package com.pepperminzia.utility.service;

import com.pepperminzia.utility.controller.SendMail;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class SendEmailServiceTest {

    @Mock
    private SendMail mockSendMail;

    @Mock
    private SendEmailService mockEmailService;

    @Before
    public void setUp() {
        mockEmailService = new SendEmailService(mockSendMail);
    }

    @Test
    public void testSendEmail() {

        LocalDateTime currentTime = LocalDateTime.now();
        LocalDate currentDate = currentTime.toLocalDate();
        String subject ="Insurance Payment 0";
        String text = "Your Insurance Number 0 has been acknowledged and processed on "+ currentDate;

        mockEmailService.sendEmail(0L, "mailTo");
        verify(mockSendMail,times(1)).sendMessage("mailTo", subject, text);
    }
}
