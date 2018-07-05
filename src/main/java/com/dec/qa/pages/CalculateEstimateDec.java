package com.dec.qa.pages;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.dec.qa.base.TestBase;
import com.dec.qa.util.TestUtil;

public class CalculateEstimateDec extends TestBase 
{
	@FindBy(xpath="//a[contains(.,'CALCULATE MY ESTIMATE')]")
	WebElement estimateBtn;
	
	@FindBy(xpath="//form[@id='eligibility_form']//div[1]//h2")
	WebElement headerText;
	
	@FindBy(xpath="//select[@name='city']")
	WebElement cityList;
	
	@FindBy(xpath="//div[@class='btn-group']//button[1]//span")
	WebElement cityBtn;
	
	@FindBy(xpath="//select[@name='employment_type']")
    WebElement employeeType;
	
	@FindBy(xpath="//div[@class='radiobox']//input[@type='radio']")   //div[@class='radiobox']
	WebElement existingEmi;
	
	@FindBy(xpath="//form[@id='eligibility_form']//div[3]//input[@type='text'][@class='calculatetextbx']")
	WebElement grossSalary;
	
	@FindBy(xpath="//form[@id='eligibility_form']//div[3]//input[@name='company_name']")
	WebElement companyName;
	
	@FindBy(xpath="//div[@class='personalbtngpbx']/button[@type='button']")
	WebElement calculateBtn;
	
	
	public CalculateEstimateDec() {
		PageFactory.initElements(driver, this);
	}
	
	public String validateEstimateBtn() {
		WebDriverWait wait=new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.elementToBeClickable(estimateBtn));
        estimateBtn.click();
        return headerText.getText();
		}
	
	public void validateCityListDropDown() throws InterruptedException {
		WebDriverWait wait=new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='btn-group']//button[1]//span")));
		Actions act=new Actions(driver);
		act.moveToElement(cityBtn).click(cityBtn).build().perform();
		Select city=new Select(cityList);
	    List<WebElement>citySize=city.getOptions();
	    Thread.sleep(3000);
		System.out.println(citySize.size());
		for(int i=0;i<citySize.size();i++) {
			String cityValues=citySize.get(i).getText();
			System.out.println(cityValues);
		}
		Boolean imultiple=city.isMultiple();
		System.out.println( "CityListDropDown is not of Multiple Select Type :" +imultiple);
		//city.deselectByIndex(0);  I was receiving error as "java.lang.UnsupportedOperationException: You may only deselect options of a multi-select"
		city.selectByIndex(7);
		}

	public void validateEmployeeType() throws InterruptedException {
		WebDriverWait wait=new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//select[@name='employment_type']")));
		Select eType=new Select(employeeType);
		List<WebElement> empType=eType.getOptions();
		Thread.sleep(3000);
		System.out.println("Employement Type size " + empType.size());
		
		for(int i=0;i<empType.size();i++) {
			String eValue=empType.get(i).getText();
			System.out.println(eValue);
		}
		eType.selectByVisibleText("Salaried");
		grossSalary.sendKeys("20000");
		companyName.sendKeys("RELIANCE");
		}
	
	public void  validateExistingEmiRadio() {
		
    List<WebElement> rSize=driver.findElements(By.className("radiochecked"));
    
	System.out.println("Size of RadioButton(existing Loans) " +rSize.size());
	Boolean r=false;
	r=rSize.get(1).isSelected();
	System.out.println("Existing Loan selected by default "+r);
	if(r==false) {
	
	//existingEmi.click();
		rSize.get(0).click();
		driver.findElement(By.xpath("//input[@type='number'][@name='existing_total_emis']")).isDisplayed();
		driver.findElement(By.xpath("//input[@type='number'][@name='existing_total_emis']")).clear();
		driver.findElement(By.xpath("//input[@type='number'][@name='existing_total_emis']")).sendKeys("250");
	}else {
		rSize.get(1).click();
	}
for(int i=0;i<rSize.size();i++)
	{
	
		String rValue=rSize.get(i).getAttribute("value");
		System.out.println(rValue);
	}
	
/*if(existingEmi.getAttribute("value").equalsIgnoreCase("yes")) {
	driver.findElement(By.xpath("//input[@type='number'][@name='existing_total_emis']")).isDisplayed();
	driver.findElement(By.xpath("//input[@type='number'][@name='existing_total_emis']")).sendKeys("100");
}else
{
System.out.println("Existing EMI is set to " + "NO");
	
}*/
	}

public void validateEstimationBtn() {
	WebDriverWait wait=new WebDriverWait(driver,10);
	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='personalbtngpbx']/button[@type='button']")));
	calculateBtn.submit();
	//return calculateBtn.isEnabled();
	
}
	
	

	

}
