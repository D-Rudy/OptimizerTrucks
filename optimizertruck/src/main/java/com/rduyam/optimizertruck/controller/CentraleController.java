package com.rduyam.optimizertruck.controller;


import com.rduyam.optimizertruck.model.Centrale;
import com.rduyam.optimizertruck.service.CentraleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CentraleController {

    @Autowired
    private CentraleService service;

 @GetMapping("/centrales")
 /*   @RequestMapping(value="centrales", method = RequestMethod.GET)*/
    public String afficherCentrales(Model model) {
        Iterable<Centrale> centrales = service.getAllCentrales();
        model.addAttribute("centrales", centrales);
        return "centrale/afficherCentrales";
    }

    @GetMapping("/centrale/{id}")
    public String afficherCentrale(@PathVariable("id") final Long id, Model model) {
        Centrale centrale = service.getCentrale(id);
        model.addAttribute("centrale", centrale);
        return "centrale/afficherCentrale";
    }

    @GetMapping("/createCentrale")
    public String createCentrale(Model model) {
        Centrale centrale = new Centrale();
        model.addAttribute("centrale", centrale);
        return "centrale/formNewCentrale";
    }

    @GetMapping("/updateCentrale/{id}")
    public String updateCentrale(@PathVariable("id") final Long id, Model model) {
        Centrale centrale = service.getCentrale(id);
        model.addAttribute("centrale",centrale);
        return "centrale/formUpdateCentrale";
    }

    @GetMapping("/deleteCentrale/{id}")
    public ModelAndView deleteCentrale(@PathVariable("id") final Long id) {
        service.deleteCentrale(id);
        return new ModelAndView("redirect:/centrales");
    }

    @PostMapping("/saveCentrale")
    public ModelAndView saveCentrale(@ModelAttribute Centrale centrale) {
 /*       if(centrale.getIdCentrale() != null) {
            Centrale current = service.getCentrale(centrale.getIdCentrale());
        }*/
        service.saveCentrale(centrale);
        return new ModelAndView("redirect:/centrales");
    }

}
