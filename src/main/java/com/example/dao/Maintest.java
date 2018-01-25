package com.example.dao;

import com.example.model.SangongUser.SangongPlayer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class Maintest {
    public static void main(String [] args){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext1.xml");
        PlayerDaoImp studentDaoImp = (PlayerDaoImp)context.getBean("studentDaoImp");
        List<SangongPlayer> students =studentDaoImp.queryPlayerByUID(123456);
        System.out.println(students.get(0));


    }
}
