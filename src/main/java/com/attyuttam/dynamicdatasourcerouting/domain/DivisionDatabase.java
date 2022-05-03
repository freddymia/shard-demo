package com.attyuttam.dynamicdatasourcerouting.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "division_database")
public class DivisionDatabase {

    @Id
    @Column(name = "division_id")
    private String divisionId;

    @Column(name = "node_id")
    private Long nodeId;

    @Column(name = "plan_id")
    private String planId;

    @Column(name = "datasource_id")
    private String datasourceId;
}
