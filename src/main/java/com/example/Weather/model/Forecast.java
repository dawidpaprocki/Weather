package com.example.Weather.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Forecast {
    private Standards[] standards;

    private Indexes[] indexes;

    private String fromDateTime;

    private Values[] values;

    private String tillDateTime;

    public Standards[] getStandards ()
    {
        return standards;
    }

    public void setStandards (Standards[] standards)
    {
        this.standards = standards;
    }

    public Indexes[] getIndexes ()
    {
        return indexes;
    }

    public void setIndexes (Indexes[] indexes)
    {
        this.indexes = indexes;
    }

    public String getFromDateTime ()
    {
        return fromDateTime;
    }

    public void setFromDateTime (String fromDateTime)
    {
        this.fromDateTime = fromDateTime;
    }

    public Values[] getValues ()
    {
        return values;
    }

    public void setValues (Values[] values)
    {
        this.values = values;
    }

    public String getTillDateTime ()
    {
        return tillDateTime;
    }

    public void setTillDateTime (String tillDateTime)
    {
        this.tillDateTime = tillDateTime;
    }

}
