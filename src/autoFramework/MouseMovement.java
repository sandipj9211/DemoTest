package autoFramework;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class MouseMovement {

	public static void main(String[] args) throws InterruptedException {
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
			
			driver.manage().window().maximize();
			
			WebElement closeButton=driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']"));
			
			closeButton.click(); 
			
			//driver.switchTo().frame(0);
			
			WebElement Fashion=driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div/div[4]/a/div[2]/div[1]/div"));
			
			WebElement MensWear=driver.findElement(By.xpath("//body/div[@id='container']/div[1]/footer[1]"));
					
			Actions action = new Actions(driver);
			
			action.moveToElement(Fashion).build().perform();
			action.moveToElement(MensWear).build().perform();
			

	}

}
