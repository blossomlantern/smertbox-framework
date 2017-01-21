package com.smertbox.security.positionrolegroup.model;

import java.util.Date;

import com.smertbox.util.page.model.PageModel;

public class SysPositionRolegroup extends PageModel{
    private String prId;

    private String positionId;

    private String rgId;

    private Date createTime;

    public String getPrId() {
        return prId;
    }

    public void setPrId(String prId) {
        this.prId = prId == null ? null : prId.trim();
    }

    public String getPositionId() {
        return positionId;
    }

    public void setPositionId(String positionId) {
        this.positionId = positionId == null ? null : positionId.trim();
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