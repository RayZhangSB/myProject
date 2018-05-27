package com.zhang.ssm.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UserExample() {
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

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Integer value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Integer value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Integer value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Integer value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Integer> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Integer> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Integer value1, Integer value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserNameIsNull() {
            addCriterion("user_name is null");
            return (Criteria) this;
        }

        public Criteria andUserNameIsNotNull() {
            addCriterion("user_name is not null");
            return (Criteria) this;
        }

        public Criteria andUserNameEqualTo(String value) {
            addCriterion("user_name =", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotEqualTo(String value) {
            addCriterion("user_name <>", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThan(String value) {
            addCriterion("user_name >", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("user_name >=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThan(String value) {
            addCriterion("user_name <", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThanOrEqualTo(String value) {
            addCriterion("user_name <=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLike(String value) {
            addCriterion("user_name like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotLike(String value) {
            addCriterion("user_name not like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameIn(List<String> values) {
            addCriterion("user_name in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotIn(List<String> values) {
            addCriterion("user_name not in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameBetween(String value1, String value2) {
            addCriterion("user_name between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotBetween(String value1, String value2) {
            addCriterion("user_name not between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andUserPasswordIsNull() {
            addCriterion("user_password is null");
            return (Criteria) this;
        }

        public Criteria andUserPasswordIsNotNull() {
            addCriterion("user_password is not null");
            return (Criteria) this;
        }

        public Criteria andUserPasswordEqualTo(String value) {
            addCriterion("user_password =", value, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordNotEqualTo(String value) {
            addCriterion("user_password <>", value, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordGreaterThan(String value) {
            addCriterion("user_password >", value, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("user_password >=", value, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordLessThan(String value) {
            addCriterion("user_password <", value, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordLessThanOrEqualTo(String value) {
            addCriterion("user_password <=", value, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordLike(String value) {
            addCriterion("user_password like", value, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordNotLike(String value) {
            addCriterion("user_password not like", value, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordIn(List<String> values) {
            addCriterion("user_password in", values, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordNotIn(List<String> values) {
            addCriterion("user_password not in", values, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordBetween(String value1, String value2) {
            addCriterion("user_password between", value1, value2, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordNotBetween(String value1, String value2) {
            addCriterion("user_password not between", value1, value2, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserSaltIsNull() {
            addCriterion("user_salt is null");
            return (Criteria) this;
        }

        public Criteria andUserSaltIsNotNull() {
            addCriterion("user_salt is not null");
            return (Criteria) this;
        }

        public Criteria andUserSaltEqualTo(String value) {
            addCriterion("user_salt =", value, "userSalt");
            return (Criteria) this;
        }

        public Criteria andUserSaltNotEqualTo(String value) {
            addCriterion("user_salt <>", value, "userSalt");
            return (Criteria) this;
        }

        public Criteria andUserSaltGreaterThan(String value) {
            addCriterion("user_salt >", value, "userSalt");
            return (Criteria) this;
        }

        public Criteria andUserSaltGreaterThanOrEqualTo(String value) {
            addCriterion("user_salt >=", value, "userSalt");
            return (Criteria) this;
        }

        public Criteria andUserSaltLessThan(String value) {
            addCriterion("user_salt <", value, "userSalt");
            return (Criteria) this;
        }

        public Criteria andUserSaltLessThanOrEqualTo(String value) {
            addCriterion("user_salt <=", value, "userSalt");
            return (Criteria) this;
        }

        public Criteria andUserSaltLike(String value) {
            addCriterion("user_salt like", value, "userSalt");
            return (Criteria) this;
        }

        public Criteria andUserSaltNotLike(String value) {
            addCriterion("user_salt not like", value, "userSalt");
            return (Criteria) this;
        }

        public Criteria andUserSaltIn(List<String> values) {
            addCriterion("user_salt in", values, "userSalt");
            return (Criteria) this;
        }

        public Criteria andUserSaltNotIn(List<String> values) {
            addCriterion("user_salt not in", values, "userSalt");
            return (Criteria) this;
        }

        public Criteria andUserSaltBetween(String value1, String value2) {
            addCriterion("user_salt between", value1, value2, "userSalt");
            return (Criteria) this;
        }

        public Criteria andUserSaltNotBetween(String value1, String value2) {
            addCriterion("user_salt not between", value1, value2, "userSalt");
            return (Criteria) this;
        }

        public Criteria andUserHeadurlIsNull() {
            addCriterion("user_headUrl is null");
            return (Criteria) this;
        }

        public Criteria andUserHeadurlIsNotNull() {
            addCriterion("user_headUrl is not null");
            return (Criteria) this;
        }

        public Criteria andUserHeadurlEqualTo(String value) {
            addCriterion("user_headUrl =", value, "userHeadurl");
            return (Criteria) this;
        }

        public Criteria andUserHeadurlNotEqualTo(String value) {
            addCriterion("user_headUrl <>", value, "userHeadurl");
            return (Criteria) this;
        }

        public Criteria andUserHeadurlGreaterThan(String value) {
            addCriterion("user_headUrl >", value, "userHeadurl");
            return (Criteria) this;
        }

        public Criteria andUserHeadurlGreaterThanOrEqualTo(String value) {
            addCriterion("user_headUrl >=", value, "userHeadurl");
            return (Criteria) this;
        }

        public Criteria andUserHeadurlLessThan(String value) {
            addCriterion("user_headUrl <", value, "userHeadurl");
            return (Criteria) this;
        }

        public Criteria andUserHeadurlLessThanOrEqualTo(String value) {
            addCriterion("user_headUrl <=", value, "userHeadurl");
            return (Criteria) this;
        }

        public Criteria andUserHeadurlLike(String value) {
            addCriterion("user_headUrl like", value, "userHeadurl");
            return (Criteria) this;
        }

        public Criteria andUserHeadurlNotLike(String value) {
            addCriterion("user_headUrl not like", value, "userHeadurl");
            return (Criteria) this;
        }

        public Criteria andUserHeadurlIn(List<String> values) {
            addCriterion("user_headUrl in", values, "userHeadurl");
            return (Criteria) this;
        }

        public Criteria andUserHeadurlNotIn(List<String> values) {
            addCriterion("user_headUrl not in", values, "userHeadurl");
            return (Criteria) this;
        }

        public Criteria andUserHeadurlBetween(String value1, String value2) {
            addCriterion("user_headUrl between", value1, value2, "userHeadurl");
            return (Criteria) this;
        }

        public Criteria andUserHeadurlNotBetween(String value1, String value2) {
            addCriterion("user_headUrl not between", value1, value2, "userHeadurl");
            return (Criteria) this;
        }

        public Criteria andUserPositionIsNull() {
            addCriterion("user_position is null");
            return (Criteria) this;
        }

        public Criteria andUserPositionIsNotNull() {
            addCriterion("user_position is not null");
            return (Criteria) this;
        }

        public Criteria andUserPositionEqualTo(String value) {
            addCriterion("user_position =", value, "userPosition");
            return (Criteria) this;
        }

        public Criteria andUserPositionNotEqualTo(String value) {
            addCriterion("user_position <>", value, "userPosition");
            return (Criteria) this;
        }

        public Criteria andUserPositionGreaterThan(String value) {
            addCriterion("user_position >", value, "userPosition");
            return (Criteria) this;
        }

        public Criteria andUserPositionGreaterThanOrEqualTo(String value) {
            addCriterion("user_position >=", value, "userPosition");
            return (Criteria) this;
        }

        public Criteria andUserPositionLessThan(String value) {
            addCriterion("user_position <", value, "userPosition");
            return (Criteria) this;
        }

        public Criteria andUserPositionLessThanOrEqualTo(String value) {
            addCriterion("user_position <=", value, "userPosition");
            return (Criteria) this;
        }

        public Criteria andUserPositionLike(String value) {
            addCriterion("user_position like", value, "userPosition");
            return (Criteria) this;
        }

        public Criteria andUserPositionNotLike(String value) {
            addCriterion("user_position not like", value, "userPosition");
            return (Criteria) this;
        }

        public Criteria andUserPositionIn(List<String> values) {
            addCriterion("user_position in", values, "userPosition");
            return (Criteria) this;
        }

        public Criteria andUserPositionNotIn(List<String> values) {
            addCriterion("user_position not in", values, "userPosition");
            return (Criteria) this;
        }

        public Criteria andUserPositionBetween(String value1, String value2) {
            addCriterion("user_position between", value1, value2, "userPosition");
            return (Criteria) this;
        }

        public Criteria andUserPositionNotBetween(String value1, String value2) {
            addCriterion("user_position not between", value1, value2, "userPosition");
            return (Criteria) this;
        }

        public Criteria andUserWorkgroupIsNull() {
            addCriterion("user_workgroup is null");
            return (Criteria) this;
        }

        public Criteria andUserWorkgroupIsNotNull() {
            addCriterion("user_workgroup is not null");
            return (Criteria) this;
        }

        public Criteria andUserWorkgroupEqualTo(String value) {
            addCriterion("user_workgroup =", value, "userWorkgroup");
            return (Criteria) this;
        }

        public Criteria andUserWorkgroupNotEqualTo(String value) {
            addCriterion("user_workgroup <>", value, "userWorkgroup");
            return (Criteria) this;
        }

        public Criteria andUserWorkgroupGreaterThan(String value) {
            addCriterion("user_workgroup >", value, "userWorkgroup");
            return (Criteria) this;
        }

        public Criteria andUserWorkgroupGreaterThanOrEqualTo(String value) {
            addCriterion("user_workgroup >=", value, "userWorkgroup");
            return (Criteria) this;
        }

        public Criteria andUserWorkgroupLessThan(String value) {
            addCriterion("user_workgroup <", value, "userWorkgroup");
            return (Criteria) this;
        }

        public Criteria andUserWorkgroupLessThanOrEqualTo(String value) {
            addCriterion("user_workgroup <=", value, "userWorkgroup");
            return (Criteria) this;
        }

        public Criteria andUserWorkgroupLike(String value) {
            addCriterion("user_workgroup like", value, "userWorkgroup");
            return (Criteria) this;
        }

        public Criteria andUserWorkgroupNotLike(String value) {
            addCriterion("user_workgroup not like", value, "userWorkgroup");
            return (Criteria) this;
        }

        public Criteria andUserWorkgroupIn(List<String> values) {
            addCriterion("user_workgroup in", values, "userWorkgroup");
            return (Criteria) this;
        }

        public Criteria andUserWorkgroupNotIn(List<String> values) {
            addCriterion("user_workgroup not in", values, "userWorkgroup");
            return (Criteria) this;
        }

        public Criteria andUserWorkgroupBetween(String value1, String value2) {
            addCriterion("user_workgroup between", value1, value2, "userWorkgroup");
            return (Criteria) this;
        }

        public Criteria andUserWorkgroupNotBetween(String value1, String value2) {
            addCriterion("user_workgroup not between", value1, value2, "userWorkgroup");
            return (Criteria) this;
        }

        public Criteria andUserCreateddateIsNull() {
            addCriterion("user_createddate is null");
            return (Criteria) this;
        }

        public Criteria andUserCreateddateIsNotNull() {
            addCriterion("user_createddate is not null");
            return (Criteria) this;
        }

        public Criteria andUserCreateddateEqualTo(Date value) {
            addCriterion("user_createddate =", value, "userCreateddate");
            return (Criteria) this;
        }

        public Criteria andUserCreateddateNotEqualTo(Date value) {
            addCriterion("user_createddate <>", value, "userCreateddate");
            return (Criteria) this;
        }

        public Criteria andUserCreateddateGreaterThan(Date value) {
            addCriterion("user_createddate >", value, "userCreateddate");
            return (Criteria) this;
        }

        public Criteria andUserCreateddateGreaterThanOrEqualTo(Date value) {
            addCriterion("user_createddate >=", value, "userCreateddate");
            return (Criteria) this;
        }

        public Criteria andUserCreateddateLessThan(Date value) {
            addCriterion("user_createddate <", value, "userCreateddate");
            return (Criteria) this;
        }

        public Criteria andUserCreateddateLessThanOrEqualTo(Date value) {
            addCriterion("user_createddate <=", value, "userCreateddate");
            return (Criteria) this;
        }

        public Criteria andUserCreateddateIn(List<Date> values) {
            addCriterion("user_createddate in", values, "userCreateddate");
            return (Criteria) this;
        }

        public Criteria andUserCreateddateNotIn(List<Date> values) {
            addCriterion("user_createddate not in", values, "userCreateddate");
            return (Criteria) this;
        }

        public Criteria andUserCreateddateBetween(Date value1, Date value2) {
            addCriterion("user_createddate between", value1, value2, "userCreateddate");
            return (Criteria) this;
        }

        public Criteria andUserCreateddateNotBetween(Date value1, Date value2) {
            addCriterion("user_createddate not between", value1, value2, "userCreateddate");
            return (Criteria) this;
        }

        public Criteria andUserAgeIsNull() {
            addCriterion("user_age is null");
            return (Criteria) this;
        }

        public Criteria andUserAgeIsNotNull() {
            addCriterion("user_age is not null");
            return (Criteria) this;
        }

        public Criteria andUserAgeEqualTo(Integer value) {
            addCriterion("user_age =", value, "userAge");
            return (Criteria) this;
        }

        public Criteria andUserAgeNotEqualTo(Integer value) {
            addCriterion("user_age <>", value, "userAge");
            return (Criteria) this;
        }

        public Criteria andUserAgeGreaterThan(Integer value) {
            addCriterion("user_age >", value, "userAge");
            return (Criteria) this;
        }

        public Criteria andUserAgeGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_age >=", value, "userAge");
            return (Criteria) this;
        }

        public Criteria andUserAgeLessThan(Integer value) {
            addCriterion("user_age <", value, "userAge");
            return (Criteria) this;
        }

        public Criteria andUserAgeLessThanOrEqualTo(Integer value) {
            addCriterion("user_age <=", value, "userAge");
            return (Criteria) this;
        }

        public Criteria andUserAgeIn(List<Integer> values) {
            addCriterion("user_age in", values, "userAge");
            return (Criteria) this;
        }

        public Criteria andUserAgeNotIn(List<Integer> values) {
            addCriterion("user_age not in", values, "userAge");
            return (Criteria) this;
        }

        public Criteria andUserAgeBetween(Integer value1, Integer value2) {
            addCriterion("user_age between", value1, value2, "userAge");
            return (Criteria) this;
        }

        public Criteria andUserAgeNotBetween(Integer value1, Integer value2) {
            addCriterion("user_age not between", value1, value2, "userAge");
            return (Criteria) this;
        }

        public Criteria andUserEmailIsNull() {
            addCriterion("user_email is null");
            return (Criteria) this;
        }

        public Criteria andUserEmailIsNotNull() {
            addCriterion("user_email is not null");
            return (Criteria) this;
        }

        public Criteria andUserEmailEqualTo(String value) {
            addCriterion("user_email =", value, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailNotEqualTo(String value) {
            addCriterion("user_email <>", value, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailGreaterThan(String value) {
            addCriterion("user_email >", value, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailGreaterThanOrEqualTo(String value) {
            addCriterion("user_email >=", value, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailLessThan(String value) {
            addCriterion("user_email <", value, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailLessThanOrEqualTo(String value) {
            addCriterion("user_email <=", value, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailLike(String value) {
            addCriterion("user_email like", value, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailNotLike(String value) {
            addCriterion("user_email not like", value, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailIn(List<String> values) {
            addCriterion("user_email in", values, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailNotIn(List<String> values) {
            addCriterion("user_email not in", values, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailBetween(String value1, String value2) {
            addCriterion("user_email between", value1, value2, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailNotBetween(String value1, String value2) {
            addCriterion("user_email not between", value1, value2, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserPhoneIsNull() {
            addCriterion("user_phone is null");
            return (Criteria) this;
        }

        public Criteria andUserPhoneIsNotNull() {
            addCriterion("user_phone is not null");
            return (Criteria) this;
        }

        public Criteria andUserPhoneEqualTo(String value) {
            addCriterion("user_phone =", value, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneNotEqualTo(String value) {
            addCriterion("user_phone <>", value, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneGreaterThan(String value) {
            addCriterion("user_phone >", value, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("user_phone >=", value, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneLessThan(String value) {
            addCriterion("user_phone <", value, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneLessThanOrEqualTo(String value) {
            addCriterion("user_phone <=", value, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneLike(String value) {
            addCriterion("user_phone like", value, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneNotLike(String value) {
            addCriterion("user_phone not like", value, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneIn(List<String> values) {
            addCriterion("user_phone in", values, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneNotIn(List<String> values) {
            addCriterion("user_phone not in", values, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneBetween(String value1, String value2) {
            addCriterion("user_phone between", value1, value2, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneNotBetween(String value1, String value2) {
            addCriterion("user_phone not between", value1, value2, "userPhone");
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