/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package claudio.happyhour.model;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author claudio
 */
public class EventTest {
    
    Event e;
    Worker wk;
    Worker wk2;
    Item i;
    Item i2;
    
    @Before
    public void setUp() {
        e = new Event();
        e.setId(0);
        wk = new Worker("email@email.com", "claudio");
        wk.setId(0);
        wk2 = new Worker("email@email.com", "ThatGuy");
        wk2.setId(1);
        i = new Item("marshmallow", "2.50");
        i.setId(0);
        i2 = new Item("water", "1");
        i2.setId(1);
        e.setDate(new Date("jan-2-1999"));
        e.setUseStoredCash(false);
        
        Set<Item> its = new HashSet<>();
        its.add(i);
        its.add(i2);
        e.setItems(its);
        e.setTotalValue();
        
        Set<Worker> wks = new HashSet<>();
        wks.add(wk);
        wks.add(wk2);
        e.setWorkers(wks);
        
    }
    
    @After
    public void tearDown() {
        e = null;
        wk = null;
        wk2 = null;
        i = null;
        i2 = null;
    }
    @Test
    public void testSumOfItems(){
        assertEquals(new BigDecimal("3.50"), e.getTotalValue());
    }
   
}
