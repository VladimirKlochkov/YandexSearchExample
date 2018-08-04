package org.selenide.examples.cucumber;

import com.codeborne.selenide.Configuration;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.Before;
import org.junit.runner.RunWith;

/**
 * Обеспечивает запуск тестов в Cucumber с указанными опциями (см. аннотацию @CucumberOptions).
 * Created by Vladimir V. Klochkov on 04.08.2018.
 * Updated by Vladimir V. Klochkov on 04.08.2018.
 */

@RunWith(Cucumber.class)
@CucumberOptions(
        strict = false,
        features = "src/test/resources/features",
        format = {"pretty", "html:target/site/cucumber-pretty", "json:target/cucumber.json"},
        plugin = {"json:target/cucumber.json"})

public class RunTest {
  //====================================================================================================================
  //     Этот класс всегда должен быть пустым !
  //====================================================================================================================

  @Before
  public void setUp() {
    Configuration.startMaximized = true;
    Configuration.reportsFolder = "target/surefire-reports";
  }
}
