package com.smertbox.security.userrole.model;

import java.util.Date;

import com.smertbox.util.page.model.PageModel;

public class SysUserRole extends PageModel {
    private String urId;

    private String userId;

    private String roleId;

    private Date createTime;

    public String getUrId() {
        return urId;
    }

    public void setUrId(String urId) {
        this.urId = urId == null ? null : urId.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId == null ? null : roleId.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}