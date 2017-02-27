/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package claudio.happyhour.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

/**
 *
 * @author claudio
 */
@Entity
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    
    private int id;

    private Date date;
    private boolean useStoredCash;
    private BigDecimal totalValue;
    
    
    
    @ManyToMany
    @JoinTable(name = "event_worker", joinColumns = @JoinColumn(name = "event_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "worker_id", referencedColumnName = "id"))
    private Set<Worker> workers;
    
    @ManyToMany
    @JoinTable(name = "event_item", joinColumns = @JoinColumn(name = "event_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "item_id", referencedColumnName = "id"))
    private Set<Item> items;

    public Set<Worker> getWorkers() {
        return workers;
    }
    public Set<Item> getItems() {
        return items;
    }
    
     public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public boolean isUseStoredCash() {
        return useStoredCash;
    }

    public void setUseStoredCash(boolean useStoredCash) {
        this.useStoredCash = useStoredCash;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public void setTotalValue(){
        totalValue = BigDecimal.ZERO;
        for(Item i : getItems()) {
            BigDecimal totalPerItem = i.getPrice().multiply(new BigDecimal(i.getAmount()));
            totalValue.add(totalPerItem);
        }
    }
    
    public BigDecimal getTotalValue(){
        return totalValue;
    }
}
