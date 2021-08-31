package com.pepperminzia.insurance.entity;

public class Insurance {

    private Double mileage;
    private String vehicleType;
    private String postalCode;
    private String county;
    private String state;
    private int regionalClass;

    public Insurance() {
    }

    public Insurance(Double mileage, String vehicleType, String postalCode, String county, String state, int regionalClass) {
        this.mileage = mileage;
        this.vehicleType = vehicleType;
        this.postalCode = postalCode;
        this.county = county;
        this.state = state;
        this.regionalClass = regionalClass;
    }

    public Double getMileage() {
        return mileage;
    }

    public void setMileage(Double mileage) {
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

    public int getRegionalClass() {
        return regionalClass;
    }

    public void setRegionalClass(int regionalClass) {
        this.regionalClass = regionalClass;
    }
}
