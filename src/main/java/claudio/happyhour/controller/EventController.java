/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package claudio.happyhour.controller;

import claudio.happyhour.model.Event;

import claudio.happyhour.repository.EventRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;

/**
 *
 * @author claudio
 */
@RestController
@RequestMapping(path = "/event")
public class EventController {

    @Autowired
    EventRepository eventRep;

    @RequestMapping(path = "/add", method = RequestMethod.POST)
    public ResponseEntity<Void> createEvent(@RequestBody Event evt, UriComponentsBuilder ucBuilder) {

        eventRep.save(evt);

        HttpHeaders header = new HttpHeaders();
        header.setLocation(ucBuilder.path("/event/{id}").buildAndExpand(evt.getId()).toUri());

        return new ResponseEntity<>(header, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<Iterable<Event>> listAllEvents() {
        Iterable<Event> evts = eventRep.findAll();

        return new ResponseEntity<>(evts, HttpStatus.OK);

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Event> getEventById(@PathVariable("id") long id) {
        Event evt = eventRep.findOne(id);

        if (evt == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(evt, HttpStatus.OK);
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Event> updateEvent(@PathVariable("id") long id, @RequestBody Event evt) {
        Event currentEvent = eventRep.findOne(id);

        if (currentEvent == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        currentEvent.setDate(evt.getDate());
        currentEvent.setItems(evt.getItems());
        currentEvent.setUseStoredCash(evt.isUseStoredCash());
        currentEvent.setWorkers(evt.getWorkers());

        eventRep.save(currentEvent);

        return new ResponseEntity<>(currentEvent, HttpStatus.OK);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Event> deleteEvent(@PathVariable("id") long id) {
        Event evt = eventRep.findOne(id);

        if (evt == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        eventRep.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
