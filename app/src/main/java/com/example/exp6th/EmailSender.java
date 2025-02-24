package com.example.exp6th;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailSender {

    // Send email using SMTP
    public void sendEmail(final String username, final String password, String recipient, String subject, String body) {
        // Set SMTP server properties
        Properties properties = new Properties();
        properties.put("mail.smtp.host", "smtp.gmail.com");  // Gmail SMTP server
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");

        // Create a session with the specified properties and authentication
        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            // Create email message
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));  // Sender's email
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipient));  // Recipient's email
            message.setSubject(subject);  // Email subject
            message.setText(body);  // Email body

            // Send the email
            Transport.send(message);

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
