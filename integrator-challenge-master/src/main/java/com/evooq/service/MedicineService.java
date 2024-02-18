package com.evooq.service;

import com.evooq.domain.Medicine;

import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing {@link Medicine}.
 */
public interface MedicineService {

    /**
     * Save a medicine.
     *
     * @param medicine the entity to save.
     * @return the persisted entity.
     */
    Medicine save(Medicine medicine);

    /**
     * Get all the medicines.
     *
     * @return the list of entities.
     */
    List<Medicine> findAll();


    /**
     * Get the "id" medicine.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<Medicine> findOne(Long id);

    /**
     * Delete the "id" medicine.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
