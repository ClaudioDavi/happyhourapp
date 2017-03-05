/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package claudio.happyhour.helper;

import static junit.framework.TestCase.assertEquals;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author claudio
 */
public class EmailValidatorTest {

    EmailValidator emailValidator;

    @Before
    public void setUp() {
        emailValidator = EmailValidator.getInstance();
    }

    @After
    public void tearDown() {
        emailValidator = null;
    }

    @Test
    public void testValidateEmailRight() {
        System.out.println("validate with right email");

        String userEmail = "rightemail@email.com";
        boolean expResult = true;
        boolean result = emailValidator.validate(userEmail);

        assertEquals(expResult, result);

    }

    @Test
    public void testValidateEmailOnlyNumber() {
        System.err.println("not validated only numbers email");
        String userEmail = "123451243";

        boolean expResult = false;

        boolean result = emailValidator.validate(userEmail);

        assertEquals(expResult, result);
    }

    @Test
    public void testValidateEmailNotDotCom() {
        System.err.println("not validated because not .com at end");
        String userEmail = "claudio@email";

        boolean expResult = false;

        boolean result = emailValidator.validate(userEmail);

        assertEquals(expResult, result);
    }

    @Test
    public void testValidateEmailNotAt() {
        System.err.println("not validated because not @");
        String userEmail = "claudioemail.com";

        boolean expResult = false;

        boolean result = emailValidator.validate(userEmail);

        assertEquals(expResult, result);
    }

    @Test
    public void testValidateEmailEmpty() {
        System.err.println("not validated because non existent string");
        String userEmail = "";

        boolean expResult = false;

        boolean result = emailValidator.validate(userEmail);

        assertEquals(expResult, result);
    }

}
