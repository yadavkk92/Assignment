package com.assignment.recruitment.offer;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ApplicationServiceTest {
	
	ApplicationService appser = new ApplicationService();

	@Test
	void test() {
		Application application = new Application();
		application.setEmail("yash@gmail.com");
		application.setRelatedOffer("Java");
		application.setResume("Java JAVA JAVA");
		application.setStatus("APPLIED");
		String actual = appser.addApplication(application);
		String expected = "APPLICATION SUBMITTED";
		assertEquals(expected, actual, "Application has been submitted Successfully");
	}

}
