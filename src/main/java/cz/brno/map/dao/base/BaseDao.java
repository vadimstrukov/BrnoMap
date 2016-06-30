package cz.brno.map.dao.base;

import java.util.List;

/**
 * Created by strukov on 6/29/16.
 */
public interface BaseDao<T> {
    List<T> findAll();
    T findById(String id);
}
