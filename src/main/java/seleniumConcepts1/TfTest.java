
 package seleniumConcepts1;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;





public class TfTest {

	WebDriver driver;

	@Before

	public void browser() throws InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\rks_8\\Selenium 2020\\crm1\\driver\\chromedriver.exe");

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
		
		USERNAME_ELEMENT.sendKeys("demo@techfios.com");
		PASSWORD_ELEMENT.sendKeys("abc123");
		LOGIN_BUTTON.click();
		Thread.sleep(2000);
		
		WebElement DASHBOARD_ELEMENT = driver.findElement(By.xpath("//h2[contains(text(),' Dashboard ')]"));
		WebDriverWait wait = new WebDriverWait(driver, 3);
		wait.until(ExpectedConditions.visibilityOfAllElements(DASHBOARD_ELEMENT));
		    
		Assert.assertTrue("Dashboard page is not found",DASHBOARD_ELEMENT.isDisplayed());
		

	   WebElement CUSTOMER_BUTTON =driver.findElement(By.xpath("//span[contains(text(),'Customers')]"));
	   CUSTOMER_BUTTON.click();
      Thread.sleep(1000);

       WebElement ADD_CUSTOMER_BUTTON = driver.findElement(By.xpath("//a[@href='https://techfios.com/billing/?ng=contacts/add/']"));
       ADD_CUSTOMER_BUTTON.click();
       Thread.sleep(1000);
		
		WebElement CUSTOMER_NAME_ELEMENT = driver.findElement(By.xpath("//input[@id='account']"));
		CUSTOMER_NAME_ELEMENT.sendKeys("Ann");
		Thread.sleep(1000);

		
		//WebDriverWait wait = new WebDriverWait(driver, 3);
		//wait.until(ExpectedConditions.visibilityOfAllElements(ADD_CUSTOMER_BUTTON));

		WebElement COMPANY_DROPDOWN = driver.findElement(By.xpath("//*[@id=\"cid\"]"));
		Select sel = new Select(COMPANY_DROPDOWN);
		sel.selectByVisibleText("Techfios");
		
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("abc@gamil.com");
		driver.findElement(By.xpath("//input[@id='phone']")).sendKeys("0123456789");
		driver.findElement(By.xpath("//input[@id='address']")).sendKeys("10001 ABC Street");
		driver.findElement(By.xpath("//input[@id='city']")).sendKeys("Frisco");
		driver.findElement(By.xpath("//input[@name='state']")).sendKeys("TX");
		driver.findElement(By.xpath("//input[@name='zip']")).sendKeys("75023");
		Thread.sleep(1000);

	/*	  WebElement COUNTRY =driver.findElement(By.xpath("//select[@name='country']"));
		COUNTRY.click();
		WebDriverWait wait1 = new WebDriverWait(driver, 3);
		wait1.until(ExpectedConditions.visibilityOfAllElements(COUNTRY)); 
		
		Select selCountry = new Select(COUNTRY);
		selCountry.selectByVisibleText("Austalia");  */
		
		WebElement CURRENCY = driver.findElement(By.xpath("//select[@id='currency']"));
		Select selCurrency = new Select(CURRENCY);
		selCurrency.selectByVisibleText("USD");
		
		//WebElement GROUP = driver.findElement(By.xpath("//select[@id='cid']")).);
		Select selGroup = new Select(driver.findElement(By.xpath("//select[@id='group']")));
		selGroup.selectByVisibleText("AUG 2020");
		
		WebElement SAVE_BUTTON = driver.findElement(By.xpath("//button[@id=\"submit\"]"));
		
		JavascriptExecutor Js = (JavascriptExecutor) driver;
		Js.executeScript("arguments[0].scrollIntoView();",SAVE_BUTTON);
				
		SAVE_BUTTON.click();
		
		WebDriverWait wait2 = new WebDriverWait(driver, 3);
		wait2.until(ExpectedConditions.visibilityOfAllElements(SAVE_BUTTON));
		

		
		driver.findElement(By.xpath("//input[@placeholder='Search Customers...']")).sendKeys("Ann");
		driver.findElement(By.xpath("//button[@class='btn btn-search']")).click();
		
		
		//WebElement CONTACT_PAGE = driver.findElement(By.xpath("//*[@id=\"page-wrapper\"]/div[2]/div/h2"));
		
		//Assert.assertEquals("Page not found", CONTACT_PAGE, driver.getTitle());
		
	}	
		@After
		public void teardown() {
			
			driver.close();
			
		}  
	
		
	} 
