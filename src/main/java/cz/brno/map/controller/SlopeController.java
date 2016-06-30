package cz.brno.map.controller;

import cz.brno.map.model.SlopeEntity;
import cz.brno.map.service.SlopeService;
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
public class SlopeController {

    @Inject
    private SlopeService slopeService;

    @RequestMapping(value = "/slopes/{id}", method = RequestMethod.GET)
    public ResponseEntity<SlopeEntity> getById(@PathVariable("id") String id){
        return new ResponseEntity<>(slopeService.findById(id), HttpStatus.OK);
    }

    @RequestMapping(value = "/slopes/all", method = RequestMethod.GET)
    public ResponseEntity<List<SlopeEntity>> getAll(){
        return new ResponseEntity<>(slopeService.findAll(), HttpStatus.OK);
    }

    @RequestMapping(value = "/items/{id}/slopes", method = RequestMethod.GET)
    public ResponseEntity<List<SlopeEntity>> getSlopesByItemId(@PathVariable("id") String id){
        return new ResponseEntity<>(slopeService.findSlopesByItemId(id), HttpStatus.OK);
    }

    @RequestMapping(value = "/items/{id}/slopes/{slopeid}", method = RequestMethod.GET)
    public ResponseEntity<SlopeEntity> getSlopeByItemIdAndSlopeId(@PathVariable("id") String id, @PathVariable("slopeid") String slopeid){
        return new ResponseEntity<>(slopeService.findSlopeByItemIdAndSlopeId(id, slopeid), HttpStatus.OK);
    }
}
