package com.example.Weather.service;

import com.example.Weather.Enums.DataResponse;
import com.example.Weather.model.Data;
import com.example.Weather.model.Indexes;
import com.example.Weather.model.Standards;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Optional;

@Service
public class DefaultStandardsService implements StandardsService {
    private CurrentService currentService;

    public DefaultStandardsService(CurrentService currentService) {
        this.currentService = currentService;
    }


    @Override
    public String getStandardName(Data data, String pollutantName) {
        Standards[] whoStandards = currentService.getWHOStandards(data);
        Optional<Standards> optionalName = Arrays.stream(whoStandards).filter(standards -> standards.getPollutant()
                .equals(pollutantName))
                .findFirst();
        if(optionalName.isPresent()){
            return optionalName.get().getName();
        }else {
            return DataResponse.LACKOFDATA.toString();
        }
    }

    @Override
    public Double getStandardPercent(Data data, String pollutantName) {
        Standards[] whoStandards = currentService.getWHOStandards(data);

        Optional<Standards> optionalStandard = Arrays.stream(whoStandards).filter(standards -> standards.getPollutant()
                .equals(pollutantName))
                .findFirst();
        return optionalStandard.map(Standards::getPercent).orElse(0.0);
    }
}
