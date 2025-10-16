import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import page.FAQPage;

import java.time.Duration;

public class BaseTest1 {
    WebDriver driver = new ChromeDriver();
    //    WebDriver driver = new FirefoxDriver();
    FAQPage faqPage;


    @Before
    public void startUp() {
        // Создаём драйвер для браузера Chrome
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox", "--disable-dev-shm-usage");
        driver = new ChromeDriver(options);

        // Создаём драйвер для браузера Firefox
//        FirefoxOptions options = new FirefoxOptions();
//        options.addArguments("--no-sandbox", "--disable-dev-shm-usage");
//        driver = new FirefoxDriver(options);

        faqPage = new FAQPage(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}