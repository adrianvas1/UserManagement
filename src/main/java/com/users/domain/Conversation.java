package com.users.domain;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

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

    @OneToMany(mappedBy = "conversation", cascade = CascadeType.ALL, orphanRemoval = true)
    @Fetch(FetchMode.JOIN)
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

    public Set<Message> getMessages() {
        return messages;
    }

    public void setMessages(Set<Message> messages) {
        this.messages = messages;
    }
}