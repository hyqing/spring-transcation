package org.example.spring.transcation.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.example.spring.transcation.annotation.SwitchDataSource;
import org.example.spring.transcation.config.DataSourceRouter;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * Created by hyq on 2020/12/15 16:26.
 */
@Aspect
@Component
public class DataSourceAspect {

    @Before("@annotation(org.example.spring.transcation.annotation.SwitchDataSource)")
    public void beforeSwitchDS(JoinPoint joinPoint) {

        System.out.println("进入切面");
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        String dataSource = "master";
        if (method.isAnnotationPresent(SwitchDataSource.class)) {
            SwitchDataSource switchDataSource = method.getDeclaredAnnotation(SwitchDataSource.class);
            dataSource = switchDataSource.value();
        }
        System.out.println("需要将数据源切换为：" + dataSource);
        DataSourceRouter.setMyDataSource(dataSource);
    }

}
