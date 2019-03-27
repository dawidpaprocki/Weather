package com.example.Weather.service;

import com.example.Weather.Enums.DataResponse;
import com.example.Weather.model.Data;
import com.example.Weather.model.History;
import com.example.Weather.model.Indexes;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class DefaultHistoryServiceTest {
    @Mock
    private Data data;
    @Mock
    private GetCAQIService getCAQIService;
    @InjectMocks
    private DefaultHistoryService defaultHistoryService;
    private String lackOfData = DataResponse.LACKOFDATA.toString();
    private String valueForTest = "2.0";
    private History[] historiesForTest;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        Indexes indexes = Indexes.builder()
                .value(valueForTest)
                .build();
        History historyForTest = History.builder()
                .indexes(new Indexes[]{indexes})
                .build();
        historiesForTest = new History[]{historyForTest};
    }

    @Test
    public void TestGetListOfIndexesTrue() {
        // Given
        // When
        when(data.getHistory())
                .thenReturn(historiesForTest);
        List<Indexes[]> listOfIndexes = defaultHistoryService.getListOfIndexes(data);
        String receivedValue = listOfIndexes.get(0)[0].getValue();
        // Then
        assertEquals(valueForTest, receivedValue);
    }

    @Test
    public void TestGetListOfIndexesNullChecker() {
        // Given
        // When
        when(data.getHistory())
                .thenReturn(null);
        List<Indexes[]> listOfIndexes = defaultHistoryService.getListOfIndexes(data);
        String receivedValue = listOfIndexes.get(0)[0].getValue();
        // Then
        assertEquals("", receivedValue);
    }

    @Test
    public void TestGetHistoricalCAQITrue() {
        // Given
        Double[] historicalCAQIForTest = {Double.parseDouble(valueForTest)};
        // When
        when(getCAQIService.getCAQI(any(), any()))
                .thenReturn(historicalCAQIForTest);
        Double[] receivedHistoricalCAIForTest = defaultHistoryService.getHistoricalCAQI(data);
        // Then
        assertEquals(historicalCAQIForTest[0], receivedHistoricalCAIForTest[0]);
    }

    @Test
    public void TestGetHistoricalCAQINullChecker() {
        // Given
        // When
        when(getCAQIService.getCAQI(any(), any()))
                .thenReturn(null);
        Double[] receivedHistoricalCAIForTest = defaultHistoryService.getHistoricalCAQI(data);
        // Then
        assertEquals(new Double(0.0), receivedHistoricalCAIForTest[0]);
    }

    @Test
    public void TestGetHistoricalCAQIColorsTrue() {

    }

    @Test
    public void TestGetHistoricalCAQIColorsFalse() {
    }
}