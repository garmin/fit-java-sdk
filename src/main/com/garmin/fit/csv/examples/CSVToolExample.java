/////////////////////////////////////////////////////////////////////////////////////////////
// Copyright 2025 Garmin International, Inc.
// Licensed under the Flexible and Interoperable Data Transfer (FIT) Protocol License; you
// may not use this file except in compliance with the Flexible and Interoperable Data
// Transfer (FIT) Protocol License.
/////////////////////////////////////////////////////////////////////////////////////////////


package com.garmin.fit.csv.examples;

import com.garmin.fit.csv.CSVTool;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

public class CSVToolExample {
    public static void main(String[] args) throws Exception {
        ByteArrayInputStream byteArrayInputStream = getExampleInputStream();

        CSVTool csvTool = new CSVTool();
        csvTool.enableEnumsAsStrings(true);
        csvTool.enableDateTimeAsISO8601(true);
        csvTool.enableSemicirclesAsDegrees(true);

        ByteArrayOutputStream byteArrayOutputStream = csvTool.convertFitToCsv(byteArrayInputStream);

        System.out.println(byteArrayOutputStream.toString());

    }

    private static ByteArrayInputStream getExampleInputStream() {

        byte[] bytes = new byte[]{
                0x0E, 0x20, (byte) 0x8B, 0x08, 0x24, 0x00, 0x00, 0x00, 0x2E, 0x46, 0x49, 0x54, (byte) 0x8E, (byte) 0xA3, // File Header
                0x40, 0x00, 0x00, 0x00, 0x00, 0x04, 0x00, 0x01, 0x00, 0x01, 0x02, (byte) 0x84, 0x04, 0x04, (byte) 0x86, 0x08, 0x0A, 0x07, // Message Definition
                0x00, 0x04, 0x01, 0x00, 0x00, (byte) 0xCA, (byte) 0x9A, 0x3B, 0x61, 0x62, 0x63, 0x64, 0x65, 0x66, 0x67, 0x68, 0x69, 0x00, // Message
                0x5D, (byte) 0xF2 // CRC
        };

        return new ByteArrayInputStream(bytes);
    }
}