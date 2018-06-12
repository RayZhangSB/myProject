package com.zhang.ssm.pojo;

import java.util.ArrayList;
import java.util.List;

public class LineInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public LineInfoExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andLineNameIsNull() {
            addCriterion("line_name is null");
            return (Criteria) this;
        }

        public Criteria andLineNameIsNotNull() {
            addCriterion("line_name is not null");
            return (Criteria) this;
        }

        public Criteria andLineNameEqualTo(String value) {
            addCriterion("line_name =", value, "lineName");
            return (Criteria) this;
        }

        public Criteria andLineNameNotEqualTo(String value) {
            addCriterion("line_name <>", value, "lineName");
            return (Criteria) this;
        }

        public Criteria andLineNameGreaterThan(String value) {
            addCriterion("line_name >", value, "lineName");
            return (Criteria) this;
        }

        public Criteria andLineNameGreaterThanOrEqualTo(String value) {
            addCriterion("line_name >=", value, "lineName");
            return (Criteria) this;
        }

        public Criteria andLineNameLessThan(String value) {
            addCriterion("line_name <", value, "lineName");
            return (Criteria) this;
        }

        public Criteria andLineNameLessThanOrEqualTo(String value) {
            addCriterion("line_name <=", value, "lineName");
            return (Criteria) this;
        }

        public Criteria andLineNameLike(String value) {
            addCriterion("line_name like", value, "lineName");
            return (Criteria) this;
        }

        public Criteria andLineNameNotLike(String value) {
            addCriterion("line_name not like", value, "lineName");
            return (Criteria) this;
        }

        public Criteria andLineNameIn(List<String> values) {
            addCriterion("line_name in", values, "lineName");
            return (Criteria) this;
        }

        public Criteria andLineNameNotIn(List<String> values) {
            addCriterion("line_name not in", values, "lineName");
            return (Criteria) this;
        }

        public Criteria andLineNameBetween(String value1, String value2) {
            addCriterion("line_name between", value1, value2, "lineName");
            return (Criteria) this;
        }

        public Criteria andLineNameNotBetween(String value1, String value2) {
            addCriterion("line_name not between", value1, value2, "lineName");
            return (Criteria) this;
        }

        public Criteria andStreamUrlIsNull() {
            addCriterion("stream_url is null");
            return (Criteria) this;
        }

        public Criteria andStreamUrlIsNotNull() {
            addCriterion("stream_url is not null");
            return (Criteria) this;
        }

        public Criteria andStreamUrlEqualTo(String value) {
            addCriterion("stream_url =", value, "streamUrl");
            return (Criteria) this;
        }

        public Criteria andStreamUrlNotEqualTo(String value) {
            addCriterion("stream_url <>", value, "streamUrl");
            return (Criteria) this;
        }

        public Criteria andStreamUrlGreaterThan(String value) {
            addCriterion("stream_url >", value, "streamUrl");
            return (Criteria) this;
        }

        public Criteria andStreamUrlGreaterThanOrEqualTo(String value) {
            addCriterion("stream_url >=", value, "streamUrl");
            return (Criteria) this;
        }

        public Criteria andStreamUrlLessThan(String value) {
            addCriterion("stream_url <", value, "streamUrl");
            return (Criteria) this;
        }

        public Criteria andStreamUrlLessThanOrEqualTo(String value) {
            addCriterion("stream_url <=", value, "streamUrl");
            return (Criteria) this;
        }

        public Criteria andStreamUrlLike(String value) {
            addCriterion("stream_url like", value, "streamUrl");
            return (Criteria) this;
        }

        public Criteria andStreamUrlNotLike(String value) {
            addCriterion("stream_url not like", value, "streamUrl");
            return (Criteria) this;
        }

        public Criteria andStreamUrlIn(List<String> values) {
            addCriterion("stream_url in", values, "streamUrl");
            return (Criteria) this;
        }

        public Criteria andStreamUrlNotIn(List<String> values) {
            addCriterion("stream_url not in", values, "streamUrl");
            return (Criteria) this;
        }

        public Criteria andStreamUrlBetween(String value1, String value2) {
            addCriterion("stream_url between", value1, value2, "streamUrl");
            return (Criteria) this;
        }

        public Criteria andStreamUrlNotBetween(String value1, String value2) {
            addCriterion("stream_url not between", value1, value2, "streamUrl");
            return (Criteria) this;
        }

        public Criteria andSrcUrlIsNull() {
            addCriterion("src_url is null");
            return (Criteria) this;
        }

        public Criteria andSrcUrlIsNotNull() {
            addCriterion("src_url is not null");
            return (Criteria) this;
        }

        public Criteria andSrcUrlEqualTo(String value) {
            addCriterion("src_url =", value, "srcUrl");
            return (Criteria) this;
        }

        public Criteria andSrcUrlNotEqualTo(String value) {
            addCriterion("src_url <>", value, "srcUrl");
            return (Criteria) this;
        }

        public Criteria andSrcUrlGreaterThan(String value) {
            addCriterion("src_url >", value, "srcUrl");
            return (Criteria) this;
        }

        public Criteria andSrcUrlGreaterThanOrEqualTo(String value) {
            addCriterion("src_url >=", value, "srcUrl");
            return (Criteria) this;
        }

        public Criteria andSrcUrlLessThan(String value) {
            addCriterion("src_url <", value, "srcUrl");
            return (Criteria) this;
        }

        public Criteria andSrcUrlLessThanOrEqualTo(String value) {
            addCriterion("src_url <=", value, "srcUrl");
            return (Criteria) this;
        }

        public Criteria andSrcUrlLike(String value) {
            addCriterion("src_url like", value, "srcUrl");
            return (Criteria) this;
        }

        public Criteria andSrcUrlNotLike(String value) {
            addCriterion("src_url not like", value, "srcUrl");
            return (Criteria) this;
        }

        public Criteria andSrcUrlIn(List<String> values) {
            addCriterion("src_url in", values, "srcUrl");
            return (Criteria) this;
        }

        public Criteria andSrcUrlNotIn(List<String> values) {
            addCriterion("src_url not in", values, "srcUrl");
            return (Criteria) this;
        }

        public Criteria andSrcUrlBetween(String value1, String value2) {
            addCriterion("src_url between", value1, value2, "srcUrl");
            return (Criteria) this;
        }

        public Criteria andSrcUrlNotBetween(String value1, String value2) {
            addCriterion("src_url not between", value1, value2, "srcUrl");
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