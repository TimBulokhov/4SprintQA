import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;

@RunWith(Parameterized.class)
public class OrderTest extends BaseOrderTest {
    private WebDriver driver;
    private final String name;
    private final String surname;
    private final String address;
    private final String subway;
    private final String phoneNumber;
    private final String date;
    private final String rentalPeriod;
    private final String color;
    private final String comment;

    public OrderTest(String name, String surname, String address, String subway, String phoneNumber, String date, String rentalPeriod, String color, String comment) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.subway = subway;
        this.phoneNumber = phoneNumber;
        this.date = date;
        this.rentalPeriod = rentalPeriod;
        this.color = color;
        this.comment = comment;
    }

    @Parameterized.Parameters
    public static Object[][] getDateSetForOrder() {
        return new Object[][] {
                {"Анна", "Корнеева", "ул. Пейзажная", "Сокольники", "89119113333", "22.07.2025", "сутки", "чёрный жемчуг", "Домофон не работает"},
                {"Василиса", "Григорьева", "ул. Вербная", "Черкизовская", "89119684567", "15.08.2025", "двое суток", "серая безысходность", "Позвоните за 30 мин до прибытия"},
        };
    }

    @Test
    public void orderPositiveTest() throws InterruptedException {

        // Открыть домашнюю страницу Яндекс самокат
        orderMainPage.openPage();

        // Нажать на главную кнопку "Заказать"
        orderMainPage.clickMainOrderButton();


        // Страница "Для кого самокат"
        // Вводим name в плейсхолдер
        orderPage.setName(name);

        // Вводим surname в плейсхолдер
        orderPage.setSurname(surname);

        // Вводим address в плейсхолдер
        orderPage.setAddress(address);

        // Заполнение subway
        // Кликаем на плейсхолдер subway
        orderPage.clickPlaceholderSubway();

        // Выбираем subway
        orderPage.clickSelectedSubway(subway);

        // Вводим phoneNumber в плейсхлдер
        orderPage.setPhoneNumber(phoneNumber);

        // Закрываем куки
        orderPage.clickCloseButtonCookie();

        // Нажимаем на кнопку "Далее"
        orderPage.clickNextButton();


        //Страница "Про аренду"
        // Вводим дату
        orderPage.setDate(date);

        // Выбор срока аренды
        // Кликаем на надпись "Про аренду"
        orderPage.clickAboutOrderTitle();

        // Кликаем на плейсхолдер строка аренды
        orderPage.clickPlaceholderRentalPeriod();

        // Выбираем срок аренды в выпадающем списке и кликаем по нему
        orderPage.clickSelectedRentalPeriod(rentalPeriod);

        // Выбираем цвет самоката
        orderPage.setColor(color);

        // Вводим комменетарий для курьера
        orderPage.setComment(comment);

        // Нажимаем на кнопку "Заказать" после заполнения данных
        orderPage.clickOrderCreateButton();


        // Страница с подтверждением заказа
        // Кликаем по кнопке "Да"
        orderPage.clickOrderConfirmButton();


        // Ожидаем появления всплывающего окна с сообщением об успешном создании заказа
        orderPage.getOrderCreation();

    }

}