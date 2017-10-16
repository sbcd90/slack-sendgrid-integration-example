package com.slack.sendgrid.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
public class FileEvent implements Serializable {

  private static final long serialVersionUID = 1L;

  @JsonProperty("type")
  private String eventType;

  @JsonProperty("file_id")
  private String fileId;

  @JsonProperty("user_id")
  private String userId;

  private Comment comment;

  public void setEventType(String eventType) {
    this.eventType = eventType;
  }

  public String getEventType() {
    return eventType;
  }

  public void setFileId(String fileId) {
    this.fileId = fileId;
  }

  public String getFileId() {
    return fileId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  public String getUserId() {
    return userId;
  }

  public void setComment(Comment comment) {
    this.comment = comment;
  }

  public Comment getComment() {
    return comment;
  }
}