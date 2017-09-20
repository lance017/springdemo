package com.lance.springdemo.controller;

import com.lance.springdemo.dao.UserMapper;
import com.lance.springdemo.po.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;


/**
 * Created by lance on 2017/9/15.
 */
@Controller
@RequestMapping("/")
public class IndexController {

    @Autowired(required = false)
    private UserMapper userMapper;

    @RequestMapping(value = "/web", method = RequestMethod.POST)
    @ResponseBody
    public User web(User person) {
        userMapper.insert(person);
        return person;
    }

    /**
     * @param person
     * @return
     * @RequestBody 代表获取的json
     */
    @RequestMapping(value = "/json", method = RequestMethod.POST)
    @ResponseBody
    public User json(@RequestBody User person) {
        userMapper.insertSelective(person);
        return person;
    }

    @RequestMapping("/index")
    public String index(ModelMap map) {
        map.put("username", "index");
        return "index";
    }

    @RequestMapping("/world")
    public String world() {
        return "world";
    }

    @RequestMapping("/san")
    public String san(ModelMap map) {
        map.put("username", "ftl");
        return "san";
    }

    @RequestMapping("/demo")
    public ModelAndView demo() {
        ModelAndView mv = new ModelAndView("demo");
        mv.addObject("intVar", 100);
        mv.addObject("longVar",10000);
        mv.addObject("stringVar","我是字符串");
        mv.addObject("doubleVar",34.5d);
        mv.addObject("boolVar",true);
        mv.addObject("dateVar",new Date());

        mv.addObject("nullVar",null);

        User user = new User();
        user.setId(12);
        user.setName("lance");
        user.setAge(14);
        user.setRecommend("<font color=\"red\">早下班</font>");

        mv.addObject("user",user);

        List<String> list = new ArrayList<String>();
        list.add("java");
        list.add("python");
        list.add("nodejs");

        mv.addObject("myList",list);

        Map<String,String> map = new HashMap<String,String>();
        map.put("java", "hello,java");
        map.put("python", "hello,python");
        map.put("nodejs", "hello,nodejs");

        mv.addObject("myMap", map);

        mv.addObject("sort_int",new SortMethod());


        return mv;
    }

}
