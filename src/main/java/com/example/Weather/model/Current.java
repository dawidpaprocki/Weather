package com.example.Weather.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Current {
    private Standards[] standards;
    private Indexes[] indexes;
    private String fromDateTime;
    private Values[] values;
    private String tillDateTime;
}
