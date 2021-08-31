package com.pepperminzia.utility.repository;

import com.pepperminzia.utility.entity.Geographical;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface GeographicalRepository extends JpaRepository<Geographical,Long> {

    public static final String FIND_STATE = "SELECT DISTINCT(REGION1) FROM geographical";
    public static final String FIND_COUNTY = "SELECT DISTINCT(REGION4) FROM geographical";
    public static final String FIND_COUNTY_NAME = "SELECT DISTINCT(REGION4) FROM geographical WHERE REGION1=:state";
    public static final String FIND_POSTALCODE = "SELECT DISTINCT(POSTALCODE) FROM geographical";
    public static final String FIND_POSTALCODE_COUNTY = "SELECT DISTINCT(POSTALCODE) FROM geographical WHERE REGION4=:county";
    public static final String FIND_POSTALCODE_STATE = "SELECT DISTINCT(POSTALCODE) FROM geographical WHERE REGION1=:state";

    @Query(value = FIND_STATE, nativeQuery = true)
    List<String> findByState();

    @Query(value = FIND_COUNTY, nativeQuery = true)
    List<String> findByCounty();

    @Query(value = FIND_COUNTY_NAME, nativeQuery = true)
    List<String> findByCountyName(@Param("state") String state);

    @Query(value = FIND_POSTALCODE_COUNTY, nativeQuery = true)
    List<String> findByPostalCodeCounty(@Param("county") String county);

    @Query(value = FIND_POSTALCODE_STATE, nativeQuery = true)
    List<String> findByPostalCodeState(@Param("state") String state);

    @Query(value = FIND_POSTALCODE, nativeQuery = true)
    List<String> findByPostalCode();
}
