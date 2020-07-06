package com.assignment.recruitment.database;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.assignment.recruitment.offer.Application;
import com.assignment.recruitment.offer.Offer;

public class DatabaseClass {

	private static Map<Integer,Offer> offers = new HashMap<>();
	private static ArrayList<Application> applications = new ArrayList<>();
	private static ArrayList<Application> applications2 = new ArrayList<>();
	
	static{
		applications.add(new Application(1L,"Java","kamal@gmail.com","5 yrs experienced beckend java developer",Application.HIRED));
	    applications.add(new Application(2L,"Java","pankaj@gmail.com","Java Spring developer with angular",Application.INVITED));
	    
	    applications2.add(new Application(3L,"Python","rahul@gmail.com","Python developer",Application.INVITED));
		offers.put(1,new Offer("Java","2020-07-21",2,applications));
	    offers.put(2,new Offer("Python","2020-07-15",1,applications2));
	    
	}   
	
	public static Map<Integer, Offer> getOffers(){
		return offers;
	}
	public static List<Application> getApplications(){
		List<Application> applications = new ArrayList<>(); 
		for(Offer offers : offers.values())
		{
			applications.addAll(offers.getApplist());
		}
		return applications;
	}
}
