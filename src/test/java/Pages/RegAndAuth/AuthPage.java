package Pages.RegAndAuth;

import BaseSteps.BaseSteps;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static utils.NumericHelper.getRandomInt;
import static utils.ReadFileLineHelper.ReadFileLineByLineWithSplit;
import static utils.SaveDataHelper.*;

public class AuthPage extends BaseSteps {
  public AuthPage(WebDriver driver) {
    super(driver);
  }

  @FindBy(xpath = "//input[@placeholder='E-mail']")
  private WebElement inputAuthEmail;
  @FindBy(xpath = "//input[@placeholder='Пароль']")
  private WebElement inputAuthPwd;
  @FindBy(xpath = "//button[@class='button button--size-m button--primary button--full-width gtm-login-main']")
  private WebElement authButton;
  @FindBy(xpath = "//div[@class='v-form-row v-form-row--indent-l']")
  private WebElement captchaAuth;


  public void RandomAuth() {
      System.out.println(ReadFileLineByLineWithSplit(PATHVIPAUTHOL));
      int randomCounter = getRandomInt(ReadFileLineByLineWithSplit(PATHVIPAUTHOL).size());
      int i = 0;
      String randomEmail = null;
      for (String key : ReadFileLineByLineWithSplit(PATHVIPAUTHOL).keySet()) {
        if (i == randomCounter) {
          randomEmail = key;
          break;
        }
        i++;
      }
      String randomPwd = ReadFileLineByLineWithSplit(PATHVIPAUTHOL).get(randomEmail);
      inputText(randomEmail, inputAuthEmail);
      inputText(randomPwd, inputAuthPwd);
      System.out.println(randomEmail + " " + randomPwd);

  }
  public void AuthBySaveData() {
    inputText(EmailTempVariableGetter(), inputAuthEmail);
    inputText(PwdTempVariableGetter(), inputAuthPwd);
  }
  public void ClickOnAuthButton() {
    clickOnButton(authButton);
  }
}