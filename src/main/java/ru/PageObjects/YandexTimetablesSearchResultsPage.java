package ru.PageObjects;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

/**
 * Класс для работы со страницей результатов поиска в сервисе 'Яндекс Расписания'
 * ( https://rasp.yandex.ru/search/suburban/ ).
 * Created by Vladimir V. Klochkov on 06.08.2018.
 * Updated by Vladimir V. Klochkov on 06.08.2018.
 */
public class YandexTimetablesSearchResultsPage extends YandexMainPage
{
    /*******************************************************************************************************************
     * Локаторы элементов страницы.
     ******************************************************************************************************************/
    //------------------------------------------------------------------------------------------------------------------
    // Заголовок страницы в котором содержатся параметры поиска [Пункт отправления] и [Пункт назначения]
    private SelenideElement fromToNames = $(By.xpath("//h1/span"));
    //------------------------------------------------------------------------------------------------------------------
    // Заголовок страницы в котором содержится параметр поиска [Когда]
    private SelenideElement dayOfWeek = $(By.xpath("//span[@class='SearchTitle__subtitle']"));
    //------------------------------------------------------------------------------------------------------------------

    /*******************************************************************************************************************
     * Методы страницы.
     ******************************************************************************************************************/
    /**
     * Осуществляет проверку, что поиск произведен и название таблицы результатов соответствует параметрам поиска.
     * @param from пункт отправления
     * @param to пункт назначения
     * @param when день недели или дата в виде строки
     */
    public void checkSearchResultsForKeyWords(String from, String to, String when)
    {
        fromToNames.waitUntil(visible, timeout, polling).shouldHave(text("из " + from));
        fromToNames.shouldHave(text("в " + to));
        dayOfWeek.waitUntil(visible, timeout, polling).shouldHave(text(when));
    }
}
