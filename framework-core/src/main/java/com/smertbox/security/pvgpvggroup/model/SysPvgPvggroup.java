package com.smertbox.security.pvgpvggroup.model;

import java.util.Date;

public class SysPvgPvggroup {
    private String id;

    private String pgId;

    private String pvgId;

    private Date createTime;

    public String getId() {
        return id;
    }

    public String getPgId() {
		return pgId;
	}

	public void setPgId(String pgId) {
		this.pgId = pgId;
	}

	public void setId(String id) {
        this.id = id == null ? null : id.trim();
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
}