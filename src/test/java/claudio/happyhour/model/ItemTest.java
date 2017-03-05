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
public class ItemTest {

    Item it;

    @Before
    public void setUp() {
        it = new Item("apple", "2");
        it.setAmount(3);
    }

    @After
    public void tearDown() {
        it = null;
    }

    @Test
    public void testCheckValidPrice() {
        assertTrue(it.setValidPrice("2.5"));
        System.out.println(it.toString());
    }

    @Test
    public void testCheckInvalidPrice() {
        assertFalse(it.setValidPrice("-25"));
        System.out.println(it.toString());
    }

    @Test
    public void TestFreeItem() {
        assertTrue(it.setValidPrice("0"));
        System.out.println(it.toString());
    }

    @Test
    public void testWrittenPrice() {
        assertFalse(it.setValidPrice("zero"));
        System.out.println(it.toString());
    }
}
