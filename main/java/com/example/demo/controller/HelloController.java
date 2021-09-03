package com.example.demo.controller;
import com.example.demo.User.BookNumInfo;
import com.example.demo.User.UserInfo;
import com.example.demo.User.UserRecorde;
import com.example.demo.respository.BookNumResipository;
import com.example.demo.respository.RecordResipository;
import com.example.demo.respository.UserResipository;
import com.example.demo.service.VoteEmailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.Logger;


@Controller
public class HelloController {

    private static Logger log = (Logger) Logger.getLogger(String.valueOf(HelloController.class));

    @Autowired
    UserResipository userResipository;

    @Autowired
    RecordResipository recordResipository;

    @Autowired
    BookNumResipository bookNumResipository;

    @Autowired
    VoteDay voteDay;

    @Autowired
    VoteEmailServiceImpl voteEmailService;


    //读取配置文件中的截止时间
    @Value("${yoka.endTime}")
    private String endTime;

    @RequestMapping(value = "/themleaf", method = RequestMethod.GET)
    public String themleaf(Map<String, String> map) {
        map.put("hello", "xiaoming");
        log.info("截止时间：" + endTime);
        return "them";
    }

    @RequestMapping("/book_manager")
    public String vote(Model model){
        List<BookNumInfo> list = new ArrayList();
        list = bookNumResipository.findAll();
        //获取总票数
        int sum = 0;
        for (BookNumInfo bookNumInfo : list) {
            int bookVoteNum = bookNumInfo.getNum();
            sum += bookVoteNum;
        }
        log.info(String.valueOf(sum));
        model.addAttribute("totalNum",sum);
        //将书籍投票作为对象返回到前端
        model.addAttribute("bookRecordes",list);
        return "book_manager";
    }

    //接受前端传参，并进行处理
    @RequestMapping(value = "/data",method = RequestMethod.GET)
    @ResponseBody
    public String handleData(@RequestParam(value = "check_val[]") String[] params,@RequestParam(value = "phone") String phone){
        //判断时间是否过期
        boolean is_time = isEndTime();
        //判断当天是否投过票
        boolean is_flag1 = voteDay.isVoted(phone);
        if (is_time){
            if (is_flag1){
                log.info("没有到截止时间");
                log.info("前端页面传过来的手机号："+ phone);
                //设置日期格式
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                // new Date()为获取当前系统时间
                String time = df.format(new Date());
                UserRecorde userRecorde = new UserRecorde();
                userRecorde.setPhone(phone);
                userRecorde.setVotetime(time);
                recordResipository.save(userRecorde);
                log.info("前端传过来的选中书籍为："+params);
                for (String book : params){
                    log.info("for循环获得每一本书："+book);
                    userResipository.updateBookNum(book);
                    log.info("update成功");
                }
                return "投票成功";
            }else {
                return "您已经投过票啦";
            }
        }
        else {
            return "已过截止时间";
        }
    }

    private boolean isEndTime(){
        boolean flag = false;
        //获取当前时间戳
        long currentTime = System.currentTimeMillis() / 1000;
        long stringEndTime = Long.parseLong(endTime);
        if (currentTime < stringEndTime){
            flag = true;
        }
        return flag;
    }

    //打开注册页面
    @RequestMapping("/register")
    public String  registerPage(Model model){
        model.addAttribute("registerImage","/static/img/companylog.png");
        return "register";
    }

    //注册页面数据处理
    @ResponseBody
    @RequestMapping(value = "/registerData",method = RequestMethod.POST)
    public String registerData(@RequestParam(value = "userName") String name,
                                @RequestParam(value = "passWord") String password,
                                @RequestParam(value = "email") String email
                                ){
        //判断用户是否注册
        List list = userResipository.selectUser(name,password);
        log.info("----这是用户数据："+list);
        if (list.size() == 0){
            //将注册的用户信息添加到数据库
            UserInfo user = new UserInfo();
            user.setIphone(name);
            user.setPasswd(password);
            user.setEmail(email);
            //设置日期格式
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            // new Date()为获取当前系统时间
            String time = df.format(new Date());
            log.info("输出当前系统时间："+ time);
            user.setTime(time);
            //调用分装好的方法进行保存
            userResipository.save(user);
            log.info("新增用户添加到数据库中，请查看。");
            log.info("注册用户信息："+name+" "+password+" " + email);
            return "注册成功";
        }else {
            return "存在该用户";
        }
    }

