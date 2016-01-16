package com.mazekkkk.product.schedule;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

/**
 * Created by mazekkkk on 16/1/15.
 */
public class SchedulerRunnable implements Runnable {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public void run() {
        logger.info("runnable" + new Date());
    }
}
