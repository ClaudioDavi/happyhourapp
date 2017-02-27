/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package claudio.happyhour.controller;

import claudio.happyhour.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 *
 * @author claudio
 */
@Controller
public class EventController {
    @Autowired
    
    EventRepository eventRep;
}
