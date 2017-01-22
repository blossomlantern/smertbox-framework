package com.smertbox.security.resourceprivilege.model;

import java.util.Date;

public class SysResPvg {
    private String resPvgId;

    private String resId;

    private String pvgId;

    private String rpType;

    private Short allowEdit;

    private Short allowDel;

    private String ctUserId;

    private Date ctTime;

    private String upUserId;

    private Date upTime;

    private String sort;

    private String note;

    private Short del;

    public String getResPvgId() {
        return resPvgId;
    }

    public void setResPvgId(String resPvgId) {
        this.resPvgId = resPvgId == null ? null : resPvgId.trim();
    }

    public String getResId() {
        return resId;
    }

    public void setResId(String resId) {
        this.resId = resId == null ? null : resId.trim();
    }

    public String getPvgId() {
        return pvgId;
    }

    public void setPvgId(String pvgId) {
        this.pvgId = pvgId == null ? null : pvgId.trim();
    }

    public String getRpType() {
        return rpType;
    }

    public void setRpType(String rpType) {
        this.rpType = rpType == null ? null : rpType.trim();
    }

    public Short getAllowEdit() {
        return allowEdit;
    }

    public void setAllowEdit(Short allowEdit) {
        this.allowEdit = allowEdit;
    }

    public Short getAllowDel() {
        return allowDel;
    }

    public void setAllowDel(Short allowDel) {
        this.allowDel = allowDel;
    }

    public String getCtUserId() {
        return ctUserId;
    }

    public void setCtUserId(String ctUserId) {
        this.ctUserId = ctUserId == null ? null : ctUserId.trim();
    }

    public Date getCtTime() {
        return ctTime;
    }

    public void setCtTime(Date ctTime) {
        this.ctTime = ctTime;
    }

    public String getUpUserId() {
        return upUserId;
    }

    public void setUpUserId(String upUserId) {
        this.upUserId = upUserId == null ? null : upUserId.trim();
    }

    public Date getUpTime() {
        return upTime;
    }

    public void setUpTime(Date upTime) {
        this.upTime = upTime;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort == null ? null : sort.trim();
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