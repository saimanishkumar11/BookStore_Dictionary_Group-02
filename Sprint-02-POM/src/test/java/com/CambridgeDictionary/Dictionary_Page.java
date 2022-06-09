package com.CambridgeDictionary;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class Dictionary_Page {
	@FindBy(xpath="//span[.='Dictionary']")
	private WebElement dictionary_Btn;

	@FindBy(xpath="//amp-img[@class='i-amphtml-element i-amphtml-layout-fixed i-amphtml-layout-size-defined i-amphtml-built i-amphtml-layout']")
	private WebElement logo;

	@FindBy(id="searchword")
	private WebElement searchField;

	@FindBy(xpath="//button[@title='Search']")
	private WebElement search_btn;

	@FindBy(xpath="//a[.='Word of the Year']")
	private WebElement word;

	@FindBy(xpath="//div[@title='Listen to the British English pronunciation']")
	private WebElement listen;

	public Dictionary_Page(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}

	public void dictionary_btn()
	{
		dictionary_Btn.click();
	}
	public void application_logo()
	{
		if(logo.isDisplayed())
		{
			System.out.println("Logo is present");
		}
		else
		{
			System.out.println("Logo is not present");
		}
	}

	public void searchField(String sheet,int rowNum,int cellNum) throws EncryptedDocumentException, IOException, InvalidFormatException
	{
		searchField.sendKeys(ExcelUtility.getValueFromExcel(sheet,rowNum,cellNum));

	}
	public void search_btn(WebDriver driver,String title)
	{
		search_btn.click();
		listenUKPronunciation();
		if(driver.getTitle().contains(title))
		{
			System.out.println("User found the "+title +" meaning");
		}
		else
		{
			System.out.println("User could not find the "+title+" meaning");
		}
	}
	public void clear_searchField()
	{
		searchField.clear();
	}
	public void word_Of_The_Year(WebDriver driver,String wordoftheyear)
	{
		word.click();
		System.out.println(driver.getTitle());
		if(driver.getTitle().contains(wordoftheyear))
		{
			System.out.println("User got the word of the year");
		}
		else
		{
			System.out.println("User could not get the word of the year");
		}
	}
	public void listenUKPronunciation()
	{
		listen.click();
	}
}
