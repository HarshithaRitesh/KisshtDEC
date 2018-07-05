package com.dec.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestBase {
	
public static WebDriver driver;
public static Properties prop;

public TestBase(){
	
	try {
		prop = new Properties();
		FileInputStream ip = new FileInputStream("C:\\Users\\Neelam\\eclipse-workspace\\KisshtDECTest\\src\\main\\java\\com\\dec\\qa\\config\\config.Properties");
		prop.load(ip);
		
	}catch(FileNotFoundException e) {
		
		e.printStackTrace();
	}catch(IOException e) {
	e.printStackTrace();
	}
}

/*public static void main(String [] args)
{
	System.out.println("Welcome to DEC Kissht");
}*/
 
public static void  initialization()
{
	String browserName=prop.getProperty("browser");
	if(browserName.equals("chrome"))
	{
		System.setProperty("webdriver.chrome.driver", "E:\\Kush\\drivers\\chromedriver_win32/chromedriver.exe");
		driver=new ChromeDriver();
	}else if(browserName.equals("FF"))
	{
		System.setProperty("webdriver.geckodriver.driver", "E:\\Kush\\drivers\\geckodriver-v0.19.1-win64/geckodriver.exe");
		driver=new FirefoxDriver();
	}
	else if(browserName.equals("IE"))
	{
		System.setProperty("webdriver.ie.driver", "E:\\Kush\\drivers\\IEDriverServer_x64_3.8.0/IEDriverServer.exe");
		driver=new InternetExplorerDriver();
	}
	
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
driver.get(prop.getProperty("url"));
	
}
}
