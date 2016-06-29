package cz.brno.map.controller;

import cz.brno.map.model.ItemEntity;
import cz.brno.map.service.ItemService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by strukov on 6/29/16.
 */

@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class ItemController {

    @Inject
    private ItemService itemService;

    @RequestMapping(value = "/items", method = RequestMethod.GET)
    public ResponseEntity<ItemEntity> getById(@RequestParam(value = "id") String id){
        return new ResponseEntity<>(itemService.findById(id), HttpStatus.OK);
    }

    @RequestMapping(value = "/items/all", method = RequestMethod.GET)
    public ResponseEntity<List<ItemEntity>> getAll(){
        return new ResponseEntity<>(itemService.findAll(), HttpStatus.OK);
    }
}
