package com.dec.qa.testdata;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dec.qa.base.TestBase;
import com.dec.qa.pages.AadhaarDetailsPage;
import com.dec.qa.pages.SignUpPage;

import junit.framework.Assert;

public class AadhaarDetailsPageTest extends TestBase{
	SignUpPage signupPage;
	AadhaarDetailsPage aadhaarDetailsPage;
	
	public AadhaarDetailsPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setUp(){
		initialization();
		signupPage =new SignUpPage();
		aadhaarDetailsPage=new AadhaarDetailsPage();
	}

	@Test(priority=1)
	public void panFormatTest() {
		aadhaarDetailsPage.validatePanFormat("QWEPO8888J");
		
	}
	
	@Test(priority=2)
	public void aadhaarFormatTest() {
		aadhaarDetailsPage.validateAadhaarFormat("127654890987");
	}
	
	@Test(priority=3)
	public void nextButtonClickTest() {
		Boolean flagB=aadhaarDetailsPage.validateNextButton();
        Assert.assertTrue(flagB);
	}
}
