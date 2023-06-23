package co.com.activos.springbootbakend.ServiceImpl;
import co.com.activos.springbootbakend.model.State;
import co.com.activos.springbootbakend.repository.StateRepository;
import co.com.activos.springbootbakend.exception.ResourceNotFoundException;
import co.com.activos.springbootbakend.services.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class StateServiceImpl implements StateService {
    @Autowired
    private StateRepository stateRepository;
    @Override
    public List<State> getAllStates() {
        return stateRepository.findAll();
    }

    @Override
    public State createState(State state) {
        return stateRepository.save(state);
    }
    @Override
    public State getStateById(long id) {
        return stateRepository.findById(id);
    }
    @Override
    public State updateState(long id, State stateDetails) {
        State updateState = stateRepository.findById(id);
        if (updateState == null) {
            throw new ResourceNotFoundException("State not exist with id: " + id);
        }
        if (stateDetails.getDescription() != null) {
            updateState.setDescription(stateDetails.getDescription());
        }
        return stateRepository.save(updateState);
    }

    @Override
    public String deleteState(long id) {
        State state = stateRepository.findById(id);
        if (state == null) {
            System.out.println("The state dont exist");
            return "State not exist with id: " + id;
        }
        System.out.println("The state was deleted");
        stateRepository.delete(state);
        return "State with ID " + id + " has been deleted";
    }

}