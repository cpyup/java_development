package com.pluralsight;

import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class FormatDates {
    public static void main(String[] args) {
        outputCurrentTime();
    }

    public static void outputCurrentTime() {
        // Get current time in GMT
        ZonedDateTime gmtTime = ZonedDateTime.now(ZoneOffset.UTC);

        // Define the date formats
        DateTimeFormatter format1 = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        DateTimeFormatter format2 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter format3 = DateTimeFormatter.ofPattern("MMMM d, yyyy", Locale.ENGLISH);
        DateTimeFormatter format4 = DateTimeFormatter.ofPattern("EEEE, MMM d, yyyy h:mm", Locale.ENGLISH);

        // Output GMT
        System.out.println("GMT:");
        System.out.println(gmtTime.format(format1));
        System.out.println(gmtTime.format(format2));
        System.out.println(gmtTime.format(format3));
        System.out.println(gmtTime.format(format4));

        // Get/output local time
        ZonedDateTime localTime = ZonedDateTime.now();
        DateTimeFormatter localFormat = DateTimeFormatter.ofPattern("h:mm 'on' dd-MMM-yyyy", Locale.ENGLISH);
        System.out.println("\nLocal:\n"+localTime.format(localFormat));
    }
}
