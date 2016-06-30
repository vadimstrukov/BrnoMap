package cz.brno.map.dao;

import cz.brno.map.dao.base.BaseDao;
import cz.brno.map.model.ItemEntity;
import cz.brno.map.model.LiftEntity;
import cz.brno.map.model.SlopeEntity;

import java.util.List;

/**
 * Created by strukov on 6/29/16.
 */
public interface ItemDao extends BaseDao<ItemEntity> {

    List<SlopeEntity> getSlopesByItemId(String id);
    List<LiftEntity> getLiftsByItemId(String id);
}
