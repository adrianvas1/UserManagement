package com.users.dao;

import com.users.domain.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
@Transactional
public class UserDaoImpl extends AbstractDao<User> {

}