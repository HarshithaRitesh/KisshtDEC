package com.dec.qa.pages;

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

@FindBy(xpath="")
WebElement aadharEdit;

@FindBy(xpath="//button[contains(.,'OTP')]")
WebElement sendOtp;

@FindBy(xpath="//button[contains(.,'Previous')]")
WebElement previousButton;

//Initializing PageObjects
public VerifyAadharPage() {
	PageFactory.initElements(driver, this);
}

public Boolean validateSendOtpCheck()
{
	sendOtp.click();
	return sendOtp.isEnabled();
}
}
