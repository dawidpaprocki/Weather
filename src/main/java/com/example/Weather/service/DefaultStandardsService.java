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

    private Optional<Standards> getStandard(Data data, String pollutantName) {
        Optional<Standards[]> whoStandards = Optional.ofNullable(currentService.getWHOStandards(data));
        if (whoStandards.isPresent()) {
            return Arrays.stream(whoStandards.get())
                    .filter(standards -> standards.getPollutant()
                            .equals(pollutantName))
                    .findFirst();
        }
        return Optional.ofNullable(Standards.builder().build());
    }


    @Override
    public String getStandardPollutantName(Data data, String pollutantName) {
        Optional<Standards> standards = getStandard(data, pollutantName);
        if (standards.isPresent()) {
            return standards.map(Standards::getPollutant).orElse(DataResponse.LACKOFDATA.toString());
        } else {
            return DataResponse.LACKOFDATA.toString();
        }
    }

    @Override
    public Double getStandardPercent(Data data, String pollutantName) {
        Optional<Standards> standards = getStandard(data, pollutantName);
        if (standards.isPresent()) {
            return standards.map(Standards::getPercent).orElse(0.0);
        } else {
            return 0.0;
        }
    }
}
