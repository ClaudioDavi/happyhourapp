/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package claudio.happyhour.controller;

import claudio.happyhour.repository.CashRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author claudio
 */
@Controller
@RequestMapping(path="/cash")
public class CashController {
    @Autowired
    
    CashRepository cashRep;
    
    

}
