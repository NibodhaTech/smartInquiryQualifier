/**
 * 
 */
package com.nibodha.smart.inquiry.qualifier.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Suresh Kumar S
 *
 */
public class Entity {
	
	private String productURL;
	private List<String> emailIds;
	
	/**
	 * @return the productURL
	 */
	public String getProductURL() {
		return productURL;
	}
	/**
	 * @param productURL the productURL to set
	 */
	public void setProductURL(String productURL) {
		this.productURL = productURL;
	}
	/**
	 * @return the emailIds
	 */
	public List<String> getEmailIds() {
		if(emailIds == null) return new ArrayList<String>();
		return emailIds;
	}
	/**
	 * @param emailIds the emailIds to set
	 */
	public void setEmailIds(List<String> emailIds) {
		this.emailIds = emailIds;
	}
	
}
