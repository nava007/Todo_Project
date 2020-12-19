package com.todo_project.qa.Base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;


public class BaseClass {
	
	public static AppiumDriver driver;
	public static Properties prop;
	public static DesiredCapabilities cap;
	String str="C:/MyWorkspace/Todo_Project/src/test/java/com/todo_project/qa/Config/config.properties";
	String locators_configfile="C:/MyWorkspace/Todo_Project/src/test/java/com/todo_project/qa/Config/locators";
	
	public BaseClass() {
		
		try {

			prop=new Properties();
			FileInputStream ip=new FileInputStream(str);
			prop.load(ip);
			

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}
	}
	
	public BaseClass(String locators_configfile) {
		
		try {

			prop=new Properties();
			FileInputStream ip=new FileInputStream(locators_configfile);
			prop.load(ip);
			

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}
		
	}
	public void initialisation() throws MalformedURLException {
		
		cap =new DesiredCapabilities();
		cap.setCapability("deviceName", "Moto G Plus");
		cap.setCapability("udid", "ZY322L223D");
		cap.setCapability("platformName", "Android");
		cap.setCapability("platformVersion", "8.1.0");
		cap.setCapability("noReset", "true");
		cap.setCapability("fullReset", "false");
				
		cap.setCapability("appPackage", prop.getProperty("packagename"));
		cap.setCapability("appActivity", prop.getProperty("activityname"));
		
		URL url =new URL("http://127.0.0.1:4723/wd/hub");
		driver=new AppiumDriver<WebElement>(url,cap);
	}

}
