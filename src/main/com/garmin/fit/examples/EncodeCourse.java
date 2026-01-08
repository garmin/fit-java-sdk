/////////////////////////////////////////////////////////////////////////////////////////////
// Copyright 2025 Garmin International, Inc.
// Licensed under the Flexible and Interoperable Data Transfer (FIT) Protocol License; you
// may not use this file except in compliance with the Flexible and Interoperable Data
// Transfer (FIT) Protocol License.
/////////////////////////////////////////////////////////////////////////////////////////////

package com.garmin.fit.examples;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.garmin.fit.CourseMesg;
import com.garmin.fit.CoursePoint;
import com.garmin.fit.CoursePointMesg;
import com.garmin.fit.DateTime;
import com.garmin.fit.Event;
import com.garmin.fit.EventMesg;
import com.garmin.fit.EventType;
import com.garmin.fit.File;
import com.garmin.fit.FileEncoder;
import com.garmin.fit.FileIdMesg;
import com.garmin.fit.Fit;
import com.garmin.fit.FitRuntimeException;
import com.garmin.fit.LapMesg;
import com.garmin.fit.Manufacturer;
import com.garmin.fit.RecordMesg;
import com.garmin.fit.Sport;

public class EncodeCourse {

    public static final int PRODUCTID = 0;

