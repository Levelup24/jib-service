package com.levelup.jib.service.impl;

import com.levelup.jib.service.JibTransactionService;
import com.levelup.jib.domain.JibTransaction;
import com.levelup.jib.repository.JibTransactionRepository;
import com.levelup.jib.service.dto.JibTransactionDTO;
import com.levelup.jib.service.mapper.JibTransactionMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link JibTransaction}.
 */
@Service
@Transactional
public class JibTransactionServiceImpl implements JibTransactionService {

    private final Logger log = LoggerFactory.getLogger(JibTransactionServiceImpl.class);

    private final JibTransactionRepository jibTransactionRepository;

    private final JibTransactionMapper jibTransactionMapper;

    public JibTransactionServiceImpl(JibTransactionRepository jibTransactionRepository, JibTransactionMapper jibTransactionMapper) {
        this.jibTransactionRepository = jibTransactionRepository;
        this.jibTransactionMapper = jibTransactionMapper;
    }

    /**
     * Save a jibTransaction.
     *
     * @param jibTransactionDTO the entity to save.
     * @return the persisted entity.
     */
    @Override
    public JibTransactionDTO save(JibTransactionDTO jibTransactionDTO) {
        log.debug("Request to save JibTransaction : {}", jibTransactionDTO);
        JibTransaction jibTransaction = jibTransactionMapper.toEntity(jibTransactionDTO);
        jibTransaction = jibTransactionRepository.save(jibTransaction);
        return jibTransactionMapper.toDto(jibTransaction);
    }

    /**
     * Get all the jibTransactions.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Override
    @Transactional(readOnly = true)
    public Page<JibTransactionDTO> findAll(Pageable pageable) {
        log.debug("Request to get all JibTransactions");
        return jibTransactionRepository.findAll(pageable)
            .map(jibTransactionMapper::toDto);
    }

    /**
     * Get one jibTransaction by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<JibTransactionDTO> findOne(Long id) {
        log.debug("Request to get JibTransaction : {}", id);
        return jibTransactionRepository.findById(id)
            .map(jibTransactionMapper::toDto);
    }

    /**
     * Delete the jibTransaction by id.
     *
     * @param id the id of the entity.
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete JibTransaction : {}", id);
        jibTransactionRepository.deleteById(id);
    }
}
