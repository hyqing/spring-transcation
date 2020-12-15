package org.example.spring.transcation.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by hyq on 2020/12/15 16:20.
 */
@Configuration
public class dataSourceRouterConfig {

    @Primary
    @Bean(name = "dataSourceRouter")
    public DataSource dataSourceRouter(@Qualifier("masterDataSource") DataSource master, @Qualifier("slaveDataSource") DataSource slave) {
        DataSourceRouter dataSourceRouter = new DataSourceRouter();

        //配置多数据源
        Map<Object, Object> map = new HashMap<>(5);
        map.put("master", master);
        map.put("slave", slave);

        // master 作为默认数据源
        dataSourceRouter.setDefaultTargetDataSource(master);
        dataSourceRouter.setTargetDataSources(map);
        return dataSourceRouter;
    }
}
