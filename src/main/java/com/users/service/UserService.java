package com.users.service;

import com.users.domain.User;

import java.util.List;

/**
 * @author avas
 */
public interface UserService {

    List getUserDetails();

    User create(User dto);
}
