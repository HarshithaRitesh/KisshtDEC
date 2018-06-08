package com.dec.qa.pages;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.dec.qa.base.TestBase;

public class AadhaarDetailsPage extends TestBase {
	
	//PageFactory 
	@FindBy(xpath="//input[@type='text' and @name='pan']")
	WebElement userPan; 
	
	@FindBy(xpath="//input[@type='text' and @name='aadhar_no']")
    WebElement aadhaar;
	
	@FindBy(xpath="//div[@id='aadharVerified']//button[contains(text(),'Next')]")
	WebElement nextButton;

	public AadhaarDetailsPage() 
	{
		PageFactory.initElements(driver, this);
	}
	
	public String validatePanFormat(String uPan)
	{
		userPan.sendKeys(uPan);
		Pattern pattern=Pattern.compile("[A-Z]{5}[0-9]{4}[A-Z]{1}");
		Matcher matcher=pattern.matcher(uPan);
		if(matcher.matches())
		{
			System.out.println("Pan format is appropriate");
		}
		else
		{
			System.out.println("Incorrect PAN Format");
		}
		
		return uPan;
		}
	
    public void validateAadhaarFormat(String uAadhaar)
	{
		aadhaar.sendKeys(uAadhaar);
		if(uAadhaar.length()==12 )
			System.out.println("Aadhaar Number must contain 12 digits");
	}
	
	public Boolean validateNextButton()
	{
		nextButton.click();
		return nextButton.isEnabled();
		
		
	}
}