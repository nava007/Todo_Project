package com.todo_project.qa.Pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.todo_project.qa.Base.BaseClass;

public class HomePage extends BaseClass {
	
	int i;
	
	public HomePage() {
		
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="(//android.widget.TextView)[1]")
	WebElement todo;
	
	@FindBy(id="com.example.android.architecture.blueprints.usecases.mock:id/add_task_fab")
	WebElement Add_button;
	
	@FindBy(id="com.example.android.architecture.blueprints.usecases.mock:id/add_task_title_edit_text")
	WebElement Title_text;
	
	@FindBy(id="com.example.android.architecture.blueprints.usecases.mock:id/add_task_description_edit_text")
	WebElement Title_desc;
	
	@FindBy(id="com.example.android.architecture.blueprints.usecases.mock:id/save_task_fab")
	WebElement save;
	
	@FindBy(xpath="//androidx.recyclerview.widget.RecyclerView//android.widget.LinearLayout//android.widget.TextView")
	List<WebElement> alltask;
	
	
	public String Verify_Title_Test() {
		
		String title=todo.getText();
		System.out.println(title);
		return title;
	}
	
	public String Add_New_Task_Test(String text1) {
		
		Add_button.click();
		Title_text.click();
		Title_text.sendKeys(text1);
		Title_desc.click();
		Title_desc.sendKeys(text1);
		driver.navigate().back();
		save.click();
		
		if(alltask.size()!=0) {
		for(i=0;i<alltask.size();i++) {
			
			if(alltask.get(i).getText().equalsIgnoreCase(text1)) {
				break;
			}
		}
		
		return alltask.get(i).getText();
		
		}else {
			
			return null;
		}
	}
	
	public void Delete_Task() {
		
		
		
		
		
		
		
	}

}
