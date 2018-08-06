package ru.StepDefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import ru.PageObjects.YandexMainPage;
import ru.PageObjects.YandexTimetablesPage;
import ru.PageObjects.YandexTimetablesSearchResultsPage;
import static com.codeborne.selenide.WebDriverRunner.url;

/**
 * Класс описывающий шаги теста по поиску электричек с помощью соответствующего сервиса Яндекса.
 * Created by Vladimir V. Klochkov on 04.08.2018.
 * Updated by Vladimir V. Klochkov on 06.08.2018.
 */
public class YandexTextSearchStepDefinitions
{
  /*********************************************************************************************************************
   * Поля класса.
   ********************************************************************************************************************/
  private static final String yandexMainPageUrl = "https://yandex.ru";
  private static final String yandexTimetablesPageUrl = "https://rasp.yandex.ru";
  private static final String yandexTimetablesSearchResultsPageUrl = "https://rasp.yandex.ru/search/suburban/";
  private String fromParameter;
  private String toParameter;
  private String whenParameter;
  private YandexMainPage yandexMainPage = new YandexMainPage();
  private YandexTimetablesPage yandexTimetablesPage = new YandexTimetablesPage();
  private YandexTimetablesSearchResultsPage yandexTimetablesSearchResultsPage = new YandexTimetablesSearchResultsPage();

  /*********************************************************************************************************************
   * Методы класса.
   *
   * Все методы оформлены в едином стиле:
   *
   * Действие
   * //------
   * Проверка
   *
   ********************************************************************************************************************/
  @Given("^Пользователь открывает страницу 'yandex.ru'$")
  public void userOpensYandexMainPage()
  {
      yandexMainPage.openYandexMainPage(yandexMainPageUrl);
      //----------------------------------------------------------------------------------------------------------------
      Assert.assertTrue("Главная страница Яндекса не открылась", url().contains(yandexMainPageUrl));
  }

  @When("^Пользователь переходит на страницу сервиса 'Яндекс Расписания'$")
    public void userGoesToYandexTimetablesPage()
  {
      yandexMainPage.goToYandexTimetablesPage();
      //----------------------------------------------------------------------------------------------------------------
      Assert.assertTrue("Страница 'Яндекс Расписания' не открылась", url().contains(yandexTimetablesPageUrl));
  }

  @Then("^Пользователь осуществляет поиск электричек из пункта \"([^\"]*)\" в пункт \"([^\"]*)\" на \"([^\"]*)\"$")
  public void userSearchesElectricTrains(String from, String to, String when)
  {
      fromParameter = from; toParameter = to; whenParameter = when;
      yandexTimetablesPage.switchToElectricTrain().searchForTimeTable(from, to, when);
      //----------------------------------------------------------------------------------------------------------------
        Assert.assertTrue("Страница результатов поиска для сервиса 'Яндекс Расписания' не открылась",
                url().contains(yandexTimetablesSearchResultsPageUrl));
  }

  @Then("^Пользователь проверяет, что поиск произведен и название таблицы результатов соответствует параметрам поиска$")
  public void userChecksSearchResultsForKeyWords()
  {
      yandexTimetablesSearchResultsPage.checkSearchResultsForKeyWords(fromParameter, toParameter, whenParameter);
      //----------------------------------------------------------------------------------------------------------------
      // Здесь проверкой является само действие
  }

  @Then("^Пользователь сохраняет данные о рейсе, который отправляется после полудня и билет на который стоит до 200 руб.$")
  public void userStoresAllDataAboutTrip()
  {
      int total = yandexTimetablesSearchResultsPage.storeAllDataAboutTrip();
      //----------------------------------------------------------------------------------------------------------------
      Assert.assertTrue("Рейсы по указанным параметрам поиска отсутствуют", total > 0);
  }

  @Then("^Пользователь выводит на консоль данные о рейсе$")
    public void userPrintsTripDataToConsole()
  {
      //----------------------------------------------------------------------------------------------------------------
  }
}
