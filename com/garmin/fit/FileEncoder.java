/////////////////////////////////////////////////////////////////////////////////////////////
// Copyright 2024 Garmin International, Inc.
// Licensed under the Flexible and Interoperable Data Transfer (FIT) Protocol License; you
// may not use this file except in compliance with the Flexible and Interoperable Data
// Transfer (FIT) Protocol License.
/////////////////////////////////////////////////////////////////////////////////////////////
// ****WARNING****  This file is auto-generated!  Do NOT edit this file.
// Profile Version = 21.133.0Release
// Tag = production/release/21.133.0-0-g6002091
/////////////////////////////////////////////////////////////////////////////////////////////


package com.garmin.fit;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.RandomAccessFile;
import java.util.List;
import java.util.zip.CheckedOutputStream;

/**
 * Encodes message objects into a FIT binary file.
 *
 */
public class FileEncoder implements MesgListener, MesgDefinitionListener {
    private File file;
    private CheckedOutputStream out;
    private CRC16 crc16;
    private MesgDefinition lastMesgDefinition[] = new MesgDefinition[Fit.MAX_LOCAL_MESGS];
    private Fit.ProtocolVersion version;
    private ProtocolValidator validator;

    public FileEncoder() {
    }

    /**
     * Constructs a new File Encoder for specified file. Forces
     * ProtocolVersion.V1_0
     *
     * @deprecated Encoder now supports encoding files of differing protocol
     * versions, use {@link #FileEncoder(File, Fit.ProtocolVersion)} to ensure
     * the encoder is validating your files correctly
     *
     * @param file
     *           File to write
     */
    @Deprecated
    public FileEncoder(File file) {
        this(file,Fit.ProtocolVersion.V1_0);
    }

    /**
     * Constructs a new File Encoder for specified file
     *
     * @param file
     *           File to write
     * @param version
     *           Fit Protocol Version to use when writing files
     */
    public FileEncoder(File file, Fit.ProtocolVersion version) {
        this.version = version;
        validator = ProtocolValidatorFactory.getProtocolValidator(version);
        open(file);
    }

    /**
     * Opens file for writing. If the file already exists it will be overwritten.
     *
     * @param file
     *           file to write
     */
    public void open(File file) {

        file.delete();
        crc16 = new CRC16();
        this.file = file;

        writeFileHeader();
        try {
            out = new CheckedOutputStream(new FileOutputStream(this.file, true), crc16); // Open output stream to write messages.
        } catch (java.io.IOException e) {
            throw new FitRuntimeException(e);
        }
    }

    /**
     * Writes the file header.
     */
    private void writeFileHeader() {
        if (file == null) {
            throw new FitRuntimeException("File not open.");
        }

        try {
            CRC16 crc = new CRC16();
            RandomAccessFile raf = new RandomAccessFile(file, "rw");
            long dataSize = file.length() - Fit.FILE_HDR_SIZE;
            long crcValue = 0;

            if (dataSize < 0) {
                dataSize = 0;
            }

            byte[] header = {
                Fit.FILE_HDR_SIZE,
                (byte)version.getVersion(),
                (byte)(Fit.PROFILE_VERSION & 0xFF),
                (Fit.PROFILE_VERSION >> 8),
                (byte)(dataSize & 0xFF),
                (byte)((dataSize >> 8) & 0xFF),
                (byte)((dataSize >> 16) & 0xFF),
                (byte)((dataSize >> 24) & 0xFF),
                '.',
                'F',
                'I',
                'T'
            };

            raf.write(header);
            crc.update(header, 0, header.length);
            crcValue = crc.getValue();

            raf.write((byte)(crcValue & 0xFF));
            raf.write((byte)((crcValue >> 8) & 0xFF));
            raf.close();
        } catch (java.io.IOException e) {
            throw new FitRuntimeException(e);
        }
    }

    /**
     * MesgListener interface.
     */
    public void onMesg(Mesg mesg) {
        write(mesg);
    }

    /**
     * MesgDefinitionListener interface.
     */
    public void onMesgDefinition(MesgDefinition mesgDefinition) {
        write(mesgDefinition);
    }

    /**
     * Writes a message definition to the file.
     *
     * @param mesgDefinition
     *           message definition object to write
     */
    public void write(MesgDefinition mesgDefinition) {
        if (file == null) {
            throw new FitRuntimeException("File not open.");
        }

        if(!validator.validateMesgDefn(mesgDefinition)) {
            throw new FitRuntimeException("Incompatible Protocol Features");
        }

        mesgDefinition.write(out);
        lastMesgDefinition[mesgDefinition.localNum] = mesgDefinition;
    }

    /**
     * Writes a message to the file.
     * Automatically writes message definition if required.
     *
     * @param mesg
     *           message object to write
     */
    public void write(Mesg mesg) {
        if (file == null) {
            throw new FitRuntimeException("File not open.");
        }

        if(!validator.validateMesg(mesg)) {
            throw new FitRuntimeException("Incompatible Protocol Features");
        }

        if ((lastMesgDefinition[mesg.localNum] == null) || !lastMesgDefinition[mesg.localNum].supports(mesg)) {
            write(new MesgDefinition(mesg));
        }

        mesg.write(out, lastMesgDefinition[mesg.localNum]);
    }

    /**
     * Writes a list of messages to the file.
     *
     * @param mesgs
     *           list message objects to write
     */
    public void write(List<? extends Mesg> mesgs) {
        for (Mesg mesg : mesgs) {
            write(mesg);
        }
    }

    /**
     * Updates the data size in the file header, writes the CRC, and closes the file.
     */
    public void close() {
        if (file == null) {
            throw new FitRuntimeException("File not open.");
        }

        try {
            // Set the data size in the file header.
            writeFileHeader();

            // Write the CRC.
            long crc = out.getChecksum().getValue();
            out.write((int) (crc & 0xFF));
            out.write((int) ((crc >> 8) & 0xFF));

            out.close();
            file = null;
        } catch (java.io.IOException e) {
            throw new FitRuntimeException(e);
        }
    }
}
