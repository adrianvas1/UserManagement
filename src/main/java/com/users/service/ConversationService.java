package com.users.service;

import com.users.domain.Conversation;

import java.util.List;

/**
 * @author avas
 */
public interface ConversationService {

    List getConversations(String userId);

    Conversation create(Conversation dto);
}
