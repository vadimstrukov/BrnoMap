package cz.brno.map.service;

import cz.brno.map.model.ItemEntity;
import cz.brno.map.model.LiftEntity;
import cz.brno.map.model.SlopeEntity;
import cz.brno.map.service.base.BaseService;

import java.util.Date;
import java.util.List;

/**
 * Created by strukov on 6/29/16.
 */

public interface ItemService extends BaseService<ItemEntity> {
    ItemEntity findByDate(Date date);
}
