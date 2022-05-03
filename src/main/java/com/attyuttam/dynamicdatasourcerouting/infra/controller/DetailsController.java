package com.attyuttam.dynamicdatasourcerouting.infra.controller;

import com.attyuttam.dynamicdatasourcerouting.domain.DivisionDatabase;
import com.attyuttam.dynamicdatasourcerouting.domain.DivisionDatabaseService;
import com.attyuttam.dynamicdatasourcerouting.domain.Employee;
import com.attyuttam.dynamicdatasourcerouting.domain.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class DetailsController {

    private final EmployeeService employeeService;

    @GetMapping(
            value = "/employees/{divisionId}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public List<Employee> getAllEmployeeDetails(
            @PathVariable("divisionId") String divisionId
    ) {
        return employeeService.getAllEmployeeDetails();
    }
}
