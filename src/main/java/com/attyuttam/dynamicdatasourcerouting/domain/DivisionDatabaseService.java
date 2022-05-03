package com.attyuttam.dynamicdatasourcerouting.domain;

import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class DivisionDatabaseService {

    private final DivisionDatabaseRepository divisionDatabaseRepository;

    public DivisionDatabaseService(DivisionDatabaseRepository divisionDatabaseRepository) {
        this.divisionDatabaseRepository = divisionDatabaseRepository;
    }

    public DivisionDatabase getByDivisionId(String divisionId) {
        return divisionDatabaseRepository.getById(divisionId);
    }

    public List<DivisionDatabase> getAll() {
        return divisionDatabaseRepository.findAll();
    }

}
