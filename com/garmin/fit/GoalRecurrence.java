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


public enum GoalRecurrence  {
    OFF((short)0),
    DAILY((short)1),
    WEEKLY((short)2),
    MONTHLY((short)3),
    YEARLY((short)4),
    CUSTOM((short)5),
    INVALID((short)255);

    protected short value;

    private GoalRecurrence(short value) {
        this.value = value;
    }

    public static GoalRecurrence getByValue(final Short value) {
        for (final GoalRecurrence type : GoalRecurrence.values()) {
            if (value == type.value)
                return type;
        }

        return GoalRecurrence.INVALID;
    }

    /**
     * Retrieves the String Representation of the Value
     * @param value The enum constant
     * @return The name of this enum constant
     */
    public static String getStringFromValue( GoalRecurrence value ) {
        return value.name();
    }

    public short getValue() {
        return value;
    }


}
