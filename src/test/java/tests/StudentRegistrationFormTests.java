package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.remote.DesiredCapabilities;
import pages.RegistrationPage;

import java.util.Map;

import static utils.RandomUtils.*;

public class StudentRegistrationFormTests {

  RegistrationPage registrationPage = new RegistrationPage();

  String firstName = getRandomFirstName(),
          lastName = getRandomLastName(),
          email = getRandomEmailAddress(),
          phone = getRandomPhone(),
          gender = getRandomGender(),
          address = getRandomAddress(),
          hobby = getRandomHobbits(),
          month = getRandomMonth(),
          year = getRandomYear(),
          subject = getRandomSubject(),
          state = getRandomState(),
          city = getRandomCity(state);


  @BeforeAll
  static void beforeALL() {
    Configuration.pageLoadStrategy = "eager";
    //Configuration.browserSize = "1024x768"; 
    Configuration.browserSize = "1920x1080";
    Configuration.timeout = 10000;
    Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub";
    DesiredCapabilities capabilities = new DesiredCapabilities();
    capabilities.setCapability("selenoid:options", Map.<String, Object>of(
            "enableVNC", true,
            "enableVideo", true
    ));
    Configuration.browserCapabilities = capabilities;

    SelenideLogger.addListener("AllureSelenide", new AllureSelenide());

  }

  @AfterEach
  void addAttachments() {
    Attach.screenshotAs("Last screenshot");
    Attach.pageSource();
    Attach.browserConsoleLogs();
    Attach.addVideo();

  }

  @Test
  void successfulFillRegistrationFormTest() {
    registrationPage.openPage("automation-practice-form")
            .setFirstName(firstName)
            .setLastName(lastName)
            .setEmail(email)
            .setGender(gender)
            .setPhone(phone)
            .setDateOfBirth(month, year)
            .setSubjects(subject)
            .setHobbits(hobby)
            .setPicture("Picture.jpg")
            .setAddress(address)
            .setStateAndCity(state, city)
            .submit();


    registrationPage.checkResult("Student Name", firstName + " " + lastName)
            .checkResult("Student Email", email)
            .checkResult("Gender", gender)
            .checkResult("Mobile", phone)
            .checkResult("Date of Birth", "08 " + month + "," + year)
            .checkResult("Subjects", subject)
            .checkResult("Hobbies", hobby)
            .checkResult("Picture", "Picture.jpg")
            .checkResult("Address", address)
            .checkResult("State and City", state + " " + city);
  }

  @Test
  void minFillRegistrationFormTest() {
    registrationPage.openPage("automation-practice-form")
            .setFirstName(firstName)
            .setLastName(lastName)
            .setGender(gender)
            .setPhone(phone)
            .submit();

    registrationPage.isAvailableResult();

  }

  @Test
  void negativeRegistrationFormTest() {
    registrationPage.openPage("automation-practice-form")
            .setFirstName(firstName)
            .setLastName(lastName)
            .setGender(gender)
            .submit();

    registrationPage.isNotAvailableResult();

  }
}
