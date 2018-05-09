package com.kaisagroup.plateform.service.boot.dao;

import com.kaisagroup.plateform.service.boot.entity.User;

import java.util.List;


public interface IUserDao {

    int insert(User user);

    List<User> queryList();
}
