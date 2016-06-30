package cz.brno.map.utils;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by strukov on 6/30/16.
 */
public class DateTimeXmlAdapter extends XmlAdapter<String, Date> {

    private final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    public Date unmarshal(final String xml) throws Exception {
        return this.dateFormat.parse(xml);
    }

    public String marshal(final Date object) throws Exception {
        return this.dateFormat.format(object);
    }
}
