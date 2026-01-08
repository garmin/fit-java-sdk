package com.garmin.fit.util;

import java.time.Instant;

public class DateTimeConverter {
    static final long FIT_EPOCH_MS = 631065600000L;

    /**
     * Converts a FIT timestamp to a ISO-8601 formatted time string.
     *
     * @param timestamp a FIT timestamp
     * @return a ISO-8601 formatted time string
     */
    public static String fitTimestampToISO8601(long timestamp) {
        Instant instant = Instant.ofEpochMilli(timestamp * 1000 + FIT_EPOCH_MS);

        return instant.toString();
    }

    /**
     * Parses a formatted java.time string in UTC and converts it to a FIT timestamp string.
     *
     * @param dateTime a formatted time string in UTC
     * @return a FIT timestamp string
     */
    public static String parseDateTime(String dateTime) {
        try {
            Instant instant = Instant.parse(dateTime).minusMillis(FIT_EPOCH_MS);
            return String.valueOf(instant.getEpochSecond());
        } catch (Exception e) {
            //no op
        }

        return dateTime;
    }
}
