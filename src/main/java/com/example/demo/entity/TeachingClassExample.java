package com.example.demo.entity;

import java.util.ArrayList;
import java.util.List;

public class TeachingClassExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TeachingClassExample() {
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

        public Criteria andTcIdIsNull() {
            addCriterion("tc_id is null");
            return (Criteria) this;
        }

        public Criteria andTcIdIsNotNull() {
            addCriterion("tc_id is not null");
            return (Criteria) this;
        }

        public Criteria andTcIdEqualTo(String value) {
            addCriterion("tc_id =", value, "tcId");
            return (Criteria) this;
        }

        public Criteria andTcIdNotEqualTo(String value) {
            addCriterion("tc_id <>", value, "tcId");
            return (Criteria) this;
        }

        public Criteria andTcIdGreaterThan(String value) {
            addCriterion("tc_id >", value, "tcId");
            return (Criteria) this;
        }

        public Criteria andTcIdGreaterThanOrEqualTo(String value) {
            addCriterion("tc_id >=", value, "tcId");
            return (Criteria) this;
        }

        public Criteria andTcIdLessThan(String value) {
            addCriterion("tc_id <", value, "tcId");
            return (Criteria) this;
        }

        public Criteria andTcIdLessThanOrEqualTo(String value) {
            addCriterion("tc_id <=", value, "tcId");
            return (Criteria) this;
        }

        public Criteria andTcIdLike(String value) {
            addCriterion("tc_id like", value, "tcId");
            return (Criteria) this;
        }

        public Criteria andTcIdNotLike(String value) {
            addCriterion("tc_id not like", value, "tcId");
            return (Criteria) this;
        }

        public Criteria andTcIdIn(List<String> values) {
            addCriterion("tc_id in", values, "tcId");
            return (Criteria) this;
        }

        public Criteria andTcIdNotIn(List<String> values) {
            addCriterion("tc_id not in", values, "tcId");
            return (Criteria) this;
        }

        public Criteria andTcIdBetween(String value1, String value2) {
            addCriterion("tc_id between", value1, value2, "tcId");
            return (Criteria) this;
        }

        public Criteria andTcIdNotBetween(String value1, String value2) {
            addCriterion("tc_id not between", value1, value2, "tcId");
            return (Criteria) this;
        }

        public Criteria andTcCIdIsNull() {
            addCriterion("tc_c_id is null");
            return (Criteria) this;
        }

        public Criteria andTcCIdIsNotNull() {
            addCriterion("tc_c_id is not null");
            return (Criteria) this;
        }

        public Criteria andTcCIdEqualTo(String value) {
            addCriterion("tc_c_id =", value, "tcCId");
            return (Criteria) this;
        }

        public Criteria andTcCIdNotEqualTo(String value) {
            addCriterion("tc_c_id <>", value, "tcCId");
            return (Criteria) this;
        }

        public Criteria andTcCIdGreaterThan(String value) {
            addCriterion("tc_c_id >", value, "tcCId");
            return (Criteria) this;
        }

        public Criteria andTcCIdGreaterThanOrEqualTo(String value) {
            addCriterion("tc_c_id >=", value, "tcCId");
            return (Criteria) this;
        }

        public Criteria andTcCIdLessThan(String value) {
            addCriterion("tc_c_id <", value, "tcCId");
            return (Criteria) this;
        }

        public Criteria andTcCIdLessThanOrEqualTo(String value) {
            addCriterion("tc_c_id <=", value, "tcCId");
            return (Criteria) this;
        }

        public Criteria andTcCIdLike(String value) {
            addCriterion("tc_c_id like", value, "tcCId");
            return (Criteria) this;
        }

        public Criteria andTcCIdNotLike(String value) {
            addCriterion("tc_c_id not like", value, "tcCId");
            return (Criteria) this;
        }

        public Criteria andTcCIdIn(List<String> values) {
            addCriterion("tc_c_id in", values, "tcCId");
            return (Criteria) this;
        }

