package com.halalmeatdepot.web.converters;

import org.springframework.core.convert.converter.Converter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * Created by vashishta on 9/15/16.
 */
public class SimpleDateConverter implements Converter<String, LocalDateTime> {


    public LocalDateTime convert(String o) {
        return toLocalDateTime(o);

    }

    public static Date getDateFromString(String dateOfEntry) {
        DateTimeFormatter fmt = DateTimeFormatter.ISO_LOCAL_DATE;
        LocalDate dt = LocalDate.parse(dateOfEntry, fmt);

        return asDate(dt);
    }

    public static LocalDateTime toLocalDateTime(Date date) {
        LocalDateTime ldt = LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
        return ldt;
    }

    public static Date asDate(LocalDate localDate) {
        return Date.from(localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
    }

    public static LocalDateTime toLocalDateTime(String date) {
        Date dt = getDateFromString(date);
        return toLocalDateTime(dt);
    }

}
