package com.zhang.ssm.pojo;

import java.util.ArrayList;
import java.util.List;

public class AbnormalInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AbnormalInfoExample() {
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

        public Criteria andAbnormalInfoidIsNull() {
            addCriterion("abnormal_infoid is null");
            return (Criteria) this;
        }

        public Criteria andAbnormalInfoidIsNotNull() {
            addCriterion("abnormal_infoid is not null");
            return (Criteria) this;
        }

        public Criteria andAbnormalInfoidEqualTo(Integer value) {
            addCriterion("abnormal_infoid =", value, "abnormalInfoid");
            return (Criteria) this;
        }

        public Criteria andAbnormalInfoidNotEqualTo(Integer value) {
            addCriterion("abnormal_infoid <>", value, "abnormalInfoid");
            return (Criteria) this;
        }

        public Criteria andAbnormalInfoidGreaterThan(Integer value) {
            addCriterion("abnormal_infoid >", value, "abnormalInfoid");
            return (Criteria) this;
        }

        public Criteria andAbnormalInfoidGreaterThanOrEqualTo(Integer value) {
            addCriterion("abnormal_infoid >=", value, "abnormalInfoid");
            return (Criteria) this;
        }

        public Criteria andAbnormalInfoidLessThan(Integer value) {
            addCriterion("abnormal_infoid <", value, "abnormalInfoid");
            return (Criteria) this;
        }

        public Criteria andAbnormalInfoidLessThanOrEqualTo(Integer value) {
            addCriterion("abnormal_infoid <=", value, "abnormalInfoid");
            return (Criteria) this;
        }

        public Criteria andAbnormalInfoidIn(List<Integer> values) {
            addCriterion("abnormal_infoid in", values, "abnormalInfoid");
            return (Criteria) this;
        }

        public Criteria andAbnormalInfoidNotIn(List<Integer> values) {
            addCriterion("abnormal_infoid not in", values, "abnormalInfoid");
            return (Criteria) this;
        }

        public Criteria andAbnormalInfoidBetween(Integer value1, Integer value2) {
            addCriterion("abnormal_infoid between", value1, value2, "abnormalInfoid");
            return (Criteria) this;
        }

        public Criteria andAbnormalInfoidNotBetween(Integer value1, Integer value2) {
            addCriterion("abnormal_infoid not between", value1, value2, "abnormalInfoid");
            return (Criteria) this;
        }

        public Criteria andDevIdIsNull() {
            addCriterion("dev_id is null");
            return (Criteria) this;
        }

        public Criteria andDevIdIsNotNull() {
            addCriterion("dev_id is not null");
            return (Criteria) this;
        }

        public Criteria andDevIdEqualTo(Integer value) {
            addCriterion("dev_id =", value, "devId");
            return (Criteria) this;
        }

        public Criteria andDevIdNotEqualTo(Integer value) {
            addCriterion("dev_id <>", value, "devId");
            return (Criteria) this;
        }

        public Criteria andDevIdGreaterThan(Integer value) {
            addCriterion("dev_id >", value, "devId");
            return (Criteria) this;
        }

