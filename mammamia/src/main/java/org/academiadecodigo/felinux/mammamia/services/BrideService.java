package org.academiadecodigo.felinux.mammamia.services;

import org.academiadecodigo.felinux.mammamia.persistence.model.Bride;
import org.academiadecodigo.felinux.mammamia.persistence.model.Proposal;

import java.util.List;

public interface BrideService {

    Bride get (Integer id);

    void saveBride (Bride bride);

    List<Bride> listAll ();

    void delete (Integer id);

    List<Proposal> listProposal (Integer id);

    Proposal addProposal (Integer id, Proposal proposal);

    Bride save(Bride bride);
}
