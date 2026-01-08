/////////////////////////////////////////////////////////////////////////////////////////////
// Copyright 2025 Garmin International, Inc.
// Licensed under the Flexible and Interoperable Data Transfer (FIT) Protocol License; you
// may not use this file except in compliance with the Flexible and Interoperable Data
// Transfer (FIT) Protocol License.
/////////////////////////////////////////////////////////////////////////////////////////////

package com.garmin.fit.examples;

import com.garmin.fit.DateTime;
import com.garmin.fit.DisplayMeasure;
import com.garmin.fit.File;
import com.garmin.fit.FileEncoder;
import com.garmin.fit.FileIdMesg;
import com.garmin.fit.Fit;
import com.garmin.fit.FitRuntimeException;
import com.garmin.fit.Intensity;
import com.garmin.fit.Manufacturer;
import com.garmin.fit.Sport;
import com.garmin.fit.SubSport;
import com.garmin.fit.SwimStroke;
import com.garmin.fit.WktStepDuration;
import com.garmin.fit.WktStepTarget;
import com.garmin.fit.WorkoutEquipment;
import com.garmin.fit.WorkoutMesg;
import com.garmin.fit.WorkoutStepMesg;

import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

public class EncodeWorkout {

    public static void main(String[] args) {
        try {
            CreateBikeTempoWorkout();
            CreateRun800RepeatWorkout();
            CreateCustomTargetValuesWorkout();
            CreatePoolSwimWorkout();            
        } catch (Exception e) {
            System.out.println("Exception encoding workout: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void CreateBikeTempoWorkout() {
        ArrayList<WorkoutStepMesg> workoutSteps = new ArrayList<WorkoutStepMesg>();

        // Warm up 10min (60000ms) in Heart Rate Zone 1
        workoutSteps.add(CreateWorkoutStep(
                workoutSteps.size(),
                "Warm up 10min in Heart Rate Zone 1",
                null,
                Intensity.WARMUP,
                WktStepDuration.TIME,
                600000,
                WktStepTarget.HEART_RATE,
                1));

        // Bike 40min (240000ms) Power Zone 3
        workoutSteps.add(CreateWorkoutStep(
                workoutSteps.size(),
                "Bike 40min Power Zone 3",
                null,
                Intensity.ACTIVE,
                WktStepDuration.TIME,
                2400000,
                WktStepTarget.POWER,
                3));

        // Cool Down Until Lap Button Pressed, No Target (0)
        workoutSteps.add(CreateWorkoutStep(
                workoutSteps.size(),
                "Cool Down Until Lap Button Pressed",
                null,
                Intensity.COOLDOWN,
                WktStepDuration.OPEN,
                null,
                WktStepTarget.OPEN,
                0));

        WorkoutMesg workoutMesg = new WorkoutMesg();
        workoutMesg.setWktName("Tempo Bike");
        workoutMesg.setSport(Sport.CYCLING);
        workoutMesg.setSubSport(SubSport.INVALID);
        workoutMesg.setNumValidSteps(workoutSteps.size());

        CreateWorkout(workoutMesg, workoutSteps);
    }

    public static void CreateRun800RepeatWorkout() {
        ArrayList<WorkoutStepMesg> workoutSteps = new ArrayList<WorkoutStepMesg>();

        // Warm up 4km (80000cm) in Heart Rate Zone 1
        workoutSteps.add(CreateWorkoutStep(
                workoutSteps.size(),
                "Warm up 4km in Heart Rate Zone 1",
                null,
                Intensity.WARMUP,
                WktStepDuration.DISTANCE,
                400000,
                WktStepTarget.HEART_RATE,
                1));

        // Run 800m (80000cm) in Heart Rate Zone 4
        workoutSteps.add(CreateWorkoutStep(
                workoutSteps.size(),
                "Run 800m in Heart Rate Zone 4",
                null,
                Intensity.ACTIVE,
                WktStepDuration.DISTANCE,
                80000,
                WktStepTarget.HEART_RATE,
                4));

        // Recover 200m (20000cm) in Heart Rate Zone 2
        workoutSteps.add(CreateWorkoutStep(
                workoutSteps.size(),
                "Recover 200m in Heart Rate Zone 2",
                null,
                Intensity.REST,
                WktStepDuration.DISTANCE,
                20000,
                WktStepTarget.HEART_RATE,
                2));

        // Repeat 5x Steps 1-2
        workoutSteps.add(CreateWorkoutStepRepeat(
                workoutSteps.size(),
                1,
                5));

        // Cool Down 1km (100000cm) in Heart Rate Zone 2
        workoutSteps.add(CreateWorkoutStep(
                workoutSteps.size(),
                "Cool Down 1km in Heart Rate Zone 2",
                null,
                Intensity.COOLDOWN,
                WktStepDuration.DISTANCE,
                100000,
                WktStepTarget.HEART_RATE,
                2));

        WorkoutMesg workoutMesg = new WorkoutMesg();
        workoutMesg.setWktName("Running 800m Repeats");
        workoutMesg.setSport(Sport.RUNNING);
        workoutMesg.setSubSport(SubSport.INVALID);
        workoutMesg.setNumValidSteps(workoutSteps.size());

        CreateWorkout(workoutMesg, workoutSteps);
    }

    public static void CreateCustomTargetValuesWorkout() {
        ArrayList<WorkoutStepMesg> workoutSteps = new ArrayList<WorkoutStepMesg>();

        // Warm Up 10min(600000ms) Heart Rate 135-155bpm
        workoutSteps.add(CreateWorkoutStep(
                workoutSteps.size(),
                "Warm Up 10min Heart Rate 135-155bpm",
                null,
                Intensity.WARMUP,
                WktStepDuration.TIME,
                600000,
                WktStepTarget.HEART_RATE,
                235,
                255));

        // Bike 40min (2400000ms) Power 175-195 watts
        workoutSteps.add(CreateWorkoutStep(
                workoutSteps.size(),
                "Bike 40min Power 175-195 watts",
                null,
                Intensity.ACTIVE,
                WktStepDuration.TIME,
                2400000,
                WktStepTarget.POWER,
                1175,
                1195));

        // Cool Down 10min(600000ms) Speed 20-25kph (5556 - 6944 cm/sec)
        workoutSteps.add(CreateWorkoutStep(
                workoutSteps.size(),
                "Cool Down 10min Speed 20-25kph",
                null,
                Intensity.COOLDOWN,
                WktStepDuration.TIME,
                600000,
                WktStepTarget.SPEED,
                5556,
                6944));

        WorkoutMesg workoutMesg = new WorkoutMesg();
        workoutMesg.setWktName("Custom Target Values");
        workoutMesg.setSport(Sport.CYCLING);
        workoutMesg.setSubSport(SubSport.INVALID);
        workoutMesg.setNumValidSteps(workoutSteps.size());

        CreateWorkout(workoutMesg, workoutSteps);
    }

    public static void CreatePoolSwimWorkout() {
        ArrayList<WorkoutStepMesg> workoutSteps = new ArrayList<WorkoutStepMesg>();

        // Warm Up 200 yds
        workoutSteps.add(CreateWorkoutStepSwim(
                workoutSteps.size(),
                182.88f,
                "Warm Up 200 yds",
                null,
                Intensity.WARMUP,
                SwimStroke.INVALID,
                null));

        // Rest until lap button pressed
        workoutSteps.add(CreateWorkoutStepSwimRest(
                workoutSteps.size(),
                WktStepDuration.OPEN,
                null));

        // Drill w/ kickboard 200 yds
        workoutSteps.add(CreateWorkoutStepSwim(
                workoutSteps.size(),
                182.88f,
                "Drill w/ kickboard 200 yds",
                null,
                Intensity.ACTIVE,
                SwimStroke.DRILL,
                WorkoutEquipment.SWIM_KICKBOARD));

        // Rest until lap button pressed
        workoutSteps.add(CreateWorkoutStepSwimRest(
                workoutSteps.size(),
                WktStepDuration.OPEN,
                null));

        // 5 x 100 yds on 2:00
        workoutSteps.add(CreateWorkoutStepSwim(
                workoutSteps.size(),
                91.44f,
                "5 x 100 yds on 2:00",
                null,
                Intensity.ACTIVE,
                SwimStroke.FREESTYLE,
                null));

        // Repeat on 2min (120sec)
        workoutSteps.add(CreateWorkoutStepSwimRest(
                workoutSteps.size(),
                WktStepDuration.REPETITION_TIME,
                120.0f));

        // Repeat 5x Steps 4-5
        workoutSteps.add(CreateWorkoutStepRepeat(
                workoutSteps.size(),
                4,
                5));

        // Rest until lap button pressed
        workoutSteps.add(CreateWorkoutStepSwimRest(
                workoutSteps.size(),
                WktStepDuration.OPEN,
                null));

        // Cool Down 100 yds
        workoutSteps.add(CreateWorkoutStepSwim(
                workoutSteps.size(),
                91.44f,
                "Cool Down 100 yds",
                null,
                Intensity.COOLDOWN,
                SwimStroke.INVALID,
                null));

        WorkoutMesg workoutMesg = new WorkoutMesg();
        workoutMesg.setWktName("Pool Swim");
        workoutMesg.setSport(Sport.SWIMMING);
        workoutMesg.setSubSport(SubSport.LAP_SWIMMING);
        workoutMesg.setPoolLength(22.86f); // 25 yards
        workoutMesg.setPoolLengthUnit(DisplayMeasure.STATUTE);
        workoutMesg.setNumValidSteps(workoutSteps.size());

        CreateWorkout(workoutMesg, workoutSteps);
    }

    public static void CreateWorkout(WorkoutMesg workoutMesg, ArrayList<WorkoutStepMesg> workoutSteps) {
        // The combination of file type, manufacturer id, product id, and serial number should be unique.
        // When available, a non-random serial number should be used.
        File filetype = File.WORKOUT;
        short manufacturerId = Manufacturer.DEVELOPMENT;
        short productId = 0;
        Random random = new Random();
        int serialNumber = random.nextInt();

        // Every FIT file MUST contain a File ID message
        FileIdMesg fileIdMesg = new FileIdMesg();
        fileIdMesg.setType(filetype);
        fileIdMesg.setManufacturer((int) manufacturerId);
        fileIdMesg.setProduct((int) productId);
        fileIdMesg.setTimeCreated(new DateTime(new Date()));
        fileIdMesg.setSerialNumber((long) serialNumber);

        // Create the output stream
        FileEncoder encode;
        String filename = workoutMesg.getWktName().replace(" ", "_") + ".fit";

        try {
            encode = new FileEncoder(new java.io.File(filename), Fit.ProtocolVersion.V1_0);
        } catch (FitRuntimeException e) {
            System.err.println("Error opening file " + filename);
            e.printStackTrace();
            return;
        }

        // Write the messages to the file, in the proper sequence
        encode.write(fileIdMesg);
        encode.write(workoutMesg);

        for (WorkoutStepMesg workoutStep : workoutSteps) {
            encode.write(workoutStep);
        }

        // Close the output stream
        try {
            encode.close();
        } catch (FitRuntimeException e) {
            System.err.println("Error closing encode.");
            e.printStackTrace();
            return;
        }

        System.out.println("Encoded FIT Workout File " + filename);
    }

    private static WorkoutStepMesg CreateWorkoutStep(int messageIndex,
                                                     String name,
                                                     String notes,
                                                     Intensity intensity,
                                                     WktStepDuration durationType,
                                                     Integer durationValue,
                                                     WktStepTarget targetType,
                                                     int targetValue) {

        return CreateWorkoutStep(
                messageIndex, name, notes, intensity,
                durationType, durationValue, targetType,
                targetValue, null, null);
    }

    private static WorkoutStepMesg CreateWorkoutStep(int messageIndex,
                                                     String name,
                                                     String notes,
                                                     Intensity intensity,
                                                     WktStepDuration durationType,
                                                     Integer durationValue,
                                                     WktStepTarget targetType,
                                                     int customTargetValueLow,
                                                     int customTargetValueHigh) {

        return CreateWorkoutStep(
                messageIndex, name, notes, intensity,
                durationType, durationValue, targetType,
                0, customTargetValueLow, customTargetValueHigh);
    }

    private static WorkoutStepMesg CreateWorkoutStep(int messageIndex,
                                                     String name,
                                                     String notes,
                                                     Intensity intensity,
                                                     WktStepDuration durationType,
                                                     Integer durationValue,
                                                     WktStepTarget targetType,
                                                     int targetValue,
                                                     Integer customTargetValueLow,
                                                     Integer customTargetValueHigh) {

        WorkoutStepMesg workoutStepMesg = new WorkoutStepMesg();
        workoutStepMesg.setMessageIndex(messageIndex);

        if (name != null) {
            workoutStepMesg.setWktStepName(name);
        }

        if (notes != null) {
            workoutStepMesg.setNotes(notes);
        }

        if (durationType == WktStepDuration.INVALID) {
            return null;
        }

        workoutStepMesg.setIntensity(intensity);
        workoutStepMesg.setDurationType(durationType);

        if (durationValue != null) {
            workoutStepMesg.setDurationValue((long) durationValue);
        }

        if (targetType != WktStepTarget.INVALID && customTargetValueLow != null && customTargetValueHigh != null) {
            workoutStepMesg.setTargetType(targetType);
            workoutStepMesg.setTargetValue((long) 0);
            workoutStepMesg.setCustomTargetValueLow((long) customTargetValueLow);
            workoutStepMesg.setCustomTargetValueHigh((long) customTargetValueHigh);
        } else if (targetType != WktStepTarget.INVALID) {
            workoutStepMesg.setTargetValue((long) targetValue);
            workoutStepMesg.setTargetType(targetType);
            workoutStepMesg.setCustomTargetValueLow((long) 0);
            workoutStepMesg.setCustomTargetValueHigh((long) 0);
        }

        return workoutStepMesg;
    }

    private static WorkoutStepMesg CreateWorkoutStepRepeat(int messageIndex, int repeatFrom, int repetitions) {
        WorkoutStepMesg workoutStepMesg = new WorkoutStepMesg();
        workoutStepMesg.setMessageIndex((messageIndex));

        workoutStepMesg.setDurationType(WktStepDuration.REPEAT_UNTIL_STEPS_CMPLT);
        workoutStepMesg.setDurationValue((long) repeatFrom);

        workoutStepMesg.setTargetType(WktStepTarget.OPEN);
        workoutStepMesg.setTargetValue((long) repetitions);

        return workoutStepMesg;
    }

    private static WorkoutStepMesg CreateWorkoutStepSwim(int messageIndex,
                                                         float distance,
                                                         String name,
                                                         String notes,
                                                         Intensity intensity,
                                                         SwimStroke swimStroke,
                                                         WorkoutEquipment equipment) {

        WorkoutStepMesg workoutStepMesg = new WorkoutStepMesg();
        workoutStepMesg.setMessageIndex(messageIndex);

        if (name != null) {
            workoutStepMesg.setWktStepName(name);
        }

        if (notes != null) {
            workoutStepMesg.setNotes(notes);
        }

        workoutStepMesg.setIntensity(intensity);

        workoutStepMesg.setDurationType(WktStepDuration.DISTANCE);
        workoutStepMesg.setDurationDistance(distance);

        workoutStepMesg.setTargetType(WktStepTarget.SWIM_STROKE);

        workoutStepMesg.setTargetStrokeType(swimStroke);

        if (equipment != null) {
            workoutStepMesg.setEquipment(equipment);
        }

        return workoutStepMesg;
    }

    private static WorkoutStepMesg CreateWorkoutStepSwimRest(int messageIndex, WktStepDuration durationType, Float durationTime) {
        WorkoutStepMesg workoutStepMesg = new WorkoutStepMesg();
        workoutStepMesg.setMessageIndex(messageIndex);

        workoutStepMesg.setDurationType(durationType);
        workoutStepMesg.setDurationTime(durationTime);

        workoutStepMesg.setTargetType(WktStepTarget.OPEN);

        workoutStepMesg.setIntensity(Intensity.REST);

        return workoutStepMesg;
    }
}
