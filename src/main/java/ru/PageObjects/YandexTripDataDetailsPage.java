package ru.PageObjects;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

/**
 * Класс для работы со страницей  информации о рейсе ( https://rasp.yandex.ru/thread/ ).
 * Created by Vladimir V. Klochkov on 07.08.2018.
 * Updated by Vladimir V. Klochkov on 07.08.2018.
 */
public class YandexTripDataDetailsPage extends YandexMainPage
{
    /*******************************************************************************************************************
     * Локаторы элементов страницы.
     ******************************************************************************************************************/
    //------------------------------------------------------------------------------------------------------------------
    // Название таблицы [Номер рейса]
    private SelenideElement tableHeaderTrainNo = $(By.xpath("//h1[@class='b-page-title__title']/span[2]"));
    //------------------------------------------------------------------------------------------------------------------
    // Название таблицы [Пункт отправления]
    private SelenideElement tableHeaderFromName = $(By.xpath("//h1[@class='b-page-title__title']/span[4]"));
    //------------------------------------------------------------------------------------------------------------------
    // Название таблицы [Пункт назначения]
    private SelenideElement tableHeaderToName = $(By.xpath("//h1[@class='b-page-title__title']/span[5]"));
    //------------------------------------------------------------------------------------------------------------------
    // Полное название рейса в легенде календаря
    private SelenideElement legendTrip = $(By.xpath("//div[@class='b-page-calendar-legend__trip']/a"));
    //------------------------------------------------------------------------------------------------------------------
    // Таблица маршрута
    private ElementsCollection timeTable =
            $$(By.xpath("//table[@class='b-timetable i-bem b-timetable_js_inited']/tbody/tr"));
    //------------------------------------------------------------------------------------------------------------------

    /*******************************************************************************************************************
     * Методы страницы.
     ******************************************************************************************************************/
    /**
     * Проверяет, что данные о рейсе на странице информации полностью соответствуют сохраненным в тесте данным.
     */
    public void checkThatTheTripDataDetailsCorrespondsToSavedData()
    {
    }
}
