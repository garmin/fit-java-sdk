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



public class AntChannelIdMesg extends Mesg   {

    
    public static final int ChannelNumberFieldNum = 0;
    
    public static final int DeviceTypeFieldNum = 1;
    
    public static final int DeviceNumberFieldNum = 2;
    
    public static final int TransmissionTypeFieldNum = 3;
    
    public static final int DeviceIndexFieldNum = 4;
    

    protected static final  Mesg antChannelIdMesg;
    static {
        // ant_channel_id
        antChannelIdMesg = new Mesg("ant_channel_id", MesgNum.ANT_CHANNEL_ID);
        antChannelIdMesg.addField(new Field("channel_number", ChannelNumberFieldNum, 2, 1, 0, "", false, Profile.Type.UINT8));
        
        antChannelIdMesg.addField(new Field("device_type", DeviceTypeFieldNum, 10, 1, 0, "", false, Profile.Type.UINT8Z));
        
        antChannelIdMesg.addField(new Field("device_number", DeviceNumberFieldNum, 139, 1, 0, "", false, Profile.Type.UINT16Z));
        
        antChannelIdMesg.addField(new Field("transmission_type", TransmissionTypeFieldNum, 10, 1, 0, "", false, Profile.Type.UINT8Z));
        
        antChannelIdMesg.addField(new Field("device_index", DeviceIndexFieldNum, 2, 1, 0, "", false, Profile.Type.DEVICE_INDEX));
        
    }

    public AntChannelIdMesg() {
        super(Factory.createMesg(MesgNum.ANT_CHANNEL_ID));
    }

    public AntChannelIdMesg(final Mesg mesg) {
        super(mesg);
    }


    /**
     * Get channel_number field
     *
     * @return channel_number
     */
    public Short getChannelNumber() {
        return getFieldShortValue(0, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Set channel_number field
     *
     * @param channelNumber The new channelNumber value to be set
     */
    public void setChannelNumber(Short channelNumber) {
        setFieldValue(0, 0, channelNumber, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Get device_type field
     *
     * @return device_type
     */
    public Short getDeviceType() {
        return getFieldShortValue(1, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Set device_type field
     *
     * @param deviceType The new deviceType value to be set
     */
    public void setDeviceType(Short deviceType) {
        setFieldValue(1, 0, deviceType, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Get device_number field
     *
     * @return device_number
     */
    public Integer getDeviceNumber() {
        return getFieldIntegerValue(2, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Set device_number field
     *
     * @param deviceNumber The new deviceNumber value to be set
     */
    public void setDeviceNumber(Integer deviceNumber) {
        setFieldValue(2, 0, deviceNumber, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Get transmission_type field
     *
     * @return transmission_type
     */
    public Short getTransmissionType() {
        return getFieldShortValue(3, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Set transmission_type field
     *
     * @param transmissionType The new transmissionType value to be set
     */
    public void setTransmissionType(Short transmissionType) {
        setFieldValue(3, 0, transmissionType, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Get device_index field
     *
     * @return device_index
     */
    public Short getDeviceIndex() {
        return getFieldShortValue(4, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Set device_index field
     *
     * @param deviceIndex The new deviceIndex value to be set
     */
    public void setDeviceIndex(Short deviceIndex) {
        setFieldValue(4, 0, deviceIndex, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

}
