package com.pepperminzia.insurance.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

public class InsurancePaymentTrans {

    private Long quotationId;
    private Long insuranceId;
    private String mileage;
    private String vehicleType;
    private String postalCode;
    private String county;
    private String state;
    private String regionalClass;
    private Double result;
    private BigDecimal amountPaid;
    private LocalDate dateOfPayment;
    private String status;

    public InsurancePaymentTrans() {
    }

    public InsurancePaymentTrans(Long quotationId, Long insuranceId, String mileage, String vehicleType,
                                 String postalCode, String county, String state, String regionalClass, Double result,
                                 BigDecimal amountPaid, LocalDate dateOfPayment, String status) {
        this.quotationId = quotationId;
        this.insuranceId = insuranceId;
        this.mileage = mileage;
        this.vehicleType = vehicleType;
        this.postalCode = postalCode;
        this.county = county;
        this.state = state;
        this.regionalClass = regionalClass;
        this.result = result;
        this.amountPaid = amountPaid;
        this.dateOfPayment = dateOfPayment;
        this.status = status;
    }

    public Long getQuotationId() {
        return quotationId;
    }

    public void setQuotationId(Long quotationId) {
        this.quotationId = quotationId;
    }

    public Long getInsuranceId() {
        return insuranceId;
    }

    public void setInsuranceId(Long insuranceId) {
        this.insuranceId = insuranceId;
    }

    public String getMileage() {
        return mileage;
    }

    public void setMileage(String mileage) {
        this.mileage = mileage;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getRegionalClass() {
        return regionalClass;
    }

    public void setRegionalClass(String regionalClass) {
        this.regionalClass = regionalClass;
    }

    public Double getResult() {
        return result;
    }

    public void setResult(Double result) {
        this.result = result;
    }

    public BigDecimal getAmountPaid() {
        return amountPaid;
    }

    public void setAmountPaid(BigDecimal amountPaid) {
        this.amountPaid = amountPaid;
    }

    public LocalDate getDateOfPayment() {
        return dateOfPayment;
    }

    public void setDateOfPayment(LocalDate dateOfPayment) {
        this.dateOfPayment = dateOfPayment;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
