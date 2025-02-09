package com.example.sendGmailLearn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.mail.MessagingException;  // Используйте Jakarta

@RestController
public class EmailController {

    private final EmailService emailService;

    @Autowired
    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }

    @GetMapping("/send-email")
    public String sendEmail(@RequestParam String to) {
        try {
            emailService.sendEmail(to);
            return "Email sent successfully to " + to;
        } catch (MessagingException e) {
            return "Error sending email: " + e.getMessage();
        }
    }
}
