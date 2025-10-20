import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import page.MainPage;

@RunWith(Parameterized.class)
public class FAQTest extends BaseTest {

    private final int questionNumber;

    public FAQTest(int questionNumber, String questionDescription) {
        this.questionNumber = questionNumber;
    }

    @Parameterized.Parameters(name = "Тест вопроса FAQ: {1}")
    public static Object[][] getQuestionData() {
        return new Object[][] {
                {1, "Стоимость аренды"},
                {2, "Несколько самокатов"},
                {3, "Время аренды"},
                {4, "Заказ на сегодня"},
                {5, "Продление и возврат"},
                {6, "Зарядка самоката"},
                {7, "Отмена заказа"},
                {8, "Зона оплаты"}
        };
    }

    @Test
    public void FAQCorrectAnswer() {
        // Открыть домашнюю страницу Яндекс самокат
        mainPage.openPage();

        // Проскролить страницу до появления таблицы FAQ
        mainPage.scrollToFAQTable();

        // Закрыть куки, если мешают
        mainPage.closeCookieButton();

        // Нажать на вопрос и проверить ответ
        mainPage.clickQuestion(questionNumber);
        mainPage.verifyAnswerDisplayed(questionNumber);
    }
}