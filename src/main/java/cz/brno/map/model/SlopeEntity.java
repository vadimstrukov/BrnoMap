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

@XmlRootElement(name = "sjezdovka")
@XmlAccessorType(XmlAccessType.FIELD)
public class SlopeEntity implements Serializable {

    @Getter @Setter
    @XmlElement(name = "id-aldr")
    private String id;

    @XmlElement(name = "nazev")
    @Getter @Setter private String name;

    @XmlElement(name = "delka")
    @Getter @Setter private String length;

    @XmlElement(name = "obtiznost")
    @Getter @Setter private String difficulty;

    @XmlElement(name = "stav")
    @Getter @Setter private SlopeStatusEntity slopeStatusEntity;

    public String toString(){
        return "Id: "+ id + "\t" +
                "Name: " + name + "\t" +
                "Length: " + length + "\t" +
                "Difficulty: " + difficulty + "\t" +
                "Status: " + slopeStatusEntity.getStatus() + "\n";
    }

}
