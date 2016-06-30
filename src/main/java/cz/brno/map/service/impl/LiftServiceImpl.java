package cz.brno.map.service.impl;

import cz.brno.map.dao.ItemDao;
import cz.brno.map.dao.LiftDao;
import cz.brno.map.model.LiftEntity;
import cz.brno.map.model.collection.LiftsCollection;
import cz.brno.map.service.LiftService;
import cz.brno.map.utils.IConverter;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.Date;
import java.util.List;

/**
 * Created by strukov on 6/30/16.
 */
@Service
@Transactional
public class LiftServiceImpl implements LiftService {

    @Inject
    private LiftDao liftDao;

    @Override
    public List<LiftEntity> findLiftsByItemId(String id) {
        return liftDao.findLiftsByItemId(id);
    }

    @Override
    public LiftEntity findLiftByItemIdAndLiftId(String itemId, String liftId) {
        return liftDao.findLiftByItemIdAndLiftId(itemId, liftId);
    }

    @Override
    public List<LiftEntity> findLiftsByDate(Date date) {
        return liftDao.findLiftsByDate(date);
    }

    @Override
    public List<LiftEntity> findLiftsByItemIdAndDate(String itemid, Date date) {
        return liftDao.findLiftsByItemIdAndDate(itemid, date);
    }

    @Override
    public List<LiftEntity> findAll() {
        return liftDao.findAll();
    }

    @Override
    public LiftEntity findById(String id) {
        return liftDao.findById(id);
    }
}
