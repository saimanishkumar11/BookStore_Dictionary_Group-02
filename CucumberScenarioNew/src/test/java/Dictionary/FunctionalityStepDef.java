package Dictionary;

import static org.junit.Assert.assertTrue;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When; 

public class FunctionalityStepDef {
	
	private static final String wait = null;
	private static final String ExceptedConditions = null;
	private static XSSFWorkbook workbook;
	//setup method-->Hooks
	
	 WebDriver driver = null;
	   @Before public void setUp(){    
	         System.setProperty("webdriver.chrome.driver", "D:\\chromedriver\\chromedriver.exe"); 
	         driver = new ChromeDriver();    
	       }    
	    
	    //Successful logo
	    
	    @Given("^User navigates to \"([^\"]*)\"$")
	    public void User_navigates_to_Guru99Bank(String arg1) {   
	         driver.navigate().to("https://dictionary.cambridge.org"); 
	         System.out.println("user is in home page");
	         driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	    }


	    @When("user finds the logo")
	    public void user_finds_the_logo() {
	       WebElement element= driver.findElement(By.xpath("//body[1]/div[3]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/a[1]/amp-img[1]/img[1]"));
	       System.out.println("user find logo");
	   }

	    //assertion for validating the logo
	    @Then("user validate the logo")
	    public void user_validate_the_logo() {	    	
	    	boolean b1 = driver.findElement(By.xpath("//body[1]/div[3]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/a[1]/amp-img[1]/img[1]")).isDisplayed(); 
			System.out.println("logo is verified : "+b1);

	    }

	 //User learns new word from word of the year
	    
	   @Given("user is in home page")    
	    public void user_is_in_home_page() {    
		   driver.navigate().to("https://dictionary.cambridge.org"); 
	       System.out.println("user is on home page");  
	       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	       driver.findElement(By.id("onetrust-accept-btn-handler")).click();
	    }
	    	    
	    @When("user scrolls")
	    public void user_scrolls() {
	    	JavascriptExecutor jss=(JavascriptExecutor)driver;
			jss.executeScript("window.scrollBy(0,1000)"); 
			System.out.println("user scrolled");
	    }
	    
	    @When("user clicks on word of the year")
	    public void user_clicks_on_word_of_the_year() {	
	      driver.findElement(By.xpath("//body[1]/footer[1]/div[1]/div[2]/div[1]/div[2]/a[6]")).click();
	      System.out.println("user clicked on word of the year");
	    }
	    
