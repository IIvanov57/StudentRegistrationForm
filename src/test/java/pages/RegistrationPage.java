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

  @Step("Открытие главной страницы с формой")
  public RegistrationPage openPage(String path) {
    open("https://demoqa.com/" + path);
    executeJavaScript("$('footer').remove();");
    executeJavaScript("$('#fixedban').remove();");
    return this;
  }

  @Step("Ввод имени пользователя")
  public RegistrationPage setFirstName(String firstName) {
    firstNameInput.setValue(firstName).click();
    return this;
  }
  @Step("Ввод фамилии пользователя")
  public RegistrationPage setLastName(String lastName) {
    lastNameInput.setValue(lastName).click();
    return this;
  }

  @Step("Ввод почты пользователя")
  public RegistrationPage setEmail(String email) {
    emailInput.setValue(email).click();
    return this;
  }

  @Step("Выбор пола пользователя")
  public RegistrationPage setGender(String gender) {
    genderRadio.$(byText(gender)).click();
    return this;
  }

  @Step("Ввод телефона для пользователя")
  public RegistrationPage setPhone(String phone) {
    userNumberInput.setValue(phone).click();
    return this;
  }

  @Step("Заполнение поля дня рождения пользователя")
  public RegistrationPage setDateOfBirth(String day, String month, String year) {
    calendarInput.click();
    calendarComponent.setDate(day,month, year);

    return this;
  }

  @Step("Заполнение поля subjects")
  public RegistrationPage setSubjects(String subjects) {
    subjectInput.click();
    subjectInput.setValue(subjects).pressEnter();

    return this;
  }
  @Step("Выбор хобби пользователя")
  public RegistrationPage setHobbits(String hobby) {
    hobbitsCheckBox.$(byText(hobby)).click();
    return this;
  }

  @Step("Загрузка аватарки")
  public RegistrationPage setPicture(String pictureName) {
    uploadPictureInput.uploadFromClasspath(pictureName);
    return this;
  }

  @Step("Заполнения адреса проживания")
  public RegistrationPage setAddress(String address) {
    addressInput.click();
    addressInput.setValue(address).click();
    return this;
  }

  @Step("Выбор штата и города проживания")
  public RegistrationPage setStateAndCity(String state, String city) {

    stateOption.click();
    stateOption.$(byText(state)).click();
    cityOption.click();
    cityOption.$(byText(city)).click();

    return this;
  }
  @Step("Подтверждения заполнения формы")
  public RegistrationPage submit() {
    submitButton.pressEnter();
    return this;
  }

  @Step("Проверка правильности ввода данных")
  public RegistrationPage checkResult(String key, String value) {
    responsiveComponent.checkResultInTable(key, value);
    return this;
  }

  @Step("Проверка доступности таблицы с результатами")
  public RegistrationPage isAvailableResult() {
    responsiveComponent.isAvailableTableResult();
    return this;
  }

  @Step("Проверка что таблица с результатом НЕ доступна")
  public RegistrationPage isNotAvailableResult() {
    responsiveComponent.isNotAvailableTableResult();
    return this;
  }

}


