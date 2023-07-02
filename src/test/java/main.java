import utils.ConfProperties;

import java.net.MalformedURLException;
import java.net.URL;

import static Const.Const.DRIVER;

public class main {
  public static void main (String args[]) throws MalformedURLException {
    DRIVER.get(ConfProperties.getProperty("RegPage"));

      String actualURL = DRIVER.getCurrentUrl();
    URL url = new URL(actualURL);
    String relativePath = url.getPath();
      System.out.println(actualURL);
  }
  }

