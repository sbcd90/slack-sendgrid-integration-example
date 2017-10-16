package com.slack.sendgrid.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Comment implements Serializable {

  private static final long serialVersionUID = 1L;

  @JsonProperty("timestamp")
  private long timestamp;

  @JsonProperty("user")
  private String user;

  @JsonProperty("comment")
  private String comment;

  public void setTimestamp(long timestamp) {
    this.timestamp = timestamp;
  }

  public long getTimestamp() {
    return timestamp;
  }

  public void setUser(String user) {
    this.user = user;
  }

  public String getUser() {
    return user;
  }

  public void setComment(String comment) {
    this.comment = comment;
  }

  public String getComment() {
    return comment;
  }
}