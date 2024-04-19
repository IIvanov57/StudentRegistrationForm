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
    // Configuration.browserPosition="10*10";
    //WebDriverRunner.getWebDriver().manage().window().maximize();

  }

  @Test
  void successfulFillRegistrationFormTest() throws InterruptedException {
    open("automation-practice-form");
    switchTo().window(0);
    //field Name
    $("#firstName").setValue("ivan").click();
    $("#lastName").setValue("ivanov").click();
    $("#userEmail").setValue("test@test.ru").click();
    //checkbox Gender
    $(".custom-radio:nth-child(1) > .custom-control-label").click();//можно лучше наверное

    //field mobile
    $("#userNumber").setValue("88005005555").click();

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
    Thread.sleep(1000);

    //hobbies-checkbox
    $(".custom-checkbox:nth-child(3) > .custom-control-label").click();//можно лучше наверное

    //uploadPicture
    $("#uploadPicture").hover();
    Thread.sleep(3000);
    $("#uploadPicture").val("C:\\Users\\ivan.vl.ivanov\\Desktop\\Безымянный.jpg");

    //field Current Address
    $("#currentAddress").click();
    $("#currentAddress").setValue("current address").click();

    //State and City
    //State
    $(".css-1wa3eu0-placeholder").click();
    Thread.sleep(2000);
    $("#react-select-3-option-2").click();
    //City
    $("#stateCity-wrapper > div:nth-child(3)").click();
    $("#react-select-4-option-1").click();

    $("#submit").pressEnter();

    //check filed form
    $(".table-responsive").shouldHave(text("ivan ivanov"));
    $(".table-responsive").shouldHave(text("test@test.ru"));
    $(".table-responsive").shouldHave(text("Male"));
    $(".table-responsive").shouldHave(text("8800500555"));
    $(".table-responsive").shouldHave(text("08 August,1992"));
    $(".table-responsive").shouldHave(text("English"));
    $(".table-responsive").shouldHave(text("Music"));
    $(".table-responsive").shouldHave(text("current address"));
    $(".table-responsive").shouldHave(text("Haryana Panipat"));

  }
}
