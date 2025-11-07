import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import page.MainPage;
import page.OrderPage;

import java.time.Duration;

public class BaseTest {
    protected WebDriver driver;
    protected MainPage mainPage;
    protected OrderPage orderPage;

    @Before
    public void startUp() {
        // Создаём драйвер для браузера Chrome
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox", "--disable-dev-shm-usage");
        driver = new ChromeDriver(options);
        mainPage = new MainPage(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}