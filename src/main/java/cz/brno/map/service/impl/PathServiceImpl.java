package cz.brno.map.service.impl;

import cz.brno.map.dao.PathDao;
import cz.brno.map.model.Path;
import cz.brno.map.service.PathService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by strukov on 8/22/16.
 */
@Service
@Transactional
public class PathServiceImpl implements PathService{

    @Inject
    private PathDao pathDao;

    @Override
    public List<Path> findAll() {
        return pathDao.findAll();
    }

    @Override
    public Path findById(String id) {
        return pathDao.getOne(id);
    }

    @Override
    public Path save(Path path) {
        return pathDao.save(path);
    }
}
