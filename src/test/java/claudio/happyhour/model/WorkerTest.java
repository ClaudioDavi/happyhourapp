/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package claudio.happyhour.model;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author claudio
 */
public class WorkerTest {

    Worker wk;

    @Before
    public void setUp() {
        wk = new Worker("claudio@email.com", "claudio");

    }

    @After
    public void tearDown() {
        wk = null;
    }

   @Test
   public void setValidContribution(){
       assertTrue(wk.setValidContribution("10"));
   }
   @Test
   public void setInvalidContribution(){
       assertFalse(wk.setValidContribution("cc"));
   }
   
   @Test
   public void setValidContribuion(){
       assertTrue(wk.setValidContribution("0"));
   }

}
