package tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import pages.AccountInformation;
import pages.ConfirmationPage;
import pages.SignUpPage;

public class SignUpTestCase extends BaseClass{

	
	// Field validations
	// do sign up
	// verify sign up
	

	@Test
	public void signUp() throws Throwable {
			
		try {
			SignUpPage sp=new SignUpPage(BaseClass.driver);
			sp.enterSignUpDetails(prop.getProperty("username"), prop.getProperty("email"));
			sp.clickOnSignUpButton();
			test.log(Status.PASS, "SignUp Passed");
		} catch (Exception e) {
			test.log(Status.FAIL, "SignUp Failed");
		}

		try {
		AccountInformation ai=new AccountInformation(BaseClass.driver);
		ai.validateTheFields();
		ai.fillTheForm();
		test.log(Status.PASS, "Account Information Page is PASSED");
		}
		catch(Exception e) {
			test.log(Status.FAIL, "Account Information Page is Failed");
		}
		
		try {
			ConfirmationPage cp=new ConfirmationPage(BaseClass.driver);
			cp.verifyAccountCreation();
			cp.clickOnContinue();
			test.log(Status.PASS, "Confirmation Page Failed");
		} catch (Exception e) {
			test.log(Status.FAIL, "Confirmation Page Failed");
		}
/*
		TakesScreenshot ss = (TakesScreenshot) driver;
		File src = ss.getScreenshotAs(OutputType.FILE);
		File dest = new File("C:\\Users\\bhara\\BTS\\Trainings\\Automation\\Screenshots\\firstimg.png");
		FileHandler.copy(src, dest);
*/
	}

}
