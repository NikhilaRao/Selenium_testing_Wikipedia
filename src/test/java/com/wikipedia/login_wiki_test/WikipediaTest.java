package com.wikipedia.login_wiki_test;

import static org.junit.Assert.assertTrue;

import javax.sql.rowset.serial.SerialArray;

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
		
		//open wikipedia webpage
		driver.get("https://www.wikipedia.org/");
		
		//verify if the page has openend
		String response = driver.getPageSource();
        assertTrue("Validation FAILED -Text \" Wikipedia\" NOT FOUND",
                response.contains("Wikipedia"));

        //select language--english
        WebElement selectEngligh = driver.findElement(By.xpath("//a[contains(@href, '//en.wikipedia.org')] "));
        selectEngligh.click();
        
        //login
        WebElement loginButton = driver.findElement(By.linkText("Log in"));
        loginButton.click();        
        
        WebElement userName = driver.findElement(By.id("wpName1"));
        userName.clear();
        userName.sendKeys("NikhilaRao");
        
        WebElement password = driver.findElement(By.id("wpPassword1"));
        password.clear();
        password.sendKeys("9902576984");
        
        WebElement login = driver.findElement(By.id("wpLoginAttempt"));
        login.click();
        
        //research about wikipedia
        WebElement searchBox = driver.findElement(By.id("searchInput"));
        searchBox.clear();
        searchBox.sendKeys("Northern Lights");

        WebElement search = driver.findElement(By.id("searchButton"));
        search.click();
        
        response = driver.getPageSource();
        //WebElement headingText = driver.findElement(By.xpath( "\\h1[contains(text(), 'Wikipedia')]" ) );
        assertTrue("Validation FAILED -Text \" Northern lights\" NOT FOUND",
                response.contains("Northern lights"));
        
        //logout
        WebElement logout = driver.findElement(By.linkText("Log out"));
        logout.click();
        
        response = driver.getPageSource();
        assertTrue("Validation FAILED -Text \" Log out\" NOT FOUND",
                response.contains("Log out"));
        
        driver.close();
	}
	
	@Test
	public void LoginFail(){
		
		//driver = new FirefoxDriver();
		
		//login fail-- password field left empty
		
		
	}
	
}
