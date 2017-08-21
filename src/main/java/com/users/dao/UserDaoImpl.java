package com.users.dao;

import com.users.domain.User;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


@Repository
@Transactional
public class UserDaoImpl extends AbstractDao<User> {

    public Optional<User> findByUsername(String username) {
        return (Optional<User>) sessionFactory.getCurrentSession().createCriteria(User.class)
                .add(Restrictions.eq("username", username))
                .uniqueResult();
    }

    public User findBySearchQuery(String searchQuery) {
        return (User) sessionFactory.getCurrentSession().createCriteria(User.class)
                .add(Restrictions.disjunction()
                        .add(Restrictions.eq("firstName", searchQuery))
                        .add(Restrictions.eq("lastName", searchQuery))
                        .add(Restrictions.eq("email", searchQuery))
                ).uniqueResult();
    }
}