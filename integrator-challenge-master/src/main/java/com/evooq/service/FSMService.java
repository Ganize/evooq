package com.evooq.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class FSMService {

    private final Random random;

    private final Logger log = LoggerFactory.getLogger(FSMService.class);

    @Value("${fsm-service.threshold}")
    private int threshold;

    public FSMService() {
        this.random = new Random();
    }

    public void openConnection() {
        // Simulates a flaky DB connection.
        log.info("Opening DB connection");
//        if (this.random.nextDouble() * threshold > 1) {
//            throw new NoodlyAppendageException("Couldn't acquire DB connection.");
//        }
        log.info("Connection opened");
    }
}
