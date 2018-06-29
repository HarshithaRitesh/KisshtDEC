package com.dec.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.dec.qa.base.TestBase;


public class LoginPage extends TestBase
{

	//PageFactory - OR Need to define PF or OR of Login Page

	
	@FindBy(xpath="//a[@id='ui-id-2']") //a[@id='ui-id-2'] /* //div[@id='tab']//a[@id='ui-id-2']*/
	WebElement signIn;
	
	@FindBy(xpath="//form[@id='login-form']//input[@name='email_mobile']")
	WebElement lUsername;
	
	@FindBy(xpath="//form[@id='login-form']//input[@type='password']")
	WebElement lPassword;
	
	@FindBy(xpath="//form[@id='login-form']//button[contains(text(),'Sign In')]")  /* other xpath =//form[@id='login-form']//button['Sign In'] */
	WebElement signInButton;            
	
	//Initializing PageObjects
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	
	public Boolean validateSignInLink() throws InterruptedException {
		
		Thread.sleep(1000);
		signIn.click();
		return signIn.isEnabled();
	}
	
	
	public UserProfilePage signIn(String uName,String uPassword) {
		
		lUsername.sendKeys(uName);
		lPassword.sendKeys(uPassword);
		signInButton.click();
		return new UserProfilePage();
	
	}
	

	}
	
