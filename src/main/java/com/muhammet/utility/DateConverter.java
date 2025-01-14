package com.muhammet.utility;

import java.sql.Date;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class DateConverter {
    /**
     * Bu method String bir tarih değerini java.sql.Date e dönüştürür.
     * @param date -> YYYY.MM.DDThh.mm.ss şeklinde değer alabilir.
     * @return
     */
    public static Date stringToDate(String date) {
        ZoneId zone = ZoneId.of("Europe/Berlin");
        Date result = new Date(LocalDateTime.parse(date).atZone(zone).toEpochSecond()*1000);
        return result;
    }

}
