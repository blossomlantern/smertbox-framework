package com.smertbox.security.rolegroup.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.smertbox.util.page.model.PageModel;

public class SysRolegroup extends PageModel{
	
    private String rgId;

    private String rgName;

    private String rgDesc;

    private Date createTime;

    private String note;

    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") 
    private Date beginCtTime;
    
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") 
    private Date endCtTime;
    
    public String getRgId() {
        return rgId;
    }

    public void setRgId(String rgId) {
        this.rgId = rgId == null ? null : rgId.trim();
    }

    public String getRgName() {
        return rgName;
    }

    public void setRgName(String rgName) {
        this.rgName = rgName == null ? null : rgName.trim();
    }

    public String getRgDesc() {
        return rgDesc;
    }

    public void setRgDesc(String rgDesc) {
        this.rgDesc = rgDesc == null ? null : rgDesc.trim();
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