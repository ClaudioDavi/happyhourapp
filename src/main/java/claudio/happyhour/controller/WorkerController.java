/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package claudio.happyhour.controller;

import claudio.happyhour.model.Worker;
import claudio.happyhour.repository.WorkerRepository;
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
@RequestMapping(path = "/worker")
public class WorkerController {

    @Autowired

    private WorkerRepository wkRep;

    @RequestMapping(path = "/add", method = RequestMethod.POST)
    public ResponseEntity<Void> createWorker(@RequestBody Worker wk, UriComponentsBuilder ucBuilder) {
        wkRep.save(wk);

        
        HttpHeaders header = new HttpHeaders();
        header.setLocation(ucBuilder.path("worker/{id}").buildAndExpand(wk.getId()).toUri());

        return new ResponseEntity<>(header, HttpStatus.CREATED);
    }

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public ResponseEntity<Iterable<Worker>> getAllWorkers() {
       Iterable<Worker> wks = wkRep.findAll();
       
      return new ResponseEntity<>(wks , HttpStatus.OK);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Worker> getWorkerById(@PathVariable("id")long id){
        Worker wk = wkRep.findOne(id);
        
        if(wk == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        
        return new ResponseEntity<>(wk, HttpStatus.OK);
    }
    
    @RequestMapping(path = "/update/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Worker> updateWorker(@PathVariable("id") long id, @RequestBody Worker wk) {
       Worker currentWk = wkRep.findOne(id);
        if(currentWk == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        currentWk.setName(wk.getName());
        currentWk.setValidatedEmail(wk.getEmail());
        
        wkRep.save(currentWk);
        
        return new ResponseEntity<>(currentWk, HttpStatus.OK);
    }
    
    @RequestMapping(path = "/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Worker> deleteWorker(@PathVariable("id") long id) {
        Worker wk = wkRep.findOne(id);
        
        if(wk == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        wkRep.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        
    }
}
