package com.ppyuan.club.notice.service;

import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.impl.StdSchedulerFactory;

public class SchedulerUtils {

    public static ThreadLocal<Scheduler> schedulerthreadlocal =  new ThreadLocal()
    {
        @Override
        protected Object initialValue() {
            try {
                return StdSchedulerFactory.getDefaultScheduler();
            } catch (SchedulerException e) {
                e.printStackTrace();
            }
            return null;
        }
    };

    public static Scheduler get(){
        return schedulerthreadlocal.get();
    }
}
