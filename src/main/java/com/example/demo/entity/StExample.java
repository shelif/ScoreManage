package com.example.demo.entity;

import java.util.ArrayList;
import java.util.List;

public class StExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public StExample() {
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

        public Criteria andStSIdIsNull() {
            addCriterion("st_s_id is null");
            return (Criteria) this;
        }

        public Criteria andStSIdIsNotNull() {
            addCriterion("st_s_id is not null");
            return (Criteria) this;
        }

        public Criteria andStSIdEqualTo(String value) {
            addCriterion("st_s_id =", value, "stSId");
            return (Criteria) this;
        }

        public Criteria andStSIdNotEqualTo(String value) {
            addCriterion("st_s_id <>", value, "stSId");
            return (Criteria) this;
        }

        public Criteria andStSIdGreaterThan(String value) {
            addCriterion("st_s_id >", value, "stSId");
            return (Criteria) this;
        }

        public Criteria andStSIdGreaterThanOrEqualTo(String value) {
            addCriterion("st_s_id >=", value, "stSId");
            return (Criteria) this;
        }

        public Criteria andStSIdLessThan(String value) {
            addCriterion("st_s_id <", value, "stSId");
            return (Criteria) this;
        }

        public Criteria andStSIdLessThanOrEqualTo(String value) {
            addCriterion("st_s_id <=", value, "stSId");
            return (Criteria) this;
        }

        public Criteria andStSIdLike(String value) {
            addCriterion("st_s_id like", value, "stSId");
            return (Criteria) this;
        }

        public Criteria andStSIdNotLike(String value) {
            addCriterion("st_s_id not like", value, "stSId");
            return (Criteria) this;
        }

        public Criteria andStSIdIn(List<String> values) {
            addCriterion("st_s_id in", values, "stSId");
            return (Criteria) this;
        }

        public Criteria andStSIdNotIn(List<String> values) {
            addCriterion("st_s_id not in", values, "stSId");
            return (Criteria) this;
        }

        public Criteria andStSIdBetween(String value1, String value2) {
            addCriterion("st_s_id between", value1, value2, "stSId");
            return (Criteria) this;
        }

        public Criteria andStSIdNotBetween(String value1, String value2) {
            addCriterion("st_s_id not between", value1, value2, "stSId");
            return (Criteria) this;
        }

        public Criteria andStTcIdIsNull() {
            addCriterion("st_tc_id is null");
            return (Criteria) this;
        }

        public Criteria andStTcIdIsNotNull() {
            addCriterion("st_tc_id is not null");
            return (Criteria) this;
        }

        public Criteria andStTcIdEqualTo(String value) {
            addCriterion("st_tc_id =", value, "stTcId");
            return (Criteria) this;
        }

        public Criteria andStTcIdNotEqualTo(String value) {
            addCriterion("st_tc_id <>", value, "stTcId");
            return (Criteria) this;
        }

        public Criteria andStTcIdGreaterThan(String value) {
            addCriterion("st_tc_id >", value, "stTcId");
            return (Criteria) this;
        }

        public Criteria andStTcIdGreaterThanOrEqualTo(String value) {
            addCriterion("st_tc_id >=", value, "stTcId");
            return (Criteria) this;
        }

        public Criteria andStTcIdLessThan(String value) {
            addCriterion("st_tc_id <", value, "stTcId");
            return (Criteria) this;
        }

        public Criteria andStTcIdLessThanOrEqualTo(String value) {
            addCriterion("st_tc_id <=", value, "stTcId");
            return (Criteria) this;
        }

        public Criteria andStTcIdLike(String value) {
            addCriterion("st_tc_id like", value, "stTcId");
            return (Criteria) this;
        }

        public Criteria andStTcIdNotLike(String value) {
            addCriterion("st_tc_id not like", value, "stTcId");
            return (Criteria) this;
        }

        public Criteria andStTcIdIn(List<String> values) {
            addCriterion("st_tc_id in", values, "stTcId");
            return (Criteria) this;
        }

        public Criteria andStTcIdNotIn(List<String> values) {
            addCriterion("st_tc_id not in", values, "stTcId");
            return (Criteria) this;
        }

        public Criteria andStTcIdBetween(String value1, String value2) {
            addCriterion("st_tc_id between", value1, value2, "stTcId");
            return (Criteria) this;
        }

        public Criteria andStTcIdNotBetween(String value1, String value2) {
            addCriterion("st_tc_id not between", value1, value2, "stTcId");
            return (Criteria) this;
        }
    }

    /**
     */
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