package pages;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import utils.ExcelUtils;
import utils.WebDriverUtils;

public class AccountInformation {

	public static WebDriver driver;
	public static WebDriverUtils webdriver;

	public AccountInformation(WebDriver remoteDriver) {
		driver = remoteDriver;
		PageFactory.initElements(driver, this);
		webdriver=new WebDriverUtils();
	}

	@FindBy(xpath = "//input[@id='id_gender2']")
	WebElement gender;

	@FindBy(xpath = "//select[@id='days']")
	WebElement day;

	@FindBy(xpath = "//select[@id='months']")
	WebElement month;

	@FindBy(xpath = "//select[@id='years']")
	WebElement year;

	public void validateTheFields() throws Throwable {
	
		Assert.assertTrue(gender.isDisplayed(), "Gender is not displayed");

		Assert.assertTrue(day.isDisplayed(), "Day is not displayed");

		Assert.assertTrue(month.isDisplayed());

		Assert.assertTrue(year.isDisplayed());
		
		webdriver.captureScreenshot("fieldValidation");
	}

	public void fillTheForm() throws Throwable {

		ExcelUtils excel = new ExcelUtils();
		XSSFSheet sheet=excel.readSheet("userdetails");

		gender.click();
	
		webdriver.selectTheDropdownUsingValue(day, "9");
		webdriver.selectTheDrodpwnUsingIndex(month, 9);
		webdriver.selectTheDropdownUsingValue(year, "2018");

		WebElement userpassword = driver.findElement(By.xpath("//input[@id='password']"));
		userpassword.sendKeys(excel.readData(sheet,0, 0));
		Thread.sleep(5000);
		WebElement checkOne = driver.findElement(By.xpath("//input[@name='newsletter']"));
		checkOne.click();
		WebElement checkTwo = driver.findElement(By.xpath("//input[@name='optin']"));
		checkTwo.click();
		WebElement userName = driver.findElement(By.xpath("//input[@id='first_name']"));
		userName.sendKeys(excel.readData(sheet, 1, 0));
		
		WebElement userLname = driver.findElement(By.xpath("//input[@id='last_name']"));
		userLname.sendKeys(excel.readData(sheet, 2, 0));

		WebElement company = driver.findElement(By.xpath("//input[@id='company']"));
		company.sendKeys(excel.readData(sheet, 3, 0));

		WebElement address = driver.findElement(By.xpath("//input[@id='address1']"));
		address.sendKeys(excel.readData(sheet, 4, 0));

		WebElement addressTwo = driver.findElement(By.xpath("//input[@id='address2']"));
		addressTwo.sendKeys(excel.readData(sheet, 5, 0));

		WebElement country = driver.findElement(By.xpath("//select[@id='country']"));
		Select s4 = new Select(country);
		s4.selectByValue(excel.readData(sheet, 10, 0));
		
		Assert.assertEquals("India", excel.readData(sheet, 10, 0));

		WebElement userstate = driver.findElement(By.xpath("//input[@id='state']"));
		userstate.sendKeys(excel.readData(sheet, 6, 0));

		WebElement usercity = driver.findElement(By.xpath("//input[@id='city']"));
		usercity.sendKeys(excel.readData(sheet, 7, 0));

		WebElement userzip = driver.findElement(By.xpath("//input[@id='zipcode']"));
		userzip.sendKeys(excel.readData(sheet, 8, 0));

		WebElement mobilenum = driver.findElement(By.xpath("//input[@id='mobile_number']"));
		mobilenum.sendKeys(excel.readData(sheet, 9, 0));
		
		webdriver.captureScreenshot("dataEntry");

		WebElement button = driver.findElement(By.xpath("//button[text()='Create Account']"));
		button.click();
		
		webdriver.captureScreenshot("formSubmission");
	}

}
