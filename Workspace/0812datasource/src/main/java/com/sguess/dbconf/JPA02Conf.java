package com.sguess.dbconf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "entityManagerFactoryTest02",
//        transactionManagerRef = "transactionManagerTest02",
        basePackages = {"com.sguess.dao.b"}) //设置Repository所在位置
public class JPA02Conf {
    @Autowired
    @Qualifier("test02DataSource")
    private DataSource dataSource;
    @Autowired
    private JpaProperties jpaProperties;

//    @Bean(name = "entityManagerTest02")
//    public EntityManager entityManager(EntityManagerFactoryBuilder builder) {
//        return entityManagerFactoryPrimary(builder).getObject().createEntityManager();
//    }
//
    @Bean(name = "entityManagerFactoryTest02")
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryPrimary(EntityManagerFactoryBuilder builder) {
        return builder
                .dataSource(dataSource)
                .properties(jpaProperties.getHibernateProperties(dataSource))
                .packages("com.sguess.dao.b.entity") //设置实体类所在位置
//                .persistenceUnit("test02PersistenceUnit")
                .build();
    }

//    @Bean(name = "transactionManagerTest02")
//    public PlatformTransactionManager transactionManagerPrimary(EntityManagerFactoryBuilder builder) {
//        return new JpaTransactionManager(entityManagerFactoryPrimary(builder).getObject());
//    }
}
