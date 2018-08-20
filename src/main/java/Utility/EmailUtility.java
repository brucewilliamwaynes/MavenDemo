package Utility;

import java.util.Date;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailUtility {

	public static void sendEmail( Session session , String toEmail , String subject , String body ) {
		
		try {
			
			MimeMessage msg = new MimeMessage( session );
			
			msg.setFrom(new InternetAddress("no_reply@example.com", "NoReply-JD"));

			msg.setReplyTo(InternetAddress.parse("no_reply@example.com", false));

			msg.setSubject(subject, "UTF-8");

		    msg.setText(body, "UTF-8");

		    msg.setSentDate(new Date());

		    msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail, false));
	    	  
		    Transport.send(msg);
			
		}
		
		catch (Exception e) {
			
			e.printStackTrace();
			
		}
		
		
	}
	
}
