package com.ppyuan.club.notice.dao;

import com.ppyuan.club.notice.vo.MsgVO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;


@Repository
public interface MsgRepository extends JpaRepository<MsgVO, Integer> {

    List<MsgVO> findByDateIsBetween(Date start, Date end);

    List<MsgVO> findByDateAndPhone(Date date, String phone);

}
