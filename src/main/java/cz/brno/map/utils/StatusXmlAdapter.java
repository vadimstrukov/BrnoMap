package cz.brno.map.utils;

import cz.brno.map.enums.StatusEnum;

import javax.xml.bind.annotation.adapters.XmlAdapter;

/**
 * Created by strukov on 7/21/16.
 */
public class StatusXmlAdapter extends XmlAdapter<Integer, StatusEnum> {

    @Override
    public StatusEnum unmarshal(Integer statusCode) throws Exception {
        return StatusEnum.values()[statusCode];
    }

    @Override
    public Integer marshal(StatusEnum v) throws Exception {
        return null;
    }
}
