package com.users.service;

import com.users.dao.ConversationDaoImpl;
import com.users.domain.Conversation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class ConversationServiceImpl implements ConversationService {

    @Autowired
    private ConversationDaoImpl conversationDao;

    @Transactional
    public List getConversations(String userId) {
        return (List) conversationDao.findByUserId(userId);
    }

    @Transactional
    public Conversation create(Conversation dto) {
        return conversationDao.save(dto);
    }

}