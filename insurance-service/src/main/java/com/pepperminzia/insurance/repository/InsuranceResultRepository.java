package com.pepperminzia.insurance.repository;

import com.pepperminzia.insurance.entity.Insurance;
import com.pepperminzia.insurance.entity.InsurancePaymentTrans;
import com.pepperminzia.insurance.entity.InsuranceResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InsuranceResultRepository extends JpaRepository<InsuranceResult,Long> {
    List<InsuranceResult> findAll();
}
