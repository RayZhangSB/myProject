package com.zhang.ssm.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LogExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public LogExample() {
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

        public Criteria andLogIdIsNull() {
            addCriterion("log_id is null");
            return (Criteria) this;
        }

        public Criteria andLogIdIsNotNull() {
            addCriterion("log_id is not null");
            return (Criteria) this;
        }

        public Criteria andLogIdEqualTo(Integer value) {
            addCriterion("log_id =", value, "logId");
            return (Criteria) this;
        }

        public Criteria andLogIdNotEqualTo(Integer value) {
            addCriterion("log_id <>", value, "logId");
            return (Criteria) this;
        }

        public Criteria andLogIdGreaterThan(Integer value) {
            addCriterion("log_id >", value, "logId");
            return (Criteria) this;
        }

        public Criteria andLogIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("log_id >=", value, "logId");
            return (Criteria) this;
        }

        public Criteria andLogIdLessThan(Integer value) {
            addCriterion("log_id <", value, "logId");
            return (Criteria) this;
        }

        public Criteria andLogIdLessThanOrEqualTo(Integer value) {
            addCriterion("log_id <=", value, "logId");
            return (Criteria) this;
        }

        public Criteria andLogIdIn(List<Integer> values) {
            addCriterion("log_id in", values, "logId");
            return (Criteria) this;
        }

        public Criteria andLogIdNotIn(List<Integer> values) {
            addCriterion("log_id not in", values, "logId");
            return (Criteria) this;
        }

        public Criteria andLogIdBetween(Integer value1, Integer value2) {
            addCriterion("log_id between", value1, value2, "logId");
            return (Criteria) this;
        }

        public Criteria andLogIdNotBetween(Integer value1, Integer value2) {
            addCriterion("log_id not between", value1, value2, "logId");
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

        public Criteria andLogExectypeIsNull() {
            addCriterion("log_exectype is null");
            return (Criteria) this;
        }

        public Criteria andLogExectypeIsNotNull() {
            addCriterion("log_exectype is not null");
            return (Criteria) this;
        }

        public Criteria andLogExectypeEqualTo(Integer value) {
            addCriterion("log_exectype =", value, "logExectype");
            return (Criteria) this;
        }

        public Criteria andLogExectypeNotEqualTo(Integer value) {
            addCriterion("log_exectype <>", value, "logExectype");
            return (Criteria) this;
        }

        public Criteria andLogExectypeGreaterThan(Integer value) {
            addCriterion("log_exectype >", value, "logExectype");
            return (Criteria) this;
        }

        public Criteria andLogExectypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("log_exectype >=", value, "logExectype");
            return (Criteria) this;
        }

        public Criteria andLogExectypeLessThan(Integer value) {
            addCriterion("log_exectype <", value, "logExectype");
            return (Criteria) this;
        }

        public Criteria andLogExectypeLessThanOrEqualTo(Integer value) {
            addCriterion("log_exectype <=", value, "logExectype");
            return (Criteria) this;
        }

        public Criteria andLogExectypeIn(List<Integer> values) {
            addCriterion("log_exectype in", values, "logExectype");
            return (Criteria) this;
        }

        public Criteria andLogExectypeNotIn(List<Integer> values) {
            addCriterion("log_exectype not in", values, "logExectype");
            return (Criteria) this;
        }

        public Criteria andLogExectypeBetween(Integer value1, Integer value2) {
            addCriterion("log_exectype between", value1, value2, "logExectype");
            return (Criteria) this;
        }

        public Criteria andLogExectypeNotBetween(Integer value1, Integer value2) {
            addCriterion("log_exectype not between", value1, value2, "logExectype");
            return (Criteria) this;
        }

        public Criteria andLogResultIsNull() {
            addCriterion("log__result is null");
            return (Criteria) this;
        }

        public Criteria andLogResultIsNotNull() {
            addCriterion("log__result is not null");
            return (Criteria) this;
        }

        public Criteria andLogResultEqualTo(String value) {
            addCriterion("log__result =", value, "logResult");
            return (Criteria) this;
        }

        public Criteria andLogResultNotEqualTo(String value) {
            addCriterion("log__result <>", value, "logResult");
            return (Criteria) this;
        }

        public Criteria andLogResultGreaterThan(String value) {
            addCriterion("log__result >", value, "logResult");
            return (Criteria) this;
        }

        public Criteria andLogResultGreaterThanOrEqualTo(String value) {
            addCriterion("log__result >=", value, "logResult");
            return (Criteria) this;
        }

        public Criteria andLogResultLessThan(String value) {
            addCriterion("log__result <", value, "logResult");
            return (Criteria) this;
        }

        public Criteria andLogResultLessThanOrEqualTo(String value) {
            addCriterion("log__result <=", value, "logResult");
            return (Criteria) this;
        }

        public Criteria andLogResultLike(String value) {
            addCriterion("log__result like", value, "logResult");
            return (Criteria) this;
        }

        public Criteria andLogResultNotLike(String value) {
            addCriterion("log__result not like", value, "logResult");
            return (Criteria) this;
        }

        public Criteria andLogResultIn(List<String> values) {
            addCriterion("log__result in", values, "logResult");
            return (Criteria) this;
        }

        public Criteria andLogResultNotIn(List<String> values) {
            addCriterion("log__result not in", values, "logResult");
            return (Criteria) this;
        }

        public Criteria andLogResultBetween(String value1, String value2) {
            addCriterion("log__result between", value1, value2, "logResult");
            return (Criteria) this;
        }

        public Criteria andLogResultNotBetween(String value1, String value2) {
            addCriterion("log__result not between", value1, value2, "logResult");
            return (Criteria) this;
        }

        public Criteria andLogDuringtimeIsNull() {
            addCriterion("log_duringtime is null");
            return (Criteria) this;
        }

        public Criteria andLogDuringtimeIsNotNull() {
            addCriterion("log_duringtime is not null");
            return (Criteria) this;
        }

        public Criteria andLogDuringtimeEqualTo(Date value) {
            addCriterion("log_duringtime =", value, "logDuringtime");
            return (Criteria) this;
        }

        public Criteria andLogDuringtimeNotEqualTo(Date value) {
            addCriterion("log_duringtime <>", value, "logDuringtime");
            return (Criteria) this;
        }

        public Criteria andLogDuringtimeGreaterThan(Date value) {
            addCriterion("log_duringtime >", value, "logDuringtime");
            return (Criteria) this;
        }

        public Criteria andLogDuringtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("log_duringtime >=", value, "logDuringtime");
            return (Criteria) this;
        }

        public Criteria andLogDuringtimeLessThan(Date value) {
            addCriterion("log_duringtime <", value, "logDuringtime");
            return (Criteria) this;
        }

        public Criteria andLogDuringtimeLessThanOrEqualTo(Date value) {
            addCriterion("log_duringtime <=", value, "logDuringtime");
            return (Criteria) this;
        }

        public Criteria andLogDuringtimeIn(List<Date> values) {
            addCriterion("log_duringtime in", values, "logDuringtime");
            return (Criteria) this;
        }

        public Criteria andLogDuringtimeNotIn(List<Date> values) {
            addCriterion("log_duringtime not in", values, "logDuringtime");
            return (Criteria) this;
        }

        public Criteria andLogDuringtimeBetween(Date value1, Date value2) {
            addCriterion("log_duringtime between", value1, value2, "logDuringtime");
            return (Criteria) this;
        }

        public Criteria andLogDuringtimeNotBetween(Date value1, Date value2) {
            addCriterion("log_duringtime not between", value1, value2, "logDuringtime");
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