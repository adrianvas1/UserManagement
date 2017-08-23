package com.users.dto.conversation;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Set;

public class ConversationPostDto implements Serializable {

    private String userId;

    @NotNull
    private Set<String> participantIds;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Set<String> getParticipantIds() {
        return participantIds;
    }

    public void setParticipantIds(Set<String> participantIds) {
        this.participantIds = participantIds;
    }
}