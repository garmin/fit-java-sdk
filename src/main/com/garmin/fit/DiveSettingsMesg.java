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



public class DiveSettingsMesg extends Mesg   {

    
    public static final int TimestampFieldNum = 253;
    
    public static final int MessageIndexFieldNum = 254;
    
    public static final int NameFieldNum = 0;
    
    public static final int ModelFieldNum = 1;
    
    public static final int GfLowFieldNum = 2;
    
    public static final int GfHighFieldNum = 3;
    
    public static final int WaterTypeFieldNum = 4;
    
    public static final int WaterDensityFieldNum = 5;
    
    public static final int Po2WarnFieldNum = 6;
    
    public static final int Po2CriticalFieldNum = 7;
    
    public static final int Po2DecoFieldNum = 8;
    
    public static final int SafetyStopEnabledFieldNum = 9;
    
    public static final int BottomDepthFieldNum = 10;
    
    public static final int BottomTimeFieldNum = 11;
    
    public static final int ApneaCountdownEnabledFieldNum = 12;
    
    public static final int ApneaCountdownTimeFieldNum = 13;
    
    public static final int BacklightModeFieldNum = 14;
    
    public static final int BacklightBrightnessFieldNum = 15;
    
    public static final int BacklightTimeoutFieldNum = 16;
    
    public static final int RepeatDiveIntervalFieldNum = 17;
    
    public static final int SafetyStopTimeFieldNum = 18;
    
    public static final int HeartRateSourceTypeFieldNum = 19;
    
    public static final int HeartRateSourceFieldNum = 20;
    
    public static final int TravelGasFieldNum = 21;
    
    public static final int CcrLowSetpointSwitchModeFieldNum = 22;
    
    public static final int CcrLowSetpointFieldNum = 23;
    
    public static final int CcrLowSetpointDepthFieldNum = 24;
    
    public static final int CcrHighSetpointSwitchModeFieldNum = 25;
    
    public static final int CcrHighSetpointFieldNum = 26;
    
    public static final int CcrHighSetpointDepthFieldNum = 27;
    
    public static final int GasConsumptionDisplayFieldNum = 29;
    
    public static final int UpKeyEnabledFieldNum = 30;
    
    public static final int DiveSoundsFieldNum = 35;
    
    public static final int LastStopMultipleFieldNum = 36;
    
    public static final int NoFlyTimeModeFieldNum = 37;
    

