import org.junit.Test;

public class FAQTest extends BaseTest1 {

    @Test
    public void FAQCorrectAnswer() throws InterruptedException {

        // Открыть домашнюю страницу Яндекс самокат
        faqPage.openPage();


        // Проскролить страницу до появления таблицы
        faqPage.scrollTable();

        // Нажать на 1 вопрос

        faqPage.clickQuestion1();

        // Получить ответ на 1 вопрос
        faqPage.getAnswer1();


        // Нажать на 2 вопрос
        faqPage.clickQuestion2();

        // Получить ответ на 2 вопрос
        faqPage.getAnswer2();


        // Нажать на 3 вопрос
        faqPage.clickQuestion3();

        // Получить ответ на 3 вопрос
        faqPage.getAnswer3();


        // Нажать на 4 вопрос
        faqPage.clickQuestion4();

        // Получить ответ на 4 вопрос
        faqPage.getAnswer4();


        // Нажать на 5 вопрос
        faqPage.clickQuestion5();

        // Получить ответ на 5 вопрос
        faqPage.getAnswer5();


        // Нажать на 6 вопрос
        faqPage.clickQuestion6();

        // Получить ответ на 6 вопрос
        faqPage.getAnswer6();


        // Нажать на 7 вопрос
        faqPage.clickQuestion7();

        // Получить ответ на 7 вопрос
        faqPage.getAnswer7();


        // Найти куку и кликнуть по ее кнопке для закрытия
        faqPage.clickCloseButtonCookie();


        // Нажать на 8 вопрос
        faqPage.clickQuestion8();

        // Получить ответ на 8 вопрос
        faqPage.getAnswer8();
    }

}