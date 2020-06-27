package com.ppyuan.club.notice.service.impl;

import com.ppyuan.club.notice.dao.MsgRepository;
import com.ppyuan.club.notice.vo.MsgVO;
import lombok.extern.slf4j.Slf4j;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.List;

@Slf4j
@Component
public class NoticeScheduler {

    @Autowired
    private MsgRepository msgRepository;

    @Autowired
    private Scheduler scheduler;

    public void notice() throws SchedulerException, ParseException {
        //1.查询db
        Date start = new Date();
        String startStr = new SimpleDateFormat("yyyy-MM-dd").format(start);
        start = new SimpleDateFormat("yyyy-MM-dd").parse(startStr);
        Date end = new Date();
        end.setTime(start.getTime() + 24 * 60 * 60 * 1000 - 1);
        List<MsgVO> list = msgRepository.findByDateIsBetween(start, end);
        log.debug("准备通知条数:" + list.size());
        for (MsgVO msgVO : list) {
            System.out.println(msgVO);
            String phone = msgVO.getPhone();
            String content = msgVO.getContent();

            Date noticeDate = msgVO.getDate();
            int second = 0;
            int minute = 0;
            int hour = 9;
            int day = noticeDate.getDay();
            int month = noticeDate.getMonth();
            String dayofweek = "?";
            String year = "*";

            //测试使用，延迟十秒
            if (true) {
                long timestamp = LocalDateTime.now().toInstant(ZoneOffset.ofHours(8)).toEpochMilli();
                LocalDateTime now = Instant.ofEpochMilli(timestamp + 1000 * 10).atZone(ZoneOffset.ofHours(8)).toLocalDateTime();
                second = now.getSecond();
                minute = now.getMinute();
                hour = now.getHour();
                day = now.getDayOfMonth();
                month = now.getMonth().getValue();
                dayofweek = "?";
                year = "*";
            }

            String space = " ";
            String cron = new StringBuffer()
                    .append(second).append(space)
                    .append(minute).append(space)
                    .append(hour).append(space)
                    .append(day).append(space)
                    .append(month).append(space)
                    .append(dayofweek)
                    .append(year).toString();


            //2.转成job
            JobDetail jobDetail = JobBuilder.newJob(NoticeJob.class)
                    .withIdentity("noticeJob_" + msgVO.getId(), "jGroup" + msgVO.getId())
                    .build();
            ShortMessageNoticeHandler handler = new ShortMessageNoticeHandler(phone, content);
            handler.setJobKey(jobDetail.getKey());
            jobDetail.getJobDataMap().put("noticeHandler", handler);

            // 3.转成trigger
            Trigger trigger = TriggerBuilder.newTrigger()
                    .withDescription("")
                    .withIdentity("noticeJob_" + msgVO.getId(), "jGroup" + msgVO.getId())
                    .startNow()
                    .withSchedule(CronScheduleBuilder.cronSchedule(cron)) //5秒执行一次
                    .build();


            //4.任务执行
            scheduler.scheduleJob(jobDetail, trigger);
            scheduler.start();
        }

    }
}
