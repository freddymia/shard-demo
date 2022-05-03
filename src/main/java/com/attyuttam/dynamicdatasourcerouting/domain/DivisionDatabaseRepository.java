package com.attyuttam.dynamicdatasourcerouting.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface DivisionDatabaseRepository extends JpaRepository<DivisionDatabase, String> {

    @Query(value = "SELECT dd FROM DivisionDatabase dd WHERE dd.divisionId = ?1")
    DivisionDatabase getById(String id);

    @Override
    List<DivisionDatabase> findAll();
}
