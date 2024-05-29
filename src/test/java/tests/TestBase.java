package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Map;

import static com.codeborne.selenide.Configuration.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class TestBase {
  @BeforeAll
  static void beforeALL() {
    Configuration.pageLoadStrategy = "eager";
    //Configuration.browserSize = "1024x768";

    browserSize = System.getProperty("browserSize", "1920x1080");
    browser = System.getProperty("browser", "chrome");
    browserVersion="120";
    Configuration.timeout = 10000;
    //Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub";
    //System.setProperty("remote","https://localhost");
    //remote = System.getProperty("remote", "https://localhost");
    remote = "https://user1:1234@" + System.getProperty("remote", "localhost") + "/wd/hub";
    DesiredCapabilities capabilities = new DesiredCapabilities();
    capabilities.setCapability("selenoid:options", Map.<String, Object>of(
            "enableVNC", true,
            "enableVideo", true
    ));
    Configuration.browserCapabilities = capabilities;


  }

  @BeforeEach
  void beforeEach() {
    SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
  }

  @AfterEach
  void addAttachments() {
    Attach.screenshotAs("Last screenshot");
    Attach.pageSource();
    Attach.browserConsoleLogs();
    Attach.addVideo();
    Selenide.closeWebDriver();

  }
}
