package weatherreport;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class searchmodule {
	
	
	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Lenovo\\Downloads\\chromedriver_win32\\chromedriver.exe");
		
		
		
		WebDriver driver=new ChromeDriver();
		
		
		driver.get("https://weather.com/");
		driver.manage().window().maximize();
		
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement element = wait.until(
		ExpectedConditions.elementToBeClickable(By.xpath("//div[@role='combobox']/input")));
		element.click();
		
		
		driver.findElement(By.xpath("//div[@role='combobox']/input")).sendKeys("Delhi");
		Actions action=new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//input[@id='LocationSearch_input']"))).build().perform();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@id='LocationSearch_listbox']/*[contains(text(),'Delhi')][1]")).click();
		
		String text = driver.findElement(By.xpath("//section[@data-testid='TodayWeatherModule']/*/h2")).getText();
        System.out.println(text);
		
		
		
		

	}

}
