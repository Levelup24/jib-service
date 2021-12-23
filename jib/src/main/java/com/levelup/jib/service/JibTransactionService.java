package com.levelup.jib.service;

import dto.JibTransactionDTO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Service Interface for managing {@link com.levelup.jib.domain.JibTransaction}.
 */
public interface JibTransactionService {

    /**
     * Save a jibTransaction.
     *
     * @param jibTransactionDTO the entity to save.
     * @return the persisted entity.
     */
    JibTransactionDTO save(JibTransactionDTO jibTransactionDTO);

    /**
     * Get all the jibTransactions.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<JibTransactionDTO> findAll(Pageable pageable);

    /**
     * Get the "id" jibTransaction.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<JibTransactionDTO> findOne(Long id);

    /**
     * Delete the "id" jibTransaction.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
