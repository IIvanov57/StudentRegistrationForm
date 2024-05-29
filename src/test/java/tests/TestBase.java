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

import static com.codeborne.selenide.Configuration.remote;
import static com.codeborne.selenide.Configuration.browserSize;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class TestBase {
  @BeforeAll
  static void beforeALL() {
    Configuration.pageLoadStrategy = "eager";
    //Configuration.browserSize = "1024x768";

    browserSize = System.getProperty("1920x1080", "1920x1080");
    //browserSize = "1920x1080";

    Configuration.timeout = 10000;
    //Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub";
    //System.setProperty("remote","https://localhost");
    remote = System.getProperty("remote", "https://localhost");
    DesiredCapabilities capabilities = new DesiredCapabilities();
    capabilities.setCapability("selenoid:options", Map.<String, Object>of(
            "enableVNC", true,
            "enableVideo", true
    ));
    Configuration.browserCapabilities = capabilities;

    executeJavaScript("$('footer').remove();");
    executeJavaScript("$('#fixedban').remove();");

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
