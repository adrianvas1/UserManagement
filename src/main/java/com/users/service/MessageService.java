package com.users.service;

import com.users.domain.Message;

import java.util.List;

/**
 * @author avas
 */
public interface MessageService {

    List getMessages(String conversationId);

    Message create(Message dto);
}
