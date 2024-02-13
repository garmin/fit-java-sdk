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


public enum WeatherStatus  {
    CLEAR((short)0),
    PARTLY_CLOUDY((short)1),
    MOSTLY_CLOUDY((short)2),
    RAIN((short)3),
    SNOW((short)4),
    WINDY((short)5),
    THUNDERSTORMS((short)6),
    WINTRY_MIX((short)7),
    FOG((short)8),
    HAZY((short)11),
    HAIL((short)12),
    SCATTERED_SHOWERS((short)13),
    SCATTERED_THUNDERSTORMS((short)14),
    UNKNOWN_PRECIPITATION((short)15),
    LIGHT_RAIN((short)16),
    HEAVY_RAIN((short)17),
    LIGHT_SNOW((short)18),
    HEAVY_SNOW((short)19),
    LIGHT_RAIN_SNOW((short)20),
    HEAVY_RAIN_SNOW((short)21),
    CLOUDY((short)22),
    INVALID((short)255);

    protected short value;

    private WeatherStatus(short value) {
        this.value = value;
    }

    public static WeatherStatus getByValue(final Short value) {
        for (final WeatherStatus type : WeatherStatus.values()) {
            if (value == type.value)
                return type;
        }

        return WeatherStatus.INVALID;
    }

    /**
     * Retrieves the String Representation of the Value
     * @param value The enum constant
     * @return The name of this enum constant
     */
    public static String getStringFromValue( WeatherStatus value ) {
        return value.name();
    }

    public short getValue() {
        return value;
    }


}
