package com.ppyuan.club.notice;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MyJob implements Job {

    private static final Logger log = LoggerFactory.getLogger(MyJob.class);

    @Override
    public void execute(JobExecutionContext context)throws JobExecutionException {
        log.info("=====  MyJob  is cc start ..................");
        log.info("=====  MyJob  is dd start ..................");
        log.info("=====  MyJob  is mm start ..................");
        log.info("=====  MyJob  is startaa ..................");
        log.info("=====  MyJob  is startbb ..................");
        log.info("=====  MyJob  is startcc ..................");

        log.info("=====  Hello quzrtz  "+
                new SimpleDateFormat("yyyy-MM-dd HH:mm:ss ").format(new Date()));

        log.info("=====  MyJob  is end .....................");
    }

}
