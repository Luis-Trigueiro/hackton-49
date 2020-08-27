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
        model.addAttribute("proposals",proposalToProposalDto.convert(brideService.listProposal(id)));
        return "bride/show";
    }


    /**
     * Saves the bride form submission and renders a view
     *
     * @param brideDto        the customer DTO object
     * @param bindingResult      the binding result object
     * @param redirectAttributes the redirect attributes object
     * @return the view to render
     */
    @RequestMapping(method = RequestMethod.POST, path = {"/", ""}, params = "action=save")
    public String saveCustomer(@Valid @ModelAttribute("bride") BrideDto brideDto, BindingResult bindingResult, RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            return "bride/add-update";
        }

        Bride savedBride = brideService.save(brideDtoToBride.convert(brideDto));

        redirectAttributes.addFlashAttribute("lastAction", "Saved " + savedBride.getFirstName() + " " + savedBride.getLastName());
        return "redirect:/bride/" + savedBride.getId();
    }

    /**
     * Cancels the bride submission and renders the default the bride view
     *
     * @return the view to render
     */
    @RequestMapping(method = RequestMethod.POST, path = {"/", ""}, params = "action=cancel")
    public String cancelSaveBride() {
        // we could use an anchor tag in the view for this, but we might want to do something clever in the future here
        return "redirect:/bride/";
    }

    /**
     * Deletes the bride and renders the default bride view
     *
     * @param id                 the customer id
     * @param redirectAttributes the redirect attributes object
     * @return the view to render
     */
    @RequestMapping(method = RequestMethod.GET, path = "{id}/delete")
    public String deleteCustomer(@PathVariable Integer id, RedirectAttributes redirectAttributes){
        Bride bride = brideService.get(id);
        brideService.delete(id);
        redirectAttributes.addFlashAttribute("lastAction", "Deleted " + bride.getFirstName() + " " + bride.getLastName());
        return "redirect:/bride";
    }

}
