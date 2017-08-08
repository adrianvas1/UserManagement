package com.users.dao;

import com.users.domain.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public abstract class ConversationDao {

    @Autowired
    @Qualifier(value = "sessionFactory")
    private SessionFactory sessionFactory;


}