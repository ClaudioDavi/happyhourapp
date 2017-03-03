/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package claudio.happyhour.controller;

import claudio.happyhour.model.Cash;
import claudio.happyhour.repository.CashRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

/**
 *
 * @author claudio
 */
@RestController
@RequestMapping(path = "/cash")
public class CashController {

    @Autowired

    CashRepository cashRep;

    @RequestMapping(path = "/add", method = RequestMethod.POST)
    public ResponseEntity<Void> addNewCash(@RequestBody Cash ch, UriComponentsBuilder ucBuilder) {
        cashRep.save(ch);

        HttpHeaders header = new HttpHeaders();
        header.setLocation(ucBuilder.path("/cash/{id}").buildAndExpand(ch.getId()).toUri());

        return new ResponseEntity<>(header, HttpStatus.CREATED);
    }

    @RequestMapping(path = "/all", method = RequestMethod.GET)
    public ResponseEntity<Iterable<Cash>> getAllCash() {
        Iterable<Cash> chs = cashRep.findAll();

        return new ResponseEntity<>(chs, HttpStatus.OK);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Cash> getCashById(@PathVariable("id") long id) {
        Cash ch = cashRep.findOne(id);

        if (ch == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(ch, HttpStatus.OK);
    }

    @RequestMapping(path = "/update/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Cash> updateCash(@PathVariable("id") long id, @RequestBody Cash ch) {
        Cash currentCash = cashRep.findOne(id);
        if (currentCash == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        currentCash.setValue(ch.getValue());

        cashRep.save(currentCash);

        return new ResponseEntity<>(currentCash, HttpStatus.OK);
    }

    @RequestMapping(path = "/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Cash> deleteCash(@PathVariable("id") long id) {
        Cash ch = cashRep.findOne(id);
        if (ch == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        cashRep.delete(ch);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
