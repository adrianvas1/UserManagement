package com.users.controller;

import com.users.domain.Conversation;
import com.users.service.ConversationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@Controller
@RequestMapping(value = "/conversations")
public class ConversationController {

    @Autowired
    private ConversationService conversationService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity userDetails(@RequestParam(value="userId", required=false) String userId) {

        List userDetails = conversationService.getConversations(userId);
        return new ResponseEntity(userDetails, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    ResponseEntity create(@RequestBody Conversation dto) {
        Conversation user = conversationService.create(dto);
        return new ResponseEntity(user, HttpStatus.CREATED);
    }

}