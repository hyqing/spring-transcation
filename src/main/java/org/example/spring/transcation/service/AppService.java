package org.example.spring.transcation.service;

import org.example.spring.transcation.annotation.SwitchDataSource;
import org.example.spring.transcation.entity.App;
import org.example.spring.transcation.repository.AppRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by hyq on 2020/12/15 13:52.
 */
@Service
public class AppService {

    @Autowired
    private AppRepository appRepository;

    public List<App> getList() {
        return appRepository.findAll();
    }

    @SwitchDataSource("master")
    public List<App> getMaster() {
        return appRepository.findAll();
    }

    @SwitchDataSource("slave")
    public List<App> getSlave() {
        return appRepository.findAll();
    }

    @Transactional
    public App createApp(App app) {
//        int i = 1 / 0;
        return appRepository.save(app);
    }

    public String aop() {
//        int i = 1 / 0;
        System.out.println("方法正常调用");
        return "返回一个字符串";
    }
}
