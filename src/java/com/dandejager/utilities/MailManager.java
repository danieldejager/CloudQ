/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package disc.tiinfosec.utilities;
import java.io.InputStream;
import java.util.Properties;
import javax.mail.Address;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
/**
 *
 * @author daniel112
 */
public class MailManager {
    
    
    
     private String getMailServerIP() {
     try {
        String parameters="";
        Properties p = new Properties();
        ClassLoader loader = getClass().getClassLoader();
        InputStream io = loader.getResourceAsStream("configuration.properties");
        if (loader == null) {
            System.out.println("loader is null");
        } else if (io != null) {
            p.load(io);
            parameters  = p.getProperty("email_server_ip");
        } else {
            System.out.println("Parameters is null");
        }
            return parameters;
     } catch (Exception ex) {
         System.out.println(ex.getMessage());
         return "";
     }
    }
     
     private String NoReplyEmailAddress() {
     try {
        String parameters="";
        Properties p = new Properties();
        ClassLoader loader = getClass().getClassLoader();
        InputStream io = loader.getResourceAsStream("configuration.properties");
        if (loader == null) {
            System.out.println("loader is null");
        } else if (io!= null) {
            p.load(io);
            parameters  = p.getProperty("email_server_noreply");
        } else {
            System.out.println("Parameters is null");
        }
            return parameters;
     } catch (Exception ex) {
         System.out.println(ex.getMessage());
         return "";
     }
    }
     
      private String getAdminEmail() {
     try {
        String parameters="";
        Properties p = new Properties();
        ClassLoader loader = getClass().getClassLoader();
        InputStream io = loader.getResourceAsStream("configuration.properties");
        if (loader == null) {
            System.out.println("loader is null");
        } else if (io!=null) {
            p.load(io);
            parameters  = p.getProperty("admin_email_address");
        } else {
            System.out.println("Parameters is null");
        }
            return parameters;
     } catch (Exception ex) {
         System.out.println(ex.getMessage());
         return "";
     }
    }
     
     
     
     public void sendEmailToAdmin(String p_message) {
            Properties props = new Properties();
            props.put("mail.smtp.auth","false");
            props.put("mail.smtp.starttls.enable", "false");
            props.put("mail.smtp.host", getMailServerIP());
            props.put("mail.smtp.port", 25);
            
            Session session = Session.getInstance(props);
            
            try {
                Message message = new MimeMessage(session);
                message.setFrom(new InternetAddress(NoReplyEmailAddress()));
                message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(getAdminEmail()));
                message.setSubject("Do not Reply - Discovery Cloud Questionnaire");
                message.setText(p_message);
                Transport.send(message);
                System.out.println("Message has been sent");
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
     }
     
      public void sendEmailToVendor(String p_message, String p_email_address) {
            Properties props = new Properties();
            props.put("mail.smtp.auth","false");
            props.put("mail.smtp.starttls.enable", "false");
            props.put("mail.smtp.host", getMailServerIP());
            props.put("mail.smtp.port", 25);
            System.out.println("So the settings are done");
            Session session = Session.getInstance(props);
            if (session!=null) {
                System.out.println("Got the session object");
            } else {
                System.out.println("Ooops the session is null");
            }
            
            try {
                Message message = new MimeMessage(session);
                message.setFrom(new InternetAddress(NoReplyEmailAddress()));
                System.out.println(Message.RecipientType.TO);
                System.out.println(InternetAddress.parse(p_email_address));
                System.out.println(p_email_address);
                message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(p_email_address));
                message.setSubject("Do not Reply - Discovery Cloud Questionnaire");
                message.setText(p_message);
                System.out.println("Text has been set");
                Transport.send(message);
                System.out.println("Transporting Message Sucecssfull");
                System.out.println("Message has been sent");
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
     }
}
