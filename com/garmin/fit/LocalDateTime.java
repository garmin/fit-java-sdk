/////////////////////////////////////////////////////////////////////////////////////////////
// Copyright 2023 Garmin International, Inc.
// Licensed under the Flexible and Interoperable Data Transfer (FIT) Protocol License; you
// may not use this file except in compliance with the Flexible and Interoperable Data
// Transfer (FIT) Protocol License.
/////////////////////////////////////////////////////////////////////////////////////////////
// ****WARNING****  This file is auto-generated!  Do NOT edit this file.
// Profile Version = 21.126.0Release
// Tag = production/release/21.126.0-0-g0576dfe
/////////////////////////////////////////////////////////////////////////////////////////////


package com.garmin.fit;

import java.util.HashMap;
import java.util.Map;

public class LocalDateTime  {
    public static final long MIN = 0x10000000; // if date_time is < 0x10000000 then it is system time (seconds from device power on)
    public static final long INVALID = Fit.UINT32_INVALID;

    private static final Map<Long, String> stringMap;

    static {
        stringMap = new HashMap<Long, String>();
        stringMap.put(MIN, "MIN");
    }
    public static final long OFFSET = 631065600000l; // Offset between Garmin (FIT) time and Unix time in ms (Dec 31, 1989 - 00:00:00 January 1, 1970).

    private long timestamp;

    /**
     * Retrieves the String Representation of the Value
     * @param value The enum constant
     * @return The name of this enum contsant
     */
    public static String getStringFromValue( Long value ) {
        if( stringMap.containsKey( value ) ) {
            return stringMap.get( value );
        }

        return "";
    }

    /**
     * Returns the enum constant with the specified name.
     * @param value The enum string value
     * @return The enum constant or INVALID if unknown
     */
    public static Long getValueFromString( String value ) {
        for( Map.Entry<Long, String> entry : stringMap.entrySet() ) {
            if( entry.getValue().equals( value ) ) {
                return entry.getKey();
            }
        }

        return INVALID;
    }
    public LocalDateTime(long timestamp) {
        this.timestamp = timestamp;
    }

    public LocalDateTime(java.util.Date date) {
        this.timestamp = (date.getTime() - OFFSET) / 1000;
    }

    public boolean equals(DateTime dateTime) {
        return (this.getTimestamp().equals(dateTime.getTimestamp()));
    }

    public void convertSystemTimeToLocal(long offset) {
        if (timestamp < MIN) {
            timestamp += offset;
        }
    }

    public Long getTimestamp() {
        return new Long(timestamp);
    }

    public java.util.Date getDate() {
        return new java.util.Date(timestamp * 1000 + OFFSET);
    }

    public String toString() {
        return getDate().toString();
    }

}
