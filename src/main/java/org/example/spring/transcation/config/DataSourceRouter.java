package org.example.spring.transcation.config;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * Created by hyq on 2020/12/15 16:15.
 */
public class DataSourceRouter extends AbstractRoutingDataSource {

    /**
     * ThreadLocal 用于提供线程局部变量，在多线程环境可以保证各个线程里的变量独立于其它线程里的变量。
     * 也就是说 ThreadLocal 可以为每个线程创建一个【单独的变量副本】，相当于线程的 private static 类型变量。
     */
    private static final ThreadLocal<String> CONTEXT_HOLDER = new ThreadLocal<>();

//    private static String dataSourceConfig = "master"; //默认主库

    @Override
    protected Object determineCurrentLookupKey() {
        System.out.println("当前数据源:" + getDataSource());
        return getDataSource();
    }

    public static void setMyDataSource(String dataSource) {
        CONTEXT_HOLDER.set(dataSource);
    }

    public static String getDataSource() {
        return CONTEXT_HOLDER.get();
    }
}
