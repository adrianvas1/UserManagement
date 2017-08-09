package com.users.dto.conversation;

import com.users.dto.message.MessageGetDto;
import com.users.dto.user.UserGetDto;

import java.io.Serializable;
import java.util.*;

public class ConversationGetDto implements Serializable {

    private String id;

    private Date createdDtm = new Date();

    private String userId;

    private Set<MessageGetDto> messages = new HashSet<>();

    private List<UserGetDto> participants = new ArrayList<>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getCreatedDtm() {
        return createdDtm;
    }

    public void setCreatedDtm(Date createdDtm) {
        this.createdDtm = createdDtm;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Set<MessageGetDto> getMessages() {
        return messages;
    }

    public void setMessages(Set<MessageGetDto> messages) {
        this.messages = messages;
    }

    public List<UserGetDto> getParticipants() {
        return participants;
    }

    public void setParticipants(List<UserGetDto> participants) {
        this.participants = participants;
    }
}