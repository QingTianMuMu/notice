package com.ppyuan.club.notice.service.impl;

import com.ppyuan.club.notice.service.INoticeHandler;
import org.quartz.*;
import org.quartz.impl.JobDetailImpl;

//定位任务
public class NoticeJob implements Job {

    INoticeHandler noticeHandler;

    public NoticeJob() {
    }

    public NoticeJob(INoticeHandler noticeHandler) {
        this.noticeHandler = noticeHandler;
    }
    //执行任务,进行通知
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        noticeHandler.notice();
    }

    public INoticeHandler getNoticeHandler() {
        return noticeHandler;
    }

    public void setNoticeHandler(INoticeHandler noticeHandler) {
        this.noticeHandler = noticeHandler;
    }
}

7