package com.users.service;

import com.users.dto.conversation.ConversationGetDto;
import com.users.dto.conversation.ConversationPostDto;

import java.util.Set;

/**
 * @author avas
 */
public interface ConversationService {

    Set getConversations(String userId);

    ConversationGetDto create(ConversationPostDto dto);

    ConversationGetDto getConversationById(String id);
}