    protected static final  Mesg diveSettingsMesg;
    static {
        int field_index = 0;
        int subfield_index = 0;
        // dive_settings
        diveSettingsMesg = new Mesg("dive_settings", MesgNum.DIVE_SETTINGS);
        diveSettingsMesg.addField(new Field("timestamp", TimestampFieldNum, 134, 1, 0, "", false, Profile.Type.DATE_TIME));
        field_index++;
        diveSettingsMesg.addField(new Field("message_index", MessageIndexFieldNum, 132, 1, 0, "", false, Profile.Type.MESSAGE_INDEX));
        field_index++;
        diveSettingsMesg.addField(new Field("name", NameFieldNum, 7, 1, 0, "", false, Profile.Type.STRING));
        field_index++;
        diveSettingsMesg.addField(new Field("model", ModelFieldNum, 0, 1, 0, "", false, Profile.Type.TISSUE_MODEL_TYPE));
        field_index++;
        diveSettingsMesg.addField(new Field("gf_low", GfLowFieldNum, 2, 1, 0, "percent", false, Profile.Type.UINT8));
        field_index++;
        diveSettingsMesg.addField(new Field("gf_high", GfHighFieldNum, 2, 1, 0, "percent", false, Profile.Type.UINT8));
        field_index++;
        diveSettingsMesg.addField(new Field("water_type", WaterTypeFieldNum, 0, 1, 0, "", false, Profile.Type.WATER_TYPE));
        field_index++;
        diveSettingsMesg.addField(new Field("water_density", WaterDensityFieldNum, 136, 1, 0, "kg/m^3", false, Profile.Type.FLOAT32));
        field_index++;
        diveSettingsMesg.addField(new Field("po2_warn", Po2WarnFieldNum, 2, 100, 0, "percent", false, Profile.Type.UINT8));
        field_index++;
        diveSettingsMesg.addField(new Field("po2_critical", Po2CriticalFieldNum, 2, 100, 0, "percent", false, Profile.Type.UINT8));
        field_index++;
        diveSettingsMesg.addField(new Field("po2_deco", Po2DecoFieldNum, 2, 100, 0, "percent", false, Profile.Type.UINT8));
        field_index++;
        diveSettingsMesg.addField(new Field("safety_stop_enabled", SafetyStopEnabledFieldNum, 0, 1, 0, "", false, Profile.Type.BOOL));
        field_index++;
        diveSettingsMesg.addField(new Field("bottom_depth", BottomDepthFieldNum, 136, 1, 0, "", false, Profile.Type.FLOAT32));
        field_index++;
        diveSettingsMesg.addField(new Field("bottom_time", BottomTimeFieldNum, 134, 1, 0, "", false, Profile.Type.UINT32));
        field_index++;
        diveSettingsMesg.addField(new Field("apnea_countdown_enabled", ApneaCountdownEnabledFieldNum, 0, 1, 0, "", false, Profile.Type.BOOL));
        field_index++;
        diveSettingsMesg.addField(new Field("apnea_countdown_time", ApneaCountdownTimeFieldNum, 134, 1, 0, "", false, Profile.Type.UINT32));
        field_index++;
        diveSettingsMesg.addField(new Field("backlight_mode", BacklightModeFieldNum, 0, 1, 0, "", false, Profile.Type.DIVE_BACKLIGHT_MODE));
        field_index++;
        diveSettingsMesg.addField(new Field("backlight_brightness", BacklightBrightnessFieldNum, 2, 1, 0, "", false, Profile.Type.UINT8));
        field_index++;
        diveSettingsMesg.addField(new Field("backlight_timeout", BacklightTimeoutFieldNum, 2, 1, 0, "", false, Profile.Type.BACKLIGHT_TIMEOUT));
        field_index++;
        diveSettingsMesg.addField(new Field("repeat_dive_interval", RepeatDiveIntervalFieldNum, 132, 1, 0, "s", false, Profile.Type.UINT16));
        field_index++;
        diveSettingsMesg.addField(new Field("safety_stop_time", SafetyStopTimeFieldNum, 132, 1, 0, "s", false, Profile.Type.UINT16));
        field_index++;
        diveSettingsMesg.addField(new Field("heart_rate_source_type", HeartRateSourceTypeFieldNum, 0, 1, 0, "", false, Profile.Type.SOURCE_TYPE));
        field_index++;
        diveSettingsMesg.addField(new Field("heart_rate_source", HeartRateSourceFieldNum, 2, 1, 0, "", false, Profile.Type.UINT8));
        subfield_index = 0;
        diveSettingsMesg.fields.get(field_index).subFields.add(new SubField("heart_rate_antplus_device_type", 2, 1, 0, ""));
        diveSettingsMesg.fields.get(field_index).subFields.get(subfield_index).addMap(19, 1);
        subfield_index++;
        diveSettingsMesg.fields.get(field_index).subFields.add(new SubField("heart_rate_local_device_type", 2, 1, 0, ""));
        diveSettingsMesg.fields.get(field_index).subFields.get(subfield_index).addMap(19, 5);
        subfield_index++;
        field_index++;
        diveSettingsMesg.addField(new Field("travel_gas", TravelGasFieldNum, 132, 1, 0, "", false, Profile.Type.MESSAGE_INDEX));
        field_index++;
        diveSettingsMesg.addField(new Field("ccr_low_setpoint_switch_mode", CcrLowSetpointSwitchModeFieldNum, 0, 1, 0, "", false, Profile.Type.CCR_SETPOINT_SWITCH_MODE));
        field_index++;
        diveSettingsMesg.addField(new Field("ccr_low_setpoint", CcrLowSetpointFieldNum, 2, 100, 0, "percent", false, Profile.Type.UINT8));
        field_index++;
        diveSettingsMesg.addField(new Field("ccr_low_setpoint_depth", CcrLowSetpointDepthFieldNum, 134, 1000, 0, "m", false, Profile.Type.UINT32));
        field_index++;
        diveSettingsMesg.addField(new Field("ccr_high_setpoint_switch_mode", CcrHighSetpointSwitchModeFieldNum, 0, 1, 0, "", false, Profile.Type.CCR_SETPOINT_SWITCH_MODE));
        field_index++;
        diveSettingsMesg.addField(new Field("ccr_high_setpoint", CcrHighSetpointFieldNum, 2, 100, 0, "percent", false, Profile.Type.UINT8));
        field_index++;
        diveSettingsMesg.addField(new Field("ccr_high_setpoint_depth", CcrHighSetpointDepthFieldNum, 134, 1000, 0, "m", false, Profile.Type.UINT32));
        field_index++;
        diveSettingsMesg.addField(new Field("gas_consumption_display", GasConsumptionDisplayFieldNum, 0, 1, 0, "", false, Profile.Type.GAS_CONSUMPTION_RATE_TYPE));
        field_index++;
        diveSettingsMesg.addField(new Field("up_key_enabled", UpKeyEnabledFieldNum, 0, 1, 0, "", false, Profile.Type.BOOL));
        field_index++;
        diveSettingsMesg.addField(new Field("dive_sounds", DiveSoundsFieldNum, 0, 1, 0, "", false, Profile.Type.TONE));
        field_index++;
        diveSettingsMesg.addField(new Field("last_stop_multiple", LastStopMultipleFieldNum, 2, 10, 0, "", false, Profile.Type.UINT8));
        field_index++;
        diveSettingsMesg.addField(new Field("no_fly_time_mode", NoFlyTimeModeFieldNum, 0, 1, 0, "", false, Profile.Type.NO_FLY_TIME_MODE));
        field_index++;
    }

