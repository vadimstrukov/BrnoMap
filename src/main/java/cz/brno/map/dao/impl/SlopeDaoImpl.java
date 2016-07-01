package cz.brno.map.dao.impl;

import com.google.common.collect.Lists;
import cz.brno.map.dao.SlopeDao;
import cz.brno.map.model.SlopeEntity;
import cz.brno.map.model.collection.ItemsCollection;
import cz.brno.map.utils.IConverter;
import org.apache.commons.lang.time.DateUtils;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;
import java.util.Date;
import java.util.List;
import java.util.Optional;
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
        List<SlopeEntity> temp = Lists.newArrayList();
        converter.deserialize(ItemsCollection.class).getEntityList().stream().forEach(item -> temp.addAll(item.getSlopesCollection().getEntityList()));
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

    @Override
    public List<SlopeEntity> findSlopesByDate(Date date) {
        List<SlopeEntity> slopesWithDate = Lists.newArrayList();
        converter.deserialize(ItemsCollection.class).getEntityList().
                stream().forEach(item -> slopesWithDate.addAll(item.getSlopesCollection().getEntityList().
                stream().filter(lift-> Optional.ofNullable(lift.getSlopeStatusEntity().getDate()).
                filter(date1 -> DateUtils.isSameDay(date1, date)).isPresent()).collect(Collectors.toList())));
        return slopesWithDate;
    }

    @Override
    public List<SlopeEntity> findSlopesByItemIdAndDate(String itemid, Date date) {
        List<SlopeEntity> slopesWithDate = Lists.newArrayList();
        converter.deserialize(ItemsCollection.class).getEntityList().
                stream().filter(item->item.getId().equals(itemid)).forEach(item -> slopesWithDate.addAll(item.getSlopesCollection().getEntityList().
                stream().filter(lift-> Optional.ofNullable(lift.getSlopeStatusEntity().getDate()).
                filter(date1 -> DateUtils.isSameDay(date1, date)).isPresent()).collect(Collectors.toList())));
        return slopesWithDate;
    }
}
