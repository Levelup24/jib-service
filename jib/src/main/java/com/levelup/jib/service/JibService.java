package com.levelup.jib.service;

import dto.JibDTO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Service Interface for managing {@link com.levelup.jib.domain.Jib}.
 */
public interface JibService {

    /**
     * Save a jib.
     *
     * @param jibDTO the entity to save.
     * @return the persisted entity.
     */
    JibDTO save(JibDTO jibDTO);

    /**
     * Get all the jibs.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<JibDTO> findAll(Pageable pageable);

    /**
     * Get the "id" jib.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<JibDTO> findOne(Long id);

    /**
     * Delete the "id" jib.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
