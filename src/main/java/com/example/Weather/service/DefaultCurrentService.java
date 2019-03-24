package com.example.Weather.service;

import com.example.Weather.Enums.DataResponse;
import com.example.Weather.model.*;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class DefaultCurrentService implements CurrentService {
    private String LackOfDataEnum = DataResponse.LACKOFDATA.toString();

    public Values[] getValue(Data data) {
        Optional<Values[]> optionalValues = Optional.ofNullable(data.getCurrent().getValues());

        Values emptyJSONValues = Values.builder()
                .name(LackOfDataEnum)
                .value(LackOfDataEnum)
                .build();
        return optionalValues.orElse(new Values[]{emptyJSONValues}) ;
    }

    public Standards[] getWHOStandards(Data data) {
        Optional<Standards[]> optionalStandards = Optional.ofNullable(data.getCurrent().getStandards());

        return data.getCurrent().getStandards();
    }

    public Indexes[] getOverAllInformation(Data data) {
        Optional<Indexes[]> indexes = Optional.ofNullable(data.getCurrent().getIndexes());
        Indexes emptyJSONIndexes = Indexes.builder()
                .color("")
                .advice(LackOfDataEnum)
                .description(LackOfDataEnum)
                .level(LackOfDataEnum)
                .name(LackOfDataEnum)
                .value(LackOfDataEnum)
                .build();
        return indexes.orElse(new Indexes[]{emptyJSONIndexes});
    }

    public String getTillDateTime(Data data) {
        return data.getCurrent().getTillDateTime();
    }

    public String getFromDateTime(Data data) {
        return data.getCurrent().getFromDateTime();
    }



}
