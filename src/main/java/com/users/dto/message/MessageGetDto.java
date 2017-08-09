package com.users.dto.message;

import java.io.Serializable;
import java.util.Date;

public class MessageGetDto implements Serializable {

    private String id;

    private String content;

    private Date createdDtm = new Date();

    private Date updatedDtm = new Date();

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