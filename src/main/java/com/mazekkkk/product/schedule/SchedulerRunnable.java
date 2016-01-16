package com.mazekkkk.product.schedule;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by mazekkkk on 16/1/15.
 */
@Component
public class SchedulerRunnable implements Runnable {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

    @Override
    public void run() {
        logger.info("runnable" + sdf.format(new Date()));
    }
}
