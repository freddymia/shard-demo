package com.attyuttam.dynamicdatasourcerouting.infra.datasource;

import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Component
public class DataSourceRouting extends AbstractRoutingDataSource {

    private DataSourceContextHolder dataSourceContextHolder;

    private DataSourceCentralDBConfig dataSourceCentralDBConfig;
    private DataSourceOneConfig dataSourceOneConfig;
    private DataSourceTwoConfig dataSourceTwoConfig;
    private DataSourceThreeConfig dataSourceThreeConfig;

    public DataSourceRouting(
            DataSourceContextHolder dataSourceContextHolder,
            DataSourceCentralDBConfig dataSourceCentralDBConfig,
            DataSourceOneConfig dataSourceOneConfig,
            DataSourceTwoConfig dataSourceTwoConfig,
            DataSourceThreeConfig dataSourceThreeConfig
    ) {
        this.dataSourceContextHolder = dataSourceContextHolder;
        this.dataSourceCentralDBConfig = dataSourceCentralDBConfig;
        this.dataSourceOneConfig = dataSourceOneConfig;
        this.dataSourceTwoConfig = dataSourceTwoConfig;
        this.dataSourceThreeConfig = dataSourceThreeConfig;

        Map<Object, Object> dataSourceMap = new HashMap<>();
        dataSourceMap.put(DataSourceEnum.DATASOURCE_ONE, dataSourceOneDataSource());
        dataSourceMap.put(DataSourceEnum.DATASOURCE_TWO, dataSourceTwoDataSource());
        dataSourceMap.put(DataSourceEnum.DATASOURCE_THREE, dataSourceThreeDataSource());
        this.setTargetDataSources(dataSourceMap);

        this.setDefaultTargetDataSource(dataSourceCentralLHDb());
    }

    @Override
    protected Object determineCurrentLookupKey() {
        return dataSourceContextHolder.getBranchContext();
    }

    public DataSource dataSourceCentralLHDb() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl(dataSourceCentralDBConfig.getUrl());
        dataSource.setUsername(dataSourceCentralDBConfig.getUsername());
        dataSource.setPassword(dataSourceCentralDBConfig.getPassword());
        return dataSource;
    }

    public DataSource dataSourceOneDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl(dataSourceOneConfig.getUrl());
        dataSource.setUsername(dataSourceOneConfig.getUsername());
        dataSource.setPassword(dataSourceOneConfig.getPassword());
        return dataSource;
    }

    public DataSource dataSourceTwoDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl(dataSourceTwoConfig.getUrl());
        dataSource.setUsername(dataSourceTwoConfig.getUsername());
        dataSource.setPassword(dataSourceTwoConfig.getPassword());
        return dataSource;
    }

    public DataSource dataSourceThreeDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl(dataSourceThreeConfig.getUrl());
        dataSource.setUsername(dataSourceThreeConfig.getUsername());
        dataSource.setPassword(dataSourceThreeConfig.getPassword());
        return dataSource;
    }
}
