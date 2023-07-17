package Pages.RegAndAuth;

import BaseSteps.BaseSteps;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import utils.PassGeneratorHelper;
import utils.StringHelper;

import static utils.BooleanHelper.getRandomBoolean;

public class RegPage extends BaseSteps {
  public RegPage(WebDriver driver) {
    super(driver);
  }
  @FindBy(xpath = "//input[@placeholder='Имя']")
  private WebElement inputRegName;
  @FindBy(xpath = "//input[@name='phone']")
  private WebElement inputRegPhone;
  @FindBy(xpath = "//input[@placeholder='E-mail']")
  private WebElement inputRegEmail;
  @FindBy(xpath = "//input[@placeholder='Пароль']")
  private WebElement inputRegPwd;
  @FindBy(xpath = "//span[@class='gtm-register-main-individual-user']//i[1]")
  private WebElement checkBoxB2b;
  @FindBy(xpath = "//span[@class='gtm-register-main-subscribe-mailing']//i[1]")
  private WebElement checkBoxMailing;
  @FindBy(xpath = "//button[@class='button button--size-m button--primary button--full-width gtm-register-main']")
  private WebElement regButton;
  @FindBy(xpath = "//div[@class='v-form-row v-captcha__container v-form-row--indent-l']")
  private WebElement captchaReg;

  public void RegInput() {
    // Проверяем наличие капчи
    if (PresentElement(captchaReg)) {
      //Если есть - тест падает с сообщением в стектрейсе
      Assert.fail("Captcha is enable!!! Please, turn off captcha switcher");
    } else {
      //Если нет - заполняем данные и жмем кнопку "Регистрация"
      inputText(StringHelper.getRandomRussianString(RANDOMSIZEOFSTRING), inputRegName);
      inputText(StringHelper.getPhoneNumber(), inputRegPhone);
      inputText(StringHelper.getMail(), inputRegEmail);
      inputText(PassGeneratorHelper.generatePassword(), inputRegPwd);
    }
  }

  public void chooseB2bBox() {
      moveAndClick(checkBoxB2b);
    }
  public void chooseMailingBox() {
      if (getRandomBoolean()) {
        moveAndClick(checkBoxMailing);
      }
    }
  public void ClickOnRegButton() {
      try {
        clickOnButton(regButton);
      } catch (NoSuchElementException e) {
        e.printStackTrace();
      }
    }
  }

