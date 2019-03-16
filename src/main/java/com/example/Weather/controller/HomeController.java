package com.example.Weather.controller;

import com.example.Weather.model.*;
import com.example.Weather.service.CurrentService;
import com.example.Weather.service.DataService;
import com.example.Weather.service.ForecastService;
import com.example.Weather.service.HistoryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
public class HomeController {
    private CurrentService currentService;
    private DataService dataService;
    private HistoryService historyService;
    private ForecastService forecastService;


    public HomeController(CurrentService currentService, DataService dataService, HistoryService historyService, ForecastService forecastService) {
        this.currentService = currentService;
        this.dataService = dataService;
        this.historyService = historyService;
        this.forecastService = forecastService;
    }




    @GetMapping
    public String initHomePage(Model model) {
        Data data = dataService.getData( 50.2974884,18.9545728);

        model.addAttribute("values", currentService.getValue(data));
        model.addAttribute("tillDate", currentService.getTillDateTime(data));
        Indexes[] overAllInformation = currentService.getOverAllInformation(data);
        model.addAttribute("index", overAllInformation[0]);
        model.addAttribute("cities", dataService.getDataFromFile());
        model.addAttribute("cityName", "Chorzów");
        model.addAttribute("listOfPointsHistorical", historyService.getHistoricalCAQI(data));
        model.addAttribute("listOfPointsColorsHistorical", historyService.getHistoricalCAQIColors(data));
        model.addAttribute("listOfPointsForecast", forecastService.getForecastCAQI(data));
        model.addAttribute("listOfPointsColorsForecast", forecastService.getForecastAQIColors(data));
        return "index";
    }

    @RequestMapping("/choiceCity")
    private String choiceCity(Model model,
                              @RequestParam("longitude") Double longitude,
                              @RequestParam("latitude")  Double latitude,
                              @RequestParam("cityName")  String cityName) {
        Data data = dataService.getData(latitude,longitude);

        model.addAttribute("values", currentService.getValue(data));
        model.addAttribute("tillDate", currentService.getTillDateTime(data));
        Indexes[] overAllInformation = currentService.getOverAllInformation(data);
        model.addAttribute("index", overAllInformation[0]);
        model.addAttribute("cities", dataService.getDataFromFile());
        model.addAttribute("cityName", cityName);
        model.addAttribute("listOfPointsHistorical", historyService.getHistoricalCAQI(data));
        model.addAttribute("listOfPointsColorsHistorical", historyService.getHistoricalCAQIColors(data));
        model.addAttribute("listOfPointsForecast", forecastService.getForecastCAQI(data));
        model.addAttribute("listOfPointsColorsForecast", forecastService.getForecastAQIColors(data));
        return "index";
    }


    @PostMapping("/choiceCity")
    public String changeCity(Model model,
            @RequestParam("cityId") String coordinates) {
        String[] split = coordinates.split(",");
        model.addAttribute("latitude",split[1]);
        model.addAttribute("longitude",split[0]);
        model.addAttribute("longitude",split[2]);
        return "redirect:/choiceCity?longitude="+split[0]+"&latitude="+split[1]+"&cityName="+split[2]+"";
    }

}
