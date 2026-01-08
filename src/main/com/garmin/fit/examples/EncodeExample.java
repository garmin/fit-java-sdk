/////////////////////////////////////////////////////////////////////////////////////////////
// Copyright 2025 Garmin International, Inc.
// Licensed under the Flexible and Interoperable Data Transfer (FIT) Protocol License; you
// may not use this file except in compliance with the Flexible and Interoperable Data
// Transfer (FIT) Protocol License.
/////////////////////////////////////////////////////////////////////////////////////////////



package com.garmin.fit.examples;

import com.garmin.fit.*;

import java.util.Calendar;
import java.util.Random;

/**
 * Example demonstrating how to encode FIT files.
 * <p>
 * The example creates 3 sample FIT files.
 */
public class EncodeExample {
    public static void main(String[] args) {
        try {
            System.out.printf("FIT Encode Example Application - Protocol %d.%d Profile %d.%d %s\n",
                            Fit.PROTOCOL_VERSION_MAJOR,
                            Fit.PROTOCOL_VERSION_MINOR,
                            Fit.PROFILE_VERSION_MAJOR,
                            Fit.PROFILE_VERSION_MINOR,
                            Fit.PROFILE_TYPE);

            encodeExampleSettings();
            encodeExampleMonitoring();
            encodeExampleActivity();

        } catch (Exception e) {
            System.out.println("Exception encoding file: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static void encodeExampleActivity() {
        System.out.println("Encode Example Activity FIT File");

        FileEncoder encode;

        try {
            encode = new FileEncoder(new java.io.File("ExampleActivity.fit"), Fit.ProtocolVersion.V2_0);
        } catch (FitRuntimeException e) {
            System.err.println("Error opening file ExampleActivity.fit");
            return;
        }

        //Generate FileIdMessage
        FileIdMesg fileIdMesg = new FileIdMesg(); // Every FIT file MUST contain a 'File ID' message as the first message
        fileIdMesg.setManufacturer(Manufacturer.DEVELOPMENT);
        fileIdMesg.setType(File.ACTIVITY);
        fileIdMesg.setProduct(1);
        fileIdMesg.setSerialNumber(12345L);

        encode.write(fileIdMesg); // Encode the FileIDMesg

        byte[] appId = new byte[]{
            0x1, 0x1, 0x2, 0x3,
            0x5, 0x8, 0xD, 0x15,
            0x22, 0x37, 0x59, (byte) 0x90,
            (byte) 0xE9, 0x79, 0x62, (byte) 0xDB
        };

        DeveloperDataIdMesg developerIdMesg = new DeveloperDataIdMesg();
        for (int i = 0; i < appId.length; i++) {
            developerIdMesg.setApplicationId(i, appId[i]);
        }
        developerIdMesg.setDeveloperDataIndex((short)0);
        encode.write(developerIdMesg);

        FieldDescriptionMesg fieldDescMesg = new FieldDescriptionMesg();
        fieldDescMesg.setDeveloperDataIndex((short)0);
        fieldDescMesg.setFieldDefinitionNumber((short)0);
        fieldDescMesg.setFitBaseTypeId((short) Fit.BASE_TYPE_SINT8);
        fieldDescMesg.setFieldName(0, "doughnuts_earned");
        fieldDescMesg.setUnits(0, "doughnuts");
        encode.write(fieldDescMesg);

        FieldDescriptionMesg hrFieldDescMesg = new FieldDescriptionMesg();
        hrFieldDescMesg.setDeveloperDataIndex((short)0);
        hrFieldDescMesg.setFieldDefinitionNumber((short)1);
        hrFieldDescMesg.setFitBaseTypeId((short)Fit.BASE_TYPE_UINT8);
        hrFieldDescMesg.setFieldName(0, "hr");
        hrFieldDescMesg.setUnits(0, "bpm");
        hrFieldDescMesg.setNativeFieldNum((short) RecordMesg.HeartRateFieldNum);
        encode.write(hrFieldDescMesg);

        RecordMesg record = new RecordMesg();
        DeveloperField doughnutsEarnedField = new DeveloperField(fieldDescMesg, developerIdMesg);
        DeveloperField hrDevField = new DeveloperField(hrFieldDescMesg, developerIdMesg);
        record.addDeveloperField(doughnutsEarnedField);
        record.addDeveloperField(hrDevField);

        record.setHeartRate((short)140);
        hrDevField.setValue((short)140);
        record.setCadence((short)88);
        record.setDistance(510f);
        record.setSpeed(2800f);
        doughnutsEarnedField.setValue(1);
        encode.write(record);

        record.setHeartRate(Fit.UINT8_INVALID );
        hrDevField.setValue((short)143);
        record.setCadence((short)90);
        record.setDistance(2080f);
        record.setSpeed(2920f);
        doughnutsEarnedField.setValue(2);
        encode.write(record);

        record.setHeartRate((short)144);
        hrDevField.setValue((short)144);
        record.setCadence((short)92);
        record.setDistance(3710f);
        record.setSpeed(3050f);
        doughnutsEarnedField.setValue(3);
        encode.write(record);

        try {
            encode.close();
        } catch (FitRuntimeException e) {
            System.err.println("Error closing encode.");
            return;
        }

        System.out.println("Encoded FIT file ExampleActivity.fit.");
    }

    private static void encodeExampleSettings() {
        System.out.println("Encode Example Settings FIT File");
        FileEncoder encode;

        try {
            encode = new FileEncoder(new java.io.File("ExampleSettings.fit"), Fit.ProtocolVersion.V1_0);
        } catch (FitRuntimeException e) {
            System.err.println("Error opening file ExampleSettings.fit");
            return;
        }

        //Generate FileIdMessage
        FileIdMesg fileIdMesg = new FileIdMesg(); // Every FIT file MUST contain a 'File ID' message as the first message
        fileIdMesg.setManufacturer(Manufacturer.DEVELOPMENT);
        fileIdMesg.setType(File.SETTINGS);
        fileIdMesg.setProduct(1);
        fileIdMesg.setSerialNumber(12345L);

        encode.write(fileIdMesg); // Encode the FileIDMesg

        //Generate UserProfileMesg
        UserProfileMesg userProfileMesg = new UserProfileMesg();
        userProfileMesg.setGender(Gender.FEMALE);
        userProfileMesg.setWeight(63.1F);
        userProfileMesg.setAge((short)99);
        userProfileMesg.setFriendlyName("TestUser");

        encode.write(userProfileMesg); // Encode the UserProfileMesg

        try {
            encode.close();
        } catch (FitRuntimeException e) {
            System.err.println("Error closing encode.");
            return;
        }

        System.out.println("Encoded FIT file ExampleSettings.fit.");
    }

    private static void encodeExampleMonitoring() {
        System.out.println("Encode Example Monitoring FIT File");

        // Dates to be used to generate some sample data
        java.util.Calendar systemStartTime = Calendar.getInstance();
        java.util.Calendar systemCurrentTime = Calendar.getInstance();

        FileEncoder encode;

        try {
            encode = new FileEncoder(new java.io.File("ExampleMonitoring.fit"), Fit.ProtocolVersion.V1_0);
        } catch (FitRuntimeException e) {
            System.err.println("Error opening file ExampleMonitoring.fit");
            return;
        }

        FileIdMesg fileIdMesg = new FileIdMesg(); // Every FIT file MUST contain a 'File ID' message as the first message
        fileIdMesg.setTimeCreated(new DateTime(systemStartTime.getTime()));
        fileIdMesg.setType(File.MONITORING_B);
        fileIdMesg.setManufacturer(Manufacturer.DEVELOPMENT);
        fileIdMesg.setProduct(1);
        fileIdMesg.setSerialNumber(12345L);
        fileIdMesg.setNumber(0);

        encode.write(fileIdMesg); // Encode the FileIDMesg

        DeviceInfoMesg deviceInfoMesg = new DeviceInfoMesg();
        deviceInfoMesg.setTimestamp(new DateTime(systemCurrentTime.getTime()));
        deviceInfoMesg.setBatteryStatus(BatteryStatus.GOOD);

        encode.write(deviceInfoMesg); // Encode the DeviceInfoMesg

        MonitoringMesg monitoringMesg = new MonitoringMesg();

        // By default, each time a new message is written the Local Message Type 0 will be redefined to match the new message.
        // In this case,to avoid having a definition message each time there is a DeviceInfoMesg, we can manually set the Local Message Type of the MonitoringMessage to '1'.
        // By doing this we avoid an additional 7 definition messages in our FIT file.
        monitoringMesg.setLocalNum(1);

        monitoringMesg.setTimestamp((new DateTime(systemCurrentTime.getTime()))); // Initialise Timestamp to current time
        monitoringMesg.setCycles(0F); //Initialise Cycles to 0

        Random numberOfCycles = new Random(); // Random number of cycles for example data
        for (int i = 0; i < 4; i++) { // Each of these loops represent a quarter of a day

            for (int j = 0; j < 6; j++) { // Each of these loops represent 1 hour
                monitoringMesg.setTimestamp(new DateTime(systemCurrentTime.getTime()));
                monitoringMesg.setActivityType(ActivityType.WALKING); // Setting this to WALKING will cause Cycles to be interpreted as steps
                monitoringMesg.setCycles(monitoringMesg.getCycles() + (numberOfCycles.nextFloat() * 1000)); // Cycles are accumulated (i.e. must be increasing)

                encode.write(monitoringMesg); // Encode the MonitoringMesg

                systemCurrentTime.add(Calendar.HOUR, 1); // Add an hour to our contrived timestamp
            }

            deviceInfoMesg.setTimestamp((new DateTime(systemCurrentTime.getTime())));
            deviceInfoMesg.setBatteryStatus(BatteryStatus.GOOD);

            encode.write(deviceInfoMesg); // Encode the DeviceInfoMesg
        }

        try {
            encode.close();
        } catch (FitRuntimeException e) {
            System.err.println("Error closing encode.");
            return;
        }

        System.out.println("Encoded FIT file ExampleMonitoring.fit.");
    }
}
