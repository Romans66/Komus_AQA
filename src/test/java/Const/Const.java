package Const;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.ConfProperties;

import java.time.Duration;
import java.util.Random;

import static Tests.SettingsForTests.driver;

public interface Const {
  // Общие константы
  public static WebDriver DRIVER = driver;
  public static Actions ACTIONS = new Actions(driver);
  public static WebDriverWait WAIT = new WebDriverWait(driver, Duration.ofMillis(Long.parseLong(ConfProperties.getProperty("login.page.time_out"))));
  public static JavascriptExecutor EXECUTOR = (JavascriptExecutor) DRIVER;
  public static Random random = new Random();
}
