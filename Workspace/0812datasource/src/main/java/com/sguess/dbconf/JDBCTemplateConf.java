package com.sguess.dbconf;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;


public class JDBCTemplateConf {

    @Bean(name = "test01JdbcTemplate")
    public JdbcTemplate test01JdbcTemplate(
            @Qualifier("test01DataSource") DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    @Bean(name = "test02JdbcTemplate")
    public JdbcTemplate test02JdbcTemplate(
            @Qualifier("test02DataSource") DataSource dataSource) {
        return new JdbcTemplate(dataSource);

    }
}
