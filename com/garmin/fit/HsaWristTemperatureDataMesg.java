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



public class HsaWristTemperatureDataMesg extends Mesg   {

    
    public static final int TimestampFieldNum = 253;
    
    public static final int ProcessingIntervalFieldNum = 0;
    
    public static final int ValueFieldNum = 1;
    

    protected static final  Mesg hsaWristTemperatureDataMesg;
    static {
        // hsa_wrist_temperature_data
        hsaWristTemperatureDataMesg = new Mesg("hsa_wrist_temperature_data", MesgNum.HSA_WRIST_TEMPERATURE_DATA);
        hsaWristTemperatureDataMesg.addField(new Field("timestamp", TimestampFieldNum, 134, 1, 0, "s", false, Profile.Type.DATE_TIME));
        
        hsaWristTemperatureDataMesg.addField(new Field("processing_interval", ProcessingIntervalFieldNum, 132, 1, 0, "s", false, Profile.Type.UINT16));
        
        hsaWristTemperatureDataMesg.addField(new Field("value", ValueFieldNum, 132, 1000, 0, "degC", false, Profile.Type.UINT16));
        
    }

    public HsaWristTemperatureDataMesg() {
        super(Factory.createMesg(MesgNum.HSA_WRIST_TEMPERATURE_DATA));
    }

    public HsaWristTemperatureDataMesg(final Mesg mesg) {
        super(mesg);
    }


    /**
     * Get timestamp field
     * Units: s
     *
     * @return timestamp
     */
    public DateTime getTimestamp() {
        return timestampToDateTime(getFieldLongValue(253, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD));
    }

    /**
     * Set timestamp field
     * Units: s
     *
     * @param timestamp The new timestamp value to be set
     */
    public void setTimestamp(DateTime timestamp) {
        setFieldValue(253, 0, timestamp.getTimestamp(), Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Get processing_interval field
     * Units: s
     * Comment: Processing interval length in seconds
     *
     * @return processing_interval
     */
    public Integer getProcessingInterval() {
        return getFieldIntegerValue(0, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Set processing_interval field
     * Units: s
     * Comment: Processing interval length in seconds
     *
     * @param processingInterval The new processingInterval value to be set
     */
    public void setProcessingInterval(Integer processingInterval) {
        setFieldValue(0, 0, processingInterval, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    public Float[] getValue() {
        
        return getFieldFloatValues(1, Fit.SUBFIELD_INDEX_MAIN_FIELD);
        
    }

    /**
     * @return number of value
     */
    public int getNumValue() {
        return getNumFieldValues(1, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Get value field
     * Units: degC
     * Comment: Wrist temperature reading
     *
     * @param index of value
     * @return value
     */
    public Float getValue(int index) {
        return getFieldFloatValue(1, index, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Set value field
     * Units: degC
     * Comment: Wrist temperature reading
     *
     * @param index of value
     * @param value The new value value to be set
     */
    public void setValue(int index, Float value) {
        setFieldValue(1, index, value, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

}
