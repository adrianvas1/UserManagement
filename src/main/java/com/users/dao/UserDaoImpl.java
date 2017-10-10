package com.users.dao;

import com.users.domain.User;
import org.hibernate.Criteria;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Repository
@Transactional
public class UserDaoImpl extends AbstractDao<User> {

    public List<User> findByUsername(String username) {
        return (List<User>) sessionFactory.getCurrentSession().createCriteria(User.class)
                .add(Restrictions.eq("username", username))
                .list();
    }

    public List<User> findBySearchQuery(String searchQuery) {
        String decoratedSearchQuery = "%" + searchQuery + "%";
        return (List) sessionFactory.getCurrentSession().createCriteria(User.class)
                .add(Restrictions.disjunction()
                        .add(Restrictions.like("firstName", decoratedSearchQuery))
                        .add(Restrictions.like("lastName", decoratedSearchQuery))
                        .add(Restrictions.like("email", decoratedSearchQuery))
                ).list();
    }
}