package TranslaterAndGrammer;

import static org.junit.Assert.assertTrue;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TGStepdef {
	
	
	private static XSSFWorkbook workbook = null;
	WebDriver driver = null;
	    @Before public void setUp(){    
	         System.setProperty("webdriver.chrome.driver", "D:\\chromedriver\\chromedriver.exe"); 
	         driver = new ChromeDriver();    
	       }    
//   adjectives and adverbs   
	    @Given("^user navigates to \"([^\"]*)\"$")
	    public void user_navigates_to_Dictionary(String arg1) {
	         driver.navigate().to("https://dictionary.cambridge.org"); 
	         System.out.println("user is in home page");
	         driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	         driver.findElement(By.id("onetrust-accept-btn-handler")).click();
	    }
	    
	    @When("user click on the grammar")
		public void user_click_on_the_grammar() {
		    driver.findElement(By.xpath("//body[1]/header[1]/div[1]/div[1]/nav[1]/ul[1]/li[3]/a[1]/span[1]")).click();
		    System.out.println("user clicked on grammer");
		}
	    
	    @And("user click on the adjectives and adverbs")
		public void user_click_on_the_adjectives_and_adverbs() {
			driver.findElement(By.linkText("Adjectives and adverbs")).click();
			System.out.println("user clicked on adjectives and adverbs");
		}
	    
	    @Then("user is able to learn about adjectives and adverbs")
		public void user_is_able_to_learn_about_adjectives_and_adverbs() {
	        String actualTitle = driver.getTitle();
	        String ExpectedTitle ="Adjectives and adverbs - English Grammar Today - Cambridge Dictionary";
	        Assert.assertEquals(ExpectedTitle,actualTitle);
	        System.out.println("test passed");
	}
	    
	//Easily confused words
	    
	   
	    @Given("user is in home page")
		public void user_is_in_home_page() {
	    	driver.navigate().to("https://dictionary.cambridge.org/");
	    	System.out.println("user is in home page");

		}
	    
	    @When("user click on the Grammar link")
		public void user_click_on_the_grammar_link() {
			driver.findElement(By.linkText("Grammar")).click();
			System.out.println("user clicked on Grammer");

		}

		@And("user click on the Easily confused words link")
		public void user_click_on_the_Easily_confused_words_link() {
			driver.findElement(By.linkText("Easily confused words")).click();
			System.out.println("user clicked on easily confused words");
		}

		@Then("user is able to learn about Easily confused words")
		public void user_is_able_to_learn_about_Easily_confused_words() {
			String ActualTitle = driver.getTitle();
            String ExpectedTitle = "Easily confused words - English Grammar Today - Cambridge Dictionary";
            Assert.assertEquals(ExpectedTitle, ActualTitle);
            System.out.println("test case passed");
		}
	    
	    //Nouns pronouns and determiners
		
		@Given("user navigated to the Cambridge Dictionary website")
		public void user_navigated_to_the_cambridge_dictionary_website() {
			driver.navigate().to("https://dictionary.cambridge.org/");
			System.out.println("user is in home page");
		}
		
	/*	@When("user click on the Grammar link")
		public void user_click_on_the_Grammar_link() {
			driver.findElement(By.linkText("Grammar")).click();
			System.out.println("user clicked on grammer");

		}*/

		@And("user click on the Nouns, pronouns and determiners link")
		public void user_click_on_the_Nouns_pronouns_and_determiners_link() {
			driver.findElement(By.linkText("Nouns, pronouns and determiners")).click();
			System.out.println("user clicked on Nouns, pronouns and determiners");
		}

		@Then("user is able to learn about Nouns, pronouns and determiners")
		public void user_is_able_to_learn_about_Nouns_pronouns_and_determiners() {
			 String ActualTitle = driver.getTitle();
             String ExpectedTitle = "Nouns, pronouns and determiners - English Grammar Today - Cambridge Dictionary";
             Assert.assertEquals(ExpectedTitle, ActualTitle);
             System.out.println("Nouns, pronouns and determiners - English Grammar Today - Cambridge Dictionary page is verified");
		}
		
		//preposition and particles
		
		/*@Given("user navigated to the Cambridge Dictionary website")
		public void user_navigated_to_the_cambridge_Dictionary_website() {
			// Write code here that turns the phrase above into concrete actions
			driver.navigate().to("https://dictionary.cambridge.org/");
			System.out.println("user is in home page");
		}*/
		
		@When("user click on the Prepositions and particles link")
		public void user_click_on_the_Prepositions_and_particles_link() {
			driver.findElement(By.linkText("Prepositions and particles")).click();
			System.out.println("user clicked on Prepositions and particles");
		}
		
		@Then("user is able to learn about Prepositions and particles")
		public void user_is_able_to_learn_about_Prepositions_and_particles() {
			String ActualTitle = driver.getTitle();
            String ExpectedTitle = "Prepositions and particles - English Grammar Today - Cambridge Dictionary";
            Assert.assertEquals(ExpectedTitle, ActualTitle);
            System.out.println("Prepositions and particles - English Grammar Today - Cambridge Dictionary page is verified");	
	}
		
	//using English
		
		@When("user click on the Using English link")
		public void user_click_on_the_Using_English_link() {
			driver.findElement(By.linkText("Using English")).click();
			System.out.println("user clicked on using English");
		}

		@Then("user is able to learn about Using English")
		public void user_is_able_to_learn_about_Using_English() {	
	        String ActualTitle = driver.getTitle();
	        String ExpectedTitle = "Using English - English Grammar Today - Cambridge Dictionary";
	        Assert.assertEquals(ExpectedTitle, ActualTitle);
	        System.out.println("Using English - English Grammar Today - Cambridge Dictionary page is verified");
		
		}
		
		//verbs
		
		@When("user click on the Verbs link")
		public void user_click_on_the_verbs_link() {
			driver.findElement(By.linkText("Verbs")).click();
			System.out.println("user clicked on verbs");
		}

		@Then("user is able to learn about Verbs")
		public void user_is_able_to_learn_about_verbs() {	 
	        String ActualTitle = driver.getTitle();
	        String ExpectedTitle = "Verbs - English Grammar Today - Cambridge Dictionary";
	        Assert.assertEquals(ExpectedTitle, ActualTitle);
	       // System.out.println("Verbs - English Grammar Today - Cambridge Dictionary page is verified");
			
		}
		
		//word sentence and clauses
		
		@When("user click on the Words,Sentences and Clauses link")
		public void user_click_on_the_Words_Sentences_and_Clauses_link() {		 
			driver.findElement(By.linkText("Words, sentences and clauses")).click();
			System.out.println("Words, sentences and clauses");
		}

		@Then("user is able to learn about Words, sentences and clauses")
		public void user_is_able_to_learn_about_Words_sentences_and_clauses() {
	        String ActualTitle = driver.getTitle();
	        String ExpectedTitle = "Words, sentences and clauses - English Grammar Today - Cambridge Dictionary";
	        Assert.assertEquals(ExpectedTitle, ActualTitle);
	        System.out.println("Words, sentences and clauses - English Grammar Today - Cambridge Dictionary page is verified");
		
		}
		
		//translate
		
		@When("user clicks on English to japanese traslation")
		public void user_clicks_on_english_to_japanese_traslation() throws InterruptedException {
			driver.manage().window().maximize();
			Thread.sleep(2000);
			JavascriptExecutor jss=(JavascriptExecutor)driver;
			jss.executeScript("window.scrollBy(0,300)"); 
			System.out.println("user scrolled");
			driver.findElement(By.xpath("//body[1]/div[3]/div[2]/div[1]/div[2]/div[2]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/ul[1]/li[5]/a[1]")).click();
			System.out.println("user clicked on English-Japanese translation link");
		
		}
		@And("search for sentence and get transalation")
		public void search_for_sentence_and_get_transalation() throws IOException, InterruptedException {
			FileInputStream fis = new FileInputStream("D:\\Capgemini Training\\Sprint 2\\translation.xlsx");
			workbook =new XSSFWorkbook(fis);
			XSSFSheet ws = workbook.getSheetAt(0);
		
			int rownum = ws.getLastRowNum();
			int colnum =ws.getRow(0).getPhysicalNumberOfCells();
			System.out.println(colnum);
			System.out.println(rownum);
			XSSFCell searchkey;
			for(int i=0; i<=rownum;i++) { 
				
			
	    	//driver.findElement(By.name("q")).clear();
				searchkey= ws.getRow(i).getCell(0);
				System.out.println("sentence which need translation :"+searchkey);
	    	
			//WebElement textbox = driver.findElement(By.id("onetrust-accept-btn-handler"));
		      //textbox.sendKeys(Keys.RETURN);
	
	    	driver.findElement(By.name("q")).sendKeys(searchkey.toString());
	    	System.out.println("user enter sentence: "+searchkey);
	    	Thread.sleep(2000);
	    	driver.findElement(By.xpath("//body[1]/div[3]/div[1]/div[2]/div[1]/div[1]/div[2]/form[1]/div[1]/div[1]/span[1]/button[3]")).click();
	    	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	    	driver.navigate().back();
			
			System.out.println("user got translation for :"+searchkey);
			System.out.println(driver.getTitle());
			//assertTrue(driver.getTitle().contains(searchkey.toString()));
		    
		}

		}

		
	 
	    
	    @After public void closeBrowser(){    
	          driver.close();    
	    }

}
