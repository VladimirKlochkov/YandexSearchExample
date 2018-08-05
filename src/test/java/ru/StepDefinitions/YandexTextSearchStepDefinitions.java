package ru.StepDefinitions;


import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import ru.PageObjects.YandexMainPage;
import ru.PageObjects.YandexTimetablesPage;
import static com.codeborne.selenide.WebDriverRunner.url;

/**
 * Класс описывающий шаги теста по поиску электричек с помощью соответствующего сервиса Яндекса.
 * Created by Vladimir V. Klochkov on 04.08.2018.
 * Updated by Vladimir V. Klochkov on 05.08.2018.
 */
public class YandexTextSearchStepDefinitions
{
  /*********************************************************************************************************************
   * Поля класса.
   ********************************************************************************************************************/
  private static final String yandexMainPageUrl = "https://yandex.ru";
  private static final String yandexTimetablesPageUrl = "https://rasp.yandex.ru";
  private static final String yandexTimetablesSearchResultsPageUrl = "https://rasp.yandex.ru/search/suburban/";
  private YandexMainPage yandexMainPage = new YandexMainPage();
  private YandexTimetablesPage yandexTimetablesPage = new YandexTimetablesPage();

  /*********************************************************************************************************************
   * Методы класса.
   ********************************************************************************************************************/
  @Given("^Пользователь открывает страницу 'yandex.ru'$")
  public void userOpensYandexMainPage()
  {
      yandexMainPage.openYandexMainPage(yandexMainPageUrl);
    //------------------------------------------------------------------------------------------------------------------
      Assert.assertTrue("Главная страница Яндекса не открылась", url().contains(yandexMainPageUrl));
  }

  @When("^Пользователь переходит на страницу сервиса 'Яндекс Расписания'$")
    public void userGoesToYandexTimetablesPage()
  {
    yandexMainPage.goToYandexTimetablesPage();
    //------------------------------------------------------------------------------------------------------------------
    Assert.assertTrue("Страница 'Яндекс Расписания' не открылась", url().contains(yandexTimetablesPageUrl));
  }

  @Then("^Пользователь осуществляет поиск электричек из пункта \"([^\"]*)\" в пункт \"([^\"]*)\" на \"([^\"]*)\"$")
  public void userSearchesElectricTrains(String from, String to, String when)
  {
    yandexTimetablesPage.switchToElectricTrain().searchForTimeTable(from, to, when);
    //------------------------------------------------------------------------------------------------------------------
      Assert.assertTrue("Страница результатов поиска для сервиса 'Яндекс Расписания' не открылась",
              url().contains(yandexTimetablesSearchResultsPageUrl));
  }
}
