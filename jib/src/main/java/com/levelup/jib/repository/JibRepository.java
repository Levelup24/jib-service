package com.levelup.jib.repository;

import com.levelup.jib.domain.Jib;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the Jib entity.
 */
@SuppressWarnings("unused")
@Repository
public interface JibRepository extends JpaRepository<Jib, Long> {

}
