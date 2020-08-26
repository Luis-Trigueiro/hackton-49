package org.academiadecodigo.felinux.mammamia.converters;

import org.academiadecodigo.felinux.mammamia.command.ProposalDto;
import org.academiadecodigo.felinux.mammamia.persistence.model.Proposal;

public class ProposalToProposalDto extends AbstractConverter<Proposal, ProposalDto> {


    @Override
    public ProposalDto convert(Proposal proposal) {

        ProposalDto proposalDto = new ProposalDto();
        proposalDto.setId(proposal.getId());
        proposalDto.setFullName(proposal.getFullName());
        proposalDto.setEmail(proposal.getEmail());
        proposalDto.setMessage(proposal.getMessage());


        return proposalDto;
    }


}
