/////////////////////////////////////////////////////////////////////////////////////////////
// Copyright 2025 Garmin International, Inc.
// Licensed under the Flexible and Interoperable Data Transfer (FIT) Protocol License; you
// may not use this file except in compliance with the Flexible and Interoperable Data
// Transfer (FIT) Protocol License.
/////////////////////////////////////////////////////////////////////////////////////////////

package com.garmin.fit.examples;

import com.garmin.fit.ActivityMesg;
import com.garmin.fit.DateTime;
import com.garmin.fit.DeveloperDataIdMesg;
import com.garmin.fit.DeveloperField;
import com.garmin.fit.DeviceIndex;
import com.garmin.fit.DeviceInfoMesg;
import com.garmin.fit.DisplayMeasure;
import com.garmin.fit.Event;
import com.garmin.fit.EventMesg;
import com.garmin.fit.EventType;
import com.garmin.fit.FieldDescriptionMesg;
import com.garmin.fit.File;
import com.garmin.fit.FileEncoder;
import com.garmin.fit.FileIdMesg;
import com.garmin.fit.Fit;
import com.garmin.fit.FitBaseType;
import com.garmin.fit.FitRuntimeException;
import com.garmin.fit.LapMesg;
import com.garmin.fit.LengthMesg;
import com.garmin.fit.LengthType;
import com.garmin.fit.Manufacturer;
import com.garmin.fit.Mesg;
import com.garmin.fit.MesgNum;
import com.garmin.fit.RecordMesg;
import com.garmin.fit.SessionMesg;
import com.garmin.fit.Sport;
import com.garmin.fit.SubSport;
import com.garmin.fit.SwimStroke;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.TimeZone;

public class EncodeActivity {

