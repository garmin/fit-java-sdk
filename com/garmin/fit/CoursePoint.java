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


public enum CoursePoint  {
    GENERIC((short)0),
    SUMMIT((short)1),
    VALLEY((short)2),
    WATER((short)3),
    FOOD((short)4),
    DANGER((short)5),
    LEFT((short)6),
    RIGHT((short)7),
    STRAIGHT((short)8),
    FIRST_AID((short)9),
    FOURTH_CATEGORY((short)10),
    THIRD_CATEGORY((short)11),
    SECOND_CATEGORY((short)12),
    FIRST_CATEGORY((short)13),
    HORS_CATEGORY((short)14),
    SPRINT((short)15),
    LEFT_FORK((short)16),
    RIGHT_FORK((short)17),
    MIDDLE_FORK((short)18),
    SLIGHT_LEFT((short)19),
    SHARP_LEFT((short)20),
    SLIGHT_RIGHT((short)21),
    SHARP_RIGHT((short)22),
    U_TURN((short)23),
    SEGMENT_START((short)24),
    SEGMENT_END((short)25),
    CAMPSITE((short)27),
    AID_STATION((short)28),
    REST_AREA((short)29),
    GENERAL_DISTANCE((short)30),
    SERVICE((short)31),
    ENERGY_GEL((short)32),
    SPORTS_DRINK((short)33),
    MILE_MARKER((short)34),
    CHECKPOINT((short)35),
    SHELTER((short)36),
    MEETING_SPOT((short)37),
    OVERLOOK((short)38),
    TOILET((short)39),
    SHOWER((short)40),
    GEAR((short)41),
    SHARP_CURVE((short)42),
    STEEP_INCLINE((short)43),
    TUNNEL((short)44),
    BRIDGE((short)45),
    OBSTACLE((short)46),
    CROSSING((short)47),
    STORE((short)48),
    TRANSITION((short)49),
    NAVAID((short)50),
    TRANSPORT((short)51),
    ALERT((short)52),
    INFO((short)53),
    INVALID((short)255);

    protected short value;

    private CoursePoint(short value) {
        this.value = value;
    }

    public static CoursePoint getByValue(final Short value) {
        for (final CoursePoint type : CoursePoint.values()) {
            if (value == type.value)
                return type;
        }

        return CoursePoint.INVALID;
    }

    /**
     * Retrieves the String Representation of the Value
     * @param value The enum constant
     * @return The name of this enum constant
     */
    public static String getStringFromValue( CoursePoint value ) {
        return value.name();
    }

    public short getValue() {
        return value;
    }


}
