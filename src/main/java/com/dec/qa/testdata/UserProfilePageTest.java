package com.dec.qa.testdata;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.dec.qa.base.TestBase;
import com.dec.qa.pages.AadhaarDetailsPage;
import com.dec.qa.pages.SignUpPage;
import com.dec.qa.pages.UserProfilePage;

import junit.framework.Assert;

public class UserProfilePageTest extends TestBase {
	
	SignUpPage signUpPage;
	UserProfilePage userProfilePage;
	AadhaarDetailsPage aadhaarDetailsPage;

	//create constructor of UserProfilePageTest Class
	
	public UserProfilePageTest()
	{
		super();
	}
	
  @BeforeTest
    public void setUp() {
	initialization();
	new SignUpPage();
	new UserProfilePage();
	new AadhaarDetailsPage();
  }

  @Test(priority=1)
  public void headerValueTest()
  {
	Assert.assertEquals(userProfilePage.validateHeaderValue(), "Connect Your AADHAAR");
  }
 

  @Test(priority=2)
  public void applyNowButtonTest() {
  boolean flag1=userProfilePage.validateApplyNowButton();
  Assert.assertTrue(flag1);
}
}
