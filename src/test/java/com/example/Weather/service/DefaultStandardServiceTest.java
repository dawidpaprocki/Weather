package com.example.Weather.service;

import com.example.Weather.Enums.DataResponse;
import com.example.Weather.model.Current;
import com.example.Weather.model.Data;
import com.example.Weather.model.Standards;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.net.ResponseCache;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class DefaultStandardServiceTest {

    @Mock
    private Data data;
    @Mock
    private Current current;
    @Mock
    private CurrentService currentService;
    @InjectMocks
    private DefaultStandardsService defaultStandardsService;

    private String lackOfData = DataResponse.LACKOFDATA.toString();

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
    }
    @Test
    public void TestGetStandardPollutantNameTrue(){
        // Given
        String testName = "Test name";
        Standards standardsForTest = Standards.builder()
                .pollutant(testName)
                .build();
        Standards[] testStandardsArray = new Standards[]{standardsForTest};
        // When
        when(currentService.getWHOStandards(data))
                .thenReturn(testStandardsArray);
        String receivedName = defaultStandardsService.getStandardPollutantName(data, testName);
        // Then
        assertEquals(testName,receivedName);
    }

    @Test
    public void TestGetStandardPollutantNameFalse(){
        // Given
        String testName = "Test name";
        // When
        String receivedName = defaultStandardsService.getStandardPollutantName(data, testName);
        // Then
        assertEquals(DataResponse.LACKOFDATA.toString(),receivedName);
    }
}