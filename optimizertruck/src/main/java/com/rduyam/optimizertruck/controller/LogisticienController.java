package com.rduyam.optimizertruck.controller;


import com.rduyam.optimizertruck.model.Logisticien;
import com.rduyam.optimizertruck.proxies.LogisticienProxy;
import com.rduyam.optimizertruck.service.LogisticienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LogisticienController {
    @Autowired
    private LogisticienService service;

    @GetMapping("/logisticiens")
    public String afficherResponsables(Model model) {
        Iterable<Logisticien> logisticiens = service.getAllLogisticiens();
        model.addAttribute("logisticiens", logisticiens);
        return "afficherLogisticiens";
    }

    @GetMapping("/logisticien/{id}")
    public String afficherLogisticien(@PathVariable("id") final Long id, Model model) {
        Logisticien logisticien = service.getLogisticien(id);
        model.addAttribute("logisticien", logisticien);
        return "afficherLogisticien";
    }

    @GetMapping("/createLogisticien")
    public String createLogisticien(Model model) {
        Logisticien logisticien = new Logisticien();
        model.addAttribute("logisticien", logisticien);
        return "formNewLogisticien";
    }

    @GetMapping("/updateLogisticien/{id}")
    public String updateLogisticien(@PathVariable("id") final Long id, Model model) {
        Logisticien logisticien = service.getLogisticien(id);
        model.addAttribute("logisticien",logisticien);
        return "formUpdateLogisticien";
    }

    @GetMapping("/deleteLogisticien/{id}")
    public ModelAndView deleteLogisticien(@PathVariable("id") final Long id) {
        service.deleteLogisticien(id);
        return new ModelAndView("redirect:/logisticiens");
    }

    @PostMapping("/saveLogisticien")
    public ModelAndView saveLogisticien(@ModelAttribute Logisticien logisticien) {
        if(logisticien.getIdLogisticien() != null) {
            Logisticien current = service.getLogisticien(logisticien.getIdLogisticien());
        }
        service.saveLogisticien(logisticien);
        return new ModelAndView("redirect:/logisticien");
    }
}
