package com.users.service;

import com.users.dao.UserDaoImpl;
import com.users.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDaoImpl userDao;

    @Transactional
    public List getUserDetails() {
        return (List) userDao.findAll();
    }

    @Transactional
    public User create(User dto) {
        return userDao.save(dto);
    }

    @Override
    public List<User> getUsersByIds(Set<String> participantIds) {
        return userDao.findByIds(participantIds);
    }

}