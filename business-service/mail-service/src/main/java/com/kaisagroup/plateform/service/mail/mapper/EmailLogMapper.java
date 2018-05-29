package com.kaisagroup.plateform.service.mail.mapper;

import com.kaisagroup.plateform.service.mail.bean.EmailLog;
import com.kaisagroup.plateform.service.mail.bean.EmailLogExample;
import java.util.List;

public interface EmailLogMapper {
    int deleteByPrimaryKey(String tid);

    int insert(EmailLog record);

    int insertSelective(EmailLog record);

    List<EmailLog> selectByExample(EmailLogExample example);

    EmailLog selectByPrimaryKey(String tid);

    int updateByPrimaryKeySelective(EmailLog record);

    int updateByPrimaryKey(EmailLog record);
}