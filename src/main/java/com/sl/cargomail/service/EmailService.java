package com.sl.cargomail.service;

import com.sl.cargomail.model.domain.Mail;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import org.thymeleaf.context.Context;


@Service
public class EmailService {

    private final JavaMailSender javaMailSender;
    public final TemplateEngine templateEngine;

    public EmailService(JavaMailSender javaMailSender, TemplateEngine templateEngine) {
        this.javaMailSender = javaMailSender;
        this.templateEngine = templateEngine;
    }

    public void send(final Mail mail) {

        try {
            createMailMessage(mail);
        } catch (MailException e) {
            e.getMessage();
        }
    }

    private void createMailMessage(final Mail mail) {
        MimeMessage newMail = javaMailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(newMail, true);
            helper.setTo(mail.getMailTo());
            helper.setSubject(mail.getSubject());
            helper.setText(mail.getMessage(), true);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        javaMailSender.send(newMail);
    }

    public void sendMail(String name, String email, String username, String password, String template) {
        String title = "Utworzenie konta w serwisie Cargo Mail";
        Context context = new Context();
        context.setVariable("name", name);
        context.setVariable("username", username);
        context.setVariable("password", password);

        String body = templateEngine.process(template, context);
        send(new Mail(email, title, body));
    }
}
