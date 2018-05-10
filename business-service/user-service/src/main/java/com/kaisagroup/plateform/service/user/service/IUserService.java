package com.kaisagroup.plateform.service.user.service;

import com.kaisagroup.plateform.service.user.bean.User;

import java.util.List;

/**
 * Created by jackssy on 2018/5/9.
 */
public interface IUserService {


    /**
     * @param phone
     * @param password
     * @return
     */
    boolean login(String phone, String password);

    /**
     * @param phone
     * @param password
     * @return
     */
    boolean signup(String phone, String password);

    List<User> getUserList();

    User findByTid(String tid);

    User findByPhone(String phone);

    int saveUser(User user);

    int updateUser(User record);

    int updateUserByPrimaryKey(User record);




}
