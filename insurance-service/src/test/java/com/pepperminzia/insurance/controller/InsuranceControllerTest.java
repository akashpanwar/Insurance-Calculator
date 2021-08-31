package com.pepperminzia.insurance.controller;

import com.pepperminzia.insurance.entity.Insurance;
import com.pepperminzia.insurance.entity.InsurancePaymentTrans;
import com.pepperminzia.insurance.entity.InsuranceResult;
import com.pepperminzia.insurance.service.InsuranceService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class InsuranceControllerTest {

    @Mock
    private InsuranceService mockInsuranceService;

    @InjectMocks
    @Spy
    private InsuranceController mockInsuranceController;

    @Test
    public void testGetAllInsuranceTransactions() {
        List<InsurancePaymentTrans> insurancePaymentTrans = List.of(new InsurancePaymentTrans(0L, 0L,
                "mileage", "vehicleType", "postalCode", "county", "state",
                "regionalClass", 0.0, new BigDecimal("0.00"),
                LocalDate.of(2020, 1, 1), "status"));

        when(mockInsuranceService.getAllInsuranceTransactions()).thenReturn(insurancePaymentTrans);

        List<InsurancePaymentTrans> result = mockInsuranceController.getAllInsuranceTransactions();

        assertNotNull(result);
        assertEquals(insurancePaymentTrans.size(), result.size());
    }

    @Test
    public void testGetAllInsuranceTransactions_InsuranceServiceReturnsNoItems() {
        when(mockInsuranceService.getAllInsuranceTransactions()).thenReturn(Collections.emptyList());

        List<InsurancePaymentTrans> result = mockInsuranceController.getAllInsuranceTransactions();

        assertEquals(Collections.EMPTY_LIST, result);
    }

    @Test
    public void testCalculateInsurance() {
        InsuranceResult insuranceResult = new InsuranceResult(0L, 0L, "mileage", "vehicleType", "postalCode", "county", "state", "regionalClass", 0.0);
        when(mockInsuranceService.calculateInsurance(any(Insurance.class))).thenReturn(insuranceResult);

        InsuranceResult result = mockInsuranceController.calculateInsurance(new Insurance(0.0,"vehicleType", "postalCode", "county", "state", 1));

        assertNotNull(result);
        assertEquals(insuranceResult.getResult(),result.getResult());
    }
}
