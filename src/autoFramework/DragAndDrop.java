package autoFramework;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class DragAndDrop {
	
	private String myname;

	public String getMyname() {
		return myname;
	}

	public void setMyname(String myname) {
		this.myname = myname;
	}

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
			driver.get("https://jqueryui.com/droppable/");
			
			driver.manage().window().maximize();
			
			driver.switchTo().frame(0);
			
			WebElement drag=driver.findElement(By.xpath("//*[@id=\"draggable\"]"));
			WebElement drop=driver.findElement(By.xpath("//*[@id=\"droppable\"]"));
			
			Actions action = new Actions(driver);
			
			action.clickAndHold(drag).moveToElement(drop).release().build().perform();
			

	}

}
