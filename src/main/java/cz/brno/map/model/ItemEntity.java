package cz.brno.map.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

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
    

    public String toString(){
        return "Id: "+ id + "\t" + "Name: " + name + "\t" + "Type: " + type + "\n";
    }

}
