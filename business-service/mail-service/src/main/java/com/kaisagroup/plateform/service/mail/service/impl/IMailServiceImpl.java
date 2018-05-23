package com.kaisagroup.plateform.service.mail.service.impl;

import com.kaisagroup.plateform.service.mail.bean.*;
import com.kaisagroup.plateform.service.mail.mapper.EmailLogMapper;
import com.kaisagroup.plateform.service.mail.mapper.EmailMapper;
import com.kaisagroup.plateform.service.mail.mapper.EmailTemplateMapper;
import com.kaisagroup.plateform.service.mail.service.IMailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by jackssy on 2018/5/21.
 */
@Service
public class IMailServiceImpl implements IMailService {

    @Autowired
    EmailMapper emailMapper;

    @Autowired
    EmailTemplateMapper emailTemplateMapper;

    @Autowired
    EmailLogMapper emailLogMapper;

    @Override
    public EmailTemplate queryByTemplateId(String templateId) {
        return emailTemplateMapper.selectByTemplateId(templateId);
    }

    @Override
    public Email queryByEmailId(String tid) {
        return emailMapper.selectByPrimaryKey(tid);
    }

    @Override
    public List<Email> selectMailByExample(EmailExample example){
        return emailMapper.selectByExample(example);
    }
    @Override
    public List<EmailLog> selectMailLogByExample(EmailLogExample example){
        return emailLogMapper.selectByExample(example);
    }
    @Override
    public List<EmailTemplate>  selectMailTemplateByExample(EmailTemplateExample example){
        return emailTemplateMapper.selectByExample(example);
    }

    @Override
    public void saveEmail(Email email) {
        emailMapper.insert(email);
    }

    @Override
    public void saveEmailLog(EmailLog emailLog) {
        emailLogMapper.insert(emailLog);
    }

}
