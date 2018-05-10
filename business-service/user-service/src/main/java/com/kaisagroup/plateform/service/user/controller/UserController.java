package com.kaisagroup.plateform.service.user.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kaisagroup.plateform.common.constant.SystemConstants;
import com.kaisagroup.plateform.service.user.bean.User;
import com.kaisagroup.plateform.service.user.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by jackssy on 2018/5/9.
 */


@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

    @Autowired
    IUserService userService;

    /**
     * 登陆
     *
     * @param phone
     * @param password
     * @return
     */
    @RequestMapping(value = "login", method = {RequestMethod.GET,RequestMethod.POST})
    public String login(@RequestParam("phone") String phone, @RequestParam("password") String password) {
        boolean result = userService.login(phone, password);
        return result ? SystemConstants.Code.SUCCESS : SystemConstants.Code.FAIL;
    }

    /**
     * 注册
     *
     * @param phone
     * @param password
     * @return
     */
    @RequestMapping(value = "signup", method = RequestMethod.GET)
    public String signup(String phone, String password) {
        boolean result = userService.signup(phone, password);
        return result ? SystemConstants.Code.SUCCESS : SystemConstants.Code.FAIL;
    }


    @RequestMapping(value = "add",method={RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    public String insert(User user){
        log.info("请求参数:{}",user);
        return ""+userService.saveUser(user);
    }

    @RequestMapping(value = "list/{start}/{size}",method={RequestMethod.POST,RequestMethod.GET})
    public @ResponseBody
    PageInfo<User> getUserList(@PathVariable("start")int start, @PathVariable("size")int size){
        PageHelper.startPage(start,size);
        List<User> list= userService.getUserList();
        PageInfo<User> pageInfo =new PageInfo<User>(list);
        log.info("pageInfo="+pageInfo.toString());
        return pageInfo ;
    }
}
