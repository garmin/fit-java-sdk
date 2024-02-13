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


public enum ExdQualifiers  {
    NO_QUALIFIER((short)0),
    INSTANTANEOUS((short)1),
    AVERAGE((short)2),
    LAP((short)3),
    MAXIMUM((short)4),
    MAXIMUM_AVERAGE((short)5),
    MAXIMUM_LAP((short)6),
    LAST_LAP((short)7),
    AVERAGE_LAP((short)8),
    TO_DESTINATION((short)9),
    TO_GO((short)10),
    TO_NEXT((short)11),
    NEXT_COURSE_POINT((short)12),
    TOTAL((short)13),
    THREE_SECOND_AVERAGE((short)14),
    TEN_SECOND_AVERAGE((short)15),
    THIRTY_SECOND_AVERAGE((short)16),
    PERCENT_MAXIMUM((short)17),
    PERCENT_MAXIMUM_AVERAGE((short)18),
    LAP_PERCENT_MAXIMUM((short)19),
    ELAPSED((short)20),
    SUNRISE((short)21),
    SUNSET((short)22),
    COMPARED_TO_VIRTUAL_PARTNER((short)23),
    MAXIMUM_24H((short)24),
    MINIMUM_24H((short)25),
    MINIMUM((short)26),
    FIRST((short)27),
    SECOND((short)28),
    THIRD((short)29),
    SHIFTER((short)30),
    LAST_SPORT((short)31),
    MOVING((short)32),
    STOPPED((short)33),
    ESTIMATED_TOTAL((short)34),
    ZONE_9((short)242),
    ZONE_8((short)243),
    ZONE_7((short)244),
    ZONE_6((short)245),
    ZONE_5((short)246),
    ZONE_4((short)247),
    ZONE_3((short)248),
    ZONE_2((short)249),
    ZONE_1((short)250),
    INVALID((short)255);

    protected short value;

    private ExdQualifiers(short value) {
        this.value = value;
    }

    public static ExdQualifiers getByValue(final Short value) {
        for (final ExdQualifiers type : ExdQualifiers.values()) {
            if (value == type.value)
                return type;
        }

        return ExdQualifiers.INVALID;
    }

    /**
     * Retrieves the String Representation of the Value
     * @param value The enum constant
     * @return The name of this enum constant
     */
    public static String getStringFromValue( ExdQualifiers value ) {
        return value.name();
    }

    public short getValue() {
        return value;
    }


}
