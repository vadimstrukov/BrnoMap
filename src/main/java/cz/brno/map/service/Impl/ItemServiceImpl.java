package cz.brno.map.service.Impl;

import cz.brno.map.HttpHelper;
import cz.brno.map.model.ItemEntity;
import cz.brno.map.service.ItemService;
import org.apache.http.client.HttpClient;
import org.springframework.beans.factory.annotation.Autowired;
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
