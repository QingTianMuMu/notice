package com.ppyuan.club.notice.controller;

import com.ppyuan.club.notice.service.MsgService;
import com.ppyuan.club.notice.vo.MsgVO;
import com.ppyuan.club.notice.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


@RestController
@RequestMapping("/notice")
public class MsgController {



    @Autowired
    private MsgService msgService;

    @RequestMapping("/add")
    public Result addMsg(MsgVO msgVO){
        msgService.add(msgVO);
        Result result = new Result();
        result.setRes(true);
        result.setCode(200);
        result.setMsg("添加成功");

        return result;
    }

    @RequestMapping("/update")
    public Result updateMsg(MsgVO msgVO){
        msgService.update(msgVO);
        Result result = new Result();
        result.setRes(true);
        result.setCode(200);
        result.setMsg("修改成功");
        return result;
    }

    @RequestMapping("/delete")
    public Result deleteMsg(int id) {
        msgService.delete(id);
        Result result = new Result();
        result.setRes(true);
        result.setCode(200);
        result.setMsg("删除成功");
        return result;
    }
    @PostMapping("/find")
    public Result findMSg(String date,String phone){

        List<MsgVO> list = msgService.findByDateAndPhone(date,phone);
        Result result = new Result();
        result.setRes(true);
        result.setCode(200);
        result.setMsg("查询成功");
        result.setData(list);
        return result;
    }



}
