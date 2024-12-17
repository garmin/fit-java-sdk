/////////////////////////////////////////////////////////////////////////////////////////////
// Copyright 2024 Garmin International, Inc.
// Licensed under the Flexible and Interoperable Data Transfer (FIT) Protocol License; you
// may not use this file except in compliance with the Flexible and Interoperable Data
// Transfer (FIT) Protocol License.
/////////////////////////////////////////////////////////////////////////////////////////////
// ****WARNING****  This file is auto-generated!  Do NOT edit this file.
// Profile Version = 21.158.0Release
// Tag = production/release/21.158.0-0-gc9428aa
/////////////////////////////////////////////////////////////////////////////////////////////


package com.garmin.fit;

import java.io.ByteArrayInputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.HashMap;

public class Decoder extends DecoderBase {

    private HashMap<Short, DeveloperDataIdMesg> developerDataIds = new HashMap<Short, DeveloperDataIdMesg>();
    private HashMap<Short, HashMap<Short, FieldDescriptionMesg>> developerFields = new HashMap<Short, HashMap<Short, FieldDescriptionMesg>>();

    public Decoder(final byte[] bytes) {
        super(bytes);
    }

    /**
     * Reads a .FIT file and passes messages to the listeners
     *
     * @throws Exception if an error occurs while reading
     */
    public void read() throws Exception {

        while (stream.available() > 0) {
            resetCrc();
            decodeNextFile(stream);
        }
    }

    private void decodeNextFile(final ByteArrayDataInputStream stream) throws Exception {
         if (!isFIT(stream)) {
             throw new FitRuntimeException("The file is not a valid FIT file.");
         }

        int position = stream.getPosition();

        // Read the file header
        byte[] fileHeader = readHeader();

        int headerSize = fileHeader[0];
        int dataSize = ByteBuffer.wrap(fileHeader, 4, 4).order(ByteOrder.LITTLE_ENDIAN).getInt();

        // Read data messages and definitions
        while (stream.getPosition() < (position + headerSize + dataSize)) {
          decodeRecord();
        }

        // Read and check the CRC
        int fileCrc = stream.readUShort();

        if (fileCrc != getCrcValue()) {
            throw new FitRuntimeException("FIT decode error: File CRC failed.");
        }
    }

    private void decodeRecord() throws Exception {
        int recordHeader = stream.peek();

        if ((recordHeader & CompressedHeaderMask) == CompressedHeaderMask) {
            decodeCompressedTimestampDataMessage();
            return;
        }

        if ((recordHeader & MesgDefinitionMask) == MesgHeaderMask) {
            decodeMessage();
            return;
        }

        if ((recordHeader & MesgDefinitionMask) == MesgDefinitionMask) {
            decodeMessageDefinition();
            return;
        }

        throw new FitRuntimeException("Invalid record header: 0x" + Integer.toHexString(recordHeader));
    }

