package cz.brno.map.service.base;

import java.util.List;

/**
 * Created by strukov on 6/29/16.
 */

// General Service interface for other interfaces
public interface BaseService<T> {
    List<T> findAll();
    T findById(String id);
}
