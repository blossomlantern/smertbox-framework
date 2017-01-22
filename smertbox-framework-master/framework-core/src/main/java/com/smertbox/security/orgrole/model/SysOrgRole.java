package com.smertbox.security.orgrole.model;

import java.util.Date;

import com.smertbox.util.page.model.PageModel;

public class SysOrgRole extends PageModel{
    private String orId;

    private String orgId;

    private String roleId;

    private Date createTime;

    public String getOrId() {
        return orId;
    }

    public void setOrId(String orId) {
        this.orId = orId == null ? null : orId.trim();
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId == null ? null : orgId.trim();
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