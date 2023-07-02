package Tests;

import Const.Const;
import Const.TechnicalConst;
import DriverCreator.DriverCreator;
import Pages.CommonElements.HeaderElementOfPage;
import Pages.PersonalCab.*;
import Pages.PersonalCabVip.VipPersonalCabPage;
import Pages.PersonalCabVip.VipSettingsOfCompany;
import Pages.PersonalCabVip.VipSettingsUserAdd;
import Pages.PersonalCabVip.VipSettingsUserList;
import Pages.RegAndAuth.AuthPage;
import Pages.RegAndAuth.RegPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;

public abstract class SettingsForTests implements ITest, TechnicalConst, Const {
  //Создаем и инициализируем драйвер через класс "DriverCreator"
  public static WebDriver driver = DriverCreator.DriverCreator();
  // Экземпляры общих элементов страниц
  public static HeaderElementOfPage headerElementOfPage = new HeaderElementOfPage(driver);
  //Экземпляры страниц для тестов
  public static RegPage regPage = new RegPage(driver);
  public static AuthPage authPage = new AuthPage(driver);
  public static PersonalCabPage personalCabPage = new PersonalCabPage(driver);
  public static PersonalCabFirstCompanyAddPage personalCabFirstCompanyAddPage = new PersonalCabFirstCompanyAddPage(driver);
  public static PersonalCabSecondCompanyAddPage personalCabSecondCompanyAddPage = new PersonalCabSecondCompanyAddPage(driver);
  public static PersonalCabFinalCompanyAddPage personalCabFinalCompanyAddPage = new PersonalCabFinalCompanyAddPage(driver);
  public static PersonalCabCompanySpecPwdAddPage personalCabCompanySpecPwdAddPage = new PersonalCabCompanySpecPwdAddPage(driver);

  //Экземпляры классов страниц VIP
  public static VipPersonalCabPage vipPersonalCabPage = new VipPersonalCabPage(driver);
  public static VipSettingsOfCompany vipSettingsOfCompany = new VipSettingsOfCompany(driver);
  public static VipSettingsUserList vipSettingsUserList = new VipSettingsUserList(driver);
  public static VipSettingsUserAdd vipSettingsUserAdd = new VipSettingsUserAdd(driver);

  @AfterTest
  public void AfterTest() throws InterruptedException {
    Thread.sleep(MILLISFORQUIT);
    driver.close();
  }
}