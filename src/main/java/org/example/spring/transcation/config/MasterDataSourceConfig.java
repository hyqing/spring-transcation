package org.example.spring.transcation.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

/**
 * Created by hyq on 2020/12/15 11:38.
 */
@Configuration
public class MasterDataSourceConfig {

    @Bean(name = "masterDataSource")
    @ConfigurationProperties("app.master")
    public DataSource masterDataSource() {
        return DataSourceBuilder.create().build();
    }

//    @Bean
//    public LocalContainerEntityManagerFactoryBean entityManagerFactory(EntityManagerFactoryBuilder entityManagerFactoryBuilder) {
//
////        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
////
////        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
////        factory.setJpaVendorAdapter(vendorAdapter);
////        factory.setPackagesToScan("org.example.spring.transcation.entity");
////        factory.setDataSource(masterDataSource());
////        return factory;
//        return entityManagerFactoryBuilder
//                .dataSource(masterDataSource())
//                .packages("org.example.spring.transcation.entity")
//                .build();
//    }

//    @Bean
//    public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
//        return new JpaTransactionManager(entityManagerFactory);
//    }
}
