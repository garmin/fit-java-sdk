/////////////////////////////////////////////////////////////////////////////////////////////
// Copyright 2025 Garmin International, Inc.
// Licensed under the Flexible and Interoperable Data Transfer (FIT) Protocol License; you
// may not use this file except in compliance with the Flexible and Interoperable Data
// Transfer (FIT) Protocol License.
/////////////////////////////////////////////////////////////////////////////////////////////


package com.garmin.fit.examples;

import com.garmin.fit.*;
import com.garmin.fit.csv.MesgCSVWriter;
import com.garmin.fit.util.StreamHelpers;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;

public class MonitoringReaderExample implements MonitoringMesgListener  {
   private MesgCSVWriter mesgWriter;

   public static void main(String[] args) {
       try {
         MonitoringReaderExample example = new MonitoringReaderExample();
         String inputFile;
         int interval;
         System.out.printf("FIT Monitoring Reader Example Application - Protocol %d.%d Profile %d.%d %s\n", Fit.PROTOCOL_VERSION_MAJOR, Fit.PROTOCOL_VERSION_MINOR, Fit.PROFILE_VERSION_MAJOR, Fit.PROFILE_VERSION_MINOR, Fit.PROFILE_TYPE);
         if (args.length != 2) {
            System.out
                  .println("Usage: java -jar MonitoringReaderExample.jar <input file>.fit <interval>");
            return;
         }

         inputFile = args[0];
         interval = Integer.parseInt(args[1]);

         example.Process(inputFile, interval, false);

         if (interval == MonitoringReader.DAILY_INTERVAL) {
            example.Process(inputFile, interval, true);
         }

         System.out.println("Decoded monitoring data from " + args[0] + " to at " + args[1] + "s intervals.");

      } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
            e.printStackTrace();
      }
   }

   public void Process(String inputFile, int interval, boolean dailyTotals)
   {
      Decode decode;
      MonitoringReader monitoringReader;
      MesgBroadcaster mesgBroadcaster;
      FileInputStream inputStream;

      try {
         inputStream = new FileInputStream(inputFile);
      } catch (java.io.IOException e) {
         throw new RuntimeException("Error opening file " + inputFile);
      }


      decode = new Decode();
      mesgBroadcaster = new MesgBroadcaster(decode);
      monitoringReader = new MonitoringReader(interval);
      if (dailyTotals) {
         monitoringReader.outputDailyTotals();
      }

      mesgBroadcaster.addListener((MonitoringInfoMesgListener) monitoringReader);
      mesgBroadcaster.addListener((MonitoringMesgListener) monitoringReader);
      mesgBroadcaster.addListener((DeviceSettingsMesgListener) monitoringReader);
      mesgBroadcaster.addListener((FileIdMesgListener) monitoringReader);
      monitoringReader.addListener(this);

      try {
         String outputFile = inputFile + "-f";

         if (dailyTotals) {
            outputFile += "-dailyTotals";
         } else {
            outputFile += "-i" + interval;
         }

         outputFile += ".csv";

         ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
         mesgWriter = new MesgCSVWriter(byteArrayOutputStream);
         mesgWriter.enableShowInvalidsAsEmpty(true);

         try {
            mesgBroadcaster.run(inputStream); // Run decoder.
         } catch (FitRuntimeException a) {
            // If a file with 0 data size in it's header  has been encountered,
            // attempt to keep processing the file
            if (decode.getInvalidFileDataSize()) {
               decode.nextFile();
               mesgBroadcaster.run(inputStream);
            }
         }
         monitoringReader.broadcast(); // End of file so flush pending data.
         mesgWriter.close();

         StreamHelpers.writeByteStreamToFile(byteArrayOutputStream, outputFile, true);
      } catch (Exception e) {
         System.err.print("Exception decoding file: ");
         System.err.println(e.getMessage());
      }
   }

   public void onMesg(MonitoringMesg mesg) {
      mesgWriter.onMesg(mesg);
   }
}
