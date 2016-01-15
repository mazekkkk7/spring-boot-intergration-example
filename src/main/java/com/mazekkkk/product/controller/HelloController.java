package com.mazekkkk.product.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by mazekkkk on 16/1/12.
 */
@RestController
@Component
public class HelloController {

    public static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    private  Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping("/")
    public String index() {
        return "build Spring boot Success!";
    }

    @Scheduled(fixedRate = 5000)
    public void taskScheduled(){
        logger.info(sdf.format(new Date()));
    }

}