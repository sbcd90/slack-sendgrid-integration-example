package com.slack.sendgrid;

import com.sendgrid.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.sql.Timestamp;

public class SendGridMailSender {
  private static final Logger LOG = LoggerFactory.getLogger(SendGridMailSender.class);
  private static final String FROM_EMAIL_ADDRESS = "admin@slack.com";
  private static final String TO_EMAIL_ADDRESS = "subhobrata.mytab@gmail.com";

  public boolean sendEmail(String teamId, String user, String fileId, long timestamp, String fileComment) {
    Email from = new Email(FROM_EMAIL_ADDRESS);
    String subject = String.format("[Slack]New comment in File %s posted by user %s in team %s", fileId, user, teamId);
    Email to = new Email(TO_EMAIL_ADDRESS);
    Content content = new Content("text/plain", fileComment + "\n" + new Timestamp(timestamp).toString());
    Mail mail = new Mail(from, subject, to, content);

    com.sendgrid.SendGrid sg = new com.sendgrid.SendGrid(System.getenv("SENDGRID_API_KEY"));
    Request request = new Request();
    try {
      request.setMethod(Method.POST);
      request.setEndpoint("mail/send");
      request.setBody(mail.build());
      Response response = sg.api(request);

      if (response.getStatusCode() == 202) {
        return true;
      } else {
        return false;
      }
    } catch (IOException ex) {
      LOG.error(ex.getMessage());
      return false;
    }
  }
}