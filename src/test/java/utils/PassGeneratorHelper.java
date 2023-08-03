package utils;

import java.util.Random;

public class PassGeneratorHelper {
  private static final Random RANDOM = new Random();

  public static String generatePassword() {
    // Используем символы в высоком, низком регистре, а также цифры
    String capitalLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    String lowerLetters = "abcdefghijklmnopqrstuvwxyz";
    String numbers = "0123456789";
    String allCharacters = capitalLetters + lowerLetters + numbers;

    // Создаем генератор случайных чисел


    // Создаем пустую строку, которая будет нашим паролем
    String password = "";

    // Добавляем случайную большую букву
    password += capitalLetters.charAt(RANDOM.nextInt(capitalLetters.length()));

    // Добавляем случайную маленькую букву
    password += lowerLetters.charAt(RANDOM.nextInt(lowerLetters.length()));

    // Добавляем случайную цифру
    password += numbers.charAt(RANDOM.nextInt(numbers.length()));

    // Добавляем оставшиеся символы
    for (int i = 0; i < 5; i++) {
      password += allCharacters.charAt(RANDOM.nextInt(allCharacters.length()));
    }

    return password;
  }
}
