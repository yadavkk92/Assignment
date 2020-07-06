package com.assignment.recruitment.offer;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.assignment.recruitment.database.DatabaseClass;

@Service
public class OfferService {
	
	private Map<Integer, Offer> offers = DatabaseClass.getOffers();
	
    public List<Offer> getAllOffers(){
    	List<Offer> alloffers = new ArrayList<>(offers.values());
    	return alloffers;
			
    }
	
	public Offer getOffer(String id) {
        Offer offer =null;
            for(Offer o : offers.values()) {
			if(o.getJobTitle().equals(id)) {
				offer = new Offer();
				offer.setJobTitle(id);
				offer.setStartDate(o.getStartDate());
				offer.setNumberOfApplications(o.getNumberOfApplications());
				break;
				}
		}
            if(offer == null) 
            	throw new NotFoundException();
            else
		return offer;
		
	 }
	  public void addOffer(Offer offer) { 
		  boolean flag = true;
		  for(Offer o : offers.values()) {
			  if(o.getJobTitle().equals(offer.getJobTitle()))
				  flag = false;
		  }
		  if(flag== true)
		  offers.put(offers.size()+1,new Offer(offer.getJobTitle(),offer.getStartDate(),0,null));
		  }
	  
	  }
	 
