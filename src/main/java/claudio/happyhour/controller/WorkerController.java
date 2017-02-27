/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package claudio.happyhour.controller;

import claudio.happyhour.model.Worker;
import claudio.happyhour.repository.WorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author claudio
 */
@Controller
@RequestMapping(path = "/worker")
public class WorkerController {

    @Autowired

    private WorkerRepository wkRep;

    @GetMapping(path = "/add")
    public @ResponseBody
    String addNewWorker(@RequestParam String name, @RequestParam String email) {
        Worker wk = new Worker(email, name);
        wkRep.save(wk);
        return "Saved";
    }
    
    @GetMapping(path = "/all")
    public @ResponseBody Iterable<Worker> getAllWorkers(){
        return wkRep.findAll();
    }

}
