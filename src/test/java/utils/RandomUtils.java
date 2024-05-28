package utils;

import com.github.javafaker.Faker;

import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.concurrent.ThreadLocalRandom;

public class RandomUtils {
  private static final String[] HOBBITS = {"Sports", "Reading", "Music"};
  private static final String[] GENDERS = {"Male", "Female", "Other"};
  private static final String[] SUBJECTS = {"Maths", "English", "Arts", "History"};
  private static final String[] STATES = {"NCR", "Uttar Pradesh", "Haryana", "Rajasthan"};

  private static final String[] CITY_NCR = {"Delhi", "Gurgaon", "Noida"};
  private static final String[] CITY_UTTAR_PRADESH = {"Agra", "Lucknow", "Merrut"};
  private static final String[] CITY_HARYANA = {"Karnal", "Panipat"};
  private static final String[] CITY_RAJASTHAN = {"Jaipur", "Jaiselmer"};


  public static String getRandomMonth() {
    SimpleDateFormat sdf = new SimpleDateFormat("LLLL", Locale.UK);
    return sdf.format(new Faker().date().birthday());
  }

  public static String getRandomYear() {
    return String.valueOf(new Faker().number().numberBetween(1900, 2024));
  }

  public static String getRandomFirstName() {
    return new Faker(new Locale("en-US")).name().firstName();
  }

  public static String getRandomLastName() {
    return new Faker(new Locale("en-US")).name().lastName();
  }

  public static String getRandomEmailAddress() {
    return new Faker(new Locale("en-US")).internet().emailAddress();
  }

  public static String getRandomPhone() {
    return String.format("%s%s%s%s", getRandomInt(111, 999),
            getRandomInt(111, 999), getRandomInt(11, 99), getRandomInt(11, 99));
  }

  public static int getRandomInt(int min, int max) {
    return ThreadLocalRandom.current().nextInt(min, max + 1);
  }

  public static String getRandomGender() {
    return getRandomItemFromArray(GENDERS);
  }

  public static String getRandomItemFromArray(String[] array) {
    int index = getRandomInt(0, array.length - 1);

    return array[index];
  }

  public static String getRandomAddress() {
    return new Faker().address().fullAddress();
  }

  public static String getRandomHobbits() {
    return getRandomItemFromArray(HOBBITS);
  }

  public static String getRandomSubject() {
    return getRandomItemFromArray(SUBJECTS);
  }

  public static String getRandomState() {
    return getRandomItemFromArray(STATES);
  }

  public static String getRandomCity(String state) {

    return switch (state) {
      case "NCR" -> getRandomItemFromArray(CITY_NCR);
      case "Uttar Pradesh" -> getRandomItemFromArray(CITY_UTTAR_PRADESH);
      case "Haryana" -> getRandomItemFromArray(CITY_HARYANA);
      case "Rajasthan" -> getRandomItemFromArray(CITY_RAJASTHAN);
      default -> null;
    };
  }

  public static String getRandomDay(){
    return String.format("%s",new Faker().number().numberBetween(1,28));
  }


}
