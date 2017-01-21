package com.smertbox.security.orgrolegroup.model;

import java.util.Date;

import com.smertbox.util.page.model.PageModel;

public class SysOrgRolegroup extends PageModel{
    private String orId;

    private String orgId;

    private String rgId;

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

    public String getRgId() {
        return rgId;
    }

    public void setRgId(String rgId) {
        this.rgId = rgId == null ? null : rgId.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}