    public static void main(String[] args) {
        try {
            // Create the output stream
            FileEncoder encode;
            String filename = "CourseEncodeRecipe.fit";

            try {
                encode = new FileEncoder(new java.io.File(filename), Fit.ProtocolVersion.V2_0);
            } catch (FitRuntimeException e) {
                System.err.println("Error opening file " + filename);
                e.printStackTrace();
                return;
            }

            // Get a list of course points
            List<Map<String, Object>> courseData = getCoursePoints();

            // Reference points for the course
            Map<String, Object> firstRecord = courseData.get(0);
            Map<String, Object> lastRecord = courseData.get(courseData.size() - 1);
            Map<String, Object> halfwayRecord = courseData.get(courseData.size() / 2);
            int startTimestamp = (int) firstRecord.get("timestamp");
            int endTimestamp = (int) lastRecord.get("timestamp");
            DateTime startDateTime = new DateTime(startTimestamp);
            DateTime endDateTime = new DateTime(endTimestamp);

            // Every FIT file MUST contain a 'File ID' message as the first message
            FileIdMesg fileIdMesg = new FileIdMesg();
            fileIdMesg.setType(File.COURSE);
            fileIdMesg.setManufacturer(Manufacturer.DEVELOPMENT);
            fileIdMesg.setProduct(PRODUCTID);
            fileIdMesg.setTimeCreated(startDateTime);
            fileIdMesg.setSerialNumber(12345L);
            encode.write(fileIdMesg);

            // Every FIT COURSE file MUST contain a Course message
            CourseMesg courseMesg = new CourseMesg();
            courseMesg.setName("Garmin Field Day");
            courseMesg.setSport(Sport.CYCLING);
            encode.write(courseMesg);

            // Every FIT COURSE file MUST contain a Lap message
            LapMesg lapMesg = new LapMesg();
            lapMesg.setStartTime(startDateTime);
            lapMesg.setTimestamp(startDateTime);
            lapMesg.setTotalElapsedTime((float) endTimestamp - startTimestamp);
            lapMesg.setTotalTimerTime((float) endTimestamp - startTimestamp);
            lapMesg.setStartPositionLat((int) firstRecord.get("position_lat"));
            lapMesg.setStartPositionLong((int) firstRecord.get("position_long"));
            lapMesg.setEndPositionLat((int) lastRecord.get("position_lat"));
            lapMesg.setEndPositionLong((int) lastRecord.get("position_long"));
            lapMesg.setTotalDistance((float) lastRecord.get("distance"));
            encode.write(lapMesg);

            // Timer Events are REQUIRED for FIT COURSE files
            EventMesg eventMesgStart = new EventMesg();
            eventMesgStart.setTimestamp(startDateTime);
            eventMesgStart.setEvent(Event.TIMER);
            eventMesgStart.setEventType(EventType.START);
            encode.write(eventMesgStart);

            // Every FIT COURSE file MUST contain Record messages
            for (Map<String, Object> record : courseData) {
                int timestamp = (int) record.get("timestamp");
                int latitude = (int) record.get("position_lat");
                int longitude = (int) record.get("position_long");
                float distance = (float) record.get("distance");
                float speed = (float) record.get("speed");
                float altitude = (float) record.get("altitude");

                RecordMesg recordMesg = new RecordMesg();
                recordMesg.setTimestamp(new DateTime(timestamp));
                recordMesg.setPositionLat(latitude);
                recordMesg.setPositionLong(longitude);
                recordMesg.setDistance(distance);
                recordMesg.setSpeed(speed);
                recordMesg.setAltitude(altitude);
                encode.write(recordMesg);

                // Add a Course Point at the halfway point of the route
                if (record == halfwayRecord) {
                    CoursePointMesg coursePointMesg = new CoursePointMesg();
                    coursePointMesg.setTimestamp(new DateTime(timestamp));
                    coursePointMesg.setName("Halfway");
                    coursePointMesg.setType(CoursePoint.GENERIC);
                    coursePointMesg.setPositionLat(latitude);
                    coursePointMesg.setPositionLong(longitude);
                    coursePointMesg.setDistance(distance);
                    encode.write(coursePointMesg);
                }
            }

            // Timer Events are REQUIRED for FIT COURSE files
            EventMesg eventMesgStop = new EventMesg();
            eventMesgStop.setTimestamp(endDateTime);
            eventMesgStop.setEvent(Event.TIMER);
            eventMesgStop.setEventType(EventType.STOP_ALL);
            encode.write(eventMesgStop);

            // Close the output stream
            try {
                encode.close();
            } catch (FitRuntimeException e) {
                System.err.println("Error closing encode.");
                e.printStackTrace();
                return;
            }

            System.out.println("Encoded FIT Course File " + filename);

        } catch (Exception e) {
            System.out.println("Exception encoding course: " + e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * Creates a list of example course points
     * Each course point contains a timestamp, latitude position,
     * longitude position, altitude, distance, and speed
     *
     * @return a list of maps where each map is a course point.
     */
    @SuppressWarnings("serial")
    public static List<Map<String, Object>> getCoursePoints() {
        LinkedHashMap<String, Object> point0 = new LinkedHashMap<String, Object>() {
            {
                put("timestamp", 961262849);
                put("position_lat", 463583114);
                put("position_long", -1131028903);
                put("altitude", 329f);
                put("distance", 0f);
                put("speed", 0f);
            }
        };

        LinkedHashMap<String, Object> point1 = new LinkedHashMap<String, Object>() {
            {
                put("timestamp", 961262855);
                put("position_lat", 463583127);
                put("position_long", -1131031938);
                put("altitude", 328.6f);
                put("distance", 22.03f);
                put("speed", 3.0f);
            }
        };

        LinkedHashMap<String, Object> point2 = new LinkedHashMap<String, Object>() {
            {
                put("timestamp", 961262869);
                put("position_lat", 463583152);
                put("position_long", -1131038159);
                put("altitude", 327.6f);
                put("distance", 67.29f);
                put("speed", 3.0f);
            }
        };

        LinkedHashMap<String, Object> point3 = new LinkedHashMap<String, Object>() {
            {
                put("timestamp", 961262876);
                put("position_lat", 463583164);
                put("position_long", -1131041346);
                put("altitude", 327f);
                put("distance", 90.52f);
                put("speed", 3.0f);
            }
        };

        LinkedHashMap<String, Object> point4 = new LinkedHashMap<String, Object>() {
            {
                put("timestamp", 961262876);
                put("position_lat", 463583164);
                put("position_long", -1131041319);
                put("altitude", 327f);
                put("distance", 90.72f);
                put("speed", 3.0f);
            }
        };

        LinkedHashMap<String, Object> point5 = new LinkedHashMap<String, Object>() {
            {
                put("timestamp", 961262891);
                put("position_lat", 463588537);
                put("position_long", -1131041383);
                put("altitude", 327f);
                put("distance", 140.72f);
                put("speed", 3.0f);
            }
        };

        LinkedHashMap<String, Object> point6 = new LinkedHashMap<String, Object>() {
            {
                put("timestamp", 961262891);
                put("position_lat", 463588549);
                put("position_long", -1131041383);
                put("altitude", 327f);
                put("distance", 140.82f);
                put("speed", 3.0f);
            }
        };

        LinkedHashMap<String, Object> point7 = new LinkedHashMap<String, Object>() {
            {
                put("timestamp", 961262897);
                put("position_lat", 463588537);
                put("position_long", -1131038293);
                put("altitude", 327.6f);
                put("distance", 163.26f);
                put("speed", 3.0f);
            }
        };

        LinkedHashMap<String, Object> point8 = new LinkedHashMap<String, Object>() {
            {
                put("timestamp", 961262911);
                put("position_lat", 463588512);
                put("position_long", -1131032041);
                put("altitude", 328.4f);
                put("distance", 208.75f);
                put("speed", 3.0f);
            }
        };

        LinkedHashMap<String, Object> point9 = new LinkedHashMap<String, Object>() {
            {
                put("timestamp", 961262918);
                put("position_lat", 463588499);
                put("position_long", -1131028879);
                put("altitude", 329f);
                put("distance", 231.8f);
                put("speed", 3.0f);
            }
        };

        LinkedHashMap<String, Object> point10 = new LinkedHashMap<String, Object>() {
            {
                put("timestamp", 961262918);
                put("position_lat", 463588499);
                put("position_long", -1131028903);
                put("altitude", 329f);
                put("distance", 231.97f);
                put("speed", 3.0f);
            }
        };

        LinkedHashMap<String, Object> point11 = new LinkedHashMap<String, Object>() {
            {
                put("timestamp", 961262933);
                put("position_lat", 463583127);
                put("position_long", -1131028903);
                put("altitude", 329f);
                put("distance", 281.96f);
                put("speed", 3.0f);
            }
        };

        List<Map<String, Object>> courseData = new ArrayList<Map<String, Object>>(
                Arrays.asList(
                        point0, point1, point2,
                        point3, point4, point5,
                        point6, point7, point8,
                        point9, point10, point11)
        );
        return courseData;
    }
}
