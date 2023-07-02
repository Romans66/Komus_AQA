package DriverCreator;

import Const.Const;
import Const.TechnicalConst;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utils.ConfProperties;
import java.util.concurrent.TimeUnit;

public class DriverCreator implements TechnicalConst, Const {
  // Инициализация и настройки драйвера
  public WebDriver driver = new ChromeDriver();
   public static WebDriver DriverCreator () {
     WebDriver driver = new ChromeDriver();
     //определение пути до драйвера и его настройка
     System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromedriver"));
     //определение пути до драйвера и его настройка
     driver.manage().window().maximize();
     // Неявное ожидание (глобальное) вызывается при каждом поиске элемента
     driver.manage().timeouts().implicitlyWait(WAITTIME, TimeUnit.SECONDS);
     return driver;
  }
}
