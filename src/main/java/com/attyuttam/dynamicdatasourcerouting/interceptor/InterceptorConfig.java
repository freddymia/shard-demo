package com.attyuttam.dynamicdatasourcerouting.interceptor;

import com.attyuttam.dynamicdatasourcerouting.domain.DivisionDatabaseService;
import com.attyuttam.dynamicdatasourcerouting.infra.datasource.DataSourceContextHolder;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    private DataSourceContextHolder dataSourceContextHolder;
    private DivisionDatabaseService divisionDatabaseService;

    public InterceptorConfig(DataSourceContextHolder dataSourceContextHolder, DivisionDatabaseService divisionDatabaseService) {
        this.dataSourceContextHolder = dataSourceContextHolder;
        this.divisionDatabaseService = divisionDatabaseService;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new Interceptor(dataSourceContextHolder, divisionDatabaseService));
    }
}
