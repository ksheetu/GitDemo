package com.facebook.qa.base;

import java.io.FileInputStream;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.facebook.qa.util.TestUtil;




public class TestBase {
	public static WebDriver driver;
	public static Properties prop;
	public static long pageloadtime,implicitwait;
	public static FileInputStream file;
	public static TestUtil testutil;
	
	public TestBase()  {
		
		prop= new Properties();
		
		try {
			file = new FileInputStream("F:\\NaveenJavatraining\\FaceBookTest\\src\\main\\java\\com\\facebook\\qa\\config\\config.properties");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			prop.load(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
	public void initialize() {
		
		
		
		if (prop.getProperty("browser").contains("chrome")) {
			
			System.setProperty("webdriver.chrome.driver", "F:\\NaveenAutomationLab\\Selenium\\chromedriver_win32\\chromedriver.exe");
			driver= new ChromeDriver();
			
		}else if(prop.getProperty("browser").contains("FF")) {
			System.setProperty("webdriver.gecko.driver", "F:\\NaveenAutomationLab\\Selenium\\geckodriver-v0.29.0-win64\\geckodriver.exe");
			driver= new FirefoxDriver();
			
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		
		driver.manage().timeouts().pageLoadTimeout(Long.parseLong(prop.getProperty("pageloadtime")), TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Long.parseLong(prop.getProperty("implicitwaitTime")), TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
	}

}
