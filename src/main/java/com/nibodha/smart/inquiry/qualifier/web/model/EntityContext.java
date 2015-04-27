/**
 * 
 */
package com.nibodha.ear.web.model;

import java.util.List;

/**
 * @author Suresh Kumar S
 *
 */
public class EntityContext {
	private String productURL;
	private List<Score> scores;
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
	 * @return the scores
	 */
	public List<Score> getScores() {
		return scores;
	}
	/**
	 * @param scores the scores to set
	 */
	public void setScores(List<Score> scores) {
		this.scores = scores;
	}
	
}
