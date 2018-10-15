package com.sguess.dbconf;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DataSourceConfigTest {
    @Autowired
    DataSourceConfig dataSourceConfig;

    @Autowired
    ApplicationContext applicationContext;

    @Test
    public void test01() throws SQLException {
        DataSource dataSource = dataSourceConfig.getTest01DataSource();
        printDataSourceInfo(dataSource);

    }

    private void printDataSourceInfo(DataSource dataSource) throws SQLException {
        System.err.println("-------------Start --------------" + dataSource.toString() + ",\t" + dataSource.hashCode());
        Connection connection = dataSource.getConnection();
        System.err.println(connection.getSchema() + "\t" + connection.getMetaData().getUserName() + ",\t" + connection.getMetaData().getConnection().getSchema() + ",\t" + connection.getMetaData().getDatabaseProductName());
//        Properties clientInfo = connection.getClientInfo();
//        for (Object o : clientInfo.keySet()) {
//            System.err.println(clientInfo.get(o));
//        }
//        System.err.println(clientInfo);
        System.err.println("------------End---------------" + dataSource.toString() + ",\t" + dataSource.hashCode());
    }

    @Test
    public void testGetDataSource02() throws SQLException {
        String beanName = "test01DataSource";
        DataSource dataSource = (DataSource) applicationContext.getBean(beanName);
        printDataSourceInfo(dataSource);
        System.out.println("is singleton: " + applicationContext.isSingleton(beanName));
        System.out.println("is equals: " + (applicationContext.getBean(beanName) == dataSourceConfig.getTest01DataSource()));
    }

    @Test
    public void testDefaultDataSource() throws SQLException {
        String beanName = "test01DataSource";
        DataSource dataSource = (DataSource) applicationContext.getBean(beanName);
        DataSource dataSource2 = applicationContext.getBean(DataSource.class);
        System.err.println("is equals datasource: " + (dataSource == dataSource2));
        System.err.println("------------>Start to print datasource 1");
        printDataSourceInfo(dataSource);
        System.err.println("------------>Start to print datasource 2");
        printDataSourceInfo(dataSource2);
        System.err.println("------------>Start to print datasource 3");
        printDataSourceInfo((DataSource) applicationContext.getBean("test02DataSource"));
    }

    @Test
    public void testDataSourceHashCode() {
        System.out.println(applicationContext.getBean(DataSource.class).hashCode());
        System.out.println((applicationContext.getBean("test01DataSource")).hashCode());
        System.out.println((applicationContext.getBean("test02DataSource")).hashCode());
    }
}