package cz.brno.map.controller;

import cz.brno.map.model.ItemEntity;
import cz.brno.map.service.ItemService;
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
 * Created by strukov on 6/29/16.
 */

// Controller that interacts with entire Items

// MediaType for getting JSON anywhere
@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class ItemController {

    @Inject
    private ItemService itemService;

    // Method for getting specific Item by his ID
    @RequestMapping(value = "/items/{id}", method = RequestMethod.GET)
    public ResponseEntity<ItemEntity> getById(@PathVariable("id") String id){
        return new ResponseEntity<>(itemService.findById(id), HttpStatus.OK);
    }

    // Method for getting all Items -> List with Item entities
    @RequestMapping(value = "/items/all", method = RequestMethod.GET)
    public ResponseEntity<List<ItemEntity>> getAll(){
        return new ResponseEntity<>(itemService.findAll(), HttpStatus.OK);
    }

}
