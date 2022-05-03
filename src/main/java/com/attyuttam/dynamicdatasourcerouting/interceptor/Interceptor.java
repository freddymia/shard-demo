package com.attyuttam.dynamicdatasourcerouting.interceptor;

import com.attyuttam.dynamicdatasourcerouting.domain.DivisionDatabase;
import com.attyuttam.dynamicdatasourcerouting.domain.DivisionDatabaseService;
import com.attyuttam.dynamicdatasourcerouting.infra.datasource.DataSourceContextHolder;
import com.attyuttam.dynamicdatasourcerouting.infra.datasource.DataSourceEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Interceptor implements HandlerInterceptor {

    private Logger logger = LoggerFactory.getLogger(Interceptor.class);

    private DataSourceContextHolder dataSourceContextHolder;
    private DivisionDatabaseService divisionDatabaseService;

    public Interceptor(DataSourceContextHolder dataSourceContextHolder, DivisionDatabaseService divisionDatabaseService) {
        this.dataSourceContextHolder = dataSourceContextHolder;
        this.divisionDatabaseService = divisionDatabaseService;
    }

    @Override
    public boolean preHandle(
            HttpServletRequest request,
            HttpServletResponse response,
            Object handler
    ) throws Exception {
        logger.info(">>>>>>>>>> preHandle");
        String divisionId;
        try {
            divisionId = request.getRequestURI().substring(request.getRequestURI().length() - 36, request.getRequestURI().length());
            DivisionDatabase divisionDatabase = divisionDatabaseService.getByDivisionId(divisionId);
            setDataSourceContextHolder(divisionDatabase);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public void postHandle(
            HttpServletRequest request,
            HttpServletResponse response,
            Object handler,
            ModelAndView modelAndView
    ) throws Exception {
        logger.info(">>>>>>>>>> postHandle");
    }

    @Override
    public void afterCompletion(
            HttpServletRequest request,
            HttpServletResponse response,
            Object handler,
            Exception ex
    ) throws Exception {
        logger.info(">>>>>>>>>> afterCompletion");
    }


    public void setDataSourceContextHolder(DivisionDatabase divisionDatabase) {
        if (divisionDatabase == null) {
            logger.info("NOT FOUND!!!");
            return;
        }
        dataSourceContextHolder.setBranchContext(DataSourceEnum.valueOf(divisionDatabase.getDatasourceId()));
    }

}