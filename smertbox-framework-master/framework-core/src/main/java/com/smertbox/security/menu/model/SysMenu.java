package com.smertbox.security.menu.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.smertbox.util.page.model.PageModel;

public class SysMenu extends PageModel{
	
    private String menuId;

    private String menuPid;
    
    private String menuPname;

    private String menuName;

    private String menuDesc;

    private String iconUrl;

    private String menuType;

    private String menuUrl;
    
    private String menuUrlValue;
    
    private String className;

    private String leftIconClass;

    private String titleClass;

    private String rightIconClass;

    private String sort;

    private Date createTime;

    private Short del;
    
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") 
    private Date beginCtTime;
    
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") 
    private Date endCtTime;

    public String getMenuId() {
        return menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId == null ? null : menuId.trim();
    }

    public String getMenuPid() {
        return menuPid;
    }

    public void setMenuPid(String menuPid) {
        this.menuPid = menuPid == null ? null : menuPid.trim();
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName == null ? null : menuName.trim();
    }

    public String getMenuDesc() {
        return menuDesc;
    }

    public void setMenuDesc(String menuDesc) {
        this.menuDesc = menuDesc == null ? null : menuDesc.trim();
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl == null ? null : iconUrl.trim();
    }

    public String getMenuType() {
        return menuType;
    }

    public void setMenuType(String menuType) {
        this.menuType = menuType == null ? null : menuType.trim();
    }

    public String getMenuUrl() {
        return menuUrl;
    }

    public void setMenuUrl(String menuUrl) {
        this.menuUrl = menuUrl == null ? null : menuUrl.trim();
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort == null ? null : sort.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
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

	public String getMenuPname() {
		return menuPname;
	}

	public void setMenuPname(String menuPname) {
		this.menuPname = menuPname;
	}

	public String getMenuUrlValue() {
		return menuUrlValue;
	}

	public void setMenuUrlValue(String menuUrlValue) {
		this.menuUrlValue = menuUrlValue;
	}
	
	public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className == null ? null : className.trim();
    }

    public String getLeftIconClass() {
        return leftIconClass;
    }

    public void setLeftIconClass(String leftIconClass) {
        this.leftIconClass = leftIconClass == null ? null : leftIconClass.trim();
    }

    public String getTitleClass() {
        return titleClass;
    }

    public void setTitleClass(String titleClass) {
        this.titleClass = titleClass == null ? null : titleClass.trim();
    }

    public String getRightIconClass() {
        return rightIconClass;
    }

    public void setRightIconClass(String rightIconClass) {
        this.rightIconClass = rightIconClass == null ? null : rightIconClass.trim();
    }
}