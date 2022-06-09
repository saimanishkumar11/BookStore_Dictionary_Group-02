package com.CambridgeDictionary;

import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.xmlbeans.impl.common.XPath;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;


public class DictionaryTest {

	static WebDriver driver;
	@Test
	public void test() throws EncryptedDocumentException, IOException, InvalidFormatException
	{
		System.setProperty("webdriver.chrome.driver", "D:\\\\chromedriver\\\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		driver.get("https://dictionary.cambridge.org");
		Dictionary_Page page=new Dictionary_Page(driver);
		page.dictionary_btn();
		page.application_logo();
		//page.word_Of_The_Year(driver,"The Cambridge Dictionary Word of the Year");
		WebElement word = driver.findElement(By.xpath("//a[.='Word of the Year']"));
		Point loc = word.getLocation();
		int x = loc.getX();
		int y = loc.getY();
		//System.out.println(x);
		//System.out.println(y);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(50,1813)");
		word.click();
		page.word_Of_The_Year(driver, "Cambridge");
		page.searchField("Sheet1",1,2);
		page.search_btn(driver,"AVALANCHE");
		page.clear_searchField();
		page.searchField("Sheet1", 2, 2);
		page.search_btn(driver,"HYSTERICAL");
		page.clear_searchField();
		page.searchField("Sheet1", 3, 2);
		page.search_btn(driver,"TURNCOAT");
		page.clear_searchField();
		driver.findElement(By.xpath("//li[@class='lpr-2']")).click();
		System.out.println(driver.getTitle());
	}
}