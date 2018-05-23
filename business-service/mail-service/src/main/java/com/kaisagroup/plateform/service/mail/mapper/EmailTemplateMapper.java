package com.kaisagroup.plateform.service.mail.mapper;

import com.kaisagroup.plateform.service.mail.bean.EmailTemplate;
import com.kaisagroup.plateform.service.mail.bean.EmailTemplateExample;
import java.util.List;

public interface EmailTemplateMapper {
    int deleteByPrimaryKey(String tid);

    int insert(EmailTemplate record);

    int insertSelective(EmailTemplate record);

    List<EmailTemplate> selectByExample(EmailTemplateExample example);

    EmailTemplate selectByPrimaryKey(String tid);


    EmailTemplate selectByTemplateId(String templateId);

    int updateByPrimaryKeySelective(EmailTemplate record);

    int updateByPrimaryKey(EmailTemplate record);
}