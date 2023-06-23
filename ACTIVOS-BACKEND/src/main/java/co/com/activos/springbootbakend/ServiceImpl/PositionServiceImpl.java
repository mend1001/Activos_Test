package co.com.activos.springbootbakend.ServiceImpl;
import co.com.activos.springbootbakend.model.Position;
import co.com.activos.springbootbakend.repository.PositionRepository;
import co.com.activos.springbootbakend.exception.ResourceNotFoundException;
import co.com.activos.springbootbakend.services.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class PositionServiceImpl implements PositionService {
    @Autowired
    private PositionRepository positionRepository;
    @Override
    public List<Position> getAllPositions() {
        return positionRepository.findAll();
    }

    @Override
    public Position createPosition(Position position) {
        return positionRepository.save(position);
    }
    @Override
    public Position getPositionById(long id) {
        return positionRepository.findById(id);
    }
    @Override
    public Position updatePosition(long id, Position positionDetails) {
        Position updatePosition = positionRepository.findById(id);
        if (updatePosition == null) {
            throw new ResourceNotFoundException("Position not exist with id: " + id);
        }
        if (positionDetails.getCharge() != null) {
            updatePosition.setCharge(positionDetails.getCharge());
        }
        return positionRepository.save(updatePosition);
    }

    @Override
    public String deletePosition(long id) {
        Position position = positionRepository.findById(id);
        if (position == null) {
            System.out.println("The position dont exist");
            return "Position not exist with id: " + id;
        }
        System.out.println("The position was deleted");
        positionRepository.delete(position);
        return "Position with ID " + id + " has been deleted";
    }

}