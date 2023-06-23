package co.com.activos.springbootbakend.repository;

import co.com.activos.springbootbakend.model.Position;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PositionRepository extends JpaRepository<Position, Long> {

    List<Position> findAll();

    Position findById(long id);

    Position save(Position position);

    void delete(Position position);

}