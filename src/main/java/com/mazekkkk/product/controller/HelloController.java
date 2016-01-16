package com.mazekkkk.product.controller;

import com.mazekkkk.product.schedule.ScheduleTask;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;

/**
 * Created by mazekkkk on 16/1/12.
 */

@RestController
@RequestMapping("/index")
public class HelloController {

    @Autowired
    private ScheduleTask scheduleTask;

    public static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    private  Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping("/hello")
    public String hello() {
        return "build Spring boot Success!";
    }

    @RequestMapping("/generateTask")
    public String generateTask() {
        scheduleTask.schedulerGenerate();
        return "build Spring boot Success!";
    }



}