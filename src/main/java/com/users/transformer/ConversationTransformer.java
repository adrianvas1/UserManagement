package com.users.transformer;

import com.users.domain.Conversation;
import com.users.dto.conversation.ConversationGetDto;
import com.users.dto.conversation.ConversationPostDto;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author avas
 */

@Component
public class ConversationTransformer {

    public Set<ConversationGetDto> toDtoList(List<Conversation> domains) {
        return domains.stream().map(this::toDto).collect(Collectors.toSet());
    }

    public ConversationGetDto toDto(Conversation domain) {
        ConversationGetDto dto = new ConversationGetDto();
        BeanUtils.copyProperties(domain, dto);
        return dto;
    }

    public Conversation toDomain(ConversationPostDto dto) {
        Conversation domain = new Conversation();
        BeanUtils.copyProperties(dto, domain, "participantIds");
        domain.setParticipantIds(dto.getParticipantIds().toString());
        return domain;
    }

}