    public DiveSettingsMesg() {
        super(Factory.createMesg(MesgNum.DIVE_SETTINGS));
    }

    public DiveSettingsMesg(final Mesg mesg) {
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
     *
     * @return name
     */
    public String getName() {
        return getFieldStringValue(0, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Set name field
     *
     * @param name The new name value to be set
     */
    public void setName(String name) {
        setFieldValue(0, 0, name, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Get model field
     *
     * @return model
     */
    public TissueModelType getModel() {
        Short value = getFieldShortValue(1, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
        if (value == null) {
            return null;
        }
        return TissueModelType.getByValue(value);
    }

    /**
     * Set model field
     *
     * @param model The new model value to be set
     */
    public void setModel(TissueModelType model) {
        setFieldValue(1, 0, model.value, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Get gf_low field
     * Units: percent
     *
     * @return gf_low
     */
    public Short getGfLow() {
        return getFieldShortValue(2, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Set gf_low field
     * Units: percent
     *
     * @param gfLow The new gfLow value to be set
     */
    public void setGfLow(Short gfLow) {
        setFieldValue(2, 0, gfLow, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Get gf_high field
     * Units: percent
     *
     * @return gf_high
     */
    public Short getGfHigh() {
        return getFieldShortValue(3, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Set gf_high field
     * Units: percent
     *
     * @param gfHigh The new gfHigh value to be set
     */
    public void setGfHigh(Short gfHigh) {
        setFieldValue(3, 0, gfHigh, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Get water_type field
     *
     * @return water_type
     */
    public WaterType getWaterType() {
        Short value = getFieldShortValue(4, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
        if (value == null) {
            return null;
        }
        return WaterType.getByValue(value);
    }

    /**
     * Set water_type field
     *
     * @param waterType The new waterType value to be set
     */
    public void setWaterType(WaterType waterType) {
        setFieldValue(4, 0, waterType.value, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Get water_density field
     * Units: kg/m^3
     * Comment: Fresh water is usually 1000; salt water is usually 1025
     *
     * @return water_density
     */
    public Float getWaterDensity() {
        return getFieldFloatValue(5, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Set water_density field
     * Units: kg/m^3
     * Comment: Fresh water is usually 1000; salt water is usually 1025
     *
     * @param waterDensity The new waterDensity value to be set
     */
    public void setWaterDensity(Float waterDensity) {
        setFieldValue(5, 0, waterDensity, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Get po2_warn field
     * Units: percent
     * Comment: Typically 1.40
     *
     * @return po2_warn
     */
    public Float getPo2Warn() {
        return getFieldFloatValue(6, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Set po2_warn field
     * Units: percent
     * Comment: Typically 1.40
     *
     * @param po2Warn The new po2Warn value to be set
     */
    public void setPo2Warn(Float po2Warn) {
        setFieldValue(6, 0, po2Warn, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Get po2_critical field
     * Units: percent
     * Comment: Typically 1.60
     *
     * @return po2_critical
     */
    public Float getPo2Critical() {
        return getFieldFloatValue(7, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Set po2_critical field
     * Units: percent
     * Comment: Typically 1.60
     *
     * @param po2Critical The new po2Critical value to be set
     */
    public void setPo2Critical(Float po2Critical) {
        setFieldValue(7, 0, po2Critical, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Get po2_deco field
     * Units: percent
     *
     * @return po2_deco
     */
    public Float getPo2Deco() {
        return getFieldFloatValue(8, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Set po2_deco field
     * Units: percent
     *
     * @param po2Deco The new po2Deco value to be set
     */
    public void setPo2Deco(Float po2Deco) {
        setFieldValue(8, 0, po2Deco, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Get safety_stop_enabled field
     *
     * @return safety_stop_enabled
     */
    public Bool getSafetyStopEnabled() {
        Short value = getFieldShortValue(9, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
        if (value == null) {
            return null;
        }
        return Bool.getByValue(value);
    }

    /**
     * Set safety_stop_enabled field
     *
     * @param safetyStopEnabled The new safetyStopEnabled value to be set
     */
    public void setSafetyStopEnabled(Bool safetyStopEnabled) {
        setFieldValue(9, 0, safetyStopEnabled.value, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Get bottom_depth field
     *
     * @return bottom_depth
     */
    public Float getBottomDepth() {
        return getFieldFloatValue(10, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Set bottom_depth field
     *
     * @param bottomDepth The new bottomDepth value to be set
     */
    public void setBottomDepth(Float bottomDepth) {
        setFieldValue(10, 0, bottomDepth, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Get bottom_time field
     *
     * @return bottom_time
     */
    public Long getBottomTime() {
        return getFieldLongValue(11, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Set bottom_time field
     *
     * @param bottomTime The new bottomTime value to be set
     */
    public void setBottomTime(Long bottomTime) {
        setFieldValue(11, 0, bottomTime, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Get apnea_countdown_enabled field
     *
     * @return apnea_countdown_enabled
     */
    public Bool getApneaCountdownEnabled() {
        Short value = getFieldShortValue(12, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
        if (value == null) {
            return null;
        }
        return Bool.getByValue(value);
    }

    /**
     * Set apnea_countdown_enabled field
     *
     * @param apneaCountdownEnabled The new apneaCountdownEnabled value to be set
     */
    public void setApneaCountdownEnabled(Bool apneaCountdownEnabled) {
        setFieldValue(12, 0, apneaCountdownEnabled.value, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Get apnea_countdown_time field
     *
     * @return apnea_countdown_time
     */
    public Long getApneaCountdownTime() {
        return getFieldLongValue(13, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Set apnea_countdown_time field
     *
     * @param apneaCountdownTime The new apneaCountdownTime value to be set
     */
    public void setApneaCountdownTime(Long apneaCountdownTime) {
        setFieldValue(13, 0, apneaCountdownTime, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Get backlight_mode field
     *
     * @return backlight_mode
     */
    public DiveBacklightMode getBacklightMode() {
        Short value = getFieldShortValue(14, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
        if (value == null) {
            return null;
        }
        return DiveBacklightMode.getByValue(value);
    }

    /**
     * Set backlight_mode field
     *
     * @param backlightMode The new backlightMode value to be set
     */
    public void setBacklightMode(DiveBacklightMode backlightMode) {
        setFieldValue(14, 0, backlightMode.value, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Get backlight_brightness field
     *
     * @return backlight_brightness
     */
    public Short getBacklightBrightness() {
        return getFieldShortValue(15, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Set backlight_brightness field
     *
     * @param backlightBrightness The new backlightBrightness value to be set
     */
    public void setBacklightBrightness(Short backlightBrightness) {
        setFieldValue(15, 0, backlightBrightness, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Get backlight_timeout field
     *
     * @return backlight_timeout
     */
    public Short getBacklightTimeout() {
        return getFieldShortValue(16, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Set backlight_timeout field
     *
     * @param backlightTimeout The new backlightTimeout value to be set
     */
    public void setBacklightTimeout(Short backlightTimeout) {
        setFieldValue(16, 0, backlightTimeout, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Get repeat_dive_interval field
     * Units: s
     * Comment: Time between surfacing and ending the activity
     *
     * @return repeat_dive_interval
     */
    public Integer getRepeatDiveInterval() {
        return getFieldIntegerValue(17, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Set repeat_dive_interval field
     * Units: s
     * Comment: Time between surfacing and ending the activity
     *
     * @param repeatDiveInterval The new repeatDiveInterval value to be set
     */
    public void setRepeatDiveInterval(Integer repeatDiveInterval) {
        setFieldValue(17, 0, repeatDiveInterval, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Get safety_stop_time field
     * Units: s
     * Comment: Time at safety stop (if enabled)
     *
     * @return safety_stop_time
     */
    public Integer getSafetyStopTime() {
        return getFieldIntegerValue(18, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Set safety_stop_time field
     * Units: s
     * Comment: Time at safety stop (if enabled)
     *
     * @param safetyStopTime The new safetyStopTime value to be set
     */
    public void setSafetyStopTime(Integer safetyStopTime) {
        setFieldValue(18, 0, safetyStopTime, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Get heart_rate_source_type field
     *
     * @return heart_rate_source_type
     */
    public SourceType getHeartRateSourceType() {
        Short value = getFieldShortValue(19, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
        if (value == null) {
            return null;
        }
        return SourceType.getByValue(value);
    }

    /**
     * Set heart_rate_source_type field
     *
     * @param heartRateSourceType The new heartRateSourceType value to be set
     */
    public void setHeartRateSourceType(SourceType heartRateSourceType) {
        setFieldValue(19, 0, heartRateSourceType.value, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Get heart_rate_source field
     *
     * @return heart_rate_source
     */
    public Short getHeartRateSource() {
        return getFieldShortValue(20, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Set heart_rate_source field
     *
     * @param heartRateSource The new heartRateSource value to be set
     */
    public void setHeartRateSource(Short heartRateSource) {
        setFieldValue(20, 0, heartRateSource, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Get heart_rate_antplus_device_type field
     *
     * @return heart_rate_antplus_device_type
     */
    public Short getHeartRateAntplusDeviceType() {
        return getFieldShortValue(20, 0, Profile.SubFields.DIVE_SETTINGS_MESG_HEART_RATE_SOURCE_FIELD_HEART_RATE_ANTPLUS_DEVICE_TYPE);
    }

    /**
     * Set heart_rate_antplus_device_type field
     *
     * @param heartRateAntplusDeviceType The new heartRateAntplusDeviceType value to be set
     */
    public void setHeartRateAntplusDeviceType(Short heartRateAntplusDeviceType) {
        setFieldValue(20, 0, heartRateAntplusDeviceType, Profile.SubFields.DIVE_SETTINGS_MESG_HEART_RATE_SOURCE_FIELD_HEART_RATE_ANTPLUS_DEVICE_TYPE);
    }

    /**
     * Get heart_rate_local_device_type field
     *
     * @return heart_rate_local_device_type
     */
    public Short getHeartRateLocalDeviceType() {
        return getFieldShortValue(20, 0, Profile.SubFields.DIVE_SETTINGS_MESG_HEART_RATE_SOURCE_FIELD_HEART_RATE_LOCAL_DEVICE_TYPE);
    }

    /**
     * Set heart_rate_local_device_type field
     *
     * @param heartRateLocalDeviceType The new heartRateLocalDeviceType value to be set
     */
    public void setHeartRateLocalDeviceType(Short heartRateLocalDeviceType) {
        setFieldValue(20, 0, heartRateLocalDeviceType, Profile.SubFields.DIVE_SETTINGS_MESG_HEART_RATE_SOURCE_FIELD_HEART_RATE_LOCAL_DEVICE_TYPE);
    }

    /**
     * Get travel_gas field
     * Comment: Index of travel dive_gas message
     *
     * @return travel_gas
     */
    public Integer getTravelGas() {
        return getFieldIntegerValue(21, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Set travel_gas field
     * Comment: Index of travel dive_gas message
     *
     * @param travelGas The new travelGas value to be set
     */
    public void setTravelGas(Integer travelGas) {
        setFieldValue(21, 0, travelGas, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Get ccr_low_setpoint_switch_mode field
     * Comment: If low PO2 should be switched to automatically
     *
     * @return ccr_low_setpoint_switch_mode
     */
    public CcrSetpointSwitchMode getCcrLowSetpointSwitchMode() {
        Short value = getFieldShortValue(22, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
        if (value == null) {
            return null;
        }
        return CcrSetpointSwitchMode.getByValue(value);
    }

    /**
     * Set ccr_low_setpoint_switch_mode field
     * Comment: If low PO2 should be switched to automatically
     *
     * @param ccrLowSetpointSwitchMode The new ccrLowSetpointSwitchMode value to be set
     */
    public void setCcrLowSetpointSwitchMode(CcrSetpointSwitchMode ccrLowSetpointSwitchMode) {
        setFieldValue(22, 0, ccrLowSetpointSwitchMode.value, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Get ccr_low_setpoint field
     * Units: percent
     * Comment: Target PO2 when using low setpoint
     *
     * @return ccr_low_setpoint
     */
    public Float getCcrLowSetpoint() {
        return getFieldFloatValue(23, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Set ccr_low_setpoint field
     * Units: percent
     * Comment: Target PO2 when using low setpoint
     *
     * @param ccrLowSetpoint The new ccrLowSetpoint value to be set
     */
    public void setCcrLowSetpoint(Float ccrLowSetpoint) {
        setFieldValue(23, 0, ccrLowSetpoint, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Get ccr_low_setpoint_depth field
     * Units: m
     * Comment: Depth to switch to low setpoint in automatic mode
     *
     * @return ccr_low_setpoint_depth
     */
    public Float getCcrLowSetpointDepth() {
        return getFieldFloatValue(24, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Set ccr_low_setpoint_depth field
     * Units: m
     * Comment: Depth to switch to low setpoint in automatic mode
     *
     * @param ccrLowSetpointDepth The new ccrLowSetpointDepth value to be set
     */
    public void setCcrLowSetpointDepth(Float ccrLowSetpointDepth) {
        setFieldValue(24, 0, ccrLowSetpointDepth, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Get ccr_high_setpoint_switch_mode field
     * Comment: If high PO2 should be switched to automatically
     *
     * @return ccr_high_setpoint_switch_mode
     */
    public CcrSetpointSwitchMode getCcrHighSetpointSwitchMode() {
        Short value = getFieldShortValue(25, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
        if (value == null) {
            return null;
        }
        return CcrSetpointSwitchMode.getByValue(value);
    }

    /**
     * Set ccr_high_setpoint_switch_mode field
     * Comment: If high PO2 should be switched to automatically
     *
     * @param ccrHighSetpointSwitchMode The new ccrHighSetpointSwitchMode value to be set
     */
    public void setCcrHighSetpointSwitchMode(CcrSetpointSwitchMode ccrHighSetpointSwitchMode) {
        setFieldValue(25, 0, ccrHighSetpointSwitchMode.value, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Get ccr_high_setpoint field
     * Units: percent
     * Comment: Target PO2 when using high setpoint
     *
     * @return ccr_high_setpoint
     */
    public Float getCcrHighSetpoint() {
        return getFieldFloatValue(26, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Set ccr_high_setpoint field
     * Units: percent
     * Comment: Target PO2 when using high setpoint
     *
     * @param ccrHighSetpoint The new ccrHighSetpoint value to be set
     */
    public void setCcrHighSetpoint(Float ccrHighSetpoint) {
        setFieldValue(26, 0, ccrHighSetpoint, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Get ccr_high_setpoint_depth field
     * Units: m
     * Comment: Depth to switch to high setpoint in automatic mode
     *
     * @return ccr_high_setpoint_depth
     */
    public Float getCcrHighSetpointDepth() {
        return getFieldFloatValue(27, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Set ccr_high_setpoint_depth field
     * Units: m
     * Comment: Depth to switch to high setpoint in automatic mode
     *
     * @param ccrHighSetpointDepth The new ccrHighSetpointDepth value to be set
     */
    public void setCcrHighSetpointDepth(Float ccrHighSetpointDepth) {
        setFieldValue(27, 0, ccrHighSetpointDepth, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Get gas_consumption_display field
     * Comment: Type of gas consumption rate to display. Some values are only valid if tank volume is known.
     *
     * @return gas_consumption_display
     */
    public GasConsumptionRateType getGasConsumptionDisplay() {
        Short value = getFieldShortValue(29, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
        if (value == null) {
            return null;
        }
        return GasConsumptionRateType.getByValue(value);
    }

    /**
     * Set gas_consumption_display field
     * Comment: Type of gas consumption rate to display. Some values are only valid if tank volume is known.
     *
     * @param gasConsumptionDisplay The new gasConsumptionDisplay value to be set
     */
    public void setGasConsumptionDisplay(GasConsumptionRateType gasConsumptionDisplay) {
        setFieldValue(29, 0, gasConsumptionDisplay.value, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Get up_key_enabled field
     * Comment: Indicates whether the up key is enabled during dives
     *
     * @return up_key_enabled
     */
    public Bool getUpKeyEnabled() {
        Short value = getFieldShortValue(30, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
        if (value == null) {
            return null;
        }
        return Bool.getByValue(value);
    }

    /**
     * Set up_key_enabled field
     * Comment: Indicates whether the up key is enabled during dives
     *
     * @param upKeyEnabled The new upKeyEnabled value to be set
     */
    public void setUpKeyEnabled(Bool upKeyEnabled) {
        setFieldValue(30, 0, upKeyEnabled.value, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Get dive_sounds field
     * Comment: Sounds and vibration enabled or disabled in-dive
     *
     * @return dive_sounds
     */
    public Tone getDiveSounds() {
        Short value = getFieldShortValue(35, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
        if (value == null) {
            return null;
        }
        return Tone.getByValue(value);
    }

    /**
     * Set dive_sounds field
     * Comment: Sounds and vibration enabled or disabled in-dive
     *
     * @param diveSounds The new diveSounds value to be set
     */
    public void setDiveSounds(Tone diveSounds) {
        setFieldValue(35, 0, diveSounds.value, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Get last_stop_multiple field
     * Comment: Usually 1.0/1.5/2.0 representing 3/4.5/6m or 10/15/20ft
     *
     * @return last_stop_multiple
     */
    public Float getLastStopMultiple() {
        return getFieldFloatValue(36, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Set last_stop_multiple field
     * Comment: Usually 1.0/1.5/2.0 representing 3/4.5/6m or 10/15/20ft
     *
     * @param lastStopMultiple The new lastStopMultiple value to be set
     */
    public void setLastStopMultiple(Float lastStopMultiple) {
        setFieldValue(36, 0, lastStopMultiple, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Get no_fly_time_mode field
     * Comment: Indicates which guidelines to use for no-fly surface interval.
     *
     * @return no_fly_time_mode
     */
    public NoFlyTimeMode getNoFlyTimeMode() {
        Short value = getFieldShortValue(37, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
        if (value == null) {
            return null;
        }
        return NoFlyTimeMode.getByValue(value);
    }

    /**
     * Set no_fly_time_mode field
     * Comment: Indicates which guidelines to use for no-fly surface interval.
     *
     * @param noFlyTimeMode The new noFlyTimeMode value to be set
     */
    public void setNoFlyTimeMode(NoFlyTimeMode noFlyTimeMode) {
        setFieldValue(37, 0, noFlyTimeMode.value, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

}
