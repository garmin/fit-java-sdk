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



public class TimestampCorrelationMesg extends Mesg   {

    
    public static final int TimestampFieldNum = 253;
    
    public static final int FractionalTimestampFieldNum = 0;
    
    public static final int SystemTimestampFieldNum = 1;
    
    public static final int FractionalSystemTimestampFieldNum = 2;
    
    public static final int LocalTimestampFieldNum = 3;
    
    public static final int TimestampMsFieldNum = 4;
    
    public static final int SystemTimestampMsFieldNum = 5;
    

    protected static final  Mesg timestampCorrelationMesg;
    static {
        // timestamp_correlation
        timestampCorrelationMesg = new Mesg("timestamp_correlation", MesgNum.TIMESTAMP_CORRELATION);
        timestampCorrelationMesg.addField(new Field("timestamp", TimestampFieldNum, 134, 1, 0, "s", false, Profile.Type.DATE_TIME));
        
        timestampCorrelationMesg.addField(new Field("fractional_timestamp", FractionalTimestampFieldNum, 132, 32768, 0, "s", false, Profile.Type.UINT16));
        
        timestampCorrelationMesg.addField(new Field("system_timestamp", SystemTimestampFieldNum, 134, 1, 0, "s", false, Profile.Type.DATE_TIME));
        
        timestampCorrelationMesg.addField(new Field("fractional_system_timestamp", FractionalSystemTimestampFieldNum, 132, 32768, 0, "s", false, Profile.Type.UINT16));
        
        timestampCorrelationMesg.addField(new Field("local_timestamp", LocalTimestampFieldNum, 134, 1, 0, "s", false, Profile.Type.LOCAL_DATE_TIME));
        
        timestampCorrelationMesg.addField(new Field("timestamp_ms", TimestampMsFieldNum, 132, 1, 0, "ms", false, Profile.Type.UINT16));
        
        timestampCorrelationMesg.addField(new Field("system_timestamp_ms", SystemTimestampMsFieldNum, 132, 1, 0, "ms", false, Profile.Type.UINT16));
        
    }

    public TimestampCorrelationMesg() {
        super(Factory.createMesg(MesgNum.TIMESTAMP_CORRELATION));
    }

    public TimestampCorrelationMesg(final Mesg mesg) {
        super(mesg);
    }


    /**
     * Get timestamp field
     * Units: s
     * Comment: Whole second part of UTC timestamp at the time the system timestamp was recorded.
     *
     * @return timestamp
     */
    public DateTime getTimestamp() {
        return timestampToDateTime(getFieldLongValue(253, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD));
    }

    /**
     * Set timestamp field
     * Units: s
     * Comment: Whole second part of UTC timestamp at the time the system timestamp was recorded.
     *
     * @param timestamp The new timestamp value to be set
     */
    public void setTimestamp(DateTime timestamp) {
        setFieldValue(253, 0, timestamp.getTimestamp(), Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Get fractional_timestamp field
     * Units: s
     * Comment: Fractional part of the UTC timestamp at the time the system timestamp was recorded.
     *
     * @return fractional_timestamp
     */
    public Float getFractionalTimestamp() {
        return getFieldFloatValue(0, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Set fractional_timestamp field
     * Units: s
     * Comment: Fractional part of the UTC timestamp at the time the system timestamp was recorded.
     *
     * @param fractionalTimestamp The new fractionalTimestamp value to be set
     */
    public void setFractionalTimestamp(Float fractionalTimestamp) {
        setFieldValue(0, 0, fractionalTimestamp, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Get system_timestamp field
     * Units: s
     * Comment: Whole second part of the system timestamp
     *
     * @return system_timestamp
     */
    public DateTime getSystemTimestamp() {
        return timestampToDateTime(getFieldLongValue(1, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD));
    }

    /**
     * Set system_timestamp field
     * Units: s
     * Comment: Whole second part of the system timestamp
     *
     * @param systemTimestamp The new systemTimestamp value to be set
     */
    public void setSystemTimestamp(DateTime systemTimestamp) {
        setFieldValue(1, 0, systemTimestamp.getTimestamp(), Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Get fractional_system_timestamp field
     * Units: s
     * Comment: Fractional part of the system timestamp
     *
     * @return fractional_system_timestamp
     */
    public Float getFractionalSystemTimestamp() {
        return getFieldFloatValue(2, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Set fractional_system_timestamp field
     * Units: s
     * Comment: Fractional part of the system timestamp
     *
     * @param fractionalSystemTimestamp The new fractionalSystemTimestamp value to be set
     */
    public void setFractionalSystemTimestamp(Float fractionalSystemTimestamp) {
        setFieldValue(2, 0, fractionalSystemTimestamp, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Get local_timestamp field
     * Units: s
     * Comment: timestamp epoch expressed in local time used to convert timestamps to local time
     *
     * @return local_timestamp
     */
    public Long getLocalTimestamp() {
        return getFieldLongValue(3, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Set local_timestamp field
     * Units: s
     * Comment: timestamp epoch expressed in local time used to convert timestamps to local time
     *
     * @param localTimestamp The new localTimestamp value to be set
     */
    public void setLocalTimestamp(Long localTimestamp) {
        setFieldValue(3, 0, localTimestamp, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Get timestamp_ms field
     * Units: ms
     * Comment: Millisecond part of the UTC timestamp at the time the system timestamp was recorded.
     *
     * @return timestamp_ms
     */
    public Integer getTimestampMs() {
        return getFieldIntegerValue(4, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Set timestamp_ms field
     * Units: ms
     * Comment: Millisecond part of the UTC timestamp at the time the system timestamp was recorded.
     *
     * @param timestampMs The new timestampMs value to be set
     */
    public void setTimestampMs(Integer timestampMs) {
        setFieldValue(4, 0, timestampMs, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Get system_timestamp_ms field
     * Units: ms
     * Comment: Millisecond part of the system timestamp
     *
     * @return system_timestamp_ms
     */
    public Integer getSystemTimestampMs() {
        return getFieldIntegerValue(5, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Set system_timestamp_ms field
     * Units: ms
     * Comment: Millisecond part of the system timestamp
     *
     * @param systemTimestampMs The new systemTimestampMs value to be set
     */
    public void setSystemTimestampMs(Integer systemTimestampMs) {
        setFieldValue(5, 0, systemTimestampMs, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

}
