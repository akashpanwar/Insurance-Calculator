package com.pepperminzia.utility.controller;

import com.pepperminzia.utility.service.SendEmailService;
import com.pepperminzia.utility.service.UploadCsvService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;

import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@RunWith(MockitoJUnitRunner.class)
public class UtilityControllerTest {

    @InjectMocks
    @Spy
    private UtilityController mockUtilityController;

    @Mock
    private UploadCsvService mockUploadCsvService;

    @Mock
    private SendEmailService mockSendEmailService;


    @Test
    public void testUploadCsvInDatabase() throws Exception {
        mockUtilityController.uploadCsvInDatabase("csvFilePath");
        verify(mockUploadCsvService).uploadCsvInDatabase("csvFilePath");
    }

    @Test
    public void testSendEmail() {
        mockUtilityController.sendEmail(0L);
        verify(mockSendEmailService).sendEmail(0L, null);
    }

    @Test
    public void testSendEmailRecipient() {
        mockUtilityController.sendEmailRecipient(0L,"mailTo");
        verify(mockSendEmailService).sendEmail(0L, "mailTo");
    }

    @Test
    public void testFindByState() {
        when(mockUploadCsvService.findByState()).thenReturn(List.of("value"));

        List<String> result = mockUtilityController.findByState();

        assertNotNull(result);
        assertFalse(result.isEmpty());
    }

    @Test
    public void testFindByState_UploadCsvServiceReturnsNoItems() {

        when(mockUploadCsvService.findByState()).thenReturn(Collections.emptyList());

        List<String> result = mockUtilityController.findByState();

        assertTrue(result.isEmpty());
    }

    @Test
    public void testFindByCounty() {
        when(mockUploadCsvService.findByCounty()).thenReturn(List.of("value"));

        List<String> result = mockUtilityController.findByCounty();

        assertNotNull(result);
        assertFalse(result.isEmpty());
    }

    @Test
    public void testFindByCounty_UploadCsvServiceReturnsNoItems() {
        when(mockUploadCsvService.findByCounty()).thenReturn(Collections.emptyList());

        List<String> result = mockUtilityController.findByCounty();

        assertTrue(result.isEmpty());
    }

    @Test
    public void testFindByCountyName() {
        when(mockUploadCsvService.findByCountyName("state")).thenReturn(List.of("value"));

        List<String> result = mockUtilityController.findByCountyName("state");

        assertNotNull(result);
        assertFalse(result.isEmpty());
    }

    @Test
    public void testFindByCountyName_UploadCsvServiceReturnsNoItems() {
        when(mockUploadCsvService.findByCountyName("state")).thenReturn(Collections.emptyList());

        List<String> result = mockUtilityController.findByCountyName("state");

        assertTrue(result.isEmpty());
    }

    @Test
    public void testFindByPostalCodeCounty() {
        when(mockUploadCsvService.findByPostalCodeCounty("county")).thenReturn(List.of("value"));

        List<String> result = mockUtilityController.findByPostalCodeCounty("county");

        assertNotNull(result);
        assertFalse(result.isEmpty());
    }

    @Test
    public void testFindByPostalCodeCounty_UploadCsvServiceReturnsNoItems() {
        when(mockUploadCsvService.findByPostalCodeCounty("county")).thenReturn(Collections.emptyList());

        List<String> result = mockUtilityController.findByPostalCodeCounty("county");

        assertTrue(result.isEmpty());
    }

    @Test
    public void testFindByPostalCodeState() {
        when(mockUploadCsvService.findByPostalCodeState("state")).thenReturn(List.of("value"));

        List<String> result = mockUtilityController.findByPostalCodeState("state");

        assertNotNull(result);
        assertFalse(result.isEmpty());
    }

    @Test
    public void testFindByPostalCodeState_UploadCsvServiceReturnsNoItems() {
        when(mockUploadCsvService.findByPostalCodeState("state")).thenReturn(Collections.emptyList());

        List<String> result = mockUtilityController.findByPostalCodeState("state");

        assertTrue(result.isEmpty());
    }

    @Test
    public void testFindByPostalCode() {
        when(mockUploadCsvService.findByPostalCode()).thenReturn(List.of("value"));

        List<String> result = mockUtilityController.findByPostalCode();

        assertNotNull(result);
        assertFalse(result.isEmpty());
    }

    @Test
    public void testFindByPostalCode_UploadCsvServiceReturnsNoItems() {
        when(mockUploadCsvService.findByPostalCode()).thenReturn(Collections.emptyList());

        List<String> result = mockUtilityController.findByPostalCode();

        assertTrue(result.isEmpty());
    }
}
