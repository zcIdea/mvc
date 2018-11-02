package com.springmvc.controller;

import com.springmvc.dao.RedisBaiseTakes;
import com.springmvc.entry.SeeUser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.SimpleFormatter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * Controller redis
 *
 */
@Controller
@RequestMapping("redisTest")
public class RedisTestController {

//    @Resource(name="seeUserRedisTakes")
	@Autowired
    private RedisBaiseTakes<String, String, SeeUser> seeUserRedisTakes;

    @RequestMapping("/hello.do")
    public ModelAndView hello(){
    	
        ModelAndView mv = new ModelAndView();
        System.out.println("hello see");
        seeUserRedisTakes.add("hello1","zhangchuan");
        mv.setViewName("hello");
        return mv;
    }
    
    @RequestMapping("/hello2.do")
    public ModelAndView hello2(HttpServletRequest request){
    	SimpleDateFormat formatter=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    	
        ModelAndView mv = new ModelAndView();
        SeeUser seeUser = new SeeUser();
        seeUser.setId("1");
        seeUser.setIp(request.getLocalAddr());
        seeUser.setSeeTime(formatter.format(new Date()));
        seeUser.setSeeCount(1);
        seeUserRedisTakes.addObj("seeUser",seeUser.getId(),seeUser);
        mv.setViewName("hello");
        return mv;
    }
    
    @RequestMapping("/hello3.do")
    public ModelAndView hello3(HttpServletRequest request){
        ModelAndView mv = new ModelAndView();
        SeeUser seeUser = (SeeUser) seeUserRedisTakes.getObj("seeUser","1");
        if(seeUser!=null){
            System.out.println(seeUser.getId()+"======="+seeUser.getIp()+"======"+seeUser.getSeeTime()+"======="+seeUser.getSeeCount());
        }

        mv.setViewName("hello");
        return mv;
    }
    
    @RequestMapping("/getHello.do")
    public ModelAndView getHello(HttpServletRequest request){
    	ModelAndView mv = new ModelAndView();
    	String seeUser = seeUserRedisTakes.get("hello1");
    	if(seeUser!=null){
    		System.out.println(seeUser);
    	}
    	mv.addObject("seeUser", seeUser);
    	mv.setViewName("hello");
    	return mv;
    }

}