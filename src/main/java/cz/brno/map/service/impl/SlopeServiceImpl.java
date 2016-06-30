package cz.brno.map.service.impl;

import cz.brno.map.dao.SlopeDao;
import cz.brno.map.model.SlopeEntity;
import cz.brno.map.service.SlopeService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by strukov on 6/30/16.
 */
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
    public SlopeEntity findSlopeByItemIdAndSlopeId(String itemId, String slopeId) {
        return slopeDao.findSlopeByItemIdAndSlopeId(itemId, slopeId);
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
