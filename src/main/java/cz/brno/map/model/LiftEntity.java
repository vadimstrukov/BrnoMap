package cz.brno.map.model;

import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * Created by doc on 28.06.2016.
 */

@XmlRootElement(name = "vlek")
@XmlAccessorType(XmlAccessType.FIELD)
public class LiftEntity implements Serializable {

    @Getter
    @Setter
    @XmlElement(name = "id-aldr")
    private String id;

    @XmlElement(name = "typ")
    @Getter @Setter
    private String type;

    @XmlElement(name = "nazev")
    @Getter @Setter
    private String name;

    @XmlElement(name = "umisteni")
    @Getter @Setter
    private String location;

    @XmlElement(name = "stav")
    @Getter @Setter
    private LiftStatusEntity liftStatusEntity;

    public String toString(){
        return "Id: "+ id + "\t" +
                "Name: " + name + "\t" +
                "Type: " + type + "\t" +
                "location: " + location + "\t" +
                "Status: " + liftStatusEntity.getStatus() + "\n";
    }
}
