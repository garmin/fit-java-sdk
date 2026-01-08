/////////////////////////////////////////////////////////////////////////////////////////////
// Copyright 2025 Garmin International, Inc.
// Licensed under the Flexible and Interoperable Data Transfer (FIT) Protocol License; you
// may not use this file except in compliance with the Flexible and Interoperable Data
// Transfer (FIT) Protocol License.
/////////////////////////////////////////////////////////////////////////////////////////////


package com.garmin.fit.examples;

import com.garmin.fit.*;

import java.nio.file.Files;
import java.nio.file.Paths;

public class DecoderExample {
    public static void main(String[] args) {
        System.out.printf("FIT Decoder Example Application - Protocol %d.%d Profile %d.%d %s\n", Fit.PROTOCOL_VERSION_MAJOR, Fit.PROTOCOL_VERSION_MINOR, Fit.PROFILE_VERSION_MAJOR, Fit.PROFILE_VERSION_MINOR, Fit.PROFILE_TYPE);

        if (args.length != 1) {
            System.out.println("Usage: java -jar DecoderExample.jar <filename>");
            return;
        }

        byte[] bytes;

        try {
            bytes = Files.readAllBytes(Paths.get(args[0]));
        }
        catch (java.io.IOException e) {
            throw new RuntimeException("Error opening file " + args[0] + " [2]");
        }

        Decoder decoder = new Decoder(bytes);

        // Use a FitListener to capture all decoded messages in a FitMessages object
        FitListener fitListener = new FitListener();
        decoder.addListener((MesgListener) fitListener);
        decoder.addListener((DeveloperFieldDescriptionListener) fitListener);

        // Use a custom listener to process messages as they are being decoded, and to
        // capture message definitions and developer field descriptions
        CustomListener customListener = new CustomListener();
        decoder.addListener((MesgListener) customListener);
        decoder.addListener((MesgDefinitionListener) customListener);

        // Use a MesgBroadcaster for easy integration with existing projects
        // MesgBroadcaster mesgBroadcaster = new MesgBroadcaster();
        // mesgBroadcaster.addListener((RecordMesgListener)customListener);
        // mesgBroadcaster.addListener((MesgDefinitionListener)customListener);
        // decoder.addListener((MesgListener) mesgBroadcaster);
        // decoder.addListener((MesgDefinitionListener)mesgBroadcaster);

        try {
            decoder.read();

            FitMessages fitMessages = fitListener.getFitMessages();

            fitMessages.getFileIdMesgs().forEach(DecoderExample::printFileIdMesg);
            fitMessages.getUserProfileMesgs().forEach(DecoderExample::printUserProfileMesg);
            fitMessages.getDeviceInfoMesgs().forEach(DecoderExample::printDeviceInfoMesg);
            fitMessages.getMonitoringMesgs().forEach(DecoderExample::printMonitoringMesg);
            fitMessages.getRecordMesgs().forEach(DecoderExample::printRecordMesg);
            fitMessages.getDeveloperFieldDescriptionMesgs().forEach(DecoderExample::printDeveloperFieldDescriptionMesg);

            System.out.println("Decoded FIT file " + args[0] + ".");
            
        }
        catch (Exception e) {
            System.err.print("Exception decoding file: ");
            System.err.println(e.getMessage());
        }
    }

    public static void printFileIdMesg(FileIdMesg mesg) {
        System.out.println("File ID:");

        if (mesg.getType() != null) {
            System.out.print("   Type: ");
            System.out.println(mesg.getType().getValue());
        }

        if (mesg.getManufacturer() != null) {
            System.out.print("   Manufacturer: ");
            System.out.println(mesg.getManufacturer());
        }

        if (mesg.getProduct() != null) {
            System.out.print("   Product: ");
            System.out.println(mesg.getProduct());
        }

        if (mesg.getSerialNumber() != null) {
            System.out.print("   Serial Number: ");
            System.out.println(mesg.getSerialNumber());
        }

        if (mesg.getNumber() != null) {
            System.out.print("   Number: ");
            System.out.println(mesg.getNumber());
        }
    }

    public static void printUserProfileMesg(UserProfileMesg mesg) {
        System.out.println("User profile:");

        if (mesg.getFriendlyName() != null) {
            System.out.print("   Friendly Name: ");
            System.out.println(mesg.getFriendlyName());
        }

        if (mesg.getGender() != null) {
            if (mesg.getGender() == Gender.MALE) {
                System.out.println("   Gender: Male");
            }
            else if (mesg.getGender() == Gender.FEMALE) {
                System.out.println("   Gender: Female");
            }
        }

        if (mesg.getAge() != null) {
            System.out.print("   Age [years]: ");
            System.out.println(mesg.getAge());
        }

        if (mesg.getWeight() != null) {
            System.out.print("   Weight [kg]: ");
            System.out.println(mesg.getWeight());
        }
    }

