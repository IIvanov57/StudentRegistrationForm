import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;


public class StudentRegistrationFormTests {

  RegistrationPage registrationPage = new RegistrationPage();

  @BeforeAll
  static void beforeALL() {
    Configuration.pageLoadStrategy = "eager";
    Configuration.browserSize = "1024x768";

  }

  @Test
  void successfulFillRegistrationFormTest() {
    registrationPage.openPage("automation-practice-form")
            .setFirstName("ivan")
            .setLastName("ivanov")
            .setEmail("test@test.ru")
            .setGender("Male")
            .setPhone("8005001234")
            .setDateOfBirth("August", "1992")
            .setSubjects("English")
            .setHobbits()
            .setPicture("Picture.jpg")
            .setAddress("current address")
            .setStateAndCity()
            .submit();


    //check filed form

    /*$x("//td[contains(text(),'Student Name')]/../td[2]").shouldHave(text("ivan ivanov"));
    $x("//td[contains(text(),'Student Email')]/../td[2]").shouldHave(text("test@test.ru"));
    $x("//td[contains(text(),'Gender')]/../td[2]").shouldHave(text("Male"));
    $x("//td[contains(text(),'Mobile')]/../td[2]").shouldHave(text("8005001234"));
    $x("//td[contains(text(),'Date of Birth')]/../td[2]").shouldHave(text("08 August,1992"));
    $x("//td[contains(text(),'Subjects')]/../td[2]").shouldHave(text("English"));
    $x("//td[contains(text(),'Hobbies')]/../td[2]").shouldHave(text("Music"));
    $x("//td[contains(text(),'Picture')]/../td[2]").shouldHave(text("Picture.jpg"));
    $x("//td[contains(text(),'Address')]/../td[2]").shouldHave(text("current address"));
    $x("//td[contains(text(),'State and City')]/../td[2]").shouldHave(text("NCR Delhi"));
    */

    registrationPage.checkResult("Student Name","ivan ivanov")
            .checkResult("Student Email","test@test.ru")
            .checkResult("Gender","Male")
            .checkResult("Mobile","8005001234")
            .checkResult("Date of Birth","08 August,1992")
            .checkResult("Subjects","English")
            .checkResult("Hobbies","Music")
            .checkResult("Picture","Picture.jpg")
            .checkResult("Address","current address")
            .checkResult("State and City","NCR Delhi");
  }

  @Test
  void minFillRegistrationFormTest() {
    registrationPage.openPage("automation-practice-form")
            .setFirstName("ivan")
            .setLastName("ivanov")
            .setGender("Male")
            .setPhone("8005001234")
            .submit();

    registrationPage.isAvailableResult();

  }
  @Test
  void negativeRegistrationFormTest() {
    registrationPage.openPage("automation-practice-form")
            .setFirstName("ivan")
            .setLastName("ivanov")
            .setGender("Male")
            .submit();

    registrationPage.isNotAvailableResult();

  }
}
