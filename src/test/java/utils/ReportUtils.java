package utils;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import tests.BaseClass;

public class ReportUtils extends BaseClass {
	
	
	@Test
	public void generateReport() {
		
		// 1. Report type - ExtentSparkReporter
		// 2. Report type needs to be attached ExtentReports Object
		// 3. Create the test
		// 4. Log the events
		sparkReport=new ExtentSparkReporter("src/test/resources/reports/demo.html");
		report=new ExtentReports();
		report.attachReporter(sparkReport);		
		test=report.createTest("Regression");

		
		
	}

}
