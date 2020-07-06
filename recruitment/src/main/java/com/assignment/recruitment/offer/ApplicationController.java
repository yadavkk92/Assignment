package com.assignment.recruitment.offer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApplicationController {

	@Autowired
	private ApplicationService applicationservice;
	
	@RequestMapping("/offers/{id}/applications")
	  public List<Application> getApplications(@PathVariable String id){
		  return applicationservice.getApplications(id);
		  }
	  
	  @RequestMapping("/offers/{title}/applications/{id}")
	  public Application getApplication(@PathVariable("title") String title,@PathVariable("id") long id) {
		  return applicationservice.getApplication(title,id);
	  }
	  
	  @RequestMapping(method = RequestMethod.POST, value="/applications") 
	  public void addOffer(@RequestBody Application application) { 
		  applicationservice.addApplication(application);
		  }
	 
}