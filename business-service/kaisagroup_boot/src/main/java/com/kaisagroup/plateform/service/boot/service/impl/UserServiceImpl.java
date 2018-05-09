package com.kaisagroup.plateform.service.boot.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.kaisagroup.plateform.service.boot.dao.IUserDao;
import com.kaisagroup.plateform.service.boot.entity.User;
import com.kaisagroup.plateform.service.boot.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private IUserDao userDao;

    @Override
    public String insert(User user) {
        int resultInt=userDao.insert(user);
        JSONObject result = new JSONObject();
        if(resultInt>0){
             result.put("success",true);
             result.put("msg","成功");
        }else{
            result.put("success",false);
            result.put("msg","失败");
        }
        return result.toJSONString();
    }

    @Override
    public List<User> getList() {
        return userDao.queryList();
    }
}
