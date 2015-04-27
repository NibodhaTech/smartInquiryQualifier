/**
 * 
 */
package com.nibodha.ear.web.model;


/**
 * @author Suresh Kumar S
 *
 */
public class Score implements Comparable<Score>{
	
	private String emailId;
	private double score;
	
	/**
	 * 
	 */
	public Score() {
		super();
	}
	
	
	
	/**
	 * @param emailId
	 * @param score
	 */
	public Score(String emailId, double score) {
		super();
		this.emailId = emailId;
		this.score = score;
	}



	/**
	 * @return the emailId
	 */
	public String getEmailId() {
		return emailId;
	}
	/**
	 * @param emailId the emailId to set
	 */
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	
	/**
	 * @return the score
	 */
	public double getScore() {
		return score;
	}
	/**
	 * @param score the score to set
	 */
	public void setScore(double score) {
		this.score = score;
	}
	@Override
	public int compareTo(Score score) {
		return Double.compare(score.getScore(), this.getScore());
	}
	
	
}
