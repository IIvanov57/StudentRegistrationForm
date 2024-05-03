import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

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


    registrationPage.checkResult("Student Name", "ivan ivanov")
            .checkResult("Student Email", "test@test.ru")
            .checkResult("Gender", "Male")
            .checkResult("Mobile", "8005001234")
            .checkResult("Date of Birth", "08 August,1992")
            .checkResult("Subjects", "English")
            .checkResult("Hobbies", "Music")
            .checkResult("Picture", "Picture.jpg")
            .checkResult("Address", "current address")
            .checkResult("State and City", "NCR Delhi");
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
