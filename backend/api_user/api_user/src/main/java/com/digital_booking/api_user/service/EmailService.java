package com.digital_booking.api_user.service;

import com.digital_booking.api_user.util.Log;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.mail.MailProperties;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;

@Log4j
@Service
public class EmailService{

    private MailSender mailSender;
    private JavaMailSender javaMailSender;
    private TemplateEngine templateEngine;
    MailProperties mailProperties;

    @Autowired
    public EmailService(MailSender mailSender, JavaMailSender javaMailSender, TemplateEngine templateEngine, MailProperties mailProperties) {
        this.mailSender = mailSender;
        this.javaMailSender = javaMailSender;
        this.templateEngine = templateEngine;
        this.mailProperties = mailProperties;
    }

    @Async
    public  void sendTextMail(String to, String subject, String body, String cc, String bcc) throws MessagingException{
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setText(body);
        message.setSubject(subject);
        if(cc!=null) message.setCc(cc);
        if(bcc != null) message.setBcc(bcc);
        mailSender.send(message);
    }

    @Async
    public void sendHtmlMail(String to, String subject, String templateName, Context context) throws MessagingException {
        try{
            MimeMessage mail = javaMailSender.createMimeMessage();
            String body = templateEngine.process(templateName, context);
            MimeMessageHelper helper = new MimeMessageHelper(mail, true);
            helper.setFrom("digitalrentcar@gmail.com");
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(body, true);
            javaMailSender.send(mail);
            log.info(Log.formatLog("MAIL-SERVICE", subject + " enviado a " + to));
        } catch (Exception ex) {
            log.info(Log.formatLog("MAIL-SERVICE-FAIL", ex.getMessage()));
        }
    }
}
