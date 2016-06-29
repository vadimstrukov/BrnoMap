package cz.brno.map.service;

import cz.brno.map.model.ItemEntity;

/**
 * Created by strukov on 6/29/16.
 */

public interface ItemService {
    ItemEntity findById(String id);
}
