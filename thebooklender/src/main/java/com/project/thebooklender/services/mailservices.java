package com.project.thebooklender.services;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.project.thebooklender.dao.*;
import com.project.thebooklender.bean.*;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
public class mailservices {
//
//	    public void sendmail(String title,User user) {
//            bookdao dao=new bookdao();
//           // List<String> emaillist = new ArrayList<String>();
//            List<String> recipientList = dao.getOwnerEmail(title);
//            
//	        final String username = 
//	        		"thebooklender2019@outlook.com";
//	        final String password = "admin@thebooklender";  //removed password for now.
//
//	        Properties props = new Properties();
//	        props.put("mail.smtp.starttls.enable", "true");
//	        props.put("mail.smtp.auth", "true");
//	        props.put("mail.smtp.host", "smtp-mail.outlook.com");
//	        props.put("mail.smtp.port", "587");
//
//	        Session session = Session.getInstance(props,
//	          new javax.mail.Authenticator() {
//	            protected PasswordAuthentication getPasswordAuthentication() {
//	                return new PasswordAuthentication(username, password);
//	            }
//	          });
//
//	        try {
//
//	            Message message = new MimeMessage(session);
//	            message.setFrom(new InternetAddress("thebooklender2019@outlook.com"));
//	           // String[] recipientList = emaillist.split();
//	            InternetAddress[] recipientAddress = new InternetAddress[recipientList.size()];
//	            int counter = 0;
//	            for (String recipient : recipientList) {
//	                recipientAddress[counter] = new InternetAddress(recipient.trim());
//	                counter++;
//	            }
//	            message.setRecipients(Message.RecipientType.TO, recipientAddress);
//	          //  message.setRecipients(Message.RecipientType.TO,
//	           //     InternetAddress.parse("mentlaprabhanjanreddy@gmail.com"));
//	            message.setSubject("theBookLender");
//	            message.setText("Hi I am admin"
//	                + "\n\n Your book has been requested by following user"+
//	            		"\n\n UserName : "+ user.getUser_name() +
//	            		"\n\n UserEmail : "+ user.getUser_email() +
//	            		"\n\n UserAddress : "+user.getAddress() +
//	            		"\n\n Please issue or reject the request.Once you issue book update the same in portal");
//
//	            Transport.send(message);
//
//	            System.out.println("Done");
//
//	        } catch (MessagingException e) {
//	            throw new RuntimeException(e);
//	        }
//	    }
	
	public void sendmail(int bookid,int userid,User user) {
      bookdao dao=new bookdao();
      String emailAddress = dao.getOwnerEmail(bookid);
      
      final String username = "thebooklender2019@outlook.com";
      final String password = "admin@thebooklender";  //removed password for now.

      Properties props = new Properties();
      props.put("mail.smtp.starttls.enable", "true");
      props.put("mail.smtp.auth", "true");
      props.put("mail.smtp.host", "smtp-mail.outlook.com");
      props.put("mail.smtp.port", "587");

      Session session = Session.getInstance(props,
        new javax.mail.Authenticator() {
          protected PasswordAuthentication getPasswordAuthentication() {
              return new PasswordAuthentication(username, password);
          }
        });

      try {
          Message message = new MimeMessage(session);
          message.setFrom(new InternetAddress("thebooklender2019@outlook.com"));
         // String[] recipientList = emaillist.split();
         //message.setRecipients(Message.RecipientType.TO, recipientAddress);
          message.setRecipients(Message.RecipientType.TO,InternetAddress.parse(emailAddress));
          message.setSubject("theBookLender");
          message.setText("Hi I am admin"
              + "\n\n Your book has been requested by following user"+
          		"\n\n UserName : "+ user.getUser_name() +
          		"\n\n UserEmail : "+ user.getUser_email() +
          		"\n\n UserAddress : "+user.getAddress() +
          		"\n\n Please issue or reject the request.Once you issue book update the same in portal");

          Transport.send(message);
          System.out.println("Done");

      } catch (MessagingException e) {
          throw new RuntimeException(e);
      }
  }
	
