package cz.brno.map.service.impl;

import cz.brno.map.model.SlopeEntity;
import cz.brno.map.service.SlopeService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by strukov on 6/30/16.
 */
@Service
@Transactional
public class SlopeServiceImpl implements SlopeService{

    @Override
    public List<SlopeEntity> findSlopesByItemId(String id) {
        return null;
    }

    @Override
    public SlopeEntity findSlopeByItemIdAndSlopeId(String itemId, String slopeId) {
        return null;
    }

    @Override
    public List<SlopeEntity> findAll() {
        return null;
    }

    @Override
    public SlopeEntity findById(String id) {
        return null;
    }
}
