package page;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OrderPage {
    private WebDriver driver;

    // Локаторы для первой страницы заказа
    private By nameField = By.cssSelector("input[placeholder='* Имя']");
    private By surnameField = By.cssSelector("input[placeholder='* Фамилия']");
    private By addressField = By.cssSelector("input[placeholder='* Адрес: куда привезти заказ']");
    private By placeholderSubway = By.cssSelector("input[placeholder='* Станция метро']");
    private By phoneNumberField = By.cssSelector("input[placeholder='* Телефон: на него позвонит курьер']");
    private By closeButtonCookie = By.cssSelector("button.App_CookieButton__3cvqF");
    private By nextButton = By.xpath(".//button[text()='Далее']");

    // Локаторы для второй страницы заказа
    private By dateField = By.cssSelector("input[placeholder='* Когда привезти самокат']");
    private By aboutOrderTitle = By.xpath(".//div[text()='Про аренду']");
    private By placeholderRentalPeriod = By.xpath(".//div[contains(text(), 'Срок аренды')]");
    private By commentField = By.cssSelector("input[placeholder='Комментарий для курьера']");
    private By createButton = By.xpath("//div[contains(@class,'Order_Buttons')]/button[text()='Заказать']");

    // Локаторы для выпадающих списков
    private By subwayOption = By.xpath(".//div[@class='select-search__select']//*[text()='%s']");
    private By rentalPeriodOption = By.xpath(".//div[text()='%s']");

    // Локаторы для цветов самоката
    private By colorCheckbox = By.xpath(".//label[text()='%s']/input");

    // Локаторы для подтверждения заказа
    private By confirmButton = By.xpath(".//button[text()='Да']");
    private By successModal = By.cssSelector("div.Order_Modal__YZ-d3");
    private By successTitle = By.xpath("//div[contains(@class, 'Order_ModalHeader')]");
    private By statusButton = By.xpath("//button[contains(text(), 'Посмотреть статус')]");

    public OrderPage(WebDriver driver) {
        this.driver = driver;
    }

    // Методы для первой страницы заказа
    public void setName(String name) {
        driver.findElement(nameField).sendKeys(name);
    }

    public void setSurname(String surname) {
        driver.findElement(surnameField).sendKeys(surname);
    }

    public void setAddress(String address) {
        driver.findElement(addressField).sendKeys(address);
    }

    public void clickPlaceholderSubway() {
        driver.findElement(placeholderSubway).click();
    }

    public void clickSelectedSubway(String subway) {
        By subwayField = By.xpath(String.format(".//div[text()='%s']", subway));
        driver.findElement(subwayField).click();
    }

    public void setPhoneNumber(String phoneNumber) {
        driver.findElement(phoneNumberField).sendKeys(phoneNumber);
    }

    public void clickCloseButtonCookie() {
        driver.findElement(closeButtonCookie).click();
    }

    public void clickNextButton() {
        driver.findElement(nextButton).click();
    }

    // Методы для второй страницы заказа
    public void setDate(String date) {
        driver.findElement(dateField).sendKeys(date);
    }

    public void clickAboutOrderTitle() {
        driver.findElement(aboutOrderTitle).click();
    }

    public void clickPlaceholderRentalPeriod() {
        driver.findElement(placeholderRentalPeriod).click();
    }

    public void clickSelectedRentalPeriod(String rentalPeriod) {
        By rentalPeriodField = By.xpath(String.format(".//div[text()='%s']", rentalPeriod));
        driver.findElement(rentalPeriodField).click();
    }

    public void setColor(String color) {
        By colorField = By.xpath(String.format(".//label[text()='%s']", color));
        driver.findElement(colorField).click();
    }

    public void setComment(String comment) {
        driver.findElement(commentField).sendKeys(comment);
    }

    public void clickOrderCreateButton() {
        driver.findElement(createButton).click();
    }

    // Методы для подтверждения заказа
    public void clickOrderConfirmButton() {
        driver.findElement(confirmButton).click();
    }

    public void getOrderCreation() {
        // Ждем появления модального окна с успешным оформлением заказа
        new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(ExpectedConditions.visibilityOfElementLocated(successModal));

        // Проверяем что отображается текст "Заказ оформлен"
        WebElement successElement = driver.findElement(successTitle);
        String successText = successElement.getText();
        Assert.assertTrue("Должен отображаться текст 'Заказ оформлен', а получили: " + successText,
                successText.contains("Заказ оформлен"));

        // Дополнительная проверка - кнопка "Посмотреть статус"
        WebElement statusElement = driver.findElement(statusButton);
        Assert.assertTrue("Должна отображаться кнопка 'Посмотреть статус'", statusElement.isDisplayed());
    }

    // Объединенный метод
    public void fillOrderForm(String name, String surname, String address, String subway,
                              String phoneNumber, String date, String rentalPeriod,
                              String color, String comment) {
        // Первая страница
        setName(name);
        setSurname(surname);
        setAddress(address);
        clickPlaceholderSubway();
        clickSelectedSubway(subway);
        setPhoneNumber(phoneNumber);
        clickCloseButtonCookie();
        clickNextButton();

        // Вторая страница
        setDate(date);
        clickAboutOrderTitle();
        clickPlaceholderRentalPeriod();
        clickSelectedRentalPeriod(rentalPeriod);
        setColor(color);
        setComment(comment);
        clickOrderCreateButton();
    }
}