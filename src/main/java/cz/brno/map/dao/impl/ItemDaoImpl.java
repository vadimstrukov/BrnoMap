package cz.brno.map.dao.impl;

import cz.brno.map.dao.ItemDao;
import cz.brno.map.model.ItemEntity;
import cz.brno.map.model.LiftEntity;
import cz.brno.map.model.SlopeEntity;
import cz.brno.map.model.collection.ItemsCollection;
import cz.brno.map.utils.IConverter;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by strukov on 6/29/16.
 */
@Repository
public class ItemDaoImpl implements ItemDao {

    @Inject
    IConverter<ItemsCollection> converter;

    @Override
    public List<ItemEntity> findAll() {
        return converter.deserialize(ItemsCollection.class).getEntityList();
    }

    @Override
    public ItemEntity findById(String id) {
        return converter.deserialize(ItemsCollection.class).getEntityList().stream().filter(item->item.getId().equals(id)).findFirst().orElse(null);
    }

    @Override
    public List<SlopeEntity> getSlopesByItemId(String id) {
        return converter.deserialize(ItemsCollection.class).getEntityList().stream().filter(item->item.getId().equals(id)).findFirst().orElse(null).getSlopesCollection().getEntityList();
    }

    @Override
    public List<LiftEntity> getLiftsByItemId(String id) {
        return converter.deserialize(ItemsCollection.class).getEntityList().stream().filter(item->item.getId().equals(id)).findFirst().orElse(null).getLiftsCollection().getEntityList();
    }


}
