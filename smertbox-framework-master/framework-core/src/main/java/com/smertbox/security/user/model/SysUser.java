package com.smertbox.security.user.model;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.smertbox.util.page.model.PageModel;

public class SysUser extends PageModel implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private String userId;

    private String orgSid;
    
    private String orgname;

    private String loginAccount;

    private String username;

    private String passwd;

    private Short sex;

    private String theme;

    private String office;
    
    private String officename;

    private String tel;

    private String email;

    private Integer loginCount;

    private String photo;

    @DateTimeFormat(pattern="yyyy-MM-dd") 
    private Date birthday;

    private String ctUserId;

    private Date createTime;

    private String upUserId;

    private Date upTime;

    private Date loginTime;

    private Date lastLoginTime;

    private String queAnswer;

    private Short enablePosition;

    private Short roleEnableType;

    private String question;
    
    private Short ismanage;

    private String note;

    private Short allowEdit;

    private Short allowDel;

    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") 
    private Date beginCtTime;
    
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") 
    private Date endCtTime;
	
    private Short del;
    
    private String nowLoginAccount;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getOrgSid() {
        return orgSid;
    }

    public void setOrgSid(String orgSid) {
        this.orgSid = orgSid == null ? null : orgSid.trim();
    }

    public String getLoginAccount() {
        return loginAccount;
    }

    public void setLoginAccount(String loginAccount) {
        this.loginAccount = loginAccount == null ? null : loginAccount.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd == null ? null : passwd.trim();
    }

    public Short getSex() {
        return sex;
    }

    public void setSex(Short sex) {
        this.sex = sex;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme == null ? null : theme.trim();
    }

    public String getOffice() {
        return office;
    }

    public void setOffice(String office) {
        this.office = office == null ? null : office.trim();
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel == null ? null : tel.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public Integer getLoginCount() {
        return loginCount;
    }

    public void setLoginCount(Integer loginCount) {
        this.loginCount = loginCount;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo == null ? null : photo.trim();
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getCtUserId() {
        return ctUserId;
    }

    public void setCtUserId(String ctUserId) {
        this.ctUserId = ctUserId == null ? null : ctUserId.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
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

    public Date getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public String getQueAnswer() {
        return queAnswer;
    }

    public void setQueAnswer(String queAnswer) {
        this.queAnswer = queAnswer == null ? null : queAnswer.trim();
    }

    public Short getEnablePosition() {
        return enablePosition;
    }

    public void setEnablePosition(Short enablePosition) {
        this.enablePosition = enablePosition;
    }

    public Short getRoleEnableType() {
        return roleEnableType;
    }

    public void setRoleEnableType(Short roleEnableType) {
        this.roleEnableType = roleEnableType;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question == null ? null : question.trim();
    }
    
    public Short getIsmanage() {
        return ismanage;
    }

    public void setIsmanage(Short ismanage) {
        this.ismanage = ismanage;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
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

	public String getOrgname() {
		return orgname;
	}

	public void setOrgname(String orgname) {
		this.orgname = orgname;
	}

	public String getOfficename() {
		return officename;
	}

	public void setOfficename(String officename) {
		this.officename = officename;
	}

	public String getNowLoginAccount() {
		return nowLoginAccount;
	}

	public void setNowLoginAccount(String nowLoginAccount) {
		this.nowLoginAccount = nowLoginAccount;
	}

	
}