package com.ppyuan.club.notice;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.Scheduler;
import org.quartz.impl.JobDetailImpl;
import org.quartz.spi.TriggerFiredBundle;

public class HelloJobDetail extends JobDetailImpl {

    public void execute()   {
        /*System.out.println("hello Job "+getKey());*/
        System.out.println("qwewqe");
        System.out.println("zzzzzz");

        System.out.println("disanci");
    }
}
