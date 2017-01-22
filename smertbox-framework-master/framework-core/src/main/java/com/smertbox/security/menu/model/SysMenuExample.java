package com.smertbox.security.menu.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SysMenuExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SysMenuExample() {
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

        public Criteria andMenuIdIsNull() {
            addCriterion("menu_id is null");
            return (Criteria) this;
        }

        public Criteria andMenuIdIsNotNull() {
            addCriterion("menu_id is not null");
            return (Criteria) this;
        }

        public Criteria andMenuIdEqualTo(String value) {
            addCriterion("menu_id =", value, "menuId");
            return (Criteria) this;
        }

        public Criteria andMenuIdNotEqualTo(String value) {
            addCriterion("menu_id <>", value, "menuId");
            return (Criteria) this;
        }

        public Criteria andMenuIdGreaterThan(String value) {
            addCriterion("menu_id >", value, "menuId");
            return (Criteria) this;
        }

        public Criteria andMenuIdGreaterThanOrEqualTo(String value) {
            addCriterion("menu_id >=", value, "menuId");
            return (Criteria) this;
        }

        public Criteria andMenuIdLessThan(String value) {
            addCriterion("menu_id <", value, "menuId");
            return (Criteria) this;
        }

        public Criteria andMenuIdLessThanOrEqualTo(String value) {
            addCriterion("menu_id <=", value, "menuId");
            return (Criteria) this;
        }

        public Criteria andMenuIdLike(String value) {
            addCriterion("menu_id like", value, "menuId");
            return (Criteria) this;
        }

        public Criteria andMenuIdNotLike(String value) {
            addCriterion("menu_id not like", value, "menuId");
            return (Criteria) this;
        }

        public Criteria andMenuIdIn(List<String> values) {
            addCriterion("menu_id in", values, "menuId");
            return (Criteria) this;
        }

        public Criteria andMenuIdNotIn(List<String> values) {
            addCriterion("menu_id not in", values, "menuId");
            return (Criteria) this;
        }

        public Criteria andMenuIdBetween(String value1, String value2) {
            addCriterion("menu_id between", value1, value2, "menuId");
            return (Criteria) this;
        }

        public Criteria andMenuIdNotBetween(String value1, String value2) {
            addCriterion("menu_id not between", value1, value2, "menuId");
            return (Criteria) this;
        }

        public Criteria andMenuPidIsNull() {
            addCriterion("menu_pid is null");
            return (Criteria) this;
        }

        public Criteria andMenuPidIsNotNull() {
            addCriterion("menu_pid is not null");
            return (Criteria) this;
        }

        public Criteria andMenuPidEqualTo(String value) {
            addCriterion("menu_pid =", value, "menuPid");
            return (Criteria) this;
        }

        public Criteria andMenuPidNotEqualTo(String value) {
            addCriterion("menu_pid <>", value, "menuPid");
            return (Criteria) this;
        }

        public Criteria andMenuPidGreaterThan(String value) {
            addCriterion("menu_pid >", value, "menuPid");
            return (Criteria) this;
        }

        public Criteria andMenuPidGreaterThanOrEqualTo(String value) {
            addCriterion("menu_pid >=", value, "menuPid");
            return (Criteria) this;
        }

        public Criteria andMenuPidLessThan(String value) {
            addCriterion("menu_pid <", value, "menuPid");
            return (Criteria) this;
        }

        public Criteria andMenuPidLessThanOrEqualTo(String value) {
            addCriterion("menu_pid <=", value, "menuPid");
            return (Criteria) this;
        }

        public Criteria andMenuPidLike(String value) {
            addCriterion("menu_pid like", value, "menuPid");
            return (Criteria) this;
        }

        public Criteria andMenuPidNotLike(String value) {
            addCriterion("menu_pid not like", value, "menuPid");
            return (Criteria) this;
        }

        public Criteria andMenuPidIn(List<String> values) {
            addCriterion("menu_pid in", values, "menuPid");
            return (Criteria) this;
        }

        public Criteria andMenuPidNotIn(List<String> values) {
            addCriterion("menu_pid not in", values, "menuPid");
            return (Criteria) this;
        }

        public Criteria andMenuPidBetween(String value1, String value2) {
            addCriterion("menu_pid between", value1, value2, "menuPid");
            return (Criteria) this;
        }

        public Criteria andMenuPidNotBetween(String value1, String value2) {
            addCriterion("menu_pid not between", value1, value2, "menuPid");
            return (Criteria) this;
        }

        public Criteria andMenuNameIsNull() {
            addCriterion("menu_name is null");
            return (Criteria) this;
        }

        public Criteria andMenuNameIsNotNull() {
            addCriterion("menu_name is not null");
            return (Criteria) this;
        }

        public Criteria andMenuNameEqualTo(String value) {
            addCriterion("menu_name =", value, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuNameNotEqualTo(String value) {
            addCriterion("menu_name <>", value, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuNameGreaterThan(String value) {
            addCriterion("menu_name >", value, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuNameGreaterThanOrEqualTo(String value) {
            addCriterion("menu_name >=", value, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuNameLessThan(String value) {
            addCriterion("menu_name <", value, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuNameLessThanOrEqualTo(String value) {
            addCriterion("menu_name <=", value, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuNameLike(String value) {
            addCriterion("menu_name like", value, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuNameNotLike(String value) {
            addCriterion("menu_name not like", value, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuNameIn(List<String> values) {
            addCriterion("menu_name in", values, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuNameNotIn(List<String> values) {
            addCriterion("menu_name not in", values, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuNameBetween(String value1, String value2) {
            addCriterion("menu_name between", value1, value2, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuNameNotBetween(String value1, String value2) {
            addCriterion("menu_name not between", value1, value2, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuDescIsNull() {
            addCriterion("menu_desc is null");
            return (Criteria) this;
        }

        public Criteria andMenuDescIsNotNull() {
            addCriterion("menu_desc is not null");
            return (Criteria) this;
        }

        public Criteria andMenuDescEqualTo(String value) {
            addCriterion("menu_desc =", value, "menuDesc");
            return (Criteria) this;
        }

        public Criteria andMenuDescNotEqualTo(String value) {
            addCriterion("menu_desc <>", value, "menuDesc");
            return (Criteria) this;
        }

        public Criteria andMenuDescGreaterThan(String value) {
            addCriterion("menu_desc >", value, "menuDesc");
            return (Criteria) this;
        }

        public Criteria andMenuDescGreaterThanOrEqualTo(String value) {
            addCriterion("menu_desc >=", value, "menuDesc");
            return (Criteria) this;
        }

        public Criteria andMenuDescLessThan(String value) {
            addCriterion("menu_desc <", value, "menuDesc");
            return (Criteria) this;
        }

        public Criteria andMenuDescLessThanOrEqualTo(String value) {
            addCriterion("menu_desc <=", value, "menuDesc");
            return (Criteria) this;
        }

        public Criteria andMenuDescLike(String value) {
            addCriterion("menu_desc like", value, "menuDesc");
            return (Criteria) this;
        }

        public Criteria andMenuDescNotLike(String value) {
            addCriterion("menu_desc not like", value, "menuDesc");
            return (Criteria) this;
        }

        public Criteria andMenuDescIn(List<String> values) {
            addCriterion("menu_desc in", values, "menuDesc");
            return (Criteria) this;
        }

        public Criteria andMenuDescNotIn(List<String> values) {
            addCriterion("menu_desc not in", values, "menuDesc");
            return (Criteria) this;
        }

        public Criteria andMenuDescBetween(String value1, String value2) {
            addCriterion("menu_desc between", value1, value2, "menuDesc");
            return (Criteria) this;
        }

        public Criteria andMenuDescNotBetween(String value1, String value2) {
            addCriterion("menu_desc not between", value1, value2, "menuDesc");
            return (Criteria) this;
        }

        public Criteria andIconUrlIsNull() {
            addCriterion("icon_url is null");
            return (Criteria) this;
        }

        public Criteria andIconUrlIsNotNull() {
            addCriterion("icon_url is not null");
            return (Criteria) this;
        }

        public Criteria andIconUrlEqualTo(String value) {
            addCriterion("icon_url =", value, "iconUrl");
            return (Criteria) this;
        }

        public Criteria andIconUrlNotEqualTo(String value) {
            addCriterion("icon_url <>", value, "iconUrl");
            return (Criteria) this;
        }

        public Criteria andIconUrlGreaterThan(String value) {
            addCriterion("icon_url >", value, "iconUrl");
            return (Criteria) this;
        }

        public Criteria andIconUrlGreaterThanOrEqualTo(String value) {
            addCriterion("icon_url >=", value, "iconUrl");
            return (Criteria) this;
        }

        public Criteria andIconUrlLessThan(String value) {
            addCriterion("icon_url <", value, "iconUrl");
            return (Criteria) this;
        }

        public Criteria andIconUrlLessThanOrEqualTo(String value) {
            addCriterion("icon_url <=", value, "iconUrl");
            return (Criteria) this;
        }

        public Criteria andIconUrlLike(String value) {
            addCriterion("icon_url like", value, "iconUrl");
            return (Criteria) this;
        }

        public Criteria andIconUrlNotLike(String value) {
            addCriterion("icon_url not like", value, "iconUrl");
            return (Criteria) this;
        }

        public Criteria andIconUrlIn(List<String> values) {
            addCriterion("icon_url in", values, "iconUrl");
            return (Criteria) this;
        }

        public Criteria andIconUrlNotIn(List<String> values) {
            addCriterion("icon_url not in", values, "iconUrl");
            return (Criteria) this;
        }

        public Criteria andIconUrlBetween(String value1, String value2) {
            addCriterion("icon_url between", value1, value2, "iconUrl");
            return (Criteria) this;
        }

        public Criteria andIconUrlNotBetween(String value1, String value2) {
            addCriterion("icon_url not between", value1, value2, "iconUrl");
            return (Criteria) this;
        }

        public Criteria andMenuTypeIsNull() {
            addCriterion("menu_type is null");
            return (Criteria) this;
        }

        public Criteria andMenuTypeIsNotNull() {
            addCriterion("menu_type is not null");
            return (Criteria) this;
        }

        public Criteria andMenuTypeEqualTo(String value) {
            addCriterion("menu_type =", value, "menuType");
            return (Criteria) this;
        }

        public Criteria andMenuTypeNotEqualTo(String value) {
            addCriterion("menu_type <>", value, "menuType");
            return (Criteria) this;
        }

        public Criteria andMenuTypeGreaterThan(String value) {
            addCriterion("menu_type >", value, "menuType");
            return (Criteria) this;
        }

        public Criteria andMenuTypeGreaterThanOrEqualTo(String value) {
            addCriterion("menu_type >=", value, "menuType");
            return (Criteria) this;
        }

        public Criteria andMenuTypeLessThan(String value) {
            addCriterion("menu_type <", value, "menuType");
            return (Criteria) this;
        }

        public Criteria andMenuTypeLessThanOrEqualTo(String value) {
            addCriterion("menu_type <=", value, "menuType");
            return (Criteria) this;
        }

        public Criteria andMenuTypeLike(String value) {
            addCriterion("menu_type like", value, "menuType");
            return (Criteria) this;
        }

        public Criteria andMenuTypeNotLike(String value) {
            addCriterion("menu_type not like", value, "menuType");
            return (Criteria) this;
        }

        public Criteria andMenuTypeIn(List<String> values) {
            addCriterion("menu_type in", values, "menuType");
            return (Criteria) this;
        }

        public Criteria andMenuTypeNotIn(List<String> values) {
            addCriterion("menu_type not in", values, "menuType");
            return (Criteria) this;
        }

        public Criteria andMenuTypeBetween(String value1, String value2) {
            addCriterion("menu_type between", value1, value2, "menuType");
            return (Criteria) this;
        }

        public Criteria andMenuTypeNotBetween(String value1, String value2) {
            addCriterion("menu_type not between", value1, value2, "menuType");
            return (Criteria) this;
        }

        public Criteria andMenuUrlIsNull() {
            addCriterion("menu_url is null");
            return (Criteria) this;
        }

        public Criteria andMenuUrlIsNotNull() {
            addCriterion("menu_url is not null");
            return (Criteria) this;
        }

        public Criteria andMenuUrlEqualTo(String value) {
            addCriterion("menu_url =", value, "menuUrl");
            return (Criteria) this;
        }

        public Criteria andMenuUrlNotEqualTo(String value) {
            addCriterion("menu_url <>", value, "menuUrl");
            return (Criteria) this;
        }

        public Criteria andMenuUrlGreaterThan(String value) {
            addCriterion("menu_url >", value, "menuUrl");
            return (Criteria) this;
        }

        public Criteria andMenuUrlGreaterThanOrEqualTo(String value) {
            addCriterion("menu_url >=", value, "menuUrl");
            return (Criteria) this;
        }

        public Criteria andMenuUrlLessThan(String value) {
            addCriterion("menu_url <", value, "menuUrl");
            return (Criteria) this;
        }

        public Criteria andMenuUrlLessThanOrEqualTo(String value) {
            addCriterion("menu_url <=", value, "menuUrl");
            return (Criteria) this;
        }

        public Criteria andMenuUrlLike(String value) {
            addCriterion("menu_url like", value, "menuUrl");
            return (Criteria) this;
        }

        public Criteria andMenuUrlNotLike(String value) {
            addCriterion("menu_url not like", value, "menuUrl");
            return (Criteria) this;
        }

        public Criteria andMenuUrlIn(List<String> values) {
            addCriterion("menu_url in", values, "menuUrl");
            return (Criteria) this;
        }

        public Criteria andMenuUrlNotIn(List<String> values) {
            addCriterion("menu_url not in", values, "menuUrl");
            return (Criteria) this;
        }

        public Criteria andMenuUrlBetween(String value1, String value2) {
            addCriterion("menu_url between", value1, value2, "menuUrl");
            return (Criteria) this;
        }

        public Criteria andMenuUrlNotBetween(String value1, String value2) {
            addCriterion("menu_url not between", value1, value2, "menuUrl");
            return (Criteria) this;
        }

        public Criteria andClassNameIsNull() {
            addCriterion("class_name is null");
            return (Criteria) this;
        }

        public Criteria andClassNameIsNotNull() {
            addCriterion("class_name is not null");
            return (Criteria) this;
        }

        public Criteria andClassNameEqualTo(String value) {
            addCriterion("class_name =", value, "className");
            return (Criteria) this;
        }

        public Criteria andClassNameNotEqualTo(String value) {
            addCriterion("class_name <>", value, "className");
            return (Criteria) this;
        }

        public Criteria andClassNameGreaterThan(String value) {
            addCriterion("class_name >", value, "className");
            return (Criteria) this;
        }

        public Criteria andClassNameGreaterThanOrEqualTo(String value) {
            addCriterion("class_name >=", value, "className");
            return (Criteria) this;
        }

        public Criteria andClassNameLessThan(String value) {
            addCriterion("class_name <", value, "className");
            return (Criteria) this;
        }

        public Criteria andClassNameLessThanOrEqualTo(String value) {
            addCriterion("class_name <=", value, "className");
            return (Criteria) this;
        }

        public Criteria andClassNameLike(String value) {
            addCriterion("class_name like", value, "className");
            return (Criteria) this;
        }

        public Criteria andClassNameNotLike(String value) {
            addCriterion("class_name not like", value, "className");
            return (Criteria) this;
        }

        public Criteria andClassNameIn(List<String> values) {
            addCriterion("class_name in", values, "className");
            return (Criteria) this;
        }

        public Criteria andClassNameNotIn(List<String> values) {
            addCriterion("class_name not in", values, "className");
            return (Criteria) this;
        }

        public Criteria andClassNameBetween(String value1, String value2) {
            addCriterion("class_name between", value1, value2, "className");
            return (Criteria) this;
        }

        public Criteria andClassNameNotBetween(String value1, String value2) {
            addCriterion("class_name not between", value1, value2, "className");
            return (Criteria) this;
        }

        public Criteria andLeftIconClassIsNull() {
            addCriterion("left_icon_class is null");
            return (Criteria) this;
        }

        public Criteria andLeftIconClassIsNotNull() {
            addCriterion("left_icon_class is not null");
            return (Criteria) this;
        }

        public Criteria andLeftIconClassEqualTo(String value) {
            addCriterion("left_icon_class =", value, "leftIconClass");
            return (Criteria) this;
        }

        public Criteria andLeftIconClassNotEqualTo(String value) {
            addCriterion("left_icon_class <>", value, "leftIconClass");
            return (Criteria) this;
        }

        public Criteria andLeftIconClassGreaterThan(String value) {
            addCriterion("left_icon_class >", value, "leftIconClass");
            return (Criteria) this;
        }

        public Criteria andLeftIconClassGreaterThanOrEqualTo(String value) {
            addCriterion("left_icon_class >=", value, "leftIconClass");
            return (Criteria) this;
        }

        public Criteria andLeftIconClassLessThan(String value) {
            addCriterion("left_icon_class <", value, "leftIconClass");
            return (Criteria) this;
        }

        public Criteria andLeftIconClassLessThanOrEqualTo(String value) {
            addCriterion("left_icon_class <=", value, "leftIconClass");
            return (Criteria) this;
        }

        public Criteria andLeftIconClassLike(String value) {
            addCriterion("left_icon_class like", value, "leftIconClass");
            return (Criteria) this;
        }

        public Criteria andLeftIconClassNotLike(String value) {
            addCriterion("left_icon_class not like", value, "leftIconClass");
            return (Criteria) this;
        }

        public Criteria andLeftIconClassIn(List<String> values) {
            addCriterion("left_icon_class in", values, "leftIconClass");
            return (Criteria) this;
        }

        public Criteria andLeftIconClassNotIn(List<String> values) {
            addCriterion("left_icon_class not in", values, "leftIconClass");
            return (Criteria) this;
        }

        public Criteria andLeftIconClassBetween(String value1, String value2) {
            addCriterion("left_icon_class between", value1, value2, "leftIconClass");
            return (Criteria) this;
        }

        public Criteria andLeftIconClassNotBetween(String value1, String value2) {
            addCriterion("left_icon_class not between", value1, value2, "leftIconClass");
            return (Criteria) this;
        }

        public Criteria andTitleClassIsNull() {
            addCriterion("title_class is null");
            return (Criteria) this;
        }

        public Criteria andTitleClassIsNotNull() {
            addCriterion("title_class is not null");
            return (Criteria) this;
        }

        public Criteria andTitleClassEqualTo(String value) {
            addCriterion("title_class =", value, "titleClass");
            return (Criteria) this;
        }

        public Criteria andTitleClassNotEqualTo(String value) {
            addCriterion("title_class <>", value, "titleClass");
            return (Criteria) this;
        }

        public Criteria andTitleClassGreaterThan(String value) {
            addCriterion("title_class >", value, "titleClass");
            return (Criteria) this;
        }

        public Criteria andTitleClassGreaterThanOrEqualTo(String value) {
            addCriterion("title_class >=", value, "titleClass");
            return (Criteria) this;
        }

        public Criteria andTitleClassLessThan(String value) {
            addCriterion("title_class <", value, "titleClass");
            return (Criteria) this;
        }

        public Criteria andTitleClassLessThanOrEqualTo(String value) {
            addCriterion("title_class <=", value, "titleClass");
            return (Criteria) this;
        }

        public Criteria andTitleClassLike(String value) {
            addCriterion("title_class like", value, "titleClass");
            return (Criteria) this;
        }

        public Criteria andTitleClassNotLike(String value) {
            addCriterion("title_class not like", value, "titleClass");
            return (Criteria) this;
        }

        public Criteria andTitleClassIn(List<String> values) {
            addCriterion("title_class in", values, "titleClass");
            return (Criteria) this;
        }

        public Criteria andTitleClassNotIn(List<String> values) {
            addCriterion("title_class not in", values, "titleClass");
            return (Criteria) this;
        }

        public Criteria andTitleClassBetween(String value1, String value2) {
            addCriterion("title_class between", value1, value2, "titleClass");
            return (Criteria) this;
        }

        public Criteria andTitleClassNotBetween(String value1, String value2) {
            addCriterion("title_class not between", value1, value2, "titleClass");
            return (Criteria) this;
        }

        public Criteria andRightIconClassIsNull() {
            addCriterion("right_icon_class is null");
            return (Criteria) this;
        }

        public Criteria andRightIconClassIsNotNull() {
            addCriterion("right_icon_class is not null");
            return (Criteria) this;
        }

        public Criteria andRightIconClassEqualTo(String value) {
            addCriterion("right_icon_class =", value, "rightIconClass");
            return (Criteria) this;
        }

        public Criteria andRightIconClassNotEqualTo(String value) {
            addCriterion("right_icon_class <>", value, "rightIconClass");
            return (Criteria) this;
        }

        public Criteria andRightIconClassGreaterThan(String value) {
            addCriterion("right_icon_class >", value, "rightIconClass");
            return (Criteria) this;
        }

        public Criteria andRightIconClassGreaterThanOrEqualTo(String value) {
            addCriterion("right_icon_class >=", value, "rightIconClass");
            return (Criteria) this;
        }

        public Criteria andRightIconClassLessThan(String value) {
            addCriterion("right_icon_class <", value, "rightIconClass");
            return (Criteria) this;
        }

        public Criteria andRightIconClassLessThanOrEqualTo(String value) {
            addCriterion("right_icon_class <=", value, "rightIconClass");
            return (Criteria) this;
        }

        public Criteria andRightIconClassLike(String value) {
            addCriterion("right_icon_class like", value, "rightIconClass");
            return (Criteria) this;
        }

        public Criteria andRightIconClassNotLike(String value) {
            addCriterion("right_icon_class not like", value, "rightIconClass");
            return (Criteria) this;
        }

        public Criteria andRightIconClassIn(List<String> values) {
            addCriterion("right_icon_class in", values, "rightIconClass");
            return (Criteria) this;
        }

        public Criteria andRightIconClassNotIn(List<String> values) {
            addCriterion("right_icon_class not in", values, "rightIconClass");
            return (Criteria) this;
        }

        public Criteria andRightIconClassBetween(String value1, String value2) {
            addCriterion("right_icon_class between", value1, value2, "rightIconClass");
            return (Criteria) this;
        }

        public Criteria andRightIconClassNotBetween(String value1, String value2) {
            addCriterion("right_icon_class not between", value1, value2, "rightIconClass");
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