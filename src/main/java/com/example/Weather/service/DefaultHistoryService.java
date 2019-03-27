package com.example.Weather.service;

import com.example.Weather.Enums.DataResponse;
import com.example.Weather.model.Data;
import com.example.Weather.model.History;
import com.example.Weather.model.Indexes;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;



@Service
public class DefaultHistoryService implements HistoryService {
    private GetCAQIService getCAQIService;
    private String lackOfData = DataResponse.LACKOFDATA.toString();

    public DefaultHistoryService(GetCAQIService getCAQIService) {
        this.getCAQIService = getCAQIService;
    }

    List<Indexes[]> getListOfIndexes(Data data) {
        Optional<History[]> history = Optional.ofNullable(data.getHistory());
        if (history.isPresent()){
        return Arrays.stream(history.get() )
                .map(History::getIndexes)
                .collect(Collectors.toList());
        }
        else {
            List<Indexes[]> list = new ArrayList<>();
            list.add(new Indexes[]{Indexes.builder().value(lackOfData).name(lackOfData).level(lackOfData).description(lackOfData).advice(lackOfData).color(lackOfData).build()});
            return list;
        }
    }

    @Override
    public Double[] getHistoricalCAQI(Data data) {
        List<Indexes[]> listOfIndexes = getListOfIndexes(data);
        Double[] receivedHistoricalCAIArray = getCAQIService.getCAQI(data,listOfIndexes);
        if(!Optional.ofNullable(receivedHistoricalCAIArray).isPresent()){
            return new Double[]{0.0};
        }
        return receivedHistoricalCAIArray;
    }


    @Override
    public String[] getHistoricalCAQIColors(Data data) {
        String[] receivedHistoricalCAIColorsArray = getCAQIService.getCAQIColors(data, getListOfIndexes(data));
        return receivedHistoricalCAIColorsArray;
    }
}
