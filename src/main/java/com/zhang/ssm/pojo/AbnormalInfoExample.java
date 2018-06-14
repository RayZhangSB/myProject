package com.zhang.ssm.pojo;

import java.util.ArrayList;
import java.util.Date;
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

        public Criteria andAbnormalImgUrlIsNull() {
            addCriterion("abnormal_img_url is null");
            return (Criteria) this;
        }

        public Criteria andAbnormalImgUrlIsNotNull() {
            addCriterion("abnormal_img_url is not null");
            return (Criteria) this;
        }

        public Criteria andAbnormalImgUrlEqualTo(String value) {
            addCriterion("abnormal_img_url =", value, "abnormalImgUrl");
            return (Criteria) this;
        }

        public Criteria andAbnormalImgUrlNotEqualTo(String value) {
            addCriterion("abnormal_img_url <>", value, "abnormalImgUrl");
            return (Criteria) this;
        }

        public Criteria andAbnormalImgUrlGreaterThan(String value) {
            addCriterion("abnormal_img_url >", value, "abnormalImgUrl");
            return (Criteria) this;
        }

        public Criteria andAbnormalImgUrlGreaterThanOrEqualTo(String value) {
            addCriterion("abnormal_img_url >=", value, "abnormalImgUrl");
            return (Criteria) this;
        }

        public Criteria andAbnormalImgUrlLessThan(String value) {
            addCriterion("abnormal_img_url <", value, "abnormalImgUrl");
            return (Criteria) this;
        }

        public Criteria andAbnormalImgUrlLessThanOrEqualTo(String value) {
            addCriterion("abnormal_img_url <=", value, "abnormalImgUrl");
            return (Criteria) this;
        }

        public Criteria andAbnormalImgUrlLike(String value) {
            addCriterion("abnormal_img_url like", value, "abnormalImgUrl");
            return (Criteria) this;
        }

        public Criteria andAbnormalImgUrlNotLike(String value) {
            addCriterion("abnormal_img_url not like", value, "abnormalImgUrl");
            return (Criteria) this;
        }

        public Criteria andAbnormalImgUrlIn(List<String> values) {
            addCriterion("abnormal_img_url in", values, "abnormalImgUrl");
            return (Criteria) this;
        }

        public Criteria andAbnormalImgUrlNotIn(List<String> values) {
            addCriterion("abnormal_img_url not in", values, "abnormalImgUrl");
            return (Criteria) this;
        }

        public Criteria andAbnormalImgUrlBetween(String value1, String value2) {
            addCriterion("abnormal_img_url between", value1, value2, "abnormalImgUrl");
            return (Criteria) this;
        }

        public Criteria andAbnormalImgUrlNotBetween(String value1, String value2) {
            addCriterion("abnormal_img_url not between", value1, value2, "abnormalImgUrl");
            return (Criteria) this;
        }

        public Criteria andProcessedIsNull() {
            addCriterion("processed is null");
            return (Criteria) this;
        }

        public Criteria andProcessedIsNotNull() {
            addCriterion("processed is not null");
            return (Criteria) this;
        }

        public Criteria andProcessedEqualTo(Integer value) {
            addCriterion("processed =", value, "processed");
            return (Criteria) this;
        }

        public Criteria andProcessedNotEqualTo(Integer value) {
            addCriterion("processed <>", value, "processed");
            return (Criteria) this;
        }

        public Criteria andProcessedGreaterThan(Integer value) {
            addCriterion("processed >", value, "processed");
            return (Criteria) this;
        }

        public Criteria andProcessedGreaterThanOrEqualTo(Integer value) {
            addCriterion("processed >=", value, "processed");
            return (Criteria) this;
        }

        public Criteria andProcessedLessThan(Integer value) {
            addCriterion("processed <", value, "processed");
            return (Criteria) this;
        }

        public Criteria andProcessedLessThanOrEqualTo(Integer value) {
            addCriterion("processed <=", value, "processed");
            return (Criteria) this;
        }

        public Criteria andProcessedIn(List<Integer> values) {
            addCriterion("processed in", values, "processed");
            return (Criteria) this;
        }

        public Criteria andProcessedNotIn(List<Integer> values) {
            addCriterion("processed not in", values, "processed");
            return (Criteria) this;
        }

        public Criteria andProcessedBetween(Integer value1, Integer value2) {
            addCriterion("processed between", value1, value2, "processed");
            return (Criteria) this;
        }

        public Criteria andProcessedNotBetween(Integer value1, Integer value2) {
            addCriterion("processed not between", value1, value2, "processed");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
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