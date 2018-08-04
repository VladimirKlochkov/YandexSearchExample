package ru.StepDefinitions;


import cucumber.api.java.en.Given;
import ru.PageObjects.YandexMainPage;

/**
 * Класс описывающий шаги теста по поиску электричек с помощью соответствующего сервиса Яндекса.
 * Created by Vladimir V. Klochkov on 04.08.2018.
 * Updated by Vladimir V. Klochkov on 04.08.2018.
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
  @Given("^Пользователь открывает страницу \"([^\"]*)\"$")
  public void userOpensPageByUrl(String url)
  {
      yandexMainPage.openYandexMainPage(url);
  }
}
