package com.smertbox.security.privilege.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class SysPrivilegeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SysPrivilegeExample() {
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

        public Criteria andPvgPidIsNull() {
            addCriterion("pvg_pid is null");
            return (Criteria) this;
        }

        public Criteria andPvgPidIsNotNull() {
            addCriterion("pvg_pid is not null");
            return (Criteria) this;
        }

        public Criteria andPvgPidEqualTo(String value) {
            addCriterion("pvg_pid =", value, "pvgPid");
            return (Criteria) this;
        }

        public Criteria andPvgPidNotEqualTo(String value) {
            addCriterion("pvg_pid <>", value, "pvgPid");
            return (Criteria) this;
        }

        public Criteria andPvgPidGreaterThan(String value) {
            addCriterion("pvg_pid >", value, "pvgPid");
            return (Criteria) this;
        }

        public Criteria andPvgPidGreaterThanOrEqualTo(String value) {
            addCriterion("pvg_pid >=", value, "pvgPid");
            return (Criteria) this;
        }

        public Criteria andPvgPidLessThan(String value) {
            addCriterion("pvg_pid <", value, "pvgPid");
            return (Criteria) this;
        }

        public Criteria andPvgPidLessThanOrEqualTo(String value) {
            addCriterion("pvg_pid <=", value, "pvgPid");
            return (Criteria) this;
        }

        public Criteria andPvgPidLike(String value) {
            addCriterion("pvg_pid like", value, "pvgPid");
            return (Criteria) this;
        }

        public Criteria andPvgPidNotLike(String value) {
            addCriterion("pvg_pid not like", value, "pvgPid");
            return (Criteria) this;
        }

        public Criteria andPvgPidIn(List<String> values) {
            addCriterion("pvg_pid in", values, "pvgPid");
            return (Criteria) this;
        }

        public Criteria andPvgPidNotIn(List<String> values) {
            addCriterion("pvg_pid not in", values, "pvgPid");
            return (Criteria) this;
        }

        public Criteria andPvgPidBetween(String value1, String value2) {
            addCriterion("pvg_pid between", value1, value2, "pvgPid");
            return (Criteria) this;
        }

        public Criteria andPvgPidNotBetween(String value1, String value2) {
            addCriterion("pvg_pid not between", value1, value2, "pvgPid");
            return (Criteria) this;
        }

        public Criteria andPvgNameIsNull() {
            addCriterion("pvg_name is null");
            return (Criteria) this;
        }

        public Criteria andPvgNameIsNotNull() {
            addCriterion("pvg_name is not null");
            return (Criteria) this;
        }

        public Criteria andPvgNameEqualTo(String value) {
            addCriterion("pvg_name =", value, "pvgName");
            return (Criteria) this;
        }

        public Criteria andPvgNameNotEqualTo(String value) {
            addCriterion("pvg_name <>", value, "pvgName");
            return (Criteria) this;
        }

        public Criteria andPvgNameGreaterThan(String value) {
            addCriterion("pvg_name >", value, "pvgName");
            return (Criteria) this;
        }

        public Criteria andPvgNameGreaterThanOrEqualTo(String value) {
            addCriterion("pvg_name >=", value, "pvgName");
            return (Criteria) this;
        }

        public Criteria andPvgNameLessThan(String value) {
            addCriterion("pvg_name <", value, "pvgName");
            return (Criteria) this;
        }

        public Criteria andPvgNameLessThanOrEqualTo(String value) {
            addCriterion("pvg_name <=", value, "pvgName");
            return (Criteria) this;
        }

        public Criteria andPvgNameLike(String value) {
            addCriterion("pvg_name like", value, "pvgName");
            return (Criteria) this;
        }

        public Criteria andPvgNameNotLike(String value) {
            addCriterion("pvg_name not like", value, "pvgName");
            return (Criteria) this;
        }

        public Criteria andPvgNameIn(List<String> values) {
            addCriterion("pvg_name in", values, "pvgName");
            return (Criteria) this;
        }

        public Criteria andPvgNameNotIn(List<String> values) {
            addCriterion("pvg_name not in", values, "pvgName");
            return (Criteria) this;
        }

        public Criteria andPvgNameBetween(String value1, String value2) {
            addCriterion("pvg_name between", value1, value2, "pvgName");
            return (Criteria) this;
        }

        public Criteria andPvgNameNotBetween(String value1, String value2) {
            addCriterion("pvg_name not between", value1, value2, "pvgName");
            return (Criteria) this;
        }

        public Criteria andPvgTypeIsNull() {
            addCriterion("pvg_type is null");
            return (Criteria) this;
        }

        public Criteria andPvgTypeIsNotNull() {
            addCriterion("pvg_type is not null");
            return (Criteria) this;
        }

        public Criteria andPvgTypeEqualTo(String value) {
            addCriterion("pvg_type =", value, "pvgType");
            return (Criteria) this;
        }

        public Criteria andPvgTypeNotEqualTo(String value) {
            addCriterion("pvg_type <>", value, "pvgType");
            return (Criteria) this;
        }

        public Criteria andPvgTypeGreaterThan(String value) {
            addCriterion("pvg_type >", value, "pvgType");
            return (Criteria) this;
        }

        public Criteria andPvgTypeGreaterThanOrEqualTo(String value) {
            addCriterion("pvg_type >=", value, "pvgType");
            return (Criteria) this;
        }

        public Criteria andPvgTypeLessThan(String value) {
            addCriterion("pvg_type <", value, "pvgType");
            return (Criteria) this;
        }

        public Criteria andPvgTypeLessThanOrEqualTo(String value) {
            addCriterion("pvg_type <=", value, "pvgType");
            return (Criteria) this;
        }

        public Criteria andPvgTypeLike(String value) {
            addCriterion("pvg_type like", value, "pvgType");
            return (Criteria) this;
        }

        public Criteria andPvgTypeNotLike(String value) {
            addCriterion("pvg_type not like", value, "pvgType");
            return (Criteria) this;
        }

        public Criteria andPvgTypeIn(List<String> values) {
            addCriterion("pvg_type in", values, "pvgType");
            return (Criteria) this;
        }

        public Criteria andPvgTypeNotIn(List<String> values) {
            addCriterion("pvg_type not in", values, "pvgType");
            return (Criteria) this;
        }

        public Criteria andPvgTypeBetween(String value1, String value2) {
            addCriterion("pvg_type between", value1, value2, "pvgType");
            return (Criteria) this;
        }

        public Criteria andPvgTypeNotBetween(String value1, String value2) {
            addCriterion("pvg_type not between", value1, value2, "pvgType");
            return (Criteria) this;
        }

        public Criteria andPvgDescIsNull() {
            addCriterion("pvg_desc is null");
            return (Criteria) this;
        }

        public Criteria andPvgDescIsNotNull() {
            addCriterion("pvg_desc is not null");
            return (Criteria) this;
        }

        public Criteria andPvgDescEqualTo(String value) {
            addCriterion("pvg_desc =", value, "pvgDesc");
            return (Criteria) this;
        }

        public Criteria andPvgDescNotEqualTo(String value) {
            addCriterion("pvg_desc <>", value, "pvgDesc");
            return (Criteria) this;
        }

        public Criteria andPvgDescGreaterThan(String value) {
            addCriterion("pvg_desc >", value, "pvgDesc");
            return (Criteria) this;
        }

        public Criteria andPvgDescGreaterThanOrEqualTo(String value) {
            addCriterion("pvg_desc >=", value, "pvgDesc");
            return (Criteria) this;
        }

        public Criteria andPvgDescLessThan(String value) {
            addCriterion("pvg_desc <", value, "pvgDesc");
            return (Criteria) this;
        }

        public Criteria andPvgDescLessThanOrEqualTo(String value) {
            addCriterion("pvg_desc <=", value, "pvgDesc");
            return (Criteria) this;
        }

        public Criteria andPvgDescLike(String value) {
            addCriterion("pvg_desc like", value, "pvgDesc");
            return (Criteria) this;
        }

        public Criteria andPvgDescNotLike(String value) {
            addCriterion("pvg_desc not like", value, "pvgDesc");
            return (Criteria) this;
        }

        public Criteria andPvgDescIn(List<String> values) {
            addCriterion("pvg_desc in", values, "pvgDesc");
            return (Criteria) this;
        }

        public Criteria andPvgDescNotIn(List<String> values) {
            addCriterion("pvg_desc not in", values, "pvgDesc");
            return (Criteria) this;
        }

        public Criteria andPvgDescBetween(String value1, String value2) {
            addCriterion("pvg_desc between", value1, value2, "pvgDesc");
            return (Criteria) this;
        }

        public Criteria andPvgDescNotBetween(String value1, String value2) {
            addCriterion("pvg_desc not between", value1, value2, "pvgDesc");
            return (Criteria) this;
        }

        public Criteria andAllowEditIsNull() {
            addCriterion("allow_edit is null");
            return (Criteria) this;
        }

        public Criteria andAllowEditIsNotNull() {
            addCriterion("allow_edit is not null");
            return (Criteria) this;
        }

        public Criteria andAllowEditEqualTo(Short value) {
            addCriterion("allow_edit =", value, "allowEdit");
            return (Criteria) this;
        }

        public Criteria andAllowEditNotEqualTo(Short value) {
            addCriterion("allow_edit <>", value, "allowEdit");
            return (Criteria) this;
        }

        public Criteria andAllowEditGreaterThan(Short value) {
            addCriterion("allow_edit >", value, "allowEdit");
            return (Criteria) this;
        }

        public Criteria andAllowEditGreaterThanOrEqualTo(Short value) {
            addCriterion("allow_edit >=", value, "allowEdit");
            return (Criteria) this;
        }

        public Criteria andAllowEditLessThan(Short value) {
            addCriterion("allow_edit <", value, "allowEdit");
            return (Criteria) this;
        }

        public Criteria andAllowEditLessThanOrEqualTo(Short value) {
            addCriterion("allow_edit <=", value, "allowEdit");
            return (Criteria) this;
        }

        public Criteria andAllowEditIn(List<Short> values) {
            addCriterion("allow_edit in", values, "allowEdit");
            return (Criteria) this;
        }

        public Criteria andAllowEditNotIn(List<Short> values) {
            addCriterion("allow_edit not in", values, "allowEdit");
            return (Criteria) this;
        }

        public Criteria andAllowEditBetween(Short value1, Short value2) {
            addCriterion("allow_edit between", value1, value2, "allowEdit");
            return (Criteria) this;
        }

        public Criteria andAllowEditNotBetween(Short value1, Short value2) {
            addCriterion("allow_edit not between", value1, value2, "allowEdit");
            return (Criteria) this;
        }

        public Criteria andAllowDelIsNull() {
            addCriterion("allow_del is null");
            return (Criteria) this;
        }

        public Criteria andAllowDelIsNotNull() {
            addCriterion("allow_del is not null");
            return (Criteria) this;
        }

        public Criteria andAllowDelEqualTo(Short value) {
            addCriterion("allow_del =", value, "allowDel");
            return (Criteria) this;
        }

        public Criteria andAllowDelNotEqualTo(Short value) {
            addCriterion("allow_del <>", value, "allowDel");
            return (Criteria) this;
        }

        public Criteria andAllowDelGreaterThan(Short value) {
            addCriterion("allow_del >", value, "allowDel");
            return (Criteria) this;
        }

        public Criteria andAllowDelGreaterThanOrEqualTo(Short value) {
            addCriterion("allow_del >=", value, "allowDel");
            return (Criteria) this;
        }

        public Criteria andAllowDelLessThan(Short value) {
            addCriterion("allow_del <", value, "allowDel");
            return (Criteria) this;
        }

        public Criteria andAllowDelLessThanOrEqualTo(Short value) {
            addCriterion("allow_del <=", value, "allowDel");
            return (Criteria) this;
        }

        public Criteria andAllowDelIn(List<Short> values) {
            addCriterion("allow_del in", values, "allowDel");
            return (Criteria) this;
        }

        public Criteria andAllowDelNotIn(List<Short> values) {
            addCriterion("allow_del not in", values, "allowDel");
            return (Criteria) this;
        }

        public Criteria andAllowDelBetween(Short value1, Short value2) {
            addCriterion("allow_del between", value1, value2, "allowDel");
            return (Criteria) this;
        }

        public Criteria andAllowDelNotBetween(Short value1, Short value2) {
            addCriterion("allow_del not between", value1, value2, "allowDel");
            return (Criteria) this;
        }

        public Criteria andCtUserIdIsNull() {
            addCriterion("ct_user_id is null");
            return (Criteria) this;
        }

        public Criteria andCtUserIdIsNotNull() {
            addCriterion("ct_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andCtUserIdEqualTo(String value) {
            addCriterion("ct_user_id =", value, "ctUserId");
            return (Criteria) this;
        }

        public Criteria andCtUserIdNotEqualTo(String value) {
            addCriterion("ct_user_id <>", value, "ctUserId");
            return (Criteria) this;
        }

        public Criteria andCtUserIdGreaterThan(String value) {
            addCriterion("ct_user_id >", value, "ctUserId");
            return (Criteria) this;
        }

        public Criteria andCtUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("ct_user_id >=", value, "ctUserId");
            return (Criteria) this;
        }

        public Criteria andCtUserIdLessThan(String value) {
            addCriterion("ct_user_id <", value, "ctUserId");
            return (Criteria) this;
        }

        public Criteria andCtUserIdLessThanOrEqualTo(String value) {
            addCriterion("ct_user_id <=", value, "ctUserId");
            return (Criteria) this;
        }

        public Criteria andCtUserIdLike(String value) {
            addCriterion("ct_user_id like", value, "ctUserId");
            return (Criteria) this;
        }

        public Criteria andCtUserIdNotLike(String value) {
            addCriterion("ct_user_id not like", value, "ctUserId");
            return (Criteria) this;
        }

        public Criteria andCtUserIdIn(List<String> values) {
            addCriterion("ct_user_id in", values, "ctUserId");
            return (Criteria) this;
        }

        public Criteria andCtUserIdNotIn(List<String> values) {
            addCriterion("ct_user_id not in", values, "ctUserId");
            return (Criteria) this;
        }

        public Criteria andCtUserIdBetween(String value1, String value2) {
            addCriterion("ct_user_id between", value1, value2, "ctUserId");
            return (Criteria) this;
        }

        public Criteria andCtUserIdNotBetween(String value1, String value2) {
            addCriterion("ct_user_id not between", value1, value2, "ctUserId");
            return (Criteria) this;
        }

        public Criteria andCtTimeIsNull() {
            addCriterion("ct_time is null");
            return (Criteria) this;
        }

        public Criteria andCtTimeIsNotNull() {
            addCriterion("ct_time is not null");
            return (Criteria) this;
        }

        public Criteria andCtTimeEqualTo(Date value) {
            addCriterionForJDBCDate("ct_time =", value, "ctTime");
            return (Criteria) this;
        }

        public Criteria andCtTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("ct_time <>", value, "ctTime");
            return (Criteria) this;
        }

        public Criteria andCtTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("ct_time >", value, "ctTime");
            return (Criteria) this;
        }

        public Criteria andCtTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("ct_time >=", value, "ctTime");
            return (Criteria) this;
        }

        public Criteria andCtTimeLessThan(Date value) {
            addCriterionForJDBCDate("ct_time <", value, "ctTime");
            return (Criteria) this;
        }

        public Criteria andCtTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("ct_time <=", value, "ctTime");
            return (Criteria) this;
        }

        public Criteria andCtTimeIn(List<Date> values) {
            addCriterionForJDBCDate("ct_time in", values, "ctTime");
            return (Criteria) this;
        }

        public Criteria andCtTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("ct_time not in", values, "ctTime");
            return (Criteria) this;
        }

        public Criteria andCtTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("ct_time between", value1, value2, "ctTime");
            return (Criteria) this;
        }

        public Criteria andCtTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("ct_time not between", value1, value2, "ctTime");
            return (Criteria) this;
        }

        public Criteria andUpUserIdIsNull() {
            addCriterion("up_user_id is null");
            return (Criteria) this;
        }

        public Criteria andUpUserIdIsNotNull() {
            addCriterion("up_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUpUserIdEqualTo(String value) {
            addCriterion("up_user_id =", value, "upUserId");
            return (Criteria) this;
        }

        public Criteria andUpUserIdNotEqualTo(String value) {
            addCriterion("up_user_id <>", value, "upUserId");
            return (Criteria) this;
        }

        public Criteria andUpUserIdGreaterThan(String value) {
            addCriterion("up_user_id >", value, "upUserId");
            return (Criteria) this;
        }

        public Criteria andUpUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("up_user_id >=", value, "upUserId");
            return (Criteria) this;
        }

        public Criteria andUpUserIdLessThan(String value) {
            addCriterion("up_user_id <", value, "upUserId");
            return (Criteria) this;
        }

        public Criteria andUpUserIdLessThanOrEqualTo(String value) {
            addCriterion("up_user_id <=", value, "upUserId");
            return (Criteria) this;
        }

        public Criteria andUpUserIdLike(String value) {
            addCriterion("up_user_id like", value, "upUserId");
            return (Criteria) this;
        }

        public Criteria andUpUserIdNotLike(String value) {
            addCriterion("up_user_id not like", value, "upUserId");
            return (Criteria) this;
        }

        public Criteria andUpUserIdIn(List<String> values) {
            addCriterion("up_user_id in", values, "upUserId");
            return (Criteria) this;
        }

        public Criteria andUpUserIdNotIn(List<String> values) {
            addCriterion("up_user_id not in", values, "upUserId");
            return (Criteria) this;
        }

        public Criteria andUpUserIdBetween(String value1, String value2) {
            addCriterion("up_user_id between", value1, value2, "upUserId");
            return (Criteria) this;
        }

        public Criteria andUpUserIdNotBetween(String value1, String value2) {
            addCriterion("up_user_id not between", value1, value2, "upUserId");
            return (Criteria) this;
        }

        public Criteria andUpTimeIsNull() {
            addCriterion("up_time is null");
            return (Criteria) this;
        }

        public Criteria andUpTimeIsNotNull() {
            addCriterion("up_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpTimeEqualTo(Date value) {
            addCriterionForJDBCDate("up_time =", value, "upTime");
            return (Criteria) this;
        }

        public Criteria andUpTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("up_time <>", value, "upTime");
            return (Criteria) this;
        }

        public Criteria andUpTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("up_time >", value, "upTime");
            return (Criteria) this;
        }

        public Criteria andUpTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("up_time >=", value, "upTime");
            return (Criteria) this;
        }

        public Criteria andUpTimeLessThan(Date value) {
            addCriterionForJDBCDate("up_time <", value, "upTime");
            return (Criteria) this;
        }

        public Criteria andUpTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("up_time <=", value, "upTime");
            return (Criteria) this;
        }

        public Criteria andUpTimeIn(List<Date> values) {
            addCriterionForJDBCDate("up_time in", values, "upTime");
            return (Criteria) this;
        }

        public Criteria andUpTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("up_time not in", values, "upTime");
            return (Criteria) this;
        }

        public Criteria andUpTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("up_time between", value1, value2, "upTime");
            return (Criteria) this;
        }

        public Criteria andUpTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("up_time not between", value1, value2, "upTime");
            return (Criteria) this;
        }

        public Criteria andSortIsNull() {
            addCriterion("sort is null");
            return (Criteria) this;
        }

        public Criteria andSortIsNotNull() {
            addCriterion("sort is not null");
            return (Criteria) this;
        }

        public Criteria andSortEqualTo(String value) {
            addCriterion("sort =", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortNotEqualTo(String value) {
            addCriterion("sort <>", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortGreaterThan(String value) {
            addCriterion("sort >", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortGreaterThanOrEqualTo(String value) {
            addCriterion("sort >=", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortLessThan(String value) {
            addCriterion("sort <", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortLessThanOrEqualTo(String value) {
            addCriterion("sort <=", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortLike(String value) {
            addCriterion("sort like", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortNotLike(String value) {
            addCriterion("sort not like", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortIn(List<String> values) {
            addCriterion("sort in", values, "sort");
            return (Criteria) this;
        }

        public Criteria andSortNotIn(List<String> values) {
            addCriterion("sort not in", values, "sort");
            return (Criteria) this;
        }

        public Criteria andSortBetween(String value1, String value2) {
            addCriterion("sort between", value1, value2, "sort");
            return (Criteria) this;
        }

        public Criteria andSortNotBetween(String value1, String value2) {
            addCriterion("sort not between", value1, value2, "sort");
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

        public Criteria andDelIsNull() {
            addCriterion("del is null");
            return (Criteria) this;
        }

        public Criteria andDelIsNotNull() {
            addCriterion("del is not null");
            return (Criteria) this;
        }

        public Criteria andDelEqualTo(Short value) {
            addCriterion("del =", value, "del");
            return (Criteria) this;
        }

        public Criteria andDelNotEqualTo(Short value) {
            addCriterion("del <>", value, "del");
            return (Criteria) this;
        }

        public Criteria andDelGreaterThan(Short value) {
            addCriterion("del >", value, "del");
            return (Criteria) this;
        }

        public Criteria andDelGreaterThanOrEqualTo(Short value) {
            addCriterion("del >=", value, "del");
            return (Criteria) this;
        }

        public Criteria andDelLessThan(Short value) {
            addCriterion("del <", value, "del");
            return (Criteria) this;
        }

        public Criteria andDelLessThanOrEqualTo(Short value) {
            addCriterion("del <=", value, "del");
            return (Criteria) this;
        }

        public Criteria andDelIn(List<Short> values) {
            addCriterion("del in", values, "del");
            return (Criteria) this;
        }

        public Criteria andDelNotIn(List<Short> values) {
            addCriterion("del not in", values, "del");
            return (Criteria) this;
        }

        public Criteria andDelBetween(Short value1, Short value2) {
            addCriterion("del between", value1, value2, "del");
            return (Criteria) this;
        }

        public Criteria andDelNotBetween(Short value1, Short value2) {
            addCriterion("del not between", value1, value2, "del");
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