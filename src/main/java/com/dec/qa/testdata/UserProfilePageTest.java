package com.dec.qa.testdata;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.dec.qa.base.TestBase;
import com.dec.qa.pages.LoginPage;

import com.dec.qa.pages.UserProfilePage;



public class UserProfilePageTest extends TestBase {
	
	LoginPage loginPage;
    UserProfilePage userProfilePage;

	//create constructor of UserProfilePageTest Class
	
	public UserProfilePageTest()
	{
		super();
	}
	
  @BeforeTest
    public void setUp() {
    initialization();
  
   }

  @Test(priority=2)
  public void applyNowButtonTest() throws InterruptedException {
  LoginPage loginPage=new LoginPage();
	  loginPage.validateSignInLink();
	 userProfilePage=loginPage.signIn(prop.getProperty("username"),prop.getProperty("password"));
  boolean flag1=userProfilePage.validateApplyNowButton();
 Assert.assertTrue(flag1);
  
  
}
 
	  
  
}
