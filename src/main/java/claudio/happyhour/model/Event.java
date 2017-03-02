/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package claudio.happyhour.model;

import claudio.happyhour.helper.CalendarDeserializer;
import claudio.happyhour.helper.CalendarSerializer;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.module.SimpleModule;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
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

    @JsonSerialize(using = CalendarSerializer.class)
    private Date date;
    private boolean useStoredCash;
    private BigDecimal totalValue;

    @ManyToMany
    @JoinTable(name = "event_worker", joinColumns = @JoinColumn(name = "event_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "worker_id", referencedColumnName = "id"))
    private Set<Worker> workers;

    @ManyToMany
    @JoinTable(name = "event_item", joinColumns = @JoinColumn(name = "event_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "item_id", referencedColumnName = "id"))
    private Set<Item> items;

    public void setWorkers(Set<Worker> workers) {
        this.workers = workers;
    }

    public void setItems(Set<Item> items) {
        this.items = items;
    }

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

    public void setTotalValue() {
        totalValue = BigDecimal.ZERO;
        for (Item i : getItems()) {
            BigDecimal totalPerItem = i.getPrice().multiply(new BigDecimal(i.getAmount()));
            totalValue = totalValue.add(totalPerItem);
        }
    }

    public BigDecimal getTotalValue() {
        return totalValue;
    }
    
    @Override
    public String toString(){
        ObjectMapper mapper = new ObjectMapper();
        SimpleModule dateModule = new SimpleModule();
        dateModule.addSerializer(Calendar.class, new CalendarSerializer());  
        dateModule.addDeserializer(Calendar.class,new CalendarDeserializer());
        mapper.registerModule(dateModule);
        
        String eventJson= "";
        try {
            eventJson = mapper.writeValueAsString(this);
        } catch (JsonProcessingException ex) {
            Logger.getLogger(Event.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return eventJson;
    }

    
}
