package com.evooq.repository;

import com.evooq.domain.Medicine;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the Medicine entity.
 */
@SuppressWarnings("unused")
@Repository
public interface MedicineRepository extends JpaRepository<Medicine, Long> {
}
