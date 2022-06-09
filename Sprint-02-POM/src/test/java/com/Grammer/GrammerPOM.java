package com.Grammer;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GrammerPOM {

	@FindBy(xpath="//body[1]/header[1]/div[1]/div[1]/nav[1]/ul[1]/li[3]/a[1]/span[1]")
	private WebElement grammar;

	@FindBy(xpath="/html/body/div[3]/div[2]/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/a[1]")
	private WebElement adjectives;

	@FindBy(xpath="/html/body/div[3]/div[2]/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/a[2]")
	private WebElement easily_confused;

	@FindBy(xpath="//body[1]/div[3]/div[2]/div[1]/div[2]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/a[3]")
	private WebElement Nouns;

	@FindBy(xpath="//body[1]/div[3]/div[2]/div[1]/div[2]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/a[4]")
	private WebElement preposition;

	@FindBy(xpath="//body[1]/div[3]/div[2]/div[1]/div[2]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/a[5]")
	private WebElement using_English;

	@FindBy(xpath="//body[1]/div[3]/div[2]/div[1]/div[2]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/a[6]")
	private WebElement verbs;

	@FindBy(xpath="//body[1]/div[3]/div[2]/div[1]/div[2]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/a[7]")
	private WebElement clauses;

	public GrammerPOM(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}

	public void grammar() {
		grammar.click();

	}

	public void adjectives() {
		adjectives.click();

	}

	public void easily_confused() {
		easily_confused.click();
	}


	public void Nouns() {
		Nouns.click();
	}

	public void preposition() {
		preposition.click();
	}

	public void using_English() {
		using_English.click();
	}

	public void verbs() {
		verbs.click();
	}

	public void clauses() {
		clauses.click();
	}
}
