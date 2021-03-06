package com.users.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "messages")
public class Message implements Serializable {

    @Id
    @GenericGenerator(name = "uuid2", strategy = "uuid")
    @GeneratedValue(generator = "uuid2")
    @Column(name = "UUID", nullable = false, unique = true, updatable = false)
    private String id;

    @Column(name = "CONTENT")
    private String content;

    @Column(name = "SENDER_UUID")
    private String senderId;

    @Column(name = "CREATED_DTM", nullable = false)
    private Date createdDtm = new Date();

    @Column(name = "UPDATED_DTM", nullable = false)
    private Date updatedDtm = new Date();

    @Column(name = "CONVERSATION_UUID", nullable = false)
    private String conversationId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSenderId() {
        return senderId;
    }

    public void setSenderId(String senderId) {
        this.senderId = senderId;
    }

    public Date getCreatedDtm() {
        return createdDtm;
    }

    public void setCreatedDtm(Date createdDtm) {
        this.createdDtm = createdDtm;
    }

    public Date getUpdatedDtm() {
        return updatedDtm;
    }

    public void setUpdatedDtm(Date updatedDtm) {
        this.updatedDtm = updatedDtm;
    }

    public String getConversationId() {
        return conversationId;
    }

    public void setConversationId(String conversationId) {
        this.conversationId = conversationId;
    }
}