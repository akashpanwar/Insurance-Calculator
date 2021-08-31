package com.pepperminzia.utility.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.mail.javamail.JavaMailSender;

import javax.mail.Session;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class SendMailTest {

    @Mock
    private JavaMailSender mockJavaMail;

    @InjectMocks
    @Spy
    private SendMail mockSendEmail;

    @Test
    public void testSendMessage() {

        final MimeMessage mimeMessage = new MimeMessage(Session.getInstance(new Properties()));
        when(mockJavaMail.createMimeMessage()).thenReturn(mimeMessage);

        mockSendEmail.sendMessage("to", "subject", "body");

        verify(mockJavaMail).send(any(MimeMessage.class));
    }
}
