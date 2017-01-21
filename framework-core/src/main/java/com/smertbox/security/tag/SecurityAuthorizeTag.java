/**
 * @Title: SecurityMenu.java
 * @Package: com.wavenet.security.tag
 * @Description: TODO(one statement description this file function)
 * @author: LiFD
 * @date: 2015年3月25日 上午11:08:59
 * @version: V1.0
 */
package com.smertbox.security.tag;

import java.util.Iterator;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyContent;
import javax.servlet.jsp.tagext.BodyTagSupport;

import org.springframework.security.core.context.SecurityContextHolder;

import com.smertbox.security.resource.model.SysResources;
import com.smertbox.security.user.model.SecurityUser;

public class SecurityAuthorizeTag extends BodyTagSupport{
	private static final long serialVersionUID = 1L;
	private String url;
	
	@Override
	public int doAfterBody() throws JspException {
		// TODO Auto-generated method stub
		return super.doAfterBody();
	}

	@Override
	public int doEndTag() throws JspException {
		// TODO Auto-generated method stub
		return super.doEndTag();
	}

	@Override
	public void doInitBody() throws JspException {
		// TODO Auto-generated method stub
		super.doInitBody();
	}

	@Override
	public int doStartTag() throws JspException {
		SecurityUser user = (SecurityUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		List<SysResources> resourceList = user.getResources();
		Iterator<SysResources> ite = resourceList.iterator();
		boolean isPrint = false;
		while(ite.hasNext()){
			SysResources sysResources = ite.next();
			if(this.url.equals(sysResources.getResUrl())){
				isPrint = true;
				break;
			}
		}
		if(isPrint){
			return EVAL_BODY_INCLUDE;
		}else{
			return SKIP_BODY;
		}
	}

	@Override
	public void setBodyContent(BodyContent b) {
		// TODO Auto-generated method stub
		super.setBodyContent(b);
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
}

