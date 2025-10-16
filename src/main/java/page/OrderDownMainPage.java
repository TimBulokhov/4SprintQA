package page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OrderDownMainPage {
    public static final String URL = "https://qa-scooter.praktikum-services.ru/";
    private WebDriver driver;
    private By buttomButtonOrder = By.cssSelector("button.Button_Button__ra12g.Button_Middle__1CSJM");

    public OrderDownMainPage(WebDriver driver) {
        this.driver = driver;
    }
    public void clickBottomButtonOrder() {
        driver.findElement(buttomButtonOrder).click();
    }

    public void scrollBottomButtonOrder() {
        WebElement bottomButtonOrder = driver.findElement(buttomButtonOrder);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", bottomButtonOrder);
    }

    public void openPage() {
        driver.get(URL);
    }
}