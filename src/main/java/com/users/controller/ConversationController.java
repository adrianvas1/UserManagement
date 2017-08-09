package com.users.controller;

import com.users.domain.Conversation;
import com.users.dto.conversation.ConversationPostDto;
import com.users.service.ConversationService;
import com.users.transformer.ConversationTransformer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Controller
@RequestMapping(value = "/conversations")
public class ConversationController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ConversationController.class);

    @Autowired
    private ConversationService conversationService;

    @Autowired
    private ConversationTransformer conversationTransformer;

    @RequestMapping(method = RequestMethod.GET, produces="application/json")
    public ResponseEntity getConversations(@RequestParam(value="userId", required=false) String userId) {

        Set conversations = conversationService.getConversations(userId);
        return new ResponseEntity(conversations, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    ResponseEntity create(@RequestBody ConversationPostDto dto) {


        Conversation user = conversationService.create(dto);
        return new ResponseEntity(user, HttpStatus.CREATED);
    }

}