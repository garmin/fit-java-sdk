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


public enum WktStepTarget  {
    SPEED((short)0),
    HEART_RATE((short)1),
    OPEN((short)2),
    CADENCE((short)3),
    POWER((short)4),
    GRADE((short)5),
    RESISTANCE((short)6),
    POWER_3S((short)7),
    POWER_10S((short)8),
    POWER_30S((short)9),
    POWER_LAP((short)10),
    SWIM_STROKE((short)11),
    SPEED_LAP((short)12),
    HEART_RATE_LAP((short)13),
    INVALID((short)255);

    protected short value;

    private WktStepTarget(short value) {
        this.value = value;
    }

    public static WktStepTarget getByValue(final Short value) {
        for (final WktStepTarget type : WktStepTarget.values()) {
            if (value == type.value)
                return type;
        }

        return WktStepTarget.INVALID;
    }

    /**
     * Retrieves the String Representation of the Value
     * @param value The enum constant
     * @return The name of this enum constant
     */
    public static String getStringFromValue( WktStepTarget value ) {
        return value.name();
    }

    public short getValue() {
        return value;
    }


}
