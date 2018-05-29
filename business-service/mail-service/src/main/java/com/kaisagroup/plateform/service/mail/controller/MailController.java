package com.kaisagroup.plateform.service.mail.controller;

/**
 * Created by jackssy on 2018/5/15.
 */

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kaisagroup.plateform.common.util.*;
import com.kaisagroup.plateform.common.web.BaseResp;
import com.kaisagroup.plateform.service.mail.bean.*;
import com.kaisagroup.plateform.service.mail.constant.RedisConstant;
import com.kaisagroup.plateform.service.mail.service.IMailService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.*;

import javax.mail.internet.MimeMessage;
import java.util.List;


@RestController
@RequestMapping("mail")
@Slf4j
public class MailController {
    @Autowired
    JavaMailSender mailSender;


    @Value("${foot:test}")
    private String mailHost;

    @Value("${spring.mail.fromUser:null}")
    private String fromUser;

    @Value("${spring.mail.toUser:null}")
    private String toUser;

    @Autowired
    private RedisTemplate<String, String> redis;

    @Autowired
    private IMailService mailService;

    @ApiOperation("发送邮件测试")
    @RequestMapping(value = "sendEmailTest", method = {RequestMethod.POST})
    public BaseResp sendEmailTest()
    {
        BaseResp resp = new BaseResp();
        try
        {
            final MimeMessage mimeMessage = this.mailSender.createMimeMessage();
            final MimeMessageHelper message = new MimeMessageHelper(mimeMessage);
            message.setFrom(fromUser);
            message.setTo(toUser);
            String[] toUserArray =null;
//            String[] toUserArray = new String[list.size()];
//            list.toArray(toUserArray);
            message.setSubject("测试邮件主题");
            message.setText("<!DOCTYPE html>\n" +
                    "<html>\n" +
                    "<head> \n" +
                    "<meta charset=\"utf-8\"> \n" +
                    "<title>W3Cschool教程(w3cschool.cn)</title> \n" +
                    "</head>\n" +
                    "<body>\n" +
                    "\n" +
                    "<h2>Norwegian Mountain Trip</h2>\n" +
                    "<img border=\"0\" src=\"https://www.w3cschool.cn/statics/images/course/pulpit.jpg\" alt=\"Pulpit rock\" width=\"304\" height=\"228\">\n" +
                    "\n" +
                    "</body>\n" +
                    "</html>",true);

            String redisVal=RedisUtil.hget(redis,RedisConstant.KAISA_EMAIL_QUEUE_REDIS_KEY, "TEST_EMAIL");
            log.info("redis 存取的数值为 key:"+RedisConstant.KAISA_EMAIL_QUEUE_REDIS_KEY+"TEST_EMAIL"+ "value="+redisVal);
            if(StringUtils.isEmpty(redisVal)){
                this.mailSender.send(mimeMessage);
                log.info("成功发送信息");
                RedisUtil.hset(redis, RedisConstant.KAISA_EMAIL_QUEUE_REDIS_KEY, "TEST_EMAIL", "0");
            }else{
                log.info("已经发送信息，防止重复发送信息!");
            }
        }
        catch(Exception ex)
        {
            RedisUtil.hset(redis, RedisConstant.KAISA_EMAIL_QUEUE_REDIS_KEY, "TEST_EMAIL", "-1");
            resp.setErrorCode(-1);
            resp.setErrorMessage("发送邮件错误"+ex.getMessage());
            log.info("发送信息失败"+ ex.getMessage());
        }

        return resp;
    }

    @ApiOperation("发送详细邮件测试")
    @RequestMapping(value = "sendEmailDetailTest", method = {RequestMethod.POST})
    public BaseResp sendEmailDetailTest(String emailFromUser,
                                    String emailToUser,
                                    String emailCcUser,
                                    String emailBccUser,
                                    String emailSubject,String emailContent,boolean isEmailContentHtml)
    {
        BaseResp resp = new BaseResp();
        try
        {
            final MimeMessage mimeMessage = this.mailSender.createMimeMessage();
            final MimeMessageHelper message = new MimeMessageHelper(mimeMessage);
            message.setFrom(emailFromUser);
            message.setTo(emailToUser);
            message.setCc(emailCcUser);
            message.setBcc(emailBccUser);
            message.setSubject(emailSubject);
            message.setText(emailContent,isEmailContentHtml);
            this.mailSender.send(mimeMessage);
        }
        catch(Exception ex)
        {
            resp.setErrorCode(-1);
            resp.setErrorMessage("发送邮件错误"+ex.getMessage());
        }

        return resp;
    }

    /*@ApiOperation("发送详细邮件测试")
    @RequestMapping(value = "sendEmailByTemplate", method = {RequestMethod.GET,RequestMethod.POST})*/
    public BaseResp sendEmailByTemplate(String templateId,String receiveParam)
    {
        BaseResp resp = new BaseResp();
        try
        {
            final MimeMessage mimeMessage = this.mailSender.createMimeMessage();
            final MimeMessageHelper message = new MimeMessageHelper(mimeMessage);

            mailService.queryByTemplateId(templateId);


            this.mailSender.send(mimeMessage);
        }
        catch(Exception ex)
        {
            resp.setErrorCode(-1);
            resp.setErrorMessage("发送邮件错误"+ex.getMessage());
        }

        return resp;
    }

