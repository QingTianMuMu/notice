package com.ppyuan.club.notice;


import com.ppyuan.club.notice.dao.MsgRepository;
import com.ppyuan.club.notice.vo.MsgVO;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Test {

    @Autowired
    private MsgRepository msgRepository;


    @org.junit.Test
    public void test1(){


        System.out.println(Math.ceil(9.6));
        System.out.println(Math.ceil(9.1));
        System.out.println(Math.floor(11.4));
        System.out.println(Math.round(11.4));
    }



}
