 

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.Assert;
import io.github.bonigarcia.wdm.WebDriverManager;


public class DemoSauce_LoginTest {
	//salma comment
    WebDriver driver;

    // Set up WebDriver before each test
    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup(); // Automatically manage ChromeDriver
        driver = new ChromeDriver(); // Launch Chrome browser
        driver.manage().window().maximize(); // Maximize the browser window
    }

    // Test case: Valid Login
    @Test
    public void testValidLogin() {
        // Navigate to Saucedemo login page
        driver.get("https://www.saucedemo.com/");

        // Enter valid username and password
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");

        // Click the Login button
        driver.findElement(By.id("login-button")).click();

        // Assert that the user is redirected to the inventory page
        String expectedUrl = "https://www.saucedemo.com/inventory.html";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, expectedUrl, "Login failed or URL mismatch!");
    }

    // Tear down WebDriver after each test
    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            //driver.quit(); // Close the browser
        }
    }
}


