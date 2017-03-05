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
public class CashTest {

    Cash cash;

    @Before
    public void setUp() {
        cash = new Cash();
        cash.setId(1);
        cash.checkValidTotal("200");
        cash.setWorker(new Worker("claudio@email.com", "claudio"));

    }

    @After
    public void tearDown() {
        cash = null;
    }

    @Test
    public void testValidTotalCheck() {
        assertTrue(cash.checkValidTotal("200"));
    }

    @Test
    public void testInvalidTOtalCheck() {
        assertFalse(cash.checkValidTotal("duzentos"));
    }

    @Test
    public void testValidTotalCheckWitZero() {
        assertTrue(cash.checkValidTotal("0"));
    }

    @Test
    public void testInbalidTotalCheckWitZero() {
        assertFalse(cash.checkValidTotal("-10"));
    }
}
