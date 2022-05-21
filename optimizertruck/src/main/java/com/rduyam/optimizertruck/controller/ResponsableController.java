package com.rduyam.optimizertruck.controller;

import com.rduyam.optimizertruck.model.Centrale;
import com.rduyam.optimizertruck.model.Responsable;
import com.rduyam.optimizertruck.service.CentraleService;
import com.rduyam.optimizertruck.service.ResponsableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class ResponsableController {

    @Autowired
    private ResponsableService service;
    @Autowired
    CentraleService cService;

    @GetMapping("/responsables")
    public String afficherResponsables(Model model) {
        Iterable<Responsable> responsables = service.getAllResponsables();
        model.addAttribute("responsables", responsables);
        return "responsable/afficherResponsables";
    }

    @GetMapping("/responsable/{id}")
    public String afficherResponsable(@PathVariable("id") final Long id, Model model) {
        Responsable responsable = service.getResponsable(id);

        model.addAttribute("responsable", responsable);
        return "responsable/afficherResponsable";
    }

    @GetMapping("/createResponsable")
    public String createResponsable(Model modelResp, Model modelCent) {
        Responsable responsable = new Responsable();

        Iterable<Centrale> centrales = cService.getAllCentrales();
        modelResp.addAttribute("responsable", responsable);
        modelCent.addAttribute("centrales", centrales);
        return "responsable/formNewResponsable";
    }

    @GetMapping("/updateResponsable/{id}")
    public String updateResponsable(@PathVariable("id") final Long id, Model model) {
        Responsable responsable = service.getResponsable(id);
        model.addAttribute("responsable",responsable);
        return "responsable/formUpdateResponsable";
    }

    @GetMapping("/deleteResponsable/{id}")
    public ModelAndView deleteResponsable(@PathVariable("id") final Long id) {
        service.deleteResponsable(id);
        return new ModelAndView("redirect:/responsables");
    }

    @PostMapping("/saveResponsable")
    public ModelAndView saveResponsable(@ModelAttribute Responsable responsable) {
      if(responsable.getIdResponsable() != null) {
          Responsable current = service.getResponsable(responsable.getIdResponsable());
        }
        service.saveResponsable(responsable);
        return new ModelAndView("redirect:/responsable");
    }
}
