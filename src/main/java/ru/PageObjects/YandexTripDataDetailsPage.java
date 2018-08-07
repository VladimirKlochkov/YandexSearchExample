package ru.PageObjects;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;

/**
 * Класс для работы со страницей информации о рейсе ( https://rasp.yandex.ru/thread/ ).
 * Created by Vladimir V. Klochkov on 07.08.2018.
 * Updated by Vladimir V. Klochkov on 07.08.2018.
 */
public class YandexTripDataDetailsPage extends YandexMainPage
{
    /*******************************************************************************************************************
     * Локаторы элементов страницы.
     ******************************************************************************************************************/
    //------------------------------------------------------------------------------------------------------------------
    // Название таблицы [Пункт отправления]
    private SelenideElement tableHeaderFromName = $(By.xpath("//h1[@class='b-page-title__title']/span[4]"));
    //------------------------------------------------------------------------------------------------------------------
    // Название таблицы [Пункт назначения]
    private SelenideElement tableHeaderToName = $(By.xpath("//h1[@class='b-page-title__title']/span[5]"));
    //------------------------------------------------------------------------------------------------------------------
    // Таблица маршрута (общая часть локатора)
    private String timeTable = "//table[@class='b-timetable i-bem b-timetable_js_inited']/tbody/";
    //------------------------------------------------------------------------------------------------------------------
    // Таблица маршрута [Пункт отправления]
    private SelenideElement timeTableFromName = $(By.xpath(timeTable +
            "tr[@class='b-timetable__row b-timetable__row_type_start']//a"));
    //------------------------------------------------------------------------------------------------------------------
    // Таблица маршрута [Время отправления]
    private SelenideElement timeTableFromTime = $(By.xpath(timeTable +
            "tr[@class='b-timetable__row b-timetable__row_type_start']//strong"));
    //------------------------------------------------------------------------------------------------------------------
    // Таблица маршрута [Пункт прибытия]
    private SelenideElement timeTableToName = $(By.xpath(timeTable +
            "tr[@class='b-timetable__row b-timetable__row_position_last b-timetable__row_type_end']//a"));
    //------------------------------------------------------------------------------------------------------------------
    // Таблица маршрута [Время прибытия]
    private SelenideElement timeTableToTime = $(By.xpath(timeTable +
            "tr[@class='b-timetable__row b-timetable__row_position_last b-timetable__row_type_end']//strong"));
    //------------------------------------------------------------------------------------------------------------------
    // Таблица маршрута [Время в пути]
    private SelenideElement timeTablePathTime = $(By.xpath(timeTable +
            "tr[@class='b-timetable__row b-timetable__row_position_last b-timetable__row_type_end']/" +
            "td[@class='b-timetable__cell b-timetable__cell_type_time b-timetable__cell_position_last']/" +
            "div[@class='b-timetable__pathtime']"));
    //------------------------------------------------------------------------------------------------------------------

    /*******************************************************************************************************************
     * Поля страницы.
     ******************************************************************************************************************/
    private String tripLink;           // ссылка с названием рейса
    private String fromName;           // пункт отправления
    private String tripTimeFrom;       // время отправления
    private String duration;           // длительность рейса
    private String toName;             // пункт прибытия
    private String tripTimeTo;         // время прибытия

    /*******************************************************************************************************************
     * Конструктор класса. Отвечает за инициализацию всех полей класса.
     * @param tripLink ссылка с названием рейса
     * @param fromName пункт отправления
     * @param tripTimeFrom время отправления
     * @param duration длительность рейса
     * @param toName пункт прибытия
     * @param tripTimeTo время прибытия
     ******************************************************************************************************************/
    public void YandexTripDataDetailsPage(
            String tripLink, String fromName, String tripTimeFrom, String duration, String toName, String tripTimeTo)
    {
        this.tripLink = tripLink;
        this.fromName = fromName;
        this.tripTimeFrom = tripTimeFrom;
        this.duration = duration;
        this.toName = toName;
        this.tripTimeTo = tripTimeTo;
    }

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
