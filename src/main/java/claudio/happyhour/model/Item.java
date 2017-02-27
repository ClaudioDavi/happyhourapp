/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package claudio.happyhour.model;

import java.math.BigDecimal;
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

    public Item(String nam, String pric) {
        setValidPrice(pric);
        name = nam;
    }

    public Item() {
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
}
