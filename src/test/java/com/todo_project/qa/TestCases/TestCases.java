package com.todo_project.qa.TestCases;

import java.net.MalformedURLException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.todo_project.qa.Base.BaseClass;
import com.todo_project.qa.Pages.HomePage;

public class TestCases extends BaseClass{
	
	HomePage home;
	
	@BeforeTest
	public void setup() throws MalformedURLException {
		
		initialisation();
		
	}
	
	@Test(priority=0)
	public void Case01_Verify_Titlename() {
		
		home =new HomePage();
		String actual_text=home.Verify_Title_Test();
		
		if(actual_text.equalsIgnoreCase("Todo")) {
			
			System.out.println("Case01 ----- PASSED");
		}else {
			
			System.out.println("Case01 ----- FAILED");
		}
		
		
	}
	
	@Test(priority=1)
	public void Case02_Verify_Add_New_Task() {
		
		String actual_task=home.Add_New_Task_Test("Test");
		
		System.out.println("actual text"+"------"+actual_task);
		if(actual_task.equalsIgnoreCase("Test")) {
			
			System.out.println("Case01 ----- PASSED");
			
		}else if(actual_task.equals(null)){
			
			System.out.println("Case01 ----- FAILED"+"  "+"No active Tasks available");
		}else {
			
			System.out.println("Case01 ----- FAILED"+"   "+"Task is not saved");
		}
		
	}
	
	@Test
	public void CAse03_Verify_Delete_Task() {
		
	}
	
	@AfterTest
	public void quit() {
	
		
		
	}

}
