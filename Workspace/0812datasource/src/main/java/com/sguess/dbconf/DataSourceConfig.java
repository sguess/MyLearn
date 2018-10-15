package com.sguess.dbconf;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
//import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {
    @Bean(name = "test01DataSource")
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource.test01")
    public DataSource getTest01DataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "test02DataSource")
    @ConfigurationProperties(prefix = "spring.datasource.test02")
    public DataSource test02DataSource() {
        return DataSourceBuilder.create().build();
    }
}
