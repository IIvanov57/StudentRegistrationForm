package pages.components;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$;

public class CalendarComponent {
  private final SelenideElement
          selectMonth = $(".react-datepicker__month-select"),
          selectYear = $(".react-datepicker__year-select"),
          selectEighthDay = $(".react-datepicker__day--008");

  public void setDate(String month, String year) {
    //month
    selectMonth.click();
    selectMonth.selectOption(month);
    //year
    selectYear.click();
    selectYear.selectOption(year);
    //day
    selectEighthDay.click();
  }
}
