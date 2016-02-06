package com.wikipedia.login_wiki_test;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import junit.framework.TestCase;
import junit.framework.TestSuite;

public class WikipediaTest{

	WebDriver driver;
	
	@Test
	public void wikiSignIn() {
		
		driver = new FirefoxDriver();
		driver.get("https://www.wikipedia.org/");
		
		String response = driver.getPageSource();
        assertTrue("Validation FAILED -Text \" Wikipedia\" NOT FOUND",
                response.contains("Wikipedia"));

        WebElement selectEngligh = driver.findElement(By.xpath("//a[contains(@href, '//en.wikipedia.org')] "));
        selectEngligh.click();
        
        
	}
}
