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



public class WorkoutMesg extends Mesg   {

    
    public static final int MessageIndexFieldNum = 254;
    
    public static final int SportFieldNum = 4;
    
    public static final int CapabilitiesFieldNum = 5;
    
    public static final int NumValidStepsFieldNum = 6;
    
    public static final int WktNameFieldNum = 8;
    
    public static final int SubSportFieldNum = 11;
    
    public static final int PoolLengthFieldNum = 14;
    
    public static final int PoolLengthUnitFieldNum = 15;
    

    protected static final  Mesg workoutMesg;
    static {
        // workout
        workoutMesg = new Mesg("workout", MesgNum.WORKOUT);
        workoutMesg.addField(new Field("message_index", MessageIndexFieldNum, 132, 1, 0, "", false, Profile.Type.MESSAGE_INDEX));
        
        workoutMesg.addField(new Field("sport", SportFieldNum, 0, 1, 0, "", false, Profile.Type.SPORT));
        
        workoutMesg.addField(new Field("capabilities", CapabilitiesFieldNum, 140, 1, 0, "", false, Profile.Type.WORKOUT_CAPABILITIES));
        
        workoutMesg.addField(new Field("num_valid_steps", NumValidStepsFieldNum, 132, 1, 0, "", false, Profile.Type.UINT16));
        
        workoutMesg.addField(new Field("wkt_name", WktNameFieldNum, 7, 1, 0, "", false, Profile.Type.STRING));
        
        workoutMesg.addField(new Field("sub_sport", SubSportFieldNum, 0, 1, 0, "", false, Profile.Type.SUB_SPORT));
        
        workoutMesg.addField(new Field("pool_length", PoolLengthFieldNum, 132, 100, 0, "m", false, Profile.Type.UINT16));
        
        workoutMesg.addField(new Field("pool_length_unit", PoolLengthUnitFieldNum, 0, 1, 0, "", false, Profile.Type.DISPLAY_MEASURE));
        
    }

    public WorkoutMesg() {
        super(Factory.createMesg(MesgNum.WORKOUT));
    }

    public WorkoutMesg(final Mesg mesg) {
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
     * Get sport field
     *
     * @return sport
     */
    public Sport getSport() {
        Short value = getFieldShortValue(4, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
        if (value == null) {
            return null;
        }
        return Sport.getByValue(value);
    }

    /**
     * Set sport field
     *
     * @param sport The new sport value to be set
     */
    public void setSport(Sport sport) {
        setFieldValue(4, 0, sport.value, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Get capabilities field
     *
     * @return capabilities
     */
    public Long getCapabilities() {
        return getFieldLongValue(5, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Set capabilities field
     *
     * @param capabilities The new capabilities value to be set
     */
    public void setCapabilities(Long capabilities) {
        setFieldValue(5, 0, capabilities, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Get num_valid_steps field
     * Comment: number of valid steps
     *
     * @return num_valid_steps
     */
    public Integer getNumValidSteps() {
        return getFieldIntegerValue(6, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Set num_valid_steps field
     * Comment: number of valid steps
     *
     * @param numValidSteps The new numValidSteps value to be set
     */
    public void setNumValidSteps(Integer numValidSteps) {
        setFieldValue(6, 0, numValidSteps, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Get wkt_name field
     *
     * @return wkt_name
     */
    public String getWktName() {
        return getFieldStringValue(8, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Set wkt_name field
     *
     * @param wktName The new wktName value to be set
     */
    public void setWktName(String wktName) {
        setFieldValue(8, 0, wktName, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Get sub_sport field
     *
     * @return sub_sport
     */
    public SubSport getSubSport() {
        Short value = getFieldShortValue(11, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
        if (value == null) {
            return null;
        }
        return SubSport.getByValue(value);
    }

    /**
     * Set sub_sport field
     *
     * @param subSport The new subSport value to be set
     */
    public void setSubSport(SubSport subSport) {
        setFieldValue(11, 0, subSport.value, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Get pool_length field
     * Units: m
     *
     * @return pool_length
     */
    public Float getPoolLength() {
        return getFieldFloatValue(14, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Set pool_length field
     * Units: m
     *
     * @param poolLength The new poolLength value to be set
     */
    public void setPoolLength(Float poolLength) {
        setFieldValue(14, 0, poolLength, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Get pool_length_unit field
     *
     * @return pool_length_unit
     */
    public DisplayMeasure getPoolLengthUnit() {
        Short value = getFieldShortValue(15, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
        if (value == null) {
            return null;
        }
        return DisplayMeasure.getByValue(value);
    }

    /**
     * Set pool_length_unit field
     *
     * @param poolLengthUnit The new poolLengthUnit value to be set
     */
    public void setPoolLengthUnit(DisplayMeasure poolLengthUnit) {
        setFieldValue(15, 0, poolLengthUnit.value, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

}
