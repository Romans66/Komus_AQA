package Tests.Feedback;

import Pages.FeedBack.FeedBackPage;
import Tests.SettingsForTests;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import utils.ConfProperties;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginTest extends SettingsForTests {
    public static FeedBackPage loginPage;


    /**
     * осуществление первоначальной настройки
     */
    @BeforeMethod
    public void BeforeStart() {
        //Создание экземпляра класса страниц автотеста и передача в него драйвера, передаем страницу для браузера
        loginPage = new FeedBackPage(driver);
        driver.get(ConfProperties.getProperty("X"));
    }

    @Test
    public void Start() {
        //нажимаем Да в регионе
        loginPage.acceptRegion();
        //выбираем радиобаттон
        loginPage.chooseCountOfBox();
        //проверка на быюор радиобаттона
        assertTrue(loginPage.isClickRadioButton());
        //вводим количество коробок
        loginPage.inputQuantity();
        //вводим ФИО
        loginPage.inputName();
        //вводим почту
        loginPage.inputEmail();
        //вводим телефон
        loginPage.inputPhone();
        //вводим текст
        loginPage.inputWriteText();
        //выбираем чекбокс
        loginPage.clickCheckBox();
        //загружаем файл
        loginPage.uploadFile();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        assertTrue(loginPage.isElementPresent(By.xpath("//*[@id=\"form\"]/div/div[5]/div[1]/input[1]")));
        loginPage.sendForm();
        assertTrue(loginPage.isElementPresent(By.xpath("//*[@id=\"globalMessages\"]/div/div[1]")));

    }
}