package page;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FAQPage {
    public static final String URL = "https://qa-scooter.praktikum-services.ru/";
    private WebDriver driver;
    private By answerEight8 = By.xpath("//div[@data-accordion-component='AccordionItemPanel']/p[text()='Да, обязательно. Всем самокатов! И Москве, и Московской области.']");
    private By question8 = By.id("accordion__heading-7");
    private By closeButtonCookie = By.cssSelector("button.App_CookieButton__3cvqF");
    private By answerSeven7 = By.xpath("//div[@data-accordion-component='AccordionItemPanel']/p[text()='Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.']");
    private By question7 = By.id("accordion__heading-6");
    private By answerSix6 = By.xpath("//div[@data-accordion-component='AccordionItemPanel']/p[text()='Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.']");
    private By question6 = By.id("accordion__heading-5");
    private By answerFive5 = By.xpath("//div[@data-accordion-component='AccordionItemPanel']/p[text()='Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.']");
    private By question5 = By.id("accordion__heading-4");
    private By answerFour4 = By.xpath("//div[@data-accordion-component='AccordionItemPanel']/p[text()='Только начиная с завтрашнего дня. Но скоро станем расторопнее.']");
    private By question4 = By.id("accordion__heading-3");
    private By answerThree3 = By.xpath("//div[@data-accordion-component='AccordionItemPanel']/p[text()='Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.']");
    private By question3 = By.id("accordion__heading-2");
    private By answerTwo2 = By.xpath("//div[@data-accordion-component='AccordionItemPanel']/p[text()='Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.']");
    private By question2 = By.id("accordion__heading-1");
    private By answerOne1 = By.xpath("//div[@data-accordion-component='AccordionItemPanel']/p[text()='Сутки — 400 рублей. Оплата курьеру — наличными или картой.']");
    private By question1 = By.id("accordion__heading-0");
    private By table = By.xpath(".//div[@class='accordion']");



    public FAQPage(WebDriver driver) {
        this.driver = driver;
    }
    public void getAnswer8() {
        new WebDriverWait(driver, Duration.ofSeconds(15))
                .until(ExpectedConditions.visibilityOfElementLocated(answerEight8));
        Assert.assertTrue(driver.findElement(answerEight8).isDisplayed());
    }

    public void clickQuestion8() {
        driver.findElement(question8).click();
    }

    public void clickCloseButtonCookie() {
        driver.findElement(closeButtonCookie).click();
    }

    public void getAnswer7() {
        new WebDriverWait(driver, Duration.ofSeconds(15))
                .until(ExpectedConditions.visibilityOfElementLocated(answerSeven7));
        Assert.assertTrue(driver.findElement(answerSeven7).isDisplayed());
    }

    public void clickQuestion7() {
        driver.findElement(question7).click();
    }

    public void getAnswer6() {
        new WebDriverWait(driver, Duration.ofSeconds(15))
                .until(ExpectedConditions.visibilityOfElementLocated(answerSix6));
        Assert.assertTrue(driver.findElement(answerSix6).isDisplayed());
    }

    public void clickQuestion6() {
        driver.findElement(question6).click();
    }

    public void getAnswer5() {
        new WebDriverWait(driver, Duration.ofSeconds(15))
                .until(ExpectedConditions.visibilityOfElementLocated(answerFive5));
        Assert.assertTrue(driver.findElement(answerFive5).isDisplayed());
    }

    public void clickQuestion5() {
        driver.findElement(question5).click();
    }

    public void getAnswer4() {
        new WebDriverWait(driver, Duration.ofSeconds(15))
                .until(ExpectedConditions.visibilityOfElementLocated(answerFour4));
        Assert.assertTrue(driver.findElement(answerFour4).isDisplayed());
    }

    public void clickQuestion4() {
        driver.findElement(question4).click();
    }

    public void getAnswer3() {
        new WebDriverWait(driver, Duration.ofSeconds(15))
                .until(ExpectedConditions.visibilityOfElementLocated(answerThree3));
        Assert.assertTrue(driver.findElement(answerThree3).isDisplayed());
    }

    public void clickQuestion3() {
        driver.findElement(question3).click();
    }

    public void getAnswer2() {
        new WebDriverWait(driver, Duration.ofSeconds(15))
                .until(ExpectedConditions.visibilityOfElementLocated(answerTwo2));
        Assert.assertTrue(driver.findElement(answerTwo2).isDisplayed());
    }

    public void clickQuestion2() {
        driver.findElement(question2).click();
    }

    public void getAnswer1() {
        new WebDriverWait(driver, Duration.ofSeconds(15))
                .until(ExpectedConditions.visibilityOfElementLocated(answerOne1));
        Assert.assertTrue(driver.findElement(answerOne1).isDisplayed());
    }

    public void clickQuestion1() {
        driver.findElement(question1).click();
    }

    public void scrollTable() {
        WebElement tableFAQ = driver.findElement(table);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", tableFAQ);
    }

    public void openPage() {
        driver.get(URL);
    }

}