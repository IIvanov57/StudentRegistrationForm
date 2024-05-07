package utils;

import com.github.javafaker.Faker;

import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.concurrent.ThreadLocalRandom;

public class RandomUtils {

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
    String[] genders = {"Male", "Female", "Other"};

    return getRandomItemFromArray(genders);
  }

  public static String getRandomItemFromArray(String[] array) {
    int index = getRandomInt(0, array.length - 1);

    return array[index];
  }

  public static String getRandomAddress() {
    return new Faker().address().fullAddress();
  }

  public static String getRandomHobbits() {

    String[] hobbits = {"Sports", "Reading", "Music"};

    return getRandomItemFromArray(hobbits);
  }


}
