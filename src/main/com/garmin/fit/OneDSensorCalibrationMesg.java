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



public class OneDSensorCalibrationMesg extends Mesg   {

    
    public static final int TimestampFieldNum = 253;
    
    public static final int SensorTypeFieldNum = 0;
    
    public static final int CalibrationFactorFieldNum = 1;
    
    public static final int CalibrationDivisorFieldNum = 2;
    
    public static final int LevelShiftFieldNum = 3;
    
    public static final int OffsetCalFieldNum = 4;
    

    protected static final  Mesg oneDSensorCalibrationMesg;
    static {
        int field_index = 0;
        int subfield_index = 0;
        // one_d_sensor_calibration
        oneDSensorCalibrationMesg = new Mesg("one_d_sensor_calibration", MesgNum.ONE_D_SENSOR_CALIBRATION);
        oneDSensorCalibrationMesg.addField(new Field("timestamp", TimestampFieldNum, 134, 1, 0, "s", false, Profile.Type.DATE_TIME));
        field_index++;
        oneDSensorCalibrationMesg.addField(new Field("sensor_type", SensorTypeFieldNum, 0, 1, 0, "", false, Profile.Type.SENSOR_TYPE));
        field_index++;
        oneDSensorCalibrationMesg.addField(new Field("calibration_factor", CalibrationFactorFieldNum, 134, 1, 0, "", false, Profile.Type.UINT32));
        subfield_index = 0;
        oneDSensorCalibrationMesg.fields.get(field_index).subFields.add(new SubField("baro_cal_factor", 134, 1, 0, "Pa"));
        oneDSensorCalibrationMesg.fields.get(field_index).subFields.get(subfield_index).addMap(0, 3);
        subfield_index++;
        field_index++;
        oneDSensorCalibrationMesg.addField(new Field("calibration_divisor", CalibrationDivisorFieldNum, 134, 1, 0, "counts", false, Profile.Type.UINT32));
        field_index++;
        oneDSensorCalibrationMesg.addField(new Field("level_shift", LevelShiftFieldNum, 134, 1, 0, "", false, Profile.Type.UINT32));
        field_index++;
        oneDSensorCalibrationMesg.addField(new Field("offset_cal", OffsetCalFieldNum, 133, 1, 0, "", false, Profile.Type.SINT32));
        field_index++;
    }

    public OneDSensorCalibrationMesg() {
        super(Factory.createMesg(MesgNum.ONE_D_SENSOR_CALIBRATION));
    }

    public OneDSensorCalibrationMesg(final Mesg mesg) {
        super(mesg);
    }


    /**
     * Get timestamp field
     * Units: s
     * Comment: Whole second part of the timestamp
     *
     * @return timestamp
     */
    public DateTime getTimestamp() {
        return timestampToDateTime(getFieldLongValue(253, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD));
    }

    /**
     * Set timestamp field
     * Units: s
     * Comment: Whole second part of the timestamp
     *
     * @param timestamp The new timestamp value to be set
     */
    public void setTimestamp(DateTime timestamp) {
        setFieldValue(253, 0, timestamp.getTimestamp(), Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Get sensor_type field
     * Comment: Indicates which sensor the calibration is for
     *
     * @return sensor_type
     */
    public SensorType getSensorType() {
        Short value = getFieldShortValue(0, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
        if (value == null) {
            return null;
        }
        return SensorType.getByValue(value);
    }

    /**
     * Set sensor_type field
     * Comment: Indicates which sensor the calibration is for
     *
     * @param sensorType The new sensorType value to be set
     */
    public void setSensorType(SensorType sensorType) {
        setFieldValue(0, 0, sensorType.value, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Get calibration_factor field
     * Comment: Calibration factor used to convert from raw ADC value to degrees, g, etc.
     *
     * @return calibration_factor
     */
    public Long getCalibrationFactor() {
        return getFieldLongValue(1, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Set calibration_factor field
     * Comment: Calibration factor used to convert from raw ADC value to degrees, g, etc.
     *
     * @param calibrationFactor The new calibrationFactor value to be set
     */
    public void setCalibrationFactor(Long calibrationFactor) {
        setFieldValue(1, 0, calibrationFactor, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Get baro_cal_factor field
     * Units: Pa
     * Comment: Barometer calibration factor
     *
     * @return baro_cal_factor
     */
    public Long getBaroCalFactor() {
        return getFieldLongValue(1, 0, Profile.SubFields.ONE_D_SENSOR_CALIBRATION_MESG_CALIBRATION_FACTOR_FIELD_BARO_CAL_FACTOR);
    }

    /**
     * Set baro_cal_factor field
     * Units: Pa
     * Comment: Barometer calibration factor
     *
     * @param baroCalFactor The new baroCalFactor value to be set
     */
    public void setBaroCalFactor(Long baroCalFactor) {
        setFieldValue(1, 0, baroCalFactor, Profile.SubFields.ONE_D_SENSOR_CALIBRATION_MESG_CALIBRATION_FACTOR_FIELD_BARO_CAL_FACTOR);
    }

    /**
     * Get calibration_divisor field
     * Units: counts
     * Comment: Calibration factor divisor
     *
     * @return calibration_divisor
     */
    public Long getCalibrationDivisor() {
        return getFieldLongValue(2, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Set calibration_divisor field
     * Units: counts
     * Comment: Calibration factor divisor
     *
     * @param calibrationDivisor The new calibrationDivisor value to be set
     */
    public void setCalibrationDivisor(Long calibrationDivisor) {
        setFieldValue(2, 0, calibrationDivisor, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Get level_shift field
     * Comment: Level shift value used to shift the ADC value back into range
     *
     * @return level_shift
     */
    public Long getLevelShift() {
        return getFieldLongValue(3, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Set level_shift field
     * Comment: Level shift value used to shift the ADC value back into range
     *
     * @param levelShift The new levelShift value to be set
     */
    public void setLevelShift(Long levelShift) {
        setFieldValue(3, 0, levelShift, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Get offset_cal field
     * Comment: Internal Calibration factor
     *
     * @return offset_cal
     */
    public Integer getOffsetCal() {
        return getFieldIntegerValue(4, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Set offset_cal field
     * Comment: Internal Calibration factor
     *
     * @param offsetCal The new offsetCal value to be set
     */
    public void setOffsetCal(Integer offsetCal) {
        setFieldValue(4, 0, offsetCal, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

}
