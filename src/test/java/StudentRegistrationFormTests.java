import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;


public class StudentRegistrationFormTests {


  @BeforeAll
  static void beforeALL() {
    Configuration.baseUrl = "https://demoqa.com/";
    Configuration.pageLoadStrategy = "eager";
    Configuration.browserSize = "1024x768";

  }

  @Test
  void successfulFillRegistrationFormTest() throws InterruptedException {
    open("automation-practice-form");
    executeJavaScript("$('footer').remove();");
    executeJavaScript("$('#fixedban').remove();");

    $("#firstName").setValue("ivan").click();
    $("#lastName").setValue("ivanov").click();
    $("#userEmail").setValue("test@test.ru").click();

    //checkbox Gender
    $("label[for=gender-radio-1]").click();

    //field mobile
    $("#userNumber").setValue("8005001234").click();

    //dateOfBirth
    $("#dateOfBirthInput").click();

    //month
    $(".react-datepicker__month-select").click();
    $(".react-datepicker__month-select").selectOption("August");

    //year
    $(".react-datepicker__year-select").click();
    $(".react-datepicker__year-select").selectOption("1992");

    //day
    $(".react-datepicker__day--008").click();

    //scroll page
    $(".subjects-auto-complete__value-container").scrollIntoView(true);


    //field subjects
    $("#subjectsInput").click();
    $("#subjectsInput").setValue("English").pressEnter();

    //hobbies-checkbox
    $("label[for=hobbies-checkbox-3]").click();

    //uploadPicture
    $("#uploadPicture").uploadFromClasspath("Picture.jpg");

    //field Current Address
    $("#currentAddress").click();
    $("#currentAddress").setValue("current address").click();

    //State and City
    //State
    $("#state input").setValue("NCR").pressEnter();
    //City
    $("#city input").setValue("Delhi").pressEnter();

    $("#submit").pressEnter();

    //check filed form

    $x("//td[contains(text(),'Student Name')]/../td[2]").shouldHave(text("ivan ivanov"));
    $x("//td[contains(text(),'Student Email')]/../td[2]").shouldHave(text("test@test.ru"));
    $x("//td[contains(text(),'Gender')]/../td[2]").shouldHave(text("Male"));
    $x("//td[contains(text(),'Mobile')]/../td[2]").shouldHave(text("8005001234"));
    $x("//td[contains(text(),'Date of Birth')]/../td[2]").shouldHave(text("08 August,1992"));
    $x("//td[contains(text(),'Subjects')]/../td[2]").shouldHave(text("English"));
    $x("//td[contains(text(),'Hobbies')]/../td[2]").shouldHave(text("Music"));
    $x("//td[contains(text(),'Picture')]/../td[2]").shouldHave(text("Picture.jpg"));
    $x("//td[contains(text(),'Address')]/../td[2]").shouldHave(text("current address"));
    $x("//td[contains(text(),'State and City')]/../td[2]").shouldHave(text("NCR Delhi"));


  }
}
