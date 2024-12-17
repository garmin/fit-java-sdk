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


public enum HrZoneCalc  {
    CUSTOM((short)0),
    PERCENT_MAX_HR((short)1),
    PERCENT_HRR((short)2),
    PERCENT_LTHR((short)3),
    INVALID((short)255);

    protected short value;

    private HrZoneCalc(short value) {
        this.value = value;
    }

    public static HrZoneCalc getByValue(final Short value) {
        for (final HrZoneCalc type : HrZoneCalc.values()) {
            if (value == type.value)
                return type;
        }

        return HrZoneCalc.INVALID;
    }

    /**
     * Retrieves the String Representation of the Value
     * @param value The enum constant
     * @return The name of this enum constant
     */
    public static String getStringFromValue( HrZoneCalc value ) {
        return value.name();
    }

    public short getValue() {
        return value;
    }


}
