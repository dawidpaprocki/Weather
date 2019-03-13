package com.example.Weather.service;

import com.example.Weather.model.Data;
import com.example.Weather.model.History;
import com.example.Weather.model.Indexes;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DefaultHistoryService implements HistoryService {

    private List<Indexes[]> listOfIndexes = new ArrayList<>();

    public Double[] getHistoricalCAQI(Data data) {
        getListOfIndexes(data);
        List<Double> resultListOfHistoricalIndexValue = new ArrayList();
        listOfIndexes.forEach(indexes -> {
            for (Indexes index : indexes) {
                resultListOfHistoricalIndexValue.add(Double.parseDouble(index.getValue()));
            }
        });
        getHistoricalCAQIColors(data);
        return resultListOfHistoricalIndexValue.toArray(new Double[0]);
    }

    public String[] getHistoricalCAQIColors(Data data) {
        getListOfIndexes(data);
        List<String> resultListOfHistoricalIndexValue = new ArrayList();
        listOfIndexes.forEach(indexes -> {
            for (Indexes index : indexes) {
                resultListOfHistoricalIndexValue.add(index.getColor());
            }
        });
        return resultListOfHistoricalIndexValue.toArray(new String[0]);
    }

    private void getListOfIndexes(Data data) {
            History[] history = data.getHistory();
            listOfIndexes = Arrays.stream(history)
                    .map(History::getIndexes)
                    .collect(Collectors.toList());
    }
}