    //打开登录页面
    @RequestMapping("/login")
    public String loginPage(){

        return "login";
    }

    //登录页面数据处理
    @ResponseBody
    @RequestMapping(value = "/loginData",method = RequestMethod.GET)
    public String loginData(@RequestParam(value = "userName") String name,
                            @RequestParam(value = "passWord") String password, HttpSession session){
        log.info("登录用户信息："+name+" "+password);
        //查询数据库有无此用户
        List list = userResipository.selectUser(name,password);
        log.info("list里的值："+list.size());
        if (list.size() == 1){
            log.info("list为1，进来了");
            session.setAttribute("username",name);
            return "存在该用户";
        }else {
            return "不存在该用户";
        }
    }

    //查询所有用户的邮箱
    @RequestMapping("/queryAll")

    public String queryAll(){
        return "introduction";
    }

    //查询投票次数
    @RequestMapping("/resultChartsLine")
    public String queryAllBook(Model model){
        HashMap<String,Integer> hashMap = new HashMap<>();
        List<BookNumInfo> list = new ArrayList();
        list = bookNumResipository.findAll();
        List listNum = new ArrayList();
        for (int i = 0; i < list.size();i++){
            int bookVoteNum = list.get(i).getNum();
            listNum.add(bookVoteNum);
        }
        model.addAttribute("dataList",listNum);

        return "resultChartsLine";
    }

    //查询符合条件的书籍
    @RequestMapping(value = "/book_search",method = RequestMethod.GET)
    public String  queryBook(@RequestParam(value = "searchBook") String searchBook, Model model){
        List<BookNumInfo> list = bookNumResipository.selectBookInfo(searchBook);
        //将书籍投票作为对象返回到前端
        model.addAttribute("bookRecordes",list);
        return "book_manager::book_recorde";
    }

    //票数从高往低排序
    @RequestMapping(value = "/sort",method = RequestMethod.GET)
    public String sort(Model model){
        List<BookNumInfo> list = new ArrayList<>();
        list = bookNumResipository.sort();
        model.addAttribute("bookRecordes",list);
        return "book_manager::book_recorde";

    }


    @RequestMapping(value = "/resultChartPieTest",method = RequestMethod.GET)
    public String chartPieTest(){
        return "resultChartPie1";
    }
    //饼状图展示
    @RequestMapping(value = "/resultChartPie",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object>  queryBook(){
        Map<String,Object> map = new HashMap<String,Object>();
        List<Integer> valueList =new ArrayList<Integer>();
        //获取每本书的票数和书名
        List<BookNumInfo> list = new ArrayList();
        List<String> nameList =new ArrayList<String>();
        list = bookNumResipository.findAll();
        for (BookNumInfo bookNumInfo : list) {
            String bookName = bookNumInfo.getBookName();
            int bookVoteNum = bookNumInfo.getNum();
            valueList.add(bookVoteNum);
            nameList.add(bookName);
        }

        String [] legends = {"Python从入门到实践","C++ Primer","C++ 项目开发实战入门","C++ 标准库","Java编程思想","Java核心思想",
                "数据结构和算法分析","深入理解Java虚拟机","JavaWeb项目实战","代码整洁之道","Spring 5核心原理","Effective Java",
                "Offer来了","Spring Boot实战","Java 8 函数式编程","Python标准库","利用Python进行数据分析","Python深度学习",
                "Python核心编程","Python预测之美","Python统计分析","Effective Python"};
        map.put("legends", legends);
        map.put("nameList", nameList);
        map.put("valueList", valueList);
        return map;

    }
}





