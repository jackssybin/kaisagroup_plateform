package com.kaisagroup.plateform.service.user.service.impl;

import com.kaisagroup.plateform.common.util.UUIDUtils;
import com.kaisagroup.plateform.service.user.bean.User;
import com.kaisagroup.plateform.service.user.bean.UserExample;
import com.kaisagroup.plateform.service.user.mapper.UserMapper;
import com.kaisagroup.plateform.service.user.service.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * Created by jackssy on 2018/5/9.
 */
@Service
public class UserServiceImpl implements IUserService{


    private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    UserMapper userMapper;

    @Override
    public boolean login(String phone, String password) {
        UserExample example = new UserExample();
        example.createCriteria().andPhoneEqualTo(phone);
        example.createCriteria().andPasswordEqualTo(password);
        List<User> userList = userMapper.selectByExample(example);
        logger.info("{}登陆成功!",phone);
        return !CollectionUtils.isEmpty(userList);
    }

    @Override
    public boolean signup(String phone, String password) {
        UserExample example = new UserExample();
        example.createCriteria().andPhoneEqualTo(phone);
        example.createCriteria().andPasswordEqualTo(password);
        List<User> userList = userMapper.selectByExample(example);
        if (!CollectionUtils.isEmpty(userList)) {
            logger.warn("{}-用户已存在，请选择其它用户名!",phone);
            return false;
        }
        User user = new User();
        user.setPassword(password);
        user.setPhone(phone);
        user.setTid(UUIDUtils.getUUID());
        int result = userMapper.insertSelective(user);
        logger.info("{}注册成功！",phone);
        return result > 0 ? true : false;
    }

    @Override
    public List<User> getUserList() {
        return userMapper.selectByExample(new UserExample());
    }

    @Override
    public User findByTid(String tid) {
        return userMapper.selectByPrimaryKey(tid);
    }

    @Override
    public User findByPhone(String phone) {
        return userMapper.selectByPhone(phone);
    }

    @Override
    public int saveUser(User user) {
        return userMapper.insert(user);
    }

    @Override
    public int updateUser(User record) {
        return userMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateUserByPrimaryKey(User record) {
        return userMapper.updateByPrimaryKey(record);
    }


}
