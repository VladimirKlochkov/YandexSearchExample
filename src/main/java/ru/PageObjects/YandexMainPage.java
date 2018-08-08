package ru.PageObjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;

/**
 * Класс для работы с главной страницей Яндекса ( https://yandex.ru/ ).
 * Created by Vladimir V. Klochkov on 04.08.2018.
 * Updated by Vladimir V. Klochkov on 08.08.2018.
 */
public class YandexMainPage
{
    /*******************************************************************************************************************
     * Локаторы элементов страницы.
     ******************************************************************************************************************/
    //------------------------------------------------------------------------------------------------------------------
    // Курсы валют на главной странице Яндекса
    private ElementsCollection courses = $$(By.xpath("//span[@class='inline-stocks__value_inner']"));
    //------------------------------------------------------------------------------------------------------------------
    // Строка для текстового поиска на главной странице Яндекса
    private SelenideElement yandexMainSearchString = $(By.id("text"));
    //------------------------------------------------------------------------------------------------------------------
    // Ссылка [ещё]
    private SelenideElement moreLink = $(By.xpath("//a[@href='https://yandex.ru/all' and contains(., 'ещё')]"));
    //------------------------------------------------------------------------------------------------------------------
    // Ссылка [Расписания] во всплывающем окне после нажатия на ссылку [ещё]
    private SelenideElement timetablesLink = $(By.xpath("//div[@class='popup__content']//a[contains(., 'Расписания')]"));
    //------------------------------------------------------------------------------------------------------------------

    /*******************************************************************************************************************
     * Поля страницы.
     ******************************************************************************************************************/
    Condition clickable = and("can be clicked", visible, enabled); // по элементу можно сделать клик
    long timeout = 30000; // общее время ожидания (миллисекунды)
    long polling = 1000; // интервал проверки выполнения условия (миллисекунды)

    /*******************************************************************************************************************
     * Методы страницы.
     ******************************************************************************************************************/
    /**
     * Открывает главную страницу Яндекса.
     * @param url адрес страницы
     * @return главную страницу Яндекса
     */
    public YandexMainPage openYandexMainPage(String url)
    {
        open(url);
        yandexMainSearchString.waitUntil(clickable, timeout, polling);

        return this;
    }

    /**
     * Возвращает курс рубля к доллару в виде строки.
     * @return курс рубля к доллару в виде строки
     */
    public String getUsdCourse()
    {
        return courses.get(0).waitUntil(visible, timeout, polling).getText();
    }

    /**
     *  Осуществляет переход на страницу сервиса 'Яндекс Расписания'.
     */
    public void goToYandexTimetablesPage()
    {
        moreLink.waitUntil(clickable, timeout, polling).click();
        timetablesLink.waitUntil(clickable, timeout, polling).hover();
        timetablesLink.click();
    }
}
