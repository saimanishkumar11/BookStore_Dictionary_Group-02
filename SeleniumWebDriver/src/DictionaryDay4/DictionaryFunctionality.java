package DictionaryDay4;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;


import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DictionaryFunctionality {

	private static XSSFWorkbook workbook;

	public static void main(String[] args) throws IOException, InterruptedException {


		//load the propeties file
		Properties prop = new Properties();
		FileInputStream ip = new FileInputStream(".//TestResources/dictionaryday4.property");
		prop.load(ip);

		//create webdriver instance
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver\\chromedriver.exe"); 
		WebDriver driver;
		driver = new ChromeDriver(); 

		//navigating to website
		driver.navigate().to(prop.getProperty("url"));
		driver.findElement(By.id("onetrust-accept-btn-handler")).click();

		//find the logo
		WebElement element= driver.findElement(By.xpath(prop.getProperty("logo")));
		System.out.println("user find logo");

		//validating the logo
		boolean b1 = driver.findElement(By.xpath(prop.getProperty("logo"))).isDisplayed();
		System.out.println("logo is verified : "+b1);

		//Load the external file
		FileInputStream fis = new FileInputStream("D:\\Capgemini Training\\Sprint 2\\meaning.xlsx");
		workbook =new XSSFWorkbook(fis);
		XSSFSheet ws = workbook.getSheetAt(0);	
		int rownum = ws.getLastRowNum();
		int colnum =ws.getRow(0).getPhysicalNumberOfCells();
		System.out.println(colnum);
		System.out.println(rownum);
		XSSFCell searchkey;

		//iterations to get meaning and translation
		for(int i=0; i<=rownum;i++) { 	
			//driver.navigate().to(prop.getProperty("url"));
			driver.findElement(By.xpath(prop.getProperty("english"))).click();
			searchkey= ws.getRow(i).getCell(0);
			System.out.println("word for which user needs meaning and translation :"+searchkey);

			//Entering the word to get the meaning and translation
			driver.findElement(By.name(prop.getProperty("enter"))).sendKeys(searchkey.toString());
			System.out.println("user enter word: "+searchkey);
			driver.findElement(By.xpath(prop.getProperty("search"))).click();

			//display the meaning of the word in console
			WebElement e= driver.findElement(By.xpath(prop.getProperty("meaning")));
			System.out.println( searchkey+" meaning :"+e.getText());
			System.out.println("user got the meaning :"+searchkey);

			//validating title page
			System.out.println(driver.getTitle());
			//assertTrue(driver.getTitle().contains(searchkey.toString()));

			//Translation from English to Spanish
			WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
			WebElement webElement =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("EnglishToSpanish"))));   
			driver.findElement(By.xpath(prop.getProperty("EnglishToSpanish"))).click();
			driver.findElement(By.xpath(prop.getProperty("SubSearch"))).click();

			//display the translation in the console
			WebElement e1= driver.findElement(By.xpath(prop.getProperty("translate")));
			System.out.println( searchkey+" Translation to Spanish :"+e1.getText());

			System.out.println(driver.getTitle());
			// assertTrue(driver.getTitle().contains(searchkey.toString()));
		}

		//navigating to home page
		driver.navigate().to(prop.getProperty("url"));
		driver.findElement(By.xpath(prop.getProperty("facebook"))).click();	

		//window handle -Cambridge Facebook window
		Set<String> windows=driver.getWindowHandles();
		Object parent=null;
		Object child=null;
		Iterator it=windows.iterator();
		while(it.hasNext())
		{
			parent =it.next();
			child =it.next();
		}

		//switch to child window- Cambridge Facebook window
		driver.switchTo().window((String) child);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		//Fetching the url of child window- Cambridge Facebook window
		String strUrl=driver.getCurrentUrl();
		System.out.println("Current URL is: "+strUrl);

		//Fetching the Title of child window- Cambridge Facebook window
		String strTitle=driver.getTitle();
		System.out.println("The title of the page is: "+strTitle);

		//Assert.assertTrue(driver.getTitle().matches("Cambridge ^[a-zA-Z]+ - [a-zA-Z]o[a-zA-Z][a-zA-Z]$"));

		driver.quit();

	}


}