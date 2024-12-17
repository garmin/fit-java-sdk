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


public enum WeatherSeverity  {
    UNKNOWN((short)0),
    WARNING((short)1),
    WATCH((short)2),
    ADVISORY((short)3),
    STATEMENT((short)4),
    INVALID((short)255);

    protected short value;

    private WeatherSeverity(short value) {
        this.value = value;
    }

    public static WeatherSeverity getByValue(final Short value) {
        for (final WeatherSeverity type : WeatherSeverity.values()) {
            if (value == type.value)
                return type;
        }

        return WeatherSeverity.INVALID;
    }

    /**
     * Retrieves the String Representation of the Value
     * @param value The enum constant
     * @return The name of this enum constant
     */
    public static String getStringFromValue( WeatherSeverity value ) {
        return value.name();
    }

    public short getValue() {
        return value;
    }


}
