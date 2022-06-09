package com.Grammer;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.CambridgeDictionary.Dictionary_Page;

public class GrammerTest {

	static WebDriver driver;
	@Test
	public void test() throws EncryptedDocumentException, IOException, InvalidFormatException, InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "D:\\\\chromedriver\\\\chromedriver.exe");
		driver=new ChromeDriver();

		driver.manage().window().maximize();
		driver.get("https://dictionary.cambridge.org");
		GrammerPOM page=new GrammerPOM(driver);
		Thread.sleep(2000);

		page.grammar();
		String ActualTitle= driver.getTitle();
		String ExpectedTitle= "English Grammar Today on Cambridge Dictionary";
		Assert.assertEquals(ExpectedTitle,ActualTitle);
		System.out.println("grammer page is verified");


		page.adjectives();
		Thread.sleep(2000);
		String ActualTitle1 =driver.getTitle();
		String ExpectedTitle1 ="Adjectives and adverbs - English Grammar Today - Cambridge Dictionary";
		Assert.assertEquals(ExpectedTitle1,ActualTitle1);
		System.out.println("adjectives and adverbs page is verified");
		driver.navigate().back();

		Thread.sleep(2000);
		JavascriptExecutor jss=(JavascriptExecutor)driver;
		jss.executeScript("window.scrollBy(0,350)"); 
		//System.out.println("user scrolled");

		page.easily_confused();
		Thread.sleep(2000);
		String ActualTitle11 =driver.getTitle();
		String ExpectedTitle11 ="Easily confused words - English Grammar Today - Cambridge Dictionary";
		Assert.assertEquals(ExpectedTitle11,ActualTitle11);
		System.out.println("easily confused page is verified");
		driver.navigate().back();

		Thread.sleep(2000);
		JavascriptExecutor jss1=(JavascriptExecutor)driver;
		jss1.executeScript("window.scrollBy(0,350)"); 
		//System.out.println("user scrolled");
		page.Nouns();
		Thread.sleep(2000);
		String ActualTitle111 = driver.getTitle();
		String ExpectedTitle111 = "Nouns, pronouns and determiners - English Grammar Today - Cambridge Dictionary";
		Assert.assertEquals(ExpectedTitle111, ActualTitle111);
		System.out.println("Nouns, pronouns and determiners page is verified");
		driver.navigate().back();

		Thread.sleep(2000);
		JavascriptExecutor jss2=(JavascriptExecutor)driver;
		jss2.executeScript("window.scrollBy(0,450)"); 
		//System.out.println("user scrolled");
		page.preposition();
		Thread.sleep(2000);
		String ActualTitle1111 = driver.getTitle();
		String ExpectedTitle1111 = "Prepositions and particles - English Grammar Today - Cambridge Dictionary";
		Assert.assertEquals(ExpectedTitle1111, ActualTitle1111);
		System.out.println("Prepositions and particles verified");
		driver.navigate().back();

		Thread.sleep(2000);
		JavascriptExecutor jss3=(JavascriptExecutor)driver;
		jss3.executeScript("window.scrollBy(0,450)"); 
		//System.out.println("user scrolled");
		page.using_English();
		Thread.sleep(2000);
		String ActualTitle11111 = driver.getTitle();
		String ExpectedTitle11111 = "Using English - English Grammar Today - Cambridge Dictionary";
		Assert.assertEquals(ExpectedTitle11111, ActualTitle11111);
		System.out.println("Using English is verified");
		driver.navigate().back();

		Thread.sleep(2000);
		JavascriptExecutor jss4=(JavascriptExecutor)driver;
		jss4.executeScript("window.scrollBy(0,450)"); 
		//System.out.println("user scrolled");
		page.verbs();
		Thread.sleep(2000);
		String ActualTitle111111 = driver.getTitle();
		String ExpectedTitle111111 = "Verbs - English Grammar Today - Cambridge Dictionary";
		Assert.assertEquals(ExpectedTitle111111, ActualTitle111111);
		System.out.println("Verbs is verified");
		driver.navigate().back();
		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		Thread.sleep(2000);
		JavascriptExecutor jss5=(JavascriptExecutor)driver;
		jss5.executeScript("window.scrollBy(0,450)"); 
		//System.out.println("user scrolled");
		page.clauses();
		Thread.sleep(2000);
		String ActualTitle1111111 = driver.getTitle();
		String ExpectedTitle1111111 = "Words, sentences and clauses - English Grammar Today - Cambridge Dictionary";
		Assert.assertEquals(ExpectedTitle1111111, ActualTitle1111111);
		System.out.println("Words, sentences and clauses is verified");

		driver.close();

	}
}
