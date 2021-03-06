package com.dec.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.dec.qa.base.TestBase;

public class UserProfilePage extends TestBase
{


	
    //Initializing PageObjects
	
	public UserProfilePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	
	public boolean validateApplyNowButton() {
		
		
		
	String cardApply=driver.findElement(By.xpath("//div[@class='yourcardtext1' and contains (.,'Not Applied')]")).getText();
	
		System.out.println("Status OF DEC Card Application :" +cardApply);
		
	if(cardApply.contains("APPLY NOW")){
	System.out.println("You have Not Applied for Kissht Digital EMI Card." +"\n "+" APPLY NOW");

	//driver.findElement(By.partialLinkText("//a[contains(text(),'Apply Now')]")).getTagName();
	driver.findElement(By.xpath("//a[contains(text(),'Apply Now')]")).click();
	//return driver.findElement(By.xpath("//a[contains(text(),'Apply Now')]")).isEnabled();
	}else {
	System.out.println("You have already applied for EMI Card"); 
    }
		
		
		String applyNowPage=driver.getWindowHandle();
		System.out.println("ID of applyNowPage is" + applyNowPage);
		return false;
		
		
		//for(String win:driver.getWindowHandles())
		//{
		//	driver.switchTo().window(win);
			
		//}
		
	}
	
	
}
