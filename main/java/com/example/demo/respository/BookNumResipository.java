package com.example.demo.respository;

import com.example.demo.User.BookNumInfo;
import com.example.demo.User.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface BookNumResipository extends JpaRepository<BookNumInfo,String> {
//    @Query(value = "SELECT book,num FROM vote_book WHERE phone = ?1 ORDER BY votetime LIMIT 1",nativeQuery = true)
//    Date selectUserRecordeTime(String phone);
    @Query(value = "select * from vote_book  where book like %?1%",nativeQuery = true)
    List<BookNumInfo> selectBookInfo(String searchBook);


    @Query(value = "SELECT * FROM vote_book ORDER BY num DESC",nativeQuery = true)
    List<BookNumInfo> sort();


}
