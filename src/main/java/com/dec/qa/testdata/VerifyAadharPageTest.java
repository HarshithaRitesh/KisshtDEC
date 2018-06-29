package com.dec.qa.testdata;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.dec.qa.base.TestBase;
import com.dec.qa.pages.AadhaarDetailsPage;
import com.dec.qa.pages.LoginPage;
import com.dec.qa.pages.UserProfilePage;
import com.dec.qa.pages.VerifyAadharPage;

public class VerifyAadharPageTest extends TestBase {

	LoginPage loginPage;
	UserProfilePage userProfilePage;
	AadhaarDetailsPage aadhaarDetailsPage;
	VerifyAadharPage verifyAadharPage;
	
	//create constructor for VerifyAadharPageTest
	public VerifyAadharPageTest() {
		super();
	}
	
	@BeforeTest
	public void setUp() throws InterruptedException {
		initialization();
		LoginPage loginPage=new LoginPage();
		loginPage.validateSignInLink();
		new UserProfilePage();
		userProfilePage=loginPage.signIn(prop.getProperty("username"),prop.getProperty("password"));
		userProfilePage.validateApplyNowButton();
		AadhaarDetailsPage aadhaarDetailsPage=new AadhaarDetailsPage();
		aadhaarDetailsPage.validatePanFormat("QWEPO8888J");
		aadhaarDetailsPage.validateAadhaarFormat("127654890987");
		aadhaarDetailsPage.validateNextButton();
	}
	
	@Test
	public void sendOtpCheck() {
		Boolean skip1=verifyAadharPage.validateSendOtp();
		Assert.assertTrue(skip1, "Skip Button is Clicked");
	}
}
