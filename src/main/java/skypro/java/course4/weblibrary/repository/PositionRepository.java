package skypro.java.course4.weblibrary.repository;

import org.springframework.data.repository.CrudRepository;
import skypro.java.course4.weblibrary.model.Position;

import java.util.Optional;

public interface PositionRepository extends CrudRepository<Position, Integer> {

    Optional<Position> findFirstByName(String name);
}
