package com.example.controller;

import com.example.Cache.PlayerCache;
import com.example.dao.PlayerDaoImp;
import com.example.model.SangongUser.SangongPlayer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by liupeng on 2017/2/11.
 */

// 注解标注此类为springmvc的controller，url映射为"/home"
@Controller
@RequestMapping("/home")
public class HomeController {
    /**
     *添加一个日志器
     */
    private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public String printWelcome(ModelMap model) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext1.xml");
        PlayerDaoImp studentDaoImp = (PlayerDaoImp)context.getBean("studentDaoImp");
        List<SangongPlayer> students =studentDaoImp.queryPlayerByUID(123456);


        model.addAttribute("str0121", "我去，成功了呀！！！");
        model.addAttribute("info","当前用户信息为：");
        model.addAttribute("user", students.get(0));
        return "index";
    }
}
