///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package doc;
//
//import java.util.Date;
//import javax.mail.PasswordAuthentication;
//import java.util.Properties;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//import javax.mail.Message;
//import javax.mail.MessagingException;
//import javax.mail.Session;
//import javax.mail.Transport;
//import javax.mail.internet.InternetAddress;
//import javax.mail.internet.MimeMessage;
//
//public class SendmailUseTLS {
//    public static void main(String[] args) {
//        try {
//            Properties p = new Properties();
//            p.setProperty("mail.transport.protocol", "smtp");  
//            p.put("mail.smtp.auth","true");
//            p.put("mail.smtp.starttls.enable", "true"); // phai co lenh nay
//            p.put("mail.smtp.host", "smtp.gmail.com");
//            p.put("mail.starttls.port","587");
//            //p.put("mail.smtp.ssl.enable","false");
//            p.put("mail.smtp.ssl.trust", "smtp.gmail.com"); // va lenh nay !!!!
//            
//            String user = "vythaianh2021@gmail.com";
//            String pass = "vssmonpbcuqrburi"; // app password
//            
//            Session s = Session.getDefaultInstance(p, new javax.mail.Authenticator()
//            {
//                protected PasswordAuthentication getPasswordAuthentication() {
//                    return new PasswordAuthentication(user, pass);
//                }
//                
//            });
//            
//            MimeMessage msg = new MimeMessage(s);
//            msg.setFrom(new InternetAddress("vythaianh2021@gmail.com"));
//            msg.setRecipient(Message.RecipientType.TO,new InternetAddress( "vyta@fpt.edu.vn"));
//            msg.setText("Test Mail trong Java");
//            msg.setSubject("Test JavaMail");
//            msg.setSentDate(new Date());
//            msg.saveChanges();
//            
//     
//            Transport.send(msg);
//        } catch (MessagingException ex) {
//            Logger.getLogger(SendmailUseTLS.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        
//    }
//}
