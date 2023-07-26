package Tests.Reg;

import Tests.SettingsForTests;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utils.ConfProperties;

public class RegistrationTest extends SettingsForTests {

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
              //Рандомно проставляем чекбокс подписки на рассылку
              .ChooseMailingBox()
              //Нажимаем на кнопку "Регистрация"
              .ClickOnRegButton();
    }
}

