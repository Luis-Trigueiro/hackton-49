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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public SexType getSex() {
        return sex;
    }

    public void setSex(SexType sex) {
        this.sex = sex;
    }

    public String getAboutMe() {
        return aboutMe;
    }

    public void setAboutMe(String aboutMe) {
        this.aboutMe = aboutMe;
    }

    public String getFavouriteSong() {
        return favouriteSong;
    }

    public void setFavouriteSong(String favouriteSong) {
        this.favouriteSong = favouriteSong;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
