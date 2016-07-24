package cz.brno.map.service.impl;

import cz.brno.map.dao.SlopeDao;
import cz.brno.map.model.SlopeEntity;
import cz.brno.map.service.SlopeService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.Date;
import java.util.List;

/**
 * Created by strukov on 6/30/16.
 */

// Slope Service interface implementation
// Class uses SlopeDao injection to use Slope DAO methods
@Service
@Transactional
public class SlopeServiceImpl implements SlopeService{

    @Inject
    private SlopeDao slopeDao;

    @Override
    public List<SlopeEntity> findSlopesByItemId(String id) {
        return slopeDao.findSlopesByItemId(id);
    }

    @Override
    public List<SlopeEntity> findSpecificSlopes(List<String> ids) {
        return slopeDao.findSpecificSlopes(ids);
    }

    @Override
    public SlopeEntity findSlopeByItemIdAndSlopeId(String itemId, String slopeId) {
        return slopeDao.findSlopeByItemIdAndSlopeId(itemId, slopeId);
    }

    @Override
    public List<SlopeEntity> findSlopesByDate(Date date) {
        return slopeDao.findSlopesByDate(date);
    }

    @Override
    public List<SlopeEntity> findSlopesByItemIdAndDate(String itemid, Date date) {
        return slopeDao.findSlopesByItemIdAndDate(itemid, date);
    }

    @Override
    public List<SlopeEntity> findAll() {
        return slopeDao.findAll();
    }

    @Override
    public SlopeEntity findById(String id) {
        return slopeDao.findById(id);
    }
}
