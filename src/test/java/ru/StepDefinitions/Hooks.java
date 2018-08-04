package ru.StepDefinitions;

import com.codeborne.selenide.WebDriverRunner;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.junit.Assert;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.internal.ElementScrollBehavior;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Configuration.timeout;

/**
 * Код, который будет выполняться до и после каждого сценария.
 * Created by Vladimir V. Klochkov on 04.08.2018.
 * Updated by Vladimir V. Klochkov on 04.08.2018.
 */
public class Hooks
{
    private static WebDriver driver; // Экземпляр WebDriver (главный, остальные - ссылки на него)

    @Before
    /**
     * Код, который будет выполняться до каждого сценария.
     * Настраиваем профиль и поведение нового экземпляра WebDriver.
     * Чистим все, что можем очистить чтобы избежать общего состояния между выполнением тестов.
     */
    public void openBrowser() throws UnknownHostException
    {
        // Настройка профиля браузера
        FirefoxProfile profile = new ProfilesIni().getProfile("WebDriver");

        // Настройка поведения WebDriver
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(CapabilityType.ELEMENT_SCROLL_BEHAVIOR, ElementScrollBehavior.BOTTOM);
        capabilities.setCapability(CapabilityType.ForSeleniumServer.ENSURING_CLEAN_SESSION, true);

        profile.setPreference("browser.download.folderList", 2);
        profile.setPreference("browser.helperApps.neverAsk.saveToDisk", "application/msword, application/rtf, " +
                "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet, " +
                "application/x-msexcel, application/excel, application/x-excel, application/vnd.ms-excel, " +
                "application/vnd.openxmlformats-officedocument.wordprocessingml.document, " +
                "application/csv, application/ris, text/csv, image/png, application/pdf, text/html, " +
                "text/plain, application/zip, application/x-zip, application/x-zip-compressed, " +
                "application/download, application/octet-stream doc docx xls xlsx pdf rtf txt zip");
        profile.setPreference("browser.download.manager.alertOnEXEOpen", false);
        profile.setPreference("browser.download.manager.showWhenStarting", false);
        profile.setPreference("browser.download.manager.focusWhenStarting", false);
        profile.setPreference("browser.download.useDownloadDir", true);
        profile.setPreference("browser.helperApps.alwaysAsk.force", false);
        profile.setPreference("browser.download.manager.closeWhenDone", true);
        profile.setPreference("browser.download.manager.showAlertOnComplete", false);
        profile.setPreference("browser.download.manager.useWindow", false);
        profile.setPreference("services.sync.prefs.sync.browser.download.manager.showWhenStarting", false);
        profile.setPreference("pdfjs.disabled", true);

        capabilities.setBrowserName(BrowserType.FIREFOX);

        // Создание и настройка нового экземпляра WebDriver с указанными выше профилем и поведением
        driver = new FirefoxDriver(null, profile, capabilities);
        //--------------------------------------------------------------------------------------------------------------
        // Инициализируем время ожидания по умолчанию в миллисекундах для Selenium
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        //--------------------------------------------------------------------------------------------------------------
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
        String browserName = cap.getBrowserName().toLowerCase();
        String browserVersion = cap.getVersion().toLowerCase();
        System.out.println(">>> (openBrowser) browser is: " + browserName
                + " version " + browserVersion + "");
        if (browserName.equals("firefox"))
            Assert.assertEquals("[ОШИБКА]: некорректная версия браузера, возможно он был обновлен",
                    "45", browserVersion.substring(0, 2));

        //--------------------------------------------------------------------------------------------------------------
        // Инициализируем Selenide нашим экземпляром WebDriver
        WebDriverRunner.setWebDriver(driver);
        System.out.println(">>> (openBrowser) The static instance of Selenium WebDriver was initialized.");
        // Инициализируем время ожидания по умолчанию в миллисекундах для Selenide
        timeout = 30000;
        //--------------------------------------------------------------------------------------------------------------
        // Выводим дополнительную информацию о компьютере, на котором выполняются тесты
        System.out.println(">>> (openBrowser) Computer name is : "
                + InetAddress.getLocalHost().getHostName());
        System.out.println(">>> (openBrowser) IP address is    : "
                + InetAddress.getLocalHost().getHostAddress());
        System.out.println(">>> (openBrowser) OS name is       : " + System.getProperty("os.name"));
        System.out.println(">>> (openBrowser) OS version is    : " + System.getProperty("os.version"));
        System.out.println(">>> (openBrowser) User logged in as: " + System.getProperty("user.name"));
    }

    @After
    /**
     * Код, который будет выполняться после каждого сценария.
     * Встраиваем скриншот в тестовый отчет, если тест завершен аварийно.
     */
    public void closeBrowser()
    {
        // Закрываем браузер в любом случае (нормальное или аварийное завершение теста)
        driver.quit();
    }
}
