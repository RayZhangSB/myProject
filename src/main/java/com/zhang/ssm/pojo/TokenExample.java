package com.zhang.ssm.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TokenExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TokenExample() {
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

        public Criteria andTokenIdIsNull() {
            addCriterion("token_id is null");
            return (Criteria) this;
        }

        public Criteria andTokenIdIsNotNull() {
            addCriterion("token_id is not null");
            return (Criteria) this;
        }

        public Criteria andTokenIdEqualTo(Integer value) {
            addCriterion("token_id =", value, "tokenId");
            return (Criteria) this;
        }

        public Criteria andTokenIdNotEqualTo(Integer value) {
            addCriterion("token_id <>", value, "tokenId");
            return (Criteria) this;
        }

        public Criteria andTokenIdGreaterThan(Integer value) {
            addCriterion("token_id >", value, "tokenId");
            return (Criteria) this;
        }

        public Criteria andTokenIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("token_id >=", value, "tokenId");
            return (Criteria) this;
        }

        public Criteria andTokenIdLessThan(Integer value) {
            addCriterion("token_id <", value, "tokenId");
            return (Criteria) this;
        }

        public Criteria andTokenIdLessThanOrEqualTo(Integer value) {
            addCriterion("token_id <=", value, "tokenId");
            return (Criteria) this;
        }

        public Criteria andTokenIdIn(List<Integer> values) {
            addCriterion("token_id in", values, "tokenId");
            return (Criteria) this;
        }

        public Criteria andTokenIdNotIn(List<Integer> values) {
            addCriterion("token_id not in", values, "tokenId");
            return (Criteria) this;
        }

        public Criteria andTokenIdBetween(Integer value1, Integer value2) {
            addCriterion("token_id between", value1, value2, "tokenId");
            return (Criteria) this;
        }

        public Criteria andTokenIdNotBetween(Integer value1, Integer value2) {
            addCriterion("token_id not between", value1, value2, "tokenId");
            return (Criteria) this;
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

        public Criteria andTokenExpiredIsNull() {
            addCriterion("token_expired is null");
            return (Criteria) this;
        }

        public Criteria andTokenExpiredIsNotNull() {
            addCriterion("token_expired is not null");
            return (Criteria) this;
        }

        public Criteria andTokenExpiredEqualTo(Date value) {
            addCriterion("token_expired =", value, "tokenExpired");
            return (Criteria) this;
        }

        public Criteria andTokenExpiredNotEqualTo(Date value) {
            addCriterion("token_expired <>", value, "tokenExpired");
            return (Criteria) this;
        }

        public Criteria andTokenExpiredGreaterThan(Date value) {
            addCriterion("token_expired >", value, "tokenExpired");
            return (Criteria) this;
        }

        public Criteria andTokenExpiredGreaterThanOrEqualTo(Date value) {
            addCriterion("token_expired >=", value, "tokenExpired");
            return (Criteria) this;
        }

        public Criteria andTokenExpiredLessThan(Date value) {
            addCriterion("token_expired <", value, "tokenExpired");
            return (Criteria) this;
        }

        public Criteria andTokenExpiredLessThanOrEqualTo(Date value) {
            addCriterion("token_expired <=", value, "tokenExpired");
            return (Criteria) this;
        }

        public Criteria andTokenExpiredIn(List<Date> values) {
            addCriterion("token_expired in", values, "tokenExpired");
            return (Criteria) this;
        }

        public Criteria andTokenExpiredNotIn(List<Date> values) {
            addCriterion("token_expired not in", values, "tokenExpired");
            return (Criteria) this;
        }

        public Criteria andTokenExpiredBetween(Date value1, Date value2) {
            addCriterion("token_expired between", value1, value2, "tokenExpired");
            return (Criteria) this;
        }

        public Criteria andTokenExpiredNotBetween(Date value1, Date value2) {
            addCriterion("token_expired not between", value1, value2, "tokenExpired");
            return (Criteria) this;
        }

        public Criteria andTokenStatusIsNull() {
            addCriterion("token_status is null");
            return (Criteria) this;
        }

        public Criteria andTokenStatusIsNotNull() {
            addCriterion("token_status is not null");
            return (Criteria) this;
        }

        public Criteria andTokenStatusEqualTo(Integer value) {
            addCriterion("token_status =", value, "tokenStatus");
            return (Criteria) this;
        }

        public Criteria andTokenStatusNotEqualTo(Integer value) {
            addCriterion("token_status <>", value, "tokenStatus");
            return (Criteria) this;
        }

        public Criteria andTokenStatusGreaterThan(Integer value) {
            addCriterion("token_status >", value, "tokenStatus");
            return (Criteria) this;
        }

        public Criteria andTokenStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("token_status >=", value, "tokenStatus");
            return (Criteria) this;
        }

        public Criteria andTokenStatusLessThan(Integer value) {
            addCriterion("token_status <", value, "tokenStatus");
            return (Criteria) this;
        }

        public Criteria andTokenStatusLessThanOrEqualTo(Integer value) {
            addCriterion("token_status <=", value, "tokenStatus");
            return (Criteria) this;
        }

        public Criteria andTokenStatusIn(List<Integer> values) {
            addCriterion("token_status in", values, "tokenStatus");
            return (Criteria) this;
        }

        public Criteria andTokenStatusNotIn(List<Integer> values) {
            addCriterion("token_status not in", values, "tokenStatus");
            return (Criteria) this;
        }

        public Criteria andTokenStatusBetween(Integer value1, Integer value2) {
            addCriterion("token_status between", value1, value2, "tokenStatus");
            return (Criteria) this;
        }

        public Criteria andTokenStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("token_status not between", value1, value2, "tokenStatus");
            return (Criteria) this;
        }

        public Criteria andTokenTicketIsNull() {
            addCriterion("token_ticket is null");
            return (Criteria) this;
        }

        public Criteria andTokenTicketIsNotNull() {
            addCriterion("token_ticket is not null");
            return (Criteria) this;
        }

        public Criteria andTokenTicketEqualTo(String value) {
            addCriterion("token_ticket =", value, "tokenTicket");
            return (Criteria) this;
        }

        public Criteria andTokenTicketNotEqualTo(String value) {
            addCriterion("token_ticket <>", value, "tokenTicket");
            return (Criteria) this;
        }

        public Criteria andTokenTicketGreaterThan(String value) {
            addCriterion("token_ticket >", value, "tokenTicket");
            return (Criteria) this;
        }

        public Criteria andTokenTicketGreaterThanOrEqualTo(String value) {
            addCriterion("token_ticket >=", value, "tokenTicket");
            return (Criteria) this;
        }

        public Criteria andTokenTicketLessThan(String value) {
            addCriterion("token_ticket <", value, "tokenTicket");
            return (Criteria) this;
        }

        public Criteria andTokenTicketLessThanOrEqualTo(String value) {
            addCriterion("token_ticket <=", value, "tokenTicket");
            return (Criteria) this;
        }

        public Criteria andTokenTicketLike(String value) {
            addCriterion("token_ticket like", value, "tokenTicket");
            return (Criteria) this;
        }

        public Criteria andTokenTicketNotLike(String value) {
            addCriterion("token_ticket not like", value, "tokenTicket");
            return (Criteria) this;
        }

        public Criteria andTokenTicketIn(List<String> values) {
            addCriterion("token_ticket in", values, "tokenTicket");
            return (Criteria) this;
        }

        public Criteria andTokenTicketNotIn(List<String> values) {
            addCriterion("token_ticket not in", values, "tokenTicket");
            return (Criteria) this;
        }

        public Criteria andTokenTicketBetween(String value1, String value2) {
            addCriterion("token_ticket between", value1, value2, "tokenTicket");
            return (Criteria) this;
        }

        public Criteria andTokenTicketNotBetween(String value1, String value2) {
            addCriterion("token_ticket not between", value1, value2, "tokenTicket");
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