        public Criteria andTcCIdNotIn(List<String> values) {
            addCriterion("tc_c_id not in", values, "tcCId");
            return (Criteria) this;
        }

        public Criteria andTcCIdBetween(String value1, String value2) {
            addCriterion("tc_c_id between", value1, value2, "tcCId");
            return (Criteria) this;
        }

        public Criteria andTcCIdNotBetween(String value1, String value2) {
            addCriterion("tc_c_id not between", value1, value2, "tcCId");
            return (Criteria) this;
        }

        public Criteria andTcTIdIsNull() {
            addCriterion("tc_t_id is null");
            return (Criteria) this;
        }

        public Criteria andTcTIdIsNotNull() {
            addCriterion("tc_t_id is not null");
            return (Criteria) this;
        }

        public Criteria andTcTIdEqualTo(String value) {
            addCriterion("tc_t_id =", value, "tcTId");
            return (Criteria) this;
        }

        public Criteria andTcTIdNotEqualTo(String value) {
            addCriterion("tc_t_id <>", value, "tcTId");
            return (Criteria) this;
        }

        public Criteria andTcTIdGreaterThan(String value) {
            addCriterion("tc_t_id >", value, "tcTId");
            return (Criteria) this;
        }

        public Criteria andTcTIdGreaterThanOrEqualTo(String value) {
            addCriterion("tc_t_id >=", value, "tcTId");
            return (Criteria) this;
        }

        public Criteria andTcTIdLessThan(String value) {
            addCriterion("tc_t_id <", value, "tcTId");
            return (Criteria) this;
        }

        public Criteria andTcTIdLessThanOrEqualTo(String value) {
            addCriterion("tc_t_id <=", value, "tcTId");
            return (Criteria) this;
        }

        public Criteria andTcTIdLike(String value) {
            addCriterion("tc_t_id like", value, "tcTId");
            return (Criteria) this;
        }

        public Criteria andTcTIdNotLike(String value) {
            addCriterion("tc_t_id not like", value, "tcTId");
            return (Criteria) this;
        }

        public Criteria andTcTIdIn(List<String> values) {
            addCriterion("tc_t_id in", values, "tcTId");
            return (Criteria) this;
        }

        public Criteria andTcTIdNotIn(List<String> values) {
            addCriterion("tc_t_id not in", values, "tcTId");
            return (Criteria) this;
        }

        public Criteria andTcTIdBetween(String value1, String value2) {
            addCriterion("tc_t_id between", value1, value2, "tcTId");
            return (Criteria) this;
        }

        public Criteria andTcTIdNotBetween(String value1, String value2) {
            addCriterion("tc_t_id not between", value1, value2, "tcTId");
            return (Criteria) this;
        }

        public Criteria andTcCapacityIsNull() {
            addCriterion("tc_capacity is null");
            return (Criteria) this;
        }

        public Criteria andTcCapacityIsNotNull() {
            addCriterion("tc_capacity is not null");
            return (Criteria) this;
        }

        public Criteria andTcCapacityEqualTo(String value) {
            addCriterion("tc_capacity =", value, "tcCapacity");
            return (Criteria) this;
        }

        public Criteria andTcCapacityNotEqualTo(String value) {
            addCriterion("tc_capacity <>", value, "tcCapacity");
            return (Criteria) this;
        }

        public Criteria andTcCapacityGreaterThan(String value) {
            addCriterion("tc_capacity >", value, "tcCapacity");
            return (Criteria) this;
        }

        public Criteria andTcCapacityGreaterThanOrEqualTo(String value) {
            addCriterion("tc_capacity >=", value, "tcCapacity");
            return (Criteria) this;
        }

        public Criteria andTcCapacityLessThan(String value) {
            addCriterion("tc_capacity <", value, "tcCapacity");
            return (Criteria) this;
        }

