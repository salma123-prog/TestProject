package com.example.test.my_first_automation;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Hello world!
 *
 */
public class App 
{
	@Test  
	public static void main(String[] args) throws InterruptedException {
        // Set the path to the ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", "C:\\selenium webdriver\\chromedriver-win64\\chromedriver.exe");
        
        // Create a WebDriver instance
        WebDriver driver = new ChromeDriver();
        
        // Open Google
        driver.get("https://www.google.com/");
        driver.findElement(By.className("gLFyf")).sendKeys("12 gaun"); // Stray ')'
        
        // Print the page title
       
        
        // Close the browser
        //driver.quit();
        driver.findElement(By.className("gLFyf")).sendKeys(Keys.RETURN);
        
        Thread.sleep(10000);
        driver.close();
        
    }
}
