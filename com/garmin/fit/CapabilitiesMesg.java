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



public class CapabilitiesMesg extends Mesg   {

    
    public static final int LanguagesFieldNum = 0;
    
    public static final int SportsFieldNum = 1;
    
    public static final int WorkoutsSupportedFieldNum = 21;
    
    public static final int ConnectivitySupportedFieldNum = 23;
    

    protected static final  Mesg capabilitiesMesg;
    static {
        // capabilities
        capabilitiesMesg = new Mesg("capabilities", MesgNum.CAPABILITIES);
        capabilitiesMesg.addField(new Field("languages", LanguagesFieldNum, 10, 1, 0, "", false, Profile.Type.UINT8Z));
        
        capabilitiesMesg.addField(new Field("sports", SportsFieldNum, 10, 1, 0, "", false, Profile.Type.SPORT_BITS_0));
        
        capabilitiesMesg.addField(new Field("workouts_supported", WorkoutsSupportedFieldNum, 140, 1, 0, "", false, Profile.Type.WORKOUT_CAPABILITIES));
        
        capabilitiesMesg.addField(new Field("connectivity_supported", ConnectivitySupportedFieldNum, 140, 1, 0, "", false, Profile.Type.CONNECTIVITY_CAPABILITIES));
        
    }

    public CapabilitiesMesg() {
        super(Factory.createMesg(MesgNum.CAPABILITIES));
    }

    public CapabilitiesMesg(final Mesg mesg) {
        super(mesg);
    }


    public Short[] getLanguages() {
        
        return getFieldShortValues(0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
        
    }

    /**
     * @return number of languages
     */
    public int getNumLanguages() {
        return getNumFieldValues(0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Get languages field
     * Comment: Use language_bits_x types where x is index of array.
     *
     * @param index of languages
     * @return languages
     */
    public Short getLanguages(int index) {
        return getFieldShortValue(0, index, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Set languages field
     * Comment: Use language_bits_x types where x is index of array.
     *
     * @param index of languages
     * @param languages The new languages value to be set
     */
    public void setLanguages(int index, Short languages) {
        setFieldValue(0, index, languages, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    public Short[] getSports() {
        
        return getFieldShortValues(1, Fit.SUBFIELD_INDEX_MAIN_FIELD);
        
    }

    /**
     * @return number of sports
     */
    public int getNumSports() {
        return getNumFieldValues(1, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Get sports field
     * Comment: Use sport_bits_x types where x is index of array.
     *
     * @param index of sports
     * @return sports
     */
    public Short getSports(int index) {
        return getFieldShortValue(1, index, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Set sports field
     * Comment: Use sport_bits_x types where x is index of array.
     *
     * @param index of sports
     * @param sports The new sports value to be set
     */
    public void setSports(int index, Short sports) {
        setFieldValue(1, index, sports, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Get workouts_supported field
     *
     * @return workouts_supported
     */
    public Long getWorkoutsSupported() {
        return getFieldLongValue(21, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Set workouts_supported field
     *
     * @param workoutsSupported The new workoutsSupported value to be set
     */
    public void setWorkoutsSupported(Long workoutsSupported) {
        setFieldValue(21, 0, workoutsSupported, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Get connectivity_supported field
     *
     * @return connectivity_supported
     */
    public Long getConnectivitySupported() {
        return getFieldLongValue(23, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Set connectivity_supported field
     *
     * @param connectivitySupported The new connectivitySupported value to be set
     */
    public void setConnectivitySupported(Long connectivitySupported) {
        setFieldValue(23, 0, connectivitySupported, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

}