	public void cancelmail(int bookid,int userid,User user) {
	      bookdao dao=new bookdao();
	      String emailAddress = dao.getOwnerEmail(bookid);
	      
	      final String username = "thebooklender2019@outlook.com";
	      final String password = "admin@thebooklender";  //removed password for now.

	      Properties props = new Properties();
	      props.put("mail.smtp.starttls.enable", "true");
	      props.put("mail.smtp.auth", "true");
	      props.put("mail.smtp.host", "smtp-mail.outlook.com");
	      props.put("mail.smtp.port", "587");

	      Session session = Session.getInstance(props,
	        new javax.mail.Authenticator() {
	          protected PasswordAuthentication getPasswordAuthentication() {
	              return new PasswordAuthentication(username, password);
	          }
	        });

	      try {
	          Message message = new MimeMessage(session);
	          message.setFrom(new InternetAddress("thebooklender2019@outlook.com"));
	         // String[] recipientList = emaillist.split();
	         //message.setRecipients(Message.RecipientType.TO, recipientAddress);
	          message.setRecipients(Message.RecipientType.TO,InternetAddress.parse(emailAddress));
	          message.setSubject("theBookLender");
	          message.setText("Hi I am admin"
	              + "\n\n The request for your book has been cancelled by following user"+
	          		"\n\n UserName : "+ user.getUser_name() +
	          		"\n\n UserEmail : "+ user.getUser_email() +
	          		"\n\n UserAddress : "+user.getAddress());

	          Transport.send(message);

	          System.out.println("Done");

	      } catch (MessagingException e) {
	          throw new RuntimeException(e);
	      }
	  }
	
	
	public void returnmail(int bookid,int userid,User user) {
	      bookdao dao=new bookdao();
	      String emailAddress = dao.getOwnerEmail(bookid);
	      
	      final String username = "thebooklender2019@outlook.com";
	      final String password = "admin@thebooklender";  //removed password for now.

	      Properties props = new Properties();
	      props.put("mail.smtp.starttls.enable", "true");
	      props.put("mail.smtp.auth", "true");
	      props.put("mail.smtp.host", "smtp-mail.outlook.com");
	      props.put("mail.smtp.port", "587");

	      Session session = Session.getInstance(props,
	        new javax.mail.Authenticator() {
	          protected PasswordAuthentication getPasswordAuthentication() {
	              return new PasswordAuthentication(username, password);
	          }
	        });

	      try {
	          Message message = new MimeMessage(session);
	          message.setFrom(new InternetAddress("thebooklender2019@outlook.com"));
	         // String[] recipientList = emaillist.split();
	         //message.setRecipients(Message.RecipientType.TO, recipientAddress);
	          message.setRecipients(Message.RecipientType.TO,InternetAddress.parse(emailAddress));
	          message.setSubject("theBookLender");
	          message.setText("Hi I am admin"
	              + "\n\n The following borrower wants to return your book"+
	          		"\n\n UserName : "+ user.getUser_name() +
	          		"\n\n UserEmail : "+ user.getUser_email() +
	          		"\n\n UserAddress : "+user.getAddress() + 
    		"\n\n Please collect book in hand and approve in the portal.");

	          Transport.send(message);

	          System.out.println("Done");

	      } catch (MessagingException e) {
	          throw new RuntimeException(e);
	      }
	  }
	
	public void getBookBackMail(int userid,User user) {
	      bookdao dao=new bookdao();
	      userdao usdao=new userdao();
	      User borrower = usdao.getUserById(userid);
	      
	      final String username = "thebooklender2019@outlook.com";
	      final String password = "admin@thebooklender";  //removed password for now.

	      Properties props = new Properties();
	      props.put("mail.smtp.starttls.enable", "true");
	      props.put("mail.smtp.auth", "true");
	      props.put("mail.smtp.host", "smtp-mail.outlook.com");
	      props.put("mail.smtp.port", "587");

	      Session session = Session.getInstance(props,
	        new javax.mail.Authenticator() {
	          protected PasswordAuthentication getPasswordAuthentication() {
	              return new PasswordAuthentication(username, password);
	          }
	        });

	      try {
	          Message message = new MimeMessage(session);
	          message.setFrom(new InternetAddress("thebooklender2019@outlook.com"));
	         // String[] recipientList = emaillist.split();
	         //message.setRecipients(Message.RecipientType.TO, recipientAddress);
	          message.setRecipients(Message.RecipientType.TO,InternetAddress.parse(borrower.getUser_email()));
	          message.setSubject("theBookLender");
	          message.setText("Hi I am admin"
	              + "\n\n The following lender requests for his book given to you"+
	          		"\n\n UserName : "+ user.getUser_name() +
	          		"\n\n UserEmail : "+ user.getUser_email() +
	          		"\n\n UserAddress : "+user.getAddress() + 
  		"\n\n Please give the book in hand and ask him/her to approve in the portal.");

	          Transport.send(message);

	          System.out.println("Done");

	      } catch (MessagingException e) {
	          throw new RuntimeException(e);
	      }
	  }
}
