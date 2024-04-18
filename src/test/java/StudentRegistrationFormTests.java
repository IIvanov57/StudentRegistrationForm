import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import com.codeborne.selenide.*;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;


public class StudentRegistrationFormTests {


  @BeforeAll
  static void beforeALL() {
    Configuration.baseUrl = "https://demoqa.com/";
    Configuration.pageLoadStrategy = "eager";
    Configuration.browserSize="1024x768";
   // Configuration.browserPosition="10*10";
    //WebDriverRunner.getWebDriver().manage().window().maximize();

  }

  @Test
  void successfulFillRegistrationFormTest() throws InterruptedException {
    open("automation-practice-form");
    switchTo().window(0);
    //WebDriverRunner.getWebDriver().manage().window().maximize();
    $("#firstName").setValue("testName").click();
    $("#lastName").setValue("testLastName").click();
    $("#userEmail").setValue("test@test.ru").click();
    $(".custom-radio:nth-child(1) > .custom-control-label").click();//пофиксить
    $("#userNumber").setValue("88005005555").click();

    //dateOfBirthInput
    $("#dateOfBirthInput").click();

    $(".react-datepicker__month-select").click();
    $(".react-datepicker__month-select").selectOption("August");

    //class="react-datepicker__year-select"
    $(".react-datepicker__year-select").click();
    $(".react-datepicker__year-select").selectOption("1992");
    // int i = 2;
    //react-datepicker__day
    $(".react-datepicker__day--008").click();
  //$("[aria-label='Choose Sunday, August 8th, 1992']").click();

    //react-datepicker__week




    $(".subjects-auto-complete__value-container").scrollIntoView(true);
    //$(".subjects-auto-complete__value-container").press("e");
    //int i = 2;

    //$(".subjects-auto-complete__input").click();
    $("#subjectsInput").click();
    $("#subjectsInput").setValue("English").pressEnter();
    Thread.sleep(1000);
    //$("#subjectsInput").selectOptionByValue("English");
    $("#hobbies-checkbox-3").click();


    int i = 2;
    $(".subjects-auto-complete__value-container.subjects-auto-complete__input").sendKeys("e");
            //.selectOptionByValue("English");

    //$(".subjects-auto-complete__value-container").sendKeys("E");
    //$(".subjects-auto-complete__value-container").press("E")
    //        .selectOptionByValue("English");
    //int i = 2;
    $("#currentAddress").scrollIntoView(false).setValue("current address").pressEnter();
    //$("#currentAddress").setValue("current address").click();

    // i = 2;

  }
}
