package com.example.Weather.service;

import com.example.Weather.model.Data;
import com.example.Weather.model.Indexes;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DefaultCAQIService implements GetCAQIService {

    public Double[] getCAQI(Data data, List<Indexes[]> listOfIndexes ) {
        List<Double> resultListOfIndexValue = new ArrayList();
        listOfIndexes.forEach(indexes -> {
            for (Indexes index : indexes) {
                resultListOfIndexValue.add(Double.parseDouble(index.getValue()));
            }
        });
        getCAQIColors(data,listOfIndexes );
        return resultListOfIndexValue.toArray(new Double[0]);
    }

    public String[] getCAQIColors(Data data,List<Indexes[]> listOfIndexes ) {
        List<String> resultListOfIndexValue = new ArrayList();
        listOfIndexes.forEach(indexes -> {
            for (Indexes index : indexes) {
                resultListOfIndexValue.add(index.getColor());
            }
        });
        return resultListOfIndexValue.toArray(new String[0]);
    }
}
