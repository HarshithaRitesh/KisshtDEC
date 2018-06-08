package com.dec.qa.testdata;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dec.qa.base.TestBase;
import com.dec.qa.pages.AadhaarDetailsPage;
import com.dec.qa.pages.SignUpPage;
import com.dec.qa.pages.UserProfilePage;

import junit.framework.Assert;

public class AadhaarDetailsPageTest extends TestBase{
	SignUpPage signupPage;
	UserProfilePage userProfilePage;
	AadhaarDetailsPage aadhaarDetailsPage;
	
	public AadhaarDetailsPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setUp(){
		initialization();
		signupPage =new SignUpPage();
		new UserProfilePage();
		aadhaarDetailsPage=new AadhaarDetailsPage();
	}

	 @Test(priority=1)
	  public void headerValueTest()
	  {
		Assert.assertEquals(aadhaarDetailsPage.validateHeaderValue(), "Connect Your AADHAAR");
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
