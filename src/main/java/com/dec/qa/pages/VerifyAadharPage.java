package com.dec.qa.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.dec.qa.base.TestBase;

public class VerifyAadharPage extends TestBase
{
@FindBy(xpath="//button[contains(text(),'Skip')]")
WebElement skipButton;

@FindBy(xpath="//input[@type='text' and @name='aadhar']")
WebElement aadhaarValue;

@FindBy(xpath="//div[@class='editaadharbx']//button[@type='button']")
WebElement aadharEdit;

@FindBy(xpath="//button[contains(.,'OTP')]")
WebElement sendOtp;

@FindBy(xpath="//button[contains(.,'Previous')]")
WebElement previousButton;

@FindBy(xpath="//input[@type='text'] [@name='aadhaar_otp']")
WebElement otpText;

@FindBy(xpath="//button[contains(.,'Verify')]")
WebElement verifyOtpBtn;

@FindBy(xpath="//button[contains(.,'Skip')]")
WebElement skipBtn;

//Initializing PageObjects
public VerifyAadharPage() {
	PageFactory.initElements(driver, this);
	
}

public Boolean validateSendOtp()
{
	Boolean otpHit=sendOtp.isEnabled();
	Boolean skipClick=skipBtn.isEnabled();
	
    if(otpHit==true)
	{
	otpText.sendKeys("888888");
    verifyOtpBtn.click();
    }else {
    	skipBtn.click();
    	Alert alert=driver.switchTo().alert();
    	System.out.println(alert.getText());
    	
    }
	return skipClick;
    	
    }
    
	
	

}
