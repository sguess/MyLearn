package com.sguess.service;

import java.io.File;
import java.util.Properties;

import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

public class MailService {

    public static void main(String[] args) throws MessagingException {
        MailService service = new MailService();
        service.send();
    }

    public void send() throws MessagingException {
        JavaMailSenderImpl sender = new JavaMailSenderImpl();
        Properties properties = new Properties();
        properties.put("mail.smtp.timeout", 10000);
//		sender.setJavaMailProperties(properties);
        sender.setHost("smtp.sina.com");
        sender.setPort(25);
        sender.setSession(Session.getInstance(properties));
        sender.setUsername("sguess@sina.com");
        sender.setPassword("");

        MimeMessage message = sender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true, "utf-8");
        String from = "sguess@sina.com";
        String to = "danielpei@Objectivasoftware.com";
        String cc = "danielpei@Objectivasoftware.com";
        String subject = "Test";
        helper.setFrom(from);
        helper.setTo(to);
        helper.setCc(cc);
        helper.setSubject(subject);

//		attachFile(helper);

        sender.send(message);
    }

    private void attachFile(MimeMessageHelper helper) throws MessagingException {
        File file = new File("1.txe");
        FileSystemResource res = new FileSystemResource(file);
        String attachmentFilename = "attachedFilename";
        helper.addAttachment(attachmentFilename, res);
    }

}
