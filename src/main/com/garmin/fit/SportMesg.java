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



public class SportMesg extends Mesg   {

    
    public static final int SportFieldNum = 0;
    
    public static final int SubSportFieldNum = 1;
    
    public static final int NameFieldNum = 3;
    

    protected static final  Mesg sportMesg;
    static {
        // sport
        sportMesg = new Mesg("sport", MesgNum.SPORT);
        sportMesg.addField(new Field("sport", SportFieldNum, 0, 1, 0, "", false, Profile.Type.SPORT));
        
        sportMesg.addField(new Field("sub_sport", SubSportFieldNum, 0, 1, 0, "", false, Profile.Type.SUB_SPORT));
        
        sportMesg.addField(new Field("name", NameFieldNum, 7, 1, 0, "", false, Profile.Type.STRING));
        
    }

    public SportMesg() {
        super(Factory.createMesg(MesgNum.SPORT));
    }

    public SportMesg(final Mesg mesg) {
        super(mesg);
    }


    /**
     * Get sport field
     *
     * @return sport
     */
    public Sport getSport() {
        Short value = getFieldShortValue(0, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
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
        setFieldValue(0, 0, sport.value, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Get sub_sport field
     *
     * @return sub_sport
     */
    public SubSport getSubSport() {
        Short value = getFieldShortValue(1, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
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
        setFieldValue(1, 0, subSport.value, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Get name field
     *
     * @return name
     */
    public String getName() {
        return getFieldStringValue(3, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

    /**
     * Set name field
     *
     * @param name The new name value to be set
     */
    public void setName(String name) {
        setFieldValue(3, 0, name, Fit.SUBFIELD_INDEX_MAIN_FIELD);
    }

}