    private void decodeMessageDefinition() {
        int recordHeader = readByte();
        int localMesgIndex = recordHeader & LocalMesgNumMask;

        localMesgDefs[localMesgIndex] = new MesgDefinition();
        localMesgDefs[localMesgIndex].localNum = localMesgIndex;

        int reservedByte = readByte();
        localMesgDefs[localMesgIndex].arch = readByte();
        localMesgDefs[localMesgIndex].num = readUShort();

        if (localMesgDefs[localMesgIndex].arch == Fit.ARCH_ENDIAN_BIG) {
            localMesgDefs[localMesgIndex].num = (localMesgDefs[localMesgIndex].num >> 8) | ((localMesgDefs[localMesgIndex].num & 0xFF) << 8);
        } else if (localMesgDefs[localMesgIndex].arch != Fit.ARCH_ENDIAN_LITTLE) {
            throw new FitRuntimeException("FIT decode error: Endian " + localMesgDefs[localMesgIndex].arch + " not supported. Error at byte: " + stream.getPosition());
        }

        int numFields = readByte();

        for (int fieldIndex = 0; fieldIndex < numFields; fieldIndex++) {
            localMesgDefs[localMesgIndex].fields.add(new FieldDefinition());
            localMesgDefs[localMesgIndex].fields.get(fieldIndex).num = (readByte() & 0xFF);
            localMesgDefs[localMesgIndex].fields.get(fieldIndex).size = (readByte() & 0xFF);
            localMesgDefs[localMesgIndex].fields.get(fieldIndex).type = (readByte() & 0xFF);
        }

        if ((recordHeader & DevDataMask) == DevDataMask) {
            int numDevFields = readByte();

            for (int fieldIndex = 0; fieldIndex < numDevFields; fieldIndex++) {

                DeveloperFieldDefinition developerFieldDefinition = new DeveloperFieldDefinition();

                developerFieldDefinition.setNum((short) (readByte() & 0xFF));
                developerFieldDefinition.setSize(readByte() & 0xFF);

                Short developerDataId = (short)(readByte() & 0xFF);
                developerFieldDefinition.setDeveloperDataIdMesg(developerDataIds.get(developerDataId));

                if(developerFields.get(developerDataId).containsKey(developerFieldDefinition.getNum())) {
                    FieldDescriptionMesg fieldDescription = developerFields.get(developerDataId).get(developerFieldDefinition.getNum());
                    developerFieldDefinition.setFieldDescription(fieldDescription);
                }

                localMesgDefs[localMesgIndex].developerFields.add(developerFieldDefinition);
            }
        }

        for (MesgDefinitionListener mesgDefListener : mesgDefListeners) {
            mesgDefListener.onMesgDefinition(localMesgDefs[localMesgIndex]);
        }
    }

