package cz.brno.map.dao;

import cz.brno.map.model.Path;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 * Created by strukov on 8/22/16.
 */
@Repository
public interface PathDao extends JpaRepository<Path, String> {
}
