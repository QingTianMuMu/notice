package com.ppyuan.club.notice;


import java.util.concurrent.*;

public class ThreadJob {


    @org.junit.Test
    public void newSingle() {

        ExecutorService executorService  = Executors.newSingleThreadExecutor();
        while (true){
            executorService.submit(new Callable<Object>() {
                @Override
                public Object call() throws Exception {
                    return "我是测试";
                }
            });
        }
    }

    @org.junit.Test
    public void newFix() throws InterruptedException {

        ExecutorService executorService  = new ThreadPoolExecutor(1, 10,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>());

        while (true){
            executorService.submit(new Callable<Object>() {
                @Override
                public Object call() throws Exception {
                    System.out.println(Thread.currentThread().getId() + " 测试");
                    return 1;
                }
            });
        }


    }
}
