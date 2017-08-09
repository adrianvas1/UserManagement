package com.users.service;

import com.users.dao.MessageDaoImpl;
import com.users.domain.Conversation;
import com.users.domain.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    private MessageDaoImpl messageDao;

    @Autowired
    private ConversationService conversationService;

    @Override
    @Transactional
    public List getMessages() {
        return (List) messageDao.findAll();
    }

    @Override
    @Transactional
    public Message create(Message dto) {
        return messageDao.save(dto);
    }
}