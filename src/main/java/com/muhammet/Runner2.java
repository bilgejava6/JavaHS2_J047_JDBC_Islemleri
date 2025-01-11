package com.muhammet;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.TemporalAccessor;
import java.time.temporal.TemporalField;

public class Runner2 {
    public static void main(String[] args) {
        String date = "2007-12-03T10:15:30";
        ZoneId zone = ZoneId.of("Europe/Berlin");
        System.out.println("tarih....: "+
        LocalDateTime.parse(date).atZone(zone).toEpochSecond()
        );
    }
}
