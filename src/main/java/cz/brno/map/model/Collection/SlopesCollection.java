package cz.brno.map.model.Collection;

import com.google.common.collect.Lists;
import cz.brno.map.model.SlopeEntity;
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

@XmlRootElement(name = "sjezdovky")
@XmlAccessorType(XmlAccessType.FIELD)
public class SlopesCollection {

    @Getter
    @Setter
    @XmlElement(name = "sjezdovka")
    private List<SlopeEntity> entityList = Lists.newArrayList();
}