    public static void main(String[] args) {
        try {
            CreateTimeBasedActivity();
            CreateLapSwimActivity();
        } catch (Exception e) {
            System.out.println("Exception encoding activity: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void CreateTimeBasedActivity() {
        final double twoPI = Math.PI * 2.0;
        final double semiCirclesPerMeter = 107.173;
        final String filename = "ActivityEncodeRecipe.fit";

        List<Mesg> messages = new ArrayList<Mesg>();

        // The starting timestamp for the activity
        DateTime startTime = new DateTime(new Date());

        // Timer Events are a BEST PRACTICE for FIT ACTIVITY files
        EventMesg eventMesg = new EventMesg();
        eventMesg.setTimestamp(startTime);
        eventMesg.setEvent(Event.TIMER);
        eventMesg.setEventType(EventType.START);
        messages.add(eventMesg);

        // Create the Developer Id message for the developer data fields.
        DeveloperDataIdMesg developerIdMesg = new DeveloperDataIdMesg();
        // It is a BEST PRACTICE to reuse the same Guid for all FIT files created by your platform
        byte[] appId = new byte[]{
                0x1, 0x1, 0x2, 0x3,
                0x5, 0x8, 0xD, 0x15,
                0x22, 0x37, 0x59, (byte) 0x90,
                (byte) 0xE9, 0x79, 0x62, (byte) 0xDB
        };

        for (int i = 0; i < appId.length; i++) {
            developerIdMesg.setApplicationId(i, appId[i]);
        }

        developerIdMesg.setDeveloperDataIndex((short) 0);
        messages.add(developerIdMesg);

        // Create the Developer Data Field Descriptions
        FieldDescriptionMesg doughnutsFieldDescMesg = new FieldDescriptionMesg();
        doughnutsFieldDescMesg.setDeveloperDataIndex((short) 0);
        doughnutsFieldDescMesg.setFieldDefinitionNumber((short) 0);
        doughnutsFieldDescMesg.setFitBaseTypeId(FitBaseType.FLOAT32);
        doughnutsFieldDescMesg.setUnits(0, "doughnuts");
        doughnutsFieldDescMesg.setNativeMesgNum(MesgNum.SESSION);
        messages.add(doughnutsFieldDescMesg);

        FieldDescriptionMesg hrFieldDescMesg = new FieldDescriptionMesg();
        hrFieldDescMesg.setDeveloperDataIndex((short) 0);
        hrFieldDescMesg.setFieldDefinitionNumber((short) 1);
        hrFieldDescMesg.setFitBaseTypeId(FitBaseType.UINT8);
        hrFieldDescMesg.setFieldName(0, "Heart Rate");
        hrFieldDescMesg.setUnits(0, "bpm");
        hrFieldDescMesg.setNativeFieldNum((short) RecordMesg.HeartRateFieldNum);
        hrFieldDescMesg.setNativeMesgNum(MesgNum.RECORD);
        messages.add(hrFieldDescMesg);

        // Every FIT ACTIVITY file MUST contain Record messages
        DateTime timestamp = new DateTime(startTime);

        // Create one hour (3600 seconds) of Record data
        for (int i = 0; i <= 3600; i++) {
            // Create a new Record message and set the timestamp
            RecordMesg recordMesg = new RecordMesg();
            recordMesg.setTimestamp(timestamp);

            // Fake Record Data of Various Signal Patterns
            recordMesg.setDistance((float) i);
            recordMesg.setSpeed((float) 1);
            recordMesg.setHeartRate((short) ((Math.sin(twoPI * (0.01 * i + 10)) + 1.0) * 127.0)); // Sine
            recordMesg.setCadence((short) (i % 255)); // Sawtooth
            recordMesg.setPower(((short) (i % 255) < 157 ? 150 : 250)); //Square
            recordMesg.setAltitude((float) (Math.abs((double) i % 255.0) - 127.0)); // Triangle
            recordMesg.setPositionLat(0);
            recordMesg.setPositionLong((int) Math.round(i * semiCirclesPerMeter));

            // Add a Developer Field to the Record Message
            DeveloperField hrDevField = new DeveloperField(hrFieldDescMesg, developerIdMesg);
            recordMesg.addDeveloperField(hrDevField);
            hrDevField.setValue((short) (Math.sin(twoPI * (.01 * i + 10)) + 1.0) * 127.0);

            // Write the Record message to the output stream
            messages.add(recordMesg);

            // Increment the timestamp by one second
            timestamp.add(1);
        }

        // Timer Events are a BEST PRACTICE for FIT ACTIVITY files
        EventMesg eventMesgStop = new EventMesg();
        eventMesgStop.setTimestamp(timestamp);
        eventMesgStop.setEvent(Event.TIMER);
        eventMesgStop.setEventType(EventType.STOP_ALL);
        messages.add(eventMesgStop);

        // Every FIT ACTIVITY file MUST contain at least one Lap message
        LapMesg lapMesg = new LapMesg();
        lapMesg.setMessageIndex(0);
        lapMesg.setTimestamp(timestamp);
        lapMesg.setStartTime(startTime);
        lapMesg.setTotalElapsedTime((float) (timestamp.getTimestamp() - startTime.getTimestamp()));
        lapMesg.setTotalTimerTime((float) (timestamp.getTimestamp() - startTime.getTimestamp()));
        messages.add(lapMesg);

        // Every FIT ACTIVITY file MUST contain at least one Session message
        SessionMesg sessionMesg = new SessionMesg();
        sessionMesg.setMessageIndex(0);
        sessionMesg.setTimestamp(timestamp);
        sessionMesg.setStartTime(startTime);
        sessionMesg.setTotalElapsedTime((float) (timestamp.getTimestamp() - startTime.getTimestamp()));
        sessionMesg.setTotalTimerTime((float) (timestamp.getTimestamp() - startTime.getTimestamp()));
        sessionMesg.setSport(Sport.STAND_UP_PADDLEBOARDING);
        sessionMesg.setSubSport(SubSport.GENERIC);
        sessionMesg.setFirstLapIndex(0);
        sessionMesg.setNumLaps(1);
        messages.add(sessionMesg);

        // Add a Developer Field to the Session message
        DeveloperField doughnutsEarnedDevField = new DeveloperField(doughnutsFieldDescMesg, developerIdMesg);
        doughnutsEarnedDevField.setValue(sessionMesg.getTotalElapsedTime() / 1200.0f);
        sessionMesg.addDeveloperField(doughnutsEarnedDevField);

        // Every FIT ACTIVITY file MUST contain EXACTLY one Activity message
        ActivityMesg activityMesg = new ActivityMesg();
        activityMesg.setTimestamp(timestamp);
        activityMesg.setNumSessions(1);
        TimeZone timeZone = TimeZone.getTimeZone("America/Denver");
        long timezoneOffset = (timeZone.getRawOffset() + timeZone.getDSTSavings()) / 1000;
        activityMesg.setLocalTimestamp(timestamp.getTimestamp() + timezoneOffset);
        activityMesg.setTotalTimerTime((float) (timestamp.getTimestamp() - startTime.getTimestamp()));
        messages.add(activityMesg);

        CreateActivityFile(messages, filename, startTime);
    }

    public static void CreateLapSwimActivity() {

        final String filename = "ActivityEncodeRecipeLapSwim.fit";
        List<Mesg> messages = new ArrayList<Mesg>();

        // The starting timestamp for the activity
        DateTime startTime = new DateTime(new Date());

        // Timer Events are a BEST PRACTICE for FIT ACTIVITY files
        EventMesg eventMesgStart = new EventMesg();
        eventMesgStart.setTimestamp(startTime);
        eventMesgStart.setEvent(Event.TIMER);
        eventMesgStart.setEventType(EventType.START);
        messages.add(eventMesgStart);

        // Create a Length or Lap message for each item in the sample swim data. Calculate
        // distance, duration, and stroke count for each lap and the overall session.

        // Session Accumulators
        int sessionTotalElapsedTime = 0;
        float sessionDistance = 0;
        short sessionNumLengths = 0;
        short sessionNumActiveLengths = 0;
        short sessionTotalStrokes = 0;
        int sessionNumLaps = 0;

        // Lap accumulators
        int lapTotalElapsedTime = 0;
        float lapDistance = 0;
        short lapNumActiveLengths = 0;
        short lapNumLengths = 0;
        short lapFirstLengthIndex = 0;
        short lapTotalStrokes = 0;
        DateTime lapStartTime = new DateTime(startTime);

        float poolLength = 22.86f;
        short messageIndex = 0;
        DisplayMeasure poolLengthUnit = DisplayMeasure.STATUTE;
        DateTime timestamp = new DateTime(startTime);

        List<Map<String, Object>> swimData = getSwimLengths();

        for (Map<String, Object> swimLength : swimData) {
            String type = (String) swimLength.get("type");

            if (type.equals("LAP")) {
                // Create a Lap message, set its fields, and write it to the file
                LapMesg lapMesg = new LapMesg();
                lapMesg.setMessageIndex(sessionNumLaps);
                lapMesg.setTimestamp(timestamp);
                lapMesg.setStartTime(lapStartTime);
                lapMesg.setTotalElapsedTime((float) lapTotalElapsedTime);
                lapMesg.setTotalTimerTime((float) lapTotalElapsedTime);
                lapMesg.setTotalDistance(lapDistance);
                lapMesg.setFirstLengthIndex((int) lapFirstLengthIndex);
                lapMesg.setNumActiveLengths((int) lapNumActiveLengths);
                lapMesg.setNumLengths((int) lapNumLengths);
                lapMesg.setTotalStrokes((long) lapTotalStrokes);
                lapMesg.setAvgStrokeDistance(lapDistance / lapTotalStrokes);
                lapMesg.setSport(Sport.SWIMMING);
                lapMesg.setSubSport(SubSport.LAP_SWIMMING);
                messages.add(lapMesg);

                sessionNumLaps++;

                // Reset the Lap accumulators
                lapFirstLengthIndex = messageIndex;
                lapNumActiveLengths = 0;
                lapNumLengths = 0;
                lapTotalElapsedTime = 0;
                lapDistance = 0;
                lapTotalStrokes = 0;
                lapStartTime = new DateTime(timestamp);
            } else {
                int duration = (int) swimLength.get("duration");
                LengthType lengthType = LengthType.valueOf(type);

                // Create a Length message and its fields
                LengthMesg lengthMesg = new LengthMesg();
                lengthMesg.setMessageIndex((int) (messageIndex++));
                lengthMesg.setStartTime(timestamp);
                lengthMesg.setTotalElapsedTime((float) duration);
                lengthMesg.setTotalTimerTime((float) duration);
                lengthMesg.setLengthType(lengthType);

                timestamp.add(duration);
                lengthMesg.setTimestamp(timestamp);

                // Create the Record message that pairs with the Length Message
                RecordMesg recordMesg = new RecordMesg();
                recordMesg.setTimestamp(timestamp);
                recordMesg.setDistance(sessionDistance + poolLength);

                // Is this an Active Length?
                if (lengthType.equals(LengthType.ACTIVE)) {
                    // Get the Active data from the model
                    String stroke = swimLength.containsKey("stroke") ? (String) swimLength.get("stroke") : "FREESTYLE";
                    int strokes = swimLength.containsKey("strokes") ? (int) swimLength.get("strokes") : 0;
                    SwimStroke swimStroke = SwimStroke.valueOf(stroke);

                    // Set the Active data on the Length Message
                    lengthMesg.setAvgSpeed(poolLength / ((float) duration));
                    lengthMesg.setSwimStroke(swimStroke);
                    short cadence = (short) (strokes * 60 / duration);

                    if (strokes > 0) {
                        lengthMesg.setTotalStrokes(strokes);
                        lengthMesg.setAvgSwimmingCadence(cadence);
                    }

                    // Set the Active data on the Record Message
                    recordMesg.setSpeed(poolLength / ((float) duration));

                    if (strokes > 0) {
                        recordMesg.setCadence(cadence);
                    }

                    // Increment the "Active" accumulators
                    sessionNumActiveLengths++;
                    lapNumActiveLengths++;
                    sessionDistance += poolLength;
                    lapDistance += poolLength;
                    sessionTotalStrokes += strokes;
                    lapTotalStrokes += strokes;
                }

                // Write the messages to the file
                messages.add(recordMesg);
                messages.add(lengthMesg);

                // Increment the "Total" accumulators
                sessionTotalElapsedTime += duration;
                lapTotalElapsedTime += duration;
                sessionNumLengths++;
                lapNumLengths++;
            }
        }

        // Timer Events are a BEST PRACTICE for FIT ACTIVITY files
        EventMesg eventMesgStop = new EventMesg();
        eventMesgStop.setTimestamp(timestamp);
        eventMesgStop.setEvent(Event.TIMER);
        eventMesgStop.setEventType(EventType.STOP_ALL);
        messages.add(eventMesgStop);

        // Every FIT ACTIVITY file MUST contain at least one Session message
        SessionMesg sessionMesg = new SessionMesg();
        sessionMesg.setMessageIndex(0);
        sessionMesg.setTimestamp(timestamp);
        sessionMesg.setStartTime(startTime);
        sessionMesg.setTotalElapsedTime((float) sessionTotalElapsedTime);
        sessionMesg.setTotalTimerTime((float) sessionTotalElapsedTime);
        sessionMesg.setTotalDistance(sessionDistance);
        sessionMesg.setSport(Sport.SWIMMING);
        sessionMesg.setSubSport(SubSport.LAP_SWIMMING);
        sessionMesg.setFirstLapIndex(0);
        sessionMesg.setNumLaps(sessionNumLaps);
        sessionMesg.setPoolLength(poolLength);
        sessionMesg.setPoolLengthUnit(poolLengthUnit);
        sessionMesg.setNumLengths((int) sessionNumLengths);
        sessionMesg.setNumActiveLengths((int) sessionNumActiveLengths);
        sessionMesg.setTotalStrokes((long) sessionTotalStrokes);
        sessionMesg.setAvgStrokeDistance(sessionDistance / sessionTotalStrokes);
        messages.add(sessionMesg);

        // Every FIT ACTIVITY file MUST contain EXACTLY one Activity message
        ActivityMesg activityMesg = new ActivityMesg();
        activityMesg.setTimestamp(timestamp);
        activityMesg.setNumSessions(1);
        TimeZone timeZone = TimeZone.getTimeZone("America/Denver");
        long timezoneOffset = (timeZone.getRawOffset() + timeZone.getDSTSavings()) / 1000;
        activityMesg.setLocalTimestamp(timestamp.getTimestamp() + timezoneOffset);
        activityMesg.setTotalTimerTime((float) sessionTotalElapsedTime);

        messages.add(activityMesg);

        CreateActivityFile(messages, filename, startTime);
    }

    public static void CreateActivityFile(List<Mesg> messages, String filename, DateTime startTime) {
        // The combination of file type, manufacturer id, product id, and serial number should be unique.
        // When available, a non-random serial number should be used.
        File fileType = File.ACTIVITY;
        short manufacturerId = Manufacturer.DEVELOPMENT;
        short productId = 0;
        float softwareVersion = 1.0f;

        Random random = new Random();
        int serialNumber = random.nextInt();

        // Every FIT file MUST contain a File ID message
        FileIdMesg fileIdMesg = new FileIdMesg();
        fileIdMesg.setType(fileType);
        fileIdMesg.setManufacturer((int) manufacturerId);
        fileIdMesg.setProduct((int) productId);
        fileIdMesg.setTimeCreated(startTime);
        fileIdMesg.setSerialNumber((long) serialNumber);

        // A Device Info message is a BEST PRACTICE for FIT ACTIVITY files
        DeviceInfoMesg deviceInfoMesg = new DeviceInfoMesg();
        deviceInfoMesg.setDeviceIndex(DeviceIndex.CREATOR);
        deviceInfoMesg.setManufacturer(Manufacturer.DEVELOPMENT);
        deviceInfoMesg.setProduct((int) productId);
        deviceInfoMesg.setProductName("FIT Cookbook"); // Max 20 Chars
        deviceInfoMesg.setSerialNumber((long) serialNumber);
        deviceInfoMesg.setSoftwareVersion(softwareVersion);
        deviceInfoMesg.setTimestamp(startTime);

        // Create the output stream
        FileEncoder encode;

        try {
            encode = new FileEncoder(new java.io.File(filename), Fit.ProtocolVersion.V2_0);
        } catch (FitRuntimeException e) {
            System.err.println("Error opening file " + filename);
            e.printStackTrace();
            return;
        }

        encode.write(fileIdMesg);
        encode.write(deviceInfoMesg);

        for (Mesg message : messages) {
            encode.write(message);
        }

        // Close the output stream
        try {
            encode.close();
        } catch (FitRuntimeException e) {
            System.err.println("Error closing encode.");
            e.printStackTrace();
            return;
        }
        System.out.println("Encoded FIT Activity file " + filename);
    }

    /**
     * Creates an example pool swim data set
     * Each length contains a type, duration,
     * stroke type, and stroke count.
     *
     * @return a list of maps where each map is a pool length.
     */
    @SuppressWarnings("serial")
    public static List<Map<String, Object>> getSwimLengths() {
        // Example Swim length representing a 500 yard pool swim using different strokes and drills.
        LinkedHashMap<String, Object> length0 = new LinkedHashMap<String, Object>() {
            {
                put("type", "ACTIVE");
                put("duration", 20);
                put("stroke", "FREESTYLE");
                put("strokes", 30);
            }
        };

        LinkedHashMap<String, Object> length1 = new LinkedHashMap<String, Object>() {
            {
                put("type", "ACTIVE");
                put("duration", 25);
                put("stroke", "FREESTYLE");
                put("strokes", 20);
            }
        };

        LinkedHashMap<String, Object> length2 = new LinkedHashMap<String, Object>() {
            {
                put("type", "ACTIVE");
                put("duration", 30);
                put("stroke", "FREESTYLE");
                put("strokes", 10);
            }
        };

        LinkedHashMap<String, Object> length3 = new LinkedHashMap<String, Object>() {
            {
                put("type", "ACTIVE");
                put("duration", 35);
                put("stroke", "FREESTYLE");
                put("strokes", 20);
            }
        };

        LinkedHashMap<String, Object> length4 = new LinkedHashMap<String, Object>() {
            {
                put("type", "LAP");
            }
        };

        LinkedHashMap<String, Object> length5 = new LinkedHashMap<String, Object>() {
            {
                put("type", "IDLE");
                put("duration", 60);
            }
        };

        LinkedHashMap<String, Object> length6 = new LinkedHashMap<String, Object>() {
            {
                put("type", "LAP");
            }
        };

        LinkedHashMap<String, Object> length7 = new LinkedHashMap<String, Object>() {
            {
                put("type", "ACTIVE");
                put("duration", 20);
                put("stroke", "BACKSTROKE");
                put("strokes", 30);
            }
        };

        LinkedHashMap<String, Object> length8 = new LinkedHashMap<String, Object>() {
            {
                put("type", "ACTIVE");
                put("duration", 25);
                put("stroke", "BACKSTROKE");
                put("strokes", 20);
            }
        };

        LinkedHashMap<String, Object> length9 = new LinkedHashMap<String, Object>() {
            {
                put("type", "ACTIVE");
                put("duration", 30);
                put("stroke", "BACKSTROKE");
                put("strokes", 10);
            }
        };

        LinkedHashMap<String, Object> length10 = new LinkedHashMap<String, Object>() {
            {
                put("type", "ACTIVE");
                put("duration", 35);
                put("stroke", "BACKSTROKE");
                put("strokes", 20);
            }
        };

        LinkedHashMap<String, Object> length11 = new LinkedHashMap<String, Object>() {
            {
                put("type", "LAP");
            }
        };

        LinkedHashMap<String, Object> length12 = new LinkedHashMap<String, Object>() {
            {
                put("type", "IDLE");
                put("duration", 60);
            }
        };

        LinkedHashMap<String, Object> length13 = new LinkedHashMap<String, Object>() {
            {
                put("type", "LAP");
            }
        };

        LinkedHashMap<String, Object> length14 = new LinkedHashMap<String, Object>() {
            {
                put("type", "ACTIVE");
                put("duration", 20);
                put("stroke", "BREASTSTROKE");
                put("strokes", 30);
            }
        };

        LinkedHashMap<String, Object> length15 = new LinkedHashMap<String, Object>() {
            {
                put("type", "ACTIVE");
                put("duration", 25);
                put("stroke", "BREASTSTROKE");
                put("strokes", 20);
            }
        };

        LinkedHashMap<String, Object> length16 = new LinkedHashMap<String, Object>() {
            {
                put("type", "ACTIVE");
                put("duration", 30);
                put("stroke", "BREASTSTROKE");
                put("strokes", 10);
            }
        };

        LinkedHashMap<String, Object> length17 = new LinkedHashMap<String, Object>() {
            {
                put("type", "ACTIVE");
                put("duration", 35);
                put("stroke", "BREASTSTROKE");
                put("strokes", 20);
            }
        };

        LinkedHashMap<String, Object> length18 = new LinkedHashMap<String, Object>() {
            {
                put("type", "LAP");
            }
        };

        LinkedHashMap<String, Object> length19 = new LinkedHashMap<String, Object>() {
            {
                put("type", "IDLE");
                put("duration", 60);
            }
        };

        LinkedHashMap<String, Object> length20 = new LinkedHashMap<String, Object>() {
            {
                put("type", "LAP");
            }
        };

        LinkedHashMap<String, Object> length21 = new LinkedHashMap<String, Object>() {
            {
                put("type", "ACTIVE");
                put("duration", 20);
                put("stroke", "BUTTERFLY");
                put("strokes", 30);
            }
        };

        LinkedHashMap<String, Object> length22 = new LinkedHashMap<String, Object>() {
            {
                put("type", "ACTIVE");
                put("duration", 25);
                put("stroke", "BUTTERFLY");
                put("strokes", 20);
            }
        };

        LinkedHashMap<String, Object> length23 = new LinkedHashMap<String, Object>() {
            {
                put("type", "ACTIVE");
                put("duration", 30);
                put("stroke", "BUTTERFLY");
                put("strokes", 10);
            }
        };

        LinkedHashMap<String, Object> length24 = new LinkedHashMap<String, Object>() {
            {
                put("type", "ACTIVE");
                put("duration", 35);
                put("stroke", "BUTTERFLY");
                put("strokes", 20);
            }
        };

        LinkedHashMap<String, Object> length25 = new LinkedHashMap<String, Object>() {
            {
                put("type", "LAP");
            }
        };

        LinkedHashMap<String, Object> length26 = new LinkedHashMap<String, Object>() {
            {
                put("type", "IDLE");
                put("duration", 60);
            }
        };

        LinkedHashMap<String, Object> length27 = new LinkedHashMap<String, Object>() {
            {
                put("type", "LAP");
            }
        };

        LinkedHashMap<String, Object> length28 = new LinkedHashMap<String, Object>() {
            {
                put("type", "ACTIVE");
                put("duration", 40);
                put("stroke", "DRILL");
            }
        };

        LinkedHashMap<String, Object> length29 = new LinkedHashMap<String, Object>() {
            {
                put("type", "ACTIVE");
                put("duration", 40);
                put("stroke", "DRILL");
            }
        };

        LinkedHashMap<String, Object> length30 = new LinkedHashMap<String, Object>() {
            {
                put("type", "ACTIVE");
                put("duration", 40);
                put("stroke", "DRILL");
            }
        };

        LinkedHashMap<String, Object> length31 = new LinkedHashMap<String, Object>() {
            {
                put("type", "ACTIVE");
                put("duration", 40);
                put("stroke", "DRILL");
            }
        };

        LinkedHashMap<String, Object> length32 = new LinkedHashMap<String, Object>() {
            {
                put("type", "LAP");
            }
        };

        List<Map<String, Object>> swimLengths = new ArrayList<Map<String, Object>>(
                Arrays.asList(
                        length0, length1, length2, length3, length4, length5, length6, length7, length8,
                        length9, length10, length11, length12, length13, length14, length15, length16,
                        length17, length18, length19, length20, length21, length22, length23, length24,
                        length25, length26, length27, length28, length29, length30, length31, length32)
        );
        return swimLengths;
    }
}
