package com.tylerjroach.materialdesignexample.model;

/**
 * Created by tylerjroach on 10/17/15.
 */
public class Message {
  private Contact contact;
  private String message;

  public Message(Contact contact, String message) {
    this.contact = contact;
    this.message = message;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public Contact getContact() {
    return contact;
  }

  public void setContact(Contact contact) {
    this.contact = contact;
  }
}
