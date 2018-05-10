package com.kaisagroup.plateform.service.user.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kaisagroup.plateform.common.constant.SystemConstants;
import com.kaisagroup.plateform.common.util.UUIDUtils;
import com.kaisagroup.plateform.common.web.BaseResp;
import com.kaisagroup.plateform.service.user.bean.User;
import com.kaisagroup.plateform.service.user.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public BaseResp login(@RequestParam("phone") String phone, @RequestParam("password") String password) {
        boolean result = userService.login(phone, password);
        return new BaseResp();
    }

    /**
     * 注册
     *
     * @param phone
     * @param password
     * @return
     */
    @RequestMapping(value = "signup", method = RequestMethod.GET)
    public ResponseEntity<String> signup(String phone, String password) {
        boolean result = userService.signup(phone, password);

        return new ResponseEntity<String>(result ? SystemConstants.Code.SUCCESS : SystemConstants.Code.FAIL, HttpStatus.OK);
    }


    @RequestMapping(value = "add",method={RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    public BaseResp insert(@RequestBody User user){
        log.info("请求参数:{}",user);
        BaseResp resp = new BaseResp();
        int record=0;
        if(StringUtils.isEmpty(user.getTid())){
            user.setTid(UUIDUtils.getUUID());
            record=userService.saveUser(user);
        }else{
            record=userService.updateUser(user);
        }
        return resp;
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
