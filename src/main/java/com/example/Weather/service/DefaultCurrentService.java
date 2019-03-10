package com.example.Weather.service;

import com.example.Weather.model.*;
import org.springframework.stereotype.Component;

@Component
public class DefaultCurrentService implements CurrentService {

    public Values[] getValue(Data data) {
        return data.getCurrent().getValues();
    }

    public Standards[] getWHOStandards(Data data) {
        return data.getCurrent().getStandards();
    }

    public Indexes[] getOverAllInformation(Data data) {
        return data.getCurrent().getIndexes();
    }

    public String getTillDateTime(Data data) {
        return data.getCurrent().getTillDateTime();
    }

    public String getFromDateTime(Data data) {
        return data.getCurrent().getFromDateTime();
    }



}
