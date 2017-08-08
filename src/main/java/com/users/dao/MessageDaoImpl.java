package com.users.dao;

import com.users.domain.Message;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;


@Component
public interface MessageDaoImpl extends CrudRepository<Message, String> {

}