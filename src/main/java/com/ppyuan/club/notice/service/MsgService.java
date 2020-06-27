package com.ppyuan.club.notice.service;

import com.ppyuan.club.notice.vo.MsgVO;

import java.util.Date;
import java.util.List;


public interface MsgService {

    void add(MsgVO msgVO);

    void delete(int id);

    void update(MsgVO msgVO);

    List<MsgVO> findByNextDate();


    List<MsgVO> findByDateAndPhone(String date, String phone);
}
