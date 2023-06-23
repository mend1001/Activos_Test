package co.com.activos.springbootbakend.services;

import co.com.activos.springbootbakend.model.State;

import java.util.List;

public interface StateService {
    List<State> getAllStates();

    State createState(State state);

    State getStateById(long id);

    State updateState(long id, State StateDetails);

    String deleteState(long id);

}
