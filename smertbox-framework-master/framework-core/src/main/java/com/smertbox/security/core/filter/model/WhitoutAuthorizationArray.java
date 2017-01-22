package com.smertbox.security.core.filter.model;

import org.springframework.util.Assert;

/**
 * Author : ladeng
 * Time: 2016年8月28日 上午12:31:46
 * Desc : 无需访问控制权限的请求地址集合
 */
public class WhitoutAuthorizationArray {

	private String[] whitoutAuthorizations = new String[0];
	
	public void setWhitoutAuthorization(String whitoutAuthorization) {
		this.setWhitoutAuthorizations(whitoutAuthorizations);
	}
	
	public void setWhitoutAuthorizations(String... whitoutAuthorizations){
		if (whitoutAuthorizations != null) {
			this.whitoutAuthorizations = new String[whitoutAuthorizations.length];
			for (int i = 0; i < whitoutAuthorizations.length; i++) {
				String whitoutAuthorization = whitoutAuthorizations[i];
				Assert.hasText(whitoutAuthorization, "whitoutAuthorization must not be empty");
				this.whitoutAuthorizations[i] = whitoutAuthorization.trim();
			}
		}
		else {
			this.whitoutAuthorizations = new String[0];
		}
	}

	public String[] getWhitoutAuthorizations() {
		return whitoutAuthorizations;
	}
}
