package com.example.Weather.service;

import com.example.Weather.model.Data;
import com.example.Weather.model.History;
import com.example.Weather.model.Indexes;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DefaultHistoryService implements HistoryService {
    private GetCAQIService getCAQIService;

    public DefaultHistoryService(GetCAQIService getCAQIService) {
        this.getCAQIService = getCAQIService;
    }

    private List<Indexes[]> getListOfIndexes(Data data) {
        History[] history = data.getHistory();
        return Arrays.stream(history)
                .map(History::getIndexes)
                .collect(Collectors.toList());
    }

    @Override
    public Double[] getHistoricalCAQI(Data data) {
        Double[] receivedHistoricalCAIArray = getCAQIService.getCAQI(data, getListOfIndexes(data));
        return receivedHistoricalCAIArray;
    }


    @Override
    public String[] getHistoricalCAQIColors(Data data) {
        String[] receivedHistoricalCAIColorsArray = getCAQIService.getCAQIColors(data, getListOfIndexes(data));
        return receivedHistoricalCAIColorsArray;
    }
}
