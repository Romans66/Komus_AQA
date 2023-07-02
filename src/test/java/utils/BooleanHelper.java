package utils;

import java.util.Random;

public class BooleanHelper {
  private static final Random random = new Random();

  public static boolean getRandomBoolean(){

    return random.nextBoolean();
  }

}

