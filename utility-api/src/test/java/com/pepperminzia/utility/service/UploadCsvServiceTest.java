package com.pepperminzia.utility.service;

import com.pepperminzia.utility.repository.GeographicalRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class UploadCsvServiceTest {

    @Mock
    private GeographicalRepository mockGRepo;

    private UploadCsvService mockCsvService;

    @Before
    public void setUp() {
        mockCsvService = new UploadCsvService(mockGRepo);
    }

    @Test(expected = Exception.class)
    public void testUploadCsvInDatabase_ThrowsFileNotFoundException() {
        doThrow(FileNotFoundException.class).when(FileReader.class);
        mockCsvService.uploadCsvInDatabase("csvFilePath");
        verify(mockCsvService, times(1)).uploadCsvInDatabase("csvFilePath");
    }

    @Test
    public void testFindByState() {
        when(mockGRepo.findByState()).thenReturn(List.of("value"));
        final List<String> result = mockCsvService.findByState();
        assertEquals(List.of("value"), result);
    }

    @Test
    public void testFindByState_GeographicalRepositoryReturnsNoItems() {
        when(mockGRepo.findByState()).thenReturn(Collections.emptyList());
        final List<String> result = mockCsvService.findByState();
        assertEquals(Collections.emptyList(), result);
    }

    @Test
    public void testFindByCounty() {
        when(mockGRepo.findByCounty()).thenReturn(List.of("value"));
        final List<String> result = mockCsvService.findByCounty();
        assertEquals(List.of("value"), result);
    }

    @Test
    public void testFindByCounty_GeographicalRepositoryReturnsNoItems() {
        when(mockGRepo.findByCounty()).thenReturn(Collections.emptyList());
        final List<String> result = mockCsvService.findByCounty();
        assertEquals(Collections.emptyList(), result);
    }

    @Test
    public void testFindByCountyName() {
        when(mockGRepo.findByCountyName("state")).thenReturn(List.of("value"));
        final List<String> result = mockCsvService.findByCountyName("state");
        assertEquals(List.of("value"), result);
    }

    @Test
    public void testFindByCountyName_GeographicalRepositoryReturnsNoItems() {
        when(mockGRepo.findByCountyName("state")).thenReturn(Collections.emptyList());
        final List<String> result = mockCsvService.findByCountyName("state");
        assertEquals(Collections.emptyList(), result);
    }

    @Test
    public void testFindByPostalCode() {
        when(mockGRepo.findByPostalCode()).thenReturn(List.of("value"));
        final List<String> result = mockCsvService.findByPostalCode();
        assertEquals(List.of("value"), result);
    }

    @Test
    public void testFindByPostalCode_GeographicalRepositoryReturnsNoItems() {
        when(mockGRepo.findByPostalCode()).thenReturn(Collections.emptyList());
        final List<String> result = mockCsvService.findByPostalCode();
        assertEquals(Collections.emptyList(), result);
    }

    @Test
    public void testFindByPostalCodeCounty() {
        when(mockGRepo.findByPostalCodeCounty("county")).thenReturn(List.of("value"));
        final List<String> result = mockCsvService.findByPostalCodeCounty("county");
        assertEquals(List.of("value"), result);
    }

    @Test
    public void testFindByPostalCodeCounty_GeographicalRepositoryReturnsNoItems() {
        when(mockGRepo.findByPostalCodeCounty("county")).thenReturn(Collections.emptyList());
        final List<String> result = mockCsvService.findByPostalCodeCounty("county");
        assertEquals(Collections.emptyList(), result);
    }

    @Test
    public void testFindByPostalCodeState() {
        when(mockGRepo.findByPostalCodeState("state")).thenReturn(List.of("value"));
        final List<String> result = mockCsvService.findByPostalCodeState("state");
        assertEquals(List.of("value"), result);
    }

    @Test
    public void testFindByPostalCodeState_GeographicalRepositoryReturnsNoItems() {
        when(mockGRepo.findByPostalCodeState("state")).thenReturn(Collections.emptyList());
        final List<String> result = mockCsvService.findByPostalCodeState("state");
        assertEquals(Collections.emptyList(), result);
    }
}
