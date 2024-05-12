package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.TableResponsiveComponent;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {
  CalendarComponent calendarComponent = new CalendarComponent();
  TableResponsiveComponent responsiveComponent = new TableResponsiveComponent();

  private final SelenideElement firstNameInput = $("#firstName"),
          lastNameInput = $("#lastName"),
          emailInput = $("#userEmail"),
          userNumberInput = $("#userNumber"),
          genderRadio = $("#genterWrapper"),
          calendarInput = $("#dateOfBirthInput"),
          subjectInput = $("#subjectsInput"),
          hobbitsCheckBox = $("#hobbiesWrapper"),
          uploadPictureInput = $("#uploadPicture"),
          addressInput = $("#currentAddress"),
          stateOption = $("#state"),
          cityOption = $("#city"),
          submitButton = $("#submit");

  public RegistrationPage openPage(String path) {
    open("https://demoqa.com/" + path);
    executeJavaScript("$('footer').remove();");
    executeJavaScript("$('#fixedban').remove();");
    return this;
  }

  public RegistrationPage setFirstName(String firstName) {
    firstNameInput.setValue(firstName).click();
    return this;
  }

  public RegistrationPage setLastName(String lastName) {
    lastNameInput.setValue(lastName).click();
    return this;
  }

  public RegistrationPage setEmail(String email) {
    emailInput.setValue(email).click();
    return this;
  }

  public RegistrationPage setGender(String gender) {
    genderRadio.$(byText(gender)).click();
    return this;
  }

  public RegistrationPage setPhone(String phone) {
    userNumberInput.setValue(phone).click();
    return this;
  }

  public RegistrationPage setDateOfBirth(String month, String year) {
    calendarInput.click();
    calendarComponent.setDate(month, year);

    return this;
  }

  public RegistrationPage setSubjects(String subjects) {
    subjectInput.click();
    subjectInput.setValue(subjects).pressEnter();

    return this;
  }

  public RegistrationPage setHobbits(String hobby) {
    hobbitsCheckBox.$(byText(hobby)).click();
    return this;
  }

  public RegistrationPage setPicture(String pictureName) {
    uploadPictureInput.uploadFromClasspath(pictureName);
    return this;
  }

  public RegistrationPage setAddress(String address) {
    addressInput.click();
    addressInput.setValue(address).click();
    return this;
  }

  public RegistrationPage setStateAndCity(String state, String city) {

    stateOption.click();
    stateOption.$(byText(state)).click();
    cityOption.click();
    cityOption.$(byText(city)).click();

    return this;
  }

  public RegistrationPage submit() {
    submitButton.pressEnter();
    return this;
  }

  public RegistrationPage checkResult(String key, String value) {
    responsiveComponent.checkResultInTable(key, value);
    return this;
  }

  public RegistrationPage isAvailableResult() {
    responsiveComponent.isAvailableTableResult();
    return this;
  }

  public RegistrationPage isNotAvailableResult() {
    responsiveComponent.isNotAvailableTableResult();
    return this;
  }

}


