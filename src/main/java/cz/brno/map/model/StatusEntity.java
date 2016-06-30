package cz.brno.map.model;

import cz.brno.map.utils.ZonedDateTimeXmlAdapter;
import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.Date;

/**
 * Created by doc on 28.06.2016.
 */

@XmlRootElement(name = "stav")
@XmlAccessorType(XmlAccessType.FIELD)
public class StatusEntity implements Serializable {


    @Getter
    @Setter
    @XmlElement(name = "stamp")
    @XmlJavaTypeAdapter(ZonedDateTimeXmlAdapter.class)
    private ZonedDateTime date;

    @Getter
    @Setter
    @XmlElement(name = "otevrena")
    private int status;
}
