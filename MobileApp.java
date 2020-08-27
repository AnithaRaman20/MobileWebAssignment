package Assignment;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class MobileApp {
	public static void main(String[] args) throws MalformedURLException, InterruptedException{
		//define capability if this is present/matches my real device capability it should run
		DesiredCapabilities cap= new DesiredCapabilities ();
		//common capabilities required to test an app
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Anitha");
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		//add capbility for web app
		cap.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");

		//chrome driver executable specific to android
		cap.setCapability(AndroidMobileCapabilityType.CHROMEDRIVER_EXECUTABLE, "C:\\Users\\AnithaRaman\\Downloads\\Jars-Selenium\\Mobile\\chromedriver_win32\\chromedriver.exe");

		AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(new URL("http://0.0.0.0:4723/wd/hub"),cap);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://m.cricbuzz.com");
		WebElement element=driver.findElement(By.xpath("//span[contains(text(),'Menu')]"));
		element.click();
		driver.findElement(By.xpath("//a[contains(text(),'Home')]")).click();
		JavascriptExecutor js=(JavascriptExecutor)driver;
		WebElement element1=driver.findElement(By.xpath("//span[contains(text(),'England clinch series 1-0')]"));
		js.executeScript("arguments[0].scrollIntoView();", element1);		
		
		
	}
}
