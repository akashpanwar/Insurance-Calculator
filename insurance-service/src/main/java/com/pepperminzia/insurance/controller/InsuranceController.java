package com.pepperminzia.insurance.controller;

import com.pepperminzia.insurance.entity.Insurance;
import com.pepperminzia.insurance.entity.InsurancePaymentTrans;
import com.pepperminzia.insurance.entity.InsuranceResult;
import com.pepperminzia.insurance.service.InsuranceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/insurance")
@CrossOrigin(origins = "*")
public class InsuranceController {

    @Autowired
    private InsuranceService insuranceService;

    public InsuranceController(InsuranceService insuranceService) {
        this.insuranceService = insuranceService;
    }

    @GetMapping("/getAllInsuranceTransactions")
    public List<InsurancePaymentTrans> getAllInsuranceTransactions() {
        return insuranceService.getAllInsuranceTransactions();
    }

    @PostMapping("/calculateInsurance")
    public InsuranceResult calculateInsurance(@RequestBody Insurance insuranceResponse){
        return insuranceService.calculateInsurance(insuranceResponse);
    }
}
