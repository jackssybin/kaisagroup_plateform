package com.kaisagroup.plateform.service.mail.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EmailLogExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public EmailLogExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andTidIsNull() {
            addCriterion("tid is null");
            return (Criteria) this;
        }

        public Criteria andTidIsNotNull() {
            addCriterion("tid is not null");
            return (Criteria) this;
        }

        public Criteria andTidEqualTo(String value) {
            addCriterion("tid =", value, "tid");
            return (Criteria) this;
        }

        public Criteria andTidNotEqualTo(String value) {
            addCriterion("tid <>", value, "tid");
            return (Criteria) this;
        }

        public Criteria andTidGreaterThan(String value) {
            addCriterion("tid >", value, "tid");
            return (Criteria) this;
        }

        public Criteria andTidGreaterThanOrEqualTo(String value) {
            addCriterion("tid >=", value, "tid");
            return (Criteria) this;
        }

        public Criteria andTidLessThan(String value) {
            addCriterion("tid <", value, "tid");
            return (Criteria) this;
        }

        public Criteria andTidLessThanOrEqualTo(String value) {
            addCriterion("tid <=", value, "tid");
            return (Criteria) this;
        }

        public Criteria andTidLike(String value) {
            addCriterion("tid like", value, "tid");
            return (Criteria) this;
        }

        public Criteria andTidNotLike(String value) {
            addCriterion("tid not like", value, "tid");
            return (Criteria) this;
        }

        public Criteria andTidIn(List<String> values) {
            addCriterion("tid in", values, "tid");
            return (Criteria) this;
        }

        public Criteria andTidNotIn(List<String> values) {
            addCriterion("tid not in", values, "tid");
            return (Criteria) this;
        }

        public Criteria andTidBetween(String value1, String value2) {
            addCriterion("tid between", value1, value2, "tid");
            return (Criteria) this;
        }

        public Criteria andTidNotBetween(String value1, String value2) {
            addCriterion("tid not between", value1, value2, "tid");
            return (Criteria) this;
        }

        public Criteria andFromUserIsNull() {
            addCriterion("from_user is null");
            return (Criteria) this;
        }

        public Criteria andFromUserIsNotNull() {
            addCriterion("from_user is not null");
            return (Criteria) this;
        }

        public Criteria andFromUserEqualTo(String value) {
            addCriterion("from_user =", value, "fromUser");
            return (Criteria) this;
        }

        public Criteria andFromUserNotEqualTo(String value) {
            addCriterion("from_user <>", value, "fromUser");
            return (Criteria) this;
        }

        public Criteria andFromUserGreaterThan(String value) {
            addCriterion("from_user >", value, "fromUser");
            return (Criteria) this;
        }

        public Criteria andFromUserGreaterThanOrEqualTo(String value) {
            addCriterion("from_user >=", value, "fromUser");
            return (Criteria) this;
        }

        public Criteria andFromUserLessThan(String value) {
            addCriterion("from_user <", value, "fromUser");
            return (Criteria) this;
        }

        public Criteria andFromUserLessThanOrEqualTo(String value) {
            addCriterion("from_user <=", value, "fromUser");
            return (Criteria) this;
        }

        public Criteria andFromUserLike(String value) {
            addCriterion("from_user like", value, "fromUser");
            return (Criteria) this;
        }

        public Criteria andFromUserNotLike(String value) {
            addCriterion("from_user not like", value, "fromUser");
            return (Criteria) this;
        }

        public Criteria andFromUserIn(List<String> values) {
            addCriterion("from_user in", values, "fromUser");
            return (Criteria) this;
        }

        public Criteria andFromUserNotIn(List<String> values) {
            addCriterion("from_user not in", values, "fromUser");
            return (Criteria) this;
        }

        public Criteria andFromUserBetween(String value1, String value2) {
            addCriterion("from_user between", value1, value2, "fromUser");
            return (Criteria) this;
        }

        public Criteria andFromUserNotBetween(String value1, String value2) {
            addCriterion("from_user not between", value1, value2, "fromUser");
            return (Criteria) this;
        }

        public Criteria andToUserIsNull() {
            addCriterion("to_user is null");
            return (Criteria) this;
        }

        public Criteria andToUserIsNotNull() {
            addCriterion("to_user is not null");
            return (Criteria) this;
        }

        public Criteria andToUserEqualTo(String value) {
            addCriterion("to_user =", value, "toUser");
            return (Criteria) this;
        }

        public Criteria andToUserNotEqualTo(String value) {
            addCriterion("to_user <>", value, "toUser");
            return (Criteria) this;
        }

        public Criteria andToUserGreaterThan(String value) {
            addCriterion("to_user >", value, "toUser");
            return (Criteria) this;
        }

        public Criteria andToUserGreaterThanOrEqualTo(String value) {
            addCriterion("to_user >=", value, "toUser");
            return (Criteria) this;
        }

        public Criteria andToUserLessThan(String value) {
            addCriterion("to_user <", value, "toUser");
            return (Criteria) this;
        }

        public Criteria andToUserLessThanOrEqualTo(String value) {
            addCriterion("to_user <=", value, "toUser");
            return (Criteria) this;
        }

        public Criteria andToUserLike(String value) {
            addCriterion("to_user like", value, "toUser");
            return (Criteria) this;
        }

        public Criteria andToUserNotLike(String value) {
            addCriterion("to_user not like", value, "toUser");
            return (Criteria) this;
        }

        public Criteria andToUserIn(List<String> values) {
            addCriterion("to_user in", values, "toUser");
            return (Criteria) this;
        }

        public Criteria andToUserNotIn(List<String> values) {
            addCriterion("to_user not in", values, "toUser");
            return (Criteria) this;
        }

        public Criteria andToUserBetween(String value1, String value2) {
            addCriterion("to_user between", value1, value2, "toUser");
            return (Criteria) this;
        }

        public Criteria andToUserNotBetween(String value1, String value2) {
            addCriterion("to_user not between", value1, value2, "toUser");
            return (Criteria) this;
        }

        public Criteria andCcUserIsNull() {
            addCriterion("cc_user is null");
            return (Criteria) this;
        }

        public Criteria andCcUserIsNotNull() {
            addCriterion("cc_user is not null");
            return (Criteria) this;
        }

        public Criteria andCcUserEqualTo(String value) {
            addCriterion("cc_user =", value, "ccUser");
            return (Criteria) this;
        }

        public Criteria andCcUserNotEqualTo(String value) {
            addCriterion("cc_user <>", value, "ccUser");
            return (Criteria) this;
        }

        public Criteria andCcUserGreaterThan(String value) {
            addCriterion("cc_user >", value, "ccUser");
            return (Criteria) this;
        }

        public Criteria andCcUserGreaterThanOrEqualTo(String value) {
            addCriterion("cc_user >=", value, "ccUser");
            return (Criteria) this;
        }

        public Criteria andCcUserLessThan(String value) {
            addCriterion("cc_user <", value, "ccUser");
            return (Criteria) this;
        }

        public Criteria andCcUserLessThanOrEqualTo(String value) {
            addCriterion("cc_user <=", value, "ccUser");
            return (Criteria) this;
        }

        public Criteria andCcUserLike(String value) {
            addCriterion("cc_user like", value, "ccUser");
            return (Criteria) this;
        }

        public Criteria andCcUserNotLike(String value) {
            addCriterion("cc_user not like", value, "ccUser");
            return (Criteria) this;
        }

        public Criteria andCcUserIn(List<String> values) {
            addCriterion("cc_user in", values, "ccUser");
            return (Criteria) this;
        }

        public Criteria andCcUserNotIn(List<String> values) {
            addCriterion("cc_user not in", values, "ccUser");
            return (Criteria) this;
        }

        public Criteria andCcUserBetween(String value1, String value2) {
            addCriterion("cc_user between", value1, value2, "ccUser");
            return (Criteria) this;
        }

        public Criteria andCcUserNotBetween(String value1, String value2) {
            addCriterion("cc_user not between", value1, value2, "ccUser");
            return (Criteria) this;
        }

        public Criteria andBccUserIsNull() {
            addCriterion("bcc_user is null");
            return (Criteria) this;
        }

        public Criteria andBccUserIsNotNull() {
            addCriterion("bcc_user is not null");
            return (Criteria) this;
        }

        public Criteria andBccUserEqualTo(String value) {
            addCriterion("bcc_user =", value, "bccUser");
            return (Criteria) this;
        }

        public Criteria andBccUserNotEqualTo(String value) {
            addCriterion("bcc_user <>", value, "bccUser");
            return (Criteria) this;
        }

        public Criteria andBccUserGreaterThan(String value) {
            addCriterion("bcc_user >", value, "bccUser");
            return (Criteria) this;
        }

        public Criteria andBccUserGreaterThanOrEqualTo(String value) {
            addCriterion("bcc_user >=", value, "bccUser");
            return (Criteria) this;
        }

        public Criteria andBccUserLessThan(String value) {
            addCriterion("bcc_user <", value, "bccUser");
            return (Criteria) this;
        }

        public Criteria andBccUserLessThanOrEqualTo(String value) {
            addCriterion("bcc_user <=", value, "bccUser");
            return (Criteria) this;
        }

        public Criteria andBccUserLike(String value) {
            addCriterion("bcc_user like", value, "bccUser");
            return (Criteria) this;
        }

        public Criteria andBccUserNotLike(String value) {
            addCriterion("bcc_user not like", value, "bccUser");
            return (Criteria) this;
        }

        public Criteria andBccUserIn(List<String> values) {
            addCriterion("bcc_user in", values, "bccUser");
            return (Criteria) this;
        }

        public Criteria andBccUserNotIn(List<String> values) {
            addCriterion("bcc_user not in", values, "bccUser");
            return (Criteria) this;
        }

        public Criteria andBccUserBetween(String value1, String value2) {
            addCriterion("bcc_user between", value1, value2, "bccUser");
            return (Criteria) this;
        }

        public Criteria andBccUserNotBetween(String value1, String value2) {
            addCriterion("bcc_user not between", value1, value2, "bccUser");
            return (Criteria) this;
        }

        public Criteria andPriorityIsNull() {
            addCriterion("priority is null");
            return (Criteria) this;
        }

        public Criteria andPriorityIsNotNull() {
            addCriterion("priority is not null");
            return (Criteria) this;
        }

        public Criteria andPriorityEqualTo(String value) {
            addCriterion("priority =", value, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityNotEqualTo(String value) {
            addCriterion("priority <>", value, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityGreaterThan(String value) {
            addCriterion("priority >", value, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityGreaterThanOrEqualTo(String value) {
            addCriterion("priority >=", value, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityLessThan(String value) {
            addCriterion("priority <", value, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityLessThanOrEqualTo(String value) {
            addCriterion("priority <=", value, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityLike(String value) {
            addCriterion("priority like", value, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityNotLike(String value) {
            addCriterion("priority not like", value, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityIn(List<String> values) {
            addCriterion("priority in", values, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityNotIn(List<String> values) {
            addCriterion("priority not in", values, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityBetween(String value1, String value2) {
            addCriterion("priority between", value1, value2, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityNotBetween(String value1, String value2) {
            addCriterion("priority not between", value1, value2, "priority");
            return (Criteria) this;
        }

        public Criteria andSubjectIsNull() {
            addCriterion("subject is null");
            return (Criteria) this;
        }

        public Criteria andSubjectIsNotNull() {
            addCriterion("subject is not null");
            return (Criteria) this;
        }

        public Criteria andSubjectEqualTo(String value) {
            addCriterion("subject =", value, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectNotEqualTo(String value) {
            addCriterion("subject <>", value, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectGreaterThan(String value) {
            addCriterion("subject >", value, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectGreaterThanOrEqualTo(String value) {
            addCriterion("subject >=", value, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectLessThan(String value) {
            addCriterion("subject <", value, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectLessThanOrEqualTo(String value) {
            addCriterion("subject <=", value, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectLike(String value) {
            addCriterion("subject like", value, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectNotLike(String value) {
            addCriterion("subject not like", value, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectIn(List<String> values) {
            addCriterion("subject in", values, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectNotIn(List<String> values) {
            addCriterion("subject not in", values, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectBetween(String value1, String value2) {
            addCriterion("subject between", value1, value2, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectNotBetween(String value1, String value2) {
            addCriterion("subject not between", value1, value2, "subject");
            return (Criteria) this;
        }

        public Criteria andTemplateIdIsNull() {
            addCriterion("template_id is null");
            return (Criteria) this;
        }

        public Criteria andTemplateIdIsNotNull() {
            addCriterion("template_id is not null");
            return (Criteria) this;
        }

        public Criteria andTemplateIdEqualTo(String value) {
            addCriterion("template_id =", value, "templateId");
            return (Criteria) this;
        }

        public Criteria andTemplateIdNotEqualTo(String value) {
            addCriterion("template_id <>", value, "templateId");
            return (Criteria) this;
        }

        public Criteria andTemplateIdGreaterThan(String value) {
            addCriterion("template_id >", value, "templateId");
            return (Criteria) this;
        }

        public Criteria andTemplateIdGreaterThanOrEqualTo(String value) {
            addCriterion("template_id >=", value, "templateId");
            return (Criteria) this;
        }

        public Criteria andTemplateIdLessThan(String value) {
            addCriterion("template_id <", value, "templateId");
            return (Criteria) this;
        }

        public Criteria andTemplateIdLessThanOrEqualTo(String value) {
            addCriterion("template_id <=", value, "templateId");
            return (Criteria) this;
        }

        public Criteria andTemplateIdLike(String value) {
            addCriterion("template_id like", value, "templateId");
            return (Criteria) this;
        }

        public Criteria andTemplateIdNotLike(String value) {
            addCriterion("template_id not like", value, "templateId");
            return (Criteria) this;
        }

        public Criteria andTemplateIdIn(List<String> values) {
            addCriterion("template_id in", values, "templateId");
            return (Criteria) this;
        }

        public Criteria andTemplateIdNotIn(List<String> values) {
            addCriterion("template_id not in", values, "templateId");
            return (Criteria) this;
        }

        public Criteria andTemplateIdBetween(String value1, String value2) {
            addCriterion("template_id between", value1, value2, "templateId");
            return (Criteria) this;
        }

        public Criteria andTemplateIdNotBetween(String value1, String value2) {
            addCriterion("template_id not between", value1, value2, "templateId");
            return (Criteria) this;
        }

        public Criteria andTextContentIsNull() {
            addCriterion("text_content is null");
            return (Criteria) this;
        }

        public Criteria andTextContentIsNotNull() {
            addCriterion("text_content is not null");
            return (Criteria) this;
        }

        public Criteria andTextContentEqualTo(String value) {
            addCriterion("text_content =", value, "textContent");
            return (Criteria) this;
        }

        public Criteria andTextContentNotEqualTo(String value) {
            addCriterion("text_content <>", value, "textContent");
            return (Criteria) this;
        }

        public Criteria andTextContentGreaterThan(String value) {
            addCriterion("text_content >", value, "textContent");
            return (Criteria) this;
        }

        public Criteria andTextContentGreaterThanOrEqualTo(String value) {
            addCriterion("text_content >=", value, "textContent");
            return (Criteria) this;
        }

        public Criteria andTextContentLessThan(String value) {
            addCriterion("text_content <", value, "textContent");
            return (Criteria) this;
        }

        public Criteria andTextContentLessThanOrEqualTo(String value) {
            addCriterion("text_content <=", value, "textContent");
            return (Criteria) this;
        }

        public Criteria andTextContentLike(String value) {
            addCriterion("text_content like", value, "textContent");
            return (Criteria) this;
        }

        public Criteria andTextContentNotLike(String value) {
            addCriterion("text_content not like", value, "textContent");
            return (Criteria) this;
        }

        public Criteria andTextContentIn(List<String> values) {
            addCriterion("text_content in", values, "textContent");
            return (Criteria) this;
        }

        public Criteria andTextContentNotIn(List<String> values) {
            addCriterion("text_content not in", values, "textContent");
            return (Criteria) this;
        }

        public Criteria andTextContentBetween(String value1, String value2) {
            addCriterion("text_content between", value1, value2, "textContent");
            return (Criteria) this;
        }

        public Criteria andTextContentNotBetween(String value1, String value2) {
            addCriterion("text_content not between", value1, value2, "textContent");
            return (Criteria) this;
        }

        public Criteria andReceiveParamIsNull() {
            addCriterion("receive_param is null");
            return (Criteria) this;
        }

        public Criteria andReceiveParamIsNotNull() {
            addCriterion("receive_param is not null");
            return (Criteria) this;
        }

        public Criteria andReceiveParamEqualTo(String value) {
            addCriterion("receive_param =", value, "receiveParam");
            return (Criteria) this;
        }

        public Criteria andReceiveParamNotEqualTo(String value) {
            addCriterion("receive_param <>", value, "receiveParam");
            return (Criteria) this;
        }

        public Criteria andReceiveParamGreaterThan(String value) {
            addCriterion("receive_param >", value, "receiveParam");
            return (Criteria) this;
        }

        public Criteria andReceiveParamGreaterThanOrEqualTo(String value) {
            addCriterion("receive_param >=", value, "receiveParam");
            return (Criteria) this;
        }

        public Criteria andReceiveParamLessThan(String value) {
            addCriterion("receive_param <", value, "receiveParam");
            return (Criteria) this;
        }

        public Criteria andReceiveParamLessThanOrEqualTo(String value) {
            addCriterion("receive_param <=", value, "receiveParam");
            return (Criteria) this;
        }

        public Criteria andReceiveParamLike(String value) {
            addCriterion("receive_param like", value, "receiveParam");
            return (Criteria) this;
        }

        public Criteria andReceiveParamNotLike(String value) {
            addCriterion("receive_param not like", value, "receiveParam");
            return (Criteria) this;
        }

        public Criteria andReceiveParamIn(List<String> values) {
            addCriterion("receive_param in", values, "receiveParam");
            return (Criteria) this;
        }

        public Criteria andReceiveParamNotIn(List<String> values) {
            addCriterion("receive_param not in", values, "receiveParam");
            return (Criteria) this;
        }

        public Criteria andReceiveParamBetween(String value1, String value2) {
            addCriterion("receive_param between", value1, value2, "receiveParam");
            return (Criteria) this;
        }

        public Criteria andReceiveParamNotBetween(String value1, String value2) {
            addCriterion("receive_param not between", value1, value2, "receiveParam");
            return (Criteria) this;
        }

        public Criteria andErrorDetailIsNull() {
            addCriterion("error_detail is null");
            return (Criteria) this;
        }

        public Criteria andErrorDetailIsNotNull() {
            addCriterion("error_detail is not null");
            return (Criteria) this;
        }

        public Criteria andErrorDetailEqualTo(String value) {
            addCriterion("error_detail =", value, "errorDetail");
            return (Criteria) this;
        }

        public Criteria andErrorDetailNotEqualTo(String value) {
            addCriterion("error_detail <>", value, "errorDetail");
            return (Criteria) this;
        }

        public Criteria andErrorDetailGreaterThan(String value) {
            addCriterion("error_detail >", value, "errorDetail");
            return (Criteria) this;
        }

        public Criteria andErrorDetailGreaterThanOrEqualTo(String value) {
            addCriterion("error_detail >=", value, "errorDetail");
            return (Criteria) this;
        }

        public Criteria andErrorDetailLessThan(String value) {
            addCriterion("error_detail <", value, "errorDetail");
            return (Criteria) this;
        }

        public Criteria andErrorDetailLessThanOrEqualTo(String value) {
            addCriterion("error_detail <=", value, "errorDetail");
            return (Criteria) this;
        }

        public Criteria andErrorDetailLike(String value) {
            addCriterion("error_detail like", value, "errorDetail");
            return (Criteria) this;
        }

        public Criteria andErrorDetailNotLike(String value) {
            addCriterion("error_detail not like", value, "errorDetail");
            return (Criteria) this;
        }

        public Criteria andErrorDetailIn(List<String> values) {
            addCriterion("error_detail in", values, "errorDetail");
            return (Criteria) this;
        }

        public Criteria andErrorDetailNotIn(List<String> values) {
            addCriterion("error_detail not in", values, "errorDetail");
            return (Criteria) this;
        }

        public Criteria andErrorDetailBetween(String value1, String value2) {
            addCriterion("error_detail between", value1, value2, "errorDetail");
            return (Criteria) this;
        }

        public Criteria andErrorDetailNotBetween(String value1, String value2) {
            addCriterion("error_detail not between", value1, value2, "errorDetail");
            return (Criteria) this;
        }

        public Criteria andStateIsNull() {
            addCriterion("state is null");
            return (Criteria) this;
        }

        public Criteria andStateIsNotNull() {
            addCriterion("state is not null");
            return (Criteria) this;
        }

        public Criteria andStateEqualTo(Integer value) {
            addCriterion("state =", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotEqualTo(Integer value) {
            addCriterion("state <>", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThan(Integer value) {
            addCriterion("state >", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("state >=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThan(Integer value) {
            addCriterion("state <", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThanOrEqualTo(Integer value) {
            addCriterion("state <=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateIn(List<Integer> values) {
            addCriterion("state in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotIn(List<Integer> values) {
            addCriterion("state not in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateBetween(Integer value1, Integer value2) {
            addCriterion("state between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotBetween(Integer value1, Integer value2) {
            addCriterion("state not between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNull() {
            addCriterion("create_date is null");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNotNull() {
            addCriterion("create_date is not null");
            return (Criteria) this;
        }

        public Criteria andCreateDateEqualTo(Date value) {
            addCriterion("create_date =", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotEqualTo(Date value) {
            addCriterion("create_date <>", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThan(Date value) {
            addCriterion("create_date >", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThanOrEqualTo(Date value) {
            addCriterion("create_date >=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThan(Date value) {
            addCriterion("create_date <", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThanOrEqualTo(Date value) {
            addCriterion("create_date <=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateIn(List<Date> values) {
            addCriterion("create_date in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotIn(List<Date> values) {
            addCriterion("create_date not in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateBetween(Date value1, Date value2) {
            addCriterion("create_date between", value1, value2, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotBetween(Date value1, Date value2) {
            addCriterion("create_date not between", value1, value2, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateByIsNull() {
            addCriterion("create_by is null");
            return (Criteria) this;
        }

        public Criteria andCreateByIsNotNull() {
            addCriterion("create_by is not null");
            return (Criteria) this;
        }

        public Criteria andCreateByEqualTo(String value) {
            addCriterion("create_by =", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByNotEqualTo(String value) {
            addCriterion("create_by <>", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByGreaterThan(String value) {
            addCriterion("create_by >", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByGreaterThanOrEqualTo(String value) {
            addCriterion("create_by >=", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByLessThan(String value) {
            addCriterion("create_by <", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByLessThanOrEqualTo(String value) {
            addCriterion("create_by <=", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByLike(String value) {
            addCriterion("create_by like", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByNotLike(String value) {
            addCriterion("create_by not like", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByIn(List<String> values) {
            addCriterion("create_by in", values, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByNotIn(List<String> values) {
            addCriterion("create_by not in", values, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByBetween(String value1, String value2) {
            addCriterion("create_by between", value1, value2, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByNotBetween(String value1, String value2) {
            addCriterion("create_by not between", value1, value2, "createBy");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}