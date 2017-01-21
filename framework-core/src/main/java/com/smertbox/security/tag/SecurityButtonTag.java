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

public class SecurityButtonTag extends TagSupport{

	private static final long serialVersionUID = 1L;
	private String type;
	private String css;
	private String name;
	private String id;
	private String style;
	private String label;
	private String action;
	private String permission;
	private String onclick;

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
			if(this.action.equals(sysResources.getResUrl())){
				isPrint = true;
				break;
			}
		}
		if(isPrint){
			output.append("<button");
			output.append(" name=\""+ (this.name==null?"":this.name) +"\"");
			output.append(" type=\""+ (this.type==null?"":this.type) +"\"");
			output.append(" class=\""+ (this.css==null?"":this.css) +"\"");
			output.append(" id=\""+ (this.id==null?"":this.id) +"\"");
			output.append(" onclick=\""+ (this.onclick==null?"":this.onclick) +"\"");
			output.append(" style=\""+ (this.style==null?"":this.style) +"\"");
			output.append(" >");
			output.append(""+ (this.label==null?"":this.label) +"");
			output.append("</button>");
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

	public String getPermission() {
		return permission;
	}

	public void setPermission(String permission) {
		this.permission = permission;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCss() {
		return css;
	}

	public void setCss(String css) {
		this.css = css;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getStyle() {
		return style;
	}

	public void setStyle(String style) {
		this.style = style;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getOnclick() {
		return onclick;
	}

	public void setOnclick(String onclick) {
		this.onclick = onclick;
	}
	
}

