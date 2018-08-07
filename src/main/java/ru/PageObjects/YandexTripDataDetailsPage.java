package ru.PageObjects;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.Hashtable;
import static com.codeborne.selenide.Selenide.$;

/**
 * Класс для работы со страницей сервиса 'Яндекс Расписания' ( https://rasp.yandex.ru/ ).
 * Created by Vladimir V. Klochkov on 07.08.2018.
 * Updated by Vladimir V. Klochkov on 07.08.2018.
 */
public class YandexTripDataDetailsPage extends YandexMainPage
{
    /*******************************************************************************************************************
     * Локаторы элементов страницы.
     ******************************************************************************************************************/
    //------------------------------------------------------------------------------------------------------------------
    // Позиция переключателя [Электричка]
    private SelenideElement electricTrain =
            $(By.xpath("//div[@class='header__transport-selector']//label[contains(., 'Электричка')]"));
    //------------------------------------------------------------------------------------------------------------------
    // Строка для текстового поиска [Пункт отправления]
    private SelenideElement fromName =
            $(By.xpath("//input[@class='station-input_search__control' and @name='fromName']"));
    //------------------------------------------------------------------------------------------------------------------
    // Строка для текстового поиска [Пункт назначения]
    private SelenideElement toName = $(By.xpath("//input[@class='station-input_search__control' and @name='toName']"));
    //------------------------------------------------------------------------------------------------------------------
    // Пиктограмма открытия календаря для поля [Когда]
    private SelenideElement datePickerSearchIcon = $(By.xpath("//label[@class='datepicker_search__icon']"));
    //------------------------------------------------------------------------------------------------------------------
    // Шаблон для поиска дня недели в открытом календаре по дате
    private String calendarDay =
            "//div[(@class='calendar__day' or @class='calendar__day _weekend') and @data-date='%s']";
    //------------------------------------------------------------------------------------------------------------------
    // Кнопка [Найти]
    private SelenideElement searchButton =
            $(By.xpath("//button[@type='submit']/span[@class='y-button_islet-rasp-search__text']"));
    //------------------------------------------------------------------------------------------------------------------

    /*******************************************************************************************************************
     * Методы страницы.
     ******************************************************************************************************************/
    /**
     * Переключает режим поиска в положение 'Электричка'.
     * @return страница сервиса 'Яндекс Расписания'
     */
    public YandexTripDataDetailsPage switchToElectricTrain()
    {
        electricTrain.waitUntil(clickable, timeout, polling).click();

        return this;
    }

    /**
     * Осуществляет поиск электричек в заданном направлении.
     * @param from пункт отправления
     * @param to пункт назначения
     * @param when день недели или дата в виде строки
     */
    public void searchForTimeTable(String from, String to, String when)
    {
        Hashtable<String, DayOfWeek> days = new Hashtable<>();
        days.put("понедельник", DayOfWeek.MONDAY);
        days.put("вторник", DayOfWeek.TUESDAY);
        days.put("среда", DayOfWeek.WEDNESDAY);
        days.put("четверг", DayOfWeek.THURSDAY);
        days.put("пятница", DayOfWeek.FRIDAY);
        days.put("суббота", DayOfWeek.SATURDAY);
        days.put("воскресенье", DayOfWeek.SUNDAY);

        // Получаем дату в формате ГГГГ-ММ-ДД для того, чтобы найти требуемый элемент в календаре
        LocalDate nextDayOfWeek = LocalDate.now().with(TemporalAdjusters.next(days.get(when)));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String nextDayOfWeekString = nextDayOfWeek.format(formatter);

        fromName.waitUntil(clickable, timeout, polling).click();
        fromName.clear();
        fromName.sendKeys(from);
        toName.waitUntil(clickable, timeout, polling).click();
        toName.clear();
        toName.sendKeys(to);
        datePickerSearchIcon.waitUntil(clickable, timeout, polling).click();
        SelenideElement day = $(By.xpath(String.format(calendarDay, nextDayOfWeekString)));
        day.waitUntil(clickable, timeout, polling).click();
        searchButton.waitUntil(clickable, timeout, polling).click();
    }
}
