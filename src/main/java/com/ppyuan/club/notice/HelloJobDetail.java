package com.ppyuan.club.notice;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.Scheduler;
import org.quartz.impl.JobDetailImpl;
import org.quartz.spi.TriggerFiredBundle;

public class HelloJobDetail extends JobDetailImpl {

    public void execute()   {
        System.out.println("222----第2次！");
        System.out.println("111----第1次！");
        System.out.println("333----第3次！");
        System.out.println("222----第四次");
    }
}
