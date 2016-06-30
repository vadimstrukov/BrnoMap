package cz.brno.map.service.impl;

import cz.brno.map.dao.ItemDao;
import cz.brno.map.model.ItemEntity;
import cz.brno.map.service.ItemService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.Date;
import java.util.List;

/**
 * Created by strukov on 6/29/16.
 */

@Service
@Transactional
public class ItemServiceImpl implements ItemService {

    @Inject
    private ItemDao itemDao;

    @Override
    public ItemEntity findById(final String id) {
        return itemDao.findById(id);
    }

    @Override
    public List<ItemEntity> findAll() {
        return itemDao.findAll();
    }

    @Override
    public ItemEntity findByDate(Date date) {
        return null;
    }
}
