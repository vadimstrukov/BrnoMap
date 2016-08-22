package cz.brno.map.controller;

import cz.brno.map.model.LiftEntity;
import cz.brno.map.model.Path;
import cz.brno.map.responses.NotFoundException;
import cz.brno.map.service.PathService;
import cz.brno.map.utils.IValidator;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by strukov on 8/22/16.
 */
@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class PathController {

    @Inject
    private PathService pathService;
    @Inject
    private IValidator<Path> pathValidator;

    @ExceptionHandler(NotFoundException.class)
    @RequestMapping(value = "/paths/{id}", method = RequestMethod.GET)
    public ResponseEntity<Path> getById(@PathVariable("id") String id){
        return new ResponseEntity<>(pathValidator.validate(id, pathService.findById(id)), HttpStatus.OK);
    }

    @RequestMapping(value = "/paths/all", method = RequestMethod.GET)
    public ResponseEntity<List<Path>> getAll(){
        return new ResponseEntity<>(pathService.findAll(), HttpStatus.OK);
    }

    @RequestMapping(value = "/paths", method = RequestMethod.POST)
    public ResponseEntity<Path> save(@RequestBody Path path){
        return new ResponseEntity<>(pathService.save(path), HttpStatus.OK);
    }

}