    private void decodeMessage() {
        int recordHeader = readByte();
        int localMesgIndex = recordHeader & LocalMesgNumMask;
        MesgDefinition mesgDef = localMesgDefs[localMesgIndex];

        if (mesgDef == null) {
            throw new FitRuntimeException("Message Definition Not Found");
        }

        Mesg mesg = Factory.createMesg(localMesgDefs[localMesgIndex].num);
        mesg.localNum = localMesgIndex;

        mesg.setDecoderMessageIndex(decoderMesgIndex++);

        for (int fieldIndex = 0; fieldIndex < mesgDef.fields.size(); fieldIndex++) {
            FieldDefinition fieldDef = localMesgDefs[localMesgIndex].fields.get(fieldIndex);
            Field field = Factory.createField(mesg.num, fieldDef.num);

            int typeSize = Fit.baseTypeSizes[(fieldDef.type & Fit.BASE_TYPE_NUM_MASK)];
            int elements = fieldDef.size / typeSize;

            int bytesRead = readBytes(fieldData, 0, fieldDef.size);

            if (bytesRead != fieldDef.size) {
                throw new FitRuntimeException("End of file found while reading field data.");
            }

            if (((fieldDef.type & Fit.BASE_TYPE_ENDIAN_FLAG) != 0) && ((localMesgDefs[localMesgIndex].arch & Fit.ARCH_ENDIAN_MASK) != Fit.ARCH_ENDIAN_BIG)) {
                flipFieldDataByteOrder(typeSize, elements);
            }

            // For unknown fields the factory will create a field with the type set to 0, i.e. enum
            // In this situation we should use the type found in the fieldDef instead
            if (field.getName().equals("unknown")) {
                field = new Field("unknown", fieldDef.num, fieldDef.type, 1, 0, "", false, Profile.Type.fromBaseType(fieldDef.type));
            }

            int profileSize = Fit.baseTypeSizes[(field.type & Fit.BASE_TYPE_NUM_MASK)];

            if(typeSize != profileSize) {
                continue;
            }

            field.read(new ByteArrayInputStream(fieldData), bytesRead);

            // Allow messages containing the accumulated field to set the accumulated value
            if (field.getIsAccumulated()) {
                int i;
                for (i = 0; i < field.getNumValues(); i++) {
                    long value = ((Number)field.getRawValue(i)).longValue();
                    for (Field containingField : mesg.fields) {
                        for (FieldComponent component : containingField.components) {
                            if ( ( component.fieldNum == field.num ) && ( component.accumulate ) ) {
                                value = (long) ((((value / field.scale) - field.offset) + component.offset) * component.scale);
                            }
                        }
                    }
                    accumulator.set(mesg.num, field.getNum(), value);
                }
            }

            if (field.getNumValues() > 0) {
                mesg.addField(field);
            }
        }

            // Now that the entire message is decoded we may evaluate subfields and expand components
            for (int i = 0; i < mesg.fields.size(); i++) {
                // Determine the active subfield and expand if it has any components
                int activeSubfield = mesg.getActiveSubFieldIndex(mesg.fields.get(i).getNum());

                if (activeSubfield == Fit.SUBFIELD_INDEX_MAIN_FIELD) {
                    if (mesg.fields.get(i).components.size() > 0) {
                        // Expand the main field components
                        expandComponents(mesg, mesg.fields.get(i), mesg.fields.get(i).components);
                    }
                } else {
                    if (mesg.fields.get(i).subFields.get(activeSubfield).components.size() > 0) {
                        // Expand the subfield components
                        expandComponents(mesg, mesg.fields.get(i), mesg.fields.get(i).subFields.get(activeSubfield).components);
                    }
                }
            }

        for (int fieldIndex = 0; fieldIndex < mesgDef.developerFields.size(); fieldIndex++) {
            DeveloperFieldDefinition fieldDef = mesgDef.developerFields.get(fieldIndex);

            int bytesRead = readBytes(fieldData, 0, fieldDef.getSize());

            if (bytesRead != fieldDef.getSize()) {
                throw new FitRuntimeException("End of file found while reading field data.");
            }

            DeveloperField field = new DeveloperField(fieldDef);
            int typeSize;
            int elements;

            // Ignore field if type is not supported.
            if (((fieldDef.getType() & Fit.BASE_TYPE_NUM_MASK) < Fit.BASE_TYPES)) {
                typeSize = Fit.baseTypeSizes[(fieldDef.getType() & Fit.BASE_TYPE_NUM_MASK)];
                elements = fieldDef.getSize() / typeSize;

                if (((fieldDef.getType() & Fit.BASE_TYPE_ENDIAN_FLAG) != 0) &&
                        ((mesgDef.arch & Fit.ARCH_ENDIAN_MASK) != Fit.ARCH_ENDIAN_BIG)) {
                    flipFieldDataByteOrder(typeSize, elements);
                }

                field.read(new ByteArrayInputStream(fieldData), fieldDef.getSize());

                if (field.getNumValues() > 0) {
                    mesg.addDeveloperField(field);
                }
            }

        }

        // Save the Developer Data ID and Field Description messages for decoding dev data
        switch (mesg.num) {
            case MesgNum.DEVELOPER_DATA_ID: {
                DeveloperDataIdMesg devIdMesg = new DeveloperDataIdMesg(mesg);
                short index = devIdMesg.getDeveloperDataIndex();
                developerDataIds.put(index, devIdMesg);
                developerFields.put(index, new HashMap<Short, FieldDescriptionMesg>());
                break;
            }

            case MesgNum.FIELD_DESCRIPTION: {
                FieldDescriptionMesg fieldDescriptionMesg = new FieldDescriptionMesg(mesg);
                short index = fieldDescriptionMesg.getDeveloperDataIndex();
                if (developerFields.containsKey(index)) {
                    developerFields.get(index)
                            .put(fieldDescriptionMesg.getFieldDefinitionNumber(), fieldDescriptionMesg);

                    DeveloperFieldDescription description = new DeveloperFieldDescription(developerDataIds.get(index), fieldDescriptionMesg);
                    for(DeveloperFieldDescriptionListener listener : devFieldDescListeners) {
                        listener.onDescription(description);
                    }
                }
                break;
            }
        }

        for (MesgListener mesgListener : mesgListeners) {
            mesgListener.onMesg(mesg);
        }
    }

}

