package com.slack.sendgrid.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
public class FileCommentEvent implements Serializable {

  private static final long serialVersionUID = 1L;

  @JsonProperty("token")
  private String token;

  @JsonProperty("team_id")
  private String teamId;

  @JsonProperty("event")
  private FileEvent event;

  public void setToken(String token) {
    this.token = token;
  }

  public String getToken() {
    return token;
  }

  public void setTeamId(String teamId) {
    this.teamId = teamId;
  }

  public String getTeamId() {
    return teamId;
  }

  public void setEvent(FileEvent event) {
    this.event = event;
  }

  public FileEvent getEvent() {
    return event;
  }
}