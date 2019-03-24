package com.example.Weather.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Indexes {
    private String color;
    private String level;
    private String advice;
    private String name;
    private String description;
    private String value;
}
