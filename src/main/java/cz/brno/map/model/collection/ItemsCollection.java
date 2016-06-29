package cz.brno.map.model.collection;

import com.google.common.collect.Lists;
import cz.brno.map.model.ItemEntity;
import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.List;

/**
 * Created by strukov on 6/28/16.
 */
@XmlRootElement(name = "seznam.cz")
@XmlAccessorType(XmlAccessType.FIELD)
public class ItemsCollection implements Serializable {

    @Getter
    @Setter
    @XmlElement(name = "item")
    private List<ItemEntity> entityList = Lists.newArrayList();

}
