package org.academiadecodigo.felinux.mammamia.converters;

import org.academiadecodigo.felinux.mammamia.command.BrideDto;
import org.academiadecodigo.felinux.mammamia.persistence.model.Bride;
import org.academiadecodigo.felinux.mammamia.services.BrideService;
import org.springframework.beans.factory.annotation.Autowired;

public class BrideDtoToBride extends AbstractConverter<BrideDto, Bride> {

    private BrideService brideService;
    private BirthdateConverter birthdateConverter;

    @Autowired
    public void setBrideService(BrideService brideService) {
        this.brideService = brideService;
    }


    @Override
    public Bride convert(BrideDto brideDto) {

        Bride bride = (brideDto.getId() != null ? brideService.get(brideDto.getId()) : new Bride());

        bride.setFirstName(brideDto.getFirstName());
        bride.setLastName(brideDto.getLastName());
        bride.setNickname(brideDto.getNickname());
        bride.setBirthDate(birthdateConverter.birthDateToDate(brideDto.getBirthDate()));
        bride.setSex(brideDto.getSex());
        bride.setAboutMe(brideDto.getAboutMe());
        bride.setFavouriteSong(brideDto.getFavouriteSong());
        bride.setLocation(brideDto.getLocation());


        return bride;
    }
}
