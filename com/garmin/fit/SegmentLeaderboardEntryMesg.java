/////////////////////////////////////////////////////////////////////////////////////////////
// Copyright 2023 Garmin International, Inc.
// Licensed under the Flexible and Interoperable Data Transfer (FIT) Protocol License; you
// may not use this file except in compliance with the Flexible and Interoperable Data
// Transfer (FIT) Protocol License.
/////////////////////////////////////////////////////////////////////////////////////////////
// ****WARNING****  This file is auto-generated!  Do NOT edit this file.
// Profile Version = 21.126.0Release
// Tag = production/release/21.126.0-0-g0576dfe
/////////////////////////////////////////////////////////////////////////////////////////////


package com.garmin.fit;



public class SegmentLeaderboardEntryMesg extends Mesg   {

    
    public static final int MessageIndexFieldNum = 254;
    
    public static final int NameFieldNum = 0;
    
    public static final int TypeFieldNum = 1;
    
    public static final int GroupPrimaryKeyFieldNum = 2;
    
    public static final int ActivityIdFieldNum = 3;
    
    public static final int SegmentTimeFieldNum = 4;
    
    public static final int ActivityIdStringFieldNum = 5;
    

    protected static final  Mesg segmentLeaderboardEntryMesg;
    static {
        // segment_leaderboard_entry
        segmentLeaderboardEntryMesg = new Mesg("segment_leaderboard_entry", MesgNum.SEGMENT_LEADERBOARD_ENTRY);
        segmentLeaderboardEntryMesg.addField(new Field("message_index", MessageIndexFieldNum, 132, 1, 0, "", false, Profile.Type.MESSAGE_INDEX));
        
        segmentLeaderboardEntryMesg.addField(new Field("name", NameFieldNum, 7, 1, 0, "", false, Profile.Type.STRING));
        
        segmentLeaderboardEntryMesg.addField(new Field("type", TypeFieldNum, 0, 1, 0, "", false, Profile.Type.SEGMENT_LEADERBOARD_TYPE));
        
        segmentLeaderboardEntryMesg.addField(new Field("group_primary_key", GroupPrimaryKeyFieldNum, 134, 1, 0, "", false, Profile.Type.UINT32));
        
        segmentLeaderboardEntryMesg.addField(new Field("activity_id", ActivityIdFieldNum, 134, 1, 0, "", false, Profile.Type.UINT32));
        
        segmentLeaderboardEntryMesg.addField(new Field("segment_time", SegmentTimeFieldNum, 134, 1000, 0, "s", false, Profile.Type.UINT32));
        
        segmentLeaderboardEntryMesg.addField(new Field("activity_id_string", ActivityIdStringFieldNum, 7, 1, 0, "", false, Profile.Type.STRING));
        
    }

    public SegmentLeaderboardEntryMesg() {
        super(Factory.createMesg(MesgNum.SEGMENT_LEADERBOARD_ENTRY));
    }

    public SegmentLeaderboardEntryMesg(final Mesg mesg) {
        super(mesg);
    }


    /**
     * Get message_index field
     *
     * @return message_index
     */
    public Integer getMessageIndex() {
        return getFieldIntegerValue(254, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Set message_index field
     *
     * @param messageIndex The new messageIndex value to be set
     */
    public void setMessageIndex(Integer messageIndex) {
        setFieldValue(254, 0, messageIndex, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Get name field
     * Comment: Friendly name assigned to leader
     *
     * @return name
     */
    public String getName() {
        return getFieldStringValue(0, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Set name field
     * Comment: Friendly name assigned to leader
     *
     * @param name The new name value to be set
     */
    public void setName(String name) {
        setFieldValue(0, 0, name, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Get type field
     * Comment: Leader classification
     *
     * @return type
     */
    public SegmentLeaderboardType getType() {
        Short value = getFieldShortValue(1, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
        if (value == null) {
            return null;
        }
        return SegmentLeaderboardType.getByValue(value);
    }

    /**
     * Set type field
     * Comment: Leader classification
     *
     * @param type The new type value to be set
     */
    public void setType(SegmentLeaderboardType type) {
        setFieldValue(1, 0, type.value, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Get group_primary_key field
     * Comment: Primary user ID of this leader
     *
     * @return group_primary_key
     */
    public Long getGroupPrimaryKey() {
        return getFieldLongValue(2, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Set group_primary_key field
     * Comment: Primary user ID of this leader
     *
     * @param groupPrimaryKey The new groupPrimaryKey value to be set
     */
    public void setGroupPrimaryKey(Long groupPrimaryKey) {
        setFieldValue(2, 0, groupPrimaryKey, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Get activity_id field
     * Comment: ID of the activity associated with this leader time
     *
     * @return activity_id
     */
    public Long getActivityId() {
        return getFieldLongValue(3, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Set activity_id field
     * Comment: ID of the activity associated with this leader time
     *
     * @param activityId The new activityId value to be set
     */
    public void setActivityId(Long activityId) {
        setFieldValue(3, 0, activityId, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Get segment_time field
     * Units: s
     * Comment: Segment Time (includes pauses)
     *
     * @return segment_time
     */
    public Float getSegmentTime() {
        return getFieldFloatValue(4, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Set segment_time field
     * Units: s
     * Comment: Segment Time (includes pauses)
     *
     * @param segmentTime The new segmentTime value to be set
     */
    public void setSegmentTime(Float segmentTime) {
        setFieldValue(4, 0, segmentTime, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Get activity_id_string field
     * Comment: String version of the activity_id. 21 characters long, express in decimal
     *
     * @return activity_id_string
     */
    public String getActivityIdString() {
        return getFieldStringValue(5, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Set activity_id_string field
     * Comment: String version of the activity_id. 21 characters long, express in decimal
     *
     * @param activityIdString The new activityIdString value to be set
     */
    public void setActivityIdString(String activityIdString) {
        setFieldValue(5, 0, activityIdString, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

}
