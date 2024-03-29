package com.evooq.web.rest;

import com.evooq.domain.Medicine;
import com.evooq.service.MedicineService;
import com.evooq.web.rest.errors.BadRequestAlertException;

import io.github.jhipster.web.util.HeaderUtil;
import io.github.jhipster.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing {@link com.evooq.domain.Medicine}.
 */
@RestController
@RequestMapping("/api")
public class MedicineResource {

    private final Logger log = LoggerFactory.getLogger(MedicineResource.class);

    private static final String ENTITY_NAME = "medicine";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final MedicineService medicineService;

    public MedicineResource(MedicineService medicineService) {
        this.medicineService = medicineService;
    }

    /**
     * {@code POST  /medicines} : Create a new medicine.
     *
     * @param medicine the medicine to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new medicine, or with status {@code 400 (Bad Request)} if the medicine has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/medicines")
    public ResponseEntity<Medicine> createMedicine(@RequestBody Medicine medicine) throws URISyntaxException {
        log.debug("REST request to save Medicine : {}", medicine);
        if (medicine.getId() != null) {
            throw new BadRequestAlertException("A new medicine cannot already have an ID", ENTITY_NAME, "idexists");
        }
        Medicine result = medicineService.save(medicine);
        return ResponseEntity.created(new URI("/api/medicines/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /medicines} : Updates an existing medicine.
     *
     * @param medicine the medicine to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated medicine,
     * or with status {@code 400 (Bad Request)} if the medicine is not valid,
     * or with status {@code 500 (Internal Server Error)} if the medicine couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/medicines")
    public ResponseEntity<Medicine> updateMedicine(@RequestBody Medicine medicine) throws URISyntaxException {
        log.debug("REST request to update Medicine : {}", medicine);
        if (medicine.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        Medicine result = medicineService.save(medicine);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, medicine.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /medicines} : get all the medicines.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of medicines in body.
     */
    @GetMapping("/medicines")
    public List<Medicine> getAllMedicines() {
        log.debug("REST request to get all Medicines");
        return medicineService.findAll();
    }

    /**
     * {@code GET  /medicines/:id} : get the "id" medicine.
     *
     * @param id the id of the medicine to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the medicine, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/medicines/{id}")
    public ResponseEntity<Medicine> getMedicine(@PathVariable Long id) {
        log.debug("REST request to get Medicine : {}", id);
        Optional<Medicine> medicine = medicineService.findOne(id);
        return ResponseUtil.wrapOrNotFound(medicine);
    }

    /**
     * {@code DELETE  /medicines/:id} : delete the "id" medicine.
     *
     * @param id the id of the medicine to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/medicines/{id}")
    public ResponseEntity<Void> deleteMedicine(@PathVariable Long id) {
        log.debug("REST request to delete Medicine : {}", id);
        medicineService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString())).build();
    }
}
