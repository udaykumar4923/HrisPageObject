package com.qait.automation.HrisPageObject;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import junit.framework.Assert;

import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class HrisPageobjectautomation {
    WebDriver driver;
    
    LoginForm loginForm;
    
    @Test
    public void attemptLoginWithIncorrectPasswordShouldRenderErrorMessage(){
        Assert.assertTrue(loginForm
                .loginWithIncorrectCredentials("invalid username", "invalid password").contains("Invalid Login"));
    }
    
   @Test(dependsOnMethods= {"attemptLoginWithIncorrectPasswordShouldRenderErrorMessage"})
    public void attemptLoginWithNoPasswordShouldAnnotateBlackPasswordField(){
        loginForm.login("udaykumar", "");
       Assert.assertTrue(loginForm.isPasswordEntryAnnotated());  
    }
  
   @Test(dependsOnMethods= {"attemptLoginWithNoPasswordShouldAnnotateBlackPasswordField"})
   public void attemptLoginWithCorrectCredentials() {
	   Assert.assertTrue(loginForm.loginWithCorrectCredentials("udaykumar","Uday@321#").isElementDisplayed());
   }
    
    @BeforeClass
    public void launchBrowser(){
        driver = new ChromeDriver();
        driver.get("https://hris.qainfotech.com");
        loginForm = new LoginForm(driver);
    }
    
    @AfterClass
    public void closeBrowser(){
        driver.quit();
    }
	
	
	
	
	

}
