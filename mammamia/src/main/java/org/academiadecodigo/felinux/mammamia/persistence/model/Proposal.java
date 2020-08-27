package org.academiadecodigo.felinux.mammamia.persistence.model;

import javax.persistence.*;

/**
 * A generic account model entity to be used as a base for concrete types of accounts
 */
@Entity
@Table(name = "proposal")
public class Proposal extends AbstractModel {

    @ManyToOne
    private Bride bride;

    private String fullName;
    private String email;
    private String message;

    public Bride getBride() {
        return bride;
    }

    public void setBride(Bride bride) {
        this.bride = bride;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
