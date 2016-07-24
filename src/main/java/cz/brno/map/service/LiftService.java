package cz.brno.map.service;

import cz.brno.map.model.LiftEntity;
import cz.brno.map.service.base.BaseService;

import java.util.Date;
import java.util.List;

/**
 * Created by strukov on 6/30/16.
 */

// Lift Service interface, which extends from general Service interface
public interface LiftService extends BaseService<LiftEntity>{

    List<LiftEntity> findLiftsByItemId(String id);
    List<LiftEntity> findSpecificLifts(List<String> ids);
    LiftEntity findLiftByItemIdAndLiftId(String itemId, String liftId);
    List<LiftEntity> findLiftsByDate(Date date);
    List<LiftEntity> findLiftsByItemIdAndDate(String itemid, Date date);

}
