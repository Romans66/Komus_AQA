package Pages.CommonElements;

import BaseSteps.BaseSteps;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HeaderElementOfPage extends BaseSteps {

  public HeaderElementOfPage(WebDriver driver) {
    super(driver);
  }

  @FindBy(xpath = "//div[@class='b-enterAccount']")
  private WebElement logoutButton;
  @FindBy(xpath = "//div[@class='login-account js-login-popup']")
  private WebElement loginButton;

  public HeaderElementOfPage ClickOnLogoutButton() {
    moveAndClick(logoutButton);
    return new HeaderElementOfPage(DRIVER);
  }
  public HeaderElementOfPage ClickOnLoginButton() {
    moveAndClick(loginButton);
    return new HeaderElementOfPage(DRIVER);
  }
}
