package com.facebook.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.facebook.qa.base.TestBase;



public class HomePage extends TestBase {

	
	@FindBy(xpath="//span[text()='Sheetal Sakhare']")
	WebElement UserLabel;
	
	
		

	
	

	
	
	public HomePage(){
		PageFactory.initElements(driver, this);
	}
	
	public String  VerifyLoginPageLoginIdTitle() {
		System.out.println(driver.getTitle());
		return driver.getTitle();
		
	}
	
	public String  VerifyUserLabel() {
		System.out.println(UserLabel.getText());
		return UserLabel.getText();
		
	}
	
	
}
