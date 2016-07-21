package cz.brno.map.utils;

import cz.brno.map.enums.StatusEnum;

import javax.xml.bind.annotation.adapters.XmlAdapter;

/**
 * Created by strukov on 7/21/16.
 */
public class StatusXmlAdapter extends XmlAdapter<Integer, String> {

    @Override
    public String unmarshal(Integer statusCode) throws Exception {
        return StatusEnum.values()[statusCode].getStatusText();
    }

    @Override
    public Integer marshal(String v) throws Exception {
        return null;
    }
}
