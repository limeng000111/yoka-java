package com.example.demo.respository;

import com.example.demo.User.UserInfo;
import com.example.demo.User.UserRecorde;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.websocket.Decoder;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;

@Service
public interface RecordResipository extends JpaRepository<UserRecorde,String> {
    @Modifying
    @Transactional
    @Query(value = "insert into votedRecorde (phone,votetime) values (?1 and ?2)",nativeQuery = true)
    int insertVoteRecord( String phone, String votetime);

//
//    @Query(value = "select * from voted_recorde where phone = ?1 ",nativeQuery = true)
//    List<UserRecorde> selectUserRecorde(String phone);


    @Query(value = "SELECT votetime FROM voted_recorde WHERE phone = ?1 ORDER BY votetime DESC LIMIT 1",nativeQuery = true)
    String selectUserRecordeTime(String phone);

}
