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
import org.testng.annotations.AfterTest;

public abstract class SettingsForTests implements ITest, TechnicalConst, Const {

  // Экземпляры общих элементов страниц
  protected static HeaderElementOfPage headerElementOfPage = new HeaderElementOfPage(driver);
  //Экземпляры страниц для тестов
  protected static RegPage regPage = new RegPage(driver);
  protected static AuthPage authPage = new AuthPage(driver);
  protected static PersonalCabPage personalCabPage = new PersonalCabPage(driver);
  protected static PersonalCabFirstCompanyAddPage personalCabFirstCompanyAddPage = new PersonalCabFirstCompanyAddPage(driver);
  protected static PersonalCabSecondCompanyAddPage personalCabSecondCompanyAddPage = new PersonalCabSecondCompanyAddPage(driver);
  protected static PersonalCabFinalCompanyAddPage personalCabFinalCompanyAddPage = new PersonalCabFinalCompanyAddPage(driver);
  protected static PersonalCabCompanySpecPwdAddPage personalCabCompanySpecPwdAddPage = new PersonalCabCompanySpecPwdAddPage(driver);

  //Экземпляры классов страниц VIP
  protected static VipPersonalCabPage vipPersonalCabPage = new VipPersonalCabPage(driver);
  protected static VipSettingsOfCompany vipSettingsOfCompany = new VipSettingsOfCompany(driver);
  protected static VipSettingsUserList vipSettingsUserList = new VipSettingsUserList(driver);
  protected static VipSettingsUserAdd vipSettingsUserAdd = new VipSettingsUserAdd(driver);

  @AfterTest
  public void AfterTest() {
    try {
      Thread.sleep(MILLISFORQUIT);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
    driver.close();
  }
}