    public static void printDeviceInfoMesg(DeviceInfoMesg mesg) {
        System.out.println("Device info:");

        if (mesg.getTimestamp() != null) {
            System.out.print("   Timestamp: ");
            System.out.println(mesg.getTimestamp());
        }

        if (mesg.getBatteryStatus() != null) {
            System.out.print("   Battery status: ");

            switch (mesg.getBatteryStatus()) {
                case BatteryStatus.CRITICAL:
                    System.out.println("Critical");
                    break;
                case BatteryStatus.GOOD:
                    System.out.println("Good");
                    break;
                case BatteryStatus.LOW:
                    System.out.println("Low");
                    break;
                case BatteryStatus.NEW:
                    System.out.println("New");
                    break;
                case BatteryStatus.OK:
                    System.out.println("OK");
                    break;
                default:
                    System.out.println("Invalid");
                    break;
            }
        }
    }

    public static void printMonitoringMesg(MonitoringMesg mesg) {
        System.out.println("Monitoring:");

        if (mesg.getTimestamp() != null) {
            System.out.print("   Timestamp: ");
            System.out.println(mesg.getTimestamp());
        }

        if (mesg.getActivityType() != null) {
            System.out.print("   Activity Type: ");
            System.out.println(mesg.getActivityType());
        }

        // Depending on the ActivityType, there may be Steps, Strokes, or Cycles present in the file
        if (mesg.getSteps() != null) {
            System.out.print("   Steps: ");
            System.out.println(mesg.getSteps());
        }
        else if (mesg.getStrokes() != null) {
            System.out.print("   Strokes: ");
            System.out.println(mesg.getStrokes());
        }
        else if (mesg.getCycles() != null) {
            System.out.print("   Cycles: ");
            System.out.println(mesg.getCycles());
        }

        printDeveloperData(mesg);
    }

    public static void printRecordMesg(RecordMesg mesg) {
        System.out.println("Record:");

        printValues(mesg, RecordMesg.HeartRateFieldNum);
        printValues(mesg, RecordMesg.CadenceFieldNum);
        printValues(mesg, RecordMesg.DistanceFieldNum);
        printValues(mesg, RecordMesg.SpeedFieldNum);
        printValues(mesg, RecordMesg.EnhancedAltitudeFieldNum);

        printDeveloperData(mesg);
    }

    private static void printDeveloperData(Mesg mesg) {
        for (DeveloperField field : mesg.getDeveloperFields()) {
            if (field.getNumValues() < 1) {
                continue;
            }

            if (field.isDefined()) {
                System.out.print("   " + field.getName());

                if (field.getUnits() != null) {
                    System.out.print(" [" + field.getUnits() + "]");
                }

                System.out.print(": ");
            }
            else {
                System.out.print("   Undefined Field: ");
            }

            System.out.print(field.getValue(0));
            for (int i = 1; i < field.getNumValues(); i++) {
                System.out.print("," + field.getValue(i));
            }

            System.out.println();
        }
    }

    private static void printValues(Mesg mesg, int fieldNum) {
        Iterable<FieldBase> fields = mesg.getOverrideField((short) fieldNum);
        Field profileField = Factory.createField(mesg.getNum(), fieldNum);
        boolean namePrinted = false;

        if (profileField == null) {
            return;
        }

        for (FieldBase field : fields) {
            if (!namePrinted) {
                System.out.println("   " + profileField.getName() + ":");
                namePrinted = true;
            }

            if (field instanceof Field) {
                System.out.println("      native: " + field.getValue());
            }
            else {
                System.out.println("      override: " + field.getValue());
            }
        }
    }

    public static void printDeveloperFieldDescriptionMesg(DeveloperFieldDescription desc) {
        System.out.println("Developer Field Description:");

        System.out.println("   App Id: " + desc.getApplicationId());
        System.out.println("   App Version: " + desc.getApplicationVersion());
        System.out.println("   Field Num: " + desc.getFieldDefinitionNumber());
    }

    private static class CustomListener implements MesgListener, RecordMesgListener, MesgDefinitionListener {

        @Override
        public void onMesg(Mesg mesg) {
            // TODO - Implement custom Mesg handling
        }

        @Override
        public void onMesg(RecordMesg mesg) {
            // TODO - Implement custom RecordMesg handling
        }

        @Override
        public void onMesgDefinition(MesgDefinition mesgDefn) {
            // TODO - Implement custom MesgDefinition handling
        }
    }
}