package cz.brno.map.dao;

import cz.brno.map.dao.base.BaseDao;
import cz.brno.map.model.LiftEntity;
import cz.brno.map.model.SlopeEntity;

import java.util.List;

/**
 * Created by doc on 30.06.2016.
 */
public interface SlopeDao extends BaseDao<SlopeEntity> {
    List<SlopeEntity> findSlopesByItemId(String id);
    SlopeEntity findSlopeByItemIdAndSlopeId(String itemId, String slopeId);
}
