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

// Slope DAO interface implementation
@Repository
public class SlopeDaoImpl implements SlopeDao {

    @Inject
    IConverter<ItemsCollection> converter;

    // Method for getting all Slope entities
    // Method collects all Slopes from all Items into array which is returned in the end
    @Override
    public List<SlopeEntity> findAll() {
        List<SlopeEntity> allSlopes = Lists.newArrayList();
        converter.deserialize(ItemsCollection.class).getEntityList().stream().forEach(item -> allSlopes.addAll(item.getSlopesCollection().getEntityList()));
        return allSlopes;
    }

    // Method for getting specific Slope by his ID
    // Method takes all Slopes and filters by specific Slope ID
    @Override
    public SlopeEntity findById(String id) {
        List<SlopeEntity> allSlopes = Lists.newArrayList();
        converter.deserialize(ItemsCollection.class).getEntityList().stream().forEach(item -> allSlopes.addAll(item.getSlopesCollection().getEntityList()));
        return allSlopes.stream().filter(slope -> slope.getId().equals(id)).findFirst().orElse(null);
    }

    // Method for getting Slopes by Item ID
    // Method finds specific Item by his ID, then returns Item Slopes
    @Override
    public List<SlopeEntity> findSlopesByItemId(String id) {
        return converter.deserialize(ItemsCollection.class).getEntityList().stream().
                filter(item->item.getId().equals(id)).findFirst().orElse(null).
                getSlopesCollection().getEntityList();
    }

    @Override
    public List<SlopeEntity> findSpecificSlopes(List<String> ids) {
        List<SlopeEntity> specificSlopes = Lists.newArrayList();
        converter.deserialize(ItemsCollection.class).getEntityList().forEach(item -> specificSlopes.addAll(item.getSlopesCollection().getEntityList()));
        return specificSlopes.stream().filter(slope -> ids.contains(slope.getId())).collect(Collectors.toList());
    }

    // Method for getting specific Slope by his ID and also by Item ID
    // Method finds specific Item by his ID, then filters Slopes and finds specific one by his ID
    @Override
    public SlopeEntity findSlopeByItemIdAndSlopeId(String itemId, String slopeId) {
        return converter.deserialize(ItemsCollection.class).getEntityList().stream().
                filter(item -> item.getId().equals(itemId)).findFirst().orElse(null).
                getSlopesCollection().getEntityList().stream().
                filter(slope -> slope.getId().equals(slopeId)).findFirst().orElse(null);
    }

    // Method for getting all Slopes by specific Date
    // Method collects from all Items their Slopes and filters by specific date
    @Override
    public List<SlopeEntity> findSlopesByDate(Date date) {
        List<SlopeEntity> slopesWithDate = Lists.newArrayList();
        converter.deserialize(ItemsCollection.class).getEntityList().
                stream().forEach(item -> slopesWithDate.addAll(item.getSlopesCollection().getEntityList().
                stream().filter(slope-> Optional.ofNullable(slope.getSlopeStatusEntity().getDate()).
                filter(date1 -> DateUtils.isSameDay(date1, date)).isPresent()).collect(Collectors.toList())));
        return slopesWithDate;
    }

    // Method for getting Slopes by specific Date and by Item ID
    // Method collects all Slopes from specific Item and filters by specific date
    @Override
    public List<SlopeEntity> findSlopesByItemIdAndDate(String itemid, Date date) {
        List<SlopeEntity> slopesWithDate = Lists.newArrayList();
        converter.deserialize(ItemsCollection.class).getEntityList().
                stream().filter(item->item.getId().equals(itemid)).forEach(item -> slopesWithDate.addAll(item.getSlopesCollection().getEntityList().
                stream().filter(slope-> Optional.ofNullable(slope.getSlopeStatusEntity().getDate()).
                filter(date1 -> DateUtils.isSameDay(date1, date)).isPresent()).collect(Collectors.toList())));
        return slopesWithDate;
    }
}
