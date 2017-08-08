package com.users.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "messages")
public class Message implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "UUID", nullable = false, unique = true, updatable = false)
    private String id;

    @Column(name = "CONTENT")
    private String content;

    @Column(name = "CREATED_DTM", nullable = false)
    private Date createdDtm;

    @Column(name = "UPDATED_DTM", nullable = false)
    private Date updatedDtm;

    @ManyToOne
    @JoinColumn(name = "CONVERSATION_UUID", nullable = false)
    private Conversation conversation;

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

    public Conversation getConversation() {
        return conversation;
    }

    public void setConversation(Conversation conversation) {
        this.conversation = conversation;
    }
}