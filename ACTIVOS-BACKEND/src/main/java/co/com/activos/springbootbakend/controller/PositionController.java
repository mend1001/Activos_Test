package co.com.activos.springbootbakend.controller;

import co.com.activos.springbootbakend.exception.ResourceNotFoundException;
import co.com.activos.springbootbakend.model.Position;
import co.com.activos.springbootbakend.services.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/positions")
public class PositionController {

    @Autowired
    private PositionService positionService;

    @GetMapping
    public List<Position> getAllPositions(){
        return positionService.getAllPositions();
    }

    @PostMapping
    public Position createPosition(@RequestBody Position position) {
        return positionService.createPosition(position);
    }

    @GetMapping("{id}")
    public ResponseEntity<Position> getPositionById(@PathVariable  long id){
        try {
            Position position = positionService.getPositionById(id);
            return ResponseEntity.ok(position);
        } catch (ResourceNotFoundException ex) {
            return ResponseEntity.notFound().build();
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("{id}")
    public ResponseEntity<Position> updatePosition(@PathVariable long id, @RequestBody Position positionDetails) {
        try {
            Position updatedPosition = positionService.updatePosition(id, positionDetails);
            return ResponseEntity.ok(updatedPosition);
        } catch (ResourceNotFoundException ex) {
            return ResponseEntity.notFound().build();
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deletePosition(@PathVariable long id){
        try {
            String result = positionService.deletePosition(id);
            return ResponseEntity.ok(result);
        } catch (ResourceNotFoundException ex) {
            return ResponseEntity.notFound().build();
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}