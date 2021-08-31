package com.pepperminzia.utility.service;

import com.pepperminzia.utility.controller.SendMail;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Service
public class SendEmailService {

    Logger logger = LoggerFactory.getLogger(SendEmailService.class);

    @Autowired
    private SendMail sendMail;

    public SendEmailService(SendMail sendMail) {
        this.sendMail = sendMail;
    }

    public void sendEmail(Long quotationId, String mailTo) {
        logger.info("Inside sendEmail method");

        LocalDateTime currentTime = LocalDateTime.now();
        LocalDate currentDate = currentTime.toLocalDate();
        String subject ="Insurance Payment "+ quotationId;
        String text = "Your Insurance Number "+quotationId+" has been acknowledged and processed on "+ currentDate;
        if(mailTo == null){
            mailTo = "akash01.panwar@gmail.com";
        }
        sendMail.sendMessage(mailTo, subject, text);
        logger.info("Email is triggered for the insurance Number "+quotationId);
    }
}
