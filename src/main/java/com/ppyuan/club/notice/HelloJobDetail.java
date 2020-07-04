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
        System.out.println("disici");
<<<<<<< HEAD
        System.out.println("第六次");
=======
         System.out.println("diwuci");
<<<<<<< .mine
        System.out.println("diwuci");
=======
        System.out.println("disici");
>>>>>>> .theirs
>>>>>>> 597c97537564f9dd9bda4de4889d2b979313e738
    }
}
