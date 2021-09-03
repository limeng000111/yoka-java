package com.example.yoka.test;


import com.example.yoka.entity.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Logger;

@Service
public class MybatisTest {

    private  static Logger log = (Logger) Logger.getLogger(String.valueOf(MybatisTest.class));

    public static SqlSession testMybatis() throws IOException {
            SqlSession session = null;
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
            session = sessionFactory.openSession();
//            String statement = "com.example.yoka.dao.StudentDao.getStudent";
//            Student student = (Student) session.selectOne(statement,1);
////            System.out.println("--------result------"+student.toString());
//            String statement1 = "com.example.yoka.dao.StudentDao.insertStudent";
//            ArrayList<String> list = new ArrayList<>();
//            list.add("xiaoming");
//            list.add("xiaohong");
//            list.add("xiaosun");
//            /**
//             * 从列表中随机选择一个字段
//             */
//            Random random = new Random();
//            int i = random.nextInt(list.size());
//            String name = list.get(i);
//            Student lisi = new Student(1,name,176.2,86.1);
//            log.info("即将执行插入操作");
//            session.insert(statement1,lisi);
//            log.info("插入成功");

        return session;
    }

    public static void main(String[] args) throws IOException {
        //获取起始时间(毫秒)
        long startTime = System.currentTimeMillis();
        for (int i = 0;i < 50;i++){
            MybatisTest.testMybatis();
        }
        //获取截止时间
        long endTime = System.currentTimeMillis();
        long runTime = (endTime - startTime)/1000;//单位：秒
        log.info("总运行："+runTime+"秒");
    }



    @Test
    public void testQueryMybatis() throws IOException {
        SqlSession session = null;
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
        session = sessionFactory.openSession();
        String statement = "com.example.yoka.dao.StudentDao.getStudent";
        Student student = (Student) session.selectOne(statement,1);
        System.out.println("--------result------"+student.getName());
    }


}