        public Criteria andTcCapacityLessThanOrEqualTo(String value) {
            addCriterion("tc_capacity <=", value, "tcCapacity");
            return (Criteria) this;
        }

        public Criteria andTcCapacityLike(String value) {
            addCriterion("tc_capacity like", value, "tcCapacity");
            return (Criteria) this;
        }

        public Criteria andTcCapacityNotLike(String value) {
            addCriterion("tc_capacity not like", value, "tcCapacity");
            return (Criteria) this;
        }

        public Criteria andTcCapacityIn(List<String> values) {
            addCriterion("tc_capacity in", values, "tcCapacity");
            return (Criteria) this;
        }

        public Criteria andTcCapacityNotIn(List<String> values) {
            addCriterion("tc_capacity not in", values, "tcCapacity");
            return (Criteria) this;
        }

        public Criteria andTcCapacityBetween(String value1, String value2) {
            addCriterion("tc_capacity between", value1, value2, "tcCapacity");
            return (Criteria) this;
        }

        public Criteria andTcCapacityNotBetween(String value1, String value2) {
            addCriterion("tc_capacity not between", value1, value2, "tcCapacity");
            return (Criteria) this;
        }

        public Criteria andTcWeekTimeIsNull() {
            addCriterion("tc_week_time is null");
            return (Criteria) this;
        }

        public Criteria andTcWeekTimeIsNotNull() {
            addCriterion("tc_week_time is not null");
            return (Criteria) this;
        }

        public Criteria andTcWeekTimeEqualTo(String value) {
            addCriterion("tc_week_time =", value, "tcWeekTime");
            return (Criteria) this;
        }

        public Criteria andTcWeekTimeNotEqualTo(String value) {
            addCriterion("tc_week_time <>", value, "tcWeekTime");
            return (Criteria) this;
        }

        public Criteria andTcWeekTimeGreaterThan(String value) {
            addCriterion("tc_week_time >", value, "tcWeekTime");
            return (Criteria) this;
        }

        public Criteria andTcWeekTimeGreaterThanOrEqualTo(String value) {
            addCriterion("tc_week_time >=", value, "tcWeekTime");
            return (Criteria) this;
        }

        public Criteria andTcWeekTimeLessThan(String value) {
            addCriterion("tc_week_time <", value, "tcWeekTime");
            return (Criteria) this;
        }

        public Criteria andTcWeekTimeLessThanOrEqualTo(String value) {
            addCriterion("tc_week_time <=", value, "tcWeekTime");
            return (Criteria) this;
        }

        public Criteria andTcWeekTimeLike(String value) {
            addCriterion("tc_week_time like", value, "tcWeekTime");
            return (Criteria) this;
        }

        public Criteria andTcWeekTimeNotLike(String value) {
            addCriterion("tc_week_time not like", value, "tcWeekTime");
            return (Criteria) this;
        }

        public Criteria andTcWeekTimeIn(List<String> values) {
            addCriterion("tc_week_time in", values, "tcWeekTime");
            return (Criteria) this;
        }

        public Criteria andTcWeekTimeNotIn(List<String> values) {
            addCriterion("tc_week_time not in", values, "tcWeekTime");
            return (Criteria) this;
        }

        public Criteria andTcWeekTimeBetween(String value1, String value2) {
            addCriterion("tc_week_time between", value1, value2, "tcWeekTime");
            return (Criteria) this;
        }

        public Criteria andTcWeekTimeNotBetween(String value1, String value2) {
            addCriterion("tc_week_time not between", value1, value2, "tcWeekTime");
            return (Criteria) this;
        }

        public Criteria andTcLessonIsNull() {
            addCriterion("tc_lesson is null");
            return (Criteria) this;
        }

        public Criteria andTcLessonIsNotNull() {
            addCriterion("tc_lesson is not null");
            return (Criteria) this;
        }

        public Criteria andTcLessonEqualTo(String value) {
            addCriterion("tc_lesson =", value, "tcLesson");
            return (Criteria) this;
        }

