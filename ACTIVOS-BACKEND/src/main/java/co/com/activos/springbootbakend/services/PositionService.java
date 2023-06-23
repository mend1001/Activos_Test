package co.com.activos.springbootbakend.services;

import co.com.activos.springbootbakend.model.Position;

import java.util.List;

public interface PositionService {
    List<Position> getAllPositions();

    Position createPosition(Position position);

    Position getPositionById(long id);

    Position updatePosition(long id, Position PositionDetails);

    String deletePosition(long id);

}