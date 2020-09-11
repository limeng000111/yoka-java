package com.example.demo.Dao;


import com.example.demo.User.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.awt.*;


@Mapper
public interface TestMapper {

    public void insert(UserInfo userInfo);

    public void update(UserInfo userInfo);

    public void delete(int id);

    public UserInfo find(int id);


}
