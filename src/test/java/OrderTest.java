import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class OrderTest extends BaseOrderTest {
    private final String name;
    private final String surname;
    private final String address;
    private final String subway;
    private final String phoneNumber;
    private final String date;
    private final String rentalPeriod;
    private final String color;
    private final String comment;
    private final boolean useTopButton;

    public OrderTest(String name, String surname, String address, String subway,
                     String phoneNumber, String date, String rentalPeriod,
                     String color, String comment, boolean useTopButton) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.subway = subway;
        this.phoneNumber = phoneNumber;
        this.date = date;
        this.rentalPeriod = rentalPeriod;
        this.color = color;
        this.comment = comment;
        this.useTopButton = useTopButton;
    }

    @Parameterized.Parameters(name = "Заказ самоката: {0} {1}, метро {3}, кнопка: {9}")
    public static Object[][] getDateSetForOrder() {
        return new Object[][] {
                {"Анна", "Корнеева", "ул. Пейзажная", "Сокольники", "89119113333", "22.07.2025", "сутки", "чёрный жемчуг", "Домофон не работает", true},
                {"Василиса", "Григорьева", "ул. Вербная", "Черкизовская", "89119684567", "15.08.2025", "двое суток", "серая безысходность", "Позвоните за 30 мин до прибытия", false},
        };
    }

    @Test
    public void orderPositiveTest() {
        mainPage.openPage();

        if (useTopButton) {
            mainPage.clickMainOrderButton();
        } else {
            mainPage.scrollToBottomOrderButton();
            mainPage.clickBottomOrderButton();
        }

        orderPage.fillOrderForm(name, surname, address, subway, phoneNumber, date, rentalPeriod, color, comment);

        orderPage.clickOrderConfirmButton();
        orderPage.getOrderCreation();
    }
}