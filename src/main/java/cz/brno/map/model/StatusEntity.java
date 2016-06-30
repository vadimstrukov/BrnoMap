package cz.brno.map.model;

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
 * Created by doc on 28.06.2016.
 */

@XmlRootElement(name = "stav")
@XmlAccessorType(XmlAccessType.FIELD)
public class StatusEntity implements Serializable {


    @Getter
    @Setter
    @XmlElement(name = "stamp")
    private Date date;

    @Getter
    @Setter
    @XmlElement(name = "otevrena")
    private int status;
}
