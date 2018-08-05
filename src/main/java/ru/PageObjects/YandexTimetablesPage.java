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
    private SelenideElement fromName =
            $(By.xpath("//input[@class='station-input_search__control' and @name='fromName']"));
    //------------------------------------------------------------------------------------------------------------------
    // Строка для текстового поиска [Пункт назначения] на странице сервиса 'Яндекс Расписания'
    private SelenideElement toName = $(By.xpath("//input[@class='station-input_search__control' and @name='toName']"));
    //------------------------------------------------------------------------------------------------------------------
    // Кнопка [Найти] на странице сервиса 'Яндекс Расписания'
    private SelenideElement searchButton =
            $(By.xpath("//button[@type='submit']/span[@class='y-button_islet-rasp-search__text']"));
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
