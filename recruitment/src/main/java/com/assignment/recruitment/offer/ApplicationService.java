package com.assignment.recruitment.offer;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.assignment.recruitment.database.DatabaseClass;

@Service
public class ApplicationService {
	
	
	private List<Application> applications = DatabaseClass.getApplications();
	private Map<Integer, Offer> offers = DatabaseClass.getOffers();
	
	public Application getApplication(String title,long id){
		Application app = null;
		for(Application application : applications) {
    		if((application.getId() == id) && (application.getRelatedOffer()).equals(title)) {
    			app = application;
    			break;
    		}
		}
		if (app == null)
			throw new NotFoundException();
		else
		return app;
}
	public List<Application> getApplications(String id) {
		
		List<Application> app = new ArrayList<>();
    	for(Application application : applications) {
    		if(application.getRelatedOffer().equals(id))
    			app.add(application);
    		}
		return app;	
	}
	public String addApplication(Application application) {
		boolean flag = true;
		for(Application app : applications) {
			if(app.getEmail().equals(application.getEmail()))
					flag = false;
			    break;   
		}
			if(!flag)
			   return "ALREADY EXIST";
			else {
				for(Map.Entry<Integer, Offer> entry : offers.entrySet()) {
					if(entry.getValue().getJobTitle().equals(application.getRelatedOffer())){
						entry.getValue().setNumberOfApplications(entry.getValue().getNumberOfApplications()+1);
						List<Application> app = entry.getValue().getApplist();
						application.setStatus("APPLIED");
						app.add(application);
						applications.add(application);
					}
				}
				return "APPLICATION SUBMITTED";
			}
	}
}
