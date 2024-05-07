package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import static utils.RandomUtils.*;

public class StudentRegistrationFormTests {

  RegistrationPage registrationPage = new RegistrationPage();

  String firstName,
          lastName,
          email,
          phone,
          gender,
          address,
          hobby,
          month,
          year;

  @BeforeAll
  static void beforeALL() {
    Configuration.pageLoadStrategy = "eager";
    Configuration.browserSize = "1024x768";

  }

  @BeforeEach
  void generateTestDate() {
    firstName = getRandomFirstName();
    lastName = getRandomLastName();
    email = getRandomEmailAddress();
    phone = getRandomPhone();
    gender = getRandomGender();
    address = getRandomAddress();
    hobby = getRandomHobbits();
    month = getRandomMonth();
    year = getRandomYear();
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
            .setSubjects("English")
            .setHobbits(hobby)
            .setPicture("Picture.jpg")
            .setAddress(address)
            .setStateAndCity()
            .submit();


    registrationPage.checkResult("Student Name", firstName + " " + lastName)
            .checkResult("Student Email", email)
            .checkResult("Gender", gender)
            .checkResult("Mobile", phone)
            .checkResult("Date of Birth", "08 " + month + "," + year)
            .checkResult("Subjects", "English")
            .checkResult("Hobbies", hobby)
            .checkResult("Picture", "Picture.jpg")
            .checkResult("Address", address)
            .checkResult("State and City", "NCR Delhi");
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
