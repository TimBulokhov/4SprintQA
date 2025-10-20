package page;

import org.junit.Assert;
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

    // Локаторы для FAQ - ответы
    private By answerCost = By.xpath("//div[@data-accordion-component='AccordionItemPanel']/p[text()='Сутки — 400 рублей. Оплата курьеру — наличными или картой.']");
    private By answerMultipleScooters = By.xpath("//div[@data-accordion-component='AccordionItemPanel']/p[text()='Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.']");
    private By answerRentalTime = By.xpath("//div[@data-accordion-component='AccordionItemPanel']/p[text()='Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.']");
    private By answerOrderToday = By.xpath("//div[@data-accordion-component='AccordionItemPanel']/p[text()='Только начиная с завтрашнего дня. Но скоро станем расторопнее.']");
    private By answerExtendReturn = By.xpath("//div[@data-accordion-component='AccordionItemPanel']/p[text()='Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.']");
    private By answerCharging = By.xpath("//div[@data-accordion-component='AccordionItemPanel']/p[text()='Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.']");
    private By answerCancelOrder = By.xpath("//div[@data-accordion-component='AccordionItemPanel']/p[text()='Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.']");
    private By answerPaymentArea = By.xpath("//div[@data-accordion-component='AccordionItemPanel']/p[text()='Да, обязательно. Всем самокатов! И Москве, и Московской области.']");

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

    // Индивидуальные методы для каждого вопроса (альтернативный подход)
    public void clickCostQuestion() {
        driver.findElement(questionCost).click();
    }

    public void clickMultipleScootersQuestion() {
        driver.findElement(questionMultipleScooters).click();
    }

    public void clickRentalTimeQuestion() {
        driver.findElement(questionRentalTime).click();
    }

    public void clickOrderTodayQuestion() {
        driver.findElement(questionOrderToday).click();
    }

    public void clickExtendReturnQuestion() {
        driver.findElement(questionExtendReturn).click();
    }

    public void clickChargingQuestion() {
        driver.findElement(questionCharging).click();
    }

    public void clickCancelOrderQuestion() {
        driver.findElement(questionCancelOrder).click();
    }

    public void clickPaymentAreaQuestion() {
        driver.findElement(questionPaymentArea).click();
    }

    public void verifyAnswerDisplayed(int answerNumber) {
        By answerLocator = getAnswerLocator(answerNumber);
        new WebDriverWait(driver, Duration.ofSeconds(15))
                .until(ExpectedConditions.visibilityOfElementLocated(answerLocator));
        Assert.assertTrue(driver.findElement(answerLocator).isDisplayed());
    }

    // Индивидуальные методы для проверки каждого ответа
    public void verifyCostAnswerDisplayed() {
        waitAndVerifyAnswerDisplayed(answerCost);
    }

    public void verifyMultipleScootersAnswerDisplayed() {
        waitAndVerifyAnswerDisplayed(answerMultipleScooters);
    }

    public void verifyRentalTimeAnswerDisplayed() {
        waitAndVerifyAnswerDisplayed(answerRentalTime);
    }

    public void verifyOrderTodayAnswerDisplayed() {
        waitAndVerifyAnswerDisplayed(answerOrderToday);
    }

    public void verifyExtendReturnAnswerDisplayed() {
        waitAndVerifyAnswerDisplayed(answerExtendReturn);
    }

    public void verifyChargingAnswerDisplayed() {
        waitAndVerifyAnswerDisplayed(answerCharging);
    }

    public void verifyCancelOrderAnswerDisplayed() {
        waitAndVerifyAnswerDisplayed(answerCancelOrder);
    }

    public void verifyPaymentAreaAnswerDisplayed() {
        waitAndVerifyAnswerDisplayed(answerPaymentArea);
    }

    private void waitAndVerifyAnswerDisplayed(By answerLocator) {
        new WebDriverWait(driver, Duration.ofSeconds(15))
                .until(ExpectedConditions.visibilityOfElementLocated(answerLocator));
        Assert.assertTrue(driver.findElement(answerLocator).isDisplayed());
    }

    public void scrollToFAQTable() {
        WebElement tableFAQ = driver.findElement(faqTable);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", tableFAQ);
    }

    public void closeCookieButton() {
        driver.findElement(closeButtonCookie).click();
    }

    // Вспомогательные методы для получения локаторов по номеру (оставлены для обратной совместимости)
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

    private By getAnswerLocator(int number) {
        switch (number) {
            case 1: return answerCost;
            case 2: return answerMultipleScooters;
            case 3: return answerRentalTime;
            case 4: return answerOrderToday;
            case 5: return answerExtendReturn;
            case 6: return answerCharging;
            case 7: return answerCancelOrder;
            case 8: return answerPaymentArea;
            default: throw new IllegalArgumentException("Invalid answer number: " + number);
        }
    }

    public void openPage() {
        driver.get(URL);
    }
}