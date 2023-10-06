package Tests.VipAddNewUser;


import Tests.SettingsForTests;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utils.ConfProperties;

import static org.testng.Assert.assertEquals;
import static utils.ActualURLReturnHelper.ActualURL;

public class VipAddNewUserTest extends SettingsForTests {
  /**
   * Первоначальная настройка
   */
  @BeforeMethod
  public void BeforeStart() {
    driver.get(ConfProperties.getProperty("AuthPage"));
  }

  @Test
  public void Start() {

    authPage
            // Вводим E-mail, пароль в инпуты
            .RandomAuth()
            // Нажимаем кнопку "Войти"
            .ClickOnAuthButton();

    vipPersonalCabPage
            // Проверяем, есть ли инф. сообщение и удаляем его, если есть
            .CheckAndDeleteAlertCompanyMessage()
            // Переходим на страницу настроек компании
            .ClickOnOptionsOfCompanyLink();

    vipSettingsOfCompany
            // Кликаем на ссылку "Пользователи"
            .clickOnVipUsersLink();

    vipSettingsUserList
            // Нажимаем на кнопку "Добавить пользователя"
            .clickOnVipUsersAdd();

    vipSettingsUserAdd
            // Выбираем подразделение
            .VipSubdivisionChoose()
            // Выбор грузополучателя
            .VipConsigneeChoose()
            // Выбираем рандомную роль
            .VipRoleChoose()
            // Заполнение данными полей о сотруднике
            .VipDataInput()
            //Генерируем пароль и емеил, заполняем поля, сохраняем данные в переменные
            .VipPwdAndEmailInput()
            // Сохраняем пользователя
            .VipClickOnSaveButton();


    headerElementOfPage
            // Разлогин
            .ClickOnLogoutButton()
            // Открытие страницы авторизации
            .ClickOnLoginButton();

    authPage
            // Заполнение полей данными ранее добавленного пользователя
            .AuthBySaveData()
            // Нажимаем кнопку "Войти"
            .ClickOnAuthButton();

    vipPersonalCabPage
            // Проверяем, есть ли инф. сообщение и удаляем его, если есть
            .CheckAndDeleteAlertCompanyMessage();

    //Проверяем URL ЛК (корректная авторизация)
    assertEquals(ActualURL(), vipPersonalCabPageURL);
  }
}