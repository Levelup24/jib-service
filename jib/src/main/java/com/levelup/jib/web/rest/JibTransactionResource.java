package com.levelup.jib.web.rest;

import com.levelup.jib.service.JibTransactionService;
import com.levelup.jib.service.dto.JibTransactionDTO;
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
 * REST controller for managing {@link com.levelup.jib.domain.JibTransaction}.
 */
@RestController
@RequestMapping("/api")
public class JibTransactionResource {

    private final Logger log = LoggerFactory.getLogger(JibTransactionResource.class);

    private static final String ENTITY_NAME = "jibTransaction";

    @Value("${spring.application.name}")
    private String applicationName;

    private final JibTransactionService jibTransactionService;

    public JibTransactionResource(JibTransactionService jibTransactionService) {
        this.jibTransactionService = jibTransactionService;
    }

    /**
     * {@code POST  /jib-transactions} : Create a new jibTransaction.
     *
     * @param jibTransactionDTO the jibTransactionDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new jibTransactionDTO, or with status {@code 400 (Bad Request)} if the jibTransaction has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/jib-transactions")
    public ResponseEntity<JibTransactionDTO> createJibTransaction(@Valid @RequestBody JibTransactionDTO jibTransactionDTO) throws URISyntaxException {
        log.debug("REST request to save JibTransaction : {}", jibTransactionDTO);
        if (jibTransactionDTO.getId() != null) {
            throw new BadRequestAlertException("A new jibTransaction cannot already have an ID", ENTITY_NAME, "idexists");
        }
        JibTransactionDTO result = jibTransactionService.save(jibTransactionDTO);
        return ResponseEntity.created(new URI("/api/jib-transactions/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /jib-transactions} : Updates an existing jibTransaction.
     *
     * @param jibTransactionDTO the jibTransactionDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated jibTransactionDTO,
     * or with status {@code 400 (Bad Request)} if the jibTransactionDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the jibTransactionDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/jib-transactions")
    public ResponseEntity<JibTransactionDTO> updateJibTransaction(@Valid @RequestBody JibTransactionDTO jibTransactionDTO) throws URISyntaxException {
        log.debug("REST request to update JibTransaction : {}", jibTransactionDTO);
        if (jibTransactionDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        JibTransactionDTO result = jibTransactionService.save(jibTransactionDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, jibTransactionDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /jib-transactions} : get all the jibTransactions.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of jibTransactions in body.
     */
    @GetMapping("/jib-transactions")
    public ResponseEntity<List<JibTransactionDTO>> getAllJibTransactions(Pageable pageable) {
        log.debug("REST request to get a page of JibTransactions");
        Page<JibTransactionDTO> page = jibTransactionService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /jib-transactions/:id} : get the "id" jibTransaction.
     *
     * @param id the id of the jibTransactionDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the jibTransactionDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/jib-transactions/{id}")
    public ResponseEntity<JibTransactionDTO> getJibTransaction(@PathVariable Long id) {
        log.debug("REST request to get JibTransaction : {}", id);
        Optional<JibTransactionDTO> jibTransactionDTO = jibTransactionService.findOne(id);
        return ResponseUtil.wrapOrNotFound(jibTransactionDTO);
    }

    /**
     * {@code DELETE  /jib-transactions/:id} : delete the "id" jibTransaction.
     *
     * @param id the id of the jibTransactionDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/jib-transactions/{id}")
    public ResponseEntity<Void> deleteJibTransaction(@PathVariable Long id) {
        log.debug("REST request to delete JibTransaction : {}", id);
        jibTransactionService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString())).build();
    }
}
