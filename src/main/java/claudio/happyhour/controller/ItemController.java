/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package claudio.happyhour.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import claudio.happyhour.model.Item;
import claudio.happyhour.repository.ItemRepository;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

/**
 *
 * @author claudio
 */
@RestController
@RequestMapping(path = "/item")
public class ItemController {

    @Autowired
    private ItemRepository itRep;

    @RequestMapping(path = "/add", method = RequestMethod.POST)
    public ResponseEntity<Void> addNewItem(@RequestBody Item it, UriComponentsBuilder ucBuilder) {
        itRep.save(it);

        HttpHeaders header = new HttpHeaders();

        header.setLocation(ucBuilder.path("item/{id}").buildAndExpand(it.getId()).toUri());

        return new ResponseEntity<>(header, HttpStatus.CREATED);
    }

    @RequestMapping(path = "/all", method = RequestMethod.GET)
    public ResponseEntity<Iterable<Item>> getAllItems() {
        Iterable<Item> items = itRep.findAll();

        return new ResponseEntity<>(items, HttpStatus.OK);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Item> getItemById(@PathVariable("id") long id) {
        Item it = itRep.findOne(id);

        if (it == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(it, HttpStatus.OK);
    }

    @RequestMapping(path = "/update/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Item> updateItem(@PathVariable("id") long id, @RequestBody Item it) {
        Item currentIt = itRep.findOne(id);

        if (currentIt == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        currentIt.setAmount(it.getAmount());
        currentIt.setName(it.getName());
        currentIt.setValidPrice(it.getPrice().toString());

        itRep.save(currentIt);

        return new ResponseEntity<>(currentIt, HttpStatus.OK);
    }

    @RequestMapping(path = "/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Item> deleteItem(@PathVariable("id") long id) {
        Item it = itRep.findOne(id);

        if (it == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        itRep.delete(it);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
