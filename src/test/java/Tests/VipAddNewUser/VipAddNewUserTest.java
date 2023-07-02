package Tests.VipAddNewUser;


import Tests.SettingsForTests;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utils.ConfProperties;

import static org.testng.Assert.assertEquals;
import static utils.ActualURLReturnHelper.ActualURL;

public class VipAddNewUserTest extends SettingsForTests {
  /**
   * Первоначальная настройка
   */
  @BeforeTest
  public void BeforeStart() {
    driver.get(ConfProperties.getProperty("AuthPage"));
  }

  @Test
  public void Start() {
    // Вводим E-mail, пароль в инпуты
    authPage.RandomAuth();
    // Нажимаем кнопку "Войти"
    authPage.ClickOnAuthButton();
    // Проверяем, есть ли инф. сообщение и удаляем его, если есть
    vipPersonalCabPage.CheckAndDeleteAlertCompanyMessage();
    // Переходим на страницу настроек компании
    vipPersonalCabPage.ClickOnOptionsOfCompanyLink();
    // Кликаем на ссылку "Пользователи"
    vipSettingsOfCompany.clickOnVipUsersLink();
    // Нажимаем на кнопку "Добавить пользователя"
    vipSettingsUserList.clickOnVipUsersAdd();
    // Выбираем подразделение
    vipSettingsUserAdd.VipSubdivisionChoose();
    // Выбор грузополучателя
    vipSettingsUserAdd.VipConsigneeChoose();
    // Выбираем рандомную роль
    vipSettingsUserAdd.VipRoleChoose();
    // Заполнение данными полей о сотруднике
    vipSettingsUserAdd.VipDataInput();
    //Генерируем пароль и емеил, заполняем поля, сохраняем данные в переменные
    vipSettingsUserAdd.VipPwdAndEmailInput();
    // Сохраняем пользователя
    vipSettingsUserAdd.VipClickOnSaveButton();
    // Разлогин
    headerElementOfPage.ClickOnLogoutButton();
    // Открытие страницы авторизации
    headerElementOfPage.ClickOnLoginButton();
    // Заплднение полей данными ранее добавленного пользователя
    authPage.AuthBySaveData();
    // Нажимаем кнопку "Войти"
    authPage.ClickOnAuthButton();
    // Проверяем, есть ли инф. сообщение и удаляем его, если есть
    vipPersonalCabPage.CheckAndDeleteAlertCompanyMessage();
    //Проверяем URL ЛК (корректная авторизация)
    assertEquals(ActualURL(), vipPersonalCabPageURL);
  }
}