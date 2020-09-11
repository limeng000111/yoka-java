package com.example.demo.respository;

import com.example.demo.User.UserInfo;
import org.apache.ibatis.jdbc.Null;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface UserResipository extends JpaRepository<UserInfo,String> {


//    @Query(value = "select * from voter_test vt where vt.phone=?1",nativeQuery = true)
    @Modifying
    @Transactional
    @Query(value = "update vote_book set num = num + 1 where book =?1",nativeQuery = true)
    void updateBookNum(String book);

    //查询数据库有无此用户
    @Query(value = "select * from voter_test where phone = ?1 and ?2",nativeQuery = true)
    List<UserInfo> selectUser(String phone,String password);

    @Query(value = "select * from voter_test ",nativeQuery = true)
    List<UserInfo> selectUserInfo();









}
