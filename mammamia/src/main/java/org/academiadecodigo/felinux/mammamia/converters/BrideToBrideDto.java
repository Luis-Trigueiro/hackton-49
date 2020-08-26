package org.academiadecodigo.felinux.mammamia.converters;

import org.academiadecodigo.felinux.mammamia.command.BrideDto;
import org.academiadecodigo.felinux.mammamia.persistence.model.Bride;

public class BrideToBrideDto extends AbstractConverter<Bride, BrideDto> {

    //private BirthdateConverter birthdateConverter;

    @Override
    public BrideDto convert(Bride bride) {

        BrideDto brideDto = new BrideDto();
        brideDto.setId(bride.getId());
        brideDto.setFirstName(bride.getFirstName());
        brideDto.setLastName(bride.getLastName());
        brideDto.setNickname(bride.getNickname());
        brideDto.setBirthDate(bride.getBirthDate());
        brideDto.setSex(bride.getSex());
        brideDto.setAboutMe(bride.getAboutMe());
        brideDto.setFavouriteSong(bride.getFavouriteSong());
        brideDto.setLocation(bride.getLocation());

        return brideDto;
    }

}
