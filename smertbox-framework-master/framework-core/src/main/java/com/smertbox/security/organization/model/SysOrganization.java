package com.smertbox.security.organization.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.smertbox.util.page.model.PageModel;

public class SysOrganization extends PageModel{
    private String orgId;

    private String orgPid;
    
    private String orgPname;

    private String orgName;

    private String orgDesc;

    private String country;

    private String province;

    private String city;

    private String district;

    private String addr;

    private String fax;

    private String postcode;

    private String innerTel;

    private String outerTel;

    private String charge;

    private String assistant;

    private String orgType;

    private String orgLevel;

    private String orgLogo;

    private String sort;

    private String ctUserId;

    private Date ctTime;

    private String upUserId;

    private Date upTime;

    private Short allowEdit;

    private Short allowDel;

    private String note;

    private Short del;
    
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") 
    private Date beginCtTime;
    
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") 
    private Date endCtTime;

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId == null ? null : orgId.trim();
    }

    public String getOrgPid() {
        return orgPid;
    }

    public void setOrgPid(String orgPid) {
        this.orgPid = orgPid == null ? null : orgPid.trim();
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName == null ? null : orgName.trim();
    }

    public String getOrgDesc() {
        return orgDesc;
    }

    public void setOrgDesc(String orgDesc) {
        this.orgDesc = orgDesc == null ? null : orgDesc.trim();
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country == null ? null : country.trim();
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province == null ? null : province.trim();
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district == null ? null : district.trim();
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr == null ? null : addr.trim();
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax == null ? null : fax.trim();
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode == null ? null : postcode.trim();
    }

    public String getInnerTel() {
        return innerTel;
    }

    public void setInnerTel(String innerTel) {
        this.innerTel = innerTel == null ? null : innerTel.trim();
    }

    public String getOuterTel() {
        return outerTel;
    }

    public void setOuterTel(String outerTel) {
        this.outerTel = outerTel == null ? null : outerTel.trim();
    }

    public String getCharge() {
        return charge;
    }

    public void setCharge(String charge) {
        this.charge = charge == null ? null : charge.trim();
    }

    public String getAssistant() {
        return assistant;
    }

    public void setAssistant(String assistant) {
        this.assistant = assistant == null ? null : assistant.trim();
    }

    public String getOrgType() {
        return orgType;
    }

    public void setOrgType(String orgType) {
        this.orgType = orgType == null ? null : orgType.trim();
    }

    public String getOrgLevel() {
        return orgLevel;
    }

    public void setOrgLevel(String orgLevel) {
        this.orgLevel = orgLevel == null ? null : orgLevel.trim();
    }

    public String getOrgLogo() {
        return orgLogo;
    }

    public void setOrgLogo(String orgLogo) {
        this.orgLogo = orgLogo == null ? null : orgLogo.trim();
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort == null ? null : sort.trim();
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

	public String getOrgPname() {
		return orgPname;
	}

	public void setOrgPname(String orgPname) {
		this.orgPname = orgPname;
	}
}