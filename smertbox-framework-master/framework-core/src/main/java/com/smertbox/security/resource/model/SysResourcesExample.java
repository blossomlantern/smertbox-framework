package com.smertbox.security.resource.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class SysResourcesExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SysResourcesExample() {
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

        public Criteria andResIdIsNull() {
            addCriterion("res_id is null");
            return (Criteria) this;
        }

        public Criteria andResIdIsNotNull() {
            addCriterion("res_id is not null");
            return (Criteria) this;
        }

        public Criteria andResIdEqualTo(String value) {
            addCriterion("res_id =", value, "resId");
            return (Criteria) this;
        }

        public Criteria andResIdNotEqualTo(String value) {
            addCriterion("res_id <>", value, "resId");
            return (Criteria) this;
        }

        public Criteria andResIdGreaterThan(String value) {
            addCriterion("res_id >", value, "resId");
            return (Criteria) this;
        }

        public Criteria andResIdGreaterThanOrEqualTo(String value) {
            addCriterion("res_id >=", value, "resId");
            return (Criteria) this;
        }

        public Criteria andResIdLessThan(String value) {
            addCriterion("res_id <", value, "resId");
            return (Criteria) this;
        }

        public Criteria andResIdLessThanOrEqualTo(String value) {
            addCriterion("res_id <=", value, "resId");
            return (Criteria) this;
        }

        public Criteria andResIdLike(String value) {
            addCriterion("res_id like", value, "resId");
            return (Criteria) this;
        }

        public Criteria andResIdNotLike(String value) {
            addCriterion("res_id not like", value, "resId");
            return (Criteria) this;
        }

        public Criteria andResIdIn(List<String> values) {
            addCriterion("res_id in", values, "resId");
            return (Criteria) this;
        }

        public Criteria andResIdNotIn(List<String> values) {
            addCriterion("res_id not in", values, "resId");
            return (Criteria) this;
        }

        public Criteria andResIdBetween(String value1, String value2) {
            addCriterion("res_id between", value1, value2, "resId");
            return (Criteria) this;
        }

        public Criteria andResIdNotBetween(String value1, String value2) {
            addCriterion("res_id not between", value1, value2, "resId");
            return (Criteria) this;
        }

        public Criteria andResPidIsNull() {
            addCriterion("res_pid is null");
            return (Criteria) this;
        }

        public Criteria andResPidIsNotNull() {
            addCriterion("res_pid is not null");
            return (Criteria) this;
        }

        public Criteria andResPidEqualTo(String value) {
            addCriterion("res_pid =", value, "resPid");
            return (Criteria) this;
        }

        public Criteria andResPidNotEqualTo(String value) {
            addCriterion("res_pid <>", value, "resPid");
            return (Criteria) this;
        }

        public Criteria andResPidGreaterThan(String value) {
            addCriterion("res_pid >", value, "resPid");
            return (Criteria) this;
        }

        public Criteria andResPidGreaterThanOrEqualTo(String value) {
            addCriterion("res_pid >=", value, "resPid");
            return (Criteria) this;
        }

        public Criteria andResPidLessThan(String value) {
            addCriterion("res_pid <", value, "resPid");
            return (Criteria) this;
        }

        public Criteria andResPidLessThanOrEqualTo(String value) {
            addCriterion("res_pid <=", value, "resPid");
            return (Criteria) this;
        }

        public Criteria andResPidLike(String value) {
            addCriterion("res_pid like", value, "resPid");
            return (Criteria) this;
        }

        public Criteria andResPidNotLike(String value) {
            addCriterion("res_pid not like", value, "resPid");
            return (Criteria) this;
        }

        public Criteria andResPidIn(List<String> values) {
            addCriterion("res_pid in", values, "resPid");
            return (Criteria) this;
        }

        public Criteria andResPidNotIn(List<String> values) {
            addCriterion("res_pid not in", values, "resPid");
            return (Criteria) this;
        }

        public Criteria andResPidBetween(String value1, String value2) {
            addCriterion("res_pid between", value1, value2, "resPid");
            return (Criteria) this;
        }

        public Criteria andResPidNotBetween(String value1, String value2) {
            addCriterion("res_pid not between", value1, value2, "resPid");
            return (Criteria) this;
        }

        public Criteria andResNameIsNull() {
            addCriterion("res_name is null");
            return (Criteria) this;
        }

        public Criteria andResNameIsNotNull() {
            addCriterion("res_name is not null");
            return (Criteria) this;
        }

        public Criteria andResNameEqualTo(String value) {
            addCriterion("res_name =", value, "resName");
            return (Criteria) this;
        }

        public Criteria andResNameNotEqualTo(String value) {
            addCriterion("res_name <>", value, "resName");
            return (Criteria) this;
        }

        public Criteria andResNameGreaterThan(String value) {
            addCriterion("res_name >", value, "resName");
            return (Criteria) this;
        }

        public Criteria andResNameGreaterThanOrEqualTo(String value) {
            addCriterion("res_name >=", value, "resName");
            return (Criteria) this;
        }

        public Criteria andResNameLessThan(String value) {
            addCriterion("res_name <", value, "resName");
            return (Criteria) this;
        }

        public Criteria andResNameLessThanOrEqualTo(String value) {
            addCriterion("res_name <=", value, "resName");
            return (Criteria) this;
        }

        public Criteria andResNameLike(String value) {
            addCriterion("res_name like", value, "resName");
            return (Criteria) this;
        }

        public Criteria andResNameNotLike(String value) {
            addCriterion("res_name not like", value, "resName");
            return (Criteria) this;
        }

        public Criteria andResNameIn(List<String> values) {
            addCriterion("res_name in", values, "resName");
            return (Criteria) this;
        }

        public Criteria andResNameNotIn(List<String> values) {
            addCriterion("res_name not in", values, "resName");
            return (Criteria) this;
        }

        public Criteria andResNameBetween(String value1, String value2) {
            addCriterion("res_name between", value1, value2, "resName");
            return (Criteria) this;
        }

        public Criteria andResNameNotBetween(String value1, String value2) {
            addCriterion("res_name not between", value1, value2, "resName");
            return (Criteria) this;
        }

        public Criteria andResDescIsNull() {
            addCriterion("res_desc is null");
            return (Criteria) this;
        }

        public Criteria andResDescIsNotNull() {
            addCriterion("res_desc is not null");
            return (Criteria) this;
        }

        public Criteria andResDescEqualTo(String value) {
            addCriterion("res_desc =", value, "resDesc");
            return (Criteria) this;
        }

        public Criteria andResDescNotEqualTo(String value) {
            addCriterion("res_desc <>", value, "resDesc");
            return (Criteria) this;
        }

        public Criteria andResDescGreaterThan(String value) {
            addCriterion("res_desc >", value, "resDesc");
            return (Criteria) this;
        }

        public Criteria andResDescGreaterThanOrEqualTo(String value) {
            addCriterion("res_desc >=", value, "resDesc");
            return (Criteria) this;
        }

        public Criteria andResDescLessThan(String value) {
            addCriterion("res_desc <", value, "resDesc");
            return (Criteria) this;
        }

        public Criteria andResDescLessThanOrEqualTo(String value) {
            addCriterion("res_desc <=", value, "resDesc");
            return (Criteria) this;
        }

        public Criteria andResDescLike(String value) {
            addCriterion("res_desc like", value, "resDesc");
            return (Criteria) this;
        }

        public Criteria andResDescNotLike(String value) {
            addCriterion("res_desc not like", value, "resDesc");
            return (Criteria) this;
        }

        public Criteria andResDescIn(List<String> values) {
            addCriterion("res_desc in", values, "resDesc");
            return (Criteria) this;
        }

        public Criteria andResDescNotIn(List<String> values) {
            addCriterion("res_desc not in", values, "resDesc");
            return (Criteria) this;
        }

        public Criteria andResDescBetween(String value1, String value2) {
            addCriterion("res_desc between", value1, value2, "resDesc");
            return (Criteria) this;
        }

        public Criteria andResDescNotBetween(String value1, String value2) {
            addCriterion("res_desc not between", value1, value2, "resDesc");
            return (Criteria) this;
        }

        public Criteria andResIconIsNull() {
            addCriterion("res_icon is null");
            return (Criteria) this;
        }

        public Criteria andResIconIsNotNull() {
            addCriterion("res_icon is not null");
            return (Criteria) this;
        }

        public Criteria andResIconEqualTo(String value) {
            addCriterion("res_icon =", value, "resIcon");
            return (Criteria) this;
        }

        public Criteria andResIconNotEqualTo(String value) {
            addCriterion("res_icon <>", value, "resIcon");
            return (Criteria) this;
        }

        public Criteria andResIconGreaterThan(String value) {
            addCriterion("res_icon >", value, "resIcon");
            return (Criteria) this;
        }

        public Criteria andResIconGreaterThanOrEqualTo(String value) {
            addCriterion("res_icon >=", value, "resIcon");
            return (Criteria) this;
        }

        public Criteria andResIconLessThan(String value) {
            addCriterion("res_icon <", value, "resIcon");
            return (Criteria) this;
        }

        public Criteria andResIconLessThanOrEqualTo(String value) {
            addCriterion("res_icon <=", value, "resIcon");
            return (Criteria) this;
        }

        public Criteria andResIconLike(String value) {
            addCriterion("res_icon like", value, "resIcon");
            return (Criteria) this;
        }

        public Criteria andResIconNotLike(String value) {
            addCriterion("res_icon not like", value, "resIcon");
            return (Criteria) this;
        }

        public Criteria andResIconIn(List<String> values) {
            addCriterion("res_icon in", values, "resIcon");
            return (Criteria) this;
        }

        public Criteria andResIconNotIn(List<String> values) {
            addCriterion("res_icon not in", values, "resIcon");
            return (Criteria) this;
        }

        public Criteria andResIconBetween(String value1, String value2) {
            addCriterion("res_icon between", value1, value2, "resIcon");
            return (Criteria) this;
        }

        public Criteria andResIconNotBetween(String value1, String value2) {
            addCriterion("res_icon not between", value1, value2, "resIcon");
            return (Criteria) this;
        }

        public Criteria andResUrlIsNull() {
            addCriterion("res_url is null");
            return (Criteria) this;
        }

        public Criteria andResUrlIsNotNull() {
            addCriterion("res_url is not null");
            return (Criteria) this;
        }

        public Criteria andResUrlEqualTo(String value) {
            addCriterion("res_url =", value, "resUrl");
            return (Criteria) this;
        }

        public Criteria andResUrlNotEqualTo(String value) {
            addCriterion("res_url <>", value, "resUrl");
            return (Criteria) this;
        }

        public Criteria andResUrlGreaterThan(String value) {
            addCriterion("res_url >", value, "resUrl");
            return (Criteria) this;
        }

        public Criteria andResUrlGreaterThanOrEqualTo(String value) {
            addCriterion("res_url >=", value, "resUrl");
            return (Criteria) this;
        }

        public Criteria andResUrlLessThan(String value) {
            addCriterion("res_url <", value, "resUrl");
            return (Criteria) this;
        }

        public Criteria andResUrlLessThanOrEqualTo(String value) {
            addCriterion("res_url <=", value, "resUrl");
            return (Criteria) this;
        }

        public Criteria andResUrlLike(String value) {
            addCriterion("res_url like", value, "resUrl");
            return (Criteria) this;
        }

        public Criteria andResUrlNotLike(String value) {
            addCriterion("res_url not like", value, "resUrl");
            return (Criteria) this;
        }

        public Criteria andResUrlIn(List<String> values) {
            addCriterion("res_url in", values, "resUrl");
            return (Criteria) this;
        }

        public Criteria andResUrlNotIn(List<String> values) {
            addCriterion("res_url not in", values, "resUrl");
            return (Criteria) this;
        }

        public Criteria andResUrlBetween(String value1, String value2) {
            addCriterion("res_url between", value1, value2, "resUrl");
            return (Criteria) this;
        }

        public Criteria andResUrlNotBetween(String value1, String value2) {
            addCriterion("res_url not between", value1, value2, "resUrl");
            return (Criteria) this;
        }

        public Criteria andResTypeIsNull() {
            addCriterion("res_type is null");
            return (Criteria) this;
        }

        public Criteria andResTypeIsNotNull() {
            addCriterion("res_type is not null");
            return (Criteria) this;
        }

        public Criteria andResTypeEqualTo(String value) {
            addCriterion("res_type =", value, "resType");
            return (Criteria) this;
        }

        public Criteria andResTypeNotEqualTo(String value) {
            addCriterion("res_type <>", value, "resType");
            return (Criteria) this;
        }

        public Criteria andResTypeGreaterThan(String value) {
            addCriterion("res_type >", value, "resType");
            return (Criteria) this;
        }

        public Criteria andResTypeGreaterThanOrEqualTo(String value) {
            addCriterion("res_type >=", value, "resType");
            return (Criteria) this;
        }

        public Criteria andResTypeLessThan(String value) {
            addCriterion("res_type <", value, "resType");
            return (Criteria) this;
        }

        public Criteria andResTypeLessThanOrEqualTo(String value) {
            addCriterion("res_type <=", value, "resType");
            return (Criteria) this;
        }

        public Criteria andResTypeLike(String value) {
            addCriterion("res_type like", value, "resType");
            return (Criteria) this;
        }

        public Criteria andResTypeNotLike(String value) {
            addCriterion("res_type not like", value, "resType");
            return (Criteria) this;
        }

        public Criteria andResTypeIn(List<String> values) {
            addCriterion("res_type in", values, "resType");
            return (Criteria) this;
        }

        public Criteria andResTypeNotIn(List<String> values) {
            addCriterion("res_type not in", values, "resType");
            return (Criteria) this;
        }

        public Criteria andResTypeBetween(String value1, String value2) {
            addCriterion("res_type between", value1, value2, "resType");
            return (Criteria) this;
        }

        public Criteria andResTypeNotBetween(String value1, String value2) {
            addCriterion("res_type not between", value1, value2, "resType");
            return (Criteria) this;
        }

        public Criteria andResTargetIsNull() {
            addCriterion("res_target is null");
            return (Criteria) this;
        }

        public Criteria andResTargetIsNotNull() {
            addCriterion("res_target is not null");
            return (Criteria) this;
        }

        public Criteria andResTargetEqualTo(String value) {
            addCriterion("res_target =", value, "resTarget");
            return (Criteria) this;
        }

        public Criteria andResTargetNotEqualTo(String value) {
            addCriterion("res_target <>", value, "resTarget");
            return (Criteria) this;
        }

        public Criteria andResTargetGreaterThan(String value) {
            addCriterion("res_target >", value, "resTarget");
            return (Criteria) this;
        }

        public Criteria andResTargetGreaterThanOrEqualTo(String value) {
            addCriterion("res_target >=", value, "resTarget");
            return (Criteria) this;
        }

        public Criteria andResTargetLessThan(String value) {
            addCriterion("res_target <", value, "resTarget");
            return (Criteria) this;
        }

        public Criteria andResTargetLessThanOrEqualTo(String value) {
            addCriterion("res_target <=", value, "resTarget");
            return (Criteria) this;
        }

        public Criteria andResTargetLike(String value) {
            addCriterion("res_target like", value, "resTarget");
            return (Criteria) this;
        }

        public Criteria andResTargetNotLike(String value) {
            addCriterion("res_target not like", value, "resTarget");
            return (Criteria) this;
        }

        public Criteria andResTargetIn(List<String> values) {
            addCriterion("res_target in", values, "resTarget");
            return (Criteria) this;
        }

        public Criteria andResTargetNotIn(List<String> values) {
            addCriterion("res_target not in", values, "resTarget");
            return (Criteria) this;
        }

        public Criteria andResTargetBetween(String value1, String value2) {
            addCriterion("res_target between", value1, value2, "resTarget");
            return (Criteria) this;
        }

        public Criteria andResTargetNotBetween(String value1, String value2) {
            addCriterion("res_target not between", value1, value2, "resTarget");
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