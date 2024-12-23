import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Saucedemo_CheckoutTest {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();  // Set up WebDriverManager for Chrome
        driver = new ChromeDriver();  // Launch Chrome browser
        driver.manage().window().maximize();  // Maximize browser window
    }

    @Test
    public void testCheckout() throws InterruptedException {
        driver.get("https://www.saucedemo.com/");

        // Log in
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        // Add products to the cart
        driver.findElement(By.xpath("//button[@data-test='add-to-cart-sauce-labs-backpack']")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//button[@data-test='add-to-cart-sauce-labs-bike-light']")).click();
        Thread.sleep(5000);


        // Navigate to the cart
        driver.findElement(By.className("shopping_cart_link")).click();

        // Click on checkout
        driver.findElement(By.id("checkout")).click();

        // Fill in checkout details
        driver.findElement(By.id("first-name")).sendKeys("John");
        driver.findElement(By.id("last-name")).sendKeys("Doe");
        driver.findElement(By.id("postal-code")).sendKeys("12345");
        driver.findElement(By.id("continue")).click();
        driver.findElement(By.id("finish")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//button[text()='Back Home']")).click();
        Thread.sleep(5000);


        // Verify checkout summary is displayed
        WebElement checkoutSummary = driver.findElement(By.className("summary_info"));
        Assert.assertTrue(checkoutSummary.isDisplayed(), "Checkout summary not displayed!");
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            //driver.quit();  // Close the browser after the test
        }
    }
}
