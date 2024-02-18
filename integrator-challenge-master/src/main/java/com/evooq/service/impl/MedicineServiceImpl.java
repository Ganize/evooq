package com.evooq.service.impl;

import com.evooq.service.MedicineService;
import com.evooq.domain.Medicine;
import com.evooq.repository.MedicineRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Service Implementation for managing {@link Medicine}.
 */
@Service
@Transactional
public class MedicineServiceImpl implements MedicineService {

    private final Logger log = LoggerFactory.getLogger(MedicineServiceImpl.class);

    private final MedicineRepository medicineRepository;

    public MedicineServiceImpl(MedicineRepository medicineRepository) {
        this.medicineRepository = medicineRepository;
    }

    @Override
    public Medicine save(Medicine medicine) {
        log.debug("Request to save Medicine : {}", medicine);
        return medicineRepository.save(medicine);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Medicine> findAll() {
        log.debug("Request to get all Medicines");
        return medicineRepository.findAll();
    }


    @Override
    @Transactional(readOnly = true)
    public Optional<Medicine> findOne(Long id) {
        log.debug("Request to get Medicine : {}", id);
        return medicineRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete Medicine : {}", id);
        medicineRepository.deleteById(id);
    }
}
