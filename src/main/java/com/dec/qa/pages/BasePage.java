package com.dec.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.dec.qa.base.TestBase;

public class BasePage extends TestBase {
	
@FindBy(linkText="GET KISSHT EMI CARD")
WebElement getEMICardbtn;

@FindBy(className="button button-dark calculatebtn")
WebElement estimateCalculatebtn;

public BasePage() {
	PageFactory.initElements(driver, this);
}

//Actions

public boolean getkisshtEMICardbtnCheck() {
	return getEMICardbtn.isEnabled();
}

public boolean validateLOCcalculator() {
	return estimateCalculatebtn.isEnabled();
}





}
