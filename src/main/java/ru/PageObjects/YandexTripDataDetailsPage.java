package ru.PageObjects;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;

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
     * Проверяет, что данные о рейсе на странице информации полностью соответствуют сохраненным в тесте данным.
     */
    public void checkThatTheTripDataDetailsCorrespondsToSavedData()
    {
    }
}
