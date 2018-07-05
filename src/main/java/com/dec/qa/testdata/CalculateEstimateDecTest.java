package com.dec.qa.testdata;


import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.dec.qa.base.TestBase;
import com.dec.qa.pages.CalculateEstimateDec;
import com.dec.qa.util.TestUtil;



public class CalculateEstimateDecTest extends TestBase {
CalculateEstimateDec calculateEstimateDec;
	
	@BeforeTest()
	public void setUp() {
	initialization();
    calculateEstimateDec=new CalculateEstimateDec();
    calculateEstimateDec.validateEstimateBtn();
   
	}
	
	@Test()
	public void estimateBtnCheck() {
		Assert.assertEquals(calculateEstimateDec.validateEstimateBtn(),"PLEASE PROVIDE THE FOLLOWING INFORMATION TO GET A QUICK ESTIMATE OF THE CREDIT LIMIT YOU MAY BE ELIGIBLE FOR.");	
}
	
	@Test
	public void cityListDropDownCheck() throws InterruptedException{
		calculateEstimateDec.validateCityListDropDown();
		}
	
	@Test
	public void employeeTypeCheck() throws InterruptedException 
	{
		calculateEstimateDec.validateEmployeeType();
	}
	
	@Test
	public void existingEmiRadioCheck(){
		calculateEstimateDec.validateExistingEmiRadio();
	}
	
	@Test()
	public void calculateEstimateBtnCheck(){
		//Boolean b=
				calculateEstimateDec.validateEstimationBtn();
		//Assert.assertTrue(b, "Amount is calculated");
	

	}

}
