package com.example.myapplication.models;

import java.util.Date;

/**
 * Represents a message in the system.
 */
public final class Message {
    private String userName;
    private String textMessage;
    private long messageTime;

    /**
     * Default constructor.
     */
    public Message() {}

    /**
     * Creates a new message with the given username and text message.
     *
     * @param userName     The username of the sender.
     * @param textMessage  The text content of the message.
     */
    public Message(final String userName, final String textMessage) {
        this.userName = userName;
        this.textMessage = textMessage;
        this.messageTime = new Date().getTime();
    }

    /**
     * Gets the username of the sender.
     *
     * @return The username.
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Sets the username of the sender.
     *
     * @param newUserName The new username.
     */
    public void setUserName(final String newUserName) {
        this.userName = newUserName;
    }

    /**
     * Gets the text content of the message.
     *
     * @return The text content.
     */
    public String getTextMessage() {
        return textMessage;
    }

    /**
     * Sets the text content of the message.
     *
     * @param newTextMessage The new text content.
     */
    public void setTextMessage(final String newTextMessage) {
        this.textMessage = newTextMessage;
    }

    /**
     * Gets the timestamp of the message.
     *
     * @return The timestamp.
     */
    public long getMessageTime() {
        return messageTime;
    }

    /**
     * Sets the timestamp of the message.
     *
     * @param newMessageTime The new timestamp.
     */
    public void setMessageTime(final long newMessageTime) {
        this.messageTime = newMessageTime;
    }
}
