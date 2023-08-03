package DriverCreator;

import Const.Const;
import Const.TechnicalConst;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class DriverCreator implements TechnicalConst, Const {
  // Инициализация и настройки драйвера
  /*public WebDriver driver = new ChromeDriver();*/
  public static WebDriver DriverCreator() {
    // Инициализация WebDriverManager для Chrome
    WebDriverManager.chromedriver().setup();
    // Создание экземпляра ChromeDriver
    WebDriver driver = new ChromeDriver();
    //определение пути до драйвера и его настройка
    driver.manage().window().maximize();
    // Неявное ожидание (глобальное) вызывается при каждом поиске элемента
    driver.manage().timeouts().implicitlyWait(WAITTIME, TimeUnit.SECONDS);
    return driver;
  }
  /*  "Ручная инициализация"
   //определение пути до драйвера и его настройка
     System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromedriver"));
     */
}
