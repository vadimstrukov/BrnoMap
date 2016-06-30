package cz.brno.map.dao.impl;

import cz.brno.map.dao.SlopeDao;
import cz.brno.map.model.SlopeEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by doc on 30.06.2016.
 */
@Repository
public class SlopeDaoImpl implements SlopeDao {

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
        return null;
    }

    @Override
    public SlopeEntity findSlopeByItemIdAndSlopeId(String itemId, String slopeId) {
        return null;
    }
}
