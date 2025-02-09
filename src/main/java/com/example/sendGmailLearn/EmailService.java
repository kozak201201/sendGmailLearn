package com.example.sendGmailLearn;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import jakarta.mail.MessagingException;  // Используйте Jakarta
import jakarta.mail.internet.MimeMessage;  // Используйте Jakarta

@Service
public class EmailService {
    //add some code 1
    private final JavaMailSender mailSender;

    public EmailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void sendEmail(String to) throws MessagingException {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);

        // Настройки письма
        helper.setTo(to);
        helper.setSubject("Test Email");
        helper.setText("Hello", false);  // false - текст не будет в формате HTML

        // Отправка сообщения
        mailSender.send(message);
    }
}
