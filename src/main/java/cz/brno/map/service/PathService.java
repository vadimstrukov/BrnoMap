package cz.brno.map.service;

import cz.brno.map.model.Path;
import cz.brno.map.service.base.BaseService;

/**
 * Created by strukov on 8/22/16.
 */
public interface PathService extends BaseService<Path> {
    Path save(Path path);
}
