package com.users.service;

import com.users.domain.User;

import java.util.List;
import java.util.Set;

/**
 * @author avas
 */
public interface UserService {

    List getUserDetails();

    User create(User dto);

    List<User> getUsersByIds(Set<String> participantIds);
}
