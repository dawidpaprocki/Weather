package com.example.Weather.controller;

import com.example.Weather.RequestHandler;
import com.example.Weather.mappers.DataMapper;
import com.example.Weather.model.Current;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;

@Controller
@RequestMapping("/")
public class HomeController {
    @RequestMapping
    public String initHomePage(Model model) throws IOException {
        DataMapper dataMapper = new DataMapper();
        Current currentWeather = dataMapper.MapObject(new RequestHandler()).getCurrent();

        model.addAttribute("fromDate",currentWeather.getFromDateTime());
        model.addAttribute("tillDate",currentWeather.getTillDateTime());
        return "index";
    }

}
