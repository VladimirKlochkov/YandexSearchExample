package ru.StepDefinitions;


import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import org.junit.Assert;
import ru.PageObjects.YandexMainPage;

import static com.codeborne.selenide.WebDriverRunner.url;

/**
 * Класс описывающий шаги теста по поиску электричек с помощью соответствующего сервиса Яндекса.
 * Created by Vladimir V. Klochkov on 04.08.2018.
 * Updated by Vladimir V. Klochkov on 05.08.2018.
 */
public class YandexTextSearchStepDefinitions
{
  /*******************************************************************************************************************
   * Поля класса.
   ******************************************************************************************************************/
  private YandexMainPage yandexMainPage = new YandexMainPage();

  /*******************************************************************************************************************
   * Методы класса.
   ******************************************************************************************************************/
  @Given("^Пользователь открывает страницу 'yandex.ru'$")
  public void userOpensYandexMainPage()
  {
      String url = "https://yandex.ru";

      yandexMainPage.openYandexMainPage(url);
      Assert.assertTrue("Главная страница Яндекса не открылась", url().contains(url));
  }

  @When("^Пользователь переходит на страницу сервиса 'Яндекс Расписания'$")
    public void userGoesToYandexTimetablesPage()
  {

  }
}
