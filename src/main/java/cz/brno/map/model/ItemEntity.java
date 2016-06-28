package cz.brno.map.model;

import cz.brno.map.model.Collection.LiftsCollection;
import cz.brno.map.model.Collection.SlopesCollection;
import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * Created by strukov on 6/28/16.
 */

@XmlRootElement(name = "item")
@XmlAccessorType(XmlAccessType.FIELD)
public class ItemEntity implements Serializable{

    @Getter @Setter
    @XmlElement(name = "id-aldr")
    private String id;

    @Getter @Setter String name;
    @Getter @Setter String type;
    @Getter @Setter String description;

    @Getter @Setter
    @XmlElement(name = "vleky")
    LiftsCollection liftsCollection;

    @Getter @Setter
    @XmlElement(name = "sjezdovky")
    SlopesCollection slopesCollection;

    public String toString(){
        return "Id: "+ id + "\n" +
                "Name: " + name + "\n" +
                "Type: " + type + "\n" +
                "Description: " + description + "\n\n";
    }

}
