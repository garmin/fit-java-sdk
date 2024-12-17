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


public enum ExdDisplayType  {
    NUMERICAL((short)0),
    SIMPLE((short)1),
    GRAPH((short)2),
    BAR((short)3),
    CIRCLE_GRAPH((short)4),
    VIRTUAL_PARTNER((short)5),
    BALANCE((short)6),
    STRING_LIST((short)7),
    STRING((short)8),
    SIMPLE_DYNAMIC_ICON((short)9),
    GAUGE((short)10),
    INVALID((short)255);

    protected short value;

    private ExdDisplayType(short value) {
        this.value = value;
    }

    public static ExdDisplayType getByValue(final Short value) {
        for (final ExdDisplayType type : ExdDisplayType.values()) {
            if (value == type.value)
                return type;
        }

        return ExdDisplayType.INVALID;
    }

    /**
     * Retrieves the String Representation of the Value
     * @param value The enum constant
     * @return The name of this enum constant
     */
    public static String getStringFromValue( ExdDisplayType value ) {
        return value.name();
    }

    public short getValue() {
        return value;
    }


}
