package com.users.dao;

import com.users.domain.Conversation;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository
@Transactional
public class ConversationDaoImpl extends AbstractDao<Conversation> {

    public List<Conversation> findByUserId(String userId) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Conversation.class);
        if (userId != null) {
            criteria.add(Restrictions.eq("userId", userId));
            criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        }
        return criteria.list();
    }
}