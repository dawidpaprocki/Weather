package com.example.Weather.service;

import com.example.Weather.model.Data;
import com.example.Weather.model.Standards;
import org.springframework.stereotype.Service;

import java.util.Arrays;
@Service
public class DefaultStandardsService implements StandardsService {
    private CurrentService currentService;

    public DefaultStandardsService(CurrentService currentService) {
        this.currentService = currentService;
    }


    @Override
    public String getCurrentStandardName(Data data, String pollutantName) {
        Standards[] whoStandards = currentService.getWHOStandards(data);
        return Arrays.stream(whoStandards).filter(standards -> standards.getPollutant()
                .equals(pollutantName))
                .findFirst()
                .get()
                .getName();
    }

    @Override
    public Double getCurrentStandardPercent(Data data, String pollutantName) {
        Standards[] whoStandards = currentService.getWHOStandards(data);
        String percentOfStandard = Arrays.stream(whoStandards).filter(standards -> standards.getPollutant()
                .equals(pollutantName))
                .findFirst()
                .get()
                .getPercent();
        return Double.parseDouble(percentOfStandard);
    }
}
