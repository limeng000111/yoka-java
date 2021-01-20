package com.example.yoka.dao;


import com.example.yoka.entity.Student;

import java.util.List;

public interface StudentDao {

    /**
     * 查询所有用户信息
     */
    public Student getStudent(int id);
    /**
     * 新增客户
     */
    public int insertStudent(Student student);
    /**
     * 修改客户
     */
    public int updateStudent(Student student);
    /**
     * 删除客户
     */
    public int deleteStudent(int id);
}