    @ApiOperation("发送邮件")
    @RequestMapping(value = "sendEmail",method = {RequestMethod.POST})
    public BaseResp sendEmail(String emailId,String receiveParam)
    {
        BaseResp resp = new BaseResp();
        int sendState =0;//失败
        EmailLog emailLog = new EmailLog();
        emailLog.setTid(UUIDUtils.getUUID());
        emailLog.setState(sendState);
        try
        {
            final MimeMessage mimeMessage = this.mailSender.createMimeMessage();
            final MimeMessageHelper message = new MimeMessageHelper(mimeMessage);
            Email email =this.mailService.queryByEmailId(emailId);
            if(null==email){
                resp.setErrorCode(-1);
                resp.setErrorMessage("不存在的邮件id"+emailId);
            }else{
                if(StringUtils.isNotEmpty(email.getFromUser())){//发送者
                    message.setFrom(email.getFromUser());
                }
                if(StringUtils.isNotEmpty(email.getToUser())){//接收者
                    message.setTo(email.getToUser().split(","));
                }
                if(StringUtils.isNotEmpty(email.getCcUser())){//抄送者
                    message.setCc(email.getCcUser().split(","));
                }
                if(StringUtils.isNotEmpty(email.getBccUser())){//密送者
                    message.setCc(email.getBccUser().split(","));
                }
                BeanUtilExt.copyProperties(emailLog,email);
                EmailTemplate template =this.mailService.queryByTemplateId(email.getTemplateId());
                if(null==template){
                    resp.setErrorCode(-1);
                    resp.setErrorMessage("不存在的邮件模板id"+email.getTemplateId());
                }else{
                    String subject =template.getSubject();
                    String content = template.getTextContent();
                    if(StringUtils.isEmpty(receiveParam)){
                        if(StringUtils.isNotEmpty(email.getReceiveParam())){
                            receiveParam=email.getReceiveParam();
                        }
                    }
                    if(StringUtils.isNotEmpty(receiveParam)){
                        String[] params=receiveParam.split(",");
                        subject=replaceComStrArr(subject,params);//邮件标题
                        content=replaceComStrArr(content,params);//邮件内容
                    }
                    message.setSubject(subject);
                    message.setText(content,Boolean.valueOf(template.getIsHtml()));
                    this.mailSender.send(mimeMessage);
                    sendState=1;
                    emailLog.setState(sendState);
                    emailLog.setTemplateId(template.getTemplateId());
                    emailLog.setSubject(template.getSubject());
                    emailLog.setTextContent(template.getTextContent());
                }
            }
        }
        catch(Exception ex)
        {
            emailLog.setState(sendState);
            resp.setErrorCode(-1);
            resp.setErrorMessage("发送邮件错误"+ex.getMessage());
            emailLog.setErrorDetail(ex.getMessage());
        }
        emailLog.setCreateDate(DateUtil.getCurrDate());
        emailLog.setCreateBy("needUserName");
        log.info("emailLog:"+emailLog.toString());
        mailService.saveEmailLog(emailLog);
        return resp;
    }


    @ApiOperation("保存邮件")
    @RequestMapping(value = "saveMail", method = {RequestMethod.POST})
    public BaseResp saveMail(Email email)
    {
        if(null!=email&&StringUtils.isEmpty(email.getTid())){
            email.setTid(UUIDUtils.getUUID());
            email.setCreateBy("needUserName");
            email.setCreateDate(DateUtil.getCurrDate());
        }
        email.setUpdateDate(DateUtil.getCurrDate());
        mailService.saveEmail(email);
        return new BaseResp();
    }

    @ApiOperation("获取邮件列表")
    @RequestMapping(value = "getMailList/{start}/{size}",method={RequestMethod.GET})
    public @ResponseBody
    PageInfo<Email> getMailList(@PathVariable("start")int start, @PathVariable("size")int size){
        PageHelper.startPage(start,size);
        EmailExample example = new EmailExample();
        List<Email> list= mailService.selectMailByExample(example);
        PageInfo<Email> pageInfo =new PageInfo<Email>(list);
        log.info("pageInfo email="+pageInfo.toString());
        return pageInfo ;
    }

    @ApiOperation("获取邮件日志列表")
    @RequestMapping(value = "getMailLogList/{start}/{size}",method={RequestMethod.GET})
    public @ResponseBody
    PageInfo<EmailLog> getMailLogList(@PathVariable("start")int start, @PathVariable("size")int size){
        PageHelper.startPage(start,size);
        EmailLogExample example = new EmailLogExample();
        List<EmailLog> list= mailService.selectMailLogByExample(example);
        PageInfo<EmailLog> pageInfo =new PageInfo<EmailLog>(list);
        log.info("pageInfo emailLog="+pageInfo.toString());
        return pageInfo ;
    }

    @ApiOperation("获取邮件模板列表")
    @RequestMapping(value = "getMailTemplateList/{start}/{size}",method={RequestMethod.GET})
    public @ResponseBody
    PageInfo<EmailTemplate> getMailTemplateList(@PathVariable("start")int start, @PathVariable("size")int size){
        PageHelper.startPage(start,size);
        EmailTemplateExample example = new EmailTemplateExample();
        List<EmailTemplate> list= mailService.selectMailTemplateByExample(example);
        PageInfo<EmailTemplate> pageInfo =new PageInfo<EmailTemplate>(list);
        log.info("pageInfo emailTemplate="+pageInfo.toString());
        return pageInfo ;
    }


    /**
     * 替换掉模板中{1}格式的字样
     * @param {}target 目标
     * @param {}strArr 替换的值
     * @return
     */
    public String replaceComStrArr(String target, String[] repArr){
        if (null == target) {
            return StringUtil.EMPTY;
        }
        for (int i = 1; i <= repArr.length; i++) {
            target = target.replace("{" + i +"}" , repArr[i - 1]);
        }
        return target;
    }



}