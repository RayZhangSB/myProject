package com.zhang.ssm.pojo;

import java.util.ArrayList;
import java.util.List;

public class ContentExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ContentExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
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

        public Criteria andUidIsNull() {
            addCriterion("uid is null");
            return (Criteria) this;
        }

        public Criteria andUidIsNotNull() {
            addCriterion("uid is not null");
            return (Criteria) this;
        }

        public Criteria andUidEqualTo(Long value) {
            addCriterion("uid =", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotEqualTo(Long value) {
            addCriterion("uid <>", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidGreaterThan(Long value) {
            addCriterion("uid >", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidGreaterThanOrEqualTo(Long value) {
            addCriterion("uid >=", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidLessThan(Long value) {
            addCriterion("uid <", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidLessThanOrEqualTo(Long value) {
            addCriterion("uid <=", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidIn(List<Long> values) {
            addCriterion("uid in", values, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotIn(List<Long> values) {
            addCriterion("uid not in", values, "uid");
            return (Criteria) this;
        }

        public Criteria andUidBetween(Long value1, Long value2) {
            addCriterion("uid between", value1, value2, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotBetween(Long value1, Long value2) {
            addCriterion("uid not between", value1, value2, "uid");
            return (Criteria) this;
        }

        public Criteria andCidIsNull() {
            addCriterion("cid is null");
            return (Criteria) this;
        }

        public Criteria andCidIsNotNull() {
            addCriterion("cid is not null");
            return (Criteria) this;
        }

        public Criteria andCidEqualTo(Byte value) {
            addCriterion("cid =", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidNotEqualTo(Byte value) {
            addCriterion("cid <>", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidGreaterThan(Byte value) {
            addCriterion("cid >", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidGreaterThanOrEqualTo(Byte value) {
            addCriterion("cid >=", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidLessThan(Byte value) {
            addCriterion("cid <", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidLessThanOrEqualTo(Byte value) {
            addCriterion("cid <=", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidIn(List<Byte> values) {
            addCriterion("cid in", values, "cid");
            return (Criteria) this;
        }

        public Criteria andCidNotIn(List<Byte> values) {
            addCriterion("cid not in", values, "cid");
            return (Criteria) this;
        }

        public Criteria andCidBetween(Byte value1, Byte value2) {
            addCriterion("cid between", value1, value2, "cid");
            return (Criteria) this;
        }

        public Criteria andCidNotBetween(Byte value1, Byte value2) {
            addCriterion("cid not between", value1, value2, "cid");
            return (Criteria) this;
        }

        public Criteria andTitleIsNull() {
            addCriterion("title is null");
            return (Criteria) this;
        }

        public Criteria andTitleIsNotNull() {
            addCriterion("title is not null");
            return (Criteria) this;
        }

        public Criteria andTitleEqualTo(String value) {
            addCriterion("title =", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotEqualTo(String value) {
            addCriterion("title <>", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThan(String value) {
            addCriterion("title >", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThanOrEqualTo(String value) {
            addCriterion("title >=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThan(String value) {
            addCriterion("title <", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThanOrEqualTo(String value) {
            addCriterion("title <=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLike(String value) {
            addCriterion("title like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotLike(String value) {
            addCriterion("title not like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleIn(List<String> values) {
            addCriterion("title in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotIn(List<String> values) {
            addCriterion("title not in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleBetween(String value1, String value2) {
            addCriterion("title between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotBetween(String value1, String value2) {
            addCriterion("title not between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andPic1IsNull() {
            addCriterion("pic1 is null");
            return (Criteria) this;
        }

        public Criteria andPic1IsNotNull() {
            addCriterion("pic1 is not null");
            return (Criteria) this;
        }

        public Criteria andPic1EqualTo(String value) {
            addCriterion("pic1 =", value, "pic1");
            return (Criteria) this;
        }

        public Criteria andPic1NotEqualTo(String value) {
            addCriterion("pic1 <>", value, "pic1");
            return (Criteria) this;
        }

        public Criteria andPic1GreaterThan(String value) {
            addCriterion("pic1 >", value, "pic1");
            return (Criteria) this;
        }

        public Criteria andPic1GreaterThanOrEqualTo(String value) {
            addCriterion("pic1 >=", value, "pic1");
            return (Criteria) this;
        }

        public Criteria andPic1LessThan(String value) {
            addCriterion("pic1 <", value, "pic1");
            return (Criteria) this;
        }

        public Criteria andPic1LessThanOrEqualTo(String value) {
            addCriterion("pic1 <=", value, "pic1");
            return (Criteria) this;
        }

        public Criteria andPic1Like(String value) {
            addCriterion("pic1 like", value, "pic1");
            return (Criteria) this;
        }

        public Criteria andPic1NotLike(String value) {
            addCriterion("pic1 not like", value, "pic1");
            return (Criteria) this;
        }

        public Criteria andPic1In(List<String> values) {
            addCriterion("pic1 in", values, "pic1");
            return (Criteria) this;
        }

        public Criteria andPic1NotIn(List<String> values) {
            addCriterion("pic1 not in", values, "pic1");
            return (Criteria) this;
        }

        public Criteria andPic1Between(String value1, String value2) {
            addCriterion("pic1 between", value1, value2, "pic1");
            return (Criteria) this;
        }

        public Criteria andPic1NotBetween(String value1, String value2) {
            addCriterion("pic1 not between", value1, value2, "pic1");
            return (Criteria) this;
        }

        public Criteria andPic2IsNull() {
            addCriterion("pic2 is null");
            return (Criteria) this;
        }

        public Criteria andPic2IsNotNull() {
            addCriterion("pic2 is not null");
            return (Criteria) this;
        }

        public Criteria andPic2EqualTo(String value) {
            addCriterion("pic2 =", value, "pic2");
            return (Criteria) this;
        }

        public Criteria andPic2NotEqualTo(String value) {
            addCriterion("pic2 <>", value, "pic2");
            return (Criteria) this;
        }

        public Criteria andPic2GreaterThan(String value) {
            addCriterion("pic2 >", value, "pic2");
            return (Criteria) this;
        }

        public Criteria andPic2GreaterThanOrEqualTo(String value) {
            addCriterion("pic2 >=", value, "pic2");
            return (Criteria) this;
        }

        public Criteria andPic2LessThan(String value) {
            addCriterion("pic2 <", value, "pic2");
            return (Criteria) this;
        }

        public Criteria andPic2LessThanOrEqualTo(String value) {
            addCriterion("pic2 <=", value, "pic2");
            return (Criteria) this;
        }

        public Criteria andPic2Like(String value) {
            addCriterion("pic2 like", value, "pic2");
            return (Criteria) this;
        }

        public Criteria andPic2NotLike(String value) {
            addCriterion("pic2 not like", value, "pic2");
            return (Criteria) this;
        }

        public Criteria andPic2In(List<String> values) {
            addCriterion("pic2 in", values, "pic2");
            return (Criteria) this;
        }

        public Criteria andPic2NotIn(List<String> values) {
            addCriterion("pic2 not in", values, "pic2");
            return (Criteria) this;
        }

        public Criteria andPic2Between(String value1, String value2) {
            addCriterion("pic2 between", value1, value2, "pic2");
            return (Criteria) this;
        }

        public Criteria andPic2NotBetween(String value1, String value2) {
            addCriterion("pic2 not between", value1, value2, "pic2");
            return (Criteria) this;
        }

        public Criteria andPic3IsNull() {
            addCriterion("pic3 is null");
            return (Criteria) this;
        }

        public Criteria andPic3IsNotNull() {
            addCriterion("pic3 is not null");
            return (Criteria) this;
        }

        public Criteria andPic3EqualTo(String value) {
            addCriterion("pic3 =", value, "pic3");
            return (Criteria) this;
        }

        public Criteria andPic3NotEqualTo(String value) {
            addCriterion("pic3 <>", value, "pic3");
            return (Criteria) this;
        }

        public Criteria andPic3GreaterThan(String value) {
            addCriterion("pic3 >", value, "pic3");
            return (Criteria) this;
        }

        public Criteria andPic3GreaterThanOrEqualTo(String value) {
            addCriterion("pic3 >=", value, "pic3");
            return (Criteria) this;
        }

        public Criteria andPic3LessThan(String value) {
            addCriterion("pic3 <", value, "pic3");
            return (Criteria) this;
        }

        public Criteria andPic3LessThanOrEqualTo(String value) {
            addCriterion("pic3 <=", value, "pic3");
            return (Criteria) this;
        }

        public Criteria andPic3Like(String value) {
            addCriterion("pic3 like", value, "pic3");
            return (Criteria) this;
        }

        public Criteria andPic3NotLike(String value) {
            addCriterion("pic3 not like", value, "pic3");
            return (Criteria) this;
        }

        public Criteria andPic3In(List<String> values) {
            addCriterion("pic3 in", values, "pic3");
            return (Criteria) this;
        }

        public Criteria andPic3NotIn(List<String> values) {
            addCriterion("pic3 not in", values, "pic3");
            return (Criteria) this;
        }

        public Criteria andPic3Between(String value1, String value2) {
            addCriterion("pic3 between", value1, value2, "pic3");
            return (Criteria) this;
        }

        public Criteria andPic3NotBetween(String value1, String value2) {
            addCriterion("pic3 not between", value1, value2, "pic3");
            return (Criteria) this;
        }

        public Criteria andPic4IsNull() {
            addCriterion("pic4 is null");
            return (Criteria) this;
        }

        public Criteria andPic4IsNotNull() {
            addCriterion("pic4 is not null");
            return (Criteria) this;
        }

        public Criteria andPic4EqualTo(String value) {
            addCriterion("pic4 =", value, "pic4");
            return (Criteria) this;
        }

        public Criteria andPic4NotEqualTo(String value) {
            addCriterion("pic4 <>", value, "pic4");
            return (Criteria) this;
        }

        public Criteria andPic4GreaterThan(String value) {
            addCriterion("pic4 >", value, "pic4");
            return (Criteria) this;
        }

        public Criteria andPic4GreaterThanOrEqualTo(String value) {
            addCriterion("pic4 >=", value, "pic4");
            return (Criteria) this;
        }

        public Criteria andPic4LessThan(String value) {
            addCriterion("pic4 <", value, "pic4");
            return (Criteria) this;
        }

        public Criteria andPic4LessThanOrEqualTo(String value) {
            addCriterion("pic4 <=", value, "pic4");
            return (Criteria) this;
        }

        public Criteria andPic4Like(String value) {
            addCriterion("pic4 like", value, "pic4");
            return (Criteria) this;
        }

        public Criteria andPic4NotLike(String value) {
            addCriterion("pic4 not like", value, "pic4");
            return (Criteria) this;
        }

        public Criteria andPic4In(List<String> values) {
            addCriterion("pic4 in", values, "pic4");
            return (Criteria) this;
        }

        public Criteria andPic4NotIn(List<String> values) {
            addCriterion("pic4 not in", values, "pic4");
            return (Criteria) this;
        }

        public Criteria andPic4Between(String value1, String value2) {
            addCriterion("pic4 between", value1, value2, "pic4");
            return (Criteria) this;
        }

        public Criteria andPic4NotBetween(String value1, String value2) {
            addCriterion("pic4 not between", value1, value2, "pic4");
            return (Criteria) this;
        }

        public Criteria andPic5IsNull() {
            addCriterion("pic5 is null");
            return (Criteria) this;
        }

        public Criteria andPic5IsNotNull() {
            addCriterion("pic5 is not null");
            return (Criteria) this;
        }

        public Criteria andPic5EqualTo(String value) {
            addCriterion("pic5 =", value, "pic5");
            return (Criteria) this;
        }

        public Criteria andPic5NotEqualTo(String value) {
            addCriterion("pic5 <>", value, "pic5");
            return (Criteria) this;
        }

        public Criteria andPic5GreaterThan(String value) {
            addCriterion("pic5 >", value, "pic5");
            return (Criteria) this;
        }

        public Criteria andPic5GreaterThanOrEqualTo(String value) {
            addCriterion("pic5 >=", value, "pic5");
            return (Criteria) this;
        }

        public Criteria andPic5LessThan(String value) {
            addCriterion("pic5 <", value, "pic5");
            return (Criteria) this;
        }

        public Criteria andPic5LessThanOrEqualTo(String value) {
            addCriterion("pic5 <=", value, "pic5");
            return (Criteria) this;
        }

        public Criteria andPic5Like(String value) {
            addCriterion("pic5 like", value, "pic5");
            return (Criteria) this;
        }

        public Criteria andPic5NotLike(String value) {
            addCriterion("pic5 not like", value, "pic5");
            return (Criteria) this;
        }

        public Criteria andPic5In(List<String> values) {
            addCriterion("pic5 in", values, "pic5");
            return (Criteria) this;
        }

        public Criteria andPic5NotIn(List<String> values) {
            addCriterion("pic5 not in", values, "pic5");
            return (Criteria) this;
        }

        public Criteria andPic5Between(String value1, String value2) {
            addCriterion("pic5 between", value1, value2, "pic5");
            return (Criteria) this;
        }

        public Criteria andPic5NotBetween(String value1, String value2) {
            addCriterion("pic5 not between", value1, value2, "pic5");
            return (Criteria) this;
        }

        public Criteria andPic6IsNull() {
            addCriterion("pic6 is null");
            return (Criteria) this;
        }

        public Criteria andPic6IsNotNull() {
            addCriterion("pic6 is not null");
            return (Criteria) this;
        }

        public Criteria andPic6EqualTo(String value) {
            addCriterion("pic6 =", value, "pic6");
            return (Criteria) this;
        }

        public Criteria andPic6NotEqualTo(String value) {
            addCriterion("pic6 <>", value, "pic6");
            return (Criteria) this;
        }

        public Criteria andPic6GreaterThan(String value) {
            addCriterion("pic6 >", value, "pic6");
            return (Criteria) this;
        }

        public Criteria andPic6GreaterThanOrEqualTo(String value) {
            addCriterion("pic6 >=", value, "pic6");
            return (Criteria) this;
        }

        public Criteria andPic6LessThan(String value) {
            addCriterion("pic6 <", value, "pic6");
            return (Criteria) this;
        }

        public Criteria andPic6LessThanOrEqualTo(String value) {
            addCriterion("pic6 <=", value, "pic6");
            return (Criteria) this;
        }

        public Criteria andPic6Like(String value) {
            addCriterion("pic6 like", value, "pic6");
            return (Criteria) this;
        }

        public Criteria andPic6NotLike(String value) {
            addCriterion("pic6 not like", value, "pic6");
            return (Criteria) this;
        }

        public Criteria andPic6In(List<String> values) {
            addCriterion("pic6 in", values, "pic6");
            return (Criteria) this;
        }

        public Criteria andPic6NotIn(List<String> values) {
            addCriterion("pic6 not in", values, "pic6");
            return (Criteria) this;
        }

        public Criteria andPic6Between(String value1, String value2) {
            addCriterion("pic6 between", value1, value2, "pic6");
            return (Criteria) this;
        }

        public Criteria andPic6NotBetween(String value1, String value2) {
            addCriterion("pic6 not between", value1, value2, "pic6");
            return (Criteria) this;
        }

        public Criteria andPic7IsNull() {
            addCriterion("pic7 is null");
            return (Criteria) this;
        }

        public Criteria andPic7IsNotNull() {
            addCriterion("pic7 is not null");
            return (Criteria) this;
        }

        public Criteria andPic7EqualTo(String value) {
            addCriterion("pic7 =", value, "pic7");
            return (Criteria) this;
        }

        public Criteria andPic7NotEqualTo(String value) {
            addCriterion("pic7 <>", value, "pic7");
            return (Criteria) this;
        }

        public Criteria andPic7GreaterThan(String value) {
            addCriterion("pic7 >", value, "pic7");
            return (Criteria) this;
        }

        public Criteria andPic7GreaterThanOrEqualTo(String value) {
            addCriterion("pic7 >=", value, "pic7");
            return (Criteria) this;
        }

        public Criteria andPic7LessThan(String value) {
            addCriterion("pic7 <", value, "pic7");
            return (Criteria) this;
        }

        public Criteria andPic7LessThanOrEqualTo(String value) {
            addCriterion("pic7 <=", value, "pic7");
            return (Criteria) this;
        }

        public Criteria andPic7Like(String value) {
            addCriterion("pic7 like", value, "pic7");
            return (Criteria) this;
        }

        public Criteria andPic7NotLike(String value) {
            addCriterion("pic7 not like", value, "pic7");
            return (Criteria) this;
        }

        public Criteria andPic7In(List<String> values) {
            addCriterion("pic7 in", values, "pic7");
            return (Criteria) this;
        }

        public Criteria andPic7NotIn(List<String> values) {
            addCriterion("pic7 not in", values, "pic7");
            return (Criteria) this;
        }

        public Criteria andPic7Between(String value1, String value2) {
            addCriterion("pic7 between", value1, value2, "pic7");
            return (Criteria) this;
        }

        public Criteria andPic7NotBetween(String value1, String value2) {
            addCriterion("pic7 not between", value1, value2, "pic7");
            return (Criteria) this;
        }

        public Criteria andPic8IsNull() {
            addCriterion("pic8 is null");
            return (Criteria) this;
        }

        public Criteria andPic8IsNotNull() {
            addCriterion("pic8 is not null");
            return (Criteria) this;
        }

        public Criteria andPic8EqualTo(String value) {
            addCriterion("pic8 =", value, "pic8");
            return (Criteria) this;
        }

        public Criteria andPic8NotEqualTo(String value) {
            addCriterion("pic8 <>", value, "pic8");
            return (Criteria) this;
        }

        public Criteria andPic8GreaterThan(String value) {
            addCriterion("pic8 >", value, "pic8");
            return (Criteria) this;
        }

        public Criteria andPic8GreaterThanOrEqualTo(String value) {
            addCriterion("pic8 >=", value, "pic8");
            return (Criteria) this;
        }

        public Criteria andPic8LessThan(String value) {
            addCriterion("pic8 <", value, "pic8");
            return (Criteria) this;
        }

        public Criteria andPic8LessThanOrEqualTo(String value) {
            addCriterion("pic8 <=", value, "pic8");
            return (Criteria) this;
        }

        public Criteria andPic8Like(String value) {
            addCriterion("pic8 like", value, "pic8");
            return (Criteria) this;
        }

        public Criteria andPic8NotLike(String value) {
            addCriterion("pic8 not like", value, "pic8");
            return (Criteria) this;
        }

        public Criteria andPic8In(List<String> values) {
            addCriterion("pic8 in", values, "pic8");
            return (Criteria) this;
        }

        public Criteria andPic8NotIn(List<String> values) {
            addCriterion("pic8 not in", values, "pic8");
            return (Criteria) this;
        }

        public Criteria andPic8Between(String value1, String value2) {
            addCriterion("pic8 between", value1, value2, "pic8");
            return (Criteria) this;
        }

        public Criteria andPic8NotBetween(String value1, String value2) {
            addCriterion("pic8 not between", value1, value2, "pic8");
            return (Criteria) this;
        }

        public Criteria andPic9IsNull() {
            addCriterion("pic9 is null");
            return (Criteria) this;
        }

        public Criteria andPic9IsNotNull() {
            addCriterion("pic9 is not null");
            return (Criteria) this;
        }

        public Criteria andPic9EqualTo(String value) {
            addCriterion("pic9 =", value, "pic9");
            return (Criteria) this;
        }

        public Criteria andPic9NotEqualTo(String value) {
            addCriterion("pic9 <>", value, "pic9");
            return (Criteria) this;
        }

        public Criteria andPic9GreaterThan(String value) {
            addCriterion("pic9 >", value, "pic9");
            return (Criteria) this;
        }

        public Criteria andPic9GreaterThanOrEqualTo(String value) {
            addCriterion("pic9 >=", value, "pic9");
            return (Criteria) this;
        }

        public Criteria andPic9LessThan(String value) {
            addCriterion("pic9 <", value, "pic9");
            return (Criteria) this;
        }

        public Criteria andPic9LessThanOrEqualTo(String value) {
            addCriterion("pic9 <=", value, "pic9");
            return (Criteria) this;
        }

        public Criteria andPic9Like(String value) {
            addCriterion("pic9 like", value, "pic9");
            return (Criteria) this;
        }

        public Criteria andPic9NotLike(String value) {
            addCriterion("pic9 not like", value, "pic9");
            return (Criteria) this;
        }

        public Criteria andPic9In(List<String> values) {
            addCriterion("pic9 in", values, "pic9");
            return (Criteria) this;
        }

        public Criteria andPic9NotIn(List<String> values) {
            addCriterion("pic9 not in", values, "pic9");
            return (Criteria) this;
        }

        public Criteria andPic9Between(String value1, String value2) {
            addCriterion("pic9 between", value1, value2, "pic9");
            return (Criteria) this;
        }

        public Criteria andPic9NotBetween(String value1, String value2) {
            addCriterion("pic9 not between", value1, value2, "pic9");
            return (Criteria) this;
        }

        public Criteria andSubtitleIsNull() {
            addCriterion("subtitle is null");
            return (Criteria) this;
        }

        public Criteria andSubtitleIsNotNull() {
            addCriterion("subtitle is not null");
            return (Criteria) this;
        }

        public Criteria andSubtitleEqualTo(String value) {
            addCriterion("subtitle =", value, "subtitle");
            return (Criteria) this;
        }

        public Criteria andSubtitleNotEqualTo(String value) {
            addCriterion("subtitle <>", value, "subtitle");
            return (Criteria) this;
        }

        public Criteria andSubtitleGreaterThan(String value) {
            addCriterion("subtitle >", value, "subtitle");
            return (Criteria) this;
        }

        public Criteria andSubtitleGreaterThanOrEqualTo(String value) {
            addCriterion("subtitle >=", value, "subtitle");
            return (Criteria) this;
        }

        public Criteria andSubtitleLessThan(String value) {
            addCriterion("subtitle <", value, "subtitle");
            return (Criteria) this;
        }

        public Criteria andSubtitleLessThanOrEqualTo(String value) {
            addCriterion("subtitle <=", value, "subtitle");
            return (Criteria) this;
        }

        public Criteria andSubtitleLike(String value) {
            addCriterion("subtitle like", value, "subtitle");
            return (Criteria) this;
        }

        public Criteria andSubtitleNotLike(String value) {
            addCriterion("subtitle not like", value, "subtitle");
            return (Criteria) this;
        }

        public Criteria andSubtitleIn(List<String> values) {
            addCriterion("subtitle in", values, "subtitle");
            return (Criteria) this;
        }

        public Criteria andSubtitleNotIn(List<String> values) {
            addCriterion("subtitle not in", values, "subtitle");
            return (Criteria) this;
        }

        public Criteria andSubtitleBetween(String value1, String value2) {
            addCriterion("subtitle between", value1, value2, "subtitle");
            return (Criteria) this;
        }

        public Criteria andSubtitleNotBetween(String value1, String value2) {
            addCriterion("subtitle not between", value1, value2, "subtitle");
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
    }
}