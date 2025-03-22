package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import utils.PropertyUntility;

public class ConfirmationPage {
	public static WebDriver driver;
	
	public ConfirmationPage(WebDriver remoteDriver) {
		driver = remoteDriver;
		PageFactory.initElements(driver, this);
	}
	
	public void verifyAccountCreation() {
		WebElement accountCreation=driver.findElement(By.xpath("//b[text()='Account Created!']"));
		if(accountCreation.isDisplayed())
		{
			System.out.println("Account is created successfully");
		}
	}
	
	public void clickOnContinue() {
		WebElement continueBtn=driver.findElement(By.xpath("//a[text()='Continue']"));
		continueBtn.click();
	}
	
	public void writeTheUnameAndPwdInProperty() throws Throwable{
		PropertyUntility property=new PropertyUntility();
		property.writeDataPropertyFile("uname","");
		property.writeDataPropertyFile("pwd","");
	}

}
