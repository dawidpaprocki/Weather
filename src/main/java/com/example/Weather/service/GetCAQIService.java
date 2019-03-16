package com.example.Weather.service;

import com.example.Weather.model.Data;
import com.example.Weather.model.Indexes;

import java.util.List;

public interface GetCAQIService {
    String[] getCAQIColors(Data data, List<Indexes[]> listOfIndexes );
    Double[] getCAQI(Data data,List<Indexes[]> listOfIndexes );
}
