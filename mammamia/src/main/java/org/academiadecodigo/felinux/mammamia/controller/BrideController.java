package org.academiadecodigo.felinux.mammamia.controller;

import org.academiadecodigo.felinux.mammamia.command.BrideDto;
import org.academiadecodigo.felinux.mammamia.command.ProposalDto;
import org.academiadecodigo.felinux.mammamia.persistence.model.Bride;
import org.academiadecodigo.felinux.mammamia.services.BrideService;
import org.academiadecodigo.felinux.mammamia.services.ProposalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Controller responsible for rendering {@link Bride} related views
 */

@Controller
@RequestMapping("/bride")
public class BrideController {

    private BrideService brideService;
    private ProposalService proposalService;
    private BrideDto brideDto;
    private ProposalDto proposalDto;

    @Autowired
    public void setBrideService(BrideService brideService) {
        this.brideService = brideService;
    }

    @Autowired
    public void setProposalService(ProposalService proposalService) {
        this.proposalService = proposalService;
    }

    @Autowired
    public void setBrideDto(BrideDto brideDto) {
        this.brideDto = brideDto;
    }

    @Autowired
    public void setProposalDto(ProposalDto proposalDto) {
        this.proposalDto = proposalDto;
    }


    /**
     * Renders a view with a list of Brides
     *
     * @param model the model object
     * @return the view to render
     */
    @RequestMapping(method = RequestMethod.GET, path = {"/list", "/", ""})
    public String listBrides(Model model) {
        model.addAttribute("brides","returnDtoList");
        return "Bride/list";
    }
}
