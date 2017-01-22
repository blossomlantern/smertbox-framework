package com.smertbox.security.roleprivilege.model;

import java.util.Date;

public class SysRolePrivilege {
    private String rpId;

    private String roleId;

    private String pvgId;

    private Date createTime;

    private String note;

    public String getRpId() {
        return rpId;
    }

    public void setRpId(String rpId) {
        this.rpId = rpId == null ? null : rpId.trim();
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId == null ? null : roleId.trim();
    }

    public String getPvgId() {
        return pvgId;
    }

    public void setPvgId(String pvgId) {
        this.pvgId = pvgId == null ? null : pvgId.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
    }
}