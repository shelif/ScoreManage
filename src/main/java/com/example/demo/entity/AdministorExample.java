package com.example.demo.entity;

import java.util.ArrayList;
import java.util.List;

public class AdministorExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AdministorExample() {
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

        public Criteria andAIdIsNull() {
            addCriterion("a_id is null");
            return (Criteria) this;
        }

        public Criteria andAIdIsNotNull() {
            addCriterion("a_id is not null");
            return (Criteria) this;
        }

        public Criteria andAIdEqualTo(String value) {
            addCriterion("a_id =", value, "aId");
            return (Criteria) this;
        }

        public Criteria andAIdNotEqualTo(String value) {
            addCriterion("a_id <>", value, "aId");
            return (Criteria) this;
        }

        public Criteria andAIdGreaterThan(String value) {
            addCriterion("a_id >", value, "aId");
            return (Criteria) this;
        }

        public Criteria andAIdGreaterThanOrEqualTo(String value) {
            addCriterion("a_id >=", value, "aId");
            return (Criteria) this;
        }

        public Criteria andAIdLessThan(String value) {
            addCriterion("a_id <", value, "aId");
            return (Criteria) this;
        }

        public Criteria andAIdLessThanOrEqualTo(String value) {
            addCriterion("a_id <=", value, "aId");
            return (Criteria) this;
        }

        public Criteria andAIdLike(String value) {
            addCriterion("a_id like", value, "aId");
            return (Criteria) this;
        }

        public Criteria andAIdNotLike(String value) {
            addCriterion("a_id not like", value, "aId");
            return (Criteria) this;
        }

        public Criteria andAIdIn(List<String> values) {
            addCriterion("a_id in", values, "aId");
            return (Criteria) this;
        }

        public Criteria andAIdNotIn(List<String> values) {
            addCriterion("a_id not in", values, "aId");
            return (Criteria) this;
        }

        public Criteria andAIdBetween(String value1, String value2) {
            addCriterion("a_id between", value1, value2, "aId");
            return (Criteria) this;
        }

        public Criteria andAIdNotBetween(String value1, String value2) {
            addCriterion("a_id not between", value1, value2, "aId");
            return (Criteria) this;
        }

        public Criteria andAUsernameIsNull() {
            addCriterion("a_username is null");
            return (Criteria) this;
        }

        public Criteria andAUsernameIsNotNull() {
            addCriterion("a_username is not null");
            return (Criteria) this;
        }

        public Criteria andAUsernameEqualTo(String value) {
            addCriterion("a_username =", value, "aUsername");
            return (Criteria) this;
        }

        public Criteria andAUsernameNotEqualTo(String value) {
            addCriterion("a_username <>", value, "aUsername");
            return (Criteria) this;
        }

        public Criteria andAUsernameGreaterThan(String value) {
            addCriterion("a_username >", value, "aUsername");
            return (Criteria) this;
        }

        public Criteria andAUsernameGreaterThanOrEqualTo(String value) {
            addCriterion("a_username >=", value, "aUsername");
            return (Criteria) this;
        }

        public Criteria andAUsernameLessThan(String value) {
            addCriterion("a_username <", value, "aUsername");
            return (Criteria) this;
        }

        public Criteria andAUsernameLessThanOrEqualTo(String value) {
            addCriterion("a_username <=", value, "aUsername");
            return (Criteria) this;
        }

        public Criteria andAUsernameLike(String value) {
            addCriterion("a_username like", value, "aUsername");
            return (Criteria) this;
        }

        public Criteria andAUsernameNotLike(String value) {
            addCriterion("a_username not like", value, "aUsername");
            return (Criteria) this;
        }

        public Criteria andAUsernameIn(List<String> values) {
            addCriterion("a_username in", values, "aUsername");
            return (Criteria) this;
        }

        public Criteria andAUsernameNotIn(List<String> values) {
            addCriterion("a_username not in", values, "aUsername");
            return (Criteria) this;
        }

        public Criteria andAUsernameBetween(String value1, String value2) {
            addCriterion("a_username between", value1, value2, "aUsername");
            return (Criteria) this;
        }

        public Criteria andAUsernameNotBetween(String value1, String value2) {
            addCriterion("a_username not between", value1, value2, "aUsername");
            return (Criteria) this;
        }

        public Criteria andAPasswordIsNull() {
            addCriterion("a_password is null");
            return (Criteria) this;
        }

        public Criteria andAPasswordIsNotNull() {
            addCriterion("a_password is not null");
            return (Criteria) this;
        }

        public Criteria andAPasswordEqualTo(String value) {
            addCriterion("a_password =", value, "aPassword");
            return (Criteria) this;
        }

        public Criteria andAPasswordNotEqualTo(String value) {
            addCriterion("a_password <>", value, "aPassword");
            return (Criteria) this;
        }

        public Criteria andAPasswordGreaterThan(String value) {
            addCriterion("a_password >", value, "aPassword");
            return (Criteria) this;
        }

        public Criteria andAPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("a_password >=", value, "aPassword");
            return (Criteria) this;
        }

        public Criteria andAPasswordLessThan(String value) {
            addCriterion("a_password <", value, "aPassword");
            return (Criteria) this;
        }

        public Criteria andAPasswordLessThanOrEqualTo(String value) {
            addCriterion("a_password <=", value, "aPassword");
            return (Criteria) this;
        }

        public Criteria andAPasswordLike(String value) {
            addCriterion("a_password like", value, "aPassword");
            return (Criteria) this;
        }

        public Criteria andAPasswordNotLike(String value) {
            addCriterion("a_password not like", value, "aPassword");
            return (Criteria) this;
        }

        public Criteria andAPasswordIn(List<String> values) {
            addCriterion("a_password in", values, "aPassword");
            return (Criteria) this;
        }

        public Criteria andAPasswordNotIn(List<String> values) {
            addCriterion("a_password not in", values, "aPassword");
            return (Criteria) this;
        }

        public Criteria andAPasswordBetween(String value1, String value2) {
            addCriterion("a_password between", value1, value2, "aPassword");
            return (Criteria) this;
        }

        public Criteria andAPasswordNotBetween(String value1, String value2) {
            addCriterion("a_password not between", value1, value2, "aPassword");
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