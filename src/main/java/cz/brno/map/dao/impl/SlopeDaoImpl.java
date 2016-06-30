package cz.brno.map.dao.impl;

import cz.brno.map.dao.SlopeDao;
import cz.brno.map.model.SlopeEntity;
import cz.brno.map.model.collection.ItemsCollection;
import cz.brno.map.utils.IConverter;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by doc on 30.06.2016.
 */

@Repository
public class SlopeDaoImpl implements SlopeDao {


    @Inject
    IConverter<ItemsCollection> converter;

    @Override
    public List<SlopeEntity> findAll() {
        return null;
    }

    @Override
    public SlopeEntity findById(String id) {
        return null;
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
