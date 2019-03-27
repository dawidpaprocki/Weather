package com.example.Weather.repository;

import com.example.Weather.model.Cities;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.stereotype.Repository;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.stream.Collectors;

@Repository
public class DefaultCitiesMapperFromFile implements  CitiesMapperFormFile{
    private ObjectMapper mapper = new ObjectMapper();
    public Cities[] GetCities(){

        try {
             File initialFile = new File("src/main/resources/static/Cities.json");
            return mapper.readValue(initialFile, Cities[].class);
        } catch (IOException e) {
            e.printStackTrace();
            return new Cities[0];
        }

    }
}
