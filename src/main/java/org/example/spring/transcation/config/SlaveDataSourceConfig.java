package org.example.spring.transcation.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

/**
 * Created by hyq on 2020/12/15 16:08.
 */
@Configuration
public class SlaveDataSourceConfig {
    @Bean(name = "slaveDataSource")
    @ConfigurationProperties("app.slave")
    public DataSource slaveDataSource() {
        return DataSourceBuilder.create().build();
    }
}
