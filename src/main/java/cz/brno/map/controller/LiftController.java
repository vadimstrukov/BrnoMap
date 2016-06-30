package cz.brno.map.controller;

import cz.brno.map.model.LiftEntity;
import cz.brno.map.service.LiftService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by strukov on 6/30/16.
 */
@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class LiftController {

    @Inject
    private LiftService liftService;



    @RequestMapping(value = "/lifts/{id}", method = RequestMethod.GET)
    public ResponseEntity<LiftEntity> getById(@PathVariable("id") String id){
        return new ResponseEntity<>(liftService.findById(id), HttpStatus.OK);
    }

    @RequestMapping(value = "/lifts/all", method = RequestMethod.GET)
    public ResponseEntity<List<LiftEntity>> getAll(){
        return new ResponseEntity<>(liftService.findAll(), HttpStatus.OK);
    }

    @RequestMapping(value = "/items/{id}/lifts", method = RequestMethod.GET)
    public ResponseEntity<List<LiftEntity>> getLiftsByItemId(@PathVariable("id") String id){
        return new ResponseEntity<>(liftService.findLiftsByItemId(id), HttpStatus.OK);
    }

    @RequestMapping(value = "/items/{id}/lifts/{liftid}", method = RequestMethod.GET)
    public ResponseEntity<LiftEntity> getLiftByItemIdAndLiftId(@PathVariable("id") String id, @PathVariable("liftid") String liftid){
        return new ResponseEntity<>(liftService.findLiftByItemIdAndLiftId(id, liftid), HttpStatus.OK);
    }
}
