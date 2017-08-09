package com.users.transformer;

import com.users.domain.User;
import com.users.dto.user.UserGetDto;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author avas
 */

@Component
public class UserTransformer {

    public List<UserGetDto> toDtoList(List<User> domains) {
        return domains.stream().map(this::toDto).collect(Collectors.toList());
    }

    public UserGetDto toDto(User domain) {
        UserGetDto dto = new UserGetDto();
        BeanUtils.copyProperties(domain, dto);
        return dto;
    }

}
