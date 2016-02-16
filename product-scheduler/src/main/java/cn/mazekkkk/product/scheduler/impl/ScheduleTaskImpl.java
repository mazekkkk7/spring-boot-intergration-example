package cn.mazekkkk.product.scheduler.impl;

import cn.mazekkkk.product.scheduler.ScheduleRunnableService;
import cn.mazekkkk.product.scheduler.ScheduleTaskService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ConcurrentTaskScheduler;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by mazekkkk on 16/1/15.
 */
@Component
public class ScheduleTaskImpl extends ConcurrentTaskScheduler implements ScheduleTaskService {

    @Autowired
    private ScheduleRunnableService schedulerRunnable;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public void schedulerGenerate(Date date){
        logger.info(sdf.format(date.getTime())+"----------------------------------------");
        super.schedule(schedulerRunnable,date);
    }

//    @Scheduled(fixedRate = 5000)
    public void taskScheduled(){
        logger.info(sdf.format(new Date()));
    }

}