package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderMainPage {
    public static final String URL = "https://qa-scooter.praktikum-services.ru/";
    private WebDriver driver;
    private By mainOrderButton = By.className("Button_Button__ra12g");


    public OrderMainPage(WebDriver driver) {
        this.driver = driver;
    }
    public void clickMainOrderButton() {
        driver.findElement(mainOrderButton).click();
    }

    public void openPage() {
        driver.get(URL);
    }
}