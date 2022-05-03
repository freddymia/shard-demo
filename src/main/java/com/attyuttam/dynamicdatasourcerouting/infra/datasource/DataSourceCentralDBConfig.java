package com.attyuttam.dynamicdatasourcerouting.infra.datasource;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "centrallhdb.datasource")
@Getter
@Setter
public class DataSourceCentralDBConfig {
    private String url;
    private String password;
    private String username;
}
