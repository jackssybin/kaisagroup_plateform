package com.kaisagroup.plateform.service.user.mapper;

import com.kaisagroup.plateform.service.user.bean.User;
import com.kaisagroup.plateform.service.user.bean.UserExample;
import java.util.List;

public interface UserMapper {
    int deleteByPrimaryKey(String tid);

    int insert(User record);

    int insertSelective(User record);

    List<User> selectByExample(UserExample example);

    User selectByPrimaryKey(String tid);

    User selectByPhone(String phone);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}