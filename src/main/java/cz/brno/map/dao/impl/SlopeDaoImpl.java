package cz.brno.map.dao.impl;

import com.google.common.collect.Lists;
import cz.brno.map.dao.SlopeDao;
import cz.brno.map.model.ItemEntity;
import cz.brno.map.model.SlopeEntity;
import cz.brno.map.model.collection.ItemsCollection;
import cz.brno.map.utils.IConverter;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by doc on 30.06.2016.
 */

@Repository
public class SlopeDaoImpl implements SlopeDao {

    @Inject
    IConverter<ItemsCollection> converter;

    @Override
    public List<SlopeEntity> findAll() {

        List<SlopeEntity> temp = Lists.newArrayList();

        for (ItemEntity item : converter.deserialize(ItemsCollection.class).getEntityList()){
            temp.addAll(item.getSlopesCollection().getEntityList());
        }

        return temp;
    }

    @Override
    public SlopeEntity findById(String id) {
        return findAll().stream().filter(slope -> slope.getId().equals(id)).findFirst().orElse(null);
    }

    @Override
    public List<SlopeEntity> findSlopesByItemId(String id) {
        return converter.deserialize(ItemsCollection.class).getEntityList().stream().
                filter(item->item.getId().equals(id)).findFirst().orElse(null).
                getSlopesCollection().getEntityList();
    }

    @Override
    public SlopeEntity findSlopeByItemIdAndSlopeId(String itemId, String slopeId) {
        return converter.deserialize(ItemsCollection.class).getEntityList().stream().
                filter(item -> item.getId().equals(itemId)).findFirst().orElse(null).
                getSlopesCollection().getEntityList().stream().
                filter(slope -> slope.getId().equals(slopeId)).findFirst().orElse(null);
    }
}
