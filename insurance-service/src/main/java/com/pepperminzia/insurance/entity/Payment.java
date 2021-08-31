package com.pepperminzia.insurance.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Payment {

    private Long paymentId;
    private BigDecimal amountPaid;
    private LocalDate dateOfPayment;
    private String status;

    public Payment() {
    }

    public Payment(Long paymentId, BigDecimal amountPaid, LocalDate dateOfPayment, String status) {
        this.paymentId = paymentId;
        this.amountPaid = amountPaid;
        this.dateOfPayment = dateOfPayment;
        this.status = status;
    }

    public Long getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(Long paymentId) {
        this.paymentId = paymentId;
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
