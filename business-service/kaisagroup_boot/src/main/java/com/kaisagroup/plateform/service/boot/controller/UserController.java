package com.kaisagroup.plateform.service.boot.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kaisagroup.plateform.service.boot.entity.User;
import com.kaisagroup.plateform.service.boot.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("user")
@Slf4j
public class UserController {

    @Autowired
    private IUserService userService;

    @RequestMapping(value = "add",method={RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    public String insert(@RequestParam(value = "name",defaultValue = "")String name){
        User user = new User();
        user.setUname(name);
        user.setBirth(new Date());
        log.info("请求参数:{}",user);
         return userService.insert(user);
    }

    @RequestMapping(value = "list/{start}/{size}",method={RequestMethod.POST,RequestMethod.GET})
    public @ResponseBody PageInfo<User> getUserList(@PathVariable("start")int start,@PathVariable("size")int size){
        PageHelper.startPage(start,size);
       List<User> list= userService.getList();
        PageInfo<User> pageInfo =new PageInfo<User>(list);
        log.info("pageInfo="+pageInfo.toString());
       return pageInfo ;
    }
}
