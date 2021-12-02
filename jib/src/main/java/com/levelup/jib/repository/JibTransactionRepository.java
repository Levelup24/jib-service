package com.levelup.jib.repository;

import com.levelup.jib.domain.JibTransaction;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the JibTransaction entity.
 */
@SuppressWarnings("unused")
@Repository
public interface JibTransactionRepository extends JpaRepository<JibTransaction, Long> {

}
