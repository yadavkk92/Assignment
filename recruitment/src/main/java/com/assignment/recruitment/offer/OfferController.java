package com.assignment.recruitment.offer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OfferController {
	
	@Autowired
	private OfferService offerservice;

 @RequestMapping("/offers")
 public List<Offer> getAllOffers(){
	System.out.print(offerservice.getAllOffers());	
	return offerservice.getAllOffers();
 }

  @RequestMapping("/offers/{id}") 
  public Offer getOffer(@PathVariable String id){
	  System.out.print(id);
	  return offerservice.getOffer(id); }
  
  @RequestMapping(method = RequestMethod.POST, value="/offers") 
  public void addOffer(@RequestBody Offer offer) { 
	  offerservice.addOffer(offer);
	  }
  
}