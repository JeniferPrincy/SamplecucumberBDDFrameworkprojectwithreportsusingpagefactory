package com.google.Pages;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.google.utils.Excel;

public class GoogleSearchSteps {

	@FindBy(name="q")
	@CacheLookup
	WebElement searchBox;

	@FindBy(tagName="a")
	@CacheLookup
	private List<WebElement> webElements;
	
	
	WebDriver driver;
	public GoogleSearchSteps(WebDriver driver) {
		this.driver=driver;
		 PageFactory.initElements(driver, this);

	}
	public void Search_text(String TextToSearch) {
		searchBox.sendKeys(TextToSearch);
	}

	public void Clicks_Enter() {
		searchBox.sendKeys(Keys.ENTER);
	}
	
	public void getTitles() {
		String title=driver.getTitle();
		System.out.println("  The current page title is "+title);

	}

	public void Available_Links() throws IOException  {

		List <WebElement> link =webElements;

		int count=link.size();
		System.out.println("  The total number of links are  "+count);
		Excel excel=new Excel(driver);
		excel.excelData(count);

}


}
