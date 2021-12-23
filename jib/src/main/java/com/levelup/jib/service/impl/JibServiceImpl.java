package com.levelup.jib.service.impl;

import com.levelup.jib.service.JibService;
import com.levelup.jib.domain.Jib;
import com.levelup.jib.repository.JibRepository;
import dto.JibDTO;
import com.levelup.jib.service.mapper.JibMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link Jib}.
 */
@Service
@Transactional
public class JibServiceImpl implements JibService {

    private final Logger log = LoggerFactory.getLogger(JibServiceImpl.class);

    private final JibRepository jibRepository;

    private final JibMapper jibMapper;

    public JibServiceImpl(JibRepository jibRepository, JibMapper jibMapper) {
        this.jibRepository = jibRepository;
        this.jibMapper = jibMapper;
    }

    /**
     * Save a jib.
     *
     * @param jibDTO the entity to save.
     * @return the persisted entity.
     */
    @Override
    public JibDTO save(JibDTO jibDTO) {
        log.debug("Request to save Jib : {}", jibDTO);
        Jib jib = jibMapper.toEntity(jibDTO);
        jib = jibRepository.save(jib);
        return jibMapper.toDto(jib);
    }

    /**
     * Get all the jibs.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Override
    @Transactional(readOnly = true)
    public Page<JibDTO> findAll(Pageable pageable) {
        log.debug("Request to get all Jibs");
        return jibRepository.findAll(pageable)
            .map(jibMapper::toDto);
    }

    /**
     * Get one jib by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<JibDTO> findOne(Long id) {
        log.debug("Request to get Jib : {}", id);
        return jibRepository.findById(id)
            .map(jibMapper::toDto);
    }

    /**
     * Delete the jib by id.
     *
     * @param id the id of the entity.
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete Jib : {}", id);
        jibRepository.deleteById(id);
    }
}
