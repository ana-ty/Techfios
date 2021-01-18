package seleniumConcepts1;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;









public class LearningElements {
 
	WebDriver driver;
	
  @Before
	
	public void browser() throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\rks_8\\Selenium 2020\\crm1\\driver\\chromedriver.exe");
		
		 driver = new ChromeDriver();
	     driver.get("https://techfios.com/billing/?ng=login/");
	     driver.manage().window().maximize();
	     driver.manage().deleteAllCookies();
	     driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	     Thread.sleep(1000);
	
  }
	
	@Test
     public void addCustomer() throws InterruptedException {
    	 
    	
	     
		WebElement USERNAME_ELEMENT = driver.findElement(By.xpath("//input[@id='username']"));
	    WebElement PASSWORD_ELEMENT = driver.findElement(By.xpath("//input[@id='password']"));
	    WebElement LOGIN_BUTTON = driver.findElement(By.xpath("//button[@type='submit']"));
	    
	    Thread.sleep(2000);
	    WebElement DASHBOARD_ELEMENT = driver.findElement(By.xpath("//h2[contains(text(),' Dashboard ')]"));
	    WebElement CUSTOMER = driver.findElement(By.xpath("//span[contains(text(),'Customers')]"));
	    WebElement ADD_BUTTON = driver.findElement(By.linkText("Add Customer"));
	   
	    USERNAME_ELEMENT.sendKeys("demo@techfios.com");
	    PASSWORD_ELEMENT.sendKeys("abc123");
	    LOGIN_BUTTON.click();
	    
	    Thread.sleep(2000);
	    
	    
	    
	  WebDriverWait wait = new WebDriverWait(driver, 3);
	  wait.until(ExpectedConditions.visibilityOfAllElements(DASHBOARD_ELEMENT));
	    
	   Assert.assertTrue("Dashboard page is not found",DASHBOARD_ELEMENT.isDisplayed());
	    CUSTOMER.click();
	    ADD_BUTTON.click();
	    
	 
	    
	}
       
	@After
	public void teardown() {
    	   
    	   driver.close();
       }
    
	
	}




