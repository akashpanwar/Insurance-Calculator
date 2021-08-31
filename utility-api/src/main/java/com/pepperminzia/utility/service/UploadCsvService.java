package com.pepperminzia.utility.service;

import com.pepperminzia.utility.entity.Geographical;
import com.pepperminzia.utility.repository.GeographicalRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.supercsv.cellprocessor.Optional;
import org.supercsv.cellprocessor.constraint.NotNull;
import org.supercsv.cellprocessor.ift.CellProcessor;
import org.supercsv.io.CsvBeanReader;
import org.supercsv.io.ICsvBeanReader;
import org.supercsv.prefs.CsvPreference;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@Service
public class UploadCsvService {

    Logger logger = LoggerFactory.getLogger(UploadCsvService.class);

    @Autowired
    private GeographicalRepository geographicalRepository;

    public UploadCsvService(GeographicalRepository geographicalRepository) {
        this.geographicalRepository = geographicalRepository;
    }

    public void uploadCsvInDatabase(String csvFilePath) {
        logger.info("Entering uploadCsvInDatabase service: CSV File Path - "+csvFilePath);
        int batchSize = 500;

        Connection connection = null;

        ICsvBeanReader beanReader = null;
        CellProcessor[] processors = new CellProcessor[] {
                new NotNull(), // alpha 2
                new NotNull(), // alpha 2 region code
                new NotNull(), // region 1
                new Optional(), // region 2
                new Optional(), // region 3
                new Optional(), // region 4
                new NotNull(), // postal code
                new Optional(), // location
                new Optional(), // Area 1
                new Optional(), // Area 2
                new Optional(), // Latitude
                new Optional(), // Longitude
                new Optional(), // timezone
                new Optional(), // UTC
                new Optional(), //Summertime
                new Optional() // Active
        };

        try {
            long start = System.currentTimeMillis();

            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test_insurance", "root", "password");
            connection.setAutoCommit(false);

            String sql = "INSERT INTO geographical ( " +
                    "ALPHA_2, ALPHA_2_REGION_CODE, REGION1, REGION2, REGION3, REGION4, POSTALCODE, LOCATION, " +
                    "AREA1, AREA2, LATITUDE, LONGITUDE, TIMEZONE, UTC, SUMMERTIME, ACTIVE, GEOGRAPHICAL_ID ) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement statement = connection.prepareStatement(sql);

            beanReader = new CsvBeanReader(new FileReader(csvFilePath), CsvPreference.STANDARD_PREFERENCE);

            beanReader.getHeader(true); // skip header line

            String[] header = {"ALPHA_2", "ALPHA_2_REGION_CODE","REGION1", "REGION2", "REGION3",
                    "REGION4", "postalcode", "location","AREA1", "AREA2", "latitude", "longitude",
                    "timezone", "UTC","summertime","ACTIVE"};

            Geographical bean = null;

            int count = 0;
            long value = 1;

            while ((bean = beanReader.read(Geographical.class, header, processors)) != null) {
                Long id = value++;
                String alpha2 = bean.getAlpha_2();
                String alphaRegionCode = bean.getAlpha_2_region_code();
                String region1 = bean.getRegion1();
                String region2 = bean.getRegion2();
                String region3 = bean.getRegion3();
                String region4 = bean.getRegion4();
                String postalCode = bean.getPostalcode();
                String location = bean.getLocation();
                String area1 = bean.getArea1();
                String area2 = bean.getArea2();
                String latitude = bean.getLatitude();
                String longitude = bean.getLongitude();
                String timezone = bean.getTimezone();
                String utc = bean.getUtc();
                String summerTime = bean.getSummertime();
                String active = bean.getActive();

                statement.setString(1, alpha2.replace("\"", "").trim());
                statement.setString(2, alphaRegionCode.replace("\"", "").trim());
                statement.setString(3, region1.replace("\"", "").trim());
                statement.setString(4, region2.replace("\"", "").trim());
                statement.setString(5, region3.replace("\"", "").trim());
                statement.setString(6, region4.replace("\"", "").trim());
                statement.setString(7, postalCode.replace("\"", "").trim());
                statement.setString(8, location.replace("\"", "").trim());
                statement.setString(9, area1.replace("\"", "").trim());
                statement.setString(10, area2.replace("\"", "").trim());
                statement.setString(11, latitude.replace("\"", "").trim());
                statement.setString(12, longitude.replace("\"", "").trim());
                statement.setString(13, timezone.replace("\"", "").trim());
                statement.setString(14, utc.replace("\"", "").trim());
                statement.setString(15, summerTime.replace("\"", "").trim());
                statement.setString(16, active.replace("\"", "").trim());
                statement.setLong(17,id);

                statement.addBatch();

                if (count % batchSize == 0) {
                    statement.executeBatch();
                }
            }

            beanReader.close();
            statement.executeBatch();

            connection.commit();
            connection.close();

            long end = System.currentTimeMillis();
            logger.info("Execution Time to impot the data into DB : " + (end - start));
        } catch (IOException ex) {
            logger.error("IO Exception occurred ",ex);
        } catch (SQLException ex) {
            logger.error("SQL Exception occurred ",ex);

            try {
                connection.rollback();
            } catch (SQLException e) {
                logger.error("SQL Exception occurred while rolling back",ex);
            }
        }
        logger.info("Exiting uploadCsvInDatabase service");
    }


    @Cacheable("findByState")
    public List<String> findByState(){
        return geographicalRepository.findByState();
    }

    @Cacheable("findByCounty")
    public List<String> findByCounty(){
        return geographicalRepository.findByCounty();
    }

    @Cacheable("findByCountyName")
    public List<String> findByCountyName(String state){
        return geographicalRepository.findByCountyName(state);
    }

    @Cacheable("findByPostalCode")
    public List<String> findByPostalCode(){
        return geographicalRepository.findByPostalCode();
    }

    public List<String> findByPostalCodeCounty(String county) {
        return geographicalRepository.findByPostalCodeCounty(county);
    }

    public List<String> findByPostalCodeState(String state) {
        return geographicalRepository.findByPostalCodeState(state);
    }
}
