Feature: Поиск электричек

  Scenario: Пользователь осуществляет поиск электричек с помощью соответствующего сервиса Яндекса

    Given an open browser with google.com
    When a keyword selenide is entered in input field
    Then at least top 1 matches should be shown
    Then the first one should contain selenide.org
