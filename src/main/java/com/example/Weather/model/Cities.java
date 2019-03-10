package com.example.Weather.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties("document")
public class Cities {
    @JsonProperty("ID")
    private Long id;
    @JsonProperty("Name")
    private String name;
    @JsonProperty("Population")
    private Long population;
    @JsonProperty("Latitude")
    private Float latitude;
    @JsonProperty("Longitude")
    private Float longitude;
}
