package com.example.demo.service.impl;

import com.example.demo.respository.RecordResipository;
import com.example.demo.service.RecordResipositoryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

@Service
public class RecordResipositoryServiceImpl implements RecordResipositoryService {

    @Resource
    RecordResipository recordResipository;

    @Override
    public String selectById(String phone) {
        return recordResipository.selectUserRecordeTime(phone);
    }
}
