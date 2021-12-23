package com.levelup.jib.web.rest;

import com.levelup.jib.service.JibService;
import dto.JibDTO;
import com.levelup.jib.web.rest.util.HeaderUtil;
import com.levelup.jib.web.rest.util.PaginationUtil;
import com.levelup.jib.web.rest.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing {@link com.levelup.jib.domain.Jib}.
 */
@RestController
@RequestMapping("/api")
public class JibResource {

    private final Logger log = LoggerFactory.getLogger(JibResource.class);

    private static final String ENTITY_NAME = "jib";

    @Value("${spring.application.name}")
    private String applicationName;

    private final JibService jibService;

    public JibResource(JibService jibService) {
        this.jibService = jibService;
    }

    /**
     * {@code POST  /jibs} : Create a new jib.
     *
     * @param jibDTO the jibDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new jibDTO, or with status {@code 400 (Bad Request)} if the jib has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/jibs")
    public ResponseEntity<JibDTO> createJib(@Valid @RequestBody JibDTO jibDTO) throws URISyntaxException {
        log.debug("REST request to save Jib : {}", jibDTO);
        if (jibDTO.getId() != null) {
            throw new BadRequestAlertException("A new jib cannot already have an ID", ENTITY_NAME, "idexists");
        }
        JibDTO result = jibService.save(jibDTO);
        return ResponseEntity.created(new URI("/api/jibs/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /jibs} : Updates an existing jib.
     *
     * @param jibDTO the jibDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated jibDTO,
     * or with status {@code 400 (Bad Request)} if the jibDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the jibDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/jibs")
    public ResponseEntity<JibDTO> updateJib(@Valid @RequestBody JibDTO jibDTO) throws URISyntaxException {
        log.debug("REST request to update Jib : {}", jibDTO);
        if (jibDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        JibDTO result = jibService.save(jibDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, jibDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /jibs} : get all the jibs.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of jibs in body.
     */
    @GetMapping("/jibs")
    public ResponseEntity<List<JibDTO>> getAllJibs(Pageable pageable) {
        log.debug("REST request to get a page of Jibs");
        Page<JibDTO> page = jibService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /jibs/:id} : get the "id" jib.
     *
     * @param id the id of the jibDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the jibDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/jibs/{id}")
    public ResponseEntity<JibDTO> getJib(@PathVariable Long id) {
        log.debug("REST request to get Jib : {}", id);
        Optional<JibDTO> jibDTO = jibService.findOne(id);
        return ResponseUtil.wrapOrNotFound(jibDTO);
    }

    /**
     * {@code DELETE  /jibs/:id} : delete the "id" jib.
     *
     * @param id the id of the jibDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/jibs/{id}")
    public ResponseEntity<Void> deleteJib(@PathVariable Long id) {
        log.debug("REST request to delete Jib : {}", id);
        jibService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString())).build();
    }
}
