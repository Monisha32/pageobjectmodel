import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTest {

    WebDriver driver;

    @BeforeMethod
    public void setup() {
        // Setup ChromeDriver automatically
        WebDriverManager.chromedriver().setup();

        // Initialize ChromeDriver
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Navigate to login page (replace with your actual URL)
        driver.get("https://example.com/login");
    }

    @Test
    public void testValidLogin() {
        // Find and fill username field
        driver.findElement(By.id("username")).sendKeys("testuser");

        // Find and fill password field
        driver.findElement(By.id("password")).sendKeys("testpassword");

        // Click login button
        driver.findElement(By.id("loginBtn")).click();

        // Wait a bit for page to load
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Verify successful login (adjust based on your application)
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("dashboard"),
            "Login failed - Expected to be on dashboard page");

        System.out.println("✓ Login test passed!");
    }

    @Test
    public void testInvalidLogin() {
        // Try login with invalid credentials
        driver.findElement(By.id("username")).sendKeys("wronguser");
        driver.findElement(By.id("password")).sendKeys("wrongpass");
        driver.findElement(By.id("loginBtn")).click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Verify error message appears or stays on login page
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("login"),
            "Should remain on login page with invalid credentials");

        System.out.println("✓ Invalid login test passed!");
    }

    @AfterMethod
    public void tearDown() {
        // Close browser
        if (driver != null) {
            driver.quit();
        }
    }
}
