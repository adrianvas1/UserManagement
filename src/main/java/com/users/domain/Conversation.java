package com.users.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity
@Table(name = "conversations")
public class Conversation implements Serializable {

    @Id
    @GenericGenerator(name = "uuid2", strategy = "uuid")
    @GeneratedValue(generator = "uuid2")
    @Column(name = "UUID", nullable = false, unique = true, updatable = false)
    private String id;

    @Column(name = "CREATED_DTM", nullable = false)
    private Date createdDtm = new Date();

    @Column(name = "USER_UUID", nullable = false)
    private String userId;

    @Column(name = "PARTICIPANT_IDS", nullable = false)
    private String participantIds;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "CONVERSATION_UUID")
    private Set<Message> messages = new HashSet<>();

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

    public String getParticipantIds() {
        return participantIds;
    }

    public void setParticipantIds(String participantIds) {
        this.participantIds = participantIds;
    }

    public Set<Message> getMessages() {
        return messages;
    }

    public void setMessages(Set<Message> messages) {
        this.messages = messages;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Conversation that = (Conversation) o;

        return id != null ? id.equals(that.id) : that.id == null;

    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}