/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package claudio.happyhour.model;

import claudio.happyhour.helper.EmailValidator;
import java.math.BigDecimal;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

/**
 *
 * @author claudio
 */
@Entity
public class Worker {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String email;
    private String name;
    private BigDecimal monthlyContribution;

    @Transient
    private EmailValidator validator = EmailValidator.getInstance();

    public Worker() {

    }

    public Worker(String email, String name) {
        if (setValidatedEmail(email)) {
            setName(name);
            setValidContribution("0");
        }
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    private void setEmail(String email) {

        this.email = email;
    }

    /**
     * Checks the business rules of writing an email.
     *
     * @param emailAttempt
     * @return true if email is valid, false if not
     */
    public boolean setValidatedEmail(String emailAttempt) {
        if (validator.validate(emailAttempt)) {
            setEmail(emailAttempt);
            return true;
        }
        return false;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getMonthlyContribution() {
        return monthlyContribution;
    }

    public boolean setValidContribution(String contrib) {
        try {
            BigDecimal cont = new BigDecimal(contrib);
            if (cont.signum() >= 0) {
                setMonthlyContribution(cont);
                return true;
            }
            return false;

        } catch (NumberFormatException nb) {
            System.out.println("Not a number");
            return false;
        }

    }

    private void setMonthlyContribution(BigDecimal monthlyContribution) {
        this.monthlyContribution = monthlyContribution;
    }

}
