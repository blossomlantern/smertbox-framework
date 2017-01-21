/**
 * @Title: SecurityButtonTag.java
 * @Package: com.wavenet.security.tag
 * @Description: for judge user whether have permission to operator that button,then show this button.
 * @author: LiFD
 * @date: 2015年3月23日 下午4:39:46
 * @version: V1.0
 */
package com.smertbox.security.tag;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import org.apache.commons.lang.StringUtils;
import org.springframework.security.core.context.SecurityContextHolder;

import com.smertbox.security.resource.model.SysResources;
import com.smertbox.security.user.model.SecurityUser;

public class SecurityIfElseTag extends TagSupport{

	private static final long serialVersionUID = 1L;
	private String url;
	private String ifValue;
	private String elseValue;

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
	public int doStartTag() throws JspException {
		if(StringUtils.isNotBlank(url)){
			outPutTag();//out put the html page info by user permission function.
			return EVAL_BODY_INCLUDE;
		}else{
			return SKIP_BODY;
		}
	}
	
	private String outPutTag(){
		StringBuffer output = new StringBuffer();
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
			output.append(this.ifValue);
		}else{
			output.append(this.elseValue);
		}
		
		JspWriter writer = this.pageContext.getOut();
		try {
			writer.println(output.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return output.toString();
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getIfValue() {
		return ifValue;
	}

	public void setIfValue(String ifValue) {
		this.ifValue = ifValue;
	}

	public String getElseValue() {
		return elseValue;
	}

	public void setElseValue(String elseValue) {
		this.elseValue = elseValue;
	}


}

