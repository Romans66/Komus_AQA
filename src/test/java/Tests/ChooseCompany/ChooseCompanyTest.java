package Tests.ChooseCompany;


import Tests.SettingsForTests;
import org.testng.annotations.BeforeMethod;
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
  @BeforeMethod
  public void BeforeStart() {
    driver.get(ConfProperties.getProperty("RegPage"));
  }

  @Test
  public void Start() {

    regPage
            //Вводим ФИО, телефон, E-mail, Сгенерированный пароль
            .RegInput()
            //Проставляем чекбокс признака b2b
            .ChooseB2bBox()
            //Рандомно проставляем чекбокс подписки на рассылку
            .ChooseMailingBox()
            //Нажимаем на кнопку "Регистрация"
            .ClickOnRegButton();

    personalCabFirstCompanyAddPage
            //Нажимаем на кнопку "Да" в окне "Сотрудничает ли ваша организация с Комус?"
            .ClickOnCompanyYesButton();

    if (getRandomBoolean()) { //Выбираем рандомно способ добавления компании
      /**
       Ветка добавления компании через ИНН + КК
       */
      personalCabSecondCompanyAddPage
              //Вводим Рандомные ИНН и КК из заранее подготовленного файла
              .InputRandomInnAndKk()
              //Нажимаем кнопку "Добавить"
              .ClickOnAddCompanyButtonInnKk();
    } else {
      /**
       Ветка добавления компании через спецпароль
       */
      personalCabSecondCompanyAddPage
              //Жмем на ссылку "Я знаю спецпароль"
              .ClickOnSpecPwdLink();

      personalCabCompanySpecPwdAddPage
              //Вводим рандомный спецпароль из файла
              .InputRandomSpecPwd()
              //Нажимаем кнопку "Добавить"
              .ClickOnAddCompanyButtonSpecialPwd();
    }
    /**
     Общий блок после добавления компании
     */

    personalCabFinalCompanyAddPage
            //Нажимаем кнопку "Подключить" на странице подтверждения добавления компании
            .ClickOnFinalAddCompanyButton();

    // Проверка URL ЛК
    assertEquals(ActualURL(), personalCabPageURL);

    personalCabPage
            //Нажать на кнопки "Продолжить" и "Закрыть" в поп-апах онбординга
            .ClickOnPopupButtons();

    personalCabPage
            //Проверяем появившийся алерт и текст внутри
            .IsElementPresent();

    // Проверяем текст в алерте на наличие ключевых слов
    assertTrue(personalCabPage.AssertTextAllert().contains("Компания ") & personalCabPage.AssertTextAllert().contains(" успешно добавлена"));
  }
}