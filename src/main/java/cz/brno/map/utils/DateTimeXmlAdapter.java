package cz.brno.map.utils;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 * Created by strukov on 6/30/16.
 */

// Special class that helps to parse date from XML that we get from API
public class DateTimeXmlAdapter extends XmlAdapter<String, Date> {

    private final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public Date unmarshal(final String xml) throws Exception {
        dateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        return this.dateFormat.parse(xml);
    }

    public String marshal(final Date object) throws Exception {
        return this.dateFormat.format(object);
    }
}
