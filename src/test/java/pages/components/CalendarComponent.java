package pages.components;

import com.codeborne.selenide.SelenideElement;

import java.util.Locale;

import static com.codeborne.selenide.Selenide.$;

public class CalendarComponent {
  private final SelenideElement
          selectMonth = $(".react-datepicker__month-select"),
          selectYear = $(".react-datepicker__year-select"),
          selectEighthDay = $(".react-datepicker__day--008");

  public void setDate(String month, String year) {
    selectMonth.click();
    selectMonth.selectOption(month);
    selectYear.click();
    selectYear.selectOption(year);
    selectEighthDay.click();
  }
}
