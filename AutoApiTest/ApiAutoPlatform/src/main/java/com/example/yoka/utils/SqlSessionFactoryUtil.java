package com.example.yoka.utils;


import com.example.yoka.entity.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;

public class SqlSessionFactoryUtil {
    @Test
    public static void testConnectMybatis() throws IOException {
        System.out.println("1111");
        try {
            SqlSessionFactory sqlSessionFactory;
            //mybatis的配置文件
            String resource = "mybatis-config.xml";
            //类加载器加载配置文件
            InputStream is = Resources.getResourceAsStream(resource);
            /**
             * 构建sqlSession的工厂
             * @throws IOException
             */
            SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);
            /**
             * 创建能执行映射文件sql中的sqlSession
             * @throws IOException
             */
            SqlSession session = sessionFactory.openSession();
            /**
             * 根据key进行查找
             */
            System.out.println("即将执行查询操作");
            session.selectOne("getStudent");
            Student lisi = new Student(1,"lisi",176.2,86.1);
            System.out.println("即将执行插入操作");
            session.insert("insertStudent",lisi);
            session.commit();
            session.close();
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public static void main(String[] args) throws IOException {
        SqlSessionFactoryUtil.testConnectMybatis();
    }



}
