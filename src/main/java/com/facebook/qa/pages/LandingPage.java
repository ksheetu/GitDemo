package com.facebook.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.facebook.qa.base.TestBase;



public class LandingPage extends TestBase {
	
	//PageFactory -Object Repository
	@FindBy(xpath="//input[@id='email']")
	WebElement EmailId;
	
	@FindBy(xpath="//input[@id='pass']")
	WebElement Pass;
	
	@FindBy(xpath="//button[@name='login']")
	WebElement LogInBtn;
	
	
	//Initializing Page Objects
	public LandingPage() {
		PageFactory.initElements(driver, this);
		
		
	}	

	//Actions
	
	public  String validateTitle() {
		return driver.getTitle();		
		
	}
	
	public  HomePage ClickOnLogIn() {
		EmailId.sendKeys(prop.getProperty("usernamedata"));
		Pass.sendKeys(prop.getProperty("passworddata"));
		LogInBtn.click();
		return new HomePage();
	}			
	
	
	
}
