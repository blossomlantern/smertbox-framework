package com.smertbox.security.privilege.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.smertbox.util.page.model.PageModel;

public class SysPrivilege extends PageModel {
    private String pvgId;

    private String pvgPid;
    
    private String pvgPidName;
    
    private String resName;

    private String pvgName;

    private String pvgType;

    private String pvgDesc;

    private Short allowEdit;

    private Short allowDel;

    private String ctUserId;

    private Date ctTime;
    
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") 
    private Date beginCtTime;
    
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") 
    private Date endCtTime;
    
    private String upUserId;

    private Date upTime;

    private String sort;

    private String note;

    private Short del;

    public String getPvgId() {
        return pvgId;
    }

    public void setPvgId(String pvgId) {
        this.pvgId = pvgId == null ? null : pvgId.trim();
    }

    public String getPvgPid() {
        return pvgPid;
    }

    public void setPvgPid(String pvgPid) {
        this.pvgPid = pvgPid == null ? null : pvgPid.trim();
    }

    public String getPvgName() {
        return pvgName;
    }

    public void setPvgName(String pvgName) {
        this.pvgName = pvgName == null ? null : pvgName.trim();
    }

    public String getPvgType() {
        return pvgType;
    }

    public void setPvgType(String pvgType) {
        this.pvgType = pvgType == null ? null : pvgType.trim();
    }

    public String getPvgDesc() {
        return pvgDesc;
    }

    public void setPvgDesc(String pvgDesc) {
        this.pvgDesc = pvgDesc == null ? null : pvgDesc.trim();
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

	public Date getBeginCtTime() {
		return beginCtTime;
	}

	public void setBeginCtTime(Date beginCtTime) {
		this.beginCtTime = beginCtTime;
	}

	public Date getEndCtTime() {
		return endCtTime;
	}

	public void setEndCtTime(Date endCtTime) {
		this.endCtTime = endCtTime;
	}

	public String getPvgPidName() {
		return pvgPidName;
	}

	public void setPvgPidName(String pvgPidName) {
		this.pvgPidName = pvgPidName;
	}

	public String getResName() {
		return resName;
	}

	public void setResName(String resName) {
		this.resName = resName;
	}
}