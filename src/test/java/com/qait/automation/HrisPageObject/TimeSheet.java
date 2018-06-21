package com.qait.automation.HrisPageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TimeSheet {
	WebDriver driver;
	
	public TimeSheet(WebDriver driver) {
		this.driver = driver;
	}
	
	private WebElement getWebElementtOnTimeSheet() {
		return this.driver.findElement(By.id("dvSearchBox"));
	}
	
	public boolean isElementDisplayed() {
		String WebElementOnTimeSheetToCheck = getWebElementtOnTimeSheet().getAttribute("class");
		return WebElementOnTimeSheetToCheck.equals("search-box");
	}
}