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
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created by doc on 30.06.2016.
 */

// Lift DAO interface implementation
@Repository
public class LiftDaoImpl implements LiftDao {

    @Inject
    IConverter<ItemsCollection> converter;

    // Method for getting all Lift entities
    // Method collects all Lifts from all Items into array which is returned in the end
    @Override
    public List<LiftEntity> findAll() {
        List<LiftEntity> allLifts = Lists.newArrayList();
        converter.deserialize(ItemsCollection.class).getEntityList().stream().forEach(item -> allLifts.addAll(item.getLiftsCollection().getEntityList()));
        return allLifts;
    }

    // Method for getting specific Lift by his ID
    // Method takes all Lifts and filters by specific Lift ID
    @Override
    public LiftEntity findById(String id) {
        List<LiftEntity> allLifts = Lists.newArrayList();
        converter.deserialize(ItemsCollection.class).getEntityList().stream().forEach(item -> allLifts.addAll(item.getLiftsCollection().getEntityList()));
        return allLifts.stream().filter(lift -> lift.getId().equals(id)).findFirst().orElse(null);
    }

    // Method for getting Lifts by Item ID
    // Method finds specific Item by his ID, then returns Item Lifts
    @Override
    public List<LiftEntity> findLiftsByItemId(String id) {
       return converter.deserialize(ItemsCollection.class).getEntityList().stream().
               filter(item->item.getId().equals(id)).findFirst().orElse(null).
               getLiftsCollection().getEntityList();
    }

    // Method for getting specific Lift by his ID and also by Item ID
    // Method finds specific Item by his ID, then filters Lifts and finds specific one by his ID
    @Override
    public LiftEntity findLiftByItemIdAndLiftId(String itemId, String liftId) {
        return converter.deserialize(ItemsCollection.class).getEntityList().stream().
                filter(item -> item.getId().equals(itemId)).findFirst().orElse(null).
                getLiftsCollection().getEntityList().stream().
                filter(lift -> lift.getId().equals(liftId)).findFirst().orElse(null);
    }

    // Method for getting all Lifts by specific Date
    // Method collects from all Items their Lifts and filters by specific date
    @Override
    public List<LiftEntity> findLiftsByDate(Date date) {
        List<LiftEntity> liftsWithDate = Lists.newArrayList();
        converter.deserialize(ItemsCollection.class).getEntityList().
                stream().forEach(item -> liftsWithDate.addAll(item.getLiftsCollection().getEntityList().
                stream().filter(lift-> Optional.ofNullable(lift.getLiftStatusEntity().getDate()).
                filter(date1 -> DateUtils.isSameDay(date1, date)).isPresent()).collect(Collectors.toList())));
        return liftsWithDate;
    }

    // Method for getting Lifts by specific Date and by Item ID
    // Method collects all Lifts from specific Item and filters by specific date
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
