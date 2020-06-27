package com.ppyuan.club.notice;

import com.ppyuan.club.notice.dao.MsgRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

@Slf4j
@SpringBootTest
public class NoticeDaoTest {

    @Autowired
    MsgRepository msgRepository;

    @Test
    public void testMsgDao(){


       /* Date start = new Date();

        Date end = new Date();
        end.setTime(start.getTime()+24*60*60*1000);

        String format = "yyyy-MM-dd";
        String startStr = new SimpleDateFormat(format).format(start);
        String endStr = new SimpleDateFormat(format).format(end);

       log.debug("开始日期 到 结束日期"+startStr+ " - " +endStr);

        List list = msgRepository.findByDateIsBetween(start,end);
        System.out.println("list size: "+list.size());
*/


        try {
            Date start = new Date();
            String startStr= new SimpleDateFormat("yyyy-MM-dd").format(start);
            start = new SimpleDateFormat("yyyy-MM-dd").parse(startStr);
            Date end = new Date();
            end.setTime(start.getTime()+24*60*60*1000-1);


            List list = msgRepository.findByDateIsBetween(start,end);
            System.out.println("list size: "+list.size());
        } catch (ParseException e) {
            e.printStackTrace();
        }



    }
}
