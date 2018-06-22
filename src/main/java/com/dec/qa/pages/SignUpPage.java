package com.dec.qa.pages;




import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.dec.qa.base.TestBase;

public class SignUpPage extends TestBase {
	
//PageFactory - OR Need to define PF or OR of Login Page

		@FindBy(xpath="//input[@type='email'][@name='email']")
		WebElement email;
		
		@FindBy(xpath="//input[@name='first_name']")
        WebElement fName;
		
		@FindBy(xpath="//input[@name='last_name']")
		WebElement lName;
		
		@FindBy(xpath="//input[@type='password']")
		WebElement passWord;
		
		@FindBy(xpath="//input[@type='text'][@name='mobile_number']")
		WebElement mobileNum;
		
		@FindBy(xpath="//input[@type='text'][@name='otp']")
		WebElement enterOtp;
		
		@FindBy(xpath="//button[@type='button' and text()='Send OTP']")
		WebElement sendOtp;
		
		@FindBy(xpath="//button[@type='submit' and contains(., 'Register Now')]")
		WebElement registerBtn;
		
		@FindBy(xpath="//img[@src='https://www.stage.kissht.com/public/front/website/images/logo.png?version=1.2']")
		WebElement kisshtLogo;
		
		@FindBy(xpath="//a[@href='https://www.stage.kissht.com/login']")
		WebElement applyNow;
		
		//Initializing PageObjects
				public SignUpPage() {
			    PageFactory.initElements(driver, this);
		        }

		//Actions
		
		public String validateLoginPageTitle() {
			return driver.getTitle();
		}
		
		
		public boolean validateDECLogo() {
			return kisshtLogo.isDisplayed();
		}
		
		
		public boolean validateApplyNowlink() {
			applyNow.click();
			return applyNow.isEnabled();
			}
		
		public UserProfilePage login(String uEmail,String uFname,String uLname,String uPassword,String uMobile,String uOtp)    {
            System.out.println("New User Registration");
		    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			email.sendKeys(uEmail);
			fName.sendKeys(uFname);
	        lName.sendKeys(uLname);
			passWord.sendKeys(uPassword);
			mobileNum.sendKeys(uMobile);
			enterOtp.sendKeys(uOtp);
			registerBtn.submit();
	       return new UserProfilePage();
		}
		
		public void logOut()
		{
			driver.close();
		}

		
		
	
		}