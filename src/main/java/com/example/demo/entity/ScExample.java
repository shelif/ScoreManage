package com.example.demo.entity;

import java.util.ArrayList;
import java.util.List;

public class ScExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ScExample() {
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

        public Criteria andScCIdIsNull() {
            addCriterion("sc_c_id is null");
            return (Criteria) this;
        }

        public Criteria andScCIdIsNotNull() {
            addCriterion("sc_c_id is not null");
            return (Criteria) this;
        }

        public Criteria andScCIdEqualTo(String value) {
            addCriterion("sc_c_id =", value, "scCId");
            return (Criteria) this;
        }

        public Criteria andScCIdNotEqualTo(String value) {
            addCriterion("sc_c_id <>", value, "scCId");
            return (Criteria) this;
        }

        public Criteria andScCIdGreaterThan(String value) {
            addCriterion("sc_c_id >", value, "scCId");
            return (Criteria) this;
        }

        public Criteria andScCIdGreaterThanOrEqualTo(String value) {
            addCriterion("sc_c_id >=", value, "scCId");
            return (Criteria) this;
        }

        public Criteria andScCIdLessThan(String value) {
            addCriterion("sc_c_id <", value, "scCId");
            return (Criteria) this;
        }

        public Criteria andScCIdLessThanOrEqualTo(String value) {
            addCriterion("sc_c_id <=", value, "scCId");
            return (Criteria) this;
        }

        public Criteria andScCIdLike(String value) {
            addCriterion("sc_c_id like", value, "scCId");
            return (Criteria) this;
        }

        public Criteria andScCIdNotLike(String value) {
            addCriterion("sc_c_id not like", value, "scCId");
            return (Criteria) this;
        }

        public Criteria andScCIdIn(List<String> values) {
            addCriterion("sc_c_id in", values, "scCId");
            return (Criteria) this;
        }

        public Criteria andScCIdNotIn(List<String> values) {
            addCriterion("sc_c_id not in", values, "scCId");
            return (Criteria) this;
        }

        public Criteria andScCIdBetween(String value1, String value2) {
            addCriterion("sc_c_id between", value1, value2, "scCId");
            return (Criteria) this;
        }

        public Criteria andScCIdNotBetween(String value1, String value2) {
            addCriterion("sc_c_id not between", value1, value2, "scCId");
            return (Criteria) this;
        }

        public Criteria andScSIdIsNull() {
            addCriterion("sc_s_id is null");
            return (Criteria) this;
        }

        public Criteria andScSIdIsNotNull() {
            addCriterion("sc_s_id is not null");
            return (Criteria) this;
        }

        public Criteria andScSIdEqualTo(String value) {
            addCriterion("sc_s_id =", value, "scSId");
            return (Criteria) this;
        }

        public Criteria andScSIdNotEqualTo(String value) {
            addCriterion("sc_s_id <>", value, "scSId");
            return (Criteria) this;
        }

        public Criteria andScSIdGreaterThan(String value) {
            addCriterion("sc_s_id >", value, "scSId");
            return (Criteria) this;
        }

        public Criteria andScSIdGreaterThanOrEqualTo(String value) {
            addCriterion("sc_s_id >=", value, "scSId");
            return (Criteria) this;
        }

        public Criteria andScSIdLessThan(String value) {
            addCriterion("sc_s_id <", value, "scSId");
            return (Criteria) this;
        }

        public Criteria andScSIdLessThanOrEqualTo(String value) {
            addCriterion("sc_s_id <=", value, "scSId");
            return (Criteria) this;
        }

        public Criteria andScSIdLike(String value) {
            addCriterion("sc_s_id like", value, "scSId");
            return (Criteria) this;
        }

        public Criteria andScSIdNotLike(String value) {
            addCriterion("sc_s_id not like", value, "scSId");
            return (Criteria) this;
        }

        public Criteria andScSIdIn(List<String> values) {
            addCriterion("sc_s_id in", values, "scSId");
            return (Criteria) this;
        }

        public Criteria andScSIdNotIn(List<String> values) {
            addCriterion("sc_s_id not in", values, "scSId");
            return (Criteria) this;
        }

        public Criteria andScSIdBetween(String value1, String value2) {
            addCriterion("sc_s_id between", value1, value2, "scSId");
            return (Criteria) this;
        }

        public Criteria andScSIdNotBetween(String value1, String value2) {
            addCriterion("sc_s_id not between", value1, value2, "scSId");
            return (Criteria) this;
        }

        public Criteria andScGradeIsNull() {
            addCriterion("sc_grade is null");
            return (Criteria) this;
        }

        public Criteria andScGradeIsNotNull() {
            addCriterion("sc_grade is not null");
            return (Criteria) this;
        }

        public Criteria andScGradeEqualTo(Float value) {
            addCriterion("sc_grade =", value, "scGrade");
            return (Criteria) this;
        }

        public Criteria andScGradeNotEqualTo(Float value) {
            addCriterion("sc_grade <>", value, "scGrade");
            return (Criteria) this;
        }

        public Criteria andScGradeGreaterThan(Float value) {
            addCriterion("sc_grade >", value, "scGrade");
            return (Criteria) this;
        }

        public Criteria andScGradeGreaterThanOrEqualTo(Float value) {
            addCriterion("sc_grade >=", value, "scGrade");
            return (Criteria) this;
        }

        public Criteria andScGradeLessThan(Float value) {
            addCriterion("sc_grade <", value, "scGrade");
            return (Criteria) this;
        }

        public Criteria andScGradeLessThanOrEqualTo(Float value) {
            addCriterion("sc_grade <=", value, "scGrade");
            return (Criteria) this;
        }

        public Criteria andScGradeIn(List<Float> values) {
            addCriterion("sc_grade in", values, "scGrade");
            return (Criteria) this;
        }

        public Criteria andScGradeNotIn(List<Float> values) {
            addCriterion("sc_grade not in", values, "scGrade");
            return (Criteria) this;
        }

        public Criteria andScGradeBetween(Float value1, Float value2) {
            addCriterion("sc_grade between", value1, value2, "scGrade");
            return (Criteria) this;
        }

        public Criteria andScGradeNotBetween(Float value1, Float value2) {
            addCriterion("sc_grade not between", value1, value2, "scGrade");
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