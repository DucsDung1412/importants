package mail;

import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendMailExample {
    public static void main(String[] args) {
        // Sender's email credentials
        String senderEmail = "nguyenhoahung1007@gmail.com";
        String senderPassword = "miyadhnqogmurwqu";
        
        // Recipient's email address
        String recipientEmail = "zekoxpop@gmail.com";
        
        // Email subject and content
        String emailSubject = "Hello from JavaMail";
        String emailContent = "This is a test email sent from JavaMail.";
        
        // SMTP server configuration
        String smtpHost = "smtp.gmail.com";
        int smtpPort = 587;

        // Set up mail server properties
        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", smtpHost);
        properties.put("mail.smtp.port", smtpPort);
        properties.put("mail.smtp.ssl.protocols", "TLSv1.2");

        // Create an authenticator to authenticate the sender's credentials
        Authenticator authenticator = new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(senderEmail, senderPassword);
            }
        };

        // Create a mail session with the specified properties and authenticator
        Session session = Session.getInstance(properties, authenticator);

        try {
            // Create a new email message
            Message message = new MimeMessage(session);
            
            // Set the sender and recipient addresses
            message.setFrom(new InternetAddress(senderEmail));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipientEmail));
            
            // Set the email subject and content
            message.setSubject(emailSubject);
            message.setText(emailContent);
            
            // Send the email
            Transport.send(message);
            
            System.out.println("Email sent successfully.");
        } catch (MessagingException e) {
            System.out.println("Failed to send email. Error: " + e.getMessage());
        }
    }
}

