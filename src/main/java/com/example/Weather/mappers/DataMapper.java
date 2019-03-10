package com.example.Weather.mappers;

import com.example.Weather.RequestHandler;
import com.example.Weather.model.Data;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;

public class DataMapper {
     private ObjectMapper mapper = new ObjectMapper();
     private static final String url = "https://airapi.airly.eu/v2/measurements/";
     private static final String apiKey = "UM641Ep2qlOXgMAcuVjdBfTB2jmIp4rY";

    public Data MapObject(RequestHandler requestHandler,Double latitude,Double longitude  ) throws IOException {
        String airlyApiUrl = UrlCreator(latitude, longitude);
        Data data;
       return  mapper.readValue(requestHandler.getInputStream(airlyApiUrl,apiKey), Data.class);

    }

    private String UrlCreator(Double latitude,Double longitude){
        return url +
                "nearest?lat=" +
                latitude +
                "&lng=" +
                longitude +
                "&maxDistanceKM=5";
    }
}
