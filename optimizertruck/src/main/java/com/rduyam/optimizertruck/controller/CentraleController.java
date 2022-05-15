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
    public String home(Model model) {
        Iterable<Centrale> centrales = service.getAllCentrales();
        model.addAttribute("centrales", centrales);
        return "Accueil";
    }

    @GetMapping("/createCentrale")
    public String createCentrale(Model model) {
        Centrale centrale = new Centrale();
        model.addAttribute("centrale", centrale);
        return "formNewCentrale";
    }

    @GetMapping("/updateCentrale/{id}")
    public String updateCentrale(@PathVariable("id") final String id, Model model) {
        Centrale centrale = service.getCentrale(id);
        model.addAttribute("centrale",centrale);
        return "formUpdateCentrale";
    }

    @GetMapping("/deleteCentrale/{id}")
    public ModelAndView deleteCentrale(@PathVariable("id") final String id) {
        service.deleteCentrale(id);
        return new ModelAndView("redirect:/");
    }

    @PostMapping("/saveCentrale")
    public ModelAndView saveCentrale(@ModelAttribute Centrale centrale) {
/*        if(centrale.getId() != null) {
            // Employee from update form has the password field not filled,
            // so we fill it with the current password.
            Centrale current = service.getCentrale(centrale.getId());
            centrale.setPassword(current.getPassword());
        }*/
        service.saveEmployee(centrale);
        return new ModelAndView("redirect:/");
    }

}
