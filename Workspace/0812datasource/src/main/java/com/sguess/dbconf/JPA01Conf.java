package com.sguess.dbconf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.boot.autoconfigure.orm.jpa.HibernateSettings;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "entityManagerFactoryTest01",
//        transactionManagerRef = "transactionManagerTest01",
        basePackages = {"com.sguess.dao.a"}) //设置Repository所在位置
public class JPA01Conf {
    @Autowired
    @Qualifier("test01DataSource")
    private DataSource test01DataSource;
    @Autowired
    private JpaProperties jpaProperties;
//
//    //
//    @Primary
//    @Bean(name = "entityManagerTest01")
//    public EntityManager entityManager(EntityManagerFactoryBuilder builder) {
//        return entityManagerFactoryPrimary(builder).getObject().createEntityManager();
//    }
//
//
    @Primary
    @Bean(name = "entityManagerFactoryTest01")
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryPrimary(EntityManagerFactoryBuilder builder) {
        return builder
                .dataSource(test01DataSource)
                .properties(jpaProperties.getHibernateProperties(test01DataSource))
                .packages("com.sguess.dao.a.entity") //设置实体类所在位置
//                .persistenceUnit("test01PersistenceUnit")
                .build();
    }
//
//    @Primary
//    @Bean(name = "transactionManagerTest01")
//    public PlatformTransactionManager transactionManagerPrimary(EntityManagerFactoryBuilder builder) {
//        return new JpaTransactionManager(entityManagerFactoryPrimary(builder).getObject());
//    }

}
