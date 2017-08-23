package com.users.service;

import com.users.dao.ConversationDaoImpl;
import com.users.domain.Conversation;
import com.users.domain.User;
import com.users.dto.conversation.ConversationGetDto;
import com.users.dto.conversation.ConversationPostDto;
import com.users.dto.user.UserGetDto;
import com.users.transformer.ConversationTransformer;
import com.users.transformer.UserTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;


@Service
public class ConversationServiceImpl implements ConversationService {

    @Autowired
    private ConversationDaoImpl conversationDao;

    @Autowired
    private UserService userService;

    @Autowired
    private UserTransformer userTransformer;

    @Autowired
    private ConversationTransformer conversationTransformer;

    @Transactional
    public Set getConversations(String userId) {
        List<Conversation> conversations = conversationDao.findByUserId(userId);
        Set<ConversationGetDto> conversationGetDtos = new HashSet<>();
        for (Conversation conversation : conversations) {
            conversation.getMessages();
            ConversationGetDto conversationGetDto = conversationTransformer.toDto(conversation);
            if (conversation.getParticipantIds() != null) {
                List<String> participantIds = new ArrayList<>(Arrays.asList(conversation.getParticipantIds()
                        .substring(1, conversation.getParticipantIds().length()-1)
                        .replaceAll("\\s+", "")
                        .split(",")));
                Set<String> foo = new HashSet<>(participantIds);
                List<User> usersByIds = userService.getUsersByIds(foo);
                List<UserGetDto> userGetDtos = userTransformer.toDtoList(usersByIds);
                conversationGetDto.setParticipants(userGetDtos);
            }
            conversationGetDtos.add(conversationGetDto);
        }

        return conversationGetDtos;
    }

    @Transactional
    public ConversationGetDto getConversationById(String id) {
        Optional<Conversation> conversationOptional = conversationDao.findOne(id);
        if (conversationOptional.isPresent()) {
            Conversation conversation = conversationOptional.get();
            ConversationGetDto conversationGetDto = conversationTransformer.toDto(conversation);
            List<String> participantIds = new ArrayList<>(Arrays.asList(conversation.getParticipantIds()
                    .substring(1, conversation.getParticipantIds().length()-1)
                    .replaceAll("\\s+", "")
                    .split(",")));
            Set<String> foo = new HashSet<>(participantIds);
            List<User> usersByIds = userService.getUsersByIds(foo);
            List<UserGetDto> userGetDtos = userTransformer.toDtoList(usersByIds);
            conversationGetDto.setParticipants(userGetDtos);
            return conversationGetDto;
        } else {
            return null;
        }
    }

    @Transactional
    public ConversationGetDto create(ConversationPostDto dto) {
        Conversation conversation = conversationTransformer.toDomain(dto);
        conversationDao.save(conversation);
        ConversationGetDto conversationGetDto = conversationTransformer.toDto(conversation);
        List<String> participantIds = new LinkedList<>(Arrays.asList(conversation.getParticipantIds()
                .substring(1, conversation.getParticipantIds().length()-1)
                .replaceAll("\\s+", "")
                .split(",")));
        Set<String> foo = new TreeSet<>(participantIds);
        List<User> usersByIds = userService.getUsersByIds(foo);
        List<UserGetDto> userGetDtos = userTransformer.toDtoList(usersByIds);
        conversationGetDto.setParticipants(userGetDtos);
        return conversationGetDto;
    }

}