        public Criteria andTcLessonNotEqualTo(String value) {
            addCriterion("tc_lesson <>", value, "tcLesson");
            return (Criteria) this;
        }

        public Criteria andTcLessonGreaterThan(String value) {
            addCriterion("tc_lesson >", value, "tcLesson");
            return (Criteria) this;
        }

        public Criteria andTcLessonGreaterThanOrEqualTo(String value) {
            addCriterion("tc_lesson >=", value, "tcLesson");
            return (Criteria) this;
        }

        public Criteria andTcLessonLessThan(String value) {
            addCriterion("tc_lesson <", value, "tcLesson");
            return (Criteria) this;
        }

        public Criteria andTcLessonLessThanOrEqualTo(String value) {
            addCriterion("tc_lesson <=", value, "tcLesson");
            return (Criteria) this;
        }

        public Criteria andTcLessonLike(String value) {
            addCriterion("tc_lesson like", value, "tcLesson");
            return (Criteria) this;
        }

        public Criteria andTcLessonNotLike(String value) {
            addCriterion("tc_lesson not like", value, "tcLesson");
            return (Criteria) this;
        }

        public Criteria andTcLessonIn(List<String> values) {
            addCriterion("tc_lesson in", values, "tcLesson");
            return (Criteria) this;
        }

        public Criteria andTcLessonNotIn(List<String> values) {
            addCriterion("tc_lesson not in", values, "tcLesson");
            return (Criteria) this;
        }

        public Criteria andTcLessonBetween(String value1, String value2) {
            addCriterion("tc_lesson between", value1, value2, "tcLesson");
            return (Criteria) this;
        }

        public Criteria andTcLessonNotBetween(String value1, String value2) {
            addCriterion("tc_lesson not between", value1, value2, "tcLesson");
            return (Criteria) this;
        }

        public Criteria andTcLocationIsNull() {
            addCriterion("tc_location is null");
            return (Criteria) this;
        }

        public Criteria andTcLocationIsNotNull() {
            addCriterion("tc_location is not null");
            return (Criteria) this;
        }

        public Criteria andTcLocationEqualTo(String value) {
            addCriterion("tc_location =", value, "tcLocation");
            return (Criteria) this;
        }

        public Criteria andTcLocationNotEqualTo(String value) {
            addCriterion("tc_location <>", value, "tcLocation");
            return (Criteria) this;
        }

        public Criteria andTcLocationGreaterThan(String value) {
            addCriterion("tc_location >", value, "tcLocation");
            return (Criteria) this;
        }

        public Criteria andTcLocationGreaterThanOrEqualTo(String value) {
            addCriterion("tc_location >=", value, "tcLocation");
            return (Criteria) this;
        }

        public Criteria andTcLocationLessThan(String value) {
            addCriterion("tc_location <", value, "tcLocation");
            return (Criteria) this;
        }

        public Criteria andTcLocationLessThanOrEqualTo(String value) {
            addCriterion("tc_location <=", value, "tcLocation");
            return (Criteria) this;
        }

        public Criteria andTcLocationLike(String value) {
            addCriterion("tc_location like", value, "tcLocation");
            return (Criteria) this;
        }

        public Criteria andTcLocationNotLike(String value) {
            addCriterion("tc_location not like", value, "tcLocation");
            return (Criteria) this;
        }

        public Criteria andTcLocationIn(List<String> values) {
            addCriterion("tc_location in", values, "tcLocation");
            return (Criteria) this;
        }

        public Criteria andTcLocationNotIn(List<String> values) {
            addCriterion("tc_location not in", values, "tcLocation");
            return (Criteria) this;
        }

        public Criteria andTcLocationBetween(String value1, String value2) {
            addCriterion("tc_location between", value1, value2, "tcLocation");
            return (Criteria) this;
        }

        public Criteria andTcLocationNotBetween(String value1, String value2) {
            addCriterion("tc_location not between", value1, value2, "tcLocation");
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