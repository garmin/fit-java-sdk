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



public class VideoClipMesg extends Mesg   {

    
    public static final int ClipNumberFieldNum = 0;
    
    public static final int StartTimestampFieldNum = 1;
    
    public static final int StartTimestampMsFieldNum = 2;
    
    public static final int EndTimestampFieldNum = 3;
    
    public static final int EndTimestampMsFieldNum = 4;
    
    public static final int ClipStartFieldNum = 6;
    
    public static final int ClipEndFieldNum = 7;
    

    protected static final  Mesg videoClipMesg;
    static {
        // video_clip
        videoClipMesg = new Mesg("video_clip", MesgNum.VIDEO_CLIP);
        videoClipMesg.addField(new Field("clip_number", ClipNumberFieldNum, 132, 1, 0, "", false, Profile.Type.UINT16));
        
        videoClipMesg.addField(new Field("start_timestamp", StartTimestampFieldNum, 134, 1, 0, "", false, Profile.Type.DATE_TIME));
        
        videoClipMesg.addField(new Field("start_timestamp_ms", StartTimestampMsFieldNum, 132, 1, 0, "", false, Profile.Type.UINT16));
        
        videoClipMesg.addField(new Field("end_timestamp", EndTimestampFieldNum, 134, 1, 0, "", false, Profile.Type.DATE_TIME));
        
        videoClipMesg.addField(new Field("end_timestamp_ms", EndTimestampMsFieldNum, 132, 1, 0, "", false, Profile.Type.UINT16));
        
        videoClipMesg.addField(new Field("clip_start", ClipStartFieldNum, 134, 1, 0, "ms", false, Profile.Type.UINT32));
        
        videoClipMesg.addField(new Field("clip_end", ClipEndFieldNum, 134, 1, 0, "ms", false, Profile.Type.UINT32));
        
    }

    public VideoClipMesg() {
        super(Factory.createMesg(MesgNum.VIDEO_CLIP));
    }

    public VideoClipMesg(final Mesg mesg) {
        super(mesg);
    }


    /**
     * Get clip_number field
     *
     * @return clip_number
     */
    public Integer getClipNumber() {
        return getFieldIntegerValue(0, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Set clip_number field
     *
     * @param clipNumber The new clipNumber value to be set
     */
    public void setClipNumber(Integer clipNumber) {
        setFieldValue(0, 0, clipNumber, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Get start_timestamp field
     *
     * @return start_timestamp
     */
    public DateTime getStartTimestamp() {
        return timestampToDateTime(getFieldLongValue(1, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD));
    }

    /**
     * Set start_timestamp field
     *
     * @param startTimestamp The new startTimestamp value to be set
     */
    public void setStartTimestamp(DateTime startTimestamp) {
        setFieldValue(1, 0, startTimestamp.getTimestamp(), Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Get start_timestamp_ms field
     *
     * @return start_timestamp_ms
     */
    public Integer getStartTimestampMs() {
        return getFieldIntegerValue(2, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Set start_timestamp_ms field
     *
     * @param startTimestampMs The new startTimestampMs value to be set
     */
    public void setStartTimestampMs(Integer startTimestampMs) {
        setFieldValue(2, 0, startTimestampMs, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Get end_timestamp field
     *
     * @return end_timestamp
     */
    public DateTime getEndTimestamp() {
        return timestampToDateTime(getFieldLongValue(3, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD));
    }

    /**
     * Set end_timestamp field
     *
     * @param endTimestamp The new endTimestamp value to be set
     */
    public void setEndTimestamp(DateTime endTimestamp) {
        setFieldValue(3, 0, endTimestamp.getTimestamp(), Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Get end_timestamp_ms field
     *
     * @return end_timestamp_ms
     */
    public Integer getEndTimestampMs() {
        return getFieldIntegerValue(4, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Set end_timestamp_ms field
     *
     * @param endTimestampMs The new endTimestampMs value to be set
     */
    public void setEndTimestampMs(Integer endTimestampMs) {
        setFieldValue(4, 0, endTimestampMs, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Get clip_start field
     * Units: ms
     * Comment: Start of clip in video time
     *
     * @return clip_start
     */
    public Long getClipStart() {
        return getFieldLongValue(6, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Set clip_start field
     * Units: ms
     * Comment: Start of clip in video time
     *
     * @param clipStart The new clipStart value to be set
     */
    public void setClipStart(Long clipStart) {
        setFieldValue(6, 0, clipStart, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Get clip_end field
     * Units: ms
     * Comment: End of clip in video time
     *
     * @return clip_end
     */
    public Long getClipEnd() {
        return getFieldLongValue(7, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Set clip_end field
     * Units: ms
     * Comment: End of clip in video time
     *
     * @param clipEnd The new clipEnd value to be set
     */
    public void setClipEnd(Long clipEnd) {
        setFieldValue(7, 0, clipEnd, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

}
