package org.academiadecodigo.felinux.mammamia.controller;

import org.academiadecodigo.felinux.mammamia.command.BrideDto;
import org.academiadecodigo.felinux.mammamia.command.ProposalDto;
import org.academiadecodigo.felinux.mammamia.converters.BrideDtoToBride;
import org.academiadecodigo.felinux.mammamia.converters.BrideToBrideDto;
import org.academiadecodigo.felinux.mammamia.converters.ProposalToProposalDto;
import org.academiadecodigo.felinux.mammamia.persistence.model.Bride;
import org.academiadecodigo.felinux.mammamia.services.BrideService;
import org.academiadecodigo.felinux.mammamia.services.ProposalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

/**
 * Controller responsible for rendering {@link Bride} related views
 */

@Controller
@RequestMapping("/bride")
public class BrideController {

    private BrideService brideService;
    private BrideDtoToBride brideDtoToBride;
    private BrideToBrideDto brideToBrideDto;
    private ProposalToProposalDto proposalToProposalDto;

    @Autowired
    public void setBrideService(BrideService brideService) {
        this.brideService = brideService;
    }

    @Autowired
    public void setBrideDtoToBride(BrideDtoToBride brideDtoToBride) {
        this.brideDtoToBride = brideDtoToBride;
    }

    @Autowired
    public void setBrideToBrideDto(BrideToBrideDto brideToBrideDto) {
        this.brideToBrideDto = brideToBrideDto;
    }

    @Autowired
    public void setProposalToProposalDto(ProposalToProposalDto proposalToProposalDto) {
        this.proposalToProposalDto = proposalToProposalDto;
    }

    /**
     * Renders a view with a list of Brides
     *
     * @param model the model object
     * @return the view to render
     */
    @RequestMapping(method = RequestMethod.GET, path = {"/list", "/", ""})
    public String listBrides(Model model) {
        model.addAttribute("brides", brideToBrideDto.convert(brideService.listAll()));
        return "bride/list";
    }

    /**
     * Create a Bride
     *
     * @param model the model object
     * @return the view to render
     */
    @RequestMapping(method = RequestMethod.GET, path = "/add")
    public String addBride(Model model) {
        model.addAttribute("bride", new BrideDto());
        return "bride/add-update";
    }

    /**
     * Edits a Bride
     *
     * @param id    the Bride id
     * @param model the model object
     * @return the view to render
     */
    @RequestMapping(method = RequestMethod.GET, path = "/{id}/edit")
    public String editBride(@PathVariable Integer id, Model model) {
        model.addAttribute("bride",brideToBrideDto.convert(brideService.get(id)));
        return "bride/add-update";
    }

    /**
     * Renders a view with bride details
     *
     * @param id    the bride id
     * @param model the model object
     * @return the view to render
     * @throws Exception
     */
    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    public String showBride(@PathVariable Integer id, Model model) throws Exception {

        model.addAttribute("bride", brideToBrideDto.convert(brideService.get(id)));
        model.addAttribute("proposal",proposalToProposalDto.convert(brideService.listProposal(id)));
        return "bride/show";
    }

}
