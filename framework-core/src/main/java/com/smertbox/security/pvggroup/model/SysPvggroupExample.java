package com.smertbox.security.pvggroup.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class SysPvggroupExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SysPvggroupExample() {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andPgIdIsNull() {
            addCriterion("pg_id is null");
            return (Criteria) this;
        }

        public Criteria andPgIdIsNotNull() {
            addCriterion("pg_id is not null");
            return (Criteria) this;
        }

        public Criteria andPgIdEqualTo(String value) {
            addCriterion("pg_id =", value, "pgId");
            return (Criteria) this;
        }

        public Criteria andPgIdNotEqualTo(String value) {
            addCriterion("pg_id <>", value, "pgId");
            return (Criteria) this;
        }

        public Criteria andPgIdGreaterThan(String value) {
            addCriterion("pg_id >", value, "pgId");
            return (Criteria) this;
        }

        public Criteria andPgIdGreaterThanOrEqualTo(String value) {
            addCriterion("pg_id >=", value, "pgId");
            return (Criteria) this;
        }

        public Criteria andPgIdLessThan(String value) {
            addCriterion("pg_id <", value, "pgId");
            return (Criteria) this;
        }

        public Criteria andPgIdLessThanOrEqualTo(String value) {
            addCriterion("pg_id <=", value, "pgId");
            return (Criteria) this;
        }

        public Criteria andPgIdLike(String value) {
            addCriterion("pg_id like", value, "pgId");
            return (Criteria) this;
        }

        public Criteria andPgIdNotLike(String value) {
            addCriterion("pg_id not like", value, "pgId");
            return (Criteria) this;
        }

        public Criteria andPgIdIn(List<String> values) {
            addCriterion("pg_id in", values, "pgId");
            return (Criteria) this;
        }

        public Criteria andPgIdNotIn(List<String> values) {
            addCriterion("pg_id not in", values, "pgId");
            return (Criteria) this;
        }

        public Criteria andPgIdBetween(String value1, String value2) {
            addCriterion("pg_id between", value1, value2, "pgId");
            return (Criteria) this;
        }

        public Criteria andPgIdNotBetween(String value1, String value2) {
            addCriterion("pg_id not between", value1, value2, "pgId");
            return (Criteria) this;
        }

        public Criteria andPgNameIsNull() {
            addCriterion("pg_name is null");
            return (Criteria) this;
        }

        public Criteria andPgNameIsNotNull() {
            addCriterion("pg_name is not null");
            return (Criteria) this;
        }

        public Criteria andPgNameEqualTo(String value) {
            addCriterion("pg_name =", value, "pgName");
            return (Criteria) this;
        }

        public Criteria andPgNameNotEqualTo(String value) {
            addCriterion("pg_name <>", value, "pgName");
            return (Criteria) this;
        }

        public Criteria andPgNameGreaterThan(String value) {
            addCriterion("pg_name >", value, "pgName");
            return (Criteria) this;
        }

        public Criteria andPgNameGreaterThanOrEqualTo(String value) {
            addCriterion("pg_name >=", value, "pgName");
            return (Criteria) this;
        }

        public Criteria andPgNameLessThan(String value) {
            addCriterion("pg_name <", value, "pgName");
            return (Criteria) this;
        }

        public Criteria andPgNameLessThanOrEqualTo(String value) {
            addCriterion("pg_name <=", value, "pgName");
            return (Criteria) this;
        }

        public Criteria andPgNameLike(String value) {
            addCriterion("pg_name like", value, "pgName");
            return (Criteria) this;
        }

        public Criteria andPgNameNotLike(String value) {
            addCriterion("pg_name not like", value, "pgName");
            return (Criteria) this;
        }

        public Criteria andPgNameIn(List<String> values) {
            addCriterion("pg_name in", values, "pgName");
            return (Criteria) this;
        }

        public Criteria andPgNameNotIn(List<String> values) {
            addCriterion("pg_name not in", values, "pgName");
            return (Criteria) this;
        }

        public Criteria andPgNameBetween(String value1, String value2) {
            addCriterion("pg_name between", value1, value2, "pgName");
            return (Criteria) this;
        }

        public Criteria andPgNameNotBetween(String value1, String value2) {
            addCriterion("pg_name not between", value1, value2, "pgName");
            return (Criteria) this;
        }

        public Criteria andPgDescIsNull() {
            addCriterion("pg_desc is null");
            return (Criteria) this;
        }

        public Criteria andPgDescIsNotNull() {
            addCriterion("pg_desc is not null");
            return (Criteria) this;
        }

        public Criteria andPgDescEqualTo(String value) {
            addCriterion("pg_desc =", value, "pgDesc");
            return (Criteria) this;
        }

        public Criteria andPgDescNotEqualTo(String value) {
            addCriterion("pg_desc <>", value, "pgDesc");
            return (Criteria) this;
        }

        public Criteria andPgDescGreaterThan(String value) {
            addCriterion("pg_desc >", value, "pgDesc");
            return (Criteria) this;
        }

        public Criteria andPgDescGreaterThanOrEqualTo(String value) {
            addCriterion("pg_desc >=", value, "pgDesc");
            return (Criteria) this;
        }

        public Criteria andPgDescLessThan(String value) {
            addCriterion("pg_desc <", value, "pgDesc");
            return (Criteria) this;
        }

        public Criteria andPgDescLessThanOrEqualTo(String value) {
            addCriterion("pg_desc <=", value, "pgDesc");
            return (Criteria) this;
        }

        public Criteria andPgDescLike(String value) {
            addCriterion("pg_desc like", value, "pgDesc");
            return (Criteria) this;
        }

        public Criteria andPgDescNotLike(String value) {
            addCriterion("pg_desc not like", value, "pgDesc");
            return (Criteria) this;
        }

        public Criteria andPgDescIn(List<String> values) {
            addCriterion("pg_desc in", values, "pgDesc");
            return (Criteria) this;
        }

        public Criteria andPgDescNotIn(List<String> values) {
            addCriterion("pg_desc not in", values, "pgDesc");
            return (Criteria) this;
        }

        public Criteria andPgDescBetween(String value1, String value2) {
            addCriterion("pg_desc between", value1, value2, "pgDesc");
            return (Criteria) this;
        }

        public Criteria andPgDescNotBetween(String value1, String value2) {
            addCriterion("pg_desc not between", value1, value2, "pgDesc");
            return (Criteria) this;
        }

        public Criteria andPvgIdIsNull() {
            addCriterion("pvg_id is null");
            return (Criteria) this;
        }

        public Criteria andPvgIdIsNotNull() {
            addCriterion("pvg_id is not null");
            return (Criteria) this;
        }

        public Criteria andPvgIdEqualTo(String value) {
            addCriterion("pvg_id =", value, "pvgId");
            return (Criteria) this;
        }

        public Criteria andPvgIdNotEqualTo(String value) {
            addCriterion("pvg_id <>", value, "pvgId");
            return (Criteria) this;
        }

        public Criteria andPvgIdGreaterThan(String value) {
            addCriterion("pvg_id >", value, "pvgId");
            return (Criteria) this;
        }

        public Criteria andPvgIdGreaterThanOrEqualTo(String value) {
            addCriterion("pvg_id >=", value, "pvgId");
            return (Criteria) this;
        }

        public Criteria andPvgIdLessThan(String value) {
            addCriterion("pvg_id <", value, "pvgId");
            return (Criteria) this;
        }

        public Criteria andPvgIdLessThanOrEqualTo(String value) {
            addCriterion("pvg_id <=", value, "pvgId");
            return (Criteria) this;
        }

        public Criteria andPvgIdLike(String value) {
            addCriterion("pvg_id like", value, "pvgId");
            return (Criteria) this;
        }

        public Criteria andPvgIdNotLike(String value) {
            addCriterion("pvg_id not like", value, "pvgId");
            return (Criteria) this;
        }

        public Criteria andPvgIdIn(List<String> values) {
            addCriterion("pvg_id in", values, "pvgId");
            return (Criteria) this;
        }

        public Criteria andPvgIdNotIn(List<String> values) {
            addCriterion("pvg_id not in", values, "pvgId");
            return (Criteria) this;
        }

        public Criteria andPvgIdBetween(String value1, String value2) {
            addCriterion("pvg_id between", value1, value2, "pvgId");
            return (Criteria) this;
        }

        public Criteria andPvgIdNotBetween(String value1, String value2) {
            addCriterion("pvg_id not between", value1, value2, "pvgId");
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
            addCriterionForJDBCDate("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterionForJDBCDate("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterionForJDBCDate("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andNoteIsNull() {
            addCriterion("note is null");
            return (Criteria) this;
        }

        public Criteria andNoteIsNotNull() {
            addCriterion("note is not null");
            return (Criteria) this;
        }

        public Criteria andNoteEqualTo(String value) {
            addCriterion("note =", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteNotEqualTo(String value) {
            addCriterion("note <>", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteGreaterThan(String value) {
            addCriterion("note >", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteGreaterThanOrEqualTo(String value) {
            addCriterion("note >=", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteLessThan(String value) {
            addCriterion("note <", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteLessThanOrEqualTo(String value) {
            addCriterion("note <=", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteLike(String value) {
            addCriterion("note like", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteNotLike(String value) {
            addCriterion("note not like", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteIn(List<String> values) {
            addCriterion("note in", values, "note");
            return (Criteria) this;
        }

        public Criteria andNoteNotIn(List<String> values) {
            addCriterion("note not in", values, "note");
            return (Criteria) this;
        }

        public Criteria andNoteBetween(String value1, String value2) {
            addCriterion("note between", value1, value2, "note");
            return (Criteria) this;
        }

        public Criteria andNoteNotBetween(String value1, String value2) {
            addCriterion("note not between", value1, value2, "note");
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