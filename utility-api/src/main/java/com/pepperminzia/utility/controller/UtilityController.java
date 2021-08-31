package com.pepperminzia.utility.controller;

import com.pepperminzia.utility.service.SendEmailService;
import com.pepperminzia.utility.service.UploadCsvService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/utility")
@CrossOrigin(origins = "*")
public class UtilityController {

    Logger logger = LoggerFactory.getLogger(UtilityController.class);

    @Autowired
    UploadCsvService uploadCsvService;

    @Autowired
    SendEmailService sendEmailService;

    @PostMapping("/upload")
    public void uploadCsvInDatabase(@RequestBody String csvpath){
        logger.info("Inside uploadCsvInDatabase controller ");
        uploadCsvService.uploadCsvInDatabase(csvpath);
    }

    @PostMapping("/email/{id}")
    public void sendEmail(@PathVariable("id") Long quotationId){
        logger.info("Inside sendEmail Method");
        sendEmailService.sendEmail(quotationId, null);
    }

    @PostMapping("/emailRecipient")
    public void sendEmailRecipient(@RequestParam Long insuranceId, @RequestParam String mailTo){
        logger.info("Inside sendEmailRecipient Method");
        sendEmailService.sendEmail(insuranceId, mailTo);
    }


    @GetMapping("/state")
    public List<String> findByState(){
        return uploadCsvService.findByState();
    }

    @GetMapping("/county")
    public List<String> findByCounty(){
        return uploadCsvService.findByCounty();
    }

    @GetMapping("/countyName/{state}")
    public List<String> findByCountyName(@PathVariable("state") String state){
        return uploadCsvService.findByCountyName(state);
    }

    @GetMapping("/postalCodeCounty/{county}")
    public List<String> findByPostalCodeCounty(@PathVariable("county") String county){
        return uploadCsvService.findByPostalCodeCounty(county);
    }

    @GetMapping("/postalCodeState/{state}")
    public List<String> findByPostalCodeState(@PathVariable("state") String state){
        return uploadCsvService.findByPostalCodeState(state);
    }

    @GetMapping("/postalCode")
    public List<String> findByPostalCode(){
        return uploadCsvService.findByPostalCode();
    }

}
