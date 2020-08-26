package org.academiadecodigo.felinux.mammamia.command;

import org.academiadecodigo.felinux.mammamia.persistence.model.Bride;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class ProposalDto {

    private Bride bride;

    @NotNull(message = "Full name is mandatory")
    @NotBlank(message = "Full name is mandatory")
    @Size(min = 3, max = 64)
    private String fullName;

    @Email
    @NotBlank(message = "Email is mandatory")
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
