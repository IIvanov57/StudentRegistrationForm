package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
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

  @Step("open page")
  public RegistrationPage openPage(String path) {
    open("https://demoqa.com/" + path);
    executeJavaScript("$('footer').remove();");
    executeJavaScript("$('#fixedban').remove();");
    return this;
  }

  @Step("input firstname")
  public RegistrationPage setFirstName(String firstName) {
    firstNameInput.setValue(firstName).click();
    return this;
  }
  @Step("input lastname")
  public RegistrationPage setLastName(String lastName) {
    lastNameInput.setValue(lastName).click();
    return this;
  }

  @Step("input email")
  public RegistrationPage setEmail(String email) {
    emailInput.setValue(email).click();
    return this;
  }

  @Step("selecting gender")
  public RegistrationPage setGender(String gender) {
    genderRadio.$(byText(gender)).click();
    return this;
  }

  @Step("input phone")
  public RegistrationPage setPhone(String phone) {
    userNumberInput.setValue(phone).click();
    return this;
  }

  @Step("selecting date of birth")
  public RegistrationPage setDateOfBirth(String month, String year) {
    calendarInput.click();
    calendarComponent.setDate(month, year);

    return this;
  }

  @Step("input subject")
  public RegistrationPage setSubjects(String subjects) {
    subjectInput.click();
    subjectInput.setValue(subjects).pressEnter();

    return this;
  }
  @Step("selecting hobbits")
  public RegistrationPage setHobbits(String hobby) {
    hobbitsCheckBox.$(byText(hobby)).click();
    return this;
  }

  @Step("download picture")
  public RegistrationPage setPicture(String pictureName) {
    uploadPictureInput.uploadFromClasspath(pictureName);
    return this;
  }

  @Step("input address")
  public RegistrationPage setAddress(String address) {
    addressInput.click();
    addressInput.setValue(address).click();
    return this;
  }

  @Step("selecting state and city")
  public RegistrationPage setStateAndCity(String state, String city) {

    stateOption.click();
    stateOption.$(byText(state)).click();
    cityOption.click();
    cityOption.$(byText(city)).click();

    return this;
  }
  @Step("submit form")
  public RegistrationPage submit() {
    submitButton.pressEnter();
    return this;
  }

  @Step("validation value")
  public RegistrationPage checkResult(String key, String value) {
    responsiveComponent.checkResultInTable(key, value);
    return this;
  }

  @Step("check available result table")
  public RegistrationPage isAvailableResult() {
    responsiveComponent.isAvailableTableResult();
    return this;
  }

  @Step("check is not available result table")
  public RegistrationPage isNotAvailableResult() {
    responsiveComponent.isNotAvailableTableResult();
    return this;
  }

}


