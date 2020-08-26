package org.academiadecodigo.felinux.mammamia.converters;

import java.util.Calendar;
import java.util.Date;

public class BirthdateConverter {

    public Date birthDateConvert(String birthDate) {

        int day = Integer.parseInt(birthDate.substring(0,2));
        int month = Integer.parseInt(birthDate.substring(3,5));
        int year = Integer.parseInt(birthDate.substring(6));

        return new Date(year, month, day);
    }
}
