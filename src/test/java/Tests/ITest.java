package Tests;

import Const.PagesURLConst;
import DriverCreator.DriverCreator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public interface ITest extends PagesURLConst {
  //Создаем и инициализируем драйвер через класс "DriverCreator"
  WebDriver driver = DriverCreator.DriverCreator();

  @BeforeMethod
  void BeforeStart();

  @Test
  void Start();

  @AfterTest
  void AfterTest();
}


