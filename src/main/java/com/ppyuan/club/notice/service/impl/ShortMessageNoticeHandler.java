package com.ppyuan.club.notice.service.impl;

import com.ppyuan.club.notice.service.INoticeHandler;
import com.ppyuan.club.notice.service.SchedulerUtils;
import lombok.Data;
import org.quartz.JobKey;
import org.quartz.SchedulerException;

//只负责通知
@Data
public class ShortMessageNoticeHandler implements INoticeHandler {

    private JobKey jobKey;
    private String phone;
    private String msg;

    public ShortMessageNoticeHandler(String phone, String msg) {
        this.phone = phone;
        this.msg = msg;
    }

    @Override
    public void notice() {
        System.out.println( "通知：  " + phone + " "+ msg);

        //移除
        try {
            SchedulerUtils.get().deleteJob(jobKey);
        } catch (SchedulerException e) {
            e.printStackTrace();
        }

    }
}
