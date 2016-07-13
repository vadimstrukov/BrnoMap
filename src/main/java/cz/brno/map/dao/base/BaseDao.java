package cz.brno.map.dao.base;

import java.util.List;

/**
 * Created by strukov on 6/29/16.
 */

// General DAO interface for other interfaces
public interface BaseDao<T> {
    List<T> findAll();
    T findById(String id);
}
