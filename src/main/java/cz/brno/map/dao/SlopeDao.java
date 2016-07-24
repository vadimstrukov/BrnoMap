package cz.brno.map.dao;

import cz.brno.map.dao.base.BaseDao;
import cz.brno.map.model.SlopeEntity;

import java.util.Date;
import java.util.List;

/**
 * Created by doc on 30.06.2016.
 */

// Slope DAO interface, which extends from gerenal DAO interface
public interface SlopeDao extends BaseDao<SlopeEntity> {

    List<SlopeEntity> findSlopesByItemId(String id);
    List<SlopeEntity> findSpecificSlopes(List<String> ids);
    SlopeEntity findSlopeByItemIdAndSlopeId(String itemId, String slopeId);
    List<SlopeEntity> findSlopesByDate(Date date);
    List<SlopeEntity> findSlopesByItemIdAndDate(String itemid, Date date);
}
