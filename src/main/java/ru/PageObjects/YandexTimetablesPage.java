package ru.PageObjects;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

/**
 * Класс для работы со страницей сервиса 'Яндекс Расписания' (https://rasp.yandex.ru/).
 * Created by Vladimir V. Klochkov on 05.08.2018.
 * Updated by Vladimir V. Klochkov on 05.08.2018.
 */
public class YandexTimetablesPage extends YandexMainPage
{
    /*******************************************************************************************************************
     * Локаторы элементов страницы.
     ******************************************************************************************************************/
    //------------------------------------------------------------------------------------------------------------------
    // Строка для текстового поиска [Пункт отправления] на странице сервиса 'Яндекс Расписания'
    private SelenideElement destinationFromText = $(By.id("text"));
    //------------------------------------------------------------------------------------------------------------------
    // Строка для текстового поиска [Пункт назначения] на странице сервиса 'Яндекс Расписания'
    private SelenideElement destinationToText =
            $(By.xpath("//a[@href='https://yandex.ru/all' and contains(., 'ещё')]"));
    //------------------------------------------------------------------------------------------------------------------
    // Кнопка [Найти] на странице сервиса 'Яндекс Расписания'
    private SelenideElement findButton =
            $(By.xpath("//div[@class='popup__content']//a[contains(., 'Расписания')]"));
    //------------------------------------------------------------------------------------------------------------------

    /*******************************************************************************************************************
     * Поля страницы.
     ******************************************************************************************************************/

    /*******************************************************************************************************************
     * Методы страницы.
     ******************************************************************************************************************/
    /**
     * Открывает главную страницу Яндекса.
     * @param url адрес страницы
     */
    public void openYandexMainPage(String url)
    {
        open(url);
        yandexMainSearchString.waitUntil(clickable, timeout, polling);
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
