/////////////////////////////////////////////////////////////////////////////////////////////
// Copyright 2025 Garmin International, Inc.
// Licensed under the Flexible and Interoperable Data Transfer (FIT) Protocol License; you
// may not use this file except in compliance with the Flexible and Interoperable Data
// Transfer (FIT) Protocol License.
/////////////////////////////////////////////////////////////////////////////////////////////


package com.garmin.fit.plugins.examples;

import com.garmin.fit.*;
import com.garmin.fit.plugins.*;
import com.garmin.fit.csv.MesgCSVWriter;
import com.garmin.fit.util.StreamHelpers;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.InputStream;

/**
 * Example demonstrating usage of BufferedMesgBroadcaster and
 * ThreeDSensorAdjustment plugin.
 *
 * The example applies the sensor calibration parameters to all 3D Sensor messages
 * (gyroscope_data or accelerometer_data) and outputs to to a CSV file.
 *
 */
public class ThreeDSensorAdjustmentExample implements FileIdMesgListener, AccelerometerDataMesgListener, GyroscopeDataMesgListener, ThreeDSensorCalibrationMesgListener {
    private MesgCSVWriter mesgWriter;

    public static void main(String[] args) {
        System.out.printf("FIT 3D Sensor Adjustment Example Application - Protocol %d.%d Profile %d.%d %s\n", Fit.PROTOCOL_VERSION_MAJOR, Fit.PROTOCOL_VERSION_MINOR, Fit.PROFILE_VERSION_MAJOR, Fit.PROFILE_VERSION_MINOR, Fit.PROFILE_TYPE);

        FileInputStream in;

        ThreeDSensorAdjustmentExample example = new ThreeDSensorAdjustmentExample();
        Decode decode = new Decode();
        BufferedMesgBroadcaster mesgBroadcaster = new BufferedMesgBroadcaster(decode);

        if (args.length != 1) {
            System.out .println("Usage: java -jar ThreeDSensorAdjustmentExample.jar <input file>.fit");
            return;
        }

        try {
            in = new FileInputStream(args[0]);
        }
        catch (java.io.IOException e) {
            throw new RuntimeException("Error opening file " + args[0]);
        }

        try {
            if (!decode.checkFileIntegrity(in))
                throw new RuntimeException("FIT file integrity failed.");
        } catch (RuntimeException e) {
            System.err.print("Exception Checking File Integrity: ");
            System.err.println(e.getMessage());
        } finally {
            try {
                in.close();
            }
            catch (java.io.IOException e) {
                throw new RuntimeException(e);
            }
        }

        try {
            in = new FileInputStream(args[0]);
        } catch (java.io.IOException e) {
            throw new RuntimeException("Error opening file " + args[0] + " [2]");
        }

        String outputFile = args[0] + "-3DSensorAdjustmentExampleProcessed.csv";
        mesgBroadcaster.addListener((FileIdMesgListener) example);
        mesgBroadcaster.addListener((AccelerometerDataMesgListener) example);
        mesgBroadcaster.addListener((GyroscopeDataMesgListener) example);
        mesgBroadcaster.addListener((ThreeDSensorCalibrationMesgListener) example);

        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            example.mesgWriter = new MesgCSVWriter(byteArrayOutputStream);

            // Create plugin and register with mesgBroadcaster
            MesgBroadcastPlugin plugin = new ThreeDSensorAdjustmentPlugin();
            mesgBroadcaster.registerMesgBroadcastPlugin(plugin);

            mesgBroadcaster.run(in);      // Run decoder
            mesgBroadcaster.broadcast();  // End of file so flush pending data.
            example.mesgWriter.close();

            StreamHelpers.writeByteStreamToFile(byteArrayOutputStream, outputFile, true);
        } catch (Exception e) {
            System.err.print("Exception decoding file: ");
            System.err.println(e.getMessage());
        }

        System.out.println("Adjusted 3D sensor data from " + args[0] + " to " + outputFile);
    }

    public void onMesg(FileIdMesg mesg) {
        mesgWriter.onMesg(mesg);
    }

    public void onMesg(AccelerometerDataMesg mesg) {
        mesgWriter.onMesg(mesg);
    }

    public void onMesg(GyroscopeDataMesg mesg) {
        mesgWriter.onMesg(mesg);
    }

    public void onMesg(ThreeDSensorCalibrationMesg mesg) {
        mesgWriter.onMesg(mesg);
    }
}
