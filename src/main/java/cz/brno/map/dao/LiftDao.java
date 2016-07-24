package cz.brno.map.dao;

import cz.brno.map.dao.base.BaseDao;
import cz.brno.map.model.LiftEntity;

import java.util.Date;
import java.util.List;

/**
 * Created by doc on 30.06.2016.
 */

// Lift DAO interface, which extends from general DAO interface
public interface LiftDao  extends BaseDao<LiftEntity> {

    List<LiftEntity> findLiftsByItemId(String id);
    List<LiftEntity> findSpecificLifts(List<String> ids);
    LiftEntity findLiftByItemIdAndLiftId(String itemId, String liftId);
    List<LiftEntity> findLiftsByDate(Date date);
    List<LiftEntity> findLiftsByItemIdAndDate(String itemid, Date date);

}
