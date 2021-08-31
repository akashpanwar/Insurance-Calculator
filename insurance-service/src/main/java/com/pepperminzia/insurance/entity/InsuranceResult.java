package com.pepperminzia.insurance.entity;

import javax.persistence.*;

@Entity
@Table(name = "insurance_quotation")
public class InsuranceResult {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long resultId;
    private Long quotationId;
    private String mileage;
    private String vehicleType;
    private String postalCode;
    private String county;
    private String state;
    private String regionalClass;
    private Double result;

    public InsuranceResult() {
    }

    public InsuranceResult(Long resultId, Long quotationId, String mileage, String vehicleType, String postalCode, String county, String state, String regionalClass, Double result) {
        this.resultId = resultId;
        this.quotationId = quotationId;
        this.mileage = mileage;
        this.vehicleType = vehicleType;
        this.postalCode = postalCode;
        this.county = county;
        this.state = state;
        this.regionalClass = regionalClass;
        this.result = result;
    }

    public Long getResultId() {
        return resultId;
    }

    public void setResultId(Long resultId) {
        this.resultId = resultId;
    }

    public Long getQuotationId() {
        return quotationId;
    }

    public void setQuotationId(Long quotationId) {
        this.quotationId = quotationId;
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
}
