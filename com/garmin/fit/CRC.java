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

public class CRC {
    private static final int[] crc16_table = { 0x0000, 0xCC01, 0xD801, 0x1400, 0xF001, 0x3C00, 0x2800, 0xE401, 0xA001, 0x6C00, 0x7800, 0xB401, 0x5000, 0x9C01, 0x8801, 0x4400 };

    public static final int get16(int crc, byte data) {
        int tmp;

        // compute checksum of lower four bits of byte
        tmp = crc16_table[crc & 0x0F];
        crc = (crc >> 4) & 0x0FFF;
        crc = crc ^ tmp ^ crc16_table[data & 0x0F];

        // now compute checksum of upper four bits of byte
        tmp = crc16_table[crc & 0x0F];
        crc = (crc >> 4) & 0x0FFF;
        crc = crc ^ tmp ^ crc16_table[(data >> 4) & 0x0F];

        return crc;
    }
}
