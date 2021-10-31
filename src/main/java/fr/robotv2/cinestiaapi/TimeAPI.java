package fr.robotv2.cinestiaapi;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class TimeAPI {

    public static Long getInstant() {
        return Instant.now().toEpochMilli();
    }

    public static LocalDateTime toLocalDateTime(Long instant) {
        return Instant.ofEpochMilli(instant).atZone(ZoneId.systemDefault()).toLocalDateTime();
    }

    public static int getHour(Long instant) {
        return (int) (instant / 1000) / 3600;
    }

    public static int getMinut(Long instant) {
        return toLocalDateTime(instant).getMinute();
    }

    public static int getSecond(Long instant) {
        return toLocalDateTime(instant).getSecond();
    }
}
