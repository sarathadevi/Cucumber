package com.abc.runner;


import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;
import net.masterthought.cucumber.Reportable;
import net.masterthought.cucumber.json.support.Status;
import net.masterthought.cucumber.presentation.PresentationMode;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/features",
		glue = {"com.abc.steps"},
		tags = "@para",
		dryRun = false,
		publish = false,
		plugin = {"json:target/cucumber/report.json"}
		
		) 

public class JUnitRunner {
	
	@AfterClass
	
	public static void reportSetup() {
		//json file
		File reportOD = new File("target");
		List<String> jsonFile = new ArrayList<>();
		jsonFile.add("target/cucumber/report.json");
		String buildNumber = "1";
		String projectName = "My_Project_Name";


		Configuration configuration = new Configuration(reportOD, projectName);
configuration.addPresentationModes(PresentationMode.RUN_WITH_JENKINS);

		configuration.setNotFailingStatuses(Collections.singleton(Status.SKIPPED));
		configuration.setBuildNumber(buildNumber);
configuration.addClassifications("Platform", "Windows");
		configuration.addClassifications("Browser", "Chrome");
		configuration.addClassifications("Branch", "release/1.0");
ReportBuilder reportBuilder=new ReportBuilder(jsonFile,configuration);
		  Reportable result =reportBuilder.generateReports();
		
	}
	

}
