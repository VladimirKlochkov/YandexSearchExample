package ru.PageObjects;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

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
    // Дни в календаре, являющиеся выходными днями в конце недели
    private ElementsCollection weekends = $$(By.xpath("//div[@class='calendar__day _weekend']"));
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
    public YandexTimetablesPage switchToElectricTrain()
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
        fromName.waitUntil(clickable, timeout, polling).click();
        fromName.clear();
        fromName.sendKeys(from);
        toName.waitUntil(clickable, timeout, polling).click();
        toName.clear();
        toName.sendKeys(to);
        datePickerSearchIcon.waitUntil(clickable, timeout, polling).click();
        ElementsCollection visibleWeekends = weekends.filterBy(visible);
        visibleWeekends.get(0).click();
        searchButton.waitUntil(clickable, timeout, polling).click();
    }
}
