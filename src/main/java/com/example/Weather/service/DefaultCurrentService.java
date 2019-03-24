package com.example.Weather.service;

import com.example.Weather.Enums.DataResponse;
import com.example.Weather.model.*;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class DefaultCurrentService implements CurrentService {
    private String lackOfDataEnum = DataResponse.LACKOFDATA.toString();

    public Values[] getValue(Data data) {
        Optional<Values[]> optionalValues = Optional.ofNullable(data.getCurrent().getValues());
        Values emptyJSONValues = Values.builder()
                .name(lackOfDataEnum)
                .value(lackOfDataEnum)
                .build();
        return optionalValues.orElse(new Values[]{emptyJSONValues}) ;
    }

    public Standards[] getWHOStandards(Data data) {
        Optional<Standards[]> optionalStandards = Optional.ofNullable(data.getCurrent().getStandards());
        Standards emptyJSONStandards = Standards.builder()
                .name(lackOfDataEnum)
                .limit("0")
                .pollutant(lackOfDataEnum)
                .percent(0.0)
                .build();
        return optionalStandards.orElse(new Standards[]{emptyJSONStandards});
    }

    public Indexes[] getOverAllInformation(Data data) {
        Optional<Indexes[]> optionalIndexes = Optional.ofNullable(data.getCurrent().getIndexes());
        Indexes emptyJSONIndexes = Indexes.builder()
                .color("")
                .advice(lackOfDataEnum)
                .description(lackOfDataEnum)
                .level(lackOfDataEnum)
                .name(lackOfDataEnum)
                .value(lackOfDataEnum)
                .build();
        return optionalIndexes.orElse(new Indexes[]{emptyJSONIndexes});
    }

    public String getTillDateTime(Data data) {
        Optional<String> optionalString = Optional.ofNullable(data.getCurrent().getTillDateTime());
        return optionalString.orElse(lackOfDataEnum);
    }

    public String getFromDateTime(Data data) {
        Optional<String> optionalString = Optional.ofNullable(data.getCurrent().getFromDateTime());
        return optionalString.orElse(lackOfDataEnum);
    }



}
