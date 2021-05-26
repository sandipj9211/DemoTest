package autoFramework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
//import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestCase {

	public static void main(String[] args) throws InterruptedException, IOException{
		 
		Properties prop = new Properties();
		FileInputStream ip = new FileInputStream("C:\\Users\\Sandip\\ToolsQA\\DemoQA\\src\\autoFramework\\config.properties");
		
		prop.load(ip);
		
		 System.out.println("Execution after setting ChromeDriver path in System setProperty method");
		 System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\chromedriver.exe");
		 WebDriver driver=new ChromeDriver();
		 
		 driver.manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS);
		 driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);		 
		 
		 ChromeOptions options = new ChromeOptions();
			options.addArguments("--allow-running-insecure-content");
			options.addArguments("--allow-insecure-websocket-from-https-origin");
			options.addArguments("disable-extensions");
			options.addArguments("allow-running-insecure-content");
			options.addArguments("--start-maximized");
			options.addArguments("disable-extensions");			
			options.addArguments("disable-plugins");
			options.addArguments("--enable-precise-memory-info"); 
			options.addArguments("--disable-popup-blocking");
			options.addArguments("--disable-default-apps");
			options.addArguments("test-type=browser");
			options.addArguments("disable-infobars"); 
			options.setExperimentalOption("useAutomationExtension", false);
			DesiredCapabilities cap = new DesiredCapabilities();
			cap.setCapability(ChromeOptions.CAPABILITY, options);
		 
			Thread.sleep(1000);
			driver.get("https://www.flipkart.com");
			
			//driver.get(prop.getProperty("URL"));
			
			driver.manage().window().maximize();
			
			WebElement username=driver.findElement(By.xpath("//input[@class='_2IX_2- VJZDxU']"));
			WebElement closeButton=driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']"));
			
			waitElement(driver, username);
			
			username.clear();
			username.sendKeys("7777777777");
			
			//Exception handling if "CONTINUE" button appears instead of "Login" button
			List<WebElement> signUps = driver.findElements(By.xpath("//button[contains(normalize-space(),'CONTINUE')]"));
			
			if(signUps.size()!=0) {
						
				WebElement signUp=driver.findElement(By.xpath("//button[contains(normalize-space(),'CONTINUE')]"));
				
				waitElement(driver, signUp);
				signUp.click();
				
				Thread.sleep(1000);
			}
			
			WebElement password=driver.findElement(By.xpath("//input[@type='password']"));
				
			password.clear();
			password.sendKeys("Test");
				
			driver.findElement(By.xpath("//button[contains(normalize-space(),'Login')]")).click();
				
			waitElement(driver, closeButton);
			closeButton.click(); 
			
			Thread.sleep(1000);
			
			WebElement search = driver.findElement(By.xpath("//input[@title='Search for products, brands and more']"));
			search.sendKeys("Redmi note 6 pro");
			
			waitElement(driver, search);
			search.sendKeys(Keys.ENTER);
			
			Thread.sleep(5000);
			
			WebElement product = driver.findElement(By.xpath("(//div[contains(text(),'Redmi Note 6 Pro (Red, 64 GB)')])[1]"));
			waitElement(driver, product);
			product.click();
			
			Set<String> allWindowHandles = driver.getWindowHandles();
			 
			for(String handle : allWindowHandles)
			{
			System.out.println("Switching to window - > " + handle);
			System.out.println("Navigating to product details page");
			driver.switchTo().window(handle); //Switch to the desired window first and then execute commands using driver
			 
			}
			Thread.sleep(2500);
			WebElement buyNowButton=driver.findElement(By.xpath("//button[contains(normalize-space(),'BUY NOW')]"));
			waitElement(driver,buyNowButton);

			buyNowButton.click();
			Thread.sleep(2500);

			driver.close();
			
			System.out.println("Execution finished");
			
			}

			public static void waitElement(WebDriver driver,WebElement w1){
				WebDriverWait wait=new WebDriverWait(driver, 20);
				wait.until(ExpectedConditions.visibilityOf(w1));
				System.out.println("waiting");
			}
			
}
