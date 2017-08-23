package com.users.controller;

import com.users.domain.Conversation;
import com.users.dto.conversation.ConversationGetDto;
import com.users.dto.conversation.ConversationPostDto;
import com.users.service.ConversationService;
import com.users.transformer.ConversationTransformer;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;


@RestController
@RequestMapping(value = "/conversations")
@Api(value = "conversations", description = "Endpoints for conversations management")
public class ConversationController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ConversationController.class);

    @Autowired
    private ConversationService conversationService;

    @Autowired
    private ConversationTransformer conversationTransformer;

    @ApiOperation(value = "getConversationByUserId", nickname = "getConversationByUserId")
    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value = "User's id", required = false, dataType = "string", paramType = "query")
    })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = Conversation.class),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
    public ResponseEntity getConversations(@RequestParam(value = "userId", required = false) String userId) {

        Set conversations = conversationService.getConversations(userId);
        return new ResponseEntity(conversations, HttpStatus.OK);
    }

    @RequestMapping(value = "{conversationId}", method = RequestMethod.GET, produces = "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = Conversation.class),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
    public ResponseEntity getConversationById(@PathVariable(value = "conversationId", required = false) String conversationId) {

        ConversationGetDto conversation = conversationService.getConversationById(conversationId);
        return new ResponseEntity(conversation, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    ResponseEntity create(@RequestBody ConversationPostDto dto) {


        ConversationGetDto user = conversationService.create(dto);
        return new ResponseEntity(user, HttpStatus.CREATED);
    }

}