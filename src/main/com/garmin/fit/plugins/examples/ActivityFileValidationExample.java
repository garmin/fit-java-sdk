/////////////////////////////////////////////////////////////////////////////////////////////
// Copyright 2025 Garmin International, Inc.
// Licensed under the Flexible and Interoperable Data Transfer (FIT) Protocol License; you
// may not use this file except in compliance with the Flexible and Interoperable Data
// Transfer (FIT) Protocol License.
/////////////////////////////////////////////////////////////////////////////////////////////


package com.garmin.fit.plugins.examples;

import com.garmin.fit.FitDecoder;
import com.garmin.fit.FitRuntimeException;
import com.garmin.fit.plugins.ActivityFileValidationPlugin;
import com.garmin.fit.plugins.ActivityFileValidationResult;

import java.io.FileInputStream;

public class ActivityFileValidationExample {

    public static void main(String[] args) {
        System.out.println("Activity File Validator");

        if (!validateCommandLine(args)) {
            printUsage();
            return;
        }

        ActivityFileValidationPlugin plugin = new ActivityFileValidationPlugin();

        try {
            System.out.println("Opening file: " + args[0]);
            FileInputStream inputStream = new FileInputStream(args[0]);

            FitDecoder fitDecoder = new FitDecoder();

            System.out.println("Decoding file...");
            fitDecoder.decode(inputStream, plugin);

            System.out.println("File decoded");

        } catch (java.io.IOException e) {
            System.out.println("IOException opening file: " + args[0]);
            e.printStackTrace();
        } catch (FitRuntimeException e) {
            System.out.println("FitRuntimeException decoding file: " + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("Exception decoding file: " + e.getMessage());
            e.printStackTrace();
        } finally {
            // If an exception occurs before onBroadcast() is called,
            // then the validation checks will not be executed. There
            // may still be decoded messages that are worth validating,
            // so force the validation checks to execute. Some tests may be
            // skipped or fail due to missing messages.
            if (plugin.getResults().size() == 0) {
                plugin.repeatValidation();
            }

            printValidationReport(plugin);
        }
    }

    private static boolean validateCommandLine(String[] args) {
        return args.length == 1;
    }

    private static void printUsage() {
        System.out.println("Usage: java DecodeExample <filename>");
        System.out.println("<filename>      required");
    }

    private static void printValidationReport(ActivityFileValidationPlugin plugin) {
        System.out.println("Message Count: " + plugin.getMesgCount());

        for (ActivityFileValidationResult result : plugin.getResults()) {
            System.out.println(result);
            if (result.getDescription() != null) {
                System.out.println("\t" + result.getDescription());
            }
        }
    }
}
