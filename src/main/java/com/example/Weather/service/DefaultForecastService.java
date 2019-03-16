package com.example.Weather.service;

import com.example.Weather.model.Data;
import com.example.Weather.model.Forecast;
import com.example.Weather.model.History;
import com.example.Weather.model.Indexes;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
@Service
public class DefaultForecastService implements ForecastService {
    private GetCAQIService getCAQIService;

    public DefaultForecastService(GetCAQIService getCAQIService) {
        this.getCAQIService = getCAQIService;
    }

    private List<Indexes[]> getListOfIndexes(Data data) {
        Forecast[] history = data.getForecast();
        return Arrays.stream(history)
                .map(Forecast::getIndexes)
                .collect(Collectors.toList());
    }

    @Override
    public Double[] getForecastCAQI(Data data) {
        Double[] receivedHistoricalCAIArray = getCAQIService.getCAQI(data, getListOfIndexes(data));
        return receivedHistoricalCAIArray;
    }

    @Override
    public String[] getForecastAQIColors(Data data) {
        String[] receivedHistoricalCAIColorsArray = getCAQIService.getCAQIColors(data, getListOfIndexes(data));
        return receivedHistoricalCAIColorsArray;
    }
}
