package cz.brno.map.service;

import cz.brno.map.model.LiftEntity;
import cz.brno.map.service.base.BaseService;

import java.util.List;

/**
 * Created by strukov on 6/30/16.
 */
public interface LiftService extends BaseService<LiftEntity>{
    List<LiftEntity> findLiftsByItemId(String id);
    LiftEntity findLiftByItemIdAndLiftId(String itemId, String liftId);
}
