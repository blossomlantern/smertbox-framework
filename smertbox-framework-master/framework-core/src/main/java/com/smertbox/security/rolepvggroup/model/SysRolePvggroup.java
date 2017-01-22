package com.smertbox.security.rolepvggroup.model;

import java.util.Date;

public class SysRolePvggroup {
    private String id;

    private String roleId;

    private String pvggroupId;

    private Date createTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId == null ? null : roleId.trim();
    }

    public String getPvggroupId() {
        return pvggroupId;
    }

    public void setPvggroupId(String pvggroupId) {
        this.pvggroupId = pvggroupId == null ? null : pvggroupId.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}