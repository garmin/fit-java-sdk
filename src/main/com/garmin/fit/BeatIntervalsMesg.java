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



public class BeatIntervalsMesg extends Mesg   {

    
    public static final int TimestampFieldNum = 253;
    
    public static final int TimestampMsFieldNum = 0;
    
    public static final int TimeFieldNum = 1;
    

    protected static final  Mesg beatIntervalsMesg;
    static {
        // beat_intervals
        beatIntervalsMesg = new Mesg("beat_intervals", MesgNum.BEAT_INTERVALS);
        beatIntervalsMesg.addField(new Field("timestamp", TimestampFieldNum, 134, 1, 0, "", false, Profile.Type.DATE_TIME));
        
        beatIntervalsMesg.addField(new Field("timestamp_ms", TimestampMsFieldNum, 132, 1, 0, "ms", false, Profile.Type.UINT16));
        
        beatIntervalsMesg.addField(new Field("time", TimeFieldNum, 132, 1, 0, "ms", false, Profile.Type.UINT16));
        
    }

    public BeatIntervalsMesg() {
        super(Factory.createMesg(MesgNum.BEAT_INTERVALS));
    }

    public BeatIntervalsMesg(final Mesg mesg) {
        super(mesg);
    }


    /**
     * Get timestamp field
     *
     * @return timestamp
     */
    public DateTime getTimestamp() {
        return timestampToDateTime(getFieldLongValue(253, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD));
    }

    /**
     * Set timestamp field
     *
     * @param timestamp The new timestamp value to be set
     */
    public void setTimestamp(DateTime timestamp) {
        setFieldValue(253, 0, timestamp.getTimestamp(), Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Get timestamp_ms field
     * Units: ms
     * Comment: Milliseconds past date_time
     *
     * @return timestamp_ms
     */
    public Integer getTimestampMs() {
        return getFieldIntegerValue(0, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Set timestamp_ms field
     * Units: ms
     * Comment: Milliseconds past date_time
     *
     * @param timestampMs The new timestampMs value to be set
     */
    public void setTimestampMs(Integer timestampMs) {
        setFieldValue(0, 0, timestampMs, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    public Integer[] getTime() {
        
        return getFieldIntegerValues(1, Fit.SUBFIELD_INDEX_MAIN_FIELD);
        
    }

    /**
     * @return number of time
     */
    public int getNumTime() {
        return getNumFieldValues(1, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Get time field
     * Units: ms
     * Comment: Array of millisecond times between beats
     *
     * @param index of time
     * @return time
     */
    public Integer getTime(int index) {
        return getFieldIntegerValue(1, index, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Set time field
     * Units: ms
     * Comment: Array of millisecond times between beats
     *
     * @param index of time
     * @param time The new time value to be set
     */
    public void setTime(int index, Integer time) {
        setFieldValue(1, index, time, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

}
