package com.dec.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.dec.qa.base.TestBase;

public class LoginPage extends TestBase{

	//PageFactory - OR Need to define PF or OR of Login Page
	@FindBy(name="email")
	WebElement email;
	
	@FindBy(name="first_name")
	WebElement fName;
	
	@FindBy(name="last_name")
	WebElement lName;
	
	@FindBy(name="password")
	WebElement passWord;
	
	@FindBy(name="mobile_number")
	WebElement mobileNum;
	
	@FindBy(name="otp")
	WebElement otpNum;
	
	@FindBy(tagName="Button")
	WebElement sendOtp;
	
	@FindBy(className="t400 capitalize button button-border button-circle nomargin registratinbtn")
	WebElement registerBtn;
	
	@FindBy(xpath="//img[contains(text(),'kissht')]")
	WebElement kisshtLogo;
	
	//Initializing PageObjects
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}
	
	
	public boolean validateDECLogo() {
		return kisshtLogo.isDisplayed();
	}
	

	}
	
