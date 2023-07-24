package utils;

import Const.Const;

import java.net.MalformedURLException;
import java.net.URL;

public class ActualURLReturnHelper implements Const {

  public static String ActualURL() {
    // Возвращает урл открытой страницы
    String actualURL = DRIVER.getCurrentUrl();
    URL url = null;
    try {
      //
      url = new URL(actualURL);
    } catch (MalformedURLException e) {
      e.printStackTrace();
    }
    String relativePath = url.getPath();
    return relativePath;
  }
}
