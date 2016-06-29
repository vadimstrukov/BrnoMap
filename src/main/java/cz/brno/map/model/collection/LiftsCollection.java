package cz.brno.map.model.collection;

import com.google.common.collect.Lists;
import cz.brno.map.model.LiftEntity;
import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created by doc on 28.06.2016.
 */

@XmlRootElement(name = "vleky")
@XmlAccessorType(XmlAccessType.FIELD)
public class LiftsCollection {

    @Getter
    @Setter
    @XmlElement(name = "vlek")
    private List<LiftEntity> entityList = Lists.newArrayList();
}
