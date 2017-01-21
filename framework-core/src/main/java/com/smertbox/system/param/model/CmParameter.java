package com.smertbox.system.param.model;

import java.util.Date;

import com.smertbox.util.page.model.PageModel;

public class CmParameter extends PageModel{
    private String parId;

    private String parPid;

    private String parType;

    private String parLevel;

    private String parKey;

    private String parValue;

    private String groupId;

    private String sortCode;

    private Short allowDel;

    private Short allowEdit;

    private Date ctTime;

    private String ctUserId;

    private Date upTime;

    private String upUserId;

    private String note;

    private Short del;

    public String getParId() {
        return parId;
    }

    public void setParId(String parId) {
        this.parId = parId == null ? null : parId.trim();
    }

    public String getParPid() {
        return parPid;
    }

    public void setParPid(String parPid) {
        this.parPid = parPid == null ? null : parPid.trim();
    }

    public String getParType() {
        return parType;
    }

    public void setParType(String parType) {
        this.parType = parType == null ? null : parType.trim();
    }

    public String getParLevel() {
        return parLevel;
    }

    public void setParLevel(String parLevel) {
        this.parLevel = parLevel == null ? null : parLevel.trim();
    }

    public String getParKey() {
        return parKey;
    }

    public void setParKey(String parKey) {
        this.parKey = parKey == null ? null : parKey.trim();
    }

    public String getParValue() {
        return parValue;
    }

    public void setParValue(String parValue) {
        this.parValue = parValue == null ? null : parValue.trim();
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId == null ? null : groupId.trim();
    }

    public String getSortCode() {
        return sortCode;
    }

    public void setSortCode(String sortCode) {
        this.sortCode = sortCode == null ? null : sortCode.trim();
    }

    public Short getAllowDel() {
        return allowDel;
    }

    public void setAllowDel(Short allowDel) {
        this.allowDel = allowDel;
    }

    public Short getAllowEdit() {
        return allowEdit;
    }

    public void setAllowEdit(Short allowEdit) {
        this.allowEdit = allowEdit;
    }

    public Date getCtTime() {
        return ctTime;
    }

    public void setCtTime(Date ctTime) {
        this.ctTime = ctTime;
    }

    public String getCtUserId() {
        return ctUserId;
    }

    public void setCtUserId(String ctUserId) {
        this.ctUserId = ctUserId == null ? null : ctUserId.trim();
    }

    public Date getUpTime() {
        return upTime;
    }

    public void setUpTime(Date upTime) {
        this.upTime = upTime;
    }

    public String getUpUserId() {
        return upUserId;
    }

    public void setUpUserId(String upUserId) {
        this.upUserId = upUserId == null ? null : upUserId.trim();
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
    }

    public Short getDel() {
        return del;
    }

    public void setDel(Short del) {
        this.del = del;
    }
}