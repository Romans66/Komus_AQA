package Tests.Reg;

import Tests.SettingsForTests;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utils.ConfProperties;

public class RegistrationTest extends SettingsForTests {

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
      //Рандомно проставляем чекбокс подписки на рассылку
      regPage.chooseMailingBox();
      //Нажимаем на кнопку "Регистрация"
      regPage.ClickOnRegButton();
    }
}

