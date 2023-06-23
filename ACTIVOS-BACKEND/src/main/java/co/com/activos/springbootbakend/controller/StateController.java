package co.com.activos.springbootbakend.controller;

import co.com.activos.springbootbakend.exception.ResourceNotFoundException;
import co.com.activos.springbootbakend.model.State;
import co.com.activos.springbootbakend.services.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/states")
public class StateController {

    @Autowired
    private StateService stateService;

    @GetMapping
    public List<State> getAllStates(){
        return stateService.getAllStates();
    }

    @PostMapping
    public State createState(@RequestBody State state) {
        return stateService.createState(state);
    }

    @GetMapping("{id}")
    public ResponseEntity<State> getStateById(@PathVariable  long id){
        try {
            State state = stateService.getStateById(id);
            return ResponseEntity.ok(state);
        } catch (ResourceNotFoundException ex) {
            return ResponseEntity.notFound().build();
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("{id}")
    public ResponseEntity<State> updateState(@PathVariable long id, @RequestBody State stateDetails) {
        try {
            State updatedState = stateService.updateState(id, stateDetails);
            return ResponseEntity.ok(updatedState);
        } catch (ResourceNotFoundException ex) {
            return ResponseEntity.notFound().build();
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteState(@PathVariable long id){
        try {
            String result = stateService.deleteState(id);
            return ResponseEntity.ok(result);
        } catch (ResourceNotFoundException ex) {
            return ResponseEntity.notFound().build();
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}