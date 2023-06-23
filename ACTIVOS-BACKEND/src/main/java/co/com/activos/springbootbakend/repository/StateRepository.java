package co.com.activos.springbootbakend.repository;

import co.com.activos.springbootbakend.model.State;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface StateRepository extends JpaRepository<State, Long> {

    List<State> findAll();

    State findById(long id);

    State save(State state);

    void delete(State state);

}
