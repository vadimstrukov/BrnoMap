package cz.brno.map.utils;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Created by strukov on 6/30/16.
 */
public class ZonedDateTimeXmlAdapter extends DateTimeXmlAdapter<ZonedDateTime> {

    public ZonedDateTimeXmlAdapter() {
        super(DateTimeFormatter.ISO_ZONED_DATE_TIME, ZonedDateTime::from);
    }
}