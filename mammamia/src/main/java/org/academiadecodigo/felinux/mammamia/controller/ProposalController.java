package org.academiadecodigo.felinux.mammamia.controller;


import org.academiadecodigo.felinux.mammamia.converters.BrideDtoToBride;
import org.academiadecodigo.felinux.mammamia.converters.BrideToBrideDto;
import org.academiadecodigo.felinux.mammamia.converters.ProposalDtoToProposal;
import org.academiadecodigo.felinux.mammamia.converters.ProposalToProposalDto;
import org.academiadecodigo.felinux.mammamia.persistence.model.Bride;
import org.academiadecodigo.felinux.mammamia.persistence.model.Proposal;
import org.academiadecodigo.felinux.mammamia.services.BrideService;
import org.academiadecodigo.felinux.mammamia.services.ProposalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;


@Controller
@RequestMapping("/bride")
public class ProposalController {

    private BrideService brideService;
    private ProposalService proposalService;
    private ProposalDtoToProposal proposalDtoToProposal;
    private ProposalToProposalDto proposalToProposalDto;
    private BrideToBrideDto brideToBrideDto;
    private BrideDtoToBride brideDtoToBride;


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
    public void setProposalDtoToProposal(ProposalDtoToProposal proposalDtoToProposal) {
        this.proposalDtoToProposal = proposalDtoToProposal;
    }

    @Autowired
    public void setProposalToProposalDto(ProposalToProposalDto proposalToProposalDto) {
        this.proposalToProposalDto = proposalToProposalDto;
    }

    @Autowired
    public void setBrideToBrideDto(BrideToBrideDto brideToBrideDto) {
        this.brideToBrideDto = brideToBrideDto;
    }

    @Autowired
    public void setBrideDtoToBride(BrideDtoToBride brideDtoToBride) {
        this.brideDtoToBride = brideDtoToBride;
    }


    @RequestMapping(method = RequestMethod.GET, path = "{id}/proposal")
    public String listProposal (@PathVariable Integer id, Model model){


               List<Proposal> proposals = brideService.listProposal(id);
               Bride bride = brideService.get(id);

               model.addAttribute("proposals", proposalToProposalDto.convert(proposals));
               model.addAttribute("bride", brideToBrideDto.convert(bride));

                return "proposal/list";
        }


    @RequestMapping(method = RequestMethod.GET, path = "/addProposal")
    public String addProposal (Model model){
        model.addAttribute("proposal", new Proposal());
        return "proposal/add";
    }


    @RequestMapping(method = RequestMethod.GET, path = "/{id}/deleteProposal")
    public String deleteProposal (@PathVariable Integer id, Model model){
        Proposal proposal = proposalService.get(id);
        proposalService.delete(id);
        model.addAttribute("delete", proposal);
        return "proposal/delete";
    }




}

