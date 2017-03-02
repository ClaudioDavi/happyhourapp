/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package claudio.happyhour.helper;

import java.util.regex.Pattern;

/**
 *
 * @author claudio
 */
public class EmailValidator {
    private static EmailValidator instance = null;

    protected EmailValidator() {
        pattern = Pattern.compile(EMAIL);

    }

    public static EmailValidator getInstance() {
        if (instance == null) {
            instance = new EmailValidator();
        }
        return instance;
    }

    private Pattern pattern;

    private static final String EMAIL = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";


    public boolean validate(String userEmail) {
        return pattern.matcher(userEmail).matches();
    }
}
