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



public class SdmProfileMesg extends Mesg   {

    
    public static final int MessageIndexFieldNum = 254;
    
    public static final int EnabledFieldNum = 0;
    
    public static final int SdmAntIdFieldNum = 1;
    
    public static final int SdmCalFactorFieldNum = 2;
    
    public static final int OdometerFieldNum = 3;
    
    public static final int SpeedSourceFieldNum = 4;
    
    public static final int SdmAntIdTransTypeFieldNum = 5;
    
    public static final int OdometerRolloverFieldNum = 7;
    

    protected static final  Mesg sdmProfileMesg;
    static {
        // sdm_profile
        sdmProfileMesg = new Mesg("sdm_profile", MesgNum.SDM_PROFILE);
        sdmProfileMesg.addField(new Field("message_index", MessageIndexFieldNum, 132, 1, 0, "", false, Profile.Type.MESSAGE_INDEX));
        
        sdmProfileMesg.addField(new Field("enabled", EnabledFieldNum, 0, 1, 0, "", false, Profile.Type.BOOL));
        
        sdmProfileMesg.addField(new Field("sdm_ant_id", SdmAntIdFieldNum, 139, 1, 0, "", false, Profile.Type.UINT16Z));
        
        sdmProfileMesg.addField(new Field("sdm_cal_factor", SdmCalFactorFieldNum, 132, 10, 0, "%", false, Profile.Type.UINT16));
        
        sdmProfileMesg.addField(new Field("odometer", OdometerFieldNum, 134, 100, 0, "m", false, Profile.Type.UINT32));
        
        sdmProfileMesg.addField(new Field("speed_source", SpeedSourceFieldNum, 0, 1, 0, "", false, Profile.Type.BOOL));
        
        sdmProfileMesg.addField(new Field("sdm_ant_id_trans_type", SdmAntIdTransTypeFieldNum, 10, 1, 0, "", false, Profile.Type.UINT8Z));
        
        sdmProfileMesg.addField(new Field("odometer_rollover", OdometerRolloverFieldNum, 2, 1, 0, "", false, Profile.Type.UINT8));
        
    }

    public SdmProfileMesg() {
        super(Factory.createMesg(MesgNum.SDM_PROFILE));
    }

    public SdmProfileMesg(final Mesg mesg) {
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
     * Get enabled field
     *
     * @return enabled
     */
    public Bool getEnabled() {
        Short value = getFieldShortValue(0, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
        if (value == null) {
            return null;
        }
        return Bool.getByValue(value);
    }

    /**
     * Set enabled field
     *
     * @param enabled The new enabled value to be set
     */
    public void setEnabled(Bool enabled) {
        setFieldValue(0, 0, enabled.value, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Get sdm_ant_id field
     *
     * @return sdm_ant_id
     */
    public Integer getSdmAntId() {
        return getFieldIntegerValue(1, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Set sdm_ant_id field
     *
     * @param sdmAntId The new sdmAntId value to be set
     */
    public void setSdmAntId(Integer sdmAntId) {
        setFieldValue(1, 0, sdmAntId, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Get sdm_cal_factor field
     * Units: %
     *
     * @return sdm_cal_factor
     */
    public Float getSdmCalFactor() {
        return getFieldFloatValue(2, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Set sdm_cal_factor field
     * Units: %
     *
     * @param sdmCalFactor The new sdmCalFactor value to be set
     */
    public void setSdmCalFactor(Float sdmCalFactor) {
        setFieldValue(2, 0, sdmCalFactor, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Get odometer field
     * Units: m
     *
     * @return odometer
     */
    public Float getOdometer() {
        return getFieldFloatValue(3, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Set odometer field
     * Units: m
     *
     * @param odometer The new odometer value to be set
     */
    public void setOdometer(Float odometer) {
        setFieldValue(3, 0, odometer, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Get speed_source field
     * Comment: Use footpod for speed source instead of GPS
     *
     * @return speed_source
     */
    public Bool getSpeedSource() {
        Short value = getFieldShortValue(4, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
        if (value == null) {
            return null;
        }
        return Bool.getByValue(value);
    }

    /**
     * Set speed_source field
     * Comment: Use footpod for speed source instead of GPS
     *
     * @param speedSource The new speedSource value to be set
     */
    public void setSpeedSource(Bool speedSource) {
        setFieldValue(4, 0, speedSource.value, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Get sdm_ant_id_trans_type field
     *
     * @return sdm_ant_id_trans_type
     */
    public Short getSdmAntIdTransType() {
        return getFieldShortValue(5, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Set sdm_ant_id_trans_type field
     *
     * @param sdmAntIdTransType The new sdmAntIdTransType value to be set
     */
    public void setSdmAntIdTransType(Short sdmAntIdTransType) {
        setFieldValue(5, 0, sdmAntIdTransType, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Get odometer_rollover field
     * Comment: Rollover counter that can be used to extend the odometer
     *
     * @return odometer_rollover
     */
    public Short getOdometerRollover() {
        return getFieldShortValue(7, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Set odometer_rollover field
     * Comment: Rollover counter that can be used to extend the odometer
     *
     * @param odometerRollover The new odometerRollover value to be set
     */
    public void setOdometerRollover(Short odometerRollover) {
        setFieldValue(7, 0, odometerRollover, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

}
