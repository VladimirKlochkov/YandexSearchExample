package ru.PageObjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.junit.Assert;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.url;

/**
 * Класс для работы с главной страницей Яндекса (https://yandex.ru/).
 * Created by Vladimir V. Klochkov on 04.08.2018.
 * Updated by Vladimir V. Klochkov on 04.08.2018.
 */
public class YandexMainPage
{
    /*******************************************************************************************************************
     * Локаторы элементов страницы.
     ******************************************************************************************************************/
    //------------------------------------------------------------------------------------------------------------------
    // Строка для текстового поиска на главной странице Яндекса
    private static final SelenideElement yandexMainSearchString = $(By.id("text"));
    //------------------------------------------------------------------------------------------------------------------

    /*******************************************************************************************************************
     * Поля страницы.
     ******************************************************************************************************************/
    private Condition clickable = and("can be clicked", visible, enabled); // по элементу можно сделать клик
    private long timeout = 30000; // общее время ожидания (миллисекунды)
    private long polling = 1000; // интервал проверки выполнения условия (миллисекунды)

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
        Assert.assertTrue("Главная страница Яндекса не открылась", url().contains(url));

        return this;
    }
}
