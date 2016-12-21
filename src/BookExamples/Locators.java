package BookExamples;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Locators {
	
	 private static WebDriver driver;
	 private int i=0;
	
	private boolean iselementpresent(By by)
	{
		boolean flag=false;
		try
		{
			if(driver.findElement(by).isDisplayed() || driver.findElement(by).isEnabled())
			{
				flag=true;
				System.out.println("Element found");
			}
		}
		catch(NoSuchElementException e)
		{
			System.out.println("Eception occurred");
		}
		return flag;
	}
	
	public void testelement()
	{
		if(iselementpresent(By.xpath("//li[@class='_2sYLhZ'][@data-reactid='33']/a[@class='_2k0gmP']")))
		{
			WebElement ele= driver.findElement(By.xpath("//li[@class='_2sYLhZ'][@data-reactid='33']/a[@class='_2k0gmP']"));
			String phandle=driver.getWindowHandle();
			ele.click();
			for(String winHandle : driver.getWindowHandles()){
			    driver.switchTo().window(winHandle);
			}
			driver.findElement(By.className("_2zrpKA")).sendKeys("heeloo");
		}
		else
		{
			System.out.println("element not present");
		}
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Locators loc=new Locators();
		driver = new FirefoxDriver();
		driver.get("https://www.flipkart.com/");
		loc.testelement();
		
	

	}

}
