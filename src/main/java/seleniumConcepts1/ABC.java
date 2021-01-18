package seleniumConcepts1;


import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class ABC {

	
WebDriver driver;
	
	@Before

	public void browser() throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\rks_8\\Selenium 2020\\crm1\\driver\\chromedriver.exe");
		
		 driver = new ChromeDriver();
	     driver.get("https://www.google.com/");
	     driver.manage().window().maximize();
	     driver.manage().deleteAllCookies();
	     driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	     Thread.sleep(1000);
	      
  }
	
	@Test
	   public void check() throws InterruptedException {
		   
	   WebElement HOME_PAGE = driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/div[1]/div/img"));
	    WebElement GMAIL_BUTTON = driver.findElement(By.xpath("//*[@id=\"gbw\"]/div/div/div[1]/div[1]/a"));
	    GMAIL_BUTTON.click();
	   
	    WebDriverWait wait = new WebDriverWait(driver,30);
	    wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy((By) GMAIL_BUTTON));
	    
	    Assert.assertTrue("Gmail page is not found",HOME_PAGE.isDisplayed());
	    Thread.sleep(1000);
	  
	   }
	   }
	   
	   

