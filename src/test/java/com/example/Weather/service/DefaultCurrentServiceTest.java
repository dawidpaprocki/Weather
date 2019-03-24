package com.example.Weather.service;

import com.example.Weather.Enums.DataResponse;
import com.example.Weather.model.Current;
import com.example.Weather.model.Data;
import com.example.Weather.model.Values;
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

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getValueTestTrue() {
        // Given
        String testName = "testValue";
        Values values = Values.builder()
                .name(testName)
                .build();
        Values[] valuesForTest = new Values[]{values};
        // When
        when(data.getCurrent())
                .thenReturn(current);
        when(current.getValues())
                .thenReturn(valuesForTest);
        String receivedValueName = defaultCurrentService.getValue(data)[0].getName();
        // Then
        assertEquals(testName,receivedValueName);
    }
    @Test
    public void getValueTestFalse() {
        // Given
        // When
        when(data.getCurrent())
                .thenReturn(current);
        String valueName = defaultCurrentService.getValue(data)[0].getName();
        // Then
        assertEquals(DataResponse.LACKOFDATA.toString(),valueName);
    }

    @Test
    public void getWHOStandardsTrue() {
        // Given

        // When
        // Then
    }

    @Test
    public void getOverAllInformation() {
        fail();
    }

    @Test
    public void getTillDateTime() {
        fail();
    }

    @Test
    public void getFromDateTime() {
        fail();
    }
}