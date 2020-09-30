package com.example.demo.controller;

import com.example.demo.User.UserRecorde;
import com.example.demo.respository.RecordResipository;
import com.example.demo.service.RecordResipositoryService;
import org.omg.CORBA.portable.ValueOutputStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
@Service
public class VoteDay {


    @Resource
    RecordResipositoryService recordResipositoryService;


    public boolean isVoted(String phone){
        boolean is_flag = false;
        //获取当天时间
        //设置日期格式
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        // new Date()为获取当前系统时间
        String currentTime = df.format(new Date());
        String voteTime = recordResipositoryService.selectById(phone);
        if (voteTime == null ){
            is_flag = true;

        }else {
            is_flag = !currentTime.equals(voteTime);
        }
      return is_flag;
    }
}
