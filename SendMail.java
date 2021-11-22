package Controllers;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class SendMail {

    public static void Send_mail(String mail,String Nome,String Cognome,String User) {

        final String username = "mpj.project.igpe@gmail.com";
        final String password = "Mpj_2021";

        Properties prop = new Properties();
		prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "465");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.socketFactory.port", "465");
        prop.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        
        Session session = Session.getInstance(prop,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("mpj.project.igpe@gmail.com"));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(mail)
            );
            message.setSubject("Benvenuto in Mpj: "+User);
            message.setContent("<!DOCTYPE html>"
            					+ "<html>"
            						+ "<head><meta charset='utf-8'</head>"
            						+ "<body>"
            							+ "<h1>Gentile "+Nome+" "+Cognome+",benvenuto in Mpj!</h1>"
            						+ "</body"
            						+ "</html>",
                    			"text/html");
            // aggiungere file html figo
            Transport.send(message);
            System.out.println("Messaggio inviato");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

}
