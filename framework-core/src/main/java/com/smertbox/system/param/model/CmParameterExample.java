package com.smertbox.system.param.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CmParameterExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CmParameterExample() {
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

        public Criteria andParIdIsNull() {
            addCriterion("par_id is null");
            return (Criteria) this;
        }

        public Criteria andParIdIsNotNull() {
            addCriterion("par_id is not null");
            return (Criteria) this;
        }

        public Criteria andParIdEqualTo(String value) {
            addCriterion("par_id =", value, "parId");
            return (Criteria) this;
        }

        public Criteria andParIdNotEqualTo(String value) {
            addCriterion("par_id <>", value, "parId");
            return (Criteria) this;
        }

        public Criteria andParIdGreaterThan(String value) {
            addCriterion("par_id >", value, "parId");
            return (Criteria) this;
        }

        public Criteria andParIdGreaterThanOrEqualTo(String value) {
            addCriterion("par_id >=", value, "parId");
            return (Criteria) this;
        }

        public Criteria andParIdLessThan(String value) {
            addCriterion("par_id <", value, "parId");
            return (Criteria) this;
        }

        public Criteria andParIdLessThanOrEqualTo(String value) {
            addCriterion("par_id <=", value, "parId");
            return (Criteria) this;
        }

        public Criteria andParIdLike(String value) {
            addCriterion("par_id like", value, "parId");
            return (Criteria) this;
        }

        public Criteria andParIdNotLike(String value) {
            addCriterion("par_id not like", value, "parId");
            return (Criteria) this;
        }

        public Criteria andParIdIn(List<String> values) {
            addCriterion("par_id in", values, "parId");
            return (Criteria) this;
        }

        public Criteria andParIdNotIn(List<String> values) {
            addCriterion("par_id not in", values, "parId");
            return (Criteria) this;
        }

        public Criteria andParIdBetween(String value1, String value2) {
            addCriterion("par_id between", value1, value2, "parId");
            return (Criteria) this;
        }

        public Criteria andParIdNotBetween(String value1, String value2) {
            addCriterion("par_id not between", value1, value2, "parId");
            return (Criteria) this;
        }

        public Criteria andParPidIsNull() {
            addCriterion("par_pid is null");
            return (Criteria) this;
        }

        public Criteria andParPidIsNotNull() {
            addCriterion("par_pid is not null");
            return (Criteria) this;
        }

        public Criteria andParPidEqualTo(String value) {
            addCriterion("par_pid =", value, "parPid");
            return (Criteria) this;
        }

        public Criteria andParPidNotEqualTo(String value) {
            addCriterion("par_pid <>", value, "parPid");
            return (Criteria) this;
        }

        public Criteria andParPidGreaterThan(String value) {
            addCriterion("par_pid >", value, "parPid");
            return (Criteria) this;
        }

        public Criteria andParPidGreaterThanOrEqualTo(String value) {
            addCriterion("par_pid >=", value, "parPid");
            return (Criteria) this;
        }

        public Criteria andParPidLessThan(String value) {
            addCriterion("par_pid <", value, "parPid");
            return (Criteria) this;
        }

        public Criteria andParPidLessThanOrEqualTo(String value) {
            addCriterion("par_pid <=", value, "parPid");
            return (Criteria) this;
        }

        public Criteria andParPidLike(String value) {
            addCriterion("par_pid like", value, "parPid");
            return (Criteria) this;
        }

        public Criteria andParPidNotLike(String value) {
            addCriterion("par_pid not like", value, "parPid");
            return (Criteria) this;
        }

        public Criteria andParPidIn(List<String> values) {
            addCriterion("par_pid in", values, "parPid");
            return (Criteria) this;
        }

        public Criteria andParPidNotIn(List<String> values) {
            addCriterion("par_pid not in", values, "parPid");
            return (Criteria) this;
        }

        public Criteria andParPidBetween(String value1, String value2) {
            addCriterion("par_pid between", value1, value2, "parPid");
            return (Criteria) this;
        }

        public Criteria andParPidNotBetween(String value1, String value2) {
            addCriterion("par_pid not between", value1, value2, "parPid");
            return (Criteria) this;
        }

        public Criteria andParTypeIsNull() {
            addCriterion("par_type is null");
            return (Criteria) this;
        }

        public Criteria andParTypeIsNotNull() {
            addCriterion("par_type is not null");
            return (Criteria) this;
        }

        public Criteria andParTypeEqualTo(String value) {
            addCriterion("par_type =", value, "parType");
            return (Criteria) this;
        }

        public Criteria andParTypeNotEqualTo(String value) {
            addCriterion("par_type <>", value, "parType");
            return (Criteria) this;
        }

        public Criteria andParTypeGreaterThan(String value) {
            addCriterion("par_type >", value, "parType");
            return (Criteria) this;
        }

        public Criteria andParTypeGreaterThanOrEqualTo(String value) {
            addCriterion("par_type >=", value, "parType");
            return (Criteria) this;
        }

        public Criteria andParTypeLessThan(String value) {
            addCriterion("par_type <", value, "parType");
            return (Criteria) this;
        }

        public Criteria andParTypeLessThanOrEqualTo(String value) {
            addCriterion("par_type <=", value, "parType");
            return (Criteria) this;
        }

        public Criteria andParTypeLike(String value) {
            addCriterion("par_type like", value, "parType");
            return (Criteria) this;
        }

        public Criteria andParTypeNotLike(String value) {
            addCriterion("par_type not like", value, "parType");
            return (Criteria) this;
        }

        public Criteria andParTypeIn(List<String> values) {
            addCriterion("par_type in", values, "parType");
            return (Criteria) this;
        }

        public Criteria andParTypeNotIn(List<String> values) {
            addCriterion("par_type not in", values, "parType");
            return (Criteria) this;
        }

        public Criteria andParTypeBetween(String value1, String value2) {
            addCriterion("par_type between", value1, value2, "parType");
            return (Criteria) this;
        }

        public Criteria andParTypeNotBetween(String value1, String value2) {
            addCriterion("par_type not between", value1, value2, "parType");
            return (Criteria) this;
        }

        public Criteria andParLevelIsNull() {
            addCriterion("par_level is null");
            return (Criteria) this;
        }

        public Criteria andParLevelIsNotNull() {
            addCriterion("par_level is not null");
            return (Criteria) this;
        }

        public Criteria andParLevelEqualTo(String value) {
            addCriterion("par_level =", value, "parLevel");
            return (Criteria) this;
        }

        public Criteria andParLevelNotEqualTo(String value) {
            addCriterion("par_level <>", value, "parLevel");
            return (Criteria) this;
        }

        public Criteria andParLevelGreaterThan(String value) {
            addCriterion("par_level >", value, "parLevel");
            return (Criteria) this;
        }

        public Criteria andParLevelGreaterThanOrEqualTo(String value) {
            addCriterion("par_level >=", value, "parLevel");
            return (Criteria) this;
        }

        public Criteria andParLevelLessThan(String value) {
            addCriterion("par_level <", value, "parLevel");
            return (Criteria) this;
        }

        public Criteria andParLevelLessThanOrEqualTo(String value) {
            addCriterion("par_level <=", value, "parLevel");
            return (Criteria) this;
        }

        public Criteria andParLevelLike(String value) {
            addCriterion("par_level like", value, "parLevel");
            return (Criteria) this;
        }

        public Criteria andParLevelNotLike(String value) {
            addCriterion("par_level not like", value, "parLevel");
            return (Criteria) this;
        }

        public Criteria andParLevelIn(List<String> values) {
            addCriterion("par_level in", values, "parLevel");
            return (Criteria) this;
        }

        public Criteria andParLevelNotIn(List<String> values) {
            addCriterion("par_level not in", values, "parLevel");
            return (Criteria) this;
        }

        public Criteria andParLevelBetween(String value1, String value2) {
            addCriterion("par_level between", value1, value2, "parLevel");
            return (Criteria) this;
        }

        public Criteria andParLevelNotBetween(String value1, String value2) {
            addCriterion("par_level not between", value1, value2, "parLevel");
            return (Criteria) this;
        }

        public Criteria andParKeyIsNull() {
            addCriterion("par_key is null");
            return (Criteria) this;
        }

        public Criteria andParKeyIsNotNull() {
            addCriterion("par_key is not null");
            return (Criteria) this;
        }

        public Criteria andParKeyEqualTo(String value) {
            addCriterion("par_key =", value, "parKey");
            return (Criteria) this;
        }

        public Criteria andParKeyNotEqualTo(String value) {
            addCriterion("par_key <>", value, "parKey");
            return (Criteria) this;
        }

        public Criteria andParKeyGreaterThan(String value) {
            addCriterion("par_key >", value, "parKey");
            return (Criteria) this;
        }

        public Criteria andParKeyGreaterThanOrEqualTo(String value) {
            addCriterion("par_key >=", value, "parKey");
            return (Criteria) this;
        }

        public Criteria andParKeyLessThan(String value) {
            addCriterion("par_key <", value, "parKey");
            return (Criteria) this;
        }

        public Criteria andParKeyLessThanOrEqualTo(String value) {
            addCriterion("par_key <=", value, "parKey");
            return (Criteria) this;
        }

        public Criteria andParKeyLike(String value) {
            addCriterion("par_key like", value, "parKey");
            return (Criteria) this;
        }

        public Criteria andParKeyNotLike(String value) {
            addCriterion("par_key not like", value, "parKey");
            return (Criteria) this;
        }

        public Criteria andParKeyIn(List<String> values) {
            addCriterion("par_key in", values, "parKey");
            return (Criteria) this;
        }

        public Criteria andParKeyNotIn(List<String> values) {
            addCriterion("par_key not in", values, "parKey");
            return (Criteria) this;
        }

        public Criteria andParKeyBetween(String value1, String value2) {
            addCriterion("par_key between", value1, value2, "parKey");
            return (Criteria) this;
        }

        public Criteria andParKeyNotBetween(String value1, String value2) {
            addCriterion("par_key not between", value1, value2, "parKey");
            return (Criteria) this;
        }

        public Criteria andParValueIsNull() {
            addCriterion("par_value is null");
            return (Criteria) this;
        }

        public Criteria andParValueIsNotNull() {
            addCriterion("par_value is not null");
            return (Criteria) this;
        }

        public Criteria andParValueEqualTo(String value) {
            addCriterion("par_value =", value, "parValue");
            return (Criteria) this;
        }

        public Criteria andParValueNotEqualTo(String value) {
            addCriterion("par_value <>", value, "parValue");
            return (Criteria) this;
        }

        public Criteria andParValueGreaterThan(String value) {
            addCriterion("par_value >", value, "parValue");
            return (Criteria) this;
        }

        public Criteria andParValueGreaterThanOrEqualTo(String value) {
            addCriterion("par_value >=", value, "parValue");
            return (Criteria) this;
        }

        public Criteria andParValueLessThan(String value) {
            addCriterion("par_value <", value, "parValue");
            return (Criteria) this;
        }

        public Criteria andParValueLessThanOrEqualTo(String value) {
            addCriterion("par_value <=", value, "parValue");
            return (Criteria) this;
        }

        public Criteria andParValueLike(String value) {
            addCriterion("par_value like", value, "parValue");
            return (Criteria) this;
        }

        public Criteria andParValueNotLike(String value) {
            addCriterion("par_value not like", value, "parValue");
            return (Criteria) this;
        }

        public Criteria andParValueIn(List<String> values) {
            addCriterion("par_value in", values, "parValue");
            return (Criteria) this;
        }

        public Criteria andParValueNotIn(List<String> values) {
            addCriterion("par_value not in", values, "parValue");
            return (Criteria) this;
        }

        public Criteria andParValueBetween(String value1, String value2) {
            addCriterion("par_value between", value1, value2, "parValue");
            return (Criteria) this;
        }

        public Criteria andParValueNotBetween(String value1, String value2) {
            addCriterion("par_value not between", value1, value2, "parValue");
            return (Criteria) this;
        }

        public Criteria andGroupIdIsNull() {
            addCriterion("group_id is null");
            return (Criteria) this;
        }

        public Criteria andGroupIdIsNotNull() {
            addCriterion("group_id is not null");
            return (Criteria) this;
        }

        public Criteria andGroupIdEqualTo(String value) {
            addCriterion("group_id =", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdNotEqualTo(String value) {
            addCriterion("group_id <>", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdGreaterThan(String value) {
            addCriterion("group_id >", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdGreaterThanOrEqualTo(String value) {
            addCriterion("group_id >=", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdLessThan(String value) {
            addCriterion("group_id <", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdLessThanOrEqualTo(String value) {
            addCriterion("group_id <=", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdLike(String value) {
            addCriterion("group_id like", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdNotLike(String value) {
            addCriterion("group_id not like", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdIn(List<String> values) {
            addCriterion("group_id in", values, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdNotIn(List<String> values) {
            addCriterion("group_id not in", values, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdBetween(String value1, String value2) {
            addCriterion("group_id between", value1, value2, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdNotBetween(String value1, String value2) {
            addCriterion("group_id not between", value1, value2, "groupId");
            return (Criteria) this;
        }

        public Criteria andSortCodeIsNull() {
            addCriterion("sort_code is null");
            return (Criteria) this;
        }

        public Criteria andSortCodeIsNotNull() {
            addCriterion("sort_code is not null");
            return (Criteria) this;
        }

        public Criteria andSortCodeEqualTo(String value) {
            addCriterion("sort_code =", value, "sortCode");
            return (Criteria) this;
        }

        public Criteria andSortCodeNotEqualTo(String value) {
            addCriterion("sort_code <>", value, "sortCode");
            return (Criteria) this;
        }

        public Criteria andSortCodeGreaterThan(String value) {
            addCriterion("sort_code >", value, "sortCode");
            return (Criteria) this;
        }

        public Criteria andSortCodeGreaterThanOrEqualTo(String value) {
            addCriterion("sort_code >=", value, "sortCode");
            return (Criteria) this;
        }

        public Criteria andSortCodeLessThan(String value) {
            addCriterion("sort_code <", value, "sortCode");
            return (Criteria) this;
        }

        public Criteria andSortCodeLessThanOrEqualTo(String value) {
            addCriterion("sort_code <=", value, "sortCode");
            return (Criteria) this;
        }

        public Criteria andSortCodeLike(String value) {
            addCriterion("sort_code like", value, "sortCode");
            return (Criteria) this;
        }

        public Criteria andSortCodeNotLike(String value) {
            addCriterion("sort_code not like", value, "sortCode");
            return (Criteria) this;
        }

        public Criteria andSortCodeIn(List<String> values) {
            addCriterion("sort_code in", values, "sortCode");
            return (Criteria) this;
        }

        public Criteria andSortCodeNotIn(List<String> values) {
            addCriterion("sort_code not in", values, "sortCode");
            return (Criteria) this;
        }

        public Criteria andSortCodeBetween(String value1, String value2) {
            addCriterion("sort_code between", value1, value2, "sortCode");
            return (Criteria) this;
        }

        public Criteria andSortCodeNotBetween(String value1, String value2) {
            addCriterion("sort_code not between", value1, value2, "sortCode");
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

        public Criteria andCtTimeIsNull() {
            addCriterion("ct_time is null");
            return (Criteria) this;
        }

        public Criteria andCtTimeIsNotNull() {
            addCriterion("ct_time is not null");
            return (Criteria) this;
        }

        public Criteria andCtTimeEqualTo(Date value) {
            addCriterion("ct_time =", value, "ctTime");
            return (Criteria) this;
        }

        public Criteria andCtTimeNotEqualTo(Date value) {
            addCriterion("ct_time <>", value, "ctTime");
            return (Criteria) this;
        }

        public Criteria andCtTimeGreaterThan(Date value) {
            addCriterion("ct_time >", value, "ctTime");
            return (Criteria) this;
        }

        public Criteria andCtTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("ct_time >=", value, "ctTime");
            return (Criteria) this;
        }

        public Criteria andCtTimeLessThan(Date value) {
            addCriterion("ct_time <", value, "ctTime");
            return (Criteria) this;
        }

        public Criteria andCtTimeLessThanOrEqualTo(Date value) {
            addCriterion("ct_time <=", value, "ctTime");
            return (Criteria) this;
        }

        public Criteria andCtTimeIn(List<Date> values) {
            addCriterion("ct_time in", values, "ctTime");
            return (Criteria) this;
        }

        public Criteria andCtTimeNotIn(List<Date> values) {
            addCriterion("ct_time not in", values, "ctTime");
            return (Criteria) this;
        }

        public Criteria andCtTimeBetween(Date value1, Date value2) {
            addCriterion("ct_time between", value1, value2, "ctTime");
            return (Criteria) this;
        }

        public Criteria andCtTimeNotBetween(Date value1, Date value2) {
            addCriterion("ct_time not between", value1, value2, "ctTime");
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

        public Criteria andUpTimeIsNull() {
            addCriterion("up_time is null");
            return (Criteria) this;
        }

        public Criteria andUpTimeIsNotNull() {
            addCriterion("up_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpTimeEqualTo(Date value) {
            addCriterion("up_time =", value, "upTime");
            return (Criteria) this;
        }

        public Criteria andUpTimeNotEqualTo(Date value) {
            addCriterion("up_time <>", value, "upTime");
            return (Criteria) this;
        }

        public Criteria andUpTimeGreaterThan(Date value) {
            addCriterion("up_time >", value, "upTime");
            return (Criteria) this;
        }

        public Criteria andUpTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("up_time >=", value, "upTime");
            return (Criteria) this;
        }

        public Criteria andUpTimeLessThan(Date value) {
            addCriterion("up_time <", value, "upTime");
            return (Criteria) this;
        }

        public Criteria andUpTimeLessThanOrEqualTo(Date value) {
            addCriterion("up_time <=", value, "upTime");
            return (Criteria) this;
        }

        public Criteria andUpTimeIn(List<Date> values) {
            addCriterion("up_time in", values, "upTime");
            return (Criteria) this;
        }

        public Criteria andUpTimeNotIn(List<Date> values) {
            addCriterion("up_time not in", values, "upTime");
            return (Criteria) this;
        }

        public Criteria andUpTimeBetween(Date value1, Date value2) {
            addCriterion("up_time between", value1, value2, "upTime");
            return (Criteria) this;
        }

        public Criteria andUpTimeNotBetween(Date value1, Date value2) {
            addCriterion("up_time not between", value1, value2, "upTime");
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