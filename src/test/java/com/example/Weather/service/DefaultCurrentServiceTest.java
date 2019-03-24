package com.example.Weather.service;

import com.example.Weather.Enums.DataResponse;
import com.example.Weather.model.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.when;
@RunWith(MockitoJUnitRunner.class)
public class DefaultCurrentServiceTest {

    @Mock
    private Data data;
    @Mock
    private Current current;

    @InjectMocks
    private DefaultCurrentService defaultCurrentService;

    private String lackOfData = DataResponse.LACKOFDATA.toString();

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        when(data.getCurrent())
                .thenReturn(current);
    }

    @Test
    public void TestGetValueTrue() {
        // Given
        String testName = "Test Value";
        Values values = Values.builder()
                .name(testName)
                .build();
        Values[] valuesForTest = new Values[]{values};
        // When
        when(current.getValues())
                .thenReturn(valuesForTest);
        String receivedValueName = defaultCurrentService.getValue(data)[0].getName();
        // Then
        assertEquals(testName,receivedValueName);
    }
    @Test
    public void TestGetValueTestFalse() {
        // Given
        // When
        String valueName = defaultCurrentService.getValue(data)[0].getName();
        // Then
        assertEquals(lackOfData,valueName);
    }

    @Test
    public void TestGetWHOStandardsTestTrue() {
        // Given
        String testName = "Test Standards";
        Standards standards = Standards.builder()
                .name(testName)
                .build();
        Standards[] standardsForTest = new Standards[]{standards};
        // When
        when(current.getStandards())
                .thenReturn(standardsForTest);
        String receivedStandardsName = defaultCurrentService.getWHOStandards(data)[0].getName();
        // Then
        assertEquals(testName,receivedStandardsName);
    }

    @Test
    public void TestGetWHOStandardsFalse() {
        // Given
        // When
        String receivedStandardsName = defaultCurrentService.getWHOStandards(data)[0].getName();
        // Then
        assertEquals(lackOfData,receivedStandardsName);
    }

    @Test
    public void TestGetOverAllInformationTrue() {
        // Given
        String testName = "Test Indexes";
        Indexes indexes = Indexes.builder()
                .name(testName)
                .build();
        Indexes[] indexesForTest = new Indexes[]{indexes};
        // When
        when(current.getIndexes())
                .thenReturn(indexesForTest);
        String receivedIndexesName = defaultCurrentService.getOverAllInformation(data)[0].getName();
        // Then
        assertEquals(testName,receivedIndexesName);
    }

    @Test
    public void TestGetOverAllInformationFalse() {
        // Given
        // When
        String receivedIndexesName = defaultCurrentService.getOverAllInformation(data)[0].getName();
        // Then
        assertEquals(lackOfData,receivedIndexesName);
    }

    @Test
    public void TestGetDateTimeTrue() {
        // Given
        String testDate = "Test date";
        // When
        when(current.getFromDateTime())
                .thenReturn(testDate);
        when(current.getTillDateTime())
                .thenReturn(testDate);
        String fromDateTimeFrom = defaultCurrentService.getFromDateTime(data);
        String fromDateTimeTill = defaultCurrentService.getTillDateTime(data);
        // Then
        assertEquals(testDate,fromDateTimeFrom);
        assertEquals(testDate,fromDateTimeTill);
    }

    @Test
    public void TestGetDateTimeFalse() {
        // Given
        // When
        String fromDateTimeFrom = defaultCurrentService.getFromDateTime(data);
        String fromDateTimeTill = defaultCurrentService.getTillDateTime(data);
        // Then
        assertEquals(lackOfData,fromDateTimeFrom);
        assertEquals(lackOfData,fromDateTimeTill);

    }
}