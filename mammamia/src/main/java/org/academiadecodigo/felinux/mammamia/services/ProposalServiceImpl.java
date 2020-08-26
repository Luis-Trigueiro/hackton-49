package org.academiadecodigo.felinux.mammamia.services;

import org.academiadecodigo.felinux.mammamia.persistence.model.Proposal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProposalServiceImpl implements ProposalService {

    ProposalService proposalService;

    @Autowired
    public void setProposalService(ProposalService proposalService) {
        this.proposalService = proposalService;
    }

    @Override
    public Proposal get(Integer id) {
        return proposalService.get(id);
    }
}
