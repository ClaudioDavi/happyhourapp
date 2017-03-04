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
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author claudio
 */
@Entity
public class Cash {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private BigDecimal total;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "worker_id")
    private Worker worker;

    public Worker getWorker() {
        return worker;
    }

    public void setWorker(Worker wk) {
        worker = wk;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BigDecimal getValue() {
        return total;
    }

    public boolean checkValidTotal(String total) {

        try {
            BigDecimal value = new BigDecimal(total);
            if (value.signum() >= 0) {
                setValue(value);
                return true;
            }
            return false;

        } catch (NumberFormatException nb) {
            System.out.println("Not a number");
            return false;
        }
    }

    public void setValue(BigDecimal value) {
        if (value.compareTo(BigDecimal.ZERO) >= 0) {
            this.total = value;
        }
    }

    @Override
    public String toString() {
        ObjectMapper mapper = new ObjectMapper();
        String cashJson = "";
        try {
            cashJson = mapper.writeValueAsString(this);
        } catch (JsonProcessingException ex) {
            Logger.getLogger(Event.class.getName()).log(Level.SEVERE, null, ex);
        }

        return cashJson;
    }
}
