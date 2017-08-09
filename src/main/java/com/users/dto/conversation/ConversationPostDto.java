package com.users.dto.conversation;

import com.users.dto.message.MessageGetDto;
import com.users.dto.user.UserGetDto;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.*;

public class ConversationPostDto implements Serializable {

    private String id;

    private Date createdDtm = new Date();

    private String userId;

    private Set<MessageGetDto> messages = new HashSet<>();

    @NotNull
    private Set<String> participantIds;

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

    public Set<String> getParticipantIds() {
        return participantIds;
    }

    public void setParticipantIds(Set<String> participantIds) {
        this.participantIds = participantIds;
    }
}