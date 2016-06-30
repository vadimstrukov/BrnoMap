package cz.brno.map.dao.impl;

import cz.brno.map.dao.LiftDao;
import cz.brno.map.model.LiftEntity;
import cz.brno.map.model.collection.ItemsCollection;
import cz.brno.map.model.collection.LiftsCollection;
import cz.brno.map.utils.IConverter;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by doc on 30.06.2016.
 */
@Repository
public class LiftDaoImpl implements LiftDao {

    @Inject
    IConverter<LiftsCollection> converter;

    @Inject
    IConverter<ItemsCollection> itemsConverter;

    @Override
    public List<LiftEntity> findAll() {
        return converter.deserialize(LiftsCollection.class).getEntityList();
    }

    @Override
    public LiftEntity findById(String id) {
        return converter.deserialize(LiftsCollection.class).getEntityList().stream().
                filter(item->item.getId().equals(id)).findFirst().orElse(null);
    }


    @Override
    public List<LiftEntity> findLiftsByItemId(String id) {
       return itemsConverter.deserialize(ItemsCollection.class).getEntityList().stream().
               filter(item->item.getId().equals(id)).findFirst().orElse(null).
               getLiftsCollection().getEntityList();
    }

    @Override
    public LiftEntity findLiftByItemIdAndLiftId(String itemId, String liftId) {

        return itemsConverter.deserialize(ItemsCollection.class).getEntityList().stream().
                filter(item -> item.getId().equals(itemId)).findFirst().orElse(null).
                getLiftsCollection().getEntityList().stream().
                filter(lift -> lift.getId().equals(liftId)).findFirst().orElse(null);
    }
}
