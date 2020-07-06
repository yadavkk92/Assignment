package com.assignment.recruitment.offer;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public class Offer {

	
	  private String jobTitle; 
	//  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "YYYY-MM-DD")
	  private String startDate; 
	  private int numberOfApplications;
	  @JsonIgnoreProperties("applist")
	  private ArrayList<Application> applist;
	  
	public Offer(String jobTitle, String startDate, int numberOfApplications, ArrayList<Application> applist) {
		super();
		this.jobTitle = jobTitle;
		this.startDate = startDate;
		this.numberOfApplications = numberOfApplications;
		this.applist = applist;
	}
	public Offer() {
		// TODO Auto-generated constructor stub
	}

	public String getJobTitle() {
		return jobTitle;
	}
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public int getNumberOfApplications() {
		return numberOfApplications;
	}
	public void setNumberOfApplications(int numberOfApplications) {
		this.numberOfApplications = numberOfApplications;
	}
	@JsonIgnore
	public ArrayList<Application> getApplist() {
		return applist;
	}
	public void setApplist(ArrayList<Application> applist) {
		this.applist = applist;
	}
	 

}
