package org.academiadecodigo.felinux.mammamia.controller;

import org.academiadecodigo.felinux.mammamia.command.BrideDto;
import org.academiadecodigo.felinux.mammamia.command.ProposalDto;
import org.academiadecodigo.felinux.mammamia.services.BrideService;
import org.academiadecodigo.felinux.mammamia.services.ProposalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping
public class ProposalController {

    private BrideService brideService;
    private ProposalService proposalService;
    private BrideDto brideDto;
    private ProposalDto proposalDto;


    /**
     * Sets the customer service
     *
     * @param brideService the customer service to set
     */
    @Autowired
    public void setBrideService(BrideService brideService) {
        this.brideService = brideService;
    }

    @Autowired
    public void setProposalService(ProposalService proposalService) {
        this.proposalService = proposalService;
    }

    @Autowired
    public void setBrideDto(BrideDto brideDto){
        this.brideDto = brideDto;
    }

    @Autowired
    public void setProposalDto(ProposalDto proposalDto){
        this.proposalDto = proposalDto;
    }

    public String initProposal(){
        return "";
    }

    public String sendProposal(){
        return "";
    }

}
