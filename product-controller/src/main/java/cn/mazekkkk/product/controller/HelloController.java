package cn.mazekkkk.product.controller;

import cn.mazekkkk.product.scheduler.ScheduleTaskService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * Created by mazekkkk on 16/1/12.
 */
@Component
@Controller
@RequestMapping(value = "/index")
public class HelloController {

    @Autowired
    private ScheduleTaskService scheduleTaskImpl;

    public static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    private  Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping(value = "/hello")
    public String hello() {
        return "build Spring boot Success!";
    }

    @RequestMapping(value = "/generateTask")
    public String generateTask(@RequestParam(name = "startDate",required = false) String date) throws ParseException {
        logger.info("startSchedulerTask----------------------");
        scheduleTaskImpl.schedulerGenerate(sdf.parse(date));
        return "build Spring boot Success!";
    }



}