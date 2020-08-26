package org.academiadecodigo.felinux.mammamia.converters;

import org.academiadecodigo.felinux.mammamia.command.ProposalDto;
import org.academiadecodigo.felinux.mammamia.persistence.model.Proposal;
import org.academiadecodigo.felinux.mammamia.services.BrideService;
import org.academiadecodigo.felinux.mammamia.services.ProposalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProposalDtoToProposal extends AbstractConverter<ProposalDto, Proposal> {

    private ProposalService proposalService;

    @Autowired
    public void setBrideService(ProposalService proposalService) {
        this.proposalService = proposalService;
    }


    @Override
    public Proposal convert(ProposalDto proposalDto) {

        Proposal proposal = (proposalDto.getBride() != null ? proposalService.get(proposalDto.getBride().getId()) : new Proposal());

        proposal.setFullName(proposalDto.getFullName());
        proposal.setEmail(proposalDto.getEmail());
        proposal.setMessage(proposalDto.getMessage());


        return proposal;
    }
}

