package com.smertbox.security.pvggroup.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.smertbox.util.page.model.PageModel;

public class SysPvggroup extends PageModel{
    private String pgId;

    private String pgName;

    private String pgDesc;

    private Date createTime;

    private String note;
    
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") 
    private Date beginCtTime;
    
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") 
    private Date endCtTime;

    public String getPgId() {
        return pgId;
    }

    public void setPgId(String pgId) {
        this.pgId = pgId == null ? null : pgId.trim();
    }

    public String getPgName() {
        return pgName;
    }

    public void setPgName(String pgName) {
        this.pgName = pgName == null ? null : pgName.trim();
    }

    public String getPgDesc() {
        return pgDesc;
    }

    public void setPgDesc(String pgDesc) {
        this.pgDesc = pgDesc == null ? null : pgDesc.trim();
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
}