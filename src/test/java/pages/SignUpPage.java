package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class SignUpPage {
	public static WebDriver ldriver;
	
	public SignUpPage(WebDriver driver){
		ldriver=driver;
		PageFactory.initElements(ldriver, this);
	}
	
	@FindBy(xpath="//input[@type='text']")
	WebElement uname;
	
	@FindBy(xpath="//input[@data-qa='signup-email']")
	WebElement emailid;
	
	@FindBy(xpath="//button[@data-qa='signup-button']")
	WebElement signUpButton;
	
	
	public void enterSignUpDetails(String uName, String pwd) {
		try {
		uname.sendKeys(uName);
		emailid.sendKeys(pwd);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			Assert.fail();
		}
	}
	
	public void clickOnSignUpButton() {
		try {
		signUpButton.click();
		
		// take out the message from error element
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			Assert.fail();
		}
	}
	
	public void login() {
		
	}

}
