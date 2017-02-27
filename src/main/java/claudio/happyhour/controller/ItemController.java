/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package claudio.happyhour.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import claudio.happyhour.model.Item;
import claudio.happyhour.repository.ItemRepository;
/**
 *
 * @author claudio
 */
@Controller
@RequestMapping(path="/item")
public class ItemController {
    @Autowired
    
    private ItemRepository itRep;
    
    @GetMapping(path="/add")
    public @ResponseBody String addNewItem(@RequestParam String name, @RequestParam String price){
        Item it = new Item(name, price);
        itRep.save(it);
        return "Saved";
    }
    @GetMapping(path="/all")
	public @ResponseBody Iterable<Item> getAllItems() {
		return itRep.findAll();
	}
    
    
}
