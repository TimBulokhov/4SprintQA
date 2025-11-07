package page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage {
    public static final String URL = "https://qa-scooter.praktikum-services.ru/";
    private WebDriver driver;

    // Локаторы для кнопок заказа
    private By mainOrderButton = By.className("Button_Button__ra12g");
    private By bottomOrderButton = By.cssSelector("button.Button_Button__ra12g.Button_Middle__1CSJM");

    // Локаторы для FAQ - вопросы
    private By questionCost = By.id("accordion__heading-0");
    private By questionMultipleScooters = By.id("accordion__heading-1");
    private By questionRentalTime = By.id("accordion__heading-2");
    private By questionOrderToday = By.id("accordion__heading-3");
    private By questionExtendReturn = By.id("accordion__heading-4");
    private By questionCharging = By.id("accordion__heading-5");
    private By questionCancelOrder = By.id("accordion__heading-6");
    private By questionPaymentArea = By.id("accordion__heading-7");

    // Универсальный локатор для активного ответа
    private By activeAnswer = By.cssSelector("[data-accordion-component='AccordionItemPanel']:not([hidden])");

    private By closeButtonCookie = By.cssSelector("button.App_CookieButton__3cvqF");
    private By faqTable = By.xpath(".//div[@class='accordion']");

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    // Методы для работы с кнопками заказа
    public void clickMainOrderButton() {
        driver.findElement(mainOrderButton).click();
    }

    public void clickBottomOrderButton() {
        driver.findElement(bottomOrderButton).click();
    }

    public void scrollToBottomOrderButton() {
        WebElement bottomButtonOrder = driver.findElement(bottomOrderButton);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", bottomButtonOrder);
    }

    // Методы для работы с FAQ
    public void clickQuestion(int questionNumber) {
        By questionLocator = getQuestionLocator(questionNumber);
        driver.findElement(questionLocator).click();
    }

    // Получение текста активного ответа
    public String getActiveAnswerText() {
        new WebDriverWait(driver, Duration.ofSeconds(15))
                .until(ExpectedConditions.visibilityOfElementLocated(activeAnswer));
        WebElement answerElement = driver.findElement(activeAnswer);
        return answerElement.getText().trim();
    }

    // Проверка что ответ отображается
    public boolean isAnswerDisplayed() {
        try {
            new WebDriverWait(driver, Duration.ofSeconds(5))
                    .until(ExpectedConditions.visibilityOfElementLocated(activeAnswer));
            return driver.findElement(activeAnswer).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void scrollToFAQTable() {
        WebElement tableFAQ = driver.findElement(faqTable);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", tableFAQ);
    }

    public void closeCookieButton() {
        driver.findElement(closeButtonCookie).click();
    }

    // Вспомогательные методы для получения локаторов по номеру
    private By getQuestionLocator(int number) {
        switch (number) {
            case 1: return questionCost;
            case 2: return questionMultipleScooters;
            case 3: return questionRentalTime;
            case 4: return questionOrderToday;
            case 5: return questionExtendReturn;
            case 6: return questionCharging;
            case 7: return questionCancelOrder;
            case 8: return questionPaymentArea;
            default: throw new IllegalArgumentException("Invalid question number: " + number);
        }
    }

    public void openPage() {
        driver.get(URL);
    }
}