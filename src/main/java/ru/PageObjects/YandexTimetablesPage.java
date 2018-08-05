package ru.PageObjects;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;

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
    // Строка для текстового поиска [Когда]
    private SelenideElement date = $(By.xpath("//input[@class='date-input_search__input']"));
    //------------------------------------------------------------------------------------------------------------------
    // Кнопка [Найти]
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
        fromName.waitUntil(clickable, timeout, polling).sendKeys(from);
        toName.waitUntil(clickable, timeout, polling).sendKeys(to);
        date.waitUntil(clickable, timeout, polling).sendKeys(when);
        searchButton.waitUntil(clickable, timeout, polling).click();
    }
}
