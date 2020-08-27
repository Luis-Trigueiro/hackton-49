package org.academiadecodigo.felinux.mammamia.command;


import org.academiadecodigo.felinux.mammamia.persistence.model.variables.SexType;
import org.springframework.stereotype.Component;

import javax.validation.constraints.*;

@Component
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

    @NotNull(message = "Nickname is mandatory")
    @NotBlank(message = "Nickname is mandatory")
    private String nickname;

    @NotNull(message = "Day of birth is mandatory")
    @NotBlank(message = "Day of birth is mandatory")
    private String birthDate;

    @NotNull(message = "Sex is mandatory (phrasing)")
    @NotBlank(message = "Sex is mandatory (phrasing)")
    private String sex;

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

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
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
