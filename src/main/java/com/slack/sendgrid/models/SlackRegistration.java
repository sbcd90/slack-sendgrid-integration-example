package com.slack.sendgrid.models;

import java.io.Serializable;

public class SlackRegistration implements Serializable {
  private final static long serialVersionUID = 1L;

  private String token;

  private String challenge;

  private String type;

  public void setToken(String token) {
    this.token = token;
  }

  public String getToken() {
    return token;
  }

  public void setChallenge(String challenge) {
    this.challenge = challenge;
  }

  public String getChallenge() {
    return challenge;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getType() {
    return type;
  }
}