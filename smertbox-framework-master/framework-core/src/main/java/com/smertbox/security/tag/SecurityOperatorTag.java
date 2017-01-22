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

public class SecurityOperatorTag extends TagSupport{

	private static final long serialVersionUID = 1L;
	private String action;

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
		if(StringUtils.isNotBlank(action)){
			outPutTag();
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
			if(this.action.equals(sysResources.getResUrl())){
				isPrint = true;
				break;
			}
		}
		if(isPrint){
			output.append("show");
		}
		
		JspWriter writer = this.pageContext.getOut();
		try {
			writer.println(output.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return output.toString();
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}
	
}

