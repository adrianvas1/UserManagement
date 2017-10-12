package com.users.dao;

import com.users.domain.Message;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class MessageDaoImpl extends AbstractDao<Message> {

    public List findByConversationId(String conversationId) {
        return (List<Message>) sessionFactory.getCurrentSession().createCriteria(Message.class)
                .add(Restrictions.eq("conversationId", conversationId))
                .list();
    }
}