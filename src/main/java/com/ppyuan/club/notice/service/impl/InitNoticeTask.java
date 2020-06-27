package com.ppyuan.club.notice.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.quartz.SchedulerException;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Service;

import java.text.ParseException;

/*
 * 调用时机，容器初始完成调用。
 * 实现加载db, - 工厂
 * 转成  job     - 命令模式
 *       trigger
 * 交给定时任务执行
 *
 * 6大原则。
 * 单一
 */
@Slf4j
@Service
public class InitNoticeTask implements ApplicationListener {



    private volatile boolean isInit = false;

    @Override
    public void onApplicationEvent(ApplicationEvent applicationEvent) {
        if(!(applicationEvent instanceof ApplicationReadyEvent)){
            return;
        }
        if(isInit){
            return;
        }
        //初始化事件
        try {
            init();
        } catch (SchedulerException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        log.debug("定位任务加载完成");
    }

    private synchronized void init() throws SchedulerException, ParseException {
        //开启定时任务，每天凌晨查询


    }

}
