package cz.brno.map.service.Impl;

import cz.brno.map.utils.HttpHelper;
import cz.brno.map.model.ItemEntity;
import cz.brno.map.service.ItemService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;

/**
 * Created by strukov on 6/29/16.
 */

@Service
@Transactional
public class ItemServiceImpl implements ItemService {

    @Inject
    private HttpHelper httpHelper;

    @Override
    public ItemEntity findById(final String id) {
        return httpHelper.getBody().getEntityList().stream().filter(item->item.getId().equals(id)).findFirst().orElse(null);
    }
}
