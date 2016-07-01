package cz.brno.map.dao.impl;

import com.google.common.collect.Lists;
import cz.brno.map.dao.LiftDao;
import cz.brno.map.model.LiftEntity;
import cz.brno.map.model.collection.ItemsCollection;
import cz.brno.map.utils.IConverter;
import org.apache.commons.lang.time.DateUtils;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created by doc on 30.06.2016.
 */

@Repository
public class LiftDaoImpl implements LiftDao {

    @Inject
    IConverter<ItemsCollection> converter;

    @Override
    public List<LiftEntity> findAll() {
        List<LiftEntity> lifts = Lists.newArrayList();
        converter.deserialize(ItemsCollection.class).getEntityList().stream().forEach(item -> lifts.addAll(item.getLiftsCollection().getEntityList()));
        return lifts;
    }

    @Override
    public LiftEntity findById(String id) {
        return findAll().stream().filter(lift -> lift.getId().equals(id)).findFirst().orElse(null);
    }

    @Override
    public List<LiftEntity> findLiftsByItemId(String id) {
       return converter.deserialize(ItemsCollection.class).getEntityList().stream().
               filter(item->item.getId().equals(id)).findFirst().orElse(null).
               getLiftsCollection().getEntityList();
    }

    @Override
    public LiftEntity findLiftByItemIdAndLiftId(String itemId, String liftId) {
        return converter.deserialize(ItemsCollection.class).getEntityList().stream().
                filter(item -> item.getId().equals(itemId)).findFirst().orElse(null).
                getLiftsCollection().getEntityList().stream().
                filter(lift -> lift.getId().equals(liftId)).findFirst().orElse(null);
    }

    @Override
    public List<LiftEntity> findLiftsByDate(Date date) {
        List<LiftEntity> liftsWithDate = Lists.newArrayList();
        converter.deserialize(ItemsCollection.class).getEntityList().
                stream().forEach(item -> liftsWithDate.addAll(item.getLiftsCollection().getEntityList().
                stream().filter(lift-> Optional.ofNullable(lift.getLiftStatusEntity().getDate()).
                filter(date1 -> DateUtils.isSameDay(date1, date)).isPresent()).collect(Collectors.toList())));
        return liftsWithDate;
    }

    @Override
    public List<LiftEntity> findLiftsByItemIdAndDate(String itemid, Date date) {
        List<LiftEntity> liftsWithDate = Lists.newArrayList();
        converter.deserialize(ItemsCollection.class).getEntityList().
                stream().filter(item->item.getId().equals(itemid)).forEach(item -> liftsWithDate.addAll(item.getLiftsCollection().getEntityList().
                stream().filter(lift-> Optional.ofNullable(lift.getLiftStatusEntity().getDate()).
                filter(date1 -> DateUtils.isSameDay(date1, date)).isPresent()).collect(Collectors.toList())));
        return liftsWithDate;
    }
}
