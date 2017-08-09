package com.users.controller;

import com.users.domain.Message;
import com.users.service.MessageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping(value = "/messages")
public class MessageController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ConversationController.class);

    @Autowired
    private MessageService messageService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity userDetails() {

        List userDetails = messageService.getMessages();
        return new ResponseEntity(userDetails, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    ResponseEntity create(@RequestBody Message dto) {
        Message user = messageService.create(dto);
        return new ResponseEntity(user, HttpStatus.CREATED);
    }

    @ResponseStatus(value = HttpStatus.CONFLICT, code = HttpStatus.CONFLICT,
            reason = "A user with the same e-mail address is already registered. Please try again.")
    @ExceptionHandler(DataIntegrityViolationException.class)
    public void conflict() {
        LOGGER.error("A user with the same e-mail address is already registered. Please try again.");
    }
}