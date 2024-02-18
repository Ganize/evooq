package com.evooq.service.impl;

import com.evooq.domain.Country;
import com.evooq.repository.CountryRepository;
import com.evooq.service.CountryService;
import com.evooq.service.FSMService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Service Implementation for managing {@link Country}.
 */
@Service
@Transactional
public class CountryServiceImpl implements CountryService {

    private final Logger log = LoggerFactory.getLogger(CountryServiceImpl.class);

    private final CountryRepository countryRepository;
    private final FSMService fsmService;

    public CountryServiceImpl(CountryRepository countryRepository, FSMService fsmService) {
        this.countryRepository = countryRepository;
        this.fsmService = fsmService;
    }

    @Override
    public Country save(Country country) {
        log.debug("Request to save Country : {}", country);
        fsmService.openConnection();
        return countryRepository.save(country);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Country> findAll() {
        log.debug("Request to get all Countries");
        return countryRepository.findAll();
    }


    @Override
    @Transactional(readOnly = true)
    public Optional<Country> findOne(Long id) {
        log.debug("Request to get Country : {}", id);
        return countryRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete Country : {}", id);
        countryRepository.deleteById(id);
    }
}
