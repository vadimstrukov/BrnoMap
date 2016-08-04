package cz.brno.map.controller;

import cz.brno.map.config.RestBinder;
import cz.brno.map.model.SlopeEntity;
import cz.brno.map.service.SlopeService;
import cz.brno.map.utils.IValidator;
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

// Controller that interacts with Slopes

// MediaType for getting JSON anywhere
@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class SlopeController extends RestBinder {

    @Inject
    private SlopeService slopeService;
    @Inject
    private IValidator<SlopeEntity> slopeEntityIValidator;

    // Method for getting specific Slope by his ID
    @RequestMapping(value = "/slopes/{id}", method = RequestMethod.GET)
    public ResponseEntity<SlopeEntity> getById(@PathVariable("id") String id){
        return new ResponseEntity<>(slopeEntityIValidator.validate(id, slopeService.findById(id)), HttpStatus.OK);
    }

    // Method for getting all Slopes -> List with Slope entities
    @RequestMapping(value = "/slopes/all", method = RequestMethod.GET)
    public ResponseEntity<List<SlopeEntity>> getAll(){
        return new ResponseEntity<>(slopeService.findAll(), HttpStatus.OK);
    }

    @RequestMapping(value = "/slopes/specific/{ids}", method = RequestMethod.GET)
    public ResponseEntity<List<SlopeEntity>> getSpecific(@PathVariable("ids") List<String> ids){
        return new ResponseEntity<>(slopeService.findSpecificSlopes(ids), HttpStatus.OK);
    }

    // Method for getting Slopes by Item ID
    @RequestMapping(value = "/items/{id}/slopes", method = RequestMethod.GET)
    public ResponseEntity<List<SlopeEntity>> getSlopesByItemId(@PathVariable("id") String id){
        return new ResponseEntity<>(slopeService.findSlopesByItemId(id), HttpStatus.OK);
    }

    // Method for getting specific Slope by his ID and also by Item ID
    @RequestMapping(value = "/items/{id}/slopes/{slopeid}", method = RequestMethod.GET)
    public ResponseEntity<SlopeEntity> getSlopeByItemIdAndSlopeId(@PathVariable("id") String id, @PathVariable("slopeid") String slopeid){
        return new ResponseEntity<>(slopeService.findSlopeByItemIdAndSlopeId(id, slopeid), HttpStatus.OK);
    }

    // Method for getting all Slopes by specific Date
    @RequestMapping(value = "/slopes/date", method = RequestMethod.GET)
    public ResponseEntity<List<SlopeEntity>> getSlopesByDate(@RequestParam("value") Date date){
        return new ResponseEntity<>(slopeService.findSlopesByDate(date), HttpStatus.OK);
    }

    // Method for getting Slopes by specific Date and by Item ID
    @RequestMapping(value = "/items/{id}/slopes/date", method = RequestMethod.GET)
    public ResponseEntity<List<SlopeEntity>> getSlopesByItemIdAndDate(@PathVariable("id") String id, @RequestParam("value")  Date date){
        return new ResponseEntity<>(slopeService.findSlopesByItemIdAndDate(id, date), HttpStatus.OK);
    }
}
