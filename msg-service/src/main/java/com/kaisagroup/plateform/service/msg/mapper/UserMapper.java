package com.kaisagroup.plateform.service.msg.mapper;

import com.kaisagroup.plateform.service.msg.bean.User;
import com.kaisagroup.plateform.service.msg.bean.UserExample;
import java.util.List;

public interface UserMapper {
    int deleteByPrimaryKey(Integer userId);

    int insert(User record);

    int insertSelective(User record);

    List<User> selectByExample(UserExample example);

    User selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}