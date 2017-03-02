/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package claudio.happyhour.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.math.BigDecimal;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author claudio
 */
@Entity
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private int id;
    private String name;
    private BigDecimal price;
    private int amount;

    public Item(String nam, String pric) {
        setValidPrice(pric);
        name = nam;
        amount = 1;
    }

    public Item() {
        amount = 1;
        setPrice(BigDecimal.ZERO);
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    private void setPrice(BigDecimal newPrice) {
        price = newPrice;
    }

    public boolean setValidPrice(String price) {
        try {
            BigDecimal pric = new BigDecimal(price);
            if (pric.signum() >= 0) {
                setPrice(pric);
                return true;
            }
            return false;

        } catch (NumberFormatException nb) {
            System.out.println("Not a number");
            return false;
        }

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }
    @Override
    public String toString(){
        ObjectMapper mapper = new ObjectMapper();
        String itemJson= "";
        try {
            itemJson = mapper.writeValueAsString(this);
        } catch (JsonProcessingException ex) {
            Logger.getLogger(Event.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return itemJson;
    }
}
