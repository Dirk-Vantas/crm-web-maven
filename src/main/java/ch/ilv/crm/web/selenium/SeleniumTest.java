package ch.ilv.crm.web.selenium;

import java.time.Duration;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class SeleniumTest {

	
	@Test
	public void testGoogle() {
        //System.setProperty("webdriver.ie.driver", "C:/dev/IEDriverServer.exe");
        //InternetExplorerOptions options = new InternetExplorerOptions();
        //WebDriver driver=new InternetExplorerDriver(options);
		
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Gid\\Desktop\\dev-tools\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        WebDriver driver=new ChromeDriver(options);

        //driver.manage().window().maximize();
        
        driver.get("http://localhost:7070");
        
        
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.findElement(By.xpath("//button[@id='L2AGLb']/div")).click();

		WebElement searchText = driver.findElement(By.name("q"));
		searchText.sendKeys("ilv.ch");
		searchText.submit();
		
		WebElement waitElement = (new WebDriverWait(driver, Duration.ofMillis(10))).until(ExpectedConditions.presenceOfElementLocated(By.id("rso")));
		
		
		List<WebElement> findElements = driver.findElements(By.xpath("//div[@class='yuRUbf']/a"));

		driver.get(findElements.get(0).getAttribute("href"));
		
		waitElement = (new WebDriverWait(driver, Duration.ofMillis(10))).until(ExpectedConditions.presenceOfElementLocated(By.className("bd-imagelink-5")));
		
		boolean isILVPage = driver.getPageSource().contains("INFORMATIK LEHRBETRIEBSVERBAND");
		
		Assert.assertTrue(isILVPage);
		
		driver.close();
	}


}