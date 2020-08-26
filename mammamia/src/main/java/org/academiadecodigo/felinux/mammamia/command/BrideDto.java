package org.academiadecodigo.felinux.mammamia.command;

import org.academiadecodigo.felinux.mammamia.persistence.model.variables.SexType;

import javax.validation.constraints.*;
import java.util.Date;

public class BrideDto {

    private Integer id;

    @NotNull(message = "First name is mandatory")
    @NotBlank(message = "First name is mandatory")
    @Size(min = 3, max = 64)
    private String firstName;

    @NotNull(message = "Last name is mandatory")
    @NotBlank(message = "Last name is mandatory")
    @Size(min = 3, max = 64)
    private String lastName;

    @NotNull(message = "Day of birth is mandatory")
    @NotBlank(message = "Day of birth is mandatory")
    private Date birthdate;

    @NotNull(message = "Sex is mandatory (phrasing)")
    @NotBlank(message = "Sex is mandatory (phrasing)")
    private SexType sex;

    private String aboutMe;
    private String favouriteSong;
    private String location;
}
