package com.levelup.jib.service.mapper;


import com.levelup.jib.domain.*;
import com.levelup.jib.service.dto.JibTransactionDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link JibTransaction} and its DTO {@link JibTransactionDTO}.
 */
@Mapper(componentModel = "spring", uses = {JibMapper.class})
public interface JibTransactionMapper extends EntityMapper<JibTransactionDTO, JibTransaction> {

    @Mapping(source = "jib.id", target = "jibId")
    JibTransactionDTO toDto(JibTransaction jibTransaction);

    @Mapping(source = "jibId", target = "jib")
    JibTransaction toEntity(JibTransactionDTO jibTransactionDTO);

    default JibTransaction fromId(Long id) {
        if (id == null) {
            return null;
        }
        JibTransaction jibTransaction = new JibTransaction();
        jibTransaction.setId(id);
        return jibTransaction;
    }
}
