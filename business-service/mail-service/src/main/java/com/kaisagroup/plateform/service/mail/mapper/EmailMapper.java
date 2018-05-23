package com.kaisagroup.plateform.service.mail.mapper;

import com.kaisagroup.plateform.service.mail.bean.Email;
import com.kaisagroup.plateform.service.mail.bean.EmailExample;
import java.util.List;

public interface EmailMapper {
    int deleteByPrimaryKey(String tid);

    int insert(Email record);

    int insertSelective(Email record);

    List<Email> selectByExample(EmailExample example);

    Email selectByPrimaryKey(String tid);

    int updateByPrimaryKeySelective(Email record);

    int updateByPrimaryKey(Email record);
}