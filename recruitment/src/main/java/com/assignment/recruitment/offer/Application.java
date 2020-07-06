package com.assignment.recruitment.offer;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Application {

	private long id;
	private String relatedOffer;
	private String email;
	private String resume;
	private String status;
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public static final String APPLIED = "APPLIED";
	public static final String INVITED = "INVITED";
	public static final String REJECTED = "REJECTED";
	public static final String HIRED = "HIRED";
	
	
	@JsonIgnore
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getRelatedOffer() {
		return relatedOffer;
	}
	public void setRelatedOffer(String relatedOffer) {
		this.relatedOffer = relatedOffer;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getResume() {
		return resume;
	}
	public void setResume(String resume) {
		this.resume = resume;
	}
	public Application(long id,String relatedOffer, String email, String resume, String status) {
		super();
		this.id = id;
		this.relatedOffer = relatedOffer;
		this.email = email;
		this.resume = resume;
		this.status = status;
	}
	public Application() {
		
	}
	
}
