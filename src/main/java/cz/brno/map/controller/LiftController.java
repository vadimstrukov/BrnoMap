package cz.brno.map.controller;

import cz.brno.map.config.RestBinder;
import cz.brno.map.model.LiftEntity;
import cz.brno.map.service.LiftService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.Date;
import java.util.List;

/**
 * Created by strukov on 6/30/16.
 */

// Controller that interacts with Lifts

// MediaType for getting JSON anywhere
@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class LiftController extends RestBinder{

    @Inject
    private LiftService liftService;

    // Method for getting specific Lift by his ID
    @RequestMapping(value = "/lifts/{id}", method = RequestMethod.GET)
    public ResponseEntity<LiftEntity> getById(@PathVariable("id") String id){
        return new ResponseEntity<>(liftService.findById(id), HttpStatus.OK);
    }

    // Method for getting all Lifts -> List with Lift entities
    @RequestMapping(value = "/lifts/all", method = RequestMethod.GET)
    public ResponseEntity<List<LiftEntity>> getAll(){
        return new ResponseEntity<>(liftService.findAll(), HttpStatus.OK);
    }

    // Method for getting Lifts by Item ID
    @RequestMapping(value = "/items/{id}/lifts", method = RequestMethod.GET)
    public ResponseEntity<List<LiftEntity>> getLiftsByItemId(@PathVariable("id") String id){
        return new ResponseEntity<>(liftService.findLiftsByItemId(id), HttpStatus.OK);
    }

    // Method for getting specific Lift by his ID and also by Item ID
    @RequestMapping(value = "/items/{id}/lifts/{liftid}", method = RequestMethod.GET)
    public ResponseEntity<LiftEntity> getLiftByItemIdAndLiftId(@PathVariable("id") String id, @PathVariable("liftid") String liftid){
        return new ResponseEntity<>(liftService.findLiftByItemIdAndLiftId(id, liftid), HttpStatus.OK);
    }

    // Method for getting all Lifts by specific Date
    @RequestMapping(value = "/lifts/date", method = RequestMethod.GET)
    public ResponseEntity<List<LiftEntity>> getLiftsByDate(@RequestParam("value") Date date){
        return new ResponseEntity<>(liftService.findLiftsByDate(date), HttpStatus.OK);
    }

    // Method for getting Lifts by specific Date and by Item ID
    @RequestMapping(value = "/items/{id}/lifts/date", method = RequestMethod.GET)
    public ResponseEntity<List<LiftEntity>> getLiftsByItemIdAndDate(@PathVariable("id") String id, @RequestParam("value")  Date date){
        return new ResponseEntity<>(liftService.findLiftsByItemIdAndDate(id, date), HttpStatus.OK);
    }

}
