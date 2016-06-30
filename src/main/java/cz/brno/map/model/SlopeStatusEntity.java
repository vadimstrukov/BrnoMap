package cz.brno.map.model;

import cz.brno.map.utils.DateTimeXmlAdapter;
import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.io.Serializable;
import java.time.OffsetDateTime;
import java.time.ZonedDateTime;
import java.util.Date;

/**
 * Created by doc on 28.06.2016.
 */

@XmlRootElement(name = "stav")
@XmlAccessorType(XmlAccessType.FIELD)
public class SlopeStatusEntity implements Serializable {


    @Getter
    @Setter
    @XmlElement(name = "stamp")
    @XmlJavaTypeAdapter(DateTimeXmlAdapter.class)
    private Date date;

    @Getter
    @Setter
    @XmlElement(name = "otevrena")
    private int status;
}
