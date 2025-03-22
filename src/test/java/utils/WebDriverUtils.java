package utils;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import tests.BaseClass;

public class WebDriverUtils extends BaseClass{
	
	//
	public void selectTheDropdownUsingVisibleText(WebElement ele, String text) {
		Select s=new Select(ele);
		s.selectByVisibleText(text);
	}
	
	public void selectTheDropdownUsingValue(WebElement ele, String value) {
		Select s=new Select(ele);
		s.selectByValue(value);
	}
	
	public void selectTheDrodpwnUsingIndex(WebElement ele, int index) {
		Select s=new Select(ele);
		s.selectByIndex(index);
		
	}
	
	public void waitUntilSpecificElementisDisplayed(WebElement targetEle) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(targetEle));
	}
	
	public void captureScreenshot(String fileName) throws Throwable {
		TakesScreenshot ss = (TakesScreenshot) driver;
		File src = ss.getScreenshotAs(OutputType.FILE);
		File dest = new File("src/test/resources/Output/"+fileName+".png");
		FileHandler.copy(src, dest);
	}
	
	// iframe
	
	
	// windows
	
	
	// action
	
	// explicit wait

}
