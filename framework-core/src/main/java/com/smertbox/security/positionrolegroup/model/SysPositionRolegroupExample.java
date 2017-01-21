package com.smertbox.security.positionrolegroup.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SysPositionRolegroupExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SysPositionRolegroupExample() {
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

        public Criteria andPrIdIsNull() {
            addCriterion("pr_id is null");
            return (Criteria) this;
        }

        public Criteria andPrIdIsNotNull() {
            addCriterion("pr_id is not null");
            return (Criteria) this;
        }

        public Criteria andPrIdEqualTo(String value) {
            addCriterion("pr_id =", value, "prId");
            return (Criteria) this;
        }

        public Criteria andPrIdNotEqualTo(String value) {
            addCriterion("pr_id <>", value, "prId");
            return (Criteria) this;
        }

        public Criteria andPrIdGreaterThan(String value) {
            addCriterion("pr_id >", value, "prId");
            return (Criteria) this;
        }

        public Criteria andPrIdGreaterThanOrEqualTo(String value) {
            addCriterion("pr_id >=", value, "prId");
            return (Criteria) this;
        }

        public Criteria andPrIdLessThan(String value) {
            addCriterion("pr_id <", value, "prId");
            return (Criteria) this;
        }

        public Criteria andPrIdLessThanOrEqualTo(String value) {
            addCriterion("pr_id <=", value, "prId");
            return (Criteria) this;
        }

        public Criteria andPrIdLike(String value) {
            addCriterion("pr_id like", value, "prId");
            return (Criteria) this;
        }

        public Criteria andPrIdNotLike(String value) {
            addCriterion("pr_id not like", value, "prId");
            return (Criteria) this;
        }

        public Criteria andPrIdIn(List<String> values) {
            addCriterion("pr_id in", values, "prId");
            return (Criteria) this;
        }

        public Criteria andPrIdNotIn(List<String> values) {
            addCriterion("pr_id not in", values, "prId");
            return (Criteria) this;
        }

        public Criteria andPrIdBetween(String value1, String value2) {
            addCriterion("pr_id between", value1, value2, "prId");
            return (Criteria) this;
        }

        public Criteria andPrIdNotBetween(String value1, String value2) {
            addCriterion("pr_id not between", value1, value2, "prId");
            return (Criteria) this;
        }

        public Criteria andPositionIdIsNull() {
            addCriterion("position_id is null");
            return (Criteria) this;
        }

        public Criteria andPositionIdIsNotNull() {
            addCriterion("position_id is not null");
            return (Criteria) this;
        }

        public Criteria andPositionIdEqualTo(String value) {
            addCriterion("position_id =", value, "positionId");
            return (Criteria) this;
        }

        public Criteria andPositionIdNotEqualTo(String value) {
            addCriterion("position_id <>", value, "positionId");
            return (Criteria) this;
        }

        public Criteria andPositionIdGreaterThan(String value) {
            addCriterion("position_id >", value, "positionId");
            return (Criteria) this;
        }

        public Criteria andPositionIdGreaterThanOrEqualTo(String value) {
            addCriterion("position_id >=", value, "positionId");
            return (Criteria) this;
        }

        public Criteria andPositionIdLessThan(String value) {
            addCriterion("position_id <", value, "positionId");
            return (Criteria) this;
        }

        public Criteria andPositionIdLessThanOrEqualTo(String value) {
            addCriterion("position_id <=", value, "positionId");
            return (Criteria) this;
        }

        public Criteria andPositionIdLike(String value) {
            addCriterion("position_id like", value, "positionId");
            return (Criteria) this;
        }

        public Criteria andPositionIdNotLike(String value) {
            addCriterion("position_id not like", value, "positionId");
            return (Criteria) this;
        }

        public Criteria andPositionIdIn(List<String> values) {
            addCriterion("position_id in", values, "positionId");
            return (Criteria) this;
        }

        public Criteria andPositionIdNotIn(List<String> values) {
            addCriterion("position_id not in", values, "positionId");
            return (Criteria) this;
        }

        public Criteria andPositionIdBetween(String value1, String value2) {
            addCriterion("position_id between", value1, value2, "positionId");
            return (Criteria) this;
        }

        public Criteria andPositionIdNotBetween(String value1, String value2) {
            addCriterion("position_id not between", value1, value2, "positionId");
            return (Criteria) this;
        }

        public Criteria andRgIdIsNull() {
            addCriterion("rg_id is null");
            return (Criteria) this;
        }

        public Criteria andRgIdIsNotNull() {
            addCriterion("rg_id is not null");
            return (Criteria) this;
        }

        public Criteria andRgIdEqualTo(String value) {
            addCriterion("rg_id =", value, "rgId");
            return (Criteria) this;
        }

        public Criteria andRgIdNotEqualTo(String value) {
            addCriterion("rg_id <>", value, "rgId");
            return (Criteria) this;
        }

        public Criteria andRgIdGreaterThan(String value) {
            addCriterion("rg_id >", value, "rgId");
            return (Criteria) this;
        }

        public Criteria andRgIdGreaterThanOrEqualTo(String value) {
            addCriterion("rg_id >=", value, "rgId");
            return (Criteria) this;
        }

        public Criteria andRgIdLessThan(String value) {
            addCriterion("rg_id <", value, "rgId");
            return (Criteria) this;
        }

        public Criteria andRgIdLessThanOrEqualTo(String value) {
            addCriterion("rg_id <=", value, "rgId");
            return (Criteria) this;
        }

        public Criteria andRgIdLike(String value) {
            addCriterion("rg_id like", value, "rgId");
            return (Criteria) this;
        }

        public Criteria andRgIdNotLike(String value) {
            addCriterion("rg_id not like", value, "rgId");
            return (Criteria) this;
        }

        public Criteria andRgIdIn(List<String> values) {
            addCriterion("rg_id in", values, "rgId");
            return (Criteria) this;
        }

        public Criteria andRgIdNotIn(List<String> values) {
            addCriterion("rg_id not in", values, "rgId");
            return (Criteria) this;
        }

        public Criteria andRgIdBetween(String value1, String value2) {
            addCriterion("rg_id between", value1, value2, "rgId");
            return (Criteria) this;
        }

        public Criteria andRgIdNotBetween(String value1, String value2) {
            addCriterion("rg_id not between", value1, value2, "rgId");
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