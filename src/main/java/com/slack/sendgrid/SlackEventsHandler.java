package com.slack.sendgrid;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.slack.sendgrid.models.FileCommentEvent;
import com.slack.sendgrid.models.SlackRegistration;
import org.apache.commons.io.IOUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SlackEventsHandler extends HttpServlet {

  private static final String SLACK_TOKEN = System.getenv("SLACK_TOKEN");
  private final SendGridMailSender mailSender;

  public SlackEventsHandler() {
    this.mailSender = new SendGridMailSender();
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String body = IOUtils.toString(req.getInputStream(), "UTF-8");

    /**
     * this is slack registry call
     */
    if (body.contains("challenge")) {
      ObjectMapper mapper = new ObjectMapper();
      SlackRegistration slackRegistry = mapper.readValue(body, SlackRegistration.class);

      if (SLACK_TOKEN.equals(slackRegistry.getToken())) {
        resp.setStatus(200);
        resp.getWriter().write(slackRegistry.getChallenge());
      } else {
        resp.setStatus(400);
        resp.getWriter().write("Bad Request");
      }
    } else {
      ObjectMapper mapper = new ObjectMapper();
      FileCommentEvent fileCommentEvent = mapper.readValue(body, FileCommentEvent.class);

      if (SLACK_TOKEN.equals(fileCommentEvent.getToken())) {
        if (mailSender.sendEmail(fileCommentEvent.getTeamId(),
          fileCommentEvent.getEvent().getUserId(),
          fileCommentEvent.getEvent().getFileId(),
          fileCommentEvent.getEvent().getComment().getTimestamp(),
          fileCommentEvent.getEvent().getComment().getComment())) {
          resp.setStatus(200);
          resp.getWriter().write("Acknowledge event received");
        } else {
          resp.setStatus(400);
          resp.getWriter().write("Acknowledge event receive failed");
        }
      } else {
        resp.setStatus(400);
        resp.getWriter().write("Acknowledge event receive failed");
      }
    }
  }
}