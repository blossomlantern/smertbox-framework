package com.smertbox.security.userorg.model;

import java.util.Date;

import com.smertbox.util.page.model.PageModel;

public class SysUserOrg extends PageModel {
    private String uoId;

    private String userId;

    private String orgId;

    private Date createTime;

    public String getUoId() {
        return uoId;
    }

    public void setUoId(String uoId) {
        this.uoId = uoId == null ? null : uoId.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId == null ? null : orgId.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}