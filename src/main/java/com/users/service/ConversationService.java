package com.users.service;

import com.users.domain.Conversation;
import com.users.dto.conversation.ConversationPostDto;

import java.util.List;
import java.util.Set;

/**
 * @author avas
 */
public interface ConversationService {

    Set getConversations(String userId);

    Conversation create(ConversationPostDto dto);

    Conversation getConversationById(String id);
}
