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



public class ActivityMesg extends Mesg implements MesgWithEvent   {

    
    public static final int TimestampFieldNum = 253;
    
    public static final int TotalTimerTimeFieldNum = 0;
    
    public static final int NumSessionsFieldNum = 1;
    
    public static final int TypeFieldNum = 2;
    
    public static final int EventFieldNum = 3;
    
    public static final int EventTypeFieldNum = 4;
    
    public static final int LocalTimestampFieldNum = 5;
    
    public static final int EventGroupFieldNum = 6;
    

    protected static final  Mesg activityMesg;
    static {
        // activity
        activityMesg = new Mesg("activity", MesgNum.ACTIVITY);
        activityMesg.addField(new Field("timestamp", TimestampFieldNum, 134, 1, 0, "", false, Profile.Type.DATE_TIME));
        
        activityMesg.addField(new Field("total_timer_time", TotalTimerTimeFieldNum, 134, 1000, 0, "s", false, Profile.Type.UINT32));
        
        activityMesg.addField(new Field("num_sessions", NumSessionsFieldNum, 132, 1, 0, "", false, Profile.Type.UINT16));
        
        activityMesg.addField(new Field("type", TypeFieldNum, 0, 1, 0, "", false, Profile.Type.ACTIVITY));
        
        activityMesg.addField(new Field("event", EventFieldNum, 0, 1, 0, "", false, Profile.Type.EVENT));
        
        activityMesg.addField(new Field("event_type", EventTypeFieldNum, 0, 1, 0, "", false, Profile.Type.EVENT_TYPE));
        
        activityMesg.addField(new Field("local_timestamp", LocalTimestampFieldNum, 134, 1, 0, "", false, Profile.Type.LOCAL_DATE_TIME));
        
        activityMesg.addField(new Field("event_group", EventGroupFieldNum, 2, 1, 0, "", false, Profile.Type.UINT8));
        
    }

    public ActivityMesg() {
        super(Factory.createMesg(MesgNum.ACTIVITY));
    }

    public ActivityMesg(final Mesg mesg) {
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
     * Get total_timer_time field
     * Units: s
     * Comment: Exclude pauses
     *
     * @return total_timer_time
     */
    public Float getTotalTimerTime() {
        return getFieldFloatValue(0, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Set total_timer_time field
     * Units: s
     * Comment: Exclude pauses
     *
     * @param totalTimerTime The new totalTimerTime value to be set
     */
    public void setTotalTimerTime(Float totalTimerTime) {
        setFieldValue(0, 0, totalTimerTime, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Get num_sessions field
     *
     * @return num_sessions
     */
    public Integer getNumSessions() {
        return getFieldIntegerValue(1, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Set num_sessions field
     *
     * @param numSessions The new numSessions value to be set
     */
    public void setNumSessions(Integer numSessions) {
        setFieldValue(1, 0, numSessions, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Get type field
     *
     * @return type
     */
    public Activity getType() {
        Short value = getFieldShortValue(2, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
        if (value == null) {
            return null;
        }
        return Activity.getByValue(value);
    }

    /**
     * Set type field
     *
     * @param type The new type value to be set
     */
    public void setType(Activity type) {
        setFieldValue(2, 0, type.value, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Get event field
     *
     * @return event
     */
    public Event getEvent() {
        Short value = getFieldShortValue(3, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
        if (value == null) {
            return null;
        }
        return Event.getByValue(value);
    }

    /**
     * Set event field
     *
     * @param event The new event value to be set
     */
    public void setEvent(Event event) {
        setFieldValue(3, 0, event.value, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Get event_type field
     *
     * @return event_type
     */
    public EventType getEventType() {
        Short value = getFieldShortValue(4, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
        if (value == null) {
            return null;
        }
        return EventType.getByValue(value);
    }

    /**
     * Set event_type field
     *
     * @param eventType The new eventType value to be set
     */
    public void setEventType(EventType eventType) {
        setFieldValue(4, 0, eventType.value, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Get local_timestamp field
     * Comment: timestamp epoch expressed in local time, used to convert activity timestamps to local time
     *
     * @return local_timestamp
     */
    public Long getLocalTimestamp() {
        return getFieldLongValue(5, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Set local_timestamp field
     * Comment: timestamp epoch expressed in local time, used to convert activity timestamps to local time
     *
     * @param localTimestamp The new localTimestamp value to be set
     */
    public void setLocalTimestamp(Long localTimestamp) {
        setFieldValue(5, 0, localTimestamp, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Get event_group field
     *
     * @return event_group
     */
    public Short getEventGroup() {
        return getFieldShortValue(6, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Set event_group field
     *
     * @param eventGroup The new eventGroup value to be set
     */
    public void setEventGroup(Short eventGroup) {
        setFieldValue(6, 0, eventGroup, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

}
