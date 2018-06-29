package com.dec.qa.testdata;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.dec.qa.base.TestBase;
import com.dec.qa.pages.LoginPage;
import com.dec.qa.pages.UserProfilePage;

public class LoginPageTest extends TestBase {
	LoginPage loginPage;
	UserProfilePage userProfilePage;
	
	//create constructor of LoginPageTest Class
	public LoginPageTest() {
		super();
	
	}

	@BeforeTest
	public void setUp() {
		initialization();
	
		//userProfilePage=loginPage.signIn(prop.getProperty("username"),prop.getProperty("password"));
	}
	
	@Test
	public void signInLinkCheck() throws InterruptedException {
		System.out.println("link found");
		System.out.println("driver=" + driver); 
		LoginPage loginPage=new LoginPage();
		Boolean flag=loginPage.validateSignInLink();
	Assert.assertTrue(flag);
	
	}
	
	@Test
	public void signInTest() {
		LoginPage loginPage=new LoginPage();
		UserProfilePage userProfilePage=new UserProfilePage();
		userProfilePage=loginPage.signIn(prop.getProperty("username"), prop.getProperty("password"));
	}
}
