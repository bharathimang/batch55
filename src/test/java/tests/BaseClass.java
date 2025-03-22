package tests;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import utils.PropertyUntility;
import utils.ReportUtils;

public class BaseClass {
	
	public static WebDriver driver;
	public static Properties prop;
	
	public static ExtentSparkReporter sparkReport;
	public static ExtentReports report;
	public static ExtentTest test;
	
	
	@BeforeClass
	public void setup() throws Throwable {
		System.out.println("******************STARTING SETUP**********************");
		driver = new EdgeDriver();
		PropertyUntility property=new PropertyUntility();
		ReportUtils r = new ReportUtils();
		r.generateReport();
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));	
		
	}

	@AfterClass
	public void tearDown() {
		report.flush();
		driver.quit();
		System.out.println("******************EXECUTION ENDS*********************");
	}
}
