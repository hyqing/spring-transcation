package org.example.spring.transcation.config;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * Created by hyq on 2020/12/15 16:15.
 */
public class DataSourceRouter extends AbstractRoutingDataSource {

    private static String dataSourceConfig = "master"; //默认主库

    @Override
    protected Object determineCurrentLookupKey() {
        System.out.println("当前数据源:" + dataSourceConfig);
        return dataSourceConfig;
    }

    public static void setMyDataSource(String dataSource) {
        dataSourceConfig = dataSource;
    }
}
