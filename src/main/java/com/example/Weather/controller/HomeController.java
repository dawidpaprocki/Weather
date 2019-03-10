package com.example.Weather.controller;

import com.example.Weather.model.Data;
import com.example.Weather.service.CurrentService;
import com.example.Weather.service.DataService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {
    private CurrentService currentService;
    private DataService dataService;

    public HomeController(CurrentService currentService, DataService dataService) {
        this.currentService = currentService;
        this.dataService = dataService;
    }

    @RequestMapping
    public String initHomePage(Model model)  {
        Data data = dataService.getData(50.29748, 18.95457);
        model.addAttribute("values", currentService.getValue(data));
        model.addAttribute("tillDate",currentService.getTillDateTime(data));
        return "index";
    }

}