	    @Then("user finds word of the year")
	    public void user_finds_word_of_the_year() {	    
	    	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));	    	 
	    	 JavascriptExecutor jss=(JavascriptExecutor)driver;
			 jss.executeScript("window.scrollBy(0,1000)"); 
	    	
			 //assertion for validating word of the year
	    	    boolean b1 = driver.findElement(By.xpath("//body")).isDisplayed(); 
			    System.out.println(b1);				
				String ActualTitle = driver.getTitle();
				String ExpectedTitle = "The Cambridge Dictionary Word of the Year";
				Assert.assertEquals(ExpectedTitle, ActualTitle);
				System.out.println("Word of the year page is verified");
		
	    }
	    
	    //user use dictionay to get meaning of the words-->reading the data from extenal file
	    
	    @Then("^user enters (.*) to get meaning$")
		public void user_enters_word_to_get_meaning(String word) throws InterruptedException {
	    	driver.findElement(By.name("q")).sendKeys(word);
	    	Thread.sleep(2000);
	    	driver.findElement(By.xpath("//body[1]/div[3]/div[1]/div[2]/div[1]/div[1]/div[2]/form[1]/div[1]/div[1]/span[1]/button[3]/i[1]")).click();
	    	System.out.println("user got the meaning for :"+word);
			System.out.println(driver.getTitle());
			assertTrue(driver.getTitle().contains(word.toString()));
			}
		
         //user listens to British English Pronounciation
	    
	    @Then("^user seacrh for word to listen in British English Pronounciation$")
	    public void user_seacrh_for_word_to_listen_in_British_English_Pronounciation(DataTable word) throws InterruptedException  {
	    	List<List<String>> data = word.cells();
	    	driver.findElement(By.name("q")).sendKeys(data.get(0).get(0));
	    	System.out.println("user enter word: "+data.get(0).get(0));
	    	Thread.sleep(2000);
	    	driver.findElement(By.xpath("//body[1]/div[3]/div[1]/div[2]/div[1]/div[1]/div[2]/form[1]/div[1]/div[1]/span[1]/button[3]/i[1]")).click();
	    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			driver.findElement(By.xpath("//body[1]/div[2]/div[1]/div[1]/div[2]/article[1]/div[2]/div[1]/div[2]/div[1]/div[3]/div[1]/div[1]/div[1]/div[2]/span[1]/span[2]/div[1]")).click();
			System.out.println("user listnes to British English Pronounciation  for :"+data.get(0).get(0));
			System.out.println(driver.getTitle());
			assertTrue(driver.getTitle().contains(data.get(0).get(0).toString()));
	    	
	    }

	 //user looks for cambridge dictionary facebook page

	    @When("user clicks on facebook logo")
	    public void user_clicks_on_facebook_logo() throws InterruptedException {
	    	driver.get("https://dictionary.cambridge.org/");
	    	Thread.sleep(2000);
	    	driver.findElement(By.xpath("//body[1]/header[1]/div[1]/div[2]/ul[1]/li[1]/a[1]")).click();
	    	System.out.println("user clicked on facebook logo");
	       
	    }
	    
	    @Then("user navigate to cambridge dictionary facebook page")
	    public void user_navigate_to_cambridge_dictionary_facebook_page() {
	    	
	    	 String url="https://www.facebook.com/CUPCambridgeDictionary/";
	    	 driver.get(url);
	    	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	    	 String strUrl=driver.getCurrentUrl();
	    	 System.out.println("Current URL is: "+strUrl);
	    	 
	    	 String ActualUrl = driver.getCurrentUrl();
			 String ExpectedTitle = "https://www.facebook.com/CUPCambridgeDictionary/";
			 Assert.assertEquals(ExpectedTitle, ActualUrl);
			 System.out.println("Facebook page is verified");    	 
	    }

	    
	    //Negative scenario
	    
	    @When("user enters invalid words error message is displayed")
	    public void user_enters_invalid_words_error_message_is_displayed() throws IOException, InterruptedException {
	    	FileInputStream fis = new FileInputStream("D:\\Capgemini Training\\Sprint 2\\invalidsearch.xlsx");
			workbook =new XSSFWorkbook(fis);
			XSSFSheet ws = workbook.getSheetAt(0);			
			int rownum = ws.getLastRowNum();
			int colnum =ws.getRow(0).getPhysicalNumberOfCells();
			System.out.println(colnum);
			System.out.println(rownum);
			XSSFCell searchkey;
			for(int i=0; i<=rownum;i++) { 
				
			driver.get("https://dictionary.cambridge.org/");
	    	driver.findElement(By.name("q")).clear();
			searchkey= ws.getRow(i).getCell(0);
			System.out.println("word for which user needs meaning :"+searchkey);
	    	

	    	driver.findElement(By.name("q")).sendKeys(searchkey.toString());
	    	System.out.println("user enter word: "+searchkey);
	    	Thread.sleep(2000);
	    	driver.findElement(By.xpath("//body[1]/div[3]/div[1]/div[2]/div[1]/div[1]/div[2]/form[1]/div[1]/div[1]/span[1]/button[3]/i[1]")).click();
	    	System.out.println("user got the error message");
	    	
	    	String expterrormsg="Your search terms did not match any entries.";
	    	String actualerrormsg= driver.findElement(By.xpath("//body[1]/div[2]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/h1[1]")).getText();
	    	Assert.assertEquals(expterrormsg, actualerrormsg);
	    	System.out.println("error msg got verifed");
	    	
	    }

	    }

//teardown
	    
		@After public void closeBrowser(){    
	          driver.close();    
	    }
	
	  
}


