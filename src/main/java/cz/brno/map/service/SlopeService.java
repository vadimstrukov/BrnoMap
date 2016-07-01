package cz.brno.map.service;

import cz.brno.map.model.SlopeEntity;
import cz.brno.map.service.base.BaseService;

import java.util.Date;
import java.util.List;

/**
 * Created by strukov on 6/30/16.
 */
public interface SlopeService extends BaseService<SlopeEntity>{
    List<SlopeEntity> findSlopesByItemId(String id);
    SlopeEntity findSlopeByItemIdAndSlopeId(String itemId, String slopeId);
    List<SlopeEntity> findSlopesByDate(Date date);
    List<SlopeEntity> findSlopesByItemIdAndDate(String itemid, Date date);
}
