package org.academiadecodigo.felinux.mammamia.services;

import org.academiadecodigo.felinux.mammamia.persistence.model.Proposal;

public interface ProposalService {
    Proposal get (Integer id);
    void delete (Integer id);
}

