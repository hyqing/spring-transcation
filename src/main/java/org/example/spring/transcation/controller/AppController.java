package org.example.spring.transcation.controller;

import org.example.spring.transcation.entity.App;
import org.example.spring.transcation.service.AppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by hyq on 2020/12/15 11:54.
 */

@RestController
@RequestMapping("/app")
public class AppController {

    @Autowired
    private AppService appService;

    @RequestMapping("/list")
    public List<App> getList() {
        return appService.getList();
    }

    @RequestMapping("/master")
    public List<App> getMaster() {
        return appService.getMaster();
    }

    @RequestMapping("/slave")
    public List<App> getSlave() {
        return appService.getSlave();
    }

    @RequestMapping("/create")
    public App create() {
        App app = new App();
        app.setName("22");
        app.setRemark("remark1");
        return appService.createApp(app);
    }

    @RequestMapping("/aop")
    public String aop() {
        return appService.aop();
    }
}
