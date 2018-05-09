package com.kaisagroup.plateform.service.boot.service;

import com.kaisagroup.plateform.service.boot.entity.User;

import java.util.List;


public interface IUserService {

    String insert(User user);

    List<User> getList();
}
