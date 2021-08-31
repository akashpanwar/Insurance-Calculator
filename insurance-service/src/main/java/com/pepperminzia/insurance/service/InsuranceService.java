package com.pepperminzia.insurance.service;

import com.pepperminzia.insurance.entity.Insurance;
import com.pepperminzia.insurance.entity.InsurancePaymentTrans;
import com.pepperminzia.insurance.entity.InsuranceResult;
import com.pepperminzia.insurance.entity.Payment;
import com.pepperminzia.insurance.repository.InsuranceResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class InsuranceService {

    @Autowired
    private InsuranceResultRepository insuranceResultRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Value("${payment.url}")
    private String paymentUrl;

    public InsuranceService(InsuranceResultRepository insuranceResultRepository, RestTemplate restTemplate) {
        this.insuranceResultRepository = insuranceResultRepository;
        this.restTemplate = restTemplate;
    }

    public InsuranceResult calculateInsurance(Insurance insuranceResponse){
        double premium = 0;
        Integer typeClass = 0;
        InsuranceResult result = new InsuranceResult();

        try {
            if (insuranceResponse.getVehicleType().equalsIgnoreCase("Car")) {
                typeClass = 50000;
            } else if (insuranceResponse.getVehicleType().equalsIgnoreCase("Motorcycle")) {
                typeClass = 40000;
            } else if (insuranceResponse.getVehicleType().equalsIgnoreCase("Truck")) {
                typeClass = 30000;
            } else if (insuranceResponse.getVehicleType().equalsIgnoreCase("Minivan")) {
                typeClass = 20000;
            }

            premium = insuranceResponse.getMileage() * typeClass * insuranceResponse.getRegionalClass();

            if (insuranceResponse.getMileage() == 0.5) {
                result.setMileage("0-5,000 km");
            } else if (insuranceResponse.getMileage() == 1) {
                result.setMileage("5,001 - 10,000 km");
            } else if (insuranceResponse.getMileage() == 1.5) {
                result.setMileage("10,001-20,000 km");
            } else if (insuranceResponse.getMileage() == 2) {
                result.setMileage("above 20,000 km");
            }

            if (insuranceResponse.getRegionalClass() == 1) {
                result.setRegionalClass("Private");
            } else {
                result.setRegionalClass("Commercial");
            }

            int randomNum = ThreadLocalRandom.current().nextInt(100000, 999999 + 1);
            result.setQuotationId(Long.valueOf(randomNum));

            result.setVehicleType(insuranceResponse.getVehicleType());
            result.setState(insuranceResponse.getState());
            result.setCounty(insuranceResponse.getCounty());
            result.setPostalCode(insuranceResponse.getPostalCode());
            result.setResult(premium);
            insuranceResultRepository.save(result);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return result;
    };

    public List<InsurancePaymentTrans> getAllInsuranceTransactions() {
        List<InsurancePaymentTrans> insurancePaymentTransList = new ArrayList<>();

        List<InsuranceResult> insuranceResultList = insuranceResultRepository.findAll();

        insuranceResultList.forEach(insuranceResult -> {

            InsurancePaymentTrans insurancePaymentTrans = new InsurancePaymentTrans();
            insurancePaymentTrans.setMileage(insuranceResult.getMileage());
            insurancePaymentTrans.setVehicleType(insuranceResult.getVehicleType());
            insurancePaymentTrans.setRegionalClass(insuranceResult.getRegionalClass());
            insurancePaymentTrans.setState(insuranceResult.getState());
            insurancePaymentTrans.setCounty(insuranceResult.getCounty());
            insurancePaymentTrans.setPostalCode(insuranceResult.getPostalCode());
            insurancePaymentTrans.setResult(insuranceResult.getResult());
            insurancePaymentTrans.setQuotationId(insuranceResult.getQuotationId());

            Payment payment = restTemplate.getForObject(paymentUrl + insuranceResult.getQuotationId(), Payment.class);

            if (payment != null) {
                insurancePaymentTrans.setInsuranceId(payment.getPaymentId());
                insurancePaymentTrans.setAmountPaid(payment.getAmountPaid());
                insurancePaymentTrans.setDateOfPayment(payment.getDateOfPayment());
                insurancePaymentTrans.setStatus(payment.getStatus());
            }
            insurancePaymentTransList.add(insurancePaymentTrans);
        });

        return insurancePaymentTransList;
    }
}
