package com.ppyuan.club.notice.service.impl;

import com.ppyuan.club.notice.dao.MsgRepository;
import com.ppyuan.club.notice.service.MsgService;
import com.ppyuan.club.notice.vo.MsgVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

@Service
public class MsgServiceImpl implements MsgService {

    @Autowired
    private MsgRepository msgRepository;

    @Override
    public void add(MsgVO msgVO) {

        msgRepository.save(msgVO);

    }

    @Override
    public void delete(int id) {

        msgRepository.deleteById(id);
    }

    @Override
    public void update(MsgVO msgVO) {

        msgRepository.save(msgVO);

    }

    @Override
    public List<MsgVO> findByNextDate() {
        Date date = new Date();
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, 1);
        date = calendar.getTime();

        //msgRepository.findByDate(date);
        return null;

    }

    @Override
    public List<MsgVO> findByDateAndPhone(String p, String phone) {

        try {
            Date date = new SimpleDateFormat("yyyy-MM-dd").parse(p);
            List<MsgVO> list = msgRepository.findByDateAndPhone(date,phone);
            return list;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}
