package com.dec.qa.testdata;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.dec.qa.base.TestBase;
import com.dec.qa.pages.AadhaarDetailsPage;
import com.dec.qa.pages.LoginPage;
import com.dec.qa.pages.UserProfilePage;



public class AadhaarDetailsPageTest extends TestBase{
	LoginPage loginPage;
	UserProfilePage userProfilePage;
	AadhaarDetailsPage aadhaarDetailsPage;
	
	public AadhaarDetailsPageTest()
	{
		super();
	}
	
	@BeforeTest
	public void setUp() throws InterruptedException{
		initialization();
		LoginPage loginPage=new LoginPage();
		  loginPage.validateSignInLink();
		new UserProfilePage();
		userProfilePage=loginPage.signIn(prop.getProperty("username"),prop.getProperty("password"));
		userProfilePage.validateApplyNowButton();
		aadhaarDetailsPage=new AadhaarDetailsPage();
	}

	 @Test(priority=1)
	  public void headerValueTest()
	  {
		Assert.assertEquals(aadhaarDetailsPage.validateHeaderValue(), "CONNECT YOUR AADHAAR");
	  }
	@Test(priority=2)
	public void panFormatTest() {
		aadhaarDetailsPage.validatePanFormat("QWEPO8888J");
		
	}
	
	@Test(priority=3)
	public void aadhaarFormatTest() {
		aadhaarDetailsPage.validateAadhaarFormat("127654890987");
	}
	
	@Test(priority=4)
	public void nextButtonClickTest() {
		Boolean flagB=aadhaarDetailsPage.validateNextButton();
        Assert.assertTrue(flagB);
	}
}
