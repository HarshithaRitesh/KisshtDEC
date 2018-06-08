package com.dec.qa.testdata;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.dec.qa.base.TestBase;
import com.dec.qa.pages.AadhaarDetailsPage;
import com.dec.qa.pages.SignUpPage;
import com.dec.qa.pages.UserProfilePage;
import com.dec.qa.util.TestUtil;


public class SignupPageTest extends TestBase {

	SignUpPage signupPage;
	UserProfilePage userProfilePage;
	

	
	//create constructor of SignupPageTest Class
	
	public SignupPageTest(){
	super();
	}
	
	@BeforeTest
	public void setUp() {
		initialization();
	signupPage =new SignUpPage();
	userProfilePage =new UserProfilePage();

		}
	
	@Test(priority=1)
	public void loginPageTitleTest() {
		String title=signupPage.validateLoginPageTitle();
		Assert.assertEquals(title, "Kissht - EMI Without Card - Hassle Free Online Shopping on EMI");
	}
	
	@Test(priority=2)
	public void decLogoImageTest() {
	boolean flag=signupPage.validateDECLogo();
	Assert.assertTrue(flag);
	}
	
	@Test(priority=3)
	public void applyNowLinkTest() {
		boolean flag = signupPage.validateApplyNowlink();
		Assert.assertTrue(flag);
	}
	
	@Test(priority=4)
	public void loginTest(){
		
		userProfilePage = signupPage.login("harshitha.ritesh+bru@kissht.com", "Harshitha", "Ritesh", "kushritesh", "6990079890","888888");
	
				String label=driver.findElement(By.xpath("//div[@class='yourcardtext1']")).getTagName();
				System.out.println(label);
	}
	
	

		
	
		
		
	@AfterTest
public void tearDown() {
		//driver.quit();
	}
	
	
}
