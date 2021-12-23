package com.levelup.jib.service.mapper;


import com.levelup.jib.domain.*;
import dto.JibDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link Jib} and its DTO {@link JibDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface JibMapper extends EntityMapper<JibDTO, Jib> {


    @Mapping(target = "jibTransactions", ignore = true)
    @Mapping(target = "removeJibTransaction", ignore = true)
    Jib toEntity(JibDTO jibDTO);

    default Jib fromId(Long id) {
        if (id == null) {
            return null;
        }
        Jib jib = new Jib();
        jib.setId(id);
        return jib;
    }
}
