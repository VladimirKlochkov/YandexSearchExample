package org.selenide.examples.cucumber;

import com.codeborne.selenide.Configuration;
import cucumber.api.junit.Cucumber;
import org.junit.Before;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
public class GoogleTest {

  @Before
  public void setUp() {
    Configuration.startMaximized = true;
    Configuration.reportsFolder = "target/surefire-reports";
  }
}
