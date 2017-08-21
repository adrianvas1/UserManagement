package com.users.service;

import com.users.domain.User;
import com.users.dto.user.UserPostDto;

import java.util.List;
import java.util.Optional;
import java.util.Set;

/**
 * @author avas
 */
public interface UserService {

    List getUserDetails();

    User create(UserPostDto dto);

    List<User> getUsersByIds(Set<String> participantIds);

    Optional<User> getByUsername(String username);

    User findBySearchQuery(String searchQuery);
}
