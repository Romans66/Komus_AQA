package Tests.ChooseCompany;


import Tests.SettingsForTests;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utils.ConfProperties;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static utils.ActualURLReturnHelper.ActualURL;
import static utils.BooleanHelper.getRandomBoolean;

public class ChooseCompanyTest extends SettingsForTests {
  /**
   * Первоначальная настройка
   */
  @BeforeTest
  public void BeforeStart() {
    driver.get(ConfProperties.getProperty("RegPage"));
  }

  @Test
  public void Start() {
    //Вводим ФИО, телефон, E-mail, Сгенерированный пароль
    regPage.RegInput();
    //Проставляем чекбокс признака b2b
    regPage.chooseB2bBox();
    //Рандомно проставляем чекбокс подписки на рассылку
    regPage.chooseMailingBox();
    //Нажимаем на кнопку "Регистрация"
    regPage.ClickOnRegButton();
    //Нажимаем на кнопку "Да" в окне "Сотрудничает ли ваша организация с Комус?"
    personalCabFirstCompanyAddPage.ClickOnCompanyYesButton();

    //Выбираем рандомно способ добавления компании
    if (getRandomBoolean()) {
      /**
       Ветка добавления компании через ИНН + КК
       */
      //Вводим Рандомные ИНН и КК из заранее подготовленного файла
      personalCabSecondCompanyAddPage.InputRandomInnAndKk();
      //Нажимаем кнопку "Добавить"
      personalCabSecondCompanyAddPage.ClickOnAddCompanyButtonInnKk();
    } else {
      /**
       Ветка добавления компании через спецпароль
       */
      //Жмем на ссылку "Я знаю спецпароль"
      personalCabSecondCompanyAddPage.ClickOnSpecPwdLink();
      //Вводим рандомный спецпароль из файла
      personalCabCompanySpecPwdAddPage.InputRandomSpecPwd();
      //Нажимаем кнопку "Добавить"
      personalCabCompanySpecPwdAddPage.ClickOnAddCompanyButtonSpecialPwd();
    }
    //Общий блок после добавления компании
    //Нажимаем кнопку "Подключить" на странице подтверждения добавления компании
    personalCabFinalCompanyAddPage.ClickOnFinalAddCompanyButton();
    //Нажать на кнопки "Продолжить" и "Закрыть" в поп-апах онбординга
    personalCabPage.ClickOnPopupButtons();
    // Проверяем URL ЛК
    assertEquals(ActualURL(),personalCabPageURL);
    //Проверяем появившийся алерт и текст внутри
    personalCabPage.IsElementPresent();
    assertTrue(personalCabPage.AssertTextAllert().contains("Компания ") & personalCabPage.AssertTextAllert().contains(" успешно добавлена"));
  }
}