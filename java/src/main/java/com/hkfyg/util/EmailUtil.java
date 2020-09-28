package com.hkfyg.util;

import com.sendgrid.*;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EmailUtil {	
	public static void sendEmail(String recipientEmail) throws IOException {
		Logger logger = LoggerFactory.getLogger(EmailUtil.class);
		logger.info("sendEmail() to recipient: " + recipientEmail);
		
		Email from = new Email("pso@opm.com.hk");
	    String subject = "Job Application Received";
	    Email to = new Email(recipientEmail);
	    Content content = new Content("text/plain", 
	    		"Dear Applicant,<br> "
	    		+ "<br>"
	    		+ "Your application will be reviewed in a short time,<br>"
	    		+ "Please relax and enjoy your day!<br>"
	    		+ "<br>"
	    		+ "No need to reply to this email, and if you have any concerns,"
	    		+ "Feel free to contact us through phone: 3743 8900.<br>"
	    		+ "<br>"
	    		+ "Thank you.");
	    Mail mail = new Mail(from, subject, to, content);

	    SendGrid sg = new SendGrid("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");
	    Request request = new Request();
	    try {
	      request.setMethod(Method.POST);
	      request.setEndpoint("mail/send");
	      request.setBody(mail.build());
	      Response response = sg.api(request);
	      logger.info("sendEmail end with status code: " + response.getStatusCode());
	    } catch (IOException ex) {
	      throw ex;
	    }
	}	
}
