package com.pepperminzia.insurance.service;

import com.pepperminzia.insurance.entity.Insurance;
import com.pepperminzia.insurance.entity.InsurancePaymentTrans;
import com.pepperminzia.insurance.entity.InsuranceResult;
import com.pepperminzia.insurance.entity.Payment;
import com.pepperminzia.insurance.repository.InsuranceResultRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class InsuranceServiceTest {

    @Mock
    private InsuranceResultRepository mockInsuranceResultRepository;

    @Mock
    private RestTemplate mockRestTemplate;

    @InjectMocks
    @Spy
    private InsuranceService mockInsuranceService;

    @Test
    public void testCalculateInsurance() {
        Insurance insuranceResponse = new Insurance(0.0, "vehicleType", "postalCode", "county", "state", 0);
        InsuranceResult insuranceResult = new InsuranceResult(0L, 0L, "mileage", "vehicleType", "postalCode", "county", "state", "regionalClass", 0.0);

        when(mockInsuranceResultRepository.save(any(InsuranceResult.class))).thenReturn(insuranceResult);

        InsuranceResult result = mockInsuranceService.calculateInsurance(insuranceResponse);

        assertNotNull(result);
        verify(mockInsuranceResultRepository).save(any(InsuranceResult.class));
    }

    @Test
    public void testGetAllInsuranceTransactions() {
        List<InsuranceResult> insuranceResultList = Arrays.asList(new InsuranceResult(0L, 0L, "mileage", "vehicleType", "postalCode", "county", "state", "regionalClass", 0.0));
        when(mockInsuranceResultRepository.findAll()).thenReturn(insuranceResultList);

        List<InsurancePaymentTrans> result = mockInsuranceService.getAllInsuranceTransactions();

        assertNotNull(result);
    }

    @Test
    public void testGetAllInsuranceTransactions_InsuranceResultRepositoryReturnsNoResult() {

        when(mockInsuranceResultRepository.findAll()).thenReturn(Collections.emptyList());

        List<InsurancePaymentTrans> result = mockInsuranceService.getAllInsuranceTransactions();

        assertNotNull(result);
        assertEquals(Collections.emptyList(),result);
    }

    @Test(expected = Exception.class)
    public void testGetAllInsuranceTransactions_RestTemplateThrowsRestClientException() {
        List<InsuranceResult> insuranceResultList = List.of(new InsuranceResult(0L, 0L, "mileage", "vehicleType", "postalCode", "county", "state", "regionalClass", 0.0));
        when(mockInsuranceResultRepository.findAll()).thenReturn(insuranceResultList);

        doThrow(RestClientException.class).when(mockRestTemplate).getForObject("null0", Payment.class);

        List<InsurancePaymentTrans> result = mockInsuranceService.getAllInsuranceTransactions();
    }
}
