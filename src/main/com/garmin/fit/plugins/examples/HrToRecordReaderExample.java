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
 * HrToRecordMesgBroadcaster plugin.
 * <p>
 * The example outputs all
 * record message and HR messages to a CSV file with the record
 * messages to match the HR data if their times align
 *
 */
public class HrToRecordReaderExample implements RecordMesgListener, HrMesgListener {
    private MesgCSVWriter mesgWriter;

    public static void main(String[] args) {
        System.out.printf("FIT Hr Record Reader Example Application - Protocol %d.%d Profile %d.%d %s\n", Fit.PROTOCOL_VERSION_MAJOR, Fit.PROTOCOL_VERSION_MINOR, Fit.PROFILE_VERSION_MAJOR, Fit.PROFILE_VERSION_MINOR, Fit.PROFILE_TYPE);

        FileInputStream in;

        HrToRecordReaderExample example = new HrToRecordReaderExample();
        Decode decode = new Decode();
        BufferedMesgBroadcaster mesgBroadcaster = new BufferedMesgBroadcaster(decode);

        if (args.length != 1) {
            System.out .println("Usage: java -jar FitHrRecordReaderExample.jar <input file>.fit");
            return;
        }

        try {
            in = new FileInputStream(args[0]);
        }
        catch (java.io.IOException e) {
            throw new RuntimeException("Error opening file " + args[0]);
        }

        try {
            if (!decode.checkFileIntegrity(in)) {
                throw new RuntimeException("FIT file integrity failed.");
            }
        }  catch (RuntimeException e) {
            System.err.print("Exception Checking File Integrity: ");
            System.err.println(e.getMessage());
        }
        finally {
            try {
                in.close();
            } catch (java.io.IOException e) {
                throw new RuntimeException(e);
            }
        }
        try {
            in = new FileInputStream(args[0]);
        } catch (java.io.IOException e) {
            throw new RuntimeException("Error opening file " + args[0] + " [2]");
        }

        String outputFile = args[0] + "-HrRecordExampleProcessed.csv";
        mesgBroadcaster.addListener((RecordMesgListener) example);
        mesgBroadcaster.addListener((HrMesgListener) example);

        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            example.mesgWriter = new MesgCSVWriter(byteArrayOutputStream);

            // Create plugin and register with mesgBroadcaster
            MesgBroadcastPlugin plugin = new HrToRecordMesgBroadcastPlugin();
            mesgBroadcaster.registerMesgBroadcastPlugin(plugin);

            mesgBroadcaster.run(in);      // Run decoder
            mesgBroadcaster.broadcast();  // End of file so flush pending data.
            example.mesgWriter.close();

            StreamHelpers.writeByteStreamToFile(byteArrayOutputStream, outputFile, true);
        }
        catch (Exception e) {
            System.err.print("Exception decoding file: ");
            System.err.println(e.getMessage());
        }

        System.out.println("Decoded Record and Hr data from " + args[0] + " to " + outputFile);
    }

    public void onMesg(RecordMesg mesg) {
        mesgWriter.onMesg(mesg);
    }

    public void onMesg(HrMesg mesg) {
        mesgWriter.onMesg(mesg);
    }
}
