package com.kaisagroup.plateform.service.mail.service;

import com.kaisagroup.plateform.service.mail.bean.*;

import java.util.List;

/**
 * Created by jackssy on 2018/5/21.
 */
public interface IMailService {

    EmailTemplate queryByTemplateId(String templateId);

    Email queryByEmailId(String tid);

    void saveEmail(Email email);

    void saveEmailLog(EmailLog emailLog);

    List<Email>  selectMailByExample(EmailExample example);

    List<EmailLog>  selectMailLogByExample(EmailLogExample example);

    List<EmailTemplate>  selectMailTemplateByExample(EmailTemplateExample example);
}
