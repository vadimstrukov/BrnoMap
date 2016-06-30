package cz.brno.map.utils;

import javax.annotation.Nonnull;
import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.time.temporal.TemporalQuery;
import java.util.Date;

import static java.util.Objects.requireNonNull;

/**
 * Created by strukov on 6/30/16.
 */
public class DateTimeXmlAdapter <T extends TemporalAccessor> extends XmlAdapter<String, T> {

    private final DateTimeFormatter formatter;
    private final TemporalQuery<? extends T> temporalQuery;

    public DateTimeXmlAdapter(@Nonnull DateTimeFormatter formatter,
                                      @Nonnull TemporalQuery<? extends T> temporalQuery) {
        this.formatter = requireNonNull(formatter, "formatter must not be null");
        this.temporalQuery = requireNonNull(temporalQuery, "temporal query must not be null");
    }

    @Override
    public T unmarshal(String stringValue) {
        return stringValue != null ? formatter.parse(stringValue, temporalQuery) : null;
    }

    @Override
    public String marshal(T value) {
        return value != null ? formatter.format(value) : null;
    }
}