        public Criteria andDevIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("dev_id >=", value, "devId");
            return (Criteria) this;
        }

        public Criteria andDevIdLessThan(Integer value) {
            addCriterion("dev_id <", value, "devId");
            return (Criteria) this;
        }

        public Criteria andDevIdLessThanOrEqualTo(Integer value) {
            addCriterion("dev_id <=", value, "devId");
            return (Criteria) this;
        }

        public Criteria andDevIdIn(List<Integer> values) {
            addCriterion("dev_id in", values, "devId");
            return (Criteria) this;
        }

        public Criteria andDevIdNotIn(List<Integer> values) {
            addCriterion("dev_id not in", values, "devId");
            return (Criteria) this;
        }

        public Criteria andDevIdBetween(Integer value1, Integer value2) {
            addCriterion("dev_id between", value1, value2, "devId");
            return (Criteria) this;
        }

        public Criteria andDevIdNotBetween(Integer value1, Integer value2) {
            addCriterion("dev_id not between", value1, value2, "devId");
            return (Criteria) this;
        }

        public Criteria andAbnormalCodeIsNull() {
            addCriterion("abnormal_code is null");
            return (Criteria) this;
        }

        public Criteria andAbnormalCodeIsNotNull() {
            addCriterion("abnormal_code is not null");
            return (Criteria) this;
        }

        public Criteria andAbnormalCodeEqualTo(Integer value) {
            addCriterion("abnormal_code =", value, "abnormalCode");
            return (Criteria) this;
        }

        public Criteria andAbnormalCodeNotEqualTo(Integer value) {
            addCriterion("abnormal_code <>", value, "abnormalCode");
            return (Criteria) this;
        }

        public Criteria andAbnormalCodeGreaterThan(Integer value) {
            addCriterion("abnormal_code >", value, "abnormalCode");
            return (Criteria) this;
        }

        public Criteria andAbnormalCodeGreaterThanOrEqualTo(Integer value) {
            addCriterion("abnormal_code >=", value, "abnormalCode");
            return (Criteria) this;
        }

        public Criteria andAbnormalCodeLessThan(Integer value) {
            addCriterion("abnormal_code <", value, "abnormalCode");
            return (Criteria) this;
        }

        public Criteria andAbnormalCodeLessThanOrEqualTo(Integer value) {
            addCriterion("abnormal_code <=", value, "abnormalCode");
            return (Criteria) this;
        }

        public Criteria andAbnormalCodeIn(List<Integer> values) {
            addCriterion("abnormal_code in", values, "abnormalCode");
            return (Criteria) this;
        }

        public Criteria andAbnormalCodeNotIn(List<Integer> values) {
            addCriterion("abnormal_code not in", values, "abnormalCode");
            return (Criteria) this;
        }

        public Criteria andAbnormalCodeBetween(Integer value1, Integer value2) {
            addCriterion("abnormal_code between", value1, value2, "abnormalCode");
            return (Criteria) this;
        }

        public Criteria andAbnormalCodeNotBetween(Integer value1, Integer value2) {
            addCriterion("abnormal_code not between", value1, value2, "abnormalCode");
            return (Criteria) this;
        }

        public Criteria andAbnormalImgurlIsNull() {
            addCriterion("abnormal_imgurl is null");
            return (Criteria) this;
        }

        public Criteria andAbnormalImgurlIsNotNull() {
            addCriterion("abnormal_imgurl is not null");
            return (Criteria) this;
        }

        public Criteria andAbnormalImgurlEqualTo(String value) {
            addCriterion("abnormal_imgurl =", value, "abnormalImgurl");
            return (Criteria) this;
        }

        public Criteria andAbnormalImgurlNotEqualTo(String value) {
            addCriterion("abnormal_imgurl <>", value, "abnormalImgurl");
            return (Criteria) this;
        }

        public Criteria andAbnormalImgurlGreaterThan(String value) {
            addCriterion("abnormal_imgurl >", value, "abnormalImgurl");
            return (Criteria) this;
        }

        public Criteria andAbnormalImgurlGreaterThanOrEqualTo(String value) {
            addCriterion("abnormal_imgurl >=", value, "abnormalImgurl");
            return (Criteria) this;
        }

        public Criteria andAbnormalImgurlLessThan(String value) {
            addCriterion("abnormal_imgurl <", value, "abnormalImgurl");
            return (Criteria) this;
        }

        public Criteria andAbnormalImgurlLessThanOrEqualTo(String value) {
            addCriterion("abnormal_imgurl <=", value, "abnormalImgurl");
            return (Criteria) this;
        }

        public Criteria andAbnormalImgurlLike(String value) {
            addCriterion("abnormal_imgurl like", value, "abnormalImgurl");
            return (Criteria) this;
        }

        public Criteria andAbnormalImgurlNotLike(String value) {
            addCriterion("abnormal_imgurl not like", value, "abnormalImgurl");
            return (Criteria) this;
        }

        public Criteria andAbnormalImgurlIn(List<String> values) {
            addCriterion("abnormal_imgurl in", values, "abnormalImgurl");
            return (Criteria) this;
        }

        public Criteria andAbnormalImgurlNotIn(List<String> values) {
            addCriterion("abnormal_imgurl not in", values, "abnormalImgurl");
            return (Criteria) this;
        }

        public Criteria andAbnormalImgurlBetween(String value1, String value2) {
            addCriterion("abnormal_imgurl between", value1, value2, "abnormalImgurl");
            return (Criteria) this;
        }

        public Criteria andAbnormalImgurlNotBetween(String value1, String value2) {
            addCriterion("abnormal_imgurl not between", value1, value2, "abnormalImgurl");
            return (Criteria) this;
        }

        public Criteria andAbnormalDescIsNull() {
            addCriterion("abnormal_desc is null");
            return (Criteria) this;
        }

        public Criteria andAbnormalDescIsNotNull() {
            addCriterion("abnormal_desc is not null");
            return (Criteria) this;
        }

        public Criteria andAbnormalDescEqualTo(String value) {
            addCriterion("abnormal_desc =", value, "abnormalDesc");
            return (Criteria) this;
        }

        public Criteria andAbnormalDescNotEqualTo(String value) {
            addCriterion("abnormal_desc <>", value, "abnormalDesc");
            return (Criteria) this;
        }

        public Criteria andAbnormalDescGreaterThan(String value) {
            addCriterion("abnormal_desc >", value, "abnormalDesc");
            return (Criteria) this;
        }

        public Criteria andAbnormalDescGreaterThanOrEqualTo(String value) {
            addCriterion("abnormal_desc >=", value, "abnormalDesc");
            return (Criteria) this;
        }

        public Criteria andAbnormalDescLessThan(String value) {
            addCriterion("abnormal_desc <", value, "abnormalDesc");
            return (Criteria) this;
        }

        public Criteria andAbnormalDescLessThanOrEqualTo(String value) {
            addCriterion("abnormal_desc <=", value, "abnormalDesc");
            return (Criteria) this;
        }

        public Criteria andAbnormalDescLike(String value) {
            addCriterion("abnormal_desc like", value, "abnormalDesc");
            return (Criteria) this;
        }

        public Criteria andAbnormalDescNotLike(String value) {
            addCriterion("abnormal_desc not like", value, "abnormalDesc");
            return (Criteria) this;
        }

        public Criteria andAbnormalDescIn(List<String> values) {
            addCriterion("abnormal_desc in", values, "abnormalDesc");
            return (Criteria) this;
        }

        public Criteria andAbnormalDescNotIn(List<String> values) {
            addCriterion("abnormal_desc not in", values, "abnormalDesc");
            return (Criteria) this;
        }

        public Criteria andAbnormalDescBetween(String value1, String value2) {
            addCriterion("abnormal_desc between", value1, value2, "abnormalDesc");
            return (Criteria) this;
        }

        public Criteria andAbnormalDescNotBetween(String value1, String value2) {
            addCriterion("abnormal_desc not between", value1, value2, "abnormalDesc");
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