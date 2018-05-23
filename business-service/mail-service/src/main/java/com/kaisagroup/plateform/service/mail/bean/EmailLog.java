package com.kaisagroup.plateform.service.mail.bean;

import java.util.Date;

public class EmailLog {
    private String tid;

    private String fromUser;

    private String toUser;

    private String ccUser;

    private String bccUser;

    private String priority;

    private String subject;

    private String templateId;

    private String textContent;

    private String receiveParam;

    private Integer state;

    private Date createDate;

    private String createBy;

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid == null ? null : tid.trim();
    }

    public String getFromUser() {
        return fromUser;
    }

    public void setFromUser(String fromUser) {
        this.fromUser = fromUser == null ? null : fromUser.trim();
    }

    public String getToUser() {
        return toUser;
    }

    public void setToUser(String toUser) {
        this.toUser = toUser == null ? null : toUser.trim();
    }

    public String getCcUser() {
        return ccUser;
    }

    public void setCcUser(String ccUser) {
        this.ccUser = ccUser == null ? null : ccUser.trim();
    }

    public String getBccUser() {
        return bccUser;
    }

    public void setBccUser(String bccUser) {
        this.bccUser = bccUser == null ? null : bccUser.trim();
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority == null ? null : priority.trim();
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject == null ? null : subject.trim();
    }

    public String getTemplateId() {
        return templateId;
    }

    public void setTemplateId(String templateId) {
        this.templateId = templateId == null ? null : templateId.trim();
    }

    public String getTextContent() {
        return textContent;
    }

    public void setTextContent(String textContent) {
        this.textContent = textContent == null ? null : textContent.trim();
    }

    public String getReceiveParam() {
        return receiveParam;
    }

    public void setReceiveParam(String receiveParam) {
        this.receiveParam = receiveParam == null ? null : receiveParam.trim();
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy == null ? null : createBy.trim();
    }
}