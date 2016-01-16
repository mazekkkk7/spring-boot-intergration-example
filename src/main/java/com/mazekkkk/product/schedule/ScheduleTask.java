package com.mazekkkk.product.schedule;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.concurrent.ConcurrentTaskScheduler;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by mazekkkk on 16/1/15.
 */
@Component
public class ScheduleTask {

    private ConcurrentTaskScheduler concurrentTaskScheduler = new ConcurrentTaskScheduler();

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    private Calendar calendar = Calendar.getInstance();

    public void schedulerGenerate(){
        calendar.set(2016,0,16,12,8,55);
        logger.info(sdf.format(calendar.getTime())+"----------------------------------------");
        SchedulerRunnable task = new SchedulerRunnable();
        concurrentTaskScheduler.schedule(task,calendar.getTime());
    }

    @Scheduled(fixedRate = 5000)
    public void taskScheduled(){
        logger.info(sdf.format(new Date()));
    }

}