package pages.components;

import com.codeborne.selenide.SelenideElement;
import pages.RegistrationPage;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class TableResponsiveComponent {
  private final SelenideElement tableElement = $(".table-responsive"),
          modelContentElement = $(".modal-content");

  public void checkResultInTable(String key, String value) {
    tableElement.$(byText(key)).parent()
            .shouldHave(text(value));
  }

  public void isAvailableTableResult() {
    modelContentElement.shouldBe(visible);
  }

  public void isNotAvailableTableResult() {
    modelContentElement.shouldBe(hidden);
  }
}
