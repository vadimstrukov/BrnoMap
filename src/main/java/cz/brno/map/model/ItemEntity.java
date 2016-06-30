package cz.brno.map.model;

import cz.brno.map.model.collection.LiftsCollection;
import cz.brno.map.model.collection.SlopesCollection;
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

    @Getter @Setter private String name;
    @Getter @Setter private String type;
    @Getter @Setter private String description;

    @Getter @Setter
    @XmlElement(name = "vleky")
    private LiftsCollection liftsCollection;

    @Getter @Setter
    @XmlElement(name = "sjezdovky")
    private SlopesCollection slopesCollection;

    @Getter @Setter
    @XmlElement(name = "otevreno")
    private String status;

}
