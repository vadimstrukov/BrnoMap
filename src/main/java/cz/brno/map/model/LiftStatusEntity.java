package cz.brno.map.model;

import cz.brno.map.enums.StatusEnum;
import cz.brno.map.utils.DateTimeXmlAdapter;
import cz.brno.map.utils.StatusXmlAdapter;
import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by strukov on 6/30/16.
 */
@XmlRootElement(name = "stav")
@XmlAccessorType(XmlAccessType.FIELD)
public class LiftStatusEntity implements Serializable {

    @Getter
    @Setter
    @XmlElement(name = "stamp")
    @XmlJavaTypeAdapter(DateTimeXmlAdapter.class)
    private Date date;

    @Getter
    @Setter
    @XmlElement(name = "otevren")
    @XmlJavaTypeAdapter(StatusXmlAdapter.class)
    private StatusEnum status;
}
