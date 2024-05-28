package tests;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import static utils.RandomUtils.*;
@Tag("registration_form_tests")
public class StudentRegistrationFormTests extends TestBase {

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
          city = getRandomCity(state),
          pictureName = "Picture.jpg",
          day = getRandomDay();



  @Test
  void successfulFillRegistrationFormTest() {
    registrationPage.openPage("automation-practice-form")
            .setFirstName(firstName)
            .setLastName(lastName)
            .setEmail(email)
            .setGender(gender)
            .setPhone(phone)
            .setDateOfBirth(day,month, year)
            .setSubjects(subject)
            .setHobbits(hobby)
            .setPicture(pictureName)
            .setAddress(address)
            .setStateAndCity(state, city)
            .submit();


    registrationPage.checkResult("Student Name", firstName + " " + lastName)
            .checkResult("Student Email", email)
            .checkResult("Gender", gender)
            .checkResult("Mobile", phone)
            .checkResult("Date of Birth", day + " " + month + "," + year)
            .checkResult("Subjects", subject)
            .checkResult("Hobbies", hobby)
            .checkResult("Picture", pictureName